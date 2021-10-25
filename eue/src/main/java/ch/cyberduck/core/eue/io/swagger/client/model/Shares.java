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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Shares
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-10-25T16:09:11.296078900+02:00[Europe/Berlin]")
public class Shares {
  /**
   * Gets or Sets writableSharesMinimumProtection
   */
  public enum WritableSharesMinimumProtectionEnum {
    ANY("ANY"),
    PIN("PIN"),
    EXPIRATION("EXPIRATION"),
    PIN_AND_EXPIRATION("PIN_AND_EXPIRATION");

    private String value;

    WritableSharesMinimumProtectionEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static WritableSharesMinimumProtectionEnum fromValue(String text) {
      for (WritableSharesMinimumProtectionEnum b : WritableSharesMinimumProtectionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("writableSharesMinimumProtection")
  private WritableSharesMinimumProtectionEnum writableSharesMinimumProtection = null;

  public Shares writableSharesMinimumProtection(WritableSharesMinimumProtectionEnum writableSharesMinimumProtection) {
    this.writableSharesMinimumProtection = writableSharesMinimumProtection;
    return this;
  }

   /**
   * Get writableSharesMinimumProtection
   * @return writableSharesMinimumProtection
  **/
  @Schema(description = "")
  public WritableSharesMinimumProtectionEnum getWritableSharesMinimumProtection() {
    return writableSharesMinimumProtection;
  }

  public void setWritableSharesMinimumProtection(WritableSharesMinimumProtectionEnum writableSharesMinimumProtection) {
    this.writableSharesMinimumProtection = writableSharesMinimumProtection;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Shares shares = (Shares) o;
    return Objects.equals(this.writableSharesMinimumProtection, shares.writableSharesMinimumProtection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(writableSharesMinimumProtection);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Shares {\n");
    
    sb.append("    writableSharesMinimumProtection: ").append(toIndentedString(writableSharesMinimumProtection)).append("\n");
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
