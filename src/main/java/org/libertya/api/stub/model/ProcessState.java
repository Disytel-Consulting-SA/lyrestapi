package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.libertya.api.stub.model.ProcessParameterState;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Estado efectivo de los parámetros de un proceso resuelto por el backend. El frontend debe representarlo sin interpretar expresiones de metadata de Libertya. 
 */
@Schema(description = "Estado efectivo de los parámetros de un proceso resuelto por el backend. El frontend debe representarlo sin interpretar expresiones de metadata de Libertya. ")
@Validated



public class ProcessState   {
  @JsonProperty("values")
  @Valid
  private Map<String, String> values = null;

  @JsonProperty("parameters")
  @Valid
  private List<ProcessParameterState> parameters = null;

  public ProcessState values(Map<String, String> values) {
    this.values = values;
    return this;
  }

  public ProcessState putValuesItem(String key, String valuesItem) {
    if (this.values == null) {
      this.values = new HashMap<>();
    }
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Valores efectivos de los parámetros indexados por ColumnName. 
   * @return values
   **/
  @Schema(description = "Valores efectivos de los parámetros indexados por ColumnName. ")
  
    public Map<String, String> getValues() {
    return values;
  }

  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  public ProcessState parameters(List<ProcessParameterState> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ProcessState addParametersItem(ProcessParameterState parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

  /**
   * Get parameters
   * @return parameters
   **/
  @Schema(description = "")
      @Valid
    public List<ProcessParameterState> getParameters() {
    return parameters;
  }

  public void setParameters(List<ProcessParameterState> parameters) {
    this.parameters = parameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessState processState = (ProcessState) o;
    return Objects.equals(this.values, processState.values) &&
        Objects.equals(this.parameters, processState.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessState {\n");
    
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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
