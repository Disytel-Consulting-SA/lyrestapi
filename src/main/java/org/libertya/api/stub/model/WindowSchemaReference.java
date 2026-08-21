package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.WindowSchemaReferenceValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WindowSchemaReference
 */
@Validated



public class WindowSchemaReference   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("endpoint")
  private String endpoint = null;

  @JsonProperty("values")
  @Valid
  private List<WindowSchemaReferenceValue> values = null;

  public WindowSchemaReference type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Tipo semántico de referencia para el frontend
   * @return type
   **/
  @Schema(description = "Tipo semántico de referencia para el frontend")
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public WindowSchemaReference endpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

  /**
   * Endpoint REST para recuperar los valores del lookup
   * @return endpoint
   **/
  @Schema(description = "Endpoint REST para recuperar los valores del lookup")
  
    public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public WindowSchemaReference values(List<WindowSchemaReferenceValue> values) {
    this.values = values;
    return this;
  }

  public WindowSchemaReference addValuesItem(WindowSchemaReferenceValue valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

  /**
   * Get values
   * @return values
   **/
  @Schema(description = "")
      @Valid
    public List<WindowSchemaReferenceValue> getValues() {
    return values;
  }

  public void setValues(List<WindowSchemaReferenceValue> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowSchemaReference windowSchemaReference = (WindowSchemaReference) o;
    return Objects.equals(this.type, windowSchemaReference.type) &&
        Objects.equals(this.endpoint, windowSchemaReference.endpoint) &&
        Objects.equals(this.values, windowSchemaReference.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowSchemaReference {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
