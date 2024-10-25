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

package org.wso2.carbon.identity.api.server.api.resource.v1.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.wso2.carbon.identity.api.resource.mgt.APIResourceMgtClientException;
import org.wso2.carbon.identity.api.server.api.resource.v1.AuthorizationDetailsTypesCreationModel;
import org.wso2.carbon.identity.api.server.api.resource.v1.AuthorizationDetailsTypesGetModel;
import org.wso2.carbon.identity.application.common.model.AuthorizationDetailsType;
import org.wso2.carbon.identity.oauth2.rar.AuthorizationDetailsSchemaValidator;
import org.wso2.carbon.identity.oauth2.rar.exception.AuthorizationDetailsProcessingException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.wso2.carbon.identity.api.server.api.resource.v1.constants.APIResourceMgtEndpointConstants.ErrorMessage.ERROR_CODE_INVALID_AUTHORIZATION_DETAILS_SCHEMA;

/**
 * Utility class containing helper methods to handle authorization details types.
 */
public class AuthorizationDetailsTypeMgtUtil {

    private static final Log log = LogFactory.getLog(AuthorizationDetailsTypeMgtUtil.class);

    public static List<AuthorizationDetailsTypesGetModel> toAuthorizationDetailsGetModelsList(
            final List<AuthorizationDetailsType> authorizationDetailsTypes) {

        return CollectionUtils.isEmpty(authorizationDetailsTypes) ? Collections.emptyList() :
                authorizationDetailsTypes.stream().map(AuthorizationDetailsTypeMgtUtil::toAuthorizationDetailsGetModel)
                        .collect(Collectors.toList());
    }

    public static AuthorizationDetailsTypesGetModel toAuthorizationDetailsGetModel(
            final AuthorizationDetailsType authorizationDetailsType) {

        return new AuthorizationDetailsTypesGetModel()
                .id(authorizationDetailsType.getId())
                .name(authorizationDetailsType.getName())
                .description(authorizationDetailsType.getDescription())
                .type(authorizationDetailsType.getType())
                .schema(authorizationDetailsType.getSchema());
    }

    public static List<AuthorizationDetailsType> toAuthorizationDetailsTypesList(
            final List<AuthorizationDetailsTypesCreationModel> creationModels) throws APIResourceMgtClientException {

        if (creationModels == null) {
            return Collections.emptyList();
        }

        List<AuthorizationDetailsType> authorizationDetailsTypes = new ArrayList<>();
        for (AuthorizationDetailsTypesCreationModel creationModel : creationModels) {
            authorizationDetailsTypes.add(toAuthorizationDetailsType(creationModel));
        }
        return authorizationDetailsTypes;
    }

    public static AuthorizationDetailsType toAuthorizationDetailsType(
            final AuthorizationDetailsTypesCreationModel creationModel) throws APIResourceMgtClientException {

        final AuthorizationDetailsType authorizationDetailsType = new AuthorizationDetailsType();
        authorizationDetailsType.setType(creationModel.getType());
        authorizationDetailsType.setName(creationModel.getName());
        authorizationDetailsType.setDescription(creationModel.getDescription());

        if (isValidSchema(creationModel.getSchema())) {
            authorizationDetailsType.setSchema(creationModel.getSchema());
        }

        return authorizationDetailsType;
    }

    /**
     * Validates and creates a JSON schema from the given input map.
     *
     * @param schema A map representing the input schema to be validated.
     * @return A JSON string of the validated schema.
     * @throws APIResourceMgtClientException if the schema is empty or invalid.
     */
    private static boolean isValidSchema(Map<String, Object> schema)
            throws APIResourceMgtClientException {

        if (MapUtils.isEmpty(schema)) {
            throwAPIResourceMgtClientException("Schema is empty");
        }

        try {
            if (AuthorizationDetailsSchemaValidator.getInstance().isValidSchema(new JSONObject(schema).toString())) {
                return true;
            }

            throwAPIResourceMgtClientException("Invalid schema");
        } catch (AuthorizationDetailsProcessingException e) {
            log.debug(ERROR_CODE_INVALID_AUTHORIZATION_DETAILS_SCHEMA.getMessage(), e);
            throwAPIResourceMgtClientException(e.getMessage());
        }
        return false;
    }

    public static AuthorizationDetailsType toAuthorizationDetailsType(
            String authorizationDetailsTypeId, AuthorizationDetailsTypesCreationModel creationModel)
            throws APIResourceMgtClientException {

        final AuthorizationDetailsType authorizationDetailsType = toAuthorizationDetailsType(creationModel);
        authorizationDetailsType.setId(authorizationDetailsTypeId);
        return authorizationDetailsType;
    }

    private static void throwAPIResourceMgtClientException(final String message) throws APIResourceMgtClientException {

        throw new APIResourceMgtClientException(
                ERROR_CODE_INVALID_AUTHORIZATION_DETAILS_SCHEMA.getMessage(),
                String.format(ERROR_CODE_INVALID_AUTHORIZATION_DETAILS_SCHEMA.getDescription(), message),
                ERROR_CODE_INVALID_AUTHORIZATION_DETAILS_SCHEMA.getCode());
    }
}
