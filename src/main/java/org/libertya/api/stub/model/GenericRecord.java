package org.libertya.api.stub.model;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Registro de una tabla cualquiera de AD_Table, como un objeto JSON plano con una clave por columna. En la salida las claves son el nombre de columna en minuscula (c_bpartner_id, dateacct). En la entrada se acepta ademas la forma normalizada sin guiones bajos (cbpartnerid). Las columnas en null no se incluyen en la salida. Si la API esta configurada con valores referenciados, la salida incluye ademas la clave referencedvalues con pares key/value. 
 */
@Schema(description = "Registro de una tabla cualquiera de AD_Table, como un objeto JSON plano con una clave por columna. En la salida las claves son el nombre de columna en minuscula (c_bpartner_id, dateacct). En la entrada se acepta ademas la forma normalizada sin guiones bajos (cbpartnerid). Las columnas en null no se incluyen en la salida. Si la API esta configurada con valores referenciados, la salida incluye ademas la clave referencedvalues con pares key/value. ")
@Validated



public class GenericRecord extends HashMap<String, Object>  {

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
    sb.append("class GenericRecord {\n");
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
