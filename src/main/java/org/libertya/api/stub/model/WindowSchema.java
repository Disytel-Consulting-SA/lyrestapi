package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.WindowSchemaTab;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WindowSchema
 */
@Validated



public class WindowSchema   {
  @JsonProperty("ad_window_id")
  private Integer adWindowId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("tabs")
  @Valid
  private List<WindowSchemaTab> tabs = null;

  public WindowSchema adWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
    return this;
  }

  /**
   * Get adWindowId
   * @return adWindowId
   **/
  @Schema(description = "")
  
    public Integer getAdWindowId() {
    return adWindowId;
  }

  public void setAdWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
  }

  public WindowSchema name(String name) {
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

  public WindowSchema description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public WindowSchema tabs(List<WindowSchemaTab> tabs) {
    this.tabs = tabs;
    return this;
  }

  public WindowSchema addTabsItem(WindowSchemaTab tabsItem) {
    if (this.tabs == null) {
      this.tabs = new ArrayList<>();
    }
    this.tabs.add(tabsItem);
    return this;
  }

  /**
   * Get tabs
   * @return tabs
   **/
  @Schema(description = "")
      @Valid
    public List<WindowSchemaTab> getTabs() {
    return tabs;
  }

  public void setTabs(List<WindowSchemaTab> tabs) {
    this.tabs = tabs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowSchema windowSchema = (WindowSchema) o;
    return Objects.equals(this.adWindowId, windowSchema.adWindowId) &&
        Objects.equals(this.name, windowSchema.name) &&
        Objects.equals(this.description, windowSchema.description) &&
        Objects.equals(this.tabs, windowSchema.tabs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adWindowId, name, description, tabs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowSchema {\n");
    
    sb.append("    adWindowId: ").append(toIndentedString(adWindowId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tabs: ").append(toIndentedString(tabs)).append("\n");
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
