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
import org.wso2.carbon.identity.api.server.api.resource.v2.APIResourceListItem;
import org.wso2.carbon.identity.api.server.api.resource.v2.PaginationLink;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class APIResourceListResponse  {
  
    private Integer totalResults;
    private List<PaginationLink> links = new ArrayList<PaginationLink>();

    private List<APIResourceListItem> apIResources = null;


    /**
    **/
    public APIResourceListResponse totalResults(Integer totalResults) {

        this.totalResults = totalResults;
        return this;
    }
    
    @ApiModelProperty(example = "1", value = "")
    @JsonProperty("totalResults")
    @Valid
    public Integer getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
    **/
    public APIResourceListResponse links(List<PaginationLink> links) {

        this.links = links;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("links")
    @Valid
    @NotNull(message = "Property links cannot be null.")

    public List<PaginationLink> getLinks() {
        return links;
    }
    public void setLinks(List<PaginationLink> links) {
        this.links = links;
    }

    public APIResourceListResponse addLinksItem(PaginationLink linksItem) {
        this.links.add(linksItem);
        return this;
    }

        /**
    **/
    public APIResourceListResponse apIResources(List<APIResourceListItem> apIResources) {

        this.apIResources = apIResources;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("APIResources")
    @Valid
    public List<APIResourceListItem> getApIResources() {
        return apIResources;
    }
    public void setApIResources(List<APIResourceListItem> apIResources) {
        this.apIResources = apIResources;
    }

    public APIResourceListResponse addApIResourcesItem(APIResourceListItem apIResourcesItem) {
        if (this.apIResources == null) {
            this.apIResources = new ArrayList<APIResourceListItem>();
        }
        this.apIResources.add(apIResourcesItem);
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
        APIResourceListResponse apIResourceListResponse = (APIResourceListResponse) o;
        return Objects.equals(this.totalResults, apIResourceListResponse.totalResults) &&
            Objects.equals(this.links, apIResourceListResponse.links) &&
            Objects.equals(this.apIResources, apIResourceListResponse.apIResources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalResults, links, apIResources);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class APIResourceListResponse {\n");
        
        sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    apIResources: ").append(toIndentedString(apIResources)).append("\n");
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

