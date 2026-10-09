package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Estado efectivo de un parámetro del proceso.
 */
@Schema(description = "Estado efectivo de un parámetro del proceso.")
@Validated



public class ProcessParameterState   {
  @JsonProperty("process_para_id")
  private Integer processParaId = null;

  @JsonProperty("columnname")
  private String columnname = null;

  @JsonProperty("displayed")
  private Boolean displayed = null;

  @JsonProperty("readonly")
  private Boolean readonly = null;

  public ProcessParameterState processParaId(Integer processParaId) {
    this.processParaId = processParaId;
    return this;
  }

  /**
   * Get processParaId
   * @return processParaId
   **/
  @Schema(description = "")
  
    public Integer getProcessParaId() {
    return processParaId;
  }

  public void setProcessParaId(Integer processParaId) {
    this.processParaId = processParaId;
  }

  public ProcessParameterState columnname(String columnname) {
    this.columnname = columnname;
    return this;
  }

  /**
   * Get columnname
   * @return columnname
   **/
  @Schema(description = "")
  
    public String getColumnname() {
    return columnname;
  }

  public void setColumnname(String columnname) {
    this.columnname = columnname;
  }

  public ProcessParameterState displayed(Boolean displayed) {
    this.displayed = displayed;
    return this;
  }

  /**
   * Get displayed
   * @return displayed
   **/
  @Schema(description = "")
  
    public Boolean isDisplayed() {
    return displayed;
  }

  public void setDisplayed(Boolean displayed) {
    this.displayed = displayed;
  }

  public ProcessParameterState readonly(Boolean readonly) {
    this.readonly = readonly;
    return this;
  }

  /**
   * Get readonly
   * @return readonly
   **/
  @Schema(description = "")
  
    public Boolean isReadonly() {
    return readonly;
  }

  public void setReadonly(Boolean readonly) {
    this.readonly = readonly;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessParameterState processParameterState = (ProcessParameterState) o;
    return Objects.equals(this.processParaId, processParameterState.processParaId) &&
        Objects.equals(this.columnname, processParameterState.columnname) &&
        Objects.equals(this.displayed, processParameterState.displayed) &&
        Objects.equals(this.readonly, processParameterState.readonly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processParaId, columnname, displayed, readonly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessParameterState {\n");
    
    sb.append("    processParaId: ").append(toIndentedString(processParaId)).append("\n");
    sb.append("    columnname: ").append(toIndentedString(columnname)).append("\n");
    sb.append("    displayed: ").append(toIndentedString(displayed)).append("\n");
    sb.append("    readonly: ").append(toIndentedString(readonly)).append("\n");
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
