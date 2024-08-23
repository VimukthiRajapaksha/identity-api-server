/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.api.server.api.resource.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import java.io.InputStream;
import java.util.List;

import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourceCollectionListResponse;
import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourceCollectionResponse;
import org.wso2.carbon.identity.api.server.api.resource.v2.Error;
import org.wso2.carbon.identity.api.server.api.resource.v2.MetaApiService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import io.swagger.annotations.*;

import javax.validation.constraints.*;

@Path("/meta")
@Api(description = "The meta API")

public class MetaApi  {

    @Autowired
    private MetaApiService delegate;

    @Valid
    @GET
    @Path("/api-resource-collections/{collectionId}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get API resource collection specified by the id", notes = "Get API resource collection specified by the id <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/view <br> <b>Scope required:</b> <br>   * internal_api_resource_view ", response = APIResourceCollectionResponse.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Collections", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = APIResourceCollectionResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response getAPIResourceCollectionByCollectionId(@ApiParam(value = "ID of the API Resource Collection.",required=true) @PathParam("collectionId") String collectionId) {

        return delegate.getAPIResourceCollectionByCollectionId(collectionId );
    }

    @Valid
    @GET
    @Path("/api-resource-collections")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "List all API resource collections in the server", notes = "List all API resource collections in the server <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/view <br> <b>Scope required:</b> <br>   * internal_api_resource_view ", response = APIResourceCollectionListResponse.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Collections" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = APIResourceCollectionListResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response getAPIResourceCollections(    @Valid@ApiParam(value = "Condition to filter the retrieval of records. Supports 'sw', 'co', 'ew' and 'eq' operations. ")  @QueryParam("filter") String filter,     @Valid@ApiParam(value = "Specifies the required attributes in the response. Only 'apiResources' attribute is currently supported.")  @QueryParam("attributes") String attributes) {

        return delegate.getAPIResourceCollections(filter,  attributes );
    }

}
