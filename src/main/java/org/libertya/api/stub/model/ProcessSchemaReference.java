package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.ProcessSchemaReferenceValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProcessSchemaReference
 */
@Validated



public class ProcessSchemaReference   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("endpoint")
  private String endpoint = null;

  @JsonProperty("values")
  @Valid
  private List<ProcessSchemaReferenceValue> values = null;

  public ProcessSchemaReference type(String type) {
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

  public ProcessSchemaReference endpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

  /**
   * Endpoint REST para recuperar los valores del lookup o búsqueda
   * @return endpoint
   **/
  @Schema(description = "Endpoint REST para recuperar los valores del lookup o búsqueda")
  
    public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public ProcessSchemaReference values(List<ProcessSchemaReferenceValue> values) {
    this.values = values;
    return this;
  }

  public ProcessSchemaReference addValuesItem(ProcessSchemaReferenceValue valuesItem) {
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
    public List<ProcessSchemaReferenceValue> getValues() {
    return values;
  }

  public void setValues(List<ProcessSchemaReferenceValue> values) {
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
    ProcessSchemaReference processSchemaReference = (ProcessSchemaReference) o;
    return Objects.equals(this.type, processSchemaReference.type) &&
        Objects.equals(this.endpoint, processSchemaReference.endpoint) &&
        Objects.equals(this.values, processSchemaReference.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessSchemaReference {\n");
    
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
