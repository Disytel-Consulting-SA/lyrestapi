package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WindowOption
 */
@Validated



public class WindowOption   {
  @JsonProperty("ad_window_id")
  private Integer adWindowId = null;

  @JsonProperty("name")
  private String name = null;

  public WindowOption adWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
    return this;
  }

  /**
   * Get adWindowId
   * @return adWindowId
   **/
  @Schema(description = "")
  
    public Integer getAdWindowId() {
    return adWindowId;
  }

  public void setAdWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
  }

  public WindowOption name(String name) {
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
    WindowOption windowOption = (WindowOption) o;
    return Objects.equals(this.adWindowId, windowOption.adWindowId) &&
        Objects.equals(this.name, windowOption.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adWindowId, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowOption {\n");
    
    sb.append("    adWindowId: ").append(toIndentedString(adWindowId)).append("\n");
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
