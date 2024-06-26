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
import ch.cyberduck.core.brick.io.swagger.client.model.UsageSnapshotEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;
/**
 * List Usage Daily Snapshots
 */
@Schema(description = "List Usage Daily Snapshots")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class UsageDailySnapshotEntity {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("date")
  private LocalDate date = null;

  @JsonProperty("current_storage")
  private Integer currentStorage = null;

  @JsonProperty("usage_by_top_level_dir")
  private List<UsageSnapshotEntity> usageByTopLevelDir = null;

  public UsageDailySnapshotEntity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the usage record
   * @return id
  **/
  @Schema(example = "1", description = "ID of the usage record")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UsageDailySnapshotEntity date(LocalDate date) {
    this.date = date;
    return this;
  }

   /**
   * The date of this usage record
   * @return date
  **/
  @Schema(description = "The date of this usage record")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public UsageDailySnapshotEntity currentStorage(Integer currentStorage) {
    this.currentStorage = currentStorage;
    return this;
  }

   /**
   * The quantity of storage held for this site
   * @return currentStorage
  **/
  @Schema(example = "65536", description = "The quantity of storage held for this site")
  public Integer getCurrentStorage() {
    return currentStorage;
  }

  public void setCurrentStorage(Integer currentStorage) {
    this.currentStorage = currentStorage;
  }

  public UsageDailySnapshotEntity usageByTopLevelDir(List<UsageSnapshotEntity> usageByTopLevelDir) {
    this.usageByTopLevelDir = usageByTopLevelDir;
    return this;
  }

  public UsageDailySnapshotEntity addUsageByTopLevelDirItem(UsageSnapshotEntity usageByTopLevelDirItem) {
    if (this.usageByTopLevelDir == null) {
      this.usageByTopLevelDir = new ArrayList<>();
    }
    this.usageByTopLevelDir.add(usageByTopLevelDirItem);
    return this;
  }

   /**
   * Usage broken down by each top-level folder
   * @return usageByTopLevelDir
  **/
  @Schema(description = "Usage broken down by each top-level folder")
  public List<UsageSnapshotEntity> getUsageByTopLevelDir() {
    return usageByTopLevelDir;
  }

  public void setUsageByTopLevelDir(List<UsageSnapshotEntity> usageByTopLevelDir) {
    this.usageByTopLevelDir = usageByTopLevelDir;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsageDailySnapshotEntity usageDailySnapshotEntity = (UsageDailySnapshotEntity) o;
    return Objects.equals(this.id, usageDailySnapshotEntity.id) &&
        Objects.equals(this.date, usageDailySnapshotEntity.date) &&
        Objects.equals(this.currentStorage, usageDailySnapshotEntity.currentStorage) &&
        Objects.equals(this.usageByTopLevelDir, usageDailySnapshotEntity.usageByTopLevelDir);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, currentStorage, usageByTopLevelDir);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsageDailySnapshotEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    currentStorage: ").append(toIndentedString(currentStorage)).append("\n");
    sb.append("    usageByTopLevelDir: ").append(toIndentedString(usageByTopLevelDir)).append("\n");
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
