package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Estado efectivo de un campo de la pestaña, resuelto por el backend. El frontend debe utilizar este estado sin interpretar las expresiones de metadata que lo originaron. 
 */
@Schema(description = "Estado efectivo de un campo de la pestaña, resuelto por el backend. El frontend debe utilizar este estado sin interpretar las expresiones de metadata que lo originaron. ")
@Validated



public class WindowRecordFieldState   {
  @JsonProperty("ad_field_id")
  private Integer adFieldId = null;

  @JsonProperty("columnname")
  private String columnname = null;

  @JsonProperty("displayed")
  private Boolean displayed = null;

  @JsonProperty("readonly")
  private Boolean readonly = null;

  public WindowRecordFieldState adFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
    return this;
  }

  /**
   * ID del campo de Libertya.
   * @return adFieldId
   **/
  @Schema(description = "ID del campo de Libertya.")
  
    public Integer getAdFieldId() {
    return adFieldId;
  }

  public void setAdFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
  }

  public WindowRecordFieldState columnname(String columnname) {
    this.columnname = columnname;
    return this;
  }

  /**
   * Nombre de la columna asociada al campo.
   * @return columnname
   **/
  @Schema(description = "Nombre de la columna asociada al campo.")
  
    public String getColumnname() {
    return columnname;
  }

  public void setColumnname(String columnname) {
    this.columnname = columnname;
  }

  public WindowRecordFieldState displayed(Boolean displayed) {
    this.displayed = displayed;
    return this;
  }

  /**
   * Indica si el campo debe ser mostrado por el frontend. 
   * @return displayed
   **/
  @Schema(description = "Indica si el campo debe ser mostrado por el frontend. ")
  
    public Boolean isDisplayed() {
    return displayed;
  }

  public void setDisplayed(Boolean displayed) {
    this.displayed = displayed;
  }

  public WindowRecordFieldState readonly(Boolean readonly) {
    this.readonly = readonly;
    return this;
  }

  /**
   * Indica si el campo debe ser tratado como solo lectura por el frontend.
   * @return readonly
   **/
  @Schema(description = "Indica si el campo debe ser tratado como solo lectura por el frontend.")
  
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
    WindowRecordFieldState windowRecordFieldState = (WindowRecordFieldState) o;
    return Objects.equals(this.adFieldId, windowRecordFieldState.adFieldId) &&
        Objects.equals(this.columnname, windowRecordFieldState.columnname) &&
        Objects.equals(this.displayed, windowRecordFieldState.displayed) &&
        Objects.equals(this.readonly, windowRecordFieldState.readonly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adFieldId, columnname, displayed, readonly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowRecordFieldState {\n");
    
    sb.append("    adFieldId: ").append(toIndentedString(adFieldId)).append("\n");
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
