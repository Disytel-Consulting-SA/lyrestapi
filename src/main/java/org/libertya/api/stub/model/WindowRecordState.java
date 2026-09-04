package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.libertya.api.stub.model.WindowRecordFieldState;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Estado efectivo de un registro dinámico resuelto completamente por el backend. 
 */
@Schema(description = "Estado efectivo de un registro dinámico resuelto completamente por el backend. ")
@Validated



public class WindowRecordState   {
  @JsonProperty("values")
  @Valid
  private Map<String, String> values = null;

  @JsonProperty("fields")
  @Valid
  private List<WindowRecordFieldState> fields = null;

  public WindowRecordState values(Map<String, String> values) {
    this.values = values;
    return this;
  }

  public WindowRecordState putValuesItem(String key, String valuesItem) {
    if (this.values == null) {
      this.values = new HashMap<>();
    }
    this.values.put(key, valuesItem);
    return this;
  }

  /**
   * Valores efectivos del registro indexados por nombre de columna. Los valores se representan uniformemente como strings. 
   * @return values
   **/
  @Schema(description = "Valores efectivos del registro indexados por nombre de columna. Los valores se representan uniformemente como strings. ")
  
    public Map<String, String> getValues() {
    return values;
  }

  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  public WindowRecordState fields(List<WindowRecordFieldState> fields) {
    this.fields = fields;
    return this;
  }

  public WindowRecordState addFieldsItem(WindowRecordFieldState fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

  /**
   * Estado efectivo de todos los campos de la pestaña.
   * @return fields
   **/
  @Schema(description = "Estado efectivo de todos los campos de la pestaña.")
      @Valid
    public List<WindowRecordFieldState> getFields() {
    return fields;
  }

  public void setFields(List<WindowRecordFieldState> fields) {
    this.fields = fields;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowRecordState windowRecordState = (WindowRecordState) o;
    return Objects.equals(this.values, windowRecordState.values) &&
        Objects.equals(this.fields, windowRecordState.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values, fields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowRecordState {\n");
    
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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
