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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourceCollectionListItem;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class APIResourceCollectionListResponse  {
  
    private Integer totalResults;
    private List<APIResourceCollectionListItem> apiResourceCollections = new ArrayList<APIResourceCollectionListItem>();


    /**
    **/
    public APIResourceCollectionListResponse totalResults(Integer totalResults) {

        this.totalResults = totalResults;
        return this;
    }
    
    @ApiModelProperty(example = "1", required = true, value = "")
    @JsonProperty("totalResults")
    @Valid
    @NotNull(message = "Property totalResults cannot be null.")

    public Integer getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
    **/
    public APIResourceCollectionListResponse apiResourceCollections(List<APIResourceCollectionListItem> apiResourceCollections) {

        this.apiResourceCollections = apiResourceCollections;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("apiResourceCollections")
    @Valid
    @NotNull(message = "Property apiResourceCollections cannot be null.")

    public List<APIResourceCollectionListItem> getApiResourceCollections() {
        return apiResourceCollections;
    }
    public void setApiResourceCollections(List<APIResourceCollectionListItem> apiResourceCollections) {
        this.apiResourceCollections = apiResourceCollections;
    }

    public APIResourceCollectionListResponse addApiResourceCollectionsItem(APIResourceCollectionListItem apiResourceCollectionsItem) {
        this.apiResourceCollections.add(apiResourceCollectionsItem);
        return this;
    }

    

    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        APIResourceCollectionListResponse apIResourceCollectionListResponse = (APIResourceCollectionListResponse) o;
        return Objects.equals(this.totalResults, apIResourceCollectionListResponse.totalResults) &&
            Objects.equals(this.apiResourceCollections, apIResourceCollectionListResponse.apiResourceCollections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalResults, apiResourceCollections);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class APIResourceCollectionListResponse {\n");
        
        sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
        sb.append("    apiResourceCollections: ").append(toIndentedString(apiResourceCollections)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
    private String toIndentedString(java.lang.Object o) {

        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n");
    }
}

