# Development status
## Travis CI
[![Build Status](https://travis-ci.org/cgourdin/MartServer.svg?branch=master)](https://travis-ci.org/cgourdin/MartServer)

Development Status values :
* TODO (Nothing has been done but will be done in near future)
* In progress (in development progress)
* Done (works and tested)
* Problem (done but not tested or have bugs)

## Tasks
<table>
    <th>task name</th>
    <th>comment (and related issues)</th>
    <th>progress status</th>
    <tr>
        <td align="center">Add junit tests suite</td>
        <td align="center">Test suite for each functional methods, <a href="https://github.com/cgourdin/MartServer/issues/21">feature #21</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/inprogress.png" alt="In progress" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add integration tests suite for json parser</td>
        <td align="center">Integration test launch the server and test input and output validation, <a href="https://github.com/cgourdin/MartServer/issues/22">feature #22</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/inprogress.png" alt="In progress" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add integration tests suite for text/occi parser</td>
        <td align="center">Integration test launch the server and test input and output validation, <a href="https://github.com/cgourdin/MartServer/issues/22">feature #22</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/todo.png" alt="TODO" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">text/plain media type parser (Content-Type and accept)</td>
        <td align="center">Query parser to retrieve attributes etc. and output to client, <a href="https://github.com/cgourdin/MartServer/issues/23">feature #23</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/todo.png" alt="TODO" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add integration tests suite for text/plain media type</td>
        <td align="center">Integration test launch the server and test input and output validation,  <a href="https://github.com/cgourdin/MartServer/issues/22">feature #22</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/todo.png" alt="TODO" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add external properties file to configure the server</td>
        <td align="center">Property file to manager the server configuration<a href="https://github.com/cgourdin/MartServer/issues/29">feature #29</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add https support with certificate</td>
        <td align="center">Https SSL support with X509 certificate<a href="https://github.com/cgourdin/MartServer/issues/35">feature #35</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/todo.png" alt="TODO" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add authentication token mechanism (OAUTH 2) support</td>
        <td align="center">Server authentication with tokens (refresh token and usage token)<a href="https://github.com/cgourdin/MartServer/issues/34">feature #34</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/todo.png" alt="TODO" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Start jetty server</td>
        <td align="center">Called on main method when running the application, <a href="https://github.com/cgourdin/MartServer/issues/1">feature #1</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add travis CI support (travis.yml)</td>
        <td align="center">For tests and deployment, <a href="https://github.com/cgourdin/MartServer/issues/20">feature #20</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Add configuration model@runtime</td>
        <td align="center">OCCIware Core to inject and ConfigurationManager class, <a href="https://github.com/cgourdin/MartServer/issues/28">feature #28</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Create entity (Resource)</td>
        <td align="center">Create a resource via PUT method, <a href="https://github.com/cgourdin/MartServer/issues/3">feature #3</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Create entity (Link)</td>
        <td align="center">Create a link via PUT method, <a href="https://github.com/cgourdin/MartServer/issues/4">feature #4</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Get query interface (/-/ and category/-/ filter)</td>
        <td align="center">Query interface with filter like compute/-/ (kind, mixin, action), <a href="https://github.com/cgourdin/MartServer/issues/5">feature #16</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Get entity via GET Method</td>
        <td align="center">Get an entity via GET Method, <a href="https://github.com/cgourdin/MartServer/issues/5">feature #5</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Get a collection via GET Method</td>
        <td align="center">Get a collection of entity, get a list of locations, <a href="https://github.com/cgourdin/MartServer/issues/8">feature #8</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Manage filter on Get request</td>
        <td align="center">Filtering support and pagination on GET request, <a href="https://github.com/cgourdin/MartServer/issues/15">feature #15</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Update an entity with POST Method</td>
        <td align="center">Update entity, <a href="https://github.com/cgourdin/MartServer/issues/7">feature #7</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Update an attribute of entity collection</td>
        <td align="center">Update entities, <a href="https://github.com/cgourdin/MartServer/issues/9">feature #9</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Action on entity</td>
        <td align="center">Action query (ex: start an instance), <a href="https://github.com/cgourdin/MartServer/issues/31">feature #31</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Action on entities collection</td>
        <td align="center">Action query (ex: start an instance) on collections, <a href="https://github.com/cgourdin/MartServer/issues/32">feature #32</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Define a mixin tag on configuration</td>
        <td align="center">Mixin tag support, <a href="https://github.com/cgourdin/MartServer/issues/12">feature #12</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Associate a mixin tag on entity</td>
        <td align="center">Mixin tag support, <a href="https://github.com/cgourdin/MartServer/issues/12">feature #12</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Associate a mixin tag on collection</td>
        <td align="center">Mixin tag support, <a href="https://github.com/cgourdin/MartServer/issues/14">feature #14</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Update mixin tag association</td>
        <td align="center">Update mixin tag, <a href="https://github.com/cgourdin/MartServer/issues/13">feature #13</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Delete a mixin tag</td>
        <td align="center">Mixin tag support, <a href="https://github.com/cgourdin/MartServer/issues/25">feature #25</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Associate a mixin (extension) on entity</td>
        <td align="center">Mixin support, <a href="https://github.com/cgourdin/MartServer/issues/10">feature #10</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Delete an entity</td>
        <td align="center">Delete an entity (resource or link), <a href="https://github.com/cgourdin/MartServer/issues/18">feature #18</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">text/occi media type parser (Content-Type and accept)</td>
        <td align="center">Query parser to retrieve attributes etc. and output to client, <a href="https://github.com/cgourdin/MartServer/issues/6">feature #6</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">application/json media type parser (Content-Type and accept)</td>
        <td align="center">Query parser to retrieve attributes etc. and output to client, <a href="https://github.com/cgourdin/MartServer/issues/30">feature #30</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Associate a mixin (extension) on collection</td>
        <td align="center">Mixin support, <a href="https://github.com/cgourdin/MartServer/issues/11">feature #11</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Update mixin (extension) association</td>
        <td align="center">Update mixin association, <a href="https://github.com/cgourdin/MartServer/issues/36">feature #36</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Remove a mixin (extension) from configuration</td>
        <td align="center">Mixin support, <a href="https://github.com/cgourdin/MartServer/issues/26">feature #26</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
    <tr>
        <td align="center">Delete a collection</td>
        <td align="center">Delete a collection (ex: delete all the compute of the configuration), <a href="https://github.com/cgourdin/MartServer/issues/19">feature #19</a></td>
        <td align="center"><img src="https://raw.github.com/cgourdin/MartServer/master/doc/done.png" alt="Done" height="40" width="auto" /></td>
    </tr>
</table>


