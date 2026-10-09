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
 * Contexto necesario para construir o reevaluar el estado dinámico de los parámetros de un proceso. 
 */
@Schema(description = "Contexto necesario para construir o reevaluar el estado dinámico de los parámetros de un proceso. ")
@Validated



public class ProcessStateRequest   {
  @JsonProperty("table")
  private String table = null;

  @JsonProperty("record_id")
  private Integer recordId = null;

  @JsonProperty("values")
  @Valid
  private Map<String, String> values = null;

  @JsonProperty("changed_parameters")
  @Valid
  private List<String> changedParameters = null;

  public ProcessStateRequest table(String table) {
    this.table = table;
    return this;
  }

  /**
   * Tabla del registro desde el cual se invoca el proceso. Permite al backend reconstruir el contexto de la ventana sin delegar esa responsabilidad al frontend. 
   * @return table
   **/
  @Schema(description = "Tabla del registro desde el cual se invoca el proceso. Permite al backend reconstruir el contexto de la ventana sin delegar esa responsabilidad al frontend. ")
  
    public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public ProcessStateRequest recordId(Integer recordId) {
    this.recordId = recordId;
    return this;
  }

  /**
   * ID del registro desde el cual se invoca el proceso.
   * @return recordId
   **/
  @Schema(description = "ID del registro desde el cual se invoca el proceso.")
  
    public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public ProcessStateRequest values(Map<String, String> values) {
    this.values = values;
    return this;
  }

  public ProcessStateRequest putValuesItem(String key, String valuesItem) {
    if (this.values == null) {
      this.values = new HashMap<>();
    }
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Valores actuales de los parámetros del proceso indexados por ColumnName. Se superponen al contexto del registro origen. 
   * @return values
   **/
  @Schema(description = "Valores actuales de los parámetros del proceso indexados por ColumnName. Se superponen al contexto del registro origen. ")
  
    public Map<String, String> getValues() {
    return values;
  }

  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  public ProcessStateRequest changedParameters(List<String> changedParameters) {
    this.changedParameters = changedParameters;
    return this;
  }

  public ProcessStateRequest addChangedParametersItem(String changedParametersItem) {
    if (this.changedParameters == null) {
      this.changedParameters = new ArrayList<>();
    }
    this.changedParameters.add(changedParametersItem);
    return this;
  }

  /**
   * Parámetros modificados desde la evaluación anterior. Reservado para la ejecución incremental de callouts y dependencias. 
   * @return changedParameters
   **/
  @Schema(description = "Parámetros modificados desde la evaluación anterior. Reservado para la ejecución incremental de callouts y dependencias. ")
  
    public List<String> getChangedParameters() {
    return changedParameters;
  }

  public void setChangedParameters(List<String> changedParameters) {
    this.changedParameters = changedParameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessStateRequest processStateRequest = (ProcessStateRequest) o;
    return Objects.equals(this.table, processStateRequest.table) &&
        Objects.equals(this.recordId, processStateRequest.recordId) &&
        Objects.equals(this.values, processStateRequest.values) &&
        Objects.equals(this.changedParameters, processStateRequest.changedParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(table, recordId, values, changedParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessStateRequest {\n");
    
    sb.append("    table: ").append(toIndentedString(table)).append("\n");
    sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    changedParameters: ").append(toIndentedString(changedParameters)).append("\n");
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
