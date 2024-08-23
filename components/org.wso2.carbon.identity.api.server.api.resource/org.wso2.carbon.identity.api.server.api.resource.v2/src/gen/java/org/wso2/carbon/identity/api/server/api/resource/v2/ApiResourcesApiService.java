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

import org.wso2.carbon.identity.api.server.api.resource.v2.*;
import org.wso2.carbon.identity.api.server.api.resource.v2.*;
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
import javax.ws.rs.core.Response;


public interface ApiResourcesApiService {

      public Response addAPIResource(APIResourceCreationModel apIResourceCreationModel);

      public Response apiResourcesApiResourceIdDelete(String apiResourceId);

      public Response apiResourcesApiResourceIdGet(String apiResourceId);

      public Response apiResourcesApiResourceIdPatch(String apiResourceId, APIResourcePatchModel apIResourcePatchModel);

      public Response apiResourcesApiResourceIdScopesGet(String apiResourceId);

      public Response apiResourcesApiResourceIdScopesPut(String apiResourceId, List<ScopeCreationModel> scopeCreationModel);

      public Response apiResourcesApiResourceIdScopesScopeNameDelete(String apiResourceId, String scopeName);

      public Response deleteAnAuthorizationDetailsType(String apiResourceId, String authorizationDetailsType);

      public Response getAPIResources(String before, String after, String filter, Integer limit, String attributes);

      public Response getAnAuthorizationDetailsType(String apiResourceId, String authorizationDetailsType);

      public Response getAuthorizationDetailsType(String apiResourceId);

      public Response isAuthorizationDetailsTypeExists(String apiResourceId, String authorizationDetailsType);

      public Response updateAnAuthorizationDetailsType(String apiResourceId, String authorizationDetailsType, AuthorizationDetailsTypesPatchModel authorizationDetailsTypesPatchModel);
}
