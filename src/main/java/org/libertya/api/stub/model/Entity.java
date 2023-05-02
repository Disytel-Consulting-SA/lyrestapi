package org.libertya.api.stub.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.SimpleMap;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Una entidad abarca un conjunto de maps clave-valor para cada uno de los campos que la componen
 */
@ApiModel(description = "Una entidad abarca un conjunto de maps clave-valor para cada uno de los campos que la componen")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-02T09:01:27.224-03:00[America/Argentina/Buenos_Aires]")
public class Entity extends ArrayList<SimpleMap>  {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Entity {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
