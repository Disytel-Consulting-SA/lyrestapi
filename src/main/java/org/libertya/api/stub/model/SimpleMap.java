package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Una simple map clave-valor
 */
@ApiModel(description = "Una simple map clave-valor")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-22T09:54:46.337-03:00[America/Argentina/Buenos_Aires]")
public class SimpleMap   {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("value")
  private String value = null;

  public SimpleMap key(String key) {
    this.key = key;
    return this;
  }

  /**
   * La clave de la map
   * @return key
  **/
  @ApiModelProperty(value = "La clave de la map")
  
    public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public SimpleMap value(String value) {
    this.value = value;
    return this;
  }

  /**
   * El valor de la map
   * @return value
  **/
  @ApiModelProperty(value = "El valor de la map")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleMap simpleMap = (SimpleMap) o;
    return Objects.equals(this.key, simpleMap.key) &&
        Objects.equals(this.value, simpleMap.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleMap {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
