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
 * CashLine
 */
@Validated



public class CashLine   {
  @JsonProperty("accounting_c_charge_id")
  private Integer accountingCChargeId = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("authcode")
  private String authcode = null;

  @JsonProperty("authmatch")
  private Boolean authmatch = null;

  @JsonProperty("automaticgenerated")
  private Boolean automaticgenerated = null;

  @JsonProperty("c_allocationhdr_id")
  private Integer cAllocationhdrId = null;

  @JsonProperty("cashamount")
  private BigDecimal cashamount = null;

  @JsonProperty("cashtype")
  private String cashtype = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_cashcurrency_id")
  private Integer cCashcurrencyId = null;

  @JsonProperty("c_cash_id")
  private Integer cCashId = null;

  @JsonProperty("c_cashline_id")
  private Integer cCashlineId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("c_posjournal_id")
  private Integer cPosjournalId = null;

  @JsonProperty("c_pospaymentmedium_id")
  private Integer cPospaymentmediumId = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("discountamt")
  private BigDecimal discountamt = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isallocated")
  private Boolean isallocated = null;

  @JsonProperty("isgenerated")
  private Boolean isgenerated = null;

  @JsonProperty("line")
  private Integer line = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private Boolean processing = null;

  @JsonProperty("transfercash_id")
  private Integer transfercashId = null;

  @JsonProperty("transfercashline_id")
  private Integer transfercashlineId = null;

  @JsonProperty("updatebpbalance")
  private Boolean updatebpbalance = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("whiteoffamt")
  private BigDecimal whiteoffamt = null;

  @JsonProperty("writeoffamt")
  private BigDecimal writeoffamt = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public CashLine accountingCChargeId(Integer accountingCChargeId) {
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

  public CashLine adClientId(Integer adClientId) {
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

  public CashLine adOrgId(Integer adOrgId) {
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

  public CashLine amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Importe en una moneda definida
   * @return amount
   **/
  @Schema(required = true, description = "Importe en una moneda definida")
      @NotNull

    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public CashLine authcode(String authcode) {
    this.authcode = authcode;
    return this;
  }

  /**
   * Código de Autorización Offline
   * @return authcode
   **/
  @Schema(description = "Código de Autorización Offline")
  
    public String getAuthcode() {
    return authcode;
  }

  public void setAuthcode(String authcode) {
    this.authcode = authcode;
  }

  public CashLine authmatch(Boolean authmatch) {
    this.authmatch = authmatch;
    return this;
  }

  /**
   *  
   * @return authmatch
   **/
  @Schema(description = " ")
  
    public Boolean isAuthmatch() {
    return authmatch;
  }

  public void setAuthmatch(Boolean authmatch) {
    this.authmatch = authmatch;
  }

  public CashLine automaticgenerated(Boolean automaticgenerated) {
    this.automaticgenerated = automaticgenerated;
    return this;
  }

  /**
   *  
   * @return automaticgenerated
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAutomaticgenerated() {
    return automaticgenerated;
  }

  public void setAutomaticgenerated(Boolean automaticgenerated) {
    this.automaticgenerated = automaticgenerated;
  }

  public CashLine cAllocationhdrId(Integer cAllocationhdrId) {
    this.cAllocationhdrId = cAllocationhdrId;
    return this;
  }

  /**
   * Asignación de pagos
   * @return cAllocationhdrId
   **/
  @Schema(description = "Asignación de pagos")
  
    public Integer getCAllocationhdrId() {
    return cAllocationhdrId;
  }

  public void setCAllocationhdrId(Integer cAllocationhdrId) {
    this.cAllocationhdrId = cAllocationhdrId;
  }

  public CashLine cashamount(BigDecimal cashamount) {
    this.cashamount = cashamount;
    return this;
  }

  /**
   * Importe en la moneda del Libro de Caja
   * @return cashamount
   **/
  @Schema(required = true, description = "Importe en la moneda del Libro de Caja")
      @NotNull

    @Valid
    public BigDecimal getCashamount() {
    return cashamount;
  }

  public void setCashamount(BigDecimal cashamount) {
    this.cashamount = cashamount;
  }

  public CashLine cashtype(String cashtype) {
    this.cashtype = cashtype;
    return this;
  }

  /**
   * Fuente de Efectivo
   * @return cashtype
   **/
  @Schema(required = true, description = "Fuente de Efectivo")
      @NotNull

    public String getCashtype() {
    return cashtype;
  }

  public void setCashtype(String cashtype) {
    this.cashtype = cashtype;
  }

  public CashLine cBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
    return this;
  }

  /**
   * Cuenta Bancaria
   * @return cBankaccountId
   **/
  @Schema(description = "Cuenta Bancaria")
  
    public Integer getCBankaccountId() {
    return cBankaccountId;
  }

  public void setCBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
  }

  public CashLine cBpartnerId(Integer cBpartnerId) {
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

  public CashLine cCashcurrencyId(Integer cCashcurrencyId) {
    this.cCashcurrencyId = cCashcurrencyId;
    return this;
  }

  /**
   * Moneda original del Libro de Caja
   * @return cCashcurrencyId
   **/
  @Schema(description = "Moneda original del Libro de Caja")
  
    public Integer getCCashcurrencyId() {
    return cCashcurrencyId;
  }

  public void setCCashcurrencyId(Integer cCashcurrencyId) {
    this.cCashcurrencyId = cCashcurrencyId;
  }

  public CashLine cCashId(Integer cCashId) {
    this.cCashId = cCashId;
    return this;
  }

  /**
   * Libro de Caja
   * @return cCashId
   **/
  @Schema(required = true, description = "Libro de Caja")
      @NotNull

    public Integer getCCashId() {
    return cCashId;
  }

  public void setCCashId(Integer cCashId) {
    this.cCashId = cCashId;
  }

  public CashLine cCashlineId(Integer cCashlineId) {
    this.cCashlineId = cCashlineId;
    return this;
  }

  /**
   * Línea del Libro de Caja
   * @return cCashlineId
   **/
  @Schema(required = true, description = "Línea del Libro de Caja")
      @NotNull

    public Integer getCCashlineId() {
    return cCashlineId;
  }

  public void setCCashlineId(Integer cCashlineId) {
    this.cCashlineId = cCashlineId;
  }

  public CashLine cChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
    return this;
  }

  /**
   * Cargos adicionales del documento
   * @return cChargeId
   **/
  @Schema(description = "Cargos adicionales del documento")
  
    public Integer getCChargeId() {
    return cChargeId;
  }

  public void setCChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
  }

  public CashLine cCurrencyId(Integer cCurrencyId) {
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

  public CashLine cInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
    return this;
  }

  /**
   * Identificador de la factura
   * @return cInvoiceId
   **/
  @Schema(description = "Identificador de la factura")
  
    public Integer getCInvoiceId() {
    return cInvoiceId;
  }

  public void setCInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
  }

  public CashLine cPaymentId(Integer cPaymentId) {
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

  public CashLine cPosjournalId(Integer cPosjournalId) {
    this.cPosjournalId = cPosjournalId;
    return this;
  }

  /**
   * Caja Diaria
   * @return cPosjournalId
   **/
  @Schema(description = "Caja Diaria")
  
    public Integer getCPosjournalId() {
    return cPosjournalId;
  }

  public void setCPosjournalId(Integer cPosjournalId) {
    this.cPosjournalId = cPosjournalId;
  }

  public CashLine cPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
    return this;
  }

  /**
   * Medio de Pago de Terminal Punto de Venta
   * @return cPospaymentmediumId
   **/
  @Schema(description = "Medio de Pago de Terminal Punto de Venta")
  
    public Integer getCPospaymentmediumId() {
    return cPospaymentmediumId;
  }

  public void setCPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
  }

  public CashLine cProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
    return this;
  }

  /**
   * Identifica un proyecto único
   * @return cProjectId
   **/
  @Schema(description = "Identifica un proyecto único")
  
    public Integer getCProjectId() {
    return cProjectId;
  }

  public void setCProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
  }

  public CashLine created(String created) {
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

  public CashLine createdby(Integer createdby) {
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

  public CashLine description(String description) {
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

  public CashLine discountamt(BigDecimal discountamt) {
    this.discountamt = discountamt;
    return this;
  }

  /**
   * Importe del Descuento calculado
   * @return discountamt
   **/
  @Schema(description = "Importe del Descuento calculado")
  
    @Valid
    public BigDecimal getDiscountamt() {
    return discountamt;
  }

  public void setDiscountamt(BigDecimal discountamt) {
    this.discountamt = discountamt;
  }

  public CashLine docaction(String docaction) {
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

  public CashLine docstatus(String docstatus) {
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

  public CashLine isactive(Boolean isactive) {
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

  public CashLine isallocated(Boolean isallocated) {
    this.isallocated = isallocated;
    return this;
  }

  /**
   * Indica si el pago ha sido asignado
   * @return isallocated
   **/
  @Schema(required = true, description = "Indica si el pago ha sido asignado")
      @NotNull

    public Boolean isIsallocated() {
    return isallocated;
  }

  public void setIsallocated(Boolean isallocated) {
    this.isallocated = isallocated;
  }

  public CashLine isgenerated(Boolean isgenerated) {
    this.isgenerated = isgenerated;
    return this;
  }

  /**
   * Esta línea es generada
   * @return isgenerated
   **/
  @Schema(description = "Esta línea es generada")
  
    public Boolean isIsgenerated() {
    return isgenerated;
  }

  public void setIsgenerated(Boolean isgenerated) {
    this.isgenerated = isgenerated;
  }

  public CashLine line(Integer line) {
    this.line = line;
    return this;
  }

  /**
   * No. Línea único para este documento
   * @return line
   **/
  @Schema(required = true, description = "No. Línea único para este documento")
      @NotNull

    public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public CashLine processed(Boolean processed) {
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

  public CashLine processing(Boolean processing) {
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

  public CashLine transfercashId(Integer transfercashId) {
    this.transfercashId = transfercashId;
    return this;
  }

  /**
   * Caja Destino para la transferencia de efectivo
   * @return transfercashId
   **/
  @Schema(description = "Caja Destino para la transferencia de efectivo")
  
    public Integer getTransfercashId() {
    return transfercashId;
  }

  public void setTransfercashId(Integer transfercashId) {
    this.transfercashId = transfercashId;
  }

  public CashLine transfercashlineId(Integer transfercashlineId) {
    this.transfercashlineId = transfercashlineId;
    return this;
  }

  /**
   * Línea de Caja generada por una transferencia de efectivo entre cajas
   * @return transfercashlineId
   **/
  @Schema(description = "Línea de Caja generada por una transferencia de efectivo entre cajas")
  
    public Integer getTransfercashlineId() {
    return transfercashlineId;
  }

  public void setTransfercashlineId(Integer transfercashlineId) {
    this.transfercashlineId = transfercashlineId;
  }

  public CashLine updatebpbalance(Boolean updatebpbalance) {
    this.updatebpbalance = updatebpbalance;
    return this;
  }

  /**
   *  
   * @return updatebpbalance
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isUpdatebpbalance() {
    return updatebpbalance;
  }

  public void setUpdatebpbalance(Boolean updatebpbalance) {
    this.updatebpbalance = updatebpbalance;
  }

  public CashLine updated(String updated) {
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

  public CashLine updatedby(Integer updatedby) {
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

  public CashLine whiteoffamt(BigDecimal whiteoffamt) {
    this.whiteoffamt = whiteoffamt;
    return this;
  }

  /**
   *  
   * @return whiteoffamt
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getWhiteoffamt() {
    return whiteoffamt;
  }

  public void setWhiteoffamt(BigDecimal whiteoffamt) {
    this.whiteoffamt = whiteoffamt;
  }

  public CashLine writeoffamt(BigDecimal writeoffamt) {
    this.writeoffamt = writeoffamt;
    return this;
  }

  /**
   * Importe del Ajuste
   * @return writeoffamt
   **/
  @Schema(description = "Importe del Ajuste")
  
    @Valid
    public BigDecimal getWriteoffamt() {
    return writeoffamt;
  }

  public void setWriteoffamt(BigDecimal writeoffamt) {
    this.writeoffamt = writeoffamt;
  }

  public CashLine additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public CashLine addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public CashLine referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public CashLine addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    CashLine cashLine = (CashLine) o;
    return Objects.equals(this.accountingCChargeId, cashLine.accountingCChargeId) &&
        Objects.equals(this.adClientId, cashLine.adClientId) &&
        Objects.equals(this.adOrgId, cashLine.adOrgId) &&
        Objects.equals(this.amount, cashLine.amount) &&
        Objects.equals(this.authcode, cashLine.authcode) &&
        Objects.equals(this.authmatch, cashLine.authmatch) &&
        Objects.equals(this.automaticgenerated, cashLine.automaticgenerated) &&
        Objects.equals(this.cAllocationhdrId, cashLine.cAllocationhdrId) &&
        Objects.equals(this.cashamount, cashLine.cashamount) &&
        Objects.equals(this.cashtype, cashLine.cashtype) &&
        Objects.equals(this.cBankaccountId, cashLine.cBankaccountId) &&
        Objects.equals(this.cBpartnerId, cashLine.cBpartnerId) &&
        Objects.equals(this.cCashcurrencyId, cashLine.cCashcurrencyId) &&
        Objects.equals(this.cCashId, cashLine.cCashId) &&
        Objects.equals(this.cCashlineId, cashLine.cCashlineId) &&
        Objects.equals(this.cChargeId, cashLine.cChargeId) &&
        Objects.equals(this.cCurrencyId, cashLine.cCurrencyId) &&
        Objects.equals(this.cInvoiceId, cashLine.cInvoiceId) &&
        Objects.equals(this.cPaymentId, cashLine.cPaymentId) &&
        Objects.equals(this.cPosjournalId, cashLine.cPosjournalId) &&
        Objects.equals(this.cPospaymentmediumId, cashLine.cPospaymentmediumId) &&
        Objects.equals(this.cProjectId, cashLine.cProjectId) &&
        Objects.equals(this.created, cashLine.created) &&
        Objects.equals(this.createdby, cashLine.createdby) &&
        Objects.equals(this.description, cashLine.description) &&
        Objects.equals(this.discountamt, cashLine.discountamt) &&
        Objects.equals(this.docaction, cashLine.docaction) &&
        Objects.equals(this.docstatus, cashLine.docstatus) &&
        Objects.equals(this.isactive, cashLine.isactive) &&
        Objects.equals(this.isallocated, cashLine.isallocated) &&
        Objects.equals(this.isgenerated, cashLine.isgenerated) &&
        Objects.equals(this.line, cashLine.line) &&
        Objects.equals(this.processed, cashLine.processed) &&
        Objects.equals(this.processing, cashLine.processing) &&
        Objects.equals(this.transfercashId, cashLine.transfercashId) &&
        Objects.equals(this.transfercashlineId, cashLine.transfercashlineId) &&
        Objects.equals(this.updatebpbalance, cashLine.updatebpbalance) &&
        Objects.equals(this.updated, cashLine.updated) &&
        Objects.equals(this.updatedby, cashLine.updatedby) &&
        Objects.equals(this.whiteoffamt, cashLine.whiteoffamt) &&
        Objects.equals(this.writeoffamt, cashLine.writeoffamt) &&
        Objects.equals(this.additionalvalues, cashLine.additionalvalues) &&
        Objects.equals(this.referencedvalues, cashLine.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingCChargeId, adClientId, adOrgId, amount, authcode, authmatch, automaticgenerated, cAllocationhdrId, cashamount, cashtype, cBankaccountId, cBpartnerId, cCashcurrencyId, cCashId, cCashlineId, cChargeId, cCurrencyId, cInvoiceId, cPaymentId, cPosjournalId, cPospaymentmediumId, cProjectId, created, createdby, description, discountamt, docaction, docstatus, isactive, isallocated, isgenerated, line, processed, processing, transfercashId, transfercashlineId, updatebpbalance, updated, updatedby, whiteoffamt, writeoffamt, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CashLine {\n");
    
    sb.append("    accountingCChargeId: ").append(toIndentedString(accountingCChargeId)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    authcode: ").append(toIndentedString(authcode)).append("\n");
    sb.append("    authmatch: ").append(toIndentedString(authmatch)).append("\n");
    sb.append("    automaticgenerated: ").append(toIndentedString(automaticgenerated)).append("\n");
    sb.append("    cAllocationhdrId: ").append(toIndentedString(cAllocationhdrId)).append("\n");
    sb.append("    cashamount: ").append(toIndentedString(cashamount)).append("\n");
    sb.append("    cashtype: ").append(toIndentedString(cashtype)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCashcurrencyId: ").append(toIndentedString(cCashcurrencyId)).append("\n");
    sb.append("    cCashId: ").append(toIndentedString(cCashId)).append("\n");
    sb.append("    cCashlineId: ").append(toIndentedString(cCashlineId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    cPosjournalId: ").append(toIndentedString(cPosjournalId)).append("\n");
    sb.append("    cPospaymentmediumId: ").append(toIndentedString(cPospaymentmediumId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountamt: ").append(toIndentedString(discountamt)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isallocated: ").append(toIndentedString(isallocated)).append("\n");
    sb.append("    isgenerated: ").append(toIndentedString(isgenerated)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    transfercashId: ").append(toIndentedString(transfercashId)).append("\n");
    sb.append("    transfercashlineId: ").append(toIndentedString(transfercashlineId)).append("\n");
    sb.append("    updatebpbalance: ").append(toIndentedString(updatebpbalance)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    whiteoffamt: ").append(toIndentedString(whiteoffamt)).append("\n");
    sb.append("    writeoffamt: ").append(toIndentedString(writeoffamt)).append("\n");
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
