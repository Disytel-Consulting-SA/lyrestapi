package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Propertiesmap;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Location
 */
@Validated



public class Location   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("address1")
  private String address1 = null;

  @JsonProperty("address2")
  private String address2 = null;

  @JsonProperty("address3")
  private String address3 = null;

  @JsonProperty("address4")
  private String address4 = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_city_id")
  private Integer cCityId = null;

  @JsonProperty("c_country_id")
  private Integer cCountryId = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("c_location_id")
  private Integer cLocationId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_region_id")
  private Integer cRegionId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("plaza")
  private String plaza = null;

  @JsonProperty("postal")
  private String postal = null;

  @JsonProperty("postal_add")
  private String postalAdd = null;

  @JsonProperty("regionname")
  private String regionname = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Location adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Get adClientId
   * @return adClientId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public Location adComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
    return this;
  }

  /**
   * Get adComponentobjectuid
   * @return adComponentobjectuid
   **/
  @Schema(description = "")
  
    public String getAdComponentobjectuid() {
    return adComponentobjectuid;
  }

  public void setAdComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
  }

  public Location address1(String address1) {
    this.address1 = address1;
    return this;
  }

  /**
   * Get address1
   * @return address1
   **/
  @Schema(description = "")
  
    public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public Location address2(String address2) {
    this.address2 = address2;
    return this;
  }

  /**
   * Get address2
   * @return address2
   **/
  @Schema(description = "")
  
    public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public Location address3(String address3) {
    this.address3 = address3;
    return this;
  }

  /**
   * Get address3
   * @return address3
   **/
  @Schema(description = "")
  
    public String getAddress3() {
    return address3;
  }

  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  public Location address4(String address4) {
    this.address4 = address4;
    return this;
  }

  /**
   * Get address4
   * @return address4
   **/
  @Schema(description = "")
  
    public String getAddress4() {
    return address4;
  }

  public void setAddress4(String address4) {
    this.address4 = address4;
  }

  public Location adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public Location cCityId(Integer cCityId) {
    this.cCityId = cCityId;
    return this;
  }

  /**
   * Get cCityId
   * @return cCityId
   **/
  @Schema(description = "")
  
    public Integer getCCityId() {
    return cCityId;
  }

  public void setCCityId(Integer cCityId) {
    this.cCityId = cCityId;
  }

  public Location cCountryId(Integer cCountryId) {
    this.cCountryId = cCountryId;
    return this;
  }

  /**
   * Get cCountryId
   * @return cCountryId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCCountryId() {
    return cCountryId;
  }

  public void setCCountryId(Integer cCountryId) {
    this.cCountryId = cCountryId;
  }

  public Location city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
   **/
  @Schema(description = "")
  
    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Location cLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
    return this;
  }

  /**
   * Get cLocationId
   * @return cLocationId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCLocationId() {
    return cLocationId;
  }

  public void setCLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
  }

  public Location created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Location createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Get createdby
   * @return createdby
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public Location cRegionId(Integer cRegionId) {
    this.cRegionId = cRegionId;
    return this;
  }

  /**
   * Get cRegionId
   * @return cRegionId
   **/
  @Schema(description = "")
  
    public Integer getCRegionId() {
    return cRegionId;
  }

  public void setCRegionId(Integer cRegionId) {
    this.cRegionId = cRegionId;
  }

  public Location isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Get isactive
   * @return isactive
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public Location plaza(String plaza) {
    this.plaza = plaza;
    return this;
  }

  /**
   * Get plaza
   * @return plaza
   **/
  @Schema(description = "")
  
    public String getPlaza() {
    return plaza;
  }

  public void setPlaza(String plaza) {
    this.plaza = plaza;
  }

  public Location postal(String postal) {
    this.postal = postal;
    return this;
  }

  /**
   * Get postal
   * @return postal
   **/
  @Schema(description = "")
  
    public String getPostal() {
    return postal;
  }

  public void setPostal(String postal) {
    this.postal = postal;
  }

  public Location postalAdd(String postalAdd) {
    this.postalAdd = postalAdd;
    return this;
  }

  /**
   * Get postalAdd
   * @return postalAdd
   **/
  @Schema(description = "")
  
    public String getPostalAdd() {
    return postalAdd;
  }

  public void setPostalAdd(String postalAdd) {
    this.postalAdd = postalAdd;
  }

  public Location regionname(String regionname) {
    this.regionname = regionname;
    return this;
  }

  /**
   * Get regionname
   * @return regionname
   **/
  @Schema(description = "")
  
    public String getRegionname() {
    return regionname;
  }

  public void setRegionname(String regionname) {
    this.regionname = regionname;
  }

  public Location updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public Location updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Get updatedby
   * @return updatedby
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

  public Location additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Location addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
    if (this.additionalvalues == null) {
      this.additionalvalues = new ArrayList<>();
    }
    this.additionalvalues.add(additionalvaluesItem);
    return this;
  }

  /**
   * Get additionalvalues
   * @return additionalvalues
   **/
  @Schema(description = "")
      @Valid
    public List<Propertiesmap> getAdditionalvalues() {
    return additionalvalues;
  }

  public void setAdditionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
  }

  public Location referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Location addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
    if (this.referencedvalues == null) {
      this.referencedvalues = new ArrayList<>();
    }
    this.referencedvalues.add(referencedvaluesItem);
    return this;
  }

  /**
   * Get referencedvalues
   * @return referencedvalues
   **/
  @Schema(description = "")
      @Valid
    public List<Propertiesmap> getReferencedvalues() {
    return referencedvalues;
  }

  public void setReferencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.adClientId, location.adClientId) &&
        Objects.equals(this.adComponentobjectuid, location.adComponentobjectuid) &&
        Objects.equals(this.address1, location.address1) &&
        Objects.equals(this.address2, location.address2) &&
        Objects.equals(this.address3, location.address3) &&
        Objects.equals(this.address4, location.address4) &&
        Objects.equals(this.adOrgId, location.adOrgId) &&
        Objects.equals(this.cCityId, location.cCityId) &&
        Objects.equals(this.cCountryId, location.cCountryId) &&
        Objects.equals(this.city, location.city) &&
        Objects.equals(this.cLocationId, location.cLocationId) &&
        Objects.equals(this.created, location.created) &&
        Objects.equals(this.createdby, location.createdby) &&
        Objects.equals(this.cRegionId, location.cRegionId) &&
        Objects.equals(this.isactive, location.isactive) &&
        Objects.equals(this.plaza, location.plaza) &&
        Objects.equals(this.postal, location.postal) &&
        Objects.equals(this.postalAdd, location.postalAdd) &&
        Objects.equals(this.regionname, location.regionname) &&
        Objects.equals(this.updated, location.updated) &&
        Objects.equals(this.updatedby, location.updatedby) &&
        Objects.equals(this.additionalvalues, location.additionalvalues) &&
        Objects.equals(this.referencedvalues, location.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, address1, address2, address3, address4, adOrgId, cCityId, cCountryId, city, cLocationId, created, createdby, cRegionId, isactive, plaza, postal, postalAdd, regionname, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    address1: ").append(toIndentedString(address1)).append("\n");
    sb.append("    address2: ").append(toIndentedString(address2)).append("\n");
    sb.append("    address3: ").append(toIndentedString(address3)).append("\n");
    sb.append("    address4: ").append(toIndentedString(address4)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cCityId: ").append(toIndentedString(cCityId)).append("\n");
    sb.append("    cCountryId: ").append(toIndentedString(cCountryId)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    cLocationId: ").append(toIndentedString(cLocationId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRegionId: ").append(toIndentedString(cRegionId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    plaza: ").append(toIndentedString(plaza)).append("\n");
    sb.append("    postal: ").append(toIndentedString(postal)).append("\n");
    sb.append("    postalAdd: ").append(toIndentedString(postalAdd)).append("\n");
    sb.append("    regionname: ").append(toIndentedString(regionname)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    additionalvalues: ").append(toIndentedString(additionalvalues)).append("\n");
    sb.append("    referencedvalues: ").append(toIndentedString(referencedvalues)).append("\n");
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
