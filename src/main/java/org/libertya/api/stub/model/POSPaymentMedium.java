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
 * POSPaymentMedium
 */
@Validated



public class POSPaymentMedium   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("bank")
  private String bank = null;

  @JsonProperty("beforecheckdeadlinefrom")
  private String beforecheckdeadlinefrom = null;

  @JsonProperty("beforecheckdeadlineto")
  private String beforecheckdeadlineto = null;

  @JsonProperty("c_bank_id")
  private Integer cBankId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("checkdeadline")
  private String checkdeadline = null;

  @JsonProperty("context")
  private String context = null;

  @JsonProperty("c_pospaymentmedium_id")
  private Integer cPospaymentmediumId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("datefrom")
  private String datefrom = null;

  @JsonProperty("dateto")
  private String dateto = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("ismandatorybank")
  private Boolean ismandatorybank = null;

  @JsonProperty("isnormalizedbank")
  private Boolean isnormalizedbank = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("m_entidadfinanciera_id")
  private Integer mEntidadfinancieraId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("tendertype")
  private String tendertype = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("validatebeforecheckdeadlines")
  private Boolean validatebeforecheckdeadlines = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public POSPaymentMedium adClientId(Integer adClientId) {
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

  public POSPaymentMedium adComponentobjectuid(String adComponentobjectuid) {
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

  public POSPaymentMedium adComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
    return this;
  }

  /**
   * Get adComponentversionId
   * @return adComponentversionId
   **/
  @Schema(description = "")
  
    public Integer getAdComponentversionId() {
    return adComponentversionId;
  }

  public void setAdComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
  }

  public POSPaymentMedium adOrgId(Integer adOrgId) {
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

  public POSPaymentMedium bank(String bank) {
    this.bank = bank;
    return this;
  }

  /**
   * Get bank
   * @return bank
   **/
  @Schema(description = "")
  
    public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public POSPaymentMedium beforecheckdeadlinefrom(String beforecheckdeadlinefrom) {
    this.beforecheckdeadlinefrom = beforecheckdeadlinefrom;
    return this;
  }

  /**
   * Get beforecheckdeadlinefrom
   * @return beforecheckdeadlinefrom
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getBeforecheckdeadlinefrom() {
    return beforecheckdeadlinefrom;
  }

  public void setBeforecheckdeadlinefrom(String beforecheckdeadlinefrom) {
    this.beforecheckdeadlinefrom = beforecheckdeadlinefrom;
  }

  public POSPaymentMedium beforecheckdeadlineto(String beforecheckdeadlineto) {
    this.beforecheckdeadlineto = beforecheckdeadlineto;
    return this;
  }

  /**
   * Get beforecheckdeadlineto
   * @return beforecheckdeadlineto
   **/
  @Schema(description = "")
  
    public String getBeforecheckdeadlineto() {
    return beforecheckdeadlineto;
  }

  public void setBeforecheckdeadlineto(String beforecheckdeadlineto) {
    this.beforecheckdeadlineto = beforecheckdeadlineto;
  }

  public POSPaymentMedium cBankId(Integer cBankId) {
    this.cBankId = cBankId;
    return this;
  }

  /**
   * Get cBankId
   * @return cBankId
   **/
  @Schema(description = "")
  
    public Integer getCBankId() {
    return cBankId;
  }

  public void setCBankId(Integer cBankId) {
    this.cBankId = cBankId;
  }

  public POSPaymentMedium cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Get cCurrencyId
   * @return cCurrencyId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public POSPaymentMedium checkdeadline(String checkdeadline) {
    this.checkdeadline = checkdeadline;
    return this;
  }

  /**
   * Get checkdeadline
   * @return checkdeadline
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCheckdeadline() {
    return checkdeadline;
  }

  public void setCheckdeadline(String checkdeadline) {
    this.checkdeadline = checkdeadline;
  }

  public POSPaymentMedium context(String context) {
    this.context = context;
    return this;
  }

  /**
   * Get context
   * @return context
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public POSPaymentMedium cPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
    return this;
  }

  /**
   * Get cPospaymentmediumId
   * @return cPospaymentmediumId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCPospaymentmediumId() {
    return cPospaymentmediumId;
  }

  public void setCPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
  }

  public POSPaymentMedium created(String created) {
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

  public POSPaymentMedium createdby(Integer createdby) {
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

  public POSPaymentMedium datefrom(String datefrom) {
    this.datefrom = datefrom;
    return this;
  }

  /**
   * Get datefrom
   * @return datefrom
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDatefrom() {
    return datefrom;
  }

  public void setDatefrom(String datefrom) {
    this.datefrom = datefrom;
  }

  public POSPaymentMedium dateto(String dateto) {
    this.dateto = dateto;
    return this;
  }

  /**
   * Get dateto
   * @return dateto
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDateto() {
    return dateto;
  }

  public void setDateto(String dateto) {
    this.dateto = dateto;
  }

  public POSPaymentMedium description(String description) {
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

  public POSPaymentMedium isactive(Boolean isactive) {
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

  public POSPaymentMedium ismandatorybank(Boolean ismandatorybank) {
    this.ismandatorybank = ismandatorybank;
    return this;
  }

  /**
   * Get ismandatorybank
   * @return ismandatorybank
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsmandatorybank() {
    return ismandatorybank;
  }

  public void setIsmandatorybank(Boolean ismandatorybank) {
    this.ismandatorybank = ismandatorybank;
  }

  public POSPaymentMedium isnormalizedbank(Boolean isnormalizedbank) {
    this.isnormalizedbank = isnormalizedbank;
    return this;
  }

  /**
   * Get isnormalizedbank
   * @return isnormalizedbank
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsnormalizedbank() {
    return isnormalizedbank;
  }

  public void setIsnormalizedbank(Boolean isnormalizedbank) {
    this.isnormalizedbank = isnormalizedbank;
  }

  public POSPaymentMedium mDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
    return this;
  }

  /**
   * Get mDiscountschemaId
   * @return mDiscountschemaId
   **/
  @Schema(description = "")
  
    public Integer getMDiscountschemaId() {
    return mDiscountschemaId;
  }

  public void setMDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
  }

  public POSPaymentMedium mEntidadfinancieraId(Integer mEntidadfinancieraId) {
    this.mEntidadfinancieraId = mEntidadfinancieraId;
    return this;
  }

  /**
   * Get mEntidadfinancieraId
   * @return mEntidadfinancieraId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMEntidadfinancieraId() {
    return mEntidadfinancieraId;
  }

  public void setMEntidadfinancieraId(Integer mEntidadfinancieraId) {
    this.mEntidadfinancieraId = mEntidadfinancieraId;
  }

  public POSPaymentMedium name(String name) {
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

  public POSPaymentMedium tendertype(String tendertype) {
    this.tendertype = tendertype;
    return this;
  }

  /**
   * Get tendertype
   * @return tendertype
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTendertype() {
    return tendertype;
  }

  public void setTendertype(String tendertype) {
    this.tendertype = tendertype;
  }

  public POSPaymentMedium updated(String updated) {
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

  public POSPaymentMedium updatedby(Integer updatedby) {
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

  public POSPaymentMedium validatebeforecheckdeadlines(Boolean validatebeforecheckdeadlines) {
    this.validatebeforecheckdeadlines = validatebeforecheckdeadlines;
    return this;
  }

  /**
   * Get validatebeforecheckdeadlines
   * @return validatebeforecheckdeadlines
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isValidatebeforecheckdeadlines() {
    return validatebeforecheckdeadlines;
  }

  public void setValidatebeforecheckdeadlines(Boolean validatebeforecheckdeadlines) {
    this.validatebeforecheckdeadlines = validatebeforecheckdeadlines;
  }

  public POSPaymentMedium additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public POSPaymentMedium addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public POSPaymentMedium referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public POSPaymentMedium addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    POSPaymentMedium poSPaymentMedium = (POSPaymentMedium) o;
    return Objects.equals(this.adClientId, poSPaymentMedium.adClientId) &&
        Objects.equals(this.adComponentobjectuid, poSPaymentMedium.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, poSPaymentMedium.adComponentversionId) &&
        Objects.equals(this.adOrgId, poSPaymentMedium.adOrgId) &&
        Objects.equals(this.bank, poSPaymentMedium.bank) &&
        Objects.equals(this.beforecheckdeadlinefrom, poSPaymentMedium.beforecheckdeadlinefrom) &&
        Objects.equals(this.beforecheckdeadlineto, poSPaymentMedium.beforecheckdeadlineto) &&
        Objects.equals(this.cBankId, poSPaymentMedium.cBankId) &&
        Objects.equals(this.cCurrencyId, poSPaymentMedium.cCurrencyId) &&
        Objects.equals(this.checkdeadline, poSPaymentMedium.checkdeadline) &&
        Objects.equals(this.context, poSPaymentMedium.context) &&
        Objects.equals(this.cPospaymentmediumId, poSPaymentMedium.cPospaymentmediumId) &&
        Objects.equals(this.created, poSPaymentMedium.created) &&
        Objects.equals(this.createdby, poSPaymentMedium.createdby) &&
        Objects.equals(this.datefrom, poSPaymentMedium.datefrom) &&
        Objects.equals(this.dateto, poSPaymentMedium.dateto) &&
        Objects.equals(this.description, poSPaymentMedium.description) &&
        Objects.equals(this.isactive, poSPaymentMedium.isactive) &&
        Objects.equals(this.ismandatorybank, poSPaymentMedium.ismandatorybank) &&
        Objects.equals(this.isnormalizedbank, poSPaymentMedium.isnormalizedbank) &&
        Objects.equals(this.mDiscountschemaId, poSPaymentMedium.mDiscountschemaId) &&
        Objects.equals(this.mEntidadfinancieraId, poSPaymentMedium.mEntidadfinancieraId) &&
        Objects.equals(this.name, poSPaymentMedium.name) &&
        Objects.equals(this.tendertype, poSPaymentMedium.tendertype) &&
        Objects.equals(this.updated, poSPaymentMedium.updated) &&
        Objects.equals(this.updatedby, poSPaymentMedium.updatedby) &&
        Objects.equals(this.validatebeforecheckdeadlines, poSPaymentMedium.validatebeforecheckdeadlines) &&
        Objects.equals(this.additionalvalues, poSPaymentMedium.additionalvalues) &&
        Objects.equals(this.referencedvalues, poSPaymentMedium.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adOrgId, bank, beforecheckdeadlinefrom, beforecheckdeadlineto, cBankId, cCurrencyId, checkdeadline, context, cPospaymentmediumId, created, createdby, datefrom, dateto, description, isactive, ismandatorybank, isnormalizedbank, mDiscountschemaId, mEntidadfinancieraId, name, tendertype, updated, updatedby, validatebeforecheckdeadlines, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSPaymentMedium {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    bank: ").append(toIndentedString(bank)).append("\n");
    sb.append("    beforecheckdeadlinefrom: ").append(toIndentedString(beforecheckdeadlinefrom)).append("\n");
    sb.append("    beforecheckdeadlineto: ").append(toIndentedString(beforecheckdeadlineto)).append("\n");
    sb.append("    cBankId: ").append(toIndentedString(cBankId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    checkdeadline: ").append(toIndentedString(checkdeadline)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    cPospaymentmediumId: ").append(toIndentedString(cPospaymentmediumId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    datefrom: ").append(toIndentedString(datefrom)).append("\n");
    sb.append("    dateto: ").append(toIndentedString(dateto)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    ismandatorybank: ").append(toIndentedString(ismandatorybank)).append("\n");
    sb.append("    isnormalizedbank: ").append(toIndentedString(isnormalizedbank)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    mEntidadfinancieraId: ").append(toIndentedString(mEntidadfinancieraId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tendertype: ").append(toIndentedString(tendertype)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    validatebeforecheckdeadlines: ").append(toIndentedString(validatebeforecheckdeadlines)).append("\n");
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
