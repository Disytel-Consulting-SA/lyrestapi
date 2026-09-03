package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RoleOption
 */
@Validated



public class RoleOption   {
  @JsonProperty("ad_role_id")
  private Integer adRoleId = null;

  @JsonProperty("name")
  private String name = null;

  public RoleOption adRoleId(Integer adRoleId) {
    this.adRoleId = adRoleId;
    return this;
  }

  /**
   * Get adRoleId
   * @return adRoleId
   **/
  @Schema(description = "")
  
    public Integer getAdRoleId() {
    return adRoleId;
  }

  public void setAdRoleId(Integer adRoleId) {
    this.adRoleId = adRoleId;
  }

  public RoleOption name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleOption roleOption = (RoleOption) o;
    return Objects.equals(this.adRoleId, roleOption.adRoleId) &&
        Objects.equals(this.name, roleOption.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adRoleId, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleOption {\n");
    
    sb.append("    adRoleId: ").append(toIndentedString(adRoleId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
