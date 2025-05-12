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
   * Compañía o empresa que utiliza ésta instalación
   * @return adClientId
   **/
  @Schema(required = true, description = "Compañía o empresa que utiliza ésta instalación")
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
   *  
   * @return adComponentobjectuid
   **/
  @Schema(description = " ")
  
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
   * Versión de Componente propietaria de este registro
   * @return adComponentversionId
   **/
  @Schema(description = "Versión de Componente propietaria de este registro")
  
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
   * Entidad organizacional dentro de la compañía
   * @return adOrgId
   **/
  @Schema(required = true, description = "Entidad organizacional dentro de la compañía")
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
   * Nombre del Banco asociado
   * @return bank
   **/
  @Schema(description = "Nombre del Banco asociado")
  
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
   * Valor inicial del rango
   * @return beforecheckdeadlinefrom
   **/
  @Schema(required = true, description = "Valor inicial del rango")
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
   * Valor final del rango
   * @return beforecheckdeadlineto
   **/
  @Schema(description = "Valor final del rango")
  
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
   * Banco
   * @return cBankId
   **/
  @Schema(description = "Banco")
  
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
   * Moneda para este registro
   * @return cCurrencyId
   **/
  @Schema(required = true, description = "Moneda para este registro")
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
   * Plazo de Cobro de Cheque
   * @return checkdeadline
   **/
  @Schema(required = true, description = "Plazo de Cobro de Cheque")
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
   *  
   * @return context
   **/
  @Schema(required = true, description = " ")
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
   * Medio de Pago de Terminal Punto de Venta
   * @return cPospaymentmediumId
   **/
  @Schema(required = true, description = "Medio de Pago de Terminal Punto de Venta")
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
   * Fecha de creación de este registro
   * @return created
   **/
  @Schema(required = true, description = "Fecha de creación de este registro")
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
   * Usuario que creó este registro
   * @return createdby
   **/
  @Schema(required = true, description = "Usuario que creó este registro")
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
   * Fecha de inicio para un rango
   * @return datefrom
   **/
  @Schema(required = true, description = "Fecha de inicio para un rango")
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
   * Fecha final de un rango (inclusive)
   * @return dateto
   **/
  @Schema(required = true, description = "Fecha final de un rango (inclusive)")
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
   * Descripción corta opcional del registro
   * @return description
   **/
  @Schema(description = "Descripción corta opcional del registro")
  
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
   * El registro está activo en el sistema
   * @return isactive
   **/
  @Schema(required = true, description = "El registro está activo en el sistema")
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
   *  
   * @return ismandatorybank
   **/
  @Schema(required = true, description = " ")
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
   *  
   * @return isnormalizedbank
   **/
  @Schema(required = true, description = " ")
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
   * Esquema para calcular el porcentaje de descuento comercial
   * @return mDiscountschemaId
   **/
  @Schema(description = "Esquema para calcular el porcentaje de descuento comercial")
  
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
   *  
   * @return mEntidadfinancieraId
   **/
  @Schema(required = true, description = " ")
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
   * Identificador alfanumérico de la Entidad
   * @return name
   **/
  @Schema(required = true, description = "Identificador alfanumérico de la Entidad")
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
   * Método de pago
   * @return tendertype
   **/
  @Schema(required = true, description = "Método de pago")
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
   * Determina si el campo esta actualizado
   * @return updated
   **/
  @Schema(required = true, description = "Determina si el campo esta actualizado")
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
   * Determina quien actualizó el campo
   * @return updatedby
   **/
  @Schema(required = true, description = "Determina quien actualizó el campo")
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
   * Validar plazos anteriores en el TPV
   * @return validatebeforecheckdeadlines
   **/
  @Schema(required = true, description = "Validar plazos anteriores en el TPV")
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
