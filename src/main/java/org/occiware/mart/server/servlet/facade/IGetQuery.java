/**
 * Copyright (c) 2015-2017 Inria
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Contributors:
 * - Christophe Gourdin <christophe.gourdin@inria.fr>
 */
package org.occiware.mart.server.servlet.facade;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * @author Christophe Gourdin
 */
interface IGetQuery extends IEntryPoint {

    /**
     * Get request on an entity valid path like : /compute/entity uuid
     *
     * @param path
     * @param entityId
     * @param headers
     * @param request
     * @return
     */
    Response getEntity(String path, String entityId, HttpHeaders headers, HttpServletRequest request);

    Response getEntities(final String path);


    /**
     * on path /-/
     *
     * @param path
     * @param headers
     * @return
     */
    Response getQueryInterface(String path, HttpHeaders headers);

}
