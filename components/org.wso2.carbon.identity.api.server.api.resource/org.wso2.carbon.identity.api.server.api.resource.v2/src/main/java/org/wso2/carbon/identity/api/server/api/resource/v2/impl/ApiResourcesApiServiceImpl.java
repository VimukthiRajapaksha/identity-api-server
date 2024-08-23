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

package org.wso2.carbon.identity.api.server.api.resource.v2.impl;

import org.wso2.carbon.identity.api.server.api.resource.v2.*;
import org.wso2.carbon.identity.api.server.api.resource.v2.*;
import java.util.List;

import javax.ws.rs.core.Response;

public class ApiResourcesApiServiceImpl implements ApiResourcesApiService {

    @Override
    public Response addAPIResource(APIResourceCreationModel apIResourceCreationModel) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response apiResourcesApiResourceIdDelete(String apiResourceId) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response apiResourcesApiResourceIdGet(String apiResourceId) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response apiResourcesApiResourceIdPatch(String apiResourceId, APIResourcePatchModel apIResourcePatchModel) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response apiResourcesApiResourceIdScopesGet(String apiResourceId) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response apiResourcesApiResourceIdScopesPut(String apiResourceId, List<ScopeCreationModel> scopeCreationModel) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response apiResourcesApiResourceIdScopesScopeNameDelete(String apiResourceId, String scopeName) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response deleteAnAuthorizationDetailsType(String apiResourceId, String authorizationDetailsType) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response getAPIResources(String before, String after, String filter, Integer limit, String attributes) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response getAnAuthorizationDetailsType(String apiResourceId, String authorizationDetailsType) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response getAuthorizationDetailsType(String apiResourceId) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response isAuthorizationDetailsTypeExists(String apiResourceId, String authorizationDetailsType) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }

    @Override
    public Response updateAnAuthorizationDetailsType(String apiResourceId, String authorizationDetailsType, AuthorizationDetailsTypesPatchModel authorizationDetailsTypesPatchModel) {

        // do some magic!
        return Response.ok().entity("magic!").build();
    }
}
