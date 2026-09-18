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
 * Resultado de la ejecucion del callout.
 */
@Schema(description = "Resultado de la ejecucion del callout.")
@Validated



public class WindowCalloutResponse   {
  @JsonProperty("changes")
  @Valid
  private Map<String, Object> changes = null;

  @JsonProperty("message")
  private String message = null;

  public WindowCalloutResponse changes(Map<String, Object> changes) {
    this.changes = changes;
    return this;
  }

  public WindowCalloutResponse putChangesItem(String key, Object changesItem) {
    if (this.changes == null) {
      this.changes = new HashMap<>();
    }
    this.changes.put(key, changesItem);
    return this;
  }

  /**
   * Valores modificados por el callout, indexados por nombre de columna.
   * @return changes
   **/
  @Schema(description = "Valores modificados por el callout, indexados por nombre de columna.")
  
    public Map<String, Object> getChanges() {
    return changes;
  }

  public void setChanges(Map<String, Object> changes) {
    this.changes = changes;
  }

  public WindowCalloutResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Mensaje eventualmente generado por el callout.
   * @return message
   **/
  @Schema(description = "Mensaje eventualmente generado por el callout.")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowCalloutResponse windowCalloutResponse = (WindowCalloutResponse) o;
    return Objects.equals(this.changes, windowCalloutResponse.changes) &&
        Objects.equals(this.message, windowCalloutResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(changes, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowCalloutResponse {\n");
    
    sb.append("    changes: ").append(toIndentedString(changes)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
