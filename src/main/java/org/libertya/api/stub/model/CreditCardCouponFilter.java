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
 * CreditCardCouponFilter
 */
@Validated



public class CreditCardCouponFilter   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("adquirente")
  private String adquirente = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_creditcardcouponfilter_id")
  private Integer cCreditcardcouponfilterId = null;

  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("financingservice")
  private String financingservice = null;

  @JsonProperty("importcuponesfidelius")
  private String importcuponesfidelius = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isprocessed")
  private Boolean isprocessed = null;

  @JsonProperty("m_entidadfinanciera_id")
  private Integer mEntidadfinancieraId = null;

  @JsonProperty("m_entidadfinancieraplan_id")
  private Integer mEntidadfinancieraplanId = null;

  @JsonProperty("m_numerocomercio_id")
  private Integer mNumerocomercioId = null;

  @JsonProperty("paymentbatch")
  private String paymentbatch = null;

  @JsonProperty("process")
  private String process = null;

  @JsonProperty("trxdatefrom")
  private String trxdatefrom = null;

  @JsonProperty("trxdateto")
  private String trxdateto = null;

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

  public CreditCardCouponFilter adClientId(Integer adClientId) {
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

  public CreditCardCouponFilter adOrgId(Integer adOrgId) {
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

  public CreditCardCouponFilter adquirente(String adquirente) {
    this.adquirente = adquirente;
    return this;
  }

  /**
   * SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.
   * @return adquirente
   **/
  @Schema(description = "SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.")
  
    public String getAdquirente() {
    return adquirente;
  }

  public void setAdquirente(String adquirente) {
    this.adquirente = adquirente;
  }

  public CreditCardCouponFilter cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Identifica una Entidad Comercial
   * @return cBpartnerId
   **/
  @Schema(description = "Identifica una Entidad Comercial")
  
    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public CreditCardCouponFilter cCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
    return this;
  }

  /**
   *  
   * @return cCreditcardcouponfilterId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCCreditcardcouponfilterId() {
    return cCreditcardcouponfilterId;
  }

  public void setCCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
  }

  public CreditCardCouponFilter cCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
    return this;
  }

  /**
   * Liquidaciones de Tarjetas de Crédito
   * @return cCreditcardsettlementId
   **/
  @Schema(required = true, description = "Liquidaciones de Tarjetas de Crédito")
      @NotNull

    public Integer getCCreditcardsettlementId() {
    return cCreditcardsettlementId;
  }

  public void setCCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
  }

  public CreditCardCouponFilter cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Moneda para este registro
   * @return cCurrencyId
   **/
  @Schema(description = "Moneda para este registro")
  
    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public CreditCardCouponFilter created(String created) {
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

  public CreditCardCouponFilter createdby(Integer createdby) {
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

  public CreditCardCouponFilter financingservice(String financingservice) {
    this.financingservice = financingservice;
    return this;
  }

  /**
   * SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.
   * @return financingservice
   **/
  @Schema(description = "SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.")
  
    public String getFinancingservice() {
    return financingservice;
  }

  public void setFinancingservice(String financingservice) {
    this.financingservice = financingservice;
  }

  public CreditCardCouponFilter importcuponesfidelius(String importcuponesfidelius) {
    this.importcuponesfidelius = importcuponesfidelius;
    return this;
  }

  /**
   *  
   * @return importcuponesfidelius
   **/
  @Schema(description = " ")
  
    public String getImportcuponesfidelius() {
    return importcuponesfidelius;
  }

  public void setImportcuponesfidelius(String importcuponesfidelius) {
    this.importcuponesfidelius = importcuponesfidelius;
  }

  public CreditCardCouponFilter isactive(Boolean isactive) {
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

  public CreditCardCouponFilter isprocessed(Boolean isprocessed) {
    this.isprocessed = isprocessed;
    return this;
  }

  /**
   *  
   * @return isprocessed
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsprocessed() {
    return isprocessed;
  }

  public void setIsprocessed(Boolean isprocessed) {
    this.isprocessed = isprocessed;
  }

  public CreditCardCouponFilter mEntidadfinancieraId(Integer mEntidadfinancieraId) {
    this.mEntidadfinancieraId = mEntidadfinancieraId;
    return this;
  }

  /**
   *  
   * @return mEntidadfinancieraId
   **/
  @Schema(description = " ")
  
    public Integer getMEntidadfinancieraId() {
    return mEntidadfinancieraId;
  }

  public void setMEntidadfinancieraId(Integer mEntidadfinancieraId) {
    this.mEntidadfinancieraId = mEntidadfinancieraId;
  }

  public CreditCardCouponFilter mEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
    return this;
  }

  /**
   * Plan de Entidad Financiera
   * @return mEntidadfinancieraplanId
   **/
  @Schema(description = "Plan de Entidad Financiera")
  
    public Integer getMEntidadfinancieraplanId() {
    return mEntidadfinancieraplanId;
  }

  public void setMEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
  }

  public CreditCardCouponFilter mNumerocomercioId(Integer mNumerocomercioId) {
    this.mNumerocomercioId = mNumerocomercioId;
    return this;
  }

  /**
   * SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.
   * @return mNumerocomercioId
   **/
  @Schema(description = "SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.")
  
    public Integer getMNumerocomercioId() {
    return mNumerocomercioId;
  }

  public void setMNumerocomercioId(Integer mNumerocomercioId) {
    this.mNumerocomercioId = mNumerocomercioId;
  }

  public CreditCardCouponFilter paymentbatch(String paymentbatch) {
    this.paymentbatch = paymentbatch;
    return this;
  }

  /**
   *  
   * @return paymentbatch
   **/
  @Schema(description = " ")
  
    public String getPaymentbatch() {
    return paymentbatch;
  }

  public void setPaymentbatch(String paymentbatch) {
    this.paymentbatch = paymentbatch;
  }

  public CreditCardCouponFilter process(String process) {
    this.process = process;
    return this;
  }

  /**
   *  
   * @return process
   **/
  @Schema(description = " ")
  
    public String getProcess() {
    return process;
  }

  public void setProcess(String process) {
    this.process = process;
  }

  public CreditCardCouponFilter trxdatefrom(String trxdatefrom) {
    this.trxdatefrom = trxdatefrom;
    return this;
  }

  /**
   *  
   * @return trxdatefrom
   **/
  @Schema(description = " ")
  
    public String getTrxdatefrom() {
    return trxdatefrom;
  }

  public void setTrxdatefrom(String trxdatefrom) {
    this.trxdatefrom = trxdatefrom;
  }

  public CreditCardCouponFilter trxdateto(String trxdateto) {
    this.trxdateto = trxdateto;
    return this;
  }

  /**
   *  
   * @return trxdateto
   **/
  @Schema(description = " ")
  
    public String getTrxdateto() {
    return trxdateto;
  }

  public void setTrxdateto(String trxdateto) {
    this.trxdateto = trxdateto;
  }

  public CreditCardCouponFilter updated(String updated) {
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

  public CreditCardCouponFilter updatedby(Integer updatedby) {
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

  public CreditCardCouponFilter additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public CreditCardCouponFilter addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public CreditCardCouponFilter referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public CreditCardCouponFilter addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    CreditCardCouponFilter creditCardCouponFilter = (CreditCardCouponFilter) o;
    return Objects.equals(this.adClientId, creditCardCouponFilter.adClientId) &&
        Objects.equals(this.adOrgId, creditCardCouponFilter.adOrgId) &&
        Objects.equals(this.adquirente, creditCardCouponFilter.adquirente) &&
        Objects.equals(this.cBpartnerId, creditCardCouponFilter.cBpartnerId) &&
        Objects.equals(this.cCreditcardcouponfilterId, creditCardCouponFilter.cCreditcardcouponfilterId) &&
        Objects.equals(this.cCreditcardsettlementId, creditCardCouponFilter.cCreditcardsettlementId) &&
        Objects.equals(this.cCurrencyId, creditCardCouponFilter.cCurrencyId) &&
        Objects.equals(this.created, creditCardCouponFilter.created) &&
        Objects.equals(this.createdby, creditCardCouponFilter.createdby) &&
        Objects.equals(this.financingservice, creditCardCouponFilter.financingservice) &&
        Objects.equals(this.importcuponesfidelius, creditCardCouponFilter.importcuponesfidelius) &&
        Objects.equals(this.isactive, creditCardCouponFilter.isactive) &&
        Objects.equals(this.isprocessed, creditCardCouponFilter.isprocessed) &&
        Objects.equals(this.mEntidadfinancieraId, creditCardCouponFilter.mEntidadfinancieraId) &&
        Objects.equals(this.mEntidadfinancieraplanId, creditCardCouponFilter.mEntidadfinancieraplanId) &&
        Objects.equals(this.mNumerocomercioId, creditCardCouponFilter.mNumerocomercioId) &&
        Objects.equals(this.paymentbatch, creditCardCouponFilter.paymentbatch) &&
        Objects.equals(this.process, creditCardCouponFilter.process) &&
        Objects.equals(this.trxdatefrom, creditCardCouponFilter.trxdatefrom) &&
        Objects.equals(this.trxdateto, creditCardCouponFilter.trxdateto) &&
        Objects.equals(this.updated, creditCardCouponFilter.updated) &&
        Objects.equals(this.updatedby, creditCardCouponFilter.updatedby) &&
        Objects.equals(this.additionalvalues, creditCardCouponFilter.additionalvalues) &&
        Objects.equals(this.referencedvalues, creditCardCouponFilter.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adquirente, cBpartnerId, cCreditcardcouponfilterId, cCreditcardsettlementId, cCurrencyId, created, createdby, financingservice, importcuponesfidelius, isactive, isprocessed, mEntidadfinancieraId, mEntidadfinancieraplanId, mNumerocomercioId, paymentbatch, process, trxdatefrom, trxdateto, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardCouponFilter {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adquirente: ").append(toIndentedString(adquirente)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCreditcardcouponfilterId: ").append(toIndentedString(cCreditcardcouponfilterId)).append("\n");
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    financingservice: ").append(toIndentedString(financingservice)).append("\n");
    sb.append("    importcuponesfidelius: ").append(toIndentedString(importcuponesfidelius)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isprocessed: ").append(toIndentedString(isprocessed)).append("\n");
    sb.append("    mEntidadfinancieraId: ").append(toIndentedString(mEntidadfinancieraId)).append("\n");
    sb.append("    mEntidadfinancieraplanId: ").append(toIndentedString(mEntidadfinancieraplanId)).append("\n");
    sb.append("    mNumerocomercioId: ").append(toIndentedString(mNumerocomercioId)).append("\n");
    sb.append("    paymentbatch: ").append(toIndentedString(paymentbatch)).append("\n");
    sb.append("    process: ").append(toIndentedString(process)).append("\n");
    sb.append("    trxdatefrom: ").append(toIndentedString(trxdatefrom)).append("\n");
    sb.append("    trxdateto: ").append(toIndentedString(trxdateto)).append("\n");
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
