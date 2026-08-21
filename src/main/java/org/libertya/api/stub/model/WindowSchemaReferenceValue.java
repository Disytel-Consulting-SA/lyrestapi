package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WindowSchemaReferenceValue
 */
@Validated



public class WindowSchemaReferenceValue   {
  @JsonProperty("value")
  private String value = null;

  @JsonProperty("name")
  private String name = null;

  public WindowSchemaReferenceValue value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(description = "")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public WindowSchemaReferenceValue name(String name) {
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
    WindowSchemaReferenceValue windowSchemaReferenceValue = (WindowSchemaReferenceValue) o;
    return Objects.equals(this.value, windowSchemaReferenceValue.value) &&
        Objects.equals(this.name, windowSchemaReferenceValue.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowSchemaReferenceValue {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
