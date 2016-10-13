/**
 * Copyright (c) 2015-2017 Inria
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * - Christophe Gourdin <christophe.gourdin@inria.fr>
 */
package org.occiware.mart.server.servlet.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.occiware.clouddesigner.occi.Entity;
import org.occiware.mart.server.servlet.exception.ResponseParseException;
import org.occiware.mart.server.servlet.facade.AbstractGetQuery;
import org.occiware.mart.server.servlet.model.ConfigurationManager;
import org.occiware.mart.server.servlet.utils.CollectionFilter;
import org.occiware.mart.server.servlet.utils.Constants;
import org.occiware.mart.server.servlet.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cgourdin
 */
@Path("/")
public class GetQuery extends AbstractGetQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetQuery.class);

    @Path("{path:.*}/")
    @GET
    // @Consumes({Constants.MEDIA_TYPE_TEXT_OCCI, Constants.MEDIA_TYPE_TEXT_URI_LIST})
    // @Produces(Constants.MEDIA_TYPE_TEXT_OCCI)
    @Override
    public Response inputQuery(@PathParam("path") String path, @Context HttpHeaders headers, @Context HttpServletRequest request) {
        Response response;
        LOGGER.info("Call GET method in inputQuery() for path: " + path);
        response = super.inputQuery(path, headers, request);
        if (response != null) {
            // May have a malformed query.
            return response;
        }

        // Query interface check, the last case of this check is for query for ex: /compute/-/ where we filter for a category (kind or mixin).
        if (path.equals("-/") || path.equals(".well-known/org/ogf/occi/-/") || path.endsWith("/-/")) {
            // Delegate to query interface method.
            return getQueryInterface(path, headers);
        }

        Entity entity;
        String entityId;
        
        Map<String, String> attrs = inputParser.getOcciAttributes();
        // Get one entity check with uuid provided.
        // path with category/kind : http://localhost:8080/compute/uuid
        // custom location: http://localhost:8080/foo/bar/myvm/uuid
        boolean isEntityRequest = Utils.isEntityRequest(path, attrs);
        if (isEntityRequest && !getAcceptType().equals(Constants.MEDIA_TYPE_TEXT_URI_LIST)) {
            // Get uuid.
            if (Utils.isEntityUUIDProvided(path, attrs)) {
                entityId = Utils.getUUIDFromPath(path, attrs);
                entity = ConfigurationManager.findEntity(ConfigurationManager.DEFAULT_OWNER, entityId);
            } else {
                entity = ConfigurationManager.getEntityFromPath(path);
            }
            if (entity == null) {
                try {
                    response = outputParser.parseResponse("resource " + path + " not found", Response.Status.NOT_FOUND);
                    return response;
                } catch (ResponseParseException ex) {
                    throw new NotFoundException(ex);
                }
            } else {
                // Retrieve entity informations from provider.
                entity.occiRetrieve();
                // Entity is found, we must parse the result (on accept type media if defined in header of the query elsewhere this will be text/occi) to a response ok --> 200 object
                //   AND the good rendering output (text/occi, application/json etc.).
                try {
                    response = outputParser.parseResponse(entity);
                    return response;
                } catch (ResponseParseException ex) {
                    // This must never go here. If that's the case this is a bug in parser.
                    throw new InternalServerErrorException(ex);
                }

            }
        }

        // Case if entity request but accept type is text/uri-list => bad request.
        if (isEntityRequest && getAcceptType().equals(Constants.MEDIA_TYPE_TEXT_URI_LIST)) {
            // To be compliant with occi specification (text/rendering and all others), it must check if uri-list is used with entity request, if this is the case ==> badrequest.
            try {
                response = outputParser.parseResponse("you must not use the accept type " + Constants.MEDIA_TYPE_TEXT_URI_LIST + " in this way.", Response.Status.BAD_REQUEST);
            } catch (ResponseParseException ex) {
                // Must never happen if input query is ok.
                throw new InternalServerErrorException(ex);
            }
            return response;
        }
        
        // note: attrs must be empty if result is true.
          //  +++ the mixin tag has no attributes. mixin.getAttributes() must return empty list.
        boolean isMixinTagRequest = Utils.isMixinTagRequest(path, attrs, inputParser.getMixins(), inputParser.getMixinTagLocation());
        if (isMixinTagRequest) {
            // TODO :  Load mixin tag.
            
        // Return informations about the mixin tag.
            // Load the entities defined.
            // if (urilist media ==> list of location else list of entities to display.)
            
        }
        
        
        // Collections part.
        // Get pagination if any (current page number and number max of items, for the last if none defined, used to 20 items per page by default).
        String pageTmp = inputParser.getParameter(Constants.CURRENT_PAGE_KEY);
        String itemsNumber = inputParser.getParameter(Constants.NUMBER_ITEMS_PER_PAGE_KEY);
        int items = Constants.DEFAULT_NUMBER_ITEMS_PER_PAGE;
        int page = Constants.DEFAULT_CURRENT_PAGE;
        if (pageTmp != null && !pageTmp.isEmpty()) {
            // Set the value from request only if this is a number.
            try {
                items = Integer.valueOf(itemsNumber);
            } catch (NumberFormatException ex) {
                    // Cant parse the number
                    LOGGER.error("The parameter \"number\" is not set correctly, please check the parameter, this must be a number.");
                    LOGGER.error("Default to " + items);
                }
                try {
                    page = Integer.valueOf(pageTmp);
                } catch (NumberFormatException ex) {
                    LOGGER.error("The parameter \"page\" is not set correctly, please check the parameter, this must be a number.");
                    LOGGER.error("Default to " + page);
                }
        }
        String operatorTmp = inputParser.getParameter(Constants.OPERATOR_KEY);
        if (operatorTmp == null) {
                operatorTmp = "0";
        }
            int operator = 0;
        try {
                operator = Integer.valueOf(operatorTmp);
            } catch (NumberFormatException ex) {
            }
    
        // Get collections based on location and Accept = text/uri-list or give entities details for other accept types.
        // Examples of query for filtering and pagination: 
        // Filtering (attribute or category) :  http://localhost:9090/myquery?attribute=myattributename or http://localh...?category=mymixintag
        // Pagination : http://localhost:9090/myquery?attribute=myattributename&page=2&number=5 where page = current page, number : max number of items to display.
        // Operator (equal or like) : http://localhost:9090/myquery?attribute=myattributename&page=2&number=5&operator=like
        List<Entity> entities;
        // Collection on categories. // Like : get on myhost/compute/
        boolean isCollectionOnCategoryPath = Utils.isCollectionOnCategory(path, attrs);
        // Get the filter parameters and build a CollectionFilter object for each filter parameters defined.
        List<CollectionFilter> filters = new LinkedList<>();
        // Category filter check.
        String paramTmp = inputParser.getParameter("category");
        if (paramTmp != null && !paramTmp.isEmpty()) {
                CollectionFilter filter = new CollectionFilter();
                filter.setCategoryFilter(paramTmp);
                filter.setOperator(operator);
                filters.add(filter);
            }
            // Attribute filter check.
            paramTmp = inputParser.getParameter("attribute");
            if (paramTmp != null && !paramTmp.isEmpty()) {
                CollectionFilter filter = new CollectionFilter();
                filter.setAttributeFilter(paramTmp);
                filter.setOperator(operator);
                filters.add(filter);
            }
       
        if (isCollectionOnCategoryPath) {
            // Check category uri.
            String categoryId = Utils.getCategoryFilterSchemeTerm(path, ConfigurationManager.DEFAULT_OWNER);
            CollectionFilter filter = new CollectionFilter();
            filter.setOperator(operator);
            filter.setCategoryFilter(categoryId);
            filters.add(filter);
        } else {
            // Unknown collection type.
            CollectionFilter filter = new CollectionFilter();
            filter.setOperator(operator);
            filter.setFilterOnPath(path);
            filters.add(filter);
        }
        
        try {
            entities = ConfigurationManager.findAllEntities(ConfigurationManager.DEFAULT_OWNER, page, items, filters);

            if (getAcceptType().equals(Constants.MEDIA_TYPE_TEXT_URI_LIST)) {
                List<String> locations = new LinkedList<>();
                String location;
                for (Entity entityTmp : entities) {
                    location = ConfigurationManager.getLocation(entityTmp);
                    locations.add(location);
                }
                if (locations.isEmpty()) {
                    response = outputParser.parseResponse("resource " + path + " not found", Response.Status.NOT_FOUND);
                    return response;
                }
                response = outputParser.parseResponse(locations);
            } else {
                if (entities.isEmpty()) {
                    response = outputParser.parseResponse("resource " + path + " not found", Response.Status.NOT_FOUND);
                    return response;
                }
                List<Entity> entitiesInf = new LinkedList<>();
                // Update all the list of entities before setting response.
                for (Entity entityInf : entities) {
                    entityInf.occiRetrieve();
                    entitiesInf.add(entityInf);
                }
                response = outputParser.parseResponse(entitiesInf);
            }

        } catch (ResponseParseException ex) {
            // Must never happen if input query is ok.
            throw new InternalServerErrorException(ex);
        }

        return response;

    }

    /**
     *
     * @param path
     * @param entityId
     * @param headers
     * @param request, use only for json and file upload features (use
     * request.getReader() to retrieve json String).
     * @return
     */
    @Override
    public Response getEntity(String path, String entityId, @Context HttpHeaders headers, @Context HttpServletRequest request) {

        // Manage occi server version and other things before processing the query.
        Response response = super.getEntity(path, entityId, headers, request);
        // If something goes wrong, the response here is not null.
        if (response != null) {
            return response;
        }

        String pathMsg = "Path given : " + Constants.PATH_SEPARATOR + path + "\n "; // + PATH_SEPARATOR + pathB + PATH_SEPARATOR + id;
        response = Response.ok().
                entity(pathMsg).
                header("Server", Constants.OCCI_SERVER_HEADER).build();
        return response;
    }

//    @Override
//    @Path("collections/{kind}") // {a}/{b}/{id}
//    @GET
//    @Consumes({Constants.MEDIA_TYPE_TEXT_OCCI, Constants.MEDIA_TYPE_TEXT_URI_LIST})
//    @Produces(Constants.MEDIA_TYPE_TEXT_OCCI)
//    public Response getEntityCollection(@PathParam("kind") String kind, @Context HttpHeaders headers, @Context HttpServletRequest request) {
//        Response response;
//
//        String pathMsg = "Collections kind given : " + Constants.PATH_SEPARATOR + "collections/" + kind + "\n ";
//        response = Response.ok().
//                entity(pathMsg).
//                header("Server", Constants.OCCI_SERVER_HEADER).build();
//        return response;
//    }
//    @Override
//    @Path("{path}")
//    @GET
//    @Produces(Constants.MEDIA_TYPE_TEXT_URI_LIST)
//    public Response getEntityUriListing(@PathParam("path") String path, @Context HttpHeaders headers, @Context HttpServletRequest request) {
//
//        Response response = null;
//
//        // Manage /-/ relative path for listing the full query interface.
//        if (super.getUri().getPath().equals("-/")) {
//            return getQueryInterface(path, headers);
//        }
//
//        String msg = "ok";
//        response = Response.ok().
//                entity(msg).
//                header("Server", Constants.OCCI_SERVER_HEADER).build();
//        return response;
//    }
    @Override
    public Response getMixin(String mixinKind) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // With well known method.
    @Override
    // @Path("/.well-known/org/ogf/occi/-/")
    public Response getQueryInterface(String path, HttpHeaders headers) {
        Response response;

        response = super.getQueryInterface(path, headers);
        if (response != null) {
            return response;
        }
        // Check if we need to filter for a category like /compute/-/, we get the term.
        String categoryFilter = Utils.getCategoryFilter(path, ConfigurationManager.DEFAULT_OWNER);

        response = inputParser.getInterface(categoryFilter, ConfigurationManager.DEFAULT_OWNER);
        return response;
    }

}