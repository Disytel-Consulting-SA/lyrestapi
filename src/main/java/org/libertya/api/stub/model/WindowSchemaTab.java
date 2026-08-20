package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.WindowSchemaField;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WindowSchemaTab
 */
@Validated



public class WindowSchemaTab   {
  @JsonProperty("data_endpoint")
  private String dataEndpoint = null;

  @JsonProperty("ad_tab_id")
  private Integer adTabId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("seqno")
  private Integer seqno = null;

  @JsonProperty("tablevel")
  private Integer tablevel = null;

  @JsonProperty("isreadonly")
  private Boolean isreadonly = null;

  @JsonProperty("ad_table_id")
  private Integer adTableId = null;

  @JsonProperty("tablename")
  private String tablename = null;

  @JsonProperty("whereclause")
  private String whereclause = null;

  @JsonProperty("orderbyclause")
  private String orderbyclause = null;

  @JsonProperty("parent_ad_tab_id")
  private Integer parentAdTabId = null;

  @JsonProperty("link_columnname")
  private String linkColumnname = null;

  @JsonProperty("fields")
  @Valid
  private List<WindowSchemaField> fields = null;

  public WindowSchemaTab dataEndpoint(String dataEndpoint) {
    this.dataEndpoint = dataEndpoint;
    return this;
  }

  /**
   * Endpoint REST utilizado para recuperar registros de la tabla
   * @return dataEndpoint
   **/
  @Schema(description = "Endpoint REST utilizado para recuperar registros de la tabla")
  
    public String getDataEndpoint() {
    return dataEndpoint;
  }

  public void setDataEndpoint(String dataEndpoint) {
    this.dataEndpoint = dataEndpoint;
  }

  public WindowSchemaTab adTabId(Integer adTabId) {
    this.adTabId = adTabId;
    return this;
  }

  /**
   * Get adTabId
   * @return adTabId
   **/
  @Schema(description = "")
  
    public Integer getAdTabId() {
    return adTabId;
  }

  public void setAdTabId(Integer adTabId) {
    this.adTabId = adTabId;
  }

  public WindowSchemaTab name(String name) {
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

  public WindowSchemaTab description(String description) {
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

  public WindowSchemaTab seqno(Integer seqno) {
    this.seqno = seqno;
    return this;
  }

  /**
   * Get seqno
   * @return seqno
   **/
  @Schema(description = "")
  
    public Integer getSeqno() {
    return seqno;
  }

  public void setSeqno(Integer seqno) {
    this.seqno = seqno;
  }

  public WindowSchemaTab tablevel(Integer tablevel) {
    this.tablevel = tablevel;
    return this;
  }

  /**
   * Get tablevel
   * @return tablevel
   **/
  @Schema(description = "")
  
    public Integer getTablevel() {
    return tablevel;
  }

  public void setTablevel(Integer tablevel) {
    this.tablevel = tablevel;
  }

  public WindowSchemaTab isreadonly(Boolean isreadonly) {
    this.isreadonly = isreadonly;
    return this;
  }

  /**
   * Get isreadonly
   * @return isreadonly
   **/
  @Schema(description = "")
  
    public Boolean isIsreadonly() {
    return isreadonly;
  }

  public void setIsreadonly(Boolean isreadonly) {
    this.isreadonly = isreadonly;
  }

  public WindowSchemaTab adTableId(Integer adTableId) {
    this.adTableId = adTableId;
    return this;
  }

  /**
   * Get adTableId
   * @return adTableId
   **/
  @Schema(description = "")
  
    public Integer getAdTableId() {
    return adTableId;
  }

  public void setAdTableId(Integer adTableId) {
    this.adTableId = adTableId;
  }

  public WindowSchemaTab tablename(String tablename) {
    this.tablename = tablename;
    return this;
  }

  /**
   * Get tablename
   * @return tablename
   **/
  @Schema(description = "")
  
    public String getTablename() {
    return tablename;
  }

  public void setTablename(String tablename) {
    this.tablename = tablename;
  }

  public WindowSchemaTab whereclause(String whereclause) {
    this.whereclause = whereclause;
    return this;
  }

  /**
   * Get whereclause
   * @return whereclause
   **/
  @Schema(description = "")
  
    public String getWhereclause() {
    return whereclause;
  }

  public void setWhereclause(String whereclause) {
    this.whereclause = whereclause;
  }

  public WindowSchemaTab orderbyclause(String orderbyclause) {
    this.orderbyclause = orderbyclause;
    return this;
  }

  /**
   * Get orderbyclause
   * @return orderbyclause
   **/
  @Schema(description = "")
  
    public String getOrderbyclause() {
    return orderbyclause;
  }

  public void setOrderbyclause(String orderbyclause) {
    this.orderbyclause = orderbyclause;
  }

  public WindowSchemaTab parentAdTabId(Integer parentAdTabId) {
    this.parentAdTabId = parentAdTabId;
    return this;
  }

  /**
   * Get parentAdTabId
   * @return parentAdTabId
   **/
  @Schema(description = "")
  
    public Integer getParentAdTabId() {
    return parentAdTabId;
  }

  public void setParentAdTabId(Integer parentAdTabId) {
    this.parentAdTabId = parentAdTabId;
  }

  public WindowSchemaTab linkColumnname(String linkColumnname) {
    this.linkColumnname = linkColumnname;
    return this;
  }

  /**
   * Get linkColumnname
   * @return linkColumnname
   **/
  @Schema(description = "")
  
    public String getLinkColumnname() {
    return linkColumnname;
  }

  public void setLinkColumnname(String linkColumnname) {
    this.linkColumnname = linkColumnname;
  }

  public WindowSchemaTab fields(List<WindowSchemaField> fields) {
    this.fields = fields;
    return this;
  }

  public WindowSchemaTab addFieldsItem(WindowSchemaField fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

  /**
   * Get fields
   * @return fields
   **/
  @Schema(description = "")
      @Valid
    public List<WindowSchemaField> getFields() {
    return fields;
  }

  public void setFields(List<WindowSchemaField> fields) {
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
    WindowSchemaTab windowSchemaTab = (WindowSchemaTab) o;
    return Objects.equals(this.dataEndpoint, windowSchemaTab.dataEndpoint) &&
        Objects.equals(this.adTabId, windowSchemaTab.adTabId) &&
        Objects.equals(this.name, windowSchemaTab.name) &&
        Objects.equals(this.description, windowSchemaTab.description) &&
        Objects.equals(this.seqno, windowSchemaTab.seqno) &&
        Objects.equals(this.tablevel, windowSchemaTab.tablevel) &&
        Objects.equals(this.isreadonly, windowSchemaTab.isreadonly) &&
        Objects.equals(this.adTableId, windowSchemaTab.adTableId) &&
        Objects.equals(this.tablename, windowSchemaTab.tablename) &&
        Objects.equals(this.whereclause, windowSchemaTab.whereclause) &&
        Objects.equals(this.orderbyclause, windowSchemaTab.orderbyclause) &&
        Objects.equals(this.parentAdTabId, windowSchemaTab.parentAdTabId) &&
        Objects.equals(this.linkColumnname, windowSchemaTab.linkColumnname) &&
        Objects.equals(this.fields, windowSchemaTab.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataEndpoint, adTabId, name, description, seqno, tablevel, isreadonly, adTableId, tablename, whereclause, orderbyclause, parentAdTabId, linkColumnname, fields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowSchemaTab {\n");
    
    sb.append("    dataEndpoint: ").append(toIndentedString(dataEndpoint)).append("\n");
    sb.append("    adTabId: ").append(toIndentedString(adTabId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
    sb.append("    tablevel: ").append(toIndentedString(tablevel)).append("\n");
    sb.append("    isreadonly: ").append(toIndentedString(isreadonly)).append("\n");
    sb.append("    adTableId: ").append(toIndentedString(adTableId)).append("\n");
    sb.append("    tablename: ").append(toIndentedString(tablename)).append("\n");
    sb.append("    whereclause: ").append(toIndentedString(whereclause)).append("\n");
    sb.append("    orderbyclause: ").append(toIndentedString(orderbyclause)).append("\n");
    sb.append("    parentAdTabId: ").append(toIndentedString(parentAdTabId)).append("\n");
    sb.append("    linkColumnname: ").append(toIndentedString(linkColumnname)).append("\n");
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
