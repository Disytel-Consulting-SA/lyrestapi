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
 * ProductGamas
 */
@Validated



public class ProductGamas   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("isselfservice")
  private Boolean isselfservice = null;

  @JsonProperty("m_product_gamas_id")
  private Integer mProductGamasId = null;

  @JsonProperty("m_product_lines_id")
  private Integer mProductLinesId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public ProductGamas adClientId(Integer adClientId) {
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

  public ProductGamas adComponentobjectuid(String adComponentobjectuid) {
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

  public ProductGamas adOrgId(Integer adOrgId) {
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

  public ProductGamas created(String created) {
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

  public ProductGamas createdby(Integer createdby) {
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

  public ProductGamas description(String description) {
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

  public ProductGamas isactive(Boolean isactive) {
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

  public ProductGamas isdefault(Boolean isdefault) {
    this.isdefault = isdefault;
    return this;
  }

  /**
   * Get isdefault
   * @return isdefault
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsdefault() {
    return isdefault;
  }

  public void setIsdefault(Boolean isdefault) {
    this.isdefault = isdefault;
  }

  public ProductGamas isselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
    return this;
  }

  /**
   * Get isselfservice
   * @return isselfservice
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsselfservice() {
    return isselfservice;
  }

  public void setIsselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
  }

  public ProductGamas mProductGamasId(Integer mProductGamasId) {
    this.mProductGamasId = mProductGamasId;
    return this;
  }

  /**
   * Get mProductGamasId
   * @return mProductGamasId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMProductGamasId() {
    return mProductGamasId;
  }

  public void setMProductGamasId(Integer mProductGamasId) {
    this.mProductGamasId = mProductGamasId;
  }

  public ProductGamas mProductLinesId(Integer mProductLinesId) {
    this.mProductLinesId = mProductLinesId;
    return this;
  }

  /**
   * Get mProductLinesId
   * @return mProductLinesId
   **/
  @Schema(description = "")
  
    public Integer getMProductLinesId() {
    return mProductLinesId;
  }

  public void setMProductLinesId(Integer mProductLinesId) {
    this.mProductLinesId = mProductLinesId;
  }

  public ProductGamas name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductGamas processed(Boolean processed) {
    this.processed = processed;
    return this;
  }

  /**
   * Get processed
   * @return processed
   **/
  @Schema(description = "")
  
    public Boolean isProcessed() {
    return processed;
  }

  public void setProcessed(Boolean processed) {
    this.processed = processed;
  }

  public ProductGamas updated(String updated) {
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

  public ProductGamas updatedby(Integer updatedby) {
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

  public ProductGamas value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(description = "")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ProductGamas additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ProductGamas addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ProductGamas referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ProductGamas addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ProductGamas productGamas = (ProductGamas) o;
    return Objects.equals(this.adClientId, productGamas.adClientId) &&
        Objects.equals(this.adComponentobjectuid, productGamas.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, productGamas.adOrgId) &&
        Objects.equals(this.created, productGamas.created) &&
        Objects.equals(this.createdby, productGamas.createdby) &&
        Objects.equals(this.description, productGamas.description) &&
        Objects.equals(this.isactive, productGamas.isactive) &&
        Objects.equals(this.isdefault, productGamas.isdefault) &&
        Objects.equals(this.isselfservice, productGamas.isselfservice) &&
        Objects.equals(this.mProductGamasId, productGamas.mProductGamasId) &&
        Objects.equals(this.mProductLinesId, productGamas.mProductLinesId) &&
        Objects.equals(this.name, productGamas.name) &&
        Objects.equals(this.processed, productGamas.processed) &&
        Objects.equals(this.updated, productGamas.updated) &&
        Objects.equals(this.updatedby, productGamas.updatedby) &&
        Objects.equals(this.value, productGamas.value) &&
        Objects.equals(this.additionalvalues, productGamas.additionalvalues) &&
        Objects.equals(this.referencedvalues, productGamas.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, created, createdby, description, isactive, isdefault, isselfservice, mProductGamasId, mProductLinesId, name, processed, updated, updatedby, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductGamas {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    isselfservice: ").append(toIndentedString(isselfservice)).append("\n");
    sb.append("    mProductGamasId: ").append(toIndentedString(mProductGamasId)).append("\n");
    sb.append("    mProductLinesId: ").append(toIndentedString(mProductLinesId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
