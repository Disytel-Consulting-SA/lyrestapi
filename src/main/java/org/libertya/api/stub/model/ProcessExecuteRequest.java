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
 * Valores efectivos con los que debe ejecutarse un proceso.
 */
@Schema(description = "Valores efectivos con los que debe ejecutarse un proceso.")
@Validated



public class ProcessExecuteRequest   {
  @JsonProperty("table")
  private String table = null;

  @JsonProperty("record_id")
  private Integer recordId = null;

  @JsonProperty("values")
  @Valid
  private Map<String, String> values = null;

  @JsonProperty("values_to")
  @Valid
  private Map<String, String> valuesTo = null;

  public ProcessExecuteRequest table(String table) {
    this.table = table;
    return this;
  }

  /**
   * Tabla del registro origen, cuando el proceso fue invocado desde una ventana.
   * @return table
   **/
  @Schema(description = "Tabla del registro origen, cuando el proceso fue invocado desde una ventana.")
  
    public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public ProcessExecuteRequest recordId(Integer recordId) {
    this.recordId = recordId;
    return this;
  }

  /**
   * ID del registro origen, cuando corresponda.
   * @return recordId
   **/
  @Schema(description = "ID del registro origen, cuando corresponda.")
  
    public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public ProcessExecuteRequest values(Map<String, String> values) {
    this.values = values;
    return this;
  }

  public ProcessExecuteRequest putValuesItem(String key, String valuesItem) {
    if (this.values == null) {
      this.values = new HashMap<>();
    }
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Valores de parámetros indexados por ColumnName.
   * @return values
   **/
  @Schema(description = "Valores de parámetros indexados por ColumnName.")
  
    public Map<String, String> getValues() {
    return values;
  }

  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  public ProcessExecuteRequest valuesTo(Map<String, String> valuesTo) {
    this.valuesTo = valuesTo;
    return this;
  }

  public ProcessExecuteRequest putValuesToItem(String key, String valuesToItem) {
    if (this.valuesTo == null) {
      this.valuesTo = new HashMap<>();
    }
    this.valuesTo.put(key, valuesToItem);
    return this;
  }

  /**
   * Segundos valores de parámetros de rango indexados por ColumnName.
   * @return valuesTo
   **/
  @Schema(description = "Segundos valores de parámetros de rango indexados por ColumnName.")
  
    public Map<String, String> getValuesTo() {
    return valuesTo;
  }

  public void setValuesTo(Map<String, String> valuesTo) {
    this.valuesTo = valuesTo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessExecuteRequest processExecuteRequest = (ProcessExecuteRequest) o;
    return Objects.equals(this.table, processExecuteRequest.table) &&
        Objects.equals(this.recordId, processExecuteRequest.recordId) &&
        Objects.equals(this.values, processExecuteRequest.values) &&
        Objects.equals(this.valuesTo, processExecuteRequest.valuesTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(table, recordId, values, valuesTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessExecuteRequest {\n");
    
    sb.append("    table: ").append(toIndentedString(table)).append("\n");
    sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    valuesTo: ").append(toIndentedString(valuesTo)).append("\n");
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
