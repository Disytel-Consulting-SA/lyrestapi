package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProcessExecuteResponse
 */
@Validated



public class ProcessExecuteResponse   {
  @JsonProperty("process_instance_id")
  private Integer processInstanceId = null;

  @JsonProperty("success")
  private Boolean success = null;

  @JsonProperty("summary")
  private String summary = null;

  public ProcessExecuteResponse processInstanceId(Integer processInstanceId) {
    this.processInstanceId = processInstanceId;
    return this;
  }

  /**
   * Get processInstanceId
   * @return processInstanceId
   **/
  @Schema(description = "")
  
    public Integer getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(Integer processInstanceId) {
    this.processInstanceId = processInstanceId;
  }

  public ProcessExecuteResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Get success
   * @return success
   **/
  @Schema(description = "")
  
    public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public ProcessExecuteResponse summary(String summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Get summary
   * @return summary
   **/
  @Schema(description = "")
  
    public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessExecuteResponse processExecuteResponse = (ProcessExecuteResponse) o;
    return Objects.equals(this.processInstanceId, processExecuteResponse.processInstanceId) &&
        Objects.equals(this.success, processExecuteResponse.success) &&
        Objects.equals(this.summary, processExecuteResponse.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processInstanceId, success, summary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessExecuteResponse {\n");
    
    sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
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
