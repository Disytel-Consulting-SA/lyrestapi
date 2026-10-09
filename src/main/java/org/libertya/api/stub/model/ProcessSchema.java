package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.ProcessSchemaParameter;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProcessSchema
 */
@Validated



public class ProcessSchema   {
  @JsonProperty("process_id")
  private Integer processId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("parameters")
  @Valid
  private List<ProcessSchemaParameter> parameters = null;

  public ProcessSchema processId(Integer processId) {
    this.processId = processId;
    return this;
  }

  /**
   * Get processId
   * @return processId
   **/
  @Schema(description = "")
  
    public Integer getProcessId() {
    return processId;
  }

  public void setProcessId(Integer processId) {
    this.processId = processId;
  }

  public ProcessSchema name(String name) {
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

  public ProcessSchema description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProcessSchema help(String help) {
    this.help = help;
    return this;
  }

  /**
   * Get help
   * @return help
   **/
  @Schema(description = "")
  
    public String getHelp() {
    return help;
  }

  public void setHelp(String help) {
    this.help = help;
  }

  public ProcessSchema parameters(List<ProcessSchemaParameter> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ProcessSchema addParametersItem(ProcessSchemaParameter parametersItem) {
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
    public List<ProcessSchemaParameter> getParameters() {
    return parameters;
  }

  public void setParameters(List<ProcessSchemaParameter> parameters) {
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
    ProcessSchema processSchema = (ProcessSchema) o;
    return Objects.equals(this.processId, processSchema.processId) &&
        Objects.equals(this.name, processSchema.name) &&
        Objects.equals(this.description, processSchema.description) &&
        Objects.equals(this.help, processSchema.help) &&
        Objects.equals(this.parameters, processSchema.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processId, name, description, help, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessSchema {\n");
    
    sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
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
