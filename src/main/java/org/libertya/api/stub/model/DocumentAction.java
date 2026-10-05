package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DocumentAction
 */
@Validated



public class DocumentAction   {
  @JsonProperty("value")
  private String value = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  public DocumentAction value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Codigo de la accion de documento
   * @return value
   **/
  @Schema(example = "CO", required = true, description = "Codigo de la accion de documento")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public DocumentAction name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nombre localizado de la accion
   * @return name
   **/
  @Schema(example = "Completar", required = true, description = "Nombre localizado de la accion")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DocumentAction description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripcion localizada de la accion
   * @return description
   **/
  @Schema(example = "Completar el documento", description = "Descripcion localizada de la accion")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentAction documentAction = (DocumentAction) o;
    return Objects.equals(this.value, documentAction.value) &&
        Objects.equals(this.name, documentAction.name) &&
        Objects.equals(this.description, documentAction.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentAction {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
