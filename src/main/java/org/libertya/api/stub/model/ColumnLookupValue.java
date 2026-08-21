package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ColumnLookupValue
 */
@Validated



public class ColumnLookupValue   {
  @JsonProperty("value")
  private String value = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  public ColumnLookupValue value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Valor real almacenado en la columna
   * @return value
   **/
  @Schema(description = "Valor real almacenado en la columna")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ColumnLookupValue name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Descripción visible asociada al valor
   * @return name
   **/
  @Schema(description = "Descripción visible asociada al valor")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ColumnLookupValue isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Indica si el registro referenciado está activo
   * @return isactive
   **/
  @Schema(description = "Indica si el registro referenciado está activo")
  
    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColumnLookupValue columnLookupValue = (ColumnLookupValue) o;
    return Objects.equals(this.value, columnLookupValue.value) &&
        Objects.equals(this.name, columnLookupValue.name) &&
        Objects.equals(this.isactive, columnLookupValue.isactive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, name, isactive);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColumnLookupValue {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
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
