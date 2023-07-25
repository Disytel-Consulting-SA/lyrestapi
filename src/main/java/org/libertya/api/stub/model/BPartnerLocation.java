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
 * BPartnerLocation
 */
@Validated
public class BPartnerLocation   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_bpartner_location_id")
  private Integer cBpartnerLocationId = null;

  @JsonProperty("c_location_id")
  private Integer cLocationId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_salesregion_id")
  private Integer cSalesregionId = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("fax")
  private String fax = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isbillto")
  private Boolean isbillto = null;

  @JsonProperty("isdn")
  private String isdn = null;

  @JsonProperty("ispayfrom")
  private Boolean ispayfrom = null;

  @JsonProperty("isremitto")
  private Boolean isremitto = null;

  @JsonProperty("isshipto")
  private Boolean isshipto = null;

  @JsonProperty("istemporal")
  private Boolean istemporal = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("phone2")
  private String phone2 = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  public BPartnerLocation adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Get adClientId
   * @return adClientId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public BPartnerLocation adComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
    return this;
  }

  /**
   * Get adComponentobjectuid
   * @return adComponentobjectuid
  **/
  @ApiModelProperty(value = "")
  
    public String getAdComponentobjectuid() {
    return adComponentobjectuid;
  }

  public void setAdComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
  }

  public BPartnerLocation adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public BPartnerLocation cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Get cBpartnerId
   * @return cBpartnerId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public BPartnerLocation cBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
    return this;
  }

  /**
   * Get cBpartnerLocationId
   * @return cBpartnerLocationId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getCBpartnerLocationId() {
    return cBpartnerLocationId;
  }

  public void setCBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
  }

  public BPartnerLocation cLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
    return this;
  }

  /**
   * Get cLocationId
   * @return cLocationId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getCLocationId() {
    return cLocationId;
  }

  public void setCLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
  }

  public BPartnerLocation created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public BPartnerLocation createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Get createdby
   * @return createdby
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public BPartnerLocation cSalesregionId(Integer cSalesregionId) {
    this.cSalesregionId = cSalesregionId;
    return this;
  }

  /**
   * Get cSalesregionId
   * @return cSalesregionId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCSalesregionId() {
    return cSalesregionId;
  }

  public void setCSalesregionId(Integer cSalesregionId) {
    this.cSalesregionId = cSalesregionId;
  }

  public BPartnerLocation email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public BPartnerLocation fax(String fax) {
    this.fax = fax;
    return this;
  }

  /**
   * Get fax
   * @return fax
  **/
  @ApiModelProperty(value = "")
  
    public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public BPartnerLocation isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Get isactive
   * @return isactive
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public BPartnerLocation isbillto(Boolean isbillto) {
    this.isbillto = isbillto;
    return this;
  }

  /**
   * Get isbillto
   * @return isbillto
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsbillto() {
    return isbillto;
  }

  public void setIsbillto(Boolean isbillto) {
    this.isbillto = isbillto;
  }

  public BPartnerLocation isdn(String isdn) {
    this.isdn = isdn;
    return this;
  }

  /**
   * Get isdn
   * @return isdn
  **/
  @ApiModelProperty(value = "")
  
    public String getIsdn() {
    return isdn;
  }

  public void setIsdn(String isdn) {
    this.isdn = isdn;
  }

  public BPartnerLocation ispayfrom(Boolean ispayfrom) {
    this.ispayfrom = ispayfrom;
    return this;
  }

  /**
   * Get ispayfrom
   * @return ispayfrom
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIspayfrom() {
    return ispayfrom;
  }

  public void setIspayfrom(Boolean ispayfrom) {
    this.ispayfrom = ispayfrom;
  }

  public BPartnerLocation isremitto(Boolean isremitto) {
    this.isremitto = isremitto;
    return this;
  }

  /**
   * Get isremitto
   * @return isremitto
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsremitto() {
    return isremitto;
  }

  public void setIsremitto(Boolean isremitto) {
    this.isremitto = isremitto;
  }

  public BPartnerLocation isshipto(Boolean isshipto) {
    this.isshipto = isshipto;
    return this;
  }

  /**
   * Get isshipto
   * @return isshipto
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsshipto() {
    return isshipto;
  }

  public void setIsshipto(Boolean isshipto) {
    this.isshipto = isshipto;
  }

  public BPartnerLocation istemporal(Boolean istemporal) {
    this.istemporal = istemporal;
    return this;
  }

  /**
   * Get istemporal
   * @return istemporal
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIstemporal() {
    return istemporal;
  }

  public void setIstemporal(Boolean istemporal) {
    this.istemporal = istemporal;
  }

  public BPartnerLocation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BPartnerLocation phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")
  
    public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public BPartnerLocation phone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  /**
   * Get phone2
   * @return phone2
  **/
  @ApiModelProperty(value = "")
  
    public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public BPartnerLocation updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public BPartnerLocation updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Get updatedby
   * @return updatedby
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BPartnerLocation bpartnerLocation = (BPartnerLocation) o;
    return Objects.equals(this.adClientId, bpartnerLocation.adClientId) &&
        Objects.equals(this.adComponentobjectuid, bpartnerLocation.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, bpartnerLocation.adOrgId) &&
        Objects.equals(this.cBpartnerId, bpartnerLocation.cBpartnerId) &&
        Objects.equals(this.cBpartnerLocationId, bpartnerLocation.cBpartnerLocationId) &&
        Objects.equals(this.cLocationId, bpartnerLocation.cLocationId) &&
        Objects.equals(this.created, bpartnerLocation.created) &&
        Objects.equals(this.createdby, bpartnerLocation.createdby) &&
        Objects.equals(this.cSalesregionId, bpartnerLocation.cSalesregionId) &&
        Objects.equals(this.email, bpartnerLocation.email) &&
        Objects.equals(this.fax, bpartnerLocation.fax) &&
        Objects.equals(this.isactive, bpartnerLocation.isactive) &&
        Objects.equals(this.isbillto, bpartnerLocation.isbillto) &&
        Objects.equals(this.isdn, bpartnerLocation.isdn) &&
        Objects.equals(this.ispayfrom, bpartnerLocation.ispayfrom) &&
        Objects.equals(this.isremitto, bpartnerLocation.isremitto) &&
        Objects.equals(this.isshipto, bpartnerLocation.isshipto) &&
        Objects.equals(this.istemporal, bpartnerLocation.istemporal) &&
        Objects.equals(this.name, bpartnerLocation.name) &&
        Objects.equals(this.phone, bpartnerLocation.phone) &&
        Objects.equals(this.phone2, bpartnerLocation.phone2) &&
        Objects.equals(this.updated, bpartnerLocation.updated) &&
        Objects.equals(this.updatedby, bpartnerLocation.updatedby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, cBpartnerId, cBpartnerLocationId, cLocationId, created, createdby, cSalesregionId, email, fax, isactive, isbillto, isdn, ispayfrom, isremitto, isshipto, istemporal, name, phone, phone2, updated, updatedby);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BPartnerLocation {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cBpartnerLocationId: ").append(toIndentedString(cBpartnerLocationId)).append("\n");
    sb.append("    cLocationId: ").append(toIndentedString(cLocationId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cSalesregionId: ").append(toIndentedString(cSalesregionId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isbillto: ").append(toIndentedString(isbillto)).append("\n");
    sb.append("    isdn: ").append(toIndentedString(isdn)).append("\n");
    sb.append("    ispayfrom: ").append(toIndentedString(ispayfrom)).append("\n");
    sb.append("    isremitto: ").append(toIndentedString(isremitto)).append("\n");
    sb.append("    isshipto: ").append(toIndentedString(isshipto)).append("\n");
    sb.append("    istemporal: ").append(toIndentedString(istemporal)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    phone2: ").append(toIndentedString(phone2)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
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
