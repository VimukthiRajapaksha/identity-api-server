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

import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourceCreationModel;
import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourceListResponse;
import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourcePatchModel;
import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourceResponse;
import org.wso2.carbon.identity.api.server.api.resource.v2.AuthorizationDetailsTypesGetModel;
import org.wso2.carbon.identity.api.server.api.resource.v2.AuthorizationDetailsTypesPatchModel;
import org.wso2.carbon.identity.api.server.api.resource.v2.Error;
import org.wso2.carbon.identity.api.server.api.resource.v2.InlineResponse200;
import java.util.List;
import org.wso2.carbon.identity.api.server.api.resource.v2.ScopeCreationModel;
import org.wso2.carbon.identity.api.server.api.resource.v2.ScopeGetModel;
import org.wso2.carbon.identity.api.server.api.resource.v2.ApiResourcesApiService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import io.swagger.annotations.*;

import javax.validation.constraints.*;

@Path("/api-resources")
@Api(description = "The api-resources API")

public class ApiResourcesApi  {

    @Autowired
    private ApiResourcesApiService delegate;

    @Valid
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml",  })
    @ApiOperation(value = "Add a new API resource", notes = "Add a new API resource <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/create <br> <b>Scope required:</b> <br>   * internal_api_resource_create ", response = APIResourceResponse.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resources", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = APIResourceResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response addAPIResource(@ApiParam(value = "This represents the API resource to be created." ,required=true) @Valid APIResourceCreationModel apIResourceCreationModel) {

        return delegate.addAPIResource(apIResourceCreationModel );
    }

    @Valid
    @DELETE
    @Path("/{apiResourceId}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Delete API resource specified by the id", notes = "Delete API resource specified by the id <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/delete <br> <b>Scope required:</b> <br>   * internal_api_resource_delete ", response = Void.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resources", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No Content", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response apiResourcesApiResourceIdDelete(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId) {

        return delegate.apiResourcesApiResourceIdDelete(apiResourceId );
    }

    @Valid
    @GET
    @Path("/{apiResourceId}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get API resource specified by the id", notes = "Get API resource specified by the id <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/view <br> <b>Scope required:</b> <br>   * internal_api_resource_view ", response = APIResourceResponse.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resources", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = APIResourceResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response apiResourcesApiResourceIdGet(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId) {

        return delegate.apiResourcesApiResourceIdGet(apiResourceId );
    }

    @Valid
    @PATCH
    @Path("/{apiResourceId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml",  })
    @ApiOperation(value = "Patch API resource specified by the id", notes = "Patch API resource specified by the id. Patch operation only supports \"name\", \"description\" updating and \"addedScopes\" fields at the moment. <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/update <br> <b>Scope required:</b> <br>   * internal_api_resource_update ", response = Void.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resources", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Not Content", response = Void.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class),
        @ApiResponse(code = 501, message = "Not Implemented", response = Error.class)
    })
    public Response apiResourcesApiResourceIdPatch(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId, @ApiParam(value = "This represents the API resource to be patched." ,required=true) @Valid APIResourcePatchModel apIResourcePatchModel) {

        return delegate.apiResourcesApiResourceIdPatch(apiResourceId,  apIResourcePatchModel );
    }

    @Valid
    @GET
    @Path("/{apiResourceId}/scopes")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get API resource scopes", notes = "Get API resource scopes specified by the id <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/view <br> <b>Scope required:</b> <br>   * internal_api_resource_view ", response = ScopeGetModel.class, responseContainer = "List", authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Scopes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ScopeGetModel.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response apiResourcesApiResourceIdScopesGet(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId) {

        return delegate.apiResourcesApiResourceIdScopesGet(apiResourceId );
    }

    @Valid
    @PUT
    @Path("/{apiResourceId}/scopes")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml",  })
    @ApiOperation(value = "Add scopes to API resource", notes = "Put scopes API resource specified by the id <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/update <br> <b>Scope required:</b> <br>   * internal_api_resource_update ", response = Void.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Scopes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No Content", response = Void.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response apiResourcesApiResourceIdScopesPut(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId, @ApiParam(value = "This represents the API resource to be patched." ,required=true) @Valid List<ScopeCreationModel> scopeCreationModel) {

        return delegate.apiResourcesApiResourceIdScopesPut(apiResourceId,  scopeCreationModel );
    }

    @Valid
    @DELETE
    @Path("/{apiResourceId}/scopes/{scopeName}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Delete API scope specified by the name", notes = "Delete API scope specified by the name <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/delete <br> <b>Scope required:</b> <br>   * internal_api_resource_delete ", response = Void.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Scopes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response apiResourcesApiResourceIdScopesScopeNameDelete(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId, @ApiParam(value = "Name of the Scope.",required=true) @PathParam("scopeName") String scopeName) {

        return delegate.apiResourcesApiResourceIdScopesScopeNameDelete(apiResourceId,  scopeName );
    }

    @Valid
    @DELETE
    @Path("/{apiResourceId}/authorization-details-types/{authorizationDetailsType}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Deletes a registered authorization detail by type", notes = "This API is used to delete a registered authorization detail by a given type.  <b>Permission required:</b>     * /permission/admin/manage/identity/apiresourcemgt/delete    <b>Scope required:</b>     * internal_api_resource_delete ", response = Void.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Authorization Details", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successfully deleted an authorization detail by type", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized request", response = Error.class),
        @ApiResponse(code = 500, message = "Encountered a server error", response = Error.class)
    })
    public Response deleteAnAuthorizationDetailsType(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId, @ApiParam(value = "Type of the authorization detail that is to be retrieved",required=true) @PathParam("authorizationDetailsType") String authorizationDetailsType) {

        return delegate.deleteAnAuthorizationDetailsType(apiResourceId,  authorizationDetailsType );
    }

    @Valid
    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "List all API resources in the server", notes = "List all API resources in the server <b>Permission required:</b> <br>   * /permission/admin/manage/identity/apiresourcemgt/view <br> <b>Scope required:</b> <br>   * internal_api_resource_view ", response = APIResourceListResponse.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resources", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = APIResourceListResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response getAPIResources(    @Valid@ApiParam(value = "Base64 encoded cursor value for backward pagination. ")  @QueryParam("before") String before,     @Valid@ApiParam(value = "Base64 encoded cursor value for forward pagination. ")  @QueryParam("after") String after,     @Valid@ApiParam(value = "Condition to filter the retrieval of records. Supports 'sw', 'co', 'ew' and 'eq' operations. ")  @QueryParam("filter") String filter,     @Valid@ApiParam(value = "Maximum number of records to return. ")  @QueryParam("limit") Integer limit,     @Valid@ApiParam(value = "Specifies the required attributes in the response. Only 'properties' attribute is currently supported.")  @QueryParam("attributes") String attributes) {

        return delegate.getAPIResources(before,  after,  filter,  limit,  attributes );
    }

    @Valid
    @GET
    @Path("/{apiResourceId}/authorization-details-types/{authorizationDetailsType}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns a registered authorization detail by type", notes = "This API is used to retrieve details of a registered authorization detail by a given type.  <b>Permission required:</b>     * /permission/admin/manage/identity/apiresourcemgt/view    <b>Scope required:</b>     * internal_api_resource_view ", response = AuthorizationDetailsTypesGetModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Authorization Details", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully retrieved an authorization detail by type", response = AuthorizationDetailsTypesGetModel.class),
        @ApiResponse(code = 401, message = "Unauthorized request", response = Error.class),
        @ApiResponse(code = 404, message = "Requested resource is not found", response = Error.class),
        @ApiResponse(code = 500, message = "Encountered a server error", response = Error.class)
    })
    public Response getAnAuthorizationDetailsType(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId, @ApiParam(value = "Type of the authorization detail that is to be retrieved",required=true) @PathParam("authorizationDetailsType") String authorizationDetailsType) {

        return delegate.getAnAuthorizationDetailsType(apiResourceId,  authorizationDetailsType );
    }

    @Valid
    @GET
    @Path("/{apiResourceId}/authorization-details-types")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Lists all registered authorization details", notes = "This API is used to get all registered authorization details types.  <b>Permission required:</b>     * /permission/admin/manage/identity/apiresourcemgt/view    <b>Scope required:</b>     * internal_api_resource_view ", response = AuthorizationDetailsTypesGetModel.class, responseContainer = "List", authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Authorization Details", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully retrieved a list of authorization details", response = AuthorizationDetailsTypesGetModel.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized request", response = Error.class),
        @ApiResponse(code = 404, message = "Requested resource is not found", response = Error.class),
        @ApiResponse(code = 500, message = "Encountered a server error", response = Error.class)
    })
    public Response getAuthorizationDetailsType(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId) {

        return delegate.getAuthorizationDetailsType(apiResourceId );
    }

    @Valid
    @HEAD
    @Path("/{apiResourceId}/authorization-details-types/{authorizationDetailsType}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Checks an authorization detail existence by type", notes = "This API is used to check a registered authorization detail's existence using a given type.  <b>Permission required:</b>     * /permission/admin/manage/identity/apiresourcemgt/view    <b>Scope required:</b>     * internal_api_resource_view ", response = InlineResponse200.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Authorization Details", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Provided authorization details type exists", response = InlineResponse200.class),
        @ApiResponse(code = 401, message = "Unauthorized request", response = Error.class),
        @ApiResponse(code = 404, message = "Requested resource is not found", response = Error.class),
        @ApiResponse(code = 500, message = "Encountered a server error", response = Error.class)
    })
    public Response isAuthorizationDetailsTypeExists(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId, @ApiParam(value = "Type of the authorization detail that is to be retrieved",required=true) @PathParam("authorizationDetailsType") String authorizationDetailsType) {

        return delegate.isAuthorizationDetailsTypeExists(apiResourceId,  authorizationDetailsType );
    }

    @Valid
    @PUT
    @Path("/{apiResourceId}/authorization-details-types/{authorizationDetailsType}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Updates a registered authorization detail by type", notes = "This API is used to update a registered authorization detail by a given type.  <b>Permission required:</b>     * /permission/admin/manage/identity/apiresourcemgt/update    <b>Scope required:</b>     * internal_api_resource_update ", response = AuthorizationDetailsTypesGetModel.class, authorizations = {
        @Authorization(value = "BasicAuth"),
        @Authorization(value = "OAuth2", scopes = {
            
        })
    }, tags={ "API Resource Authorization Details" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully updated an authorization detail by type", response = AuthorizationDetailsTypesGetModel.class),
        @ApiResponse(code = 401, message = "Unauthorized request", response = Error.class),
        @ApiResponse(code = 404, message = "Requested resource is not found", response = Error.class),
        @ApiResponse(code = 500, message = "Encountered a server error", response = Error.class)
    })
    public Response updateAnAuthorizationDetailsType(@ApiParam(value = "ID of the API Resource.",required=true) @PathParam("apiResourceId") String apiResourceId, @ApiParam(value = "Type of the authorization detail that is to be retrieved",required=true) @PathParam("authorizationDetailsType") String authorizationDetailsType, @ApiParam(value = "" ) @Valid AuthorizationDetailsTypesPatchModel authorizationDetailsTypesPatchModel) {

        return delegate.updateAnAuthorizationDetailsType(apiResourceId,  authorizationDetailsType,  authorizationDetailsTypesPatchModel );
    }

}
