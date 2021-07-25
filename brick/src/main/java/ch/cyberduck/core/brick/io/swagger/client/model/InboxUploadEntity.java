/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.brick.io.swagger.client.model.InboxRegistrationEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * List Inbox Uploads
 */
@Schema(description = "List Inbox Uploads")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class InboxUploadEntity {
  @JsonProperty("inbox_registration")
  private InboxRegistrationEntity inboxRegistration = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("created_at")
  private DateTime createdAt = null;

  public InboxUploadEntity inboxRegistration(InboxRegistrationEntity inboxRegistration) {
    this.inboxRegistration = inboxRegistration;
    return this;
  }

   /**
   * Get inboxRegistration
   * @return inboxRegistration
  **/
  @Schema(description = "")
  public InboxRegistrationEntity getInboxRegistration() {
    return inboxRegistration;
  }

  public void setInboxRegistration(InboxRegistrationEntity inboxRegistration) {
    this.inboxRegistration = inboxRegistration;
  }

  public InboxUploadEntity path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Upload path
   * @return path
  **/
  @Schema(example = "a/b/test.txt", description = "Upload path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public InboxUploadEntity createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Upload date/time
   * @return createdAt
  **/
  @Schema(description = "Upload date/time")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InboxUploadEntity inboxUploadEntity = (InboxUploadEntity) o;
    return Objects.equals(this.inboxRegistration, inboxUploadEntity.inboxRegistration) &&
        Objects.equals(this.path, inboxUploadEntity.path) &&
        Objects.equals(this.createdAt, inboxUploadEntity.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inboxRegistration, path, createdAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InboxUploadEntity {\n");
    
    sb.append("    inboxRegistration: ").append(toIndentedString(inboxRegistration)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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
