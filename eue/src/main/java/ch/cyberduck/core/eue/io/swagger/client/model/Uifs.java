/*
 * ReSTFS
 * ReSTFS Open API 3.0 Spec
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.eue.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.eue.io.swagger.client.model.Children;
import ch.cyberduck.core.eue.io.swagger.client.model.Uifs;
import ch.cyberduck.core.eue.io.swagger.client.model.UifsUiMetaResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Uifs
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-10-25T16:09:11.296078900+02:00[Europe/Berlin]")
public class Uifs {
  @JsonProperty("creationMillis")
  private Long creationMillis = null;

  @JsonProperty("childrenSize")
  private Long childrenSize = null;

  @JsonProperty("metaETag")
  private String metaETag = null;

  @JsonProperty("lastResourceOperation")
  private String lastResourceOperation = null;

  @JsonProperty("resourceURI")
  private String resourceURI = null;

  @JsonProperty("version")
  private Integer version = null;

  @JsonProperty("lastResourceOperationClient")
  private String lastResourceOperationClient = null;

  @JsonProperty("size")
  private Long size = null;

  @JsonProperty("children")
  private List<Children> children = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("modificationMillis")
  private Long modificationMillis = null;

  @JsonProperty("childrenCount")
  private Integer childrenCount = null;

  @JsonProperty("resourceType")
  private String resourceType = null;

  @JsonProperty("cdash64")
  private String cdash64 = null;

  @JsonProperty("referenceId")
  private String referenceId = null;

  @JsonProperty("storeId")
  private String storeId = null;

  @JsonProperty("guestModificationMillis")
  private Long guestModificationMillis = null;

  @JsonProperty("originalParents")
  private List<Uifs> originalParents = null;

  @JsonProperty("contentETag")
  private String contentETag = null;

  @JsonProperty("parents")
  private List<Uifs> parents = null;

  @JsonProperty("UiMetaResource")
  private UifsUiMetaResource uiMetaResource = null;

  public Uifs creationMillis(Long creationMillis) {
    this.creationMillis = creationMillis;
    return this;
  }

   /**
   * Get creationMillis
   * @return creationMillis
  **/
  @Schema(description = "")
  public Long getCreationMillis() {
    return creationMillis;
  }

  public void setCreationMillis(Long creationMillis) {
    this.creationMillis = creationMillis;
  }

  public Uifs childrenSize(Long childrenSize) {
    this.childrenSize = childrenSize;
    return this;
  }

   /**
   * Get childrenSize
   * @return childrenSize
  **/
  @Schema(description = "")
  public Long getChildrenSize() {
    return childrenSize;
  }

  public void setChildrenSize(Long childrenSize) {
    this.childrenSize = childrenSize;
  }

  public Uifs metaETag(String metaETag) {
    this.metaETag = metaETag;
    return this;
  }

   /**
   * Get metaETag
   * @return metaETag
  **/
  @Schema(description = "")
  public String getMetaETag() {
    return metaETag;
  }

  public void setMetaETag(String metaETag) {
    this.metaETag = metaETag;
  }

  public Uifs lastResourceOperation(String lastResourceOperation) {
    this.lastResourceOperation = lastResourceOperation;
    return this;
  }

   /**
   * Get lastResourceOperation
   * @return lastResourceOperation
  **/
  @Schema(description = "")
  public String getLastResourceOperation() {
    return lastResourceOperation;
  }

  public void setLastResourceOperation(String lastResourceOperation) {
    this.lastResourceOperation = lastResourceOperation;
  }

  public Uifs resourceURI(String resourceURI) {
    this.resourceURI = resourceURI;
    return this;
  }

   /**
   * Get resourceURI
   * @return resourceURI
  **/
  @Schema(description = "")
  public String getResourceURI() {
    return resourceURI;
  }

  public void setResourceURI(String resourceURI) {
    this.resourceURI = resourceURI;
  }

  public Uifs version(Integer version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @Schema(description = "")
  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Uifs lastResourceOperationClient(String lastResourceOperationClient) {
    this.lastResourceOperationClient = lastResourceOperationClient;
    return this;
  }

   /**
   * Get lastResourceOperationClient
   * @return lastResourceOperationClient
  **/
  @Schema(description = "")
  public String getLastResourceOperationClient() {
    return lastResourceOperationClient;
  }

  public void setLastResourceOperationClient(String lastResourceOperationClient) {
    this.lastResourceOperationClient = lastResourceOperationClient;
  }

  public Uifs size(Long size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @Schema(description = "")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public Uifs children(List<Children> children) {
    this.children = children;
    return this;
  }

  public Uifs addChildrenItem(Children childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

   /**
   * Get children
   * @return children
  **/
  @Schema(description = "")
  public List<Children> getChildren() {
    return children;
  }

  public void setChildren(List<Children> children) {
    this.children = children;
  }

  public Uifs name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Uifs modificationMillis(Long modificationMillis) {
    this.modificationMillis = modificationMillis;
    return this;
  }

   /**
   * Get modificationMillis
   * @return modificationMillis
  **/
  @Schema(description = "")
  public Long getModificationMillis() {
    return modificationMillis;
  }

  public void setModificationMillis(Long modificationMillis) {
    this.modificationMillis = modificationMillis;
  }

  public Uifs childrenCount(Integer childrenCount) {
    this.childrenCount = childrenCount;
    return this;
  }

   /**
   * Get childrenCount
   * @return childrenCount
  **/
  @Schema(description = "")
  public Integer getChildrenCount() {
    return childrenCount;
  }

  public void setChildrenCount(Integer childrenCount) {
    this.childrenCount = childrenCount;
  }

  public Uifs resourceType(String resourceType) {
    this.resourceType = resourceType;
    return this;
  }

   /**
   * Get resourceType
   * @return resourceType
  **/
  @Schema(description = "")
  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public Uifs cdash64(String cdash64) {
    this.cdash64 = cdash64;
    return this;
  }

   /**
   * Get cdash64
   * @return cdash64
  **/
  @Schema(description = "")
  public String getCdash64() {
    return cdash64;
  }

  public void setCdash64(String cdash64) {
    this.cdash64 = cdash64;
  }

  public Uifs referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

   /**
   * Get referenceId
   * @return referenceId
  **/
  @Schema(description = "")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public Uifs storeId(String storeId) {
    this.storeId = storeId;
    return this;
  }

   /**
   * Get storeId
   * @return storeId
  **/
  @Schema(description = "")
  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  public Uifs guestModificationMillis(Long guestModificationMillis) {
    this.guestModificationMillis = guestModificationMillis;
    return this;
  }

   /**
   * Get guestModificationMillis
   * @return guestModificationMillis
  **/
  @Schema(description = "")
  public Long getGuestModificationMillis() {
    return guestModificationMillis;
  }

  public void setGuestModificationMillis(Long guestModificationMillis) {
    this.guestModificationMillis = guestModificationMillis;
  }

  public Uifs originalParents(List<Uifs> originalParents) {
    this.originalParents = originalParents;
    return this;
  }

  public Uifs addOriginalParentsItem(Uifs originalParentsItem) {
    if (this.originalParents == null) {
      this.originalParents = new ArrayList<>();
    }
    this.originalParents.add(originalParentsItem);
    return this;
  }

   /**
   * Get originalParents
   * @return originalParents
  **/
  @Schema(description = "")
  public List<Uifs> getOriginalParents() {
    return originalParents;
  }

  public void setOriginalParents(List<Uifs> originalParents) {
    this.originalParents = originalParents;
  }

  public Uifs contentETag(String contentETag) {
    this.contentETag = contentETag;
    return this;
  }

   /**
   * Get contentETag
   * @return contentETag
  **/
  @Schema(description = "")
  public String getContentETag() {
    return contentETag;
  }

  public void setContentETag(String contentETag) {
    this.contentETag = contentETag;
  }

  public Uifs parents(List<Uifs> parents) {
    this.parents = parents;
    return this;
  }

  public Uifs addParentsItem(Uifs parentsItem) {
    if (this.parents == null) {
      this.parents = new ArrayList<>();
    }
    this.parents.add(parentsItem);
    return this;
  }

   /**
   * Get parents
   * @return parents
  **/
  @Schema(description = "")
  public List<Uifs> getParents() {
    return parents;
  }

  public void setParents(List<Uifs> parents) {
    this.parents = parents;
  }

  public Uifs uiMetaResource(UifsUiMetaResource uiMetaResource) {
    this.uiMetaResource = uiMetaResource;
    return this;
  }

   /**
   * Get uiMetaResource
   * @return uiMetaResource
  **/
  @Schema(description = "")
  public UifsUiMetaResource getUiMetaResource() {
    return uiMetaResource;
  }

  public void setUiMetaResource(UifsUiMetaResource uiMetaResource) {
    this.uiMetaResource = uiMetaResource;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Uifs uifs = (Uifs) o;
    return Objects.equals(this.creationMillis, uifs.creationMillis) &&
        Objects.equals(this.childrenSize, uifs.childrenSize) &&
        Objects.equals(this.metaETag, uifs.metaETag) &&
        Objects.equals(this.lastResourceOperation, uifs.lastResourceOperation) &&
        Objects.equals(this.resourceURI, uifs.resourceURI) &&
        Objects.equals(this.version, uifs.version) &&
        Objects.equals(this.lastResourceOperationClient, uifs.lastResourceOperationClient) &&
        Objects.equals(this.size, uifs.size) &&
        Objects.equals(this.children, uifs.children) &&
        Objects.equals(this.name, uifs.name) &&
        Objects.equals(this.modificationMillis, uifs.modificationMillis) &&
        Objects.equals(this.childrenCount, uifs.childrenCount) &&
        Objects.equals(this.resourceType, uifs.resourceType) &&
        Objects.equals(this.cdash64, uifs.cdash64) &&
        Objects.equals(this.referenceId, uifs.referenceId) &&
        Objects.equals(this.storeId, uifs.storeId) &&
        Objects.equals(this.guestModificationMillis, uifs.guestModificationMillis) &&
        Objects.equals(this.originalParents, uifs.originalParents) &&
        Objects.equals(this.contentETag, uifs.contentETag) &&
        Objects.equals(this.parents, uifs.parents) &&
        Objects.equals(this.uiMetaResource, uifs.uiMetaResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationMillis, childrenSize, metaETag, lastResourceOperation, resourceURI, version, lastResourceOperationClient, size, children, name, modificationMillis, childrenCount, resourceType, cdash64, referenceId, storeId, guestModificationMillis, originalParents, contentETag, parents, uiMetaResource);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Uifs {\n");
    
    sb.append("    creationMillis: ").append(toIndentedString(creationMillis)).append("\n");
    sb.append("    childrenSize: ").append(toIndentedString(childrenSize)).append("\n");
    sb.append("    metaETag: ").append(toIndentedString(metaETag)).append("\n");
    sb.append("    lastResourceOperation: ").append(toIndentedString(lastResourceOperation)).append("\n");
    sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    lastResourceOperationClient: ").append(toIndentedString(lastResourceOperationClient)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    modificationMillis: ").append(toIndentedString(modificationMillis)).append("\n");
    sb.append("    childrenCount: ").append(toIndentedString(childrenCount)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    cdash64: ").append(toIndentedString(cdash64)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
    sb.append("    guestModificationMillis: ").append(toIndentedString(guestModificationMillis)).append("\n");
    sb.append("    originalParents: ").append(toIndentedString(originalParents)).append("\n");
    sb.append("    contentETag: ").append(toIndentedString(contentETag)).append("\n");
    sb.append("    parents: ").append(toIndentedString(parents)).append("\n");
    sb.append("    uiMetaResource: ").append(toIndentedString(uiMetaResource)).append("\n");
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
    return o.toString().replace("\n", "\n    ");
  }

}
