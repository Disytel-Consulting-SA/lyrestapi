package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WindowSchemaField
 */
@Validated



public class WindowSchemaField   {
  @JsonProperty("ad_field_id")
  private Integer adFieldId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("seqno")
  private Integer seqno = null;

  @JsonProperty("isdisplayed")
  private Boolean isdisplayed = null;

  @JsonProperty("ad_column_id")
  private Integer adColumnId = null;

  @JsonProperty("columnname")
  private String columnname = null;

  @JsonProperty("ad_reference_id")
  private Integer adReferenceId = null;

  @JsonProperty("ad_reference_value_id")
  private Integer adReferenceValueId = null;

  @JsonProperty("ismandatory")
  private Boolean ismandatory = null;

  @JsonProperty("iskey")
  private Boolean iskey = null;

  @JsonProperty("isparent")
  private Boolean isparent = null;

  public WindowSchemaField adFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
    return this;
  }

  /**
   * Get adFieldId
   * @return adFieldId
   **/
  @Schema(description = "")
  
    public Integer getAdFieldId() {
    return adFieldId;
  }

  public void setAdFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
  }

  public WindowSchemaField name(String name) {
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

  public WindowSchemaField description(String description) {
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

  public WindowSchemaField seqno(Integer seqno) {
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

  public WindowSchemaField isdisplayed(Boolean isdisplayed) {
    this.isdisplayed = isdisplayed;
    return this;
  }

  /**
   * Get isdisplayed
   * @return isdisplayed
   **/
  @Schema(description = "")
  
    public Boolean isIsdisplayed() {
    return isdisplayed;
  }

  public void setIsdisplayed(Boolean isdisplayed) {
    this.isdisplayed = isdisplayed;
  }

  public WindowSchemaField adColumnId(Integer adColumnId) {
    this.adColumnId = adColumnId;
    return this;
  }

  /**
   * Get adColumnId
   * @return adColumnId
   **/
  @Schema(description = "")
  
    public Integer getAdColumnId() {
    return adColumnId;
  }

  public void setAdColumnId(Integer adColumnId) {
    this.adColumnId = adColumnId;
  }

  public WindowSchemaField columnname(String columnname) {
    this.columnname = columnname;
    return this;
  }

  /**
   * Get columnname
   * @return columnname
   **/
  @Schema(description = "")
  
    public String getColumnname() {
    return columnname;
  }

  public void setColumnname(String columnname) {
    this.columnname = columnname;
  }

  public WindowSchemaField adReferenceId(Integer adReferenceId) {
    this.adReferenceId = adReferenceId;
    return this;
  }

  /**
   * Get adReferenceId
   * @return adReferenceId
   **/
  @Schema(description = "")
  
    public Integer getAdReferenceId() {
    return adReferenceId;
  }

  public void setAdReferenceId(Integer adReferenceId) {
    this.adReferenceId = adReferenceId;
  }

  public WindowSchemaField adReferenceValueId(Integer adReferenceValueId) {
    this.adReferenceValueId = adReferenceValueId;
    return this;
  }

  /**
   * Get adReferenceValueId
   * @return adReferenceValueId
   **/
  @Schema(description = "")
  
    public Integer getAdReferenceValueId() {
    return adReferenceValueId;
  }

  public void setAdReferenceValueId(Integer adReferenceValueId) {
    this.adReferenceValueId = adReferenceValueId;
  }

  public WindowSchemaField ismandatory(Boolean ismandatory) {
    this.ismandatory = ismandatory;
    return this;
  }

  /**
   * Get ismandatory
   * @return ismandatory
   **/
  @Schema(description = "")
  
    public Boolean isIsmandatory() {
    return ismandatory;
  }

  public void setIsmandatory(Boolean ismandatory) {
    this.ismandatory = ismandatory;
  }

  public WindowSchemaField iskey(Boolean iskey) {
    this.iskey = iskey;
    return this;
  }

  /**
   * Get iskey
   * @return iskey
   **/
  @Schema(description = "")
  
    public Boolean isIskey() {
    return iskey;
  }

  public void setIskey(Boolean iskey) {
    this.iskey = iskey;
  }

  public WindowSchemaField isparent(Boolean isparent) {
    this.isparent = isparent;
    return this;
  }

  /**
   * Get isparent
   * @return isparent
   **/
  @Schema(description = "")
  
    public Boolean isIsparent() {
    return isparent;
  }

  public void setIsparent(Boolean isparent) {
    this.isparent = isparent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowSchemaField windowSchemaField = (WindowSchemaField) o;
    return Objects.equals(this.adFieldId, windowSchemaField.adFieldId) &&
        Objects.equals(this.name, windowSchemaField.name) &&
        Objects.equals(this.description, windowSchemaField.description) &&
        Objects.equals(this.seqno, windowSchemaField.seqno) &&
        Objects.equals(this.isdisplayed, windowSchemaField.isdisplayed) &&
        Objects.equals(this.adColumnId, windowSchemaField.adColumnId) &&
        Objects.equals(this.columnname, windowSchemaField.columnname) &&
        Objects.equals(this.adReferenceId, windowSchemaField.adReferenceId) &&
        Objects.equals(this.adReferenceValueId, windowSchemaField.adReferenceValueId) &&
        Objects.equals(this.ismandatory, windowSchemaField.ismandatory) &&
        Objects.equals(this.iskey, windowSchemaField.iskey) &&
        Objects.equals(this.isparent, windowSchemaField.isparent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adFieldId, name, description, seqno, isdisplayed, adColumnId, columnname, adReferenceId, adReferenceValueId, ismandatory, iskey, isparent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowSchemaField {\n");
    
    sb.append("    adFieldId: ").append(toIndentedString(adFieldId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
    sb.append("    isdisplayed: ").append(toIndentedString(isdisplayed)).append("\n");
    sb.append("    adColumnId: ").append(toIndentedString(adColumnId)).append("\n");
    sb.append("    columnname: ").append(toIndentedString(columnname)).append("\n");
    sb.append("    adReferenceId: ").append(toIndentedString(adReferenceId)).append("\n");
    sb.append("    adReferenceValueId: ").append(toIndentedString(adReferenceValueId)).append("\n");
    sb.append("    ismandatory: ").append(toIndentedString(ismandatory)).append("\n");
    sb.append("    iskey: ").append(toIndentedString(iskey)).append("\n");
    sb.append("    isparent: ").append(toIndentedString(isparent)).append("\n");
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
