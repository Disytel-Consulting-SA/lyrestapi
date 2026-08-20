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
 * CouponsSettlements
 */
@Validated



public class CouponsSettlements   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("a_name")
  private String aName = null;

  @JsonProperty("c_couponssettlements_id")
  private Integer cCouponssettlementsId = null;

  @JsonProperty("c_creditcardcouponfilter_id")
  private Integer cCreditcardcouponfilterId = null;

  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("couponno")
  private String couponno = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("creditcardno")
  private String creditcardno = null;

  @JsonProperty("include")
  private Boolean include = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isreconciled")
  private Boolean isreconciled = null;

  @JsonProperty("isrefused")
  private Boolean isrefused = null;

  @JsonProperty("m_entidadfinanciera_id")
  private Integer mEntidadfinancieraId = null;

  @JsonProperty("m_entidadfinancieraplan_id")
  private Integer mEntidadfinancieraplanId = null;

  @JsonProperty("paymentbatch")
  private String paymentbatch = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("trxdate")
  private String trxdate = null;

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

  public CouponsSettlements adClientId(Integer adClientId) {
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

  public CouponsSettlements adOrgId(Integer adOrgId) {
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

  public CouponsSettlements amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Importe en una moneda definida
   * @return amount
   **/
  @Schema(description = "Importe en una moneda definida")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public CouponsSettlements aName(String aName) {
    this.aName = aName;
    return this;
  }

  /**
   * Nombre de la Tarjeta de Crédito o el Poseedor de la cuenta
   * @return aName
   **/
  @Schema(description = "Nombre de la Tarjeta de Crédito o el Poseedor de la cuenta")
  
    public String getAName() {
    return aName;
  }

  public void setAName(String aName) {
    this.aName = aName;
  }

  public CouponsSettlements cCouponssettlementsId(Integer cCouponssettlementsId) {
    this.cCouponssettlementsId = cCouponssettlementsId;
    return this;
  }

  /**
   *  
   * @return cCouponssettlementsId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCCouponssettlementsId() {
    return cCouponssettlementsId;
  }

  public void setCCouponssettlementsId(Integer cCouponssettlementsId) {
    this.cCouponssettlementsId = cCouponssettlementsId;
  }

  public CouponsSettlements cCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
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

  public CouponsSettlements cCreditcardsettlementId(Integer cCreditcardsettlementId) {
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

  public CouponsSettlements cCurrencyId(Integer cCurrencyId) {
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

  public CouponsSettlements couponno(String couponno) {
    this.couponno = couponno;
    return this;
  }

  /**
   *  
   * @return couponno
   **/
  @Schema(description = " ")
  
    public String getCouponno() {
    return couponno;
  }

  public void setCouponno(String couponno) {
    this.couponno = couponno;
  }

  public CouponsSettlements cPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
    return this;
  }

  /**
   * Identificador del pago
   * @return cPaymentId
   **/
  @Schema(required = true, description = "Identificador del pago")
      @NotNull

    public Integer getCPaymentId() {
    return cPaymentId;
  }

  public void setCPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
  }

  public CouponsSettlements created(String created) {
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

  public CouponsSettlements createdby(Integer createdby) {
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

  public CouponsSettlements creditcardno(String creditcardno) {
    this.creditcardno = creditcardno;
    return this;
  }

  /**
   *  
   * @return creditcardno
   **/
  @Schema(description = " ")
  
    public String getCreditcardno() {
    return creditcardno;
  }

  public void setCreditcardno(String creditcardno) {
    this.creditcardno = creditcardno;
  }

  public CouponsSettlements include(Boolean include) {
    this.include = include;
    return this;
  }

  /**
   *  
   * @return include
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isInclude() {
    return include;
  }

  public void setInclude(Boolean include) {
    this.include = include;
  }

  public CouponsSettlements isactive(Boolean isactive) {
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

  public CouponsSettlements isreconciled(Boolean isreconciled) {
    this.isreconciled = isreconciled;
    return this;
  }

  /**
   *  
   * @return isreconciled
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsreconciled() {
    return isreconciled;
  }

  public void setIsreconciled(Boolean isreconciled) {
    this.isreconciled = isreconciled;
  }

  public CouponsSettlements isrefused(Boolean isrefused) {
    this.isrefused = isrefused;
    return this;
  }

  /**
   *  
   * @return isrefused
   **/
  @Schema(description = " ")
  
    public Boolean isIsrefused() {
    return isrefused;
  }

  public void setIsrefused(Boolean isrefused) {
    this.isrefused = isrefused;
  }

  public CouponsSettlements mEntidadfinancieraId(Integer mEntidadfinancieraId) {
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

  public CouponsSettlements mEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
    return this;
  }

  /**
   * Plan de Entidad Financiera
   * @return mEntidadfinancieraplanId
   **/
  @Schema(required = true, description = "Plan de Entidad Financiera")
      @NotNull

    public Integer getMEntidadfinancieraplanId() {
    return mEntidadfinancieraplanId;
  }

  public void setMEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
  }

  public CouponsSettlements paymentbatch(String paymentbatch) {
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

  public CouponsSettlements processed(Boolean processed) {
    this.processed = processed;
    return this;
  }

  /**
   * El documento ha sido procesado
   * @return processed
   **/
  @Schema(required = true, description = "El documento ha sido procesado")
      @NotNull

    public Boolean isProcessed() {
    return processed;
  }

  public void setProcessed(Boolean processed) {
    this.processed = processed;
  }

  public CouponsSettlements trxdate(String trxdate) {
    this.trxdate = trxdate;
    return this;
  }

  /**
   *  
   * @return trxdate
   **/
  @Schema(description = " ")
  
    public String getTrxdate() {
    return trxdate;
  }

  public void setTrxdate(String trxdate) {
    this.trxdate = trxdate;
  }

  public CouponsSettlements updated(String updated) {
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

  public CouponsSettlements updatedby(Integer updatedby) {
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

  public CouponsSettlements additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public CouponsSettlements addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public CouponsSettlements referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public CouponsSettlements addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    CouponsSettlements couponsSettlements = (CouponsSettlements) o;
    return Objects.equals(this.adClientId, couponsSettlements.adClientId) &&
        Objects.equals(this.adOrgId, couponsSettlements.adOrgId) &&
        Objects.equals(this.amount, couponsSettlements.amount) &&
        Objects.equals(this.aName, couponsSettlements.aName) &&
        Objects.equals(this.cCouponssettlementsId, couponsSettlements.cCouponssettlementsId) &&
        Objects.equals(this.cCreditcardcouponfilterId, couponsSettlements.cCreditcardcouponfilterId) &&
        Objects.equals(this.cCreditcardsettlementId, couponsSettlements.cCreditcardsettlementId) &&
        Objects.equals(this.cCurrencyId, couponsSettlements.cCurrencyId) &&
        Objects.equals(this.couponno, couponsSettlements.couponno) &&
        Objects.equals(this.cPaymentId, couponsSettlements.cPaymentId) &&
        Objects.equals(this.created, couponsSettlements.created) &&
        Objects.equals(this.createdby, couponsSettlements.createdby) &&
        Objects.equals(this.creditcardno, couponsSettlements.creditcardno) &&
        Objects.equals(this.include, couponsSettlements.include) &&
        Objects.equals(this.isactive, couponsSettlements.isactive) &&
        Objects.equals(this.isreconciled, couponsSettlements.isreconciled) &&
        Objects.equals(this.isrefused, couponsSettlements.isrefused) &&
        Objects.equals(this.mEntidadfinancieraId, couponsSettlements.mEntidadfinancieraId) &&
        Objects.equals(this.mEntidadfinancieraplanId, couponsSettlements.mEntidadfinancieraplanId) &&
        Objects.equals(this.paymentbatch, couponsSettlements.paymentbatch) &&
        Objects.equals(this.processed, couponsSettlements.processed) &&
        Objects.equals(this.trxdate, couponsSettlements.trxdate) &&
        Objects.equals(this.updated, couponsSettlements.updated) &&
        Objects.equals(this.updatedby, couponsSettlements.updatedby) &&
        Objects.equals(this.additionalvalues, couponsSettlements.additionalvalues) &&
        Objects.equals(this.referencedvalues, couponsSettlements.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, amount, aName, cCouponssettlementsId, cCreditcardcouponfilterId, cCreditcardsettlementId, cCurrencyId, couponno, cPaymentId, created, createdby, creditcardno, include, isactive, isreconciled, isrefused, mEntidadfinancieraId, mEntidadfinancieraplanId, paymentbatch, processed, trxdate, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponsSettlements {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    aName: ").append(toIndentedString(aName)).append("\n");
    sb.append("    cCouponssettlementsId: ").append(toIndentedString(cCouponssettlementsId)).append("\n");
    sb.append("    cCreditcardcouponfilterId: ").append(toIndentedString(cCreditcardcouponfilterId)).append("\n");
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    couponno: ").append(toIndentedString(couponno)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditcardno: ").append(toIndentedString(creditcardno)).append("\n");
    sb.append("    include: ").append(toIndentedString(include)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isreconciled: ").append(toIndentedString(isreconciled)).append("\n");
    sb.append("    isrefused: ").append(toIndentedString(isrefused)).append("\n");
    sb.append("    mEntidadfinancieraId: ").append(toIndentedString(mEntidadfinancieraId)).append("\n");
    sb.append("    mEntidadfinancieraplanId: ").append(toIndentedString(mEntidadfinancieraplanId)).append("\n");
    sb.append("    paymentbatch: ").append(toIndentedString(paymentbatch)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    trxdate: ").append(toIndentedString(trxdate)).append("\n");
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
