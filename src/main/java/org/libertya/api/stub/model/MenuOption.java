package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MenuOption
 */
@Validated



public class MenuOption   {
  @JsonProperty("ad_menu_id")
  private Integer adMenuId = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Tipo semántico de entrada disponible para el frontend.
   */
  public enum TypeEnum {
    WINDOW("window"),
    
    PROCESS("process");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("target_id")
  private Integer targetId = null;

  public MenuOption adMenuId(Integer adMenuId) {
    this.adMenuId = adMenuId;
    return this;
  }

  /**
   * Get adMenuId
   * @return adMenuId
   **/
  @Schema(description = "")
  
    public Integer getAdMenuId() {
    return adMenuId;
  }

  public void setAdMenuId(Integer adMenuId) {
    this.adMenuId = adMenuId;
  }

  public MenuOption name(String name) {
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

  public MenuOption type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Tipo semántico de entrada disponible para el frontend.
   * @return type
   **/
  @Schema(description = "Tipo semántico de entrada disponible para el frontend.")
  
    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public MenuOption targetId(Integer targetId) {
    this.targetId = targetId;
    return this;
  }

  /**
   * AD_Window_ID o AD_Process_ID según type.
   * @return targetId
   **/
  @Schema(description = "AD_Window_ID o AD_Process_ID según type.")
  
    public Integer getTargetId() {
    return targetId;
  }

  public void setTargetId(Integer targetId) {
    this.targetId = targetId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuOption menuOption = (MenuOption) o;
    return Objects.equals(this.adMenuId, menuOption.adMenuId) &&
        Objects.equals(this.name, menuOption.name) &&
        Objects.equals(this.type, menuOption.type) &&
        Objects.equals(this.targetId, menuOption.targetId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adMenuId, name, type, targetId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuOption {\n");
    
    sb.append("    adMenuId: ").append(toIndentedString(adMenuId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
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
