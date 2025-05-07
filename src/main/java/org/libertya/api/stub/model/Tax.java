package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Propertiesmap;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Tax
 */
@Validated



public class Tax   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("arcibanormcode")
  private String arcibanormcode = null;

  @JsonProperty("c_bp_group_id")
  private Integer cBpGroupId = null;

  @JsonProperty("c_country_id")
  private Integer cCountryId = null;

  @JsonProperty("codigooperacion")
  private String codigooperacion = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_region_id")
  private Integer cRegionId = null;

  @JsonProperty("c_taxcategory_id")
  private Integer cTaxcategoryId = null;

  @JsonProperty("c_tax_id")
  private Integer cTaxId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("isdocumentlevel")
  private Boolean isdocumentlevel = null;

  @JsonProperty("ispercepcion")
  private Boolean ispercepcion = null;

  @JsonProperty("issummary")
  private Boolean issummary = null;

  @JsonProperty("istaxexempt")
  private Boolean istaxexempt = null;

  @JsonProperty("m_product_category_id")
  private Integer mProductCategoryId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("parent_tax_id")
  private Integer parentTaxId = null;

  @JsonProperty("perceptiontype")
  private String perceptiontype = null;

  @JsonProperty("rate")
  private BigDecimal rate = null;

  @JsonProperty("requirestaxcertificate")
  private Boolean requirestaxcertificate = null;

  @JsonProperty("sopotype")
  private String sopotype = null;

  @JsonProperty("taxaccusation")
  private String taxaccusation = null;

  @JsonProperty("taxareatype")
  private String taxareatype = null;

  @JsonProperty("taxindicator")
  private String taxindicator = null;

  @JsonProperty("taxtype")
  private String taxtype = null;

  @JsonProperty("to_country_id")
  private Integer toCountryId = null;

  @JsonProperty("to_region_id")
  private Integer toRegionId = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("validfrom")
  private String validfrom = null;

  @JsonProperty("wsfecode")
  private Integer wsfecode = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Tax adClientId(Integer adClientId) {
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

  public Tax adComponentobjectuid(String adComponentobjectuid) {
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

  public Tax adOrgId(Integer adOrgId) {
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

  public Tax arcibanormcode(String arcibanormcode) {
    this.arcibanormcode = arcibanormcode;
    return this;
  }

  /**
   * Get arcibanormcode
   * @return arcibanormcode
   **/
  @Schema(description = "")
  
    public String getArcibanormcode() {
    return arcibanormcode;
  }

  public void setArcibanormcode(String arcibanormcode) {
    this.arcibanormcode = arcibanormcode;
  }

  public Tax cBpGroupId(Integer cBpGroupId) {
    this.cBpGroupId = cBpGroupId;
    return this;
  }

  /**
   * Get cBpGroupId
   * @return cBpGroupId
   **/
  @Schema(description = "")
  
    public Integer getCBpGroupId() {
    return cBpGroupId;
  }

  public void setCBpGroupId(Integer cBpGroupId) {
    this.cBpGroupId = cBpGroupId;
  }

  public Tax cCountryId(Integer cCountryId) {
    this.cCountryId = cCountryId;
    return this;
  }

  /**
   * Get cCountryId
   * @return cCountryId
   **/
  @Schema(description = "")
  
    public Integer getCCountryId() {
    return cCountryId;
  }

  public void setCCountryId(Integer cCountryId) {
    this.cCountryId = cCountryId;
  }

  public Tax codigooperacion(String codigooperacion) {
    this.codigooperacion = codigooperacion;
    return this;
  }

  /**
   * Get codigooperacion
   * @return codigooperacion
   **/
  @Schema(description = "")
  
    public String getCodigooperacion() {
    return codigooperacion;
  }

  public void setCodigooperacion(String codigooperacion) {
    this.codigooperacion = codigooperacion;
  }

  public Tax created(String created) {
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

  public Tax createdby(Integer createdby) {
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

  public Tax cRegionId(Integer cRegionId) {
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

  public Tax cTaxcategoryId(Integer cTaxcategoryId) {
    this.cTaxcategoryId = cTaxcategoryId;
    return this;
  }

  /**
   * Get cTaxcategoryId
   * @return cTaxcategoryId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCTaxcategoryId() {
    return cTaxcategoryId;
  }

  public void setCTaxcategoryId(Integer cTaxcategoryId) {
    this.cTaxcategoryId = cTaxcategoryId;
  }

  public Tax cTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
    return this;
  }

  /**
   * Get cTaxId
   * @return cTaxId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCTaxId() {
    return cTaxId;
  }

  public void setCTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
  }

  public Tax description(String description) {
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

  public Tax isactive(Boolean isactive) {
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

  public Tax isdefault(Boolean isdefault) {
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

  public Tax isdocumentlevel(Boolean isdocumentlevel) {
    this.isdocumentlevel = isdocumentlevel;
    return this;
  }

  /**
   * Get isdocumentlevel
   * @return isdocumentlevel
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsdocumentlevel() {
    return isdocumentlevel;
  }

  public void setIsdocumentlevel(Boolean isdocumentlevel) {
    this.isdocumentlevel = isdocumentlevel;
  }

  public Tax ispercepcion(Boolean ispercepcion) {
    this.ispercepcion = ispercepcion;
    return this;
  }

  /**
   * Get ispercepcion
   * @return ispercepcion
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIspercepcion() {
    return ispercepcion;
  }

  public void setIspercepcion(Boolean ispercepcion) {
    this.ispercepcion = ispercepcion;
  }

  public Tax issummary(Boolean issummary) {
    this.issummary = issummary;
    return this;
  }

  /**
   * Get issummary
   * @return issummary
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIssummary() {
    return issummary;
  }

  public void setIssummary(Boolean issummary) {
    this.issummary = issummary;
  }

  public Tax istaxexempt(Boolean istaxexempt) {
    this.istaxexempt = istaxexempt;
    return this;
  }

  /**
   * Get istaxexempt
   * @return istaxexempt
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIstaxexempt() {
    return istaxexempt;
  }

  public void setIstaxexempt(Boolean istaxexempt) {
    this.istaxexempt = istaxexempt;
  }

  public Tax mProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
    return this;
  }

  /**
   * Get mProductCategoryId
   * @return mProductCategoryId
   **/
  @Schema(description = "")
  
    public Integer getMProductCategoryId() {
    return mProductCategoryId;
  }

  public void setMProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
  }

  public Tax mProductId(Integer mProductId) {
    this.mProductId = mProductId;
    return this;
  }

  /**
   * Get mProductId
   * @return mProductId
   **/
  @Schema(description = "")
  
    public Integer getMProductId() {
    return mProductId;
  }

  public void setMProductId(Integer mProductId) {
    this.mProductId = mProductId;
  }

  public Tax name(String name) {
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

  public Tax parentTaxId(Integer parentTaxId) {
    this.parentTaxId = parentTaxId;
    return this;
  }

  /**
   * Get parentTaxId
   * @return parentTaxId
   **/
  @Schema(description = "")
  
    public Integer getParentTaxId() {
    return parentTaxId;
  }

  public void setParentTaxId(Integer parentTaxId) {
    this.parentTaxId = parentTaxId;
  }

  public Tax perceptiontype(String perceptiontype) {
    this.perceptiontype = perceptiontype;
    return this;
  }

  /**
   * Get perceptiontype
   * @return perceptiontype
   **/
  @Schema(description = "")
  
    public String getPerceptiontype() {
    return perceptiontype;
  }

  public void setPerceptiontype(String perceptiontype) {
    this.perceptiontype = perceptiontype;
  }

  public Tax rate(BigDecimal rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public Tax requirestaxcertificate(Boolean requirestaxcertificate) {
    this.requirestaxcertificate = requirestaxcertificate;
    return this;
  }

  /**
   * Get requirestaxcertificate
   * @return requirestaxcertificate
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isRequirestaxcertificate() {
    return requirestaxcertificate;
  }

  public void setRequirestaxcertificate(Boolean requirestaxcertificate) {
    this.requirestaxcertificate = requirestaxcertificate;
  }

  public Tax sopotype(String sopotype) {
    this.sopotype = sopotype;
    return this;
  }

  /**
   * Get sopotype
   * @return sopotype
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getSopotype() {
    return sopotype;
  }

  public void setSopotype(String sopotype) {
    this.sopotype = sopotype;
  }

  public Tax taxaccusation(String taxaccusation) {
    this.taxaccusation = taxaccusation;
    return this;
  }

  /**
   * Get taxaccusation
   * @return taxaccusation
   **/
  @Schema(description = "")
  
    public String getTaxaccusation() {
    return taxaccusation;
  }

  public void setTaxaccusation(String taxaccusation) {
    this.taxaccusation = taxaccusation;
  }

  public Tax taxareatype(String taxareatype) {
    this.taxareatype = taxareatype;
    return this;
  }

  /**
   * Get taxareatype
   * @return taxareatype
   **/
  @Schema(description = "")
  
    public String getTaxareatype() {
    return taxareatype;
  }

  public void setTaxareatype(String taxareatype) {
    this.taxareatype = taxareatype;
  }

  public Tax taxindicator(String taxindicator) {
    this.taxindicator = taxindicator;
    return this;
  }

  /**
   * Get taxindicator
   * @return taxindicator
   **/
  @Schema(description = "")
  
    public String getTaxindicator() {
    return taxindicator;
  }

  public void setTaxindicator(String taxindicator) {
    this.taxindicator = taxindicator;
  }

  public Tax taxtype(String taxtype) {
    this.taxtype = taxtype;
    return this;
  }

  /**
   * Get taxtype
   * @return taxtype
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTaxtype() {
    return taxtype;
  }

  public void setTaxtype(String taxtype) {
    this.taxtype = taxtype;
  }

  public Tax toCountryId(Integer toCountryId) {
    this.toCountryId = toCountryId;
    return this;
  }

  /**
   * Get toCountryId
   * @return toCountryId
   **/
  @Schema(description = "")
  
    public Integer getToCountryId() {
    return toCountryId;
  }

  public void setToCountryId(Integer toCountryId) {
    this.toCountryId = toCountryId;
  }

  public Tax toRegionId(Integer toRegionId) {
    this.toRegionId = toRegionId;
    return this;
  }

  /**
   * Get toRegionId
   * @return toRegionId
   **/
  @Schema(description = "")
  
    public Integer getToRegionId() {
    return toRegionId;
  }

  public void setToRegionId(Integer toRegionId) {
    this.toRegionId = toRegionId;
  }

  public Tax updated(String updated) {
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

  public Tax updatedby(Integer updatedby) {
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

  public Tax validfrom(String validfrom) {
    this.validfrom = validfrom;
    return this;
  }

  /**
   * Get validfrom
   * @return validfrom
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getValidfrom() {
    return validfrom;
  }

  public void setValidfrom(String validfrom) {
    this.validfrom = validfrom;
  }

  public Tax wsfecode(Integer wsfecode) {
    this.wsfecode = wsfecode;
    return this;
  }

  /**
   * Get wsfecode
   * @return wsfecode
   **/
  @Schema(description = "")
  
    public Integer getWsfecode() {
    return wsfecode;
  }

  public void setWsfecode(Integer wsfecode) {
    this.wsfecode = wsfecode;
  }

  public Tax additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Tax addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Tax referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Tax addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Tax tax = (Tax) o;
    return Objects.equals(this.adClientId, tax.adClientId) &&
        Objects.equals(this.adComponentobjectuid, tax.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, tax.adOrgId) &&
        Objects.equals(this.arcibanormcode, tax.arcibanormcode) &&
        Objects.equals(this.cBpGroupId, tax.cBpGroupId) &&
        Objects.equals(this.cCountryId, tax.cCountryId) &&
        Objects.equals(this.codigooperacion, tax.codigooperacion) &&
        Objects.equals(this.created, tax.created) &&
        Objects.equals(this.createdby, tax.createdby) &&
        Objects.equals(this.cRegionId, tax.cRegionId) &&
        Objects.equals(this.cTaxcategoryId, tax.cTaxcategoryId) &&
        Objects.equals(this.cTaxId, tax.cTaxId) &&
        Objects.equals(this.description, tax.description) &&
        Objects.equals(this.isactive, tax.isactive) &&
        Objects.equals(this.isdefault, tax.isdefault) &&
        Objects.equals(this.isdocumentlevel, tax.isdocumentlevel) &&
        Objects.equals(this.ispercepcion, tax.ispercepcion) &&
        Objects.equals(this.issummary, tax.issummary) &&
        Objects.equals(this.istaxexempt, tax.istaxexempt) &&
        Objects.equals(this.mProductCategoryId, tax.mProductCategoryId) &&
        Objects.equals(this.mProductId, tax.mProductId) &&
        Objects.equals(this.name, tax.name) &&
        Objects.equals(this.parentTaxId, tax.parentTaxId) &&
        Objects.equals(this.perceptiontype, tax.perceptiontype) &&
        Objects.equals(this.rate, tax.rate) &&
        Objects.equals(this.requirestaxcertificate, tax.requirestaxcertificate) &&
        Objects.equals(this.sopotype, tax.sopotype) &&
        Objects.equals(this.taxaccusation, tax.taxaccusation) &&
        Objects.equals(this.taxareatype, tax.taxareatype) &&
        Objects.equals(this.taxindicator, tax.taxindicator) &&
        Objects.equals(this.taxtype, tax.taxtype) &&
        Objects.equals(this.toCountryId, tax.toCountryId) &&
        Objects.equals(this.toRegionId, tax.toRegionId) &&
        Objects.equals(this.updated, tax.updated) &&
        Objects.equals(this.updatedby, tax.updatedby) &&
        Objects.equals(this.validfrom, tax.validfrom) &&
        Objects.equals(this.wsfecode, tax.wsfecode) &&
        Objects.equals(this.additionalvalues, tax.additionalvalues) &&
        Objects.equals(this.referencedvalues, tax.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, arcibanormcode, cBpGroupId, cCountryId, codigooperacion, created, createdby, cRegionId, cTaxcategoryId, cTaxId, description, isactive, isdefault, isdocumentlevel, ispercepcion, issummary, istaxexempt, mProductCategoryId, mProductId, name, parentTaxId, perceptiontype, rate, requirestaxcertificate, sopotype, taxaccusation, taxareatype, taxindicator, taxtype, toCountryId, toRegionId, updated, updatedby, validfrom, wsfecode, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tax {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    arcibanormcode: ").append(toIndentedString(arcibanormcode)).append("\n");
    sb.append("    cBpGroupId: ").append(toIndentedString(cBpGroupId)).append("\n");
    sb.append("    cCountryId: ").append(toIndentedString(cCountryId)).append("\n");
    sb.append("    codigooperacion: ").append(toIndentedString(codigooperacion)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRegionId: ").append(toIndentedString(cRegionId)).append("\n");
    sb.append("    cTaxcategoryId: ").append(toIndentedString(cTaxcategoryId)).append("\n");
    sb.append("    cTaxId: ").append(toIndentedString(cTaxId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    isdocumentlevel: ").append(toIndentedString(isdocumentlevel)).append("\n");
    sb.append("    ispercepcion: ").append(toIndentedString(ispercepcion)).append("\n");
    sb.append("    issummary: ").append(toIndentedString(issummary)).append("\n");
    sb.append("    istaxexempt: ").append(toIndentedString(istaxexempt)).append("\n");
    sb.append("    mProductCategoryId: ").append(toIndentedString(mProductCategoryId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentTaxId: ").append(toIndentedString(parentTaxId)).append("\n");
    sb.append("    perceptiontype: ").append(toIndentedString(perceptiontype)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    requirestaxcertificate: ").append(toIndentedString(requirestaxcertificate)).append("\n");
    sb.append("    sopotype: ").append(toIndentedString(sopotype)).append("\n");
    sb.append("    taxaccusation: ").append(toIndentedString(taxaccusation)).append("\n");
    sb.append("    taxareatype: ").append(toIndentedString(taxareatype)).append("\n");
    sb.append("    taxindicator: ").append(toIndentedString(taxindicator)).append("\n");
    sb.append("    taxtype: ").append(toIndentedString(taxtype)).append("\n");
    sb.append("    toCountryId: ").append(toIndentedString(toCountryId)).append("\n");
    sb.append("    toRegionId: ").append(toIndentedString(toRegionId)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    validfrom: ").append(toIndentedString(validfrom)).append("\n");
    sb.append("    wsfecode: ").append(toIndentedString(wsfecode)).append("\n");
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
