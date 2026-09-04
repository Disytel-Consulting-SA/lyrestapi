package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Contexto de valores utilizado para construir o reevaluar el estado dinámico de un registro. 
 */
@Schema(description = "Contexto de valores utilizado para construir o reevaluar el estado dinámico de un registro. ")
@Validated



public class WindowRecordStateRequest   {
  @JsonProperty("values")
  @Valid
  private Map<String, String> values = null;

  @JsonProperty("parent_values")
  @Valid
  private Map<String, String> parentValues = null;

  @JsonProperty("changed_columns")
  @Valid
  private List<String> changedColumns = null;

  public WindowRecordStateRequest values(Map<String, String> values) {
    this.values = values;
    return this;
  }

  public WindowRecordStateRequest putValuesItem(String key, String valuesItem) {
    if (this.values == null) {
      this.values = new HashMap<>();
    }
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Valores actuales del registro indexados por nombre de columna. Los valores se representan uniformemente como strings. Se utilizará principalmente al reevaluar DisplayLogic y ReadOnlyLogic. 
   * @return values
   **/
  @Schema(description = "Valores actuales del registro indexados por nombre de columna. Los valores se representan uniformemente como strings. Se utilizará principalmente al reevaluar DisplayLogic y ReadOnlyLogic. ")
  
    public Map<String, String> getValues() {
    return values;
  }

  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  public WindowRecordStateRequest parentValues(Map<String, String> parentValues) {
    this.parentValues = parentValues;
    return this;
  }

  public WindowRecordStateRequest putParentValuesItem(String key, String parentValuesItem) {
    if (this.parentValues == null) {
      this.parentValues = new HashMap<>();
    }
    this.parentValues.put(key, parentValuesItem);
    return this;
  }

  /**
   * Valores provenientes del registro padre para pestañas master/detail, indexados por nombre de columna. Los valores se representan uniformemente como strings. 
   * @return parentValues
   **/
  @Schema(description = "Valores provenientes del registro padre para pestañas master/detail, indexados por nombre de columna. Los valores se representan uniformemente como strings. ")
  
    public Map<String, String> getParentValues() {
    return parentValues;
  }

  public void setParentValues(Map<String, String> parentValues) {
    this.parentValues = parentValues;
  }

  public WindowRecordStateRequest changedColumns(List<String> changedColumns) {
    this.changedColumns = changedColumns;
    return this;
  }

  public WindowRecordStateRequest addChangedColumnsItem(String changedColumnsItem) {
    if (this.changedColumns == null) {
      this.changedColumns = new ArrayList<>();
    }
    this.changedColumns.add(changedColumnsItem);
    return this;
  }

  /**
   * Columnas modificadas desde la evaluación anterior. Reservado para reevaluaciones incrementales. 
   * @return changedColumns
   **/
  @Schema(description = "Columnas modificadas desde la evaluación anterior. Reservado para reevaluaciones incrementales. ")
  
    public List<String> getChangedColumns() {
    return changedColumns;
  }

  public void setChangedColumns(List<String> changedColumns) {
    this.changedColumns = changedColumns;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowRecordStateRequest windowRecordStateRequest = (WindowRecordStateRequest) o;
    return Objects.equals(this.values, windowRecordStateRequest.values) &&
        Objects.equals(this.parentValues, windowRecordStateRequest.parentValues) &&
        Objects.equals(this.changedColumns, windowRecordStateRequest.changedColumns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values, parentValues, changedColumns);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowRecordStateRequest {\n");
    
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    parentValues: ").append(toIndentedString(parentValues)).append("\n");
    sb.append("    changedColumns: ").append(toIndentedString(changedColumns)).append("\n");
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
