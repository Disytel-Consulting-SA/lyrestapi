package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Escritura de un registro en el contexto de una pestaña dinámica. parentValues identifica toda la cadena ancestral por sus claves primarias; values contiene exclusivamente los campos del registro. 
 */
@Schema(description = "Escritura de un registro en el contexto de una pestaña dinámica. parentValues identifica toda la cadena ancestral por sus claves primarias; values contiene exclusivamente los campos del registro. ")
@Validated



public class ContextualRecordWrite   {
  @JsonProperty("parentValues")
  @Valid
  private Map<String, String> parentValues = null;

  @JsonProperty("values")
  @Valid
  private Map<String, Object> values = new HashMap<>();

  public ContextualRecordWrite parentValues(Map<String, String> parentValues) {
    this.parentValues = parentValues;
    return this;
  }

  public ContextualRecordWrite putParentValuesItem(String key, String parentValuesItem) {
    if (this.parentValues == null) {
      this.parentValues = new HashMap<>();
    }
    this.parentValues.put(key, parentValuesItem);
    return this;
  }

  /**
   * Mapa de claves primarias ancestras a identificadores positivos expresados como strings. Obligatorio para pestañas detalle. 
   * @return parentValues
   **/
  @Schema(description = "Mapa de claves primarias ancestras a identificadores positivos expresados como strings. Obligatorio para pestañas detalle. ")
  
    public Map<String, String> getParentValues() {
    return parentValues;
  }

  public void setParentValues(Map<String, String> parentValues) {
    this.parentValues = parentValues;
  }

  public ContextualRecordWrite values(Map<String, Object> values) {
    this.values = values;
    return this;
  }

  public ContextualRecordWrite putValuesItem(String key, Object valuesItem) {
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Campos del registro a crear o modificar.
   * @return values
   **/
  @Schema(required = true, description = "Campos del registro a crear o modificar.")
      @NotNull

  @Size(min=1)   public Map<String, Object> getValues() {
    return values;
  }

  public void setValues(Map<String, Object> values) {
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
    ContextualRecordWrite contextualRecordWrite = (ContextualRecordWrite) o;
    return Objects.equals(this.parentValues, contextualRecordWrite.parentValues) &&
        Objects.equals(this.values, contextualRecordWrite.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentValues, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextualRecordWrite {\n");
    
    sb.append("    parentValues: ").append(toIndentedString(parentValues)).append("\n");
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
