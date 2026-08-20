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
 * CreditCardSettlement
 */
@Validated



public class CreditCardSettlement   {
  @JsonProperty("accounting_c_charge_id")
  private Integer accountingCChargeId = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("adquirente")
  private String adquirente = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("commissionamount")
  private BigDecimal commissionamount = null;

  @JsonProperty("couponstotalamount")
  private BigDecimal couponstotalamount = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("creditcardtype")
  private String creditcardtype = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("establishmentnumber")
  private String establishmentnumber = null;

  @JsonProperty("expenses")
  private BigDecimal expenses = null;

  @JsonProperty("financingservice")
  private String financingservice = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("isreconciled")
  private Boolean isreconciled = null;

  @JsonProperty("ivaamount")
  private BigDecimal ivaamount = null;

  @JsonProperty("m_numerocomercio_id")
  private Integer mNumerocomercioId = null;

  @JsonProperty("netamount")
  private BigDecimal netamount = null;

  @JsonProperty("payment")
  private String payment = null;

  @JsonProperty("paymentdate")
  private String paymentdate = null;

  @JsonProperty("perception")
  private BigDecimal perception = null;

  @JsonProperty("posted")
  private String posted = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private Boolean processing = null;

  @JsonProperty("reconcilecoupons")
  private String reconcilecoupons = null;

  @JsonProperty("selectallcoupons")
  private String selectallcoupons = null;

  @JsonProperty("settlementno")
  private String settlementno = null;

  @JsonProperty("unselectallcoupons")
  private String unselectallcoupons = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("withholding")
  private BigDecimal withholding = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public CreditCardSettlement accountingCChargeId(Integer accountingCChargeId) {
    this.accountingCChargeId = accountingCChargeId;
    return this;
  }

  /**
   * Cuenta Contable Alternativa
   * @return accountingCChargeId
   **/
  @Schema(description = "Cuenta Contable Alternativa")
  
    public Integer getAccountingCChargeId() {
    return accountingCChargeId;
  }

  public void setAccountingCChargeId(Integer accountingCChargeId) {
    this.accountingCChargeId = accountingCChargeId;
  }

  public CreditCardSettlement adClientId(Integer adClientId) {
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

  public CreditCardSettlement adOrgId(Integer adOrgId) {
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

  public CreditCardSettlement adquirente(String adquirente) {
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

  public CreditCardSettlement amount(BigDecimal amount) {
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

  public CreditCardSettlement cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Identifica una Entidad Comercial
   * @return cBpartnerId
   **/
  @Schema(required = true, description = "Identifica una Entidad Comercial")
      @NotNull

    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public CreditCardSettlement cCreditcardsettlementId(Integer cCreditcardsettlementId) {
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

  public CreditCardSettlement cCurrencyId(Integer cCurrencyId) {
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

  public CreditCardSettlement commissionamount(BigDecimal commissionamount) {
    this.commissionamount = commissionamount;
    return this;
  }

  /**
   *  
   * @return commissionamount
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getCommissionamount() {
    return commissionamount;
  }

  public void setCommissionamount(BigDecimal commissionamount) {
    this.commissionamount = commissionamount;
  }

  public CreditCardSettlement couponstotalamount(BigDecimal couponstotalamount) {
    this.couponstotalamount = couponstotalamount;
    return this;
  }

  /**
   *  
   * @return couponstotalamount
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getCouponstotalamount() {
    return couponstotalamount;
  }

  public void setCouponstotalamount(BigDecimal couponstotalamount) {
    this.couponstotalamount = couponstotalamount;
  }

  public CreditCardSettlement cPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
    return this;
  }

  /**
   * Identificador del pago
   * @return cPaymentId
   **/
  @Schema(description = "Identificador del pago")
  
    public Integer getCPaymentId() {
    return cPaymentId;
  }

  public void setCPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
  }

  public CreditCardSettlement created(String created) {
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

  public CreditCardSettlement createdby(Integer createdby) {
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

  public CreditCardSettlement creditcardtype(String creditcardtype) {
    this.creditcardtype = creditcardtype;
    return this;
  }

  /**
   * Tarjeta de Crédito 
   * @return creditcardtype
   **/
  @Schema(description = "Tarjeta de Crédito ")
  
    public String getCreditcardtype() {
    return creditcardtype;
  }

  public void setCreditcardtype(String creditcardtype) {
    this.creditcardtype = creditcardtype;
  }

  public CreditCardSettlement docaction(String docaction) {
    this.docaction = docaction;
    return this;
  }

  /**
   * El estado destino del documento
   * @return docaction
   **/
  @Schema(required = true, description = "El estado destino del documento")
      @NotNull

    public String getDocaction() {
    return docaction;
  }

  public void setDocaction(String docaction) {
    this.docaction = docaction;
  }

  public CreditCardSettlement docstatus(String docstatus) {
    this.docstatus = docstatus;
    return this;
  }

  /**
   * El estado actual del documento
   * @return docstatus
   **/
  @Schema(required = true, description = "El estado actual del documento")
      @NotNull

    public String getDocstatus() {
    return docstatus;
  }

  public void setDocstatus(String docstatus) {
    this.docstatus = docstatus;
  }

  public CreditCardSettlement establishmentnumber(String establishmentnumber) {
    this.establishmentnumber = establishmentnumber;
    return this;
  }

  /**
   * Nro de Comercio / Establecimiento SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.
   * @return establishmentnumber
   **/
  @Schema(description = "Nro de Comercio / Establecimiento SOLO existe en el diccionario de Tehuelche; sobre una instalacion con el core publico esta columna no existe y el campo se ignora en silencio.")
  
    public String getEstablishmentnumber() {
    return establishmentnumber;
  }

  public void setEstablishmentnumber(String establishmentnumber) {
    this.establishmentnumber = establishmentnumber;
  }

  public CreditCardSettlement expenses(BigDecimal expenses) {
    this.expenses = expenses;
    return this;
  }

  /**
   *  
   * @return expenses
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getExpenses() {
    return expenses;
  }

  public void setExpenses(BigDecimal expenses) {
    this.expenses = expenses;
  }

  public CreditCardSettlement financingservice(String financingservice) {
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

  public CreditCardSettlement isactive(Boolean isactive) {
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

  public CreditCardSettlement isapproved(Boolean isapproved) {
    this.isapproved = isapproved;
    return this;
  }

  /**
   * Indica si este documento requiere aprobación
   * @return isapproved
   **/
  @Schema(required = true, description = "Indica si este documento requiere aprobación")
      @NotNull

    public Boolean isIsapproved() {
    return isapproved;
  }

  public void setIsapproved(Boolean isapproved) {
    this.isapproved = isapproved;
  }

  public CreditCardSettlement isreconciled(Boolean isreconciled) {
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

  public CreditCardSettlement ivaamount(BigDecimal ivaamount) {
    this.ivaamount = ivaamount;
    return this;
  }

  /**
   *  
   * @return ivaamount
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getIvaamount() {
    return ivaamount;
  }

  public void setIvaamount(BigDecimal ivaamount) {
    this.ivaamount = ivaamount;
  }

  public CreditCardSettlement mNumerocomercioId(Integer mNumerocomercioId) {
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

  public CreditCardSettlement netamount(BigDecimal netamount) {
    this.netamount = netamount;
    return this;
  }

  /**
   *  
   * @return netamount
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getNetamount() {
    return netamount;
  }

  public void setNetamount(BigDecimal netamount) {
    this.netamount = netamount;
  }

  public CreditCardSettlement payment(String payment) {
    this.payment = payment;
    return this;
  }

  /**
   *  
   * @return payment
   **/
  @Schema(description = " ")
  
    public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }

  public CreditCardSettlement paymentdate(String paymentdate) {
    this.paymentdate = paymentdate;
    return this;
  }

  /**
   *  
   * @return paymentdate
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getPaymentdate() {
    return paymentdate;
  }

  public void setPaymentdate(String paymentdate) {
    this.paymentdate = paymentdate;
  }

  public CreditCardSettlement perception(BigDecimal perception) {
    this.perception = perception;
    return this;
  }

  /**
   *  
   * @return perception
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getPerception() {
    return perception;
  }

  public void setPerception(BigDecimal perception) {
    this.perception = perception;
  }

  public CreditCardSettlement posted(String posted) {
    this.posted = posted;
    return this;
  }

  /**
   * Las transacciones de Contabilidad General han sido procesadas
   * @return posted
   **/
  @Schema(description = "Las transacciones de Contabilidad General han sido procesadas")
  
    public String getPosted() {
    return posted;
  }

  public void setPosted(String posted) {
    this.posted = posted;
  }

  public CreditCardSettlement processed(Boolean processed) {
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

  public CreditCardSettlement processing(Boolean processing) {
    this.processing = processing;
    return this;
  }

  /**
   *  
   * @return processing
   **/
  @Schema(description = " ")
  
    public Boolean isProcessing() {
    return processing;
  }

  public void setProcessing(Boolean processing) {
    this.processing = processing;
  }

  public CreditCardSettlement reconcilecoupons(String reconcilecoupons) {
    this.reconcilecoupons = reconcilecoupons;
    return this;
  }

  /**
   *  
   * @return reconcilecoupons
   **/
  @Schema(description = " ")
  
    public String getReconcilecoupons() {
    return reconcilecoupons;
  }

  public void setReconcilecoupons(String reconcilecoupons) {
    this.reconcilecoupons = reconcilecoupons;
  }

  public CreditCardSettlement selectallcoupons(String selectallcoupons) {
    this.selectallcoupons = selectallcoupons;
    return this;
  }

  /**
   *  
   * @return selectallcoupons
   **/
  @Schema(description = " ")
  
    public String getSelectallcoupons() {
    return selectallcoupons;
  }

  public void setSelectallcoupons(String selectallcoupons) {
    this.selectallcoupons = selectallcoupons;
  }

  public CreditCardSettlement settlementno(String settlementno) {
    this.settlementno = settlementno;
    return this;
  }

  /**
   *  
   * @return settlementno
   **/
  @Schema(description = " ")
  
    public String getSettlementno() {
    return settlementno;
  }

  public void setSettlementno(String settlementno) {
    this.settlementno = settlementno;
  }

  public CreditCardSettlement unselectallcoupons(String unselectallcoupons) {
    this.unselectallcoupons = unselectallcoupons;
    return this;
  }

  /**
   *  
   * @return unselectallcoupons
   **/
  @Schema(description = " ")
  
    public String getUnselectallcoupons() {
    return unselectallcoupons;
  }

  public void setUnselectallcoupons(String unselectallcoupons) {
    this.unselectallcoupons = unselectallcoupons;
  }

  public CreditCardSettlement updated(String updated) {
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

  public CreditCardSettlement updatedby(Integer updatedby) {
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

  public CreditCardSettlement withholding(BigDecimal withholding) {
    this.withholding = withholding;
    return this;
  }

  /**
   *  
   * @return withholding
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getWithholding() {
    return withholding;
  }

  public void setWithholding(BigDecimal withholding) {
    this.withholding = withholding;
  }

  public CreditCardSettlement additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public CreditCardSettlement addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public CreditCardSettlement referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public CreditCardSettlement addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    CreditCardSettlement creditCardSettlement = (CreditCardSettlement) o;
    return Objects.equals(this.accountingCChargeId, creditCardSettlement.accountingCChargeId) &&
        Objects.equals(this.adClientId, creditCardSettlement.adClientId) &&
        Objects.equals(this.adOrgId, creditCardSettlement.adOrgId) &&
        Objects.equals(this.adquirente, creditCardSettlement.adquirente) &&
        Objects.equals(this.amount, creditCardSettlement.amount) &&
        Objects.equals(this.cBpartnerId, creditCardSettlement.cBpartnerId) &&
        Objects.equals(this.cCreditcardsettlementId, creditCardSettlement.cCreditcardsettlementId) &&
        Objects.equals(this.cCurrencyId, creditCardSettlement.cCurrencyId) &&
        Objects.equals(this.commissionamount, creditCardSettlement.commissionamount) &&
        Objects.equals(this.couponstotalamount, creditCardSettlement.couponstotalamount) &&
        Objects.equals(this.cPaymentId, creditCardSettlement.cPaymentId) &&
        Objects.equals(this.created, creditCardSettlement.created) &&
        Objects.equals(this.createdby, creditCardSettlement.createdby) &&
        Objects.equals(this.creditcardtype, creditCardSettlement.creditcardtype) &&
        Objects.equals(this.docaction, creditCardSettlement.docaction) &&
        Objects.equals(this.docstatus, creditCardSettlement.docstatus) &&
        Objects.equals(this.establishmentnumber, creditCardSettlement.establishmentnumber) &&
        Objects.equals(this.expenses, creditCardSettlement.expenses) &&
        Objects.equals(this.financingservice, creditCardSettlement.financingservice) &&
        Objects.equals(this.isactive, creditCardSettlement.isactive) &&
        Objects.equals(this.isapproved, creditCardSettlement.isapproved) &&
        Objects.equals(this.isreconciled, creditCardSettlement.isreconciled) &&
        Objects.equals(this.ivaamount, creditCardSettlement.ivaamount) &&
        Objects.equals(this.mNumerocomercioId, creditCardSettlement.mNumerocomercioId) &&
        Objects.equals(this.netamount, creditCardSettlement.netamount) &&
        Objects.equals(this.payment, creditCardSettlement.payment) &&
        Objects.equals(this.paymentdate, creditCardSettlement.paymentdate) &&
        Objects.equals(this.perception, creditCardSettlement.perception) &&
        Objects.equals(this.posted, creditCardSettlement.posted) &&
        Objects.equals(this.processed, creditCardSettlement.processed) &&
        Objects.equals(this.processing, creditCardSettlement.processing) &&
        Objects.equals(this.reconcilecoupons, creditCardSettlement.reconcilecoupons) &&
        Objects.equals(this.selectallcoupons, creditCardSettlement.selectallcoupons) &&
        Objects.equals(this.settlementno, creditCardSettlement.settlementno) &&
        Objects.equals(this.unselectallcoupons, creditCardSettlement.unselectallcoupons) &&
        Objects.equals(this.updated, creditCardSettlement.updated) &&
        Objects.equals(this.updatedby, creditCardSettlement.updatedby) &&
        Objects.equals(this.withholding, creditCardSettlement.withholding) &&
        Objects.equals(this.additionalvalues, creditCardSettlement.additionalvalues) &&
        Objects.equals(this.referencedvalues, creditCardSettlement.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingCChargeId, adClientId, adOrgId, adquirente, amount, cBpartnerId, cCreditcardsettlementId, cCurrencyId, commissionamount, couponstotalamount, cPaymentId, created, createdby, creditcardtype, docaction, docstatus, establishmentnumber, expenses, financingservice, isactive, isapproved, isreconciled, ivaamount, mNumerocomercioId, netamount, payment, paymentdate, perception, posted, processed, processing, reconcilecoupons, selectallcoupons, settlementno, unselectallcoupons, updated, updatedby, withholding, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardSettlement {\n");
    
    sb.append("    accountingCChargeId: ").append(toIndentedString(accountingCChargeId)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adquirente: ").append(toIndentedString(adquirente)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    commissionamount: ").append(toIndentedString(commissionamount)).append("\n");
    sb.append("    couponstotalamount: ").append(toIndentedString(couponstotalamount)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditcardtype: ").append(toIndentedString(creditcardtype)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    establishmentnumber: ").append(toIndentedString(establishmentnumber)).append("\n");
    sb.append("    expenses: ").append(toIndentedString(expenses)).append("\n");
    sb.append("    financingservice: ").append(toIndentedString(financingservice)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    isreconciled: ").append(toIndentedString(isreconciled)).append("\n");
    sb.append("    ivaamount: ").append(toIndentedString(ivaamount)).append("\n");
    sb.append("    mNumerocomercioId: ").append(toIndentedString(mNumerocomercioId)).append("\n");
    sb.append("    netamount: ").append(toIndentedString(netamount)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    paymentdate: ").append(toIndentedString(paymentdate)).append("\n");
    sb.append("    perception: ").append(toIndentedString(perception)).append("\n");
    sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    reconcilecoupons: ").append(toIndentedString(reconcilecoupons)).append("\n");
    sb.append("    selectallcoupons: ").append(toIndentedString(selectallcoupons)).append("\n");
    sb.append("    settlementno: ").append(toIndentedString(settlementno)).append("\n");
    sb.append("    unselectallcoupons: ").append(toIndentedString(unselectallcoupons)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    withholding: ").append(toIndentedString(withholding)).append("\n");
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
