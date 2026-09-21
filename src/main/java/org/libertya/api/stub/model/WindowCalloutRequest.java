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
 * Estado actual del registro y cambio de campo que origina la ejecucion del callout. 
 */
@Schema(description = "Estado actual del registro y cambio de campo que origina la ejecucion del callout. ")
@Validated



public class WindowCalloutRequest   {
  @JsonProperty("ad_field_id")
  private Integer adFieldId = null;

  @JsonProperty("record_id")
  private Integer recordId = null;

  @JsonProperty("value")
  private Object value = null;

  @JsonProperty("values")
  @Valid
  private Map<String, Object> values = new HashMap<>();

  @JsonProperty("inserting")
  private Boolean inserting = false;

  public WindowCalloutRequest adFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
    return this;
  }

  /**
   * ID del campo modificado.
   * @return adFieldId
   **/
  @Schema(required = true, description = "ID del campo modificado.")
      @NotNull

    public Integer getAdFieldId() {
    return adFieldId;
  }

  public void setAdFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
  }

  public WindowCalloutRequest recordId(Integer recordId) {
    this.recordId = recordId;
    return this;
  }

  /**
   * Get recordId
   * @return recordId
   **/
  @Schema(description = "")
  
    public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public WindowCalloutRequest value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * Nuevo valor asignado al campo.
   * @return value
   **/
  @Schema(description = "Nuevo valor asignado al campo.")
  
    public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public WindowCalloutRequest values(Map<String, Object> values) {
    this.values = values;
    return this;
  }

  public WindowCalloutRequest putValuesItem(String key, Object valuesItem) {
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Valores actuales del registro indexados por nombre de columna.
   * @return values
   **/
  @Schema(required = true, description = "Valores actuales del registro indexados por nombre de columna.")
      @NotNull

    public Map<String, Object> getValues() {
    return values;
  }

  public void setValues(Map<String, Object> values) {
    this.values = values;
  }

  public WindowCalloutRequest inserting(Boolean inserting) {
    this.inserting = inserting;
    return this;
  }

  /**
   * Debe ser true; la ejecucion sobre registros existentes aun no esta disponible.
   * @return inserting
   **/
  @Schema(description = "Debe ser true; la ejecucion sobre registros existentes aun no esta disponible.")
  
    public Boolean isInserting() {
    return inserting;
  }

  public void setInserting(Boolean inserting) {
    this.inserting = inserting;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowCalloutRequest windowCalloutRequest = (WindowCalloutRequest) o;
    return Objects.equals(this.adFieldId, windowCalloutRequest.adFieldId) &&
        Objects.equals(this.recordId, windowCalloutRequest.recordId) &&
        Objects.equals(this.value, windowCalloutRequest.value) &&
        Objects.equals(this.values, windowCalloutRequest.values) &&
        Objects.equals(this.inserting, windowCalloutRequest.inserting);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adFieldId, recordId, value, values, inserting);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowCalloutRequest {\n");
    
    sb.append("    adFieldId: ").append(toIndentedString(adFieldId)).append("\n");
    sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    inserting: ").append(toIndentedString(inserting)).append("\n");
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
