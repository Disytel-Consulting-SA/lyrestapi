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
 * Payment
 */
@Validated



public class Payment   {
  @JsonProperty("a_bank")
  private String aBank = null;

  @JsonProperty("accounting_c_charge_id")
  private Integer accountingCChargeId = null;

  @JsonProperty("accountno")
  private String accountno = null;

  @JsonProperty("a_city")
  private String aCity = null;

  @JsonProperty("a_country")
  private String aCountry = null;

  @JsonProperty("a_cuit")
  private String aCuit = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("a_email")
  private String aEmail = null;

  @JsonProperty("a_ident_dl")
  private String aIdentDl = null;

  @JsonProperty("a_ident_ssn")
  private String aIdentSsn = null;

  @JsonProperty("a_name")
  private String aName = null;

  @JsonProperty("a_state")
  private String aState = null;

  @JsonProperty("a_street")
  private String aStreet = null;

  @JsonProperty("auditstatus")
  private String auditstatus = null;

  @JsonProperty("authcode")
  private String authcode = null;

  @JsonProperty("authmatch")
  private Boolean authmatch = null;

  @JsonProperty("a_zip")
  private String aZip = null;

  @JsonProperty("banklist_registerno")
  private String banklistRegisterno = null;

  @JsonProperty("bank_payment_date")
  private String bankPaymentDate = null;

  @JsonProperty("bank_payment_documentno")
  private String bankPaymentDocumentno = null;

  @JsonProperty("bank_payment_msg_description")
  private String bankPaymentMsgDescription = null;

  @JsonProperty("c_activity_id")
  private Integer cActivityId = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bank_id")
  private Integer cBankId = null;

  @JsonProperty("c_bankpaymentstatus_id")
  private Integer cBankpaymentstatusId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_bp_bankaccount_id")
  private Integer cBpBankaccountId = null;

  @JsonProperty("c_campaign_id")
  private Integer cCampaignId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_conversiontype_id")
  private Integer cConversiontypeId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("chargeamt")
  private Integer chargeamt = null;

  @JsonProperty("checked")
  private Boolean checked = null;

  @JsonProperty("checkno")
  private String checkno = null;

  @JsonProperty("checkstatus")
  private String checkstatus = null;

  @JsonProperty("c_invoice_check_rejected_id")
  private Integer cInvoiceCheckRejectedId = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  @JsonProperty("couponbatchnumber")
  private String couponbatchnumber = null;

  @JsonProperty("couponnumber")
  private String couponnumber = null;

  @JsonProperty("c_paymentbatch_id")
  private Integer cPaymentbatchId = null;

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

  @JsonProperty("creditcardexpmm")
  private Integer creditcardexpmm = null;

  @JsonProperty("creditcardexpyy")
  private Integer creditcardexpyy = null;

  @JsonProperty("creditcardnumber")
  private String creditcardnumber = null;

  @JsonProperty("creditcardtype")
  private String creditcardtype = null;

  @JsonProperty("creditcardvv")
  private String creditcardvv = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("dateemissioncheck")
  private String dateemissioncheck = null;

  @JsonProperty("datetrx")
  private String datetrx = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("discountamt")
  private BigDecimal discountamt = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("duedate")
  private String duedate = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isallocated")
  private Boolean isallocated = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("isdelayedcapture")
  private Boolean isdelayedcapture = null;

  @JsonProperty("ismanual")
  private Boolean ismanual = null;

  @JsonProperty("isonline")
  private Boolean isonline = null;

  @JsonProperty("isoverunderpayment")
  private Boolean isoverunderpayment = null;

  @JsonProperty("isprepayment")
  private Boolean isprepayment = null;

  @JsonProperty("isreceipt")
  private String isreceipt = null;

  @JsonProperty("isreconciled")
  private Boolean isreconciled = null;

  @JsonProperty("isselfservice")
  private Boolean isselfservice = null;

  @JsonProperty("issotrx")
  private Boolean issotrx = null;

  @JsonProperty("m_boletadeposito_id")
  private Integer mBoletadepositoId = null;

  @JsonProperty("m_entidadfinancieraplan_id")
  private Integer mEntidadfinancieraplanId = null;

  @JsonProperty("micr")
  private String micr = null;

  @JsonProperty("oprocessing")
  private String oprocessing = null;

  @JsonProperty("original_ref_payment_id")
  private Integer originalRefPaymentId = null;

  @JsonProperty("orig_trxid")
  private String origTrxid = null;

  @JsonProperty("overunderamt")
  private BigDecimal overunderamt = null;

  @JsonProperty("payamt")
  private BigDecimal payamt = null;

  @JsonProperty("ponum")
  private String ponum = null;

  @JsonProperty("posnet")
  private String posnet = null;

  @JsonProperty("posted")
  private String posted = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private String processing = null;

  @JsonProperty("r_authcode")
  private String rAuthcode = null;

  @JsonProperty("r_authcode_dc")
  private String rAuthcodeDc = null;

  @JsonProperty("r_avsaddr")
  private String rAvsaddr = null;

  @JsonProperty("r_avszip")
  private String rAvszip = null;

  @JsonProperty("r_cvv2match")
  private Boolean rCvv2match = null;

  @JsonProperty("ref_payment_id")
  private Integer refPaymentId = null;

  @JsonProperty("rejectedcomments")
  private String rejectedcomments = null;

  @JsonProperty("rejecteddate")
  private String rejecteddate = null;

  @JsonProperty("r_info")
  private String rInfo = null;

  @JsonProperty("routingno")
  private String routingno = null;

  @JsonProperty("r_pnref")
  private String rPnref = null;

  @JsonProperty("r_pnref_dc")
  private String rPnrefDc = null;

  @JsonProperty("r_respmsg")
  private String rRespmsg = null;

  @JsonProperty("r_result")
  private String rResult = null;

  @JsonProperty("swipe")
  private String swipe = null;

  @JsonProperty("taxamt")
  private BigDecimal taxamt = null;

  @JsonProperty("tendertype")
  private String tendertype = null;

  @JsonProperty("trxtype")
  private String trxtype = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("user1_id")
  private Integer user1Id = null;

  @JsonProperty("user2_id")
  private Integer user2Id = null;

  @JsonProperty("voiceauthcode")
  private String voiceauthcode = null;

  @JsonProperty("writeoffamt")
  private BigDecimal writeoffamt = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Payment aBank(String aBank) {
    this.aBank = aBank;
    return this;
  }

  /**
   *  
   * @return aBank
   **/
  @Schema(description = " ")
  
    public String getABank() {
    return aBank;
  }

  public void setABank(String aBank) {
    this.aBank = aBank;
  }

  public Payment accountingCChargeId(Integer accountingCChargeId) {
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

  public Payment accountno(String accountno) {
    this.accountno = accountno;
    return this;
  }

  /**
   * Número de cuenta
   * @return accountno
   **/
  @Schema(description = "Número de cuenta")
  
    public String getAccountno() {
    return accountno;
  }

  public void setAccountno(String accountno) {
    this.accountno = accountno;
  }

  public Payment aCity(String aCity) {
    this.aCity = aCity;
    return this;
  }

  /**
   * Ciudad en la Tarjeta de Crédito o el Poseedor de la cuenta
   * @return aCity
   **/
  @Schema(description = "Ciudad en la Tarjeta de Crédito o el Poseedor de la cuenta")
  
    public String getACity() {
    return aCity;
  }

  public void setACity(String aCity) {
    this.aCity = aCity;
  }

  public Payment aCountry(String aCountry) {
    this.aCountry = aCountry;
    return this;
  }

  /**
   * País
   * @return aCountry
   **/
  @Schema(description = "País")
  
    public String getACountry() {
    return aCountry;
  }

  public void setACountry(String aCountry) {
    this.aCountry = aCountry;
  }

  public Payment aCuit(String aCuit) {
    this.aCuit = aCuit;
    return this;
  }

  /**
   *  
   * @return aCuit
   **/
  @Schema(description = " ")
  
    public String getACuit() {
    return aCuit;
  }

  public void setACuit(String aCuit) {
    this.aCuit = aCuit;
  }

  public Payment adClientId(Integer adClientId) {
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

  public Payment adOrgId(Integer adOrgId) {
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

  public Payment adOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
    return this;
  }

  /**
   * Organización que inicia o ejecuta la transacción
   * @return adOrgtrxId
   **/
  @Schema(description = "Organización que inicia o ejecuta la transacción")
  
    public Integer getAdOrgtrxId() {
    return adOrgtrxId;
  }

  public void setAdOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
  }

  public Payment aEmail(String aEmail) {
    this.aEmail = aEmail;
    return this;
  }

  /**
   * Dirección de Correo Electrónico
   * @return aEmail
   **/
  @Schema(description = "Dirección de Correo Electrónico")
  
    public String getAEmail() {
    return aEmail;
  }

  public void setAEmail(String aEmail) {
    this.aEmail = aEmail;
  }

  public Payment aIdentDl(String aIdentDl) {
    this.aIdentDl = aIdentDl;
    return this;
  }

  /**
   * Identificación de pago - Licencia de Conducir
   * @return aIdentDl
   **/
  @Schema(description = "Identificación de pago - Licencia de Conducir")
  
    public String getAIdentDl() {
    return aIdentDl;
  }

  public void setAIdentDl(String aIdentDl) {
    this.aIdentDl = aIdentDl;
  }

  public Payment aIdentSsn(String aIdentSsn) {
    this.aIdentSsn = aIdentSsn;
    return this;
  }

  /**
   * Identificación de pago - No. Del Seguro Social
   * @return aIdentSsn
   **/
  @Schema(description = "Identificación de pago - No. Del Seguro Social")
  
    public String getAIdentSsn() {
    return aIdentSsn;
  }

  public void setAIdentSsn(String aIdentSsn) {
    this.aIdentSsn = aIdentSsn;
  }

  public Payment aName(String aName) {
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

  public Payment aState(String aState) {
    this.aState = aState;
    return this;
  }

  /**
   * Estado de la Tarjeta de Crédito o el Poseedor de la cuenta
   * @return aState
   **/
  @Schema(description = "Estado de la Tarjeta de Crédito o el Poseedor de la cuenta")
  
    public String getAState() {
    return aState;
  }

  public void setAState(String aState) {
    this.aState = aState;
  }

  public Payment aStreet(String aStreet) {
    this.aStreet = aStreet;
    return this;
  }

  /**
   * Direccion en la Tarjeta de Crédito 
   * @return aStreet
   **/
  @Schema(description = "Direccion en la Tarjeta de Crédito ")
  
    public String getAStreet() {
    return aStreet;
  }

  public void setAStreet(String aStreet) {
    this.aStreet = aStreet;
  }

  public Payment auditstatus(String auditstatus) {
    this.auditstatus = auditstatus;
    return this;
  }

  /**
   *  
   * @return auditstatus
   **/
  @Schema(description = " ")
  
    public String getAuditstatus() {
    return auditstatus;
  }

  public void setAuditstatus(String auditstatus) {
    this.auditstatus = auditstatus;
  }

  public Payment authcode(String authcode) {
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

  public Payment authmatch(Boolean authmatch) {
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

  public Payment aZip(String aZip) {
    this.aZip = aZip;
    return this;
  }

  /**
   * Código Postal de la Tarjeta de Crédito o el Poseedor de la cuenta
   * @return aZip
   **/
  @Schema(description = "Código Postal de la Tarjeta de Crédito o el Poseedor de la cuenta")
  
    public String getAZip() {
    return aZip;
  }

  public void setAZip(String aZip) {
    this.aZip = aZip;
  }

  public Payment banklistRegisterno(String banklistRegisterno) {
    this.banklistRegisterno = banklistRegisterno;
    return this;
  }

  /**
   * Número de Registro de Orden en la Lista
   * @return banklistRegisterno
   **/
  @Schema(description = "Número de Registro de Orden en la Lista")
  
    public String getBanklistRegisterno() {
    return banklistRegisterno;
  }

  public void setBanklistRegisterno(String banklistRegisterno) {
    this.banklistRegisterno = banklistRegisterno;
  }

  public Payment bankPaymentDate(String bankPaymentDate) {
    this.bankPaymentDate = bankPaymentDate;
    return this;
  }

  /**
   *  
   * @return bankPaymentDate
   **/
  @Schema(description = " ")
  
    public String getBankPaymentDate() {
    return bankPaymentDate;
  }

  public void setBankPaymentDate(String bankPaymentDate) {
    this.bankPaymentDate = bankPaymentDate;
  }

  public Payment bankPaymentDocumentno(String bankPaymentDocumentno) {
    this.bankPaymentDocumentno = bankPaymentDocumentno;
    return this;
  }

  /**
   *  
   * @return bankPaymentDocumentno
   **/
  @Schema(description = " ")
  
    public String getBankPaymentDocumentno() {
    return bankPaymentDocumentno;
  }

  public void setBankPaymentDocumentno(String bankPaymentDocumentno) {
    this.bankPaymentDocumentno = bankPaymentDocumentno;
  }

  public Payment bankPaymentMsgDescription(String bankPaymentMsgDescription) {
    this.bankPaymentMsgDescription = bankPaymentMsgDescription;
    return this;
  }

  /**
   * Descripción de Mensaje de Estado Adicional
   * @return bankPaymentMsgDescription
   **/
  @Schema(description = "Descripción de Mensaje de Estado Adicional")
  
    public String getBankPaymentMsgDescription() {
    return bankPaymentMsgDescription;
  }

  public void setBankPaymentMsgDescription(String bankPaymentMsgDescription) {
    this.bankPaymentMsgDescription = bankPaymentMsgDescription;
  }

  public Payment cActivityId(Integer cActivityId) {
    this.cActivityId = cActivityId;
    return this;
  }

  /**
   * Actividad de Negocio
   * @return cActivityId
   **/
  @Schema(description = "Actividad de Negocio")
  
    public Integer getCActivityId() {
    return cActivityId;
  }

  public void setCActivityId(Integer cActivityId) {
    this.cActivityId = cActivityId;
  }

  public Payment cBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
    return this;
  }

  /**
   * Cuenta Bancaria
   * @return cBankaccountId
   **/
  @Schema(required = true, description = "Cuenta Bancaria")
      @NotNull

    public Integer getCBankaccountId() {
    return cBankaccountId;
  }

  public void setCBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
  }

  public Payment cBankId(Integer cBankId) {
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

  public Payment cBankpaymentstatusId(Integer cBankpaymentstatusId) {
    this.cBankpaymentstatusId = cBankpaymentstatusId;
    return this;
  }

  /**
   *  
   * @return cBankpaymentstatusId
   **/
  @Schema(description = " ")
  
    public Integer getCBankpaymentstatusId() {
    return cBankpaymentstatusId;
  }

  public void setCBankpaymentstatusId(Integer cBankpaymentstatusId) {
    this.cBankpaymentstatusId = cBankpaymentstatusId;
  }

  public Payment cBpartnerId(Integer cBpartnerId) {
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

  public Payment cBpBankaccountId(Integer cBpBankaccountId) {
    this.cBpBankaccountId = cBpBankaccountId;
    return this;
  }

  /**
   * Cuenta de Banco de la Entidad
   * @return cBpBankaccountId
   **/
  @Schema(description = "Cuenta de Banco de la Entidad")
  
    public Integer getCBpBankaccountId() {
    return cBpBankaccountId;
  }

  public void setCBpBankaccountId(Integer cBpBankaccountId) {
    this.cBpBankaccountId = cBpBankaccountId;
  }

  public Payment cCampaignId(Integer cCampaignId) {
    this.cCampaignId = cCampaignId;
    return this;
  }

  /**
   * Campaña de Marketing
   * @return cCampaignId
   **/
  @Schema(description = "Campaña de Marketing")
  
    public Integer getCCampaignId() {
    return cCampaignId;
  }

  public void setCCampaignId(Integer cCampaignId) {
    this.cCampaignId = cCampaignId;
  }

  public Payment cChargeId(Integer cChargeId) {
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

  public Payment cConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
    return this;
  }

  /**
   * Tipo de Divisa
   * @return cConversiontypeId
   **/
  @Schema(description = "Tipo de Divisa")
  
    public Integer getCConversiontypeId() {
    return cConversiontypeId;
  }

  public void setCConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
  }

  public Payment cCurrencyId(Integer cCurrencyId) {
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

  public Payment cDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
    return this;
  }

  /**
   * Tipo de documento o reglas
   * @return cDoctypeId
   **/
  @Schema(required = true, description = "Tipo de documento o reglas")
      @NotNull

    public Integer getCDoctypeId() {
    return cDoctypeId;
  }

  public void setCDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
  }

  public Payment chargeamt(Integer chargeamt) {
    this.chargeamt = chargeamt;
    return this;
  }

  /**
   * Importe de Cargo
   * @return chargeamt
   **/
  @Schema(description = "Importe de Cargo")
  
    public Integer getChargeamt() {
    return chargeamt;
  }

  public void setChargeamt(Integer chargeamt) {
    this.chargeamt = chargeamt;
  }

  public Payment checked(Boolean checked) {
    this.checked = checked;
    return this;
  }

  /**
   *  
   * @return checked
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isChecked() {
    return checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  public Payment checkno(String checkno) {
    this.checkno = checkno;
    return this;
  }

  /**
   * Nro. de Cheque
   * @return checkno
   **/
  @Schema(description = "Nro. de Cheque")
  
    public String getCheckno() {
    return checkno;
  }

  public void setCheckno(String checkno) {
    this.checkno = checkno;
  }

  public Payment checkstatus(String checkstatus) {
    this.checkstatus = checkstatus;
    return this;
  }

  /**
   *  
   * @return checkstatus
   **/
  @Schema(description = " ")
  
    public String getCheckstatus() {
    return checkstatus;
  }

  public void setCheckstatus(String checkstatus) {
    this.checkstatus = checkstatus;
  }

  public Payment cInvoiceCheckRejectedId(Integer cInvoiceCheckRejectedId) {
    this.cInvoiceCheckRejectedId = cInvoiceCheckRejectedId;
    return this;
  }

  /**
   * Comprobante generado por el proceso de cheque rechazado
   * @return cInvoiceCheckRejectedId
   **/
  @Schema(description = "Comprobante generado por el proceso de cheque rechazado")
  
    public Integer getCInvoiceCheckRejectedId() {
    return cInvoiceCheckRejectedId;
  }

  public void setCInvoiceCheckRejectedId(Integer cInvoiceCheckRejectedId) {
    this.cInvoiceCheckRejectedId = cInvoiceCheckRejectedId;
  }

  public Payment cInvoiceId(Integer cInvoiceId) {
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

  public Payment cOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
    return this;
  }

  /**
   * Pedido
   * @return cOrderId
   **/
  @Schema(description = "Pedido")
  
    public Integer getCOrderId() {
    return cOrderId;
  }

  public void setCOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
  }

  public Payment couponbatchnumber(String couponbatchnumber) {
    this.couponbatchnumber = couponbatchnumber;
    return this;
  }

  /**
   * Número de lote del cupón
   * @return couponbatchnumber
   **/
  @Schema(description = "Número de lote del cupón")
  
    public String getCouponbatchnumber() {
    return couponbatchnumber;
  }

  public void setCouponbatchnumber(String couponbatchnumber) {
    this.couponbatchnumber = couponbatchnumber;
  }

  public Payment couponnumber(String couponnumber) {
    this.couponnumber = couponnumber;
    return this;
  }

  /**
   * Número del Cupón del Cobro/Pago mediante Tarjeta de Crédito
   * @return couponnumber
   **/
  @Schema(description = "Número del Cupón del Cobro/Pago mediante Tarjeta de Crédito")
  
    public String getCouponnumber() {
    return couponnumber;
  }

  public void setCouponnumber(String couponnumber) {
    this.couponnumber = couponnumber;
  }

  public Payment cPaymentbatchId(Integer cPaymentbatchId) {
    this.cPaymentbatchId = cPaymentbatchId;
    return this;
  }

  /**
   *  
   * @return cPaymentbatchId
   **/
  @Schema(description = " ")
  
    public Integer getCPaymentbatchId() {
    return cPaymentbatchId;
  }

  public void setCPaymentbatchId(Integer cPaymentbatchId) {
    this.cPaymentbatchId = cPaymentbatchId;
  }

  public Payment cPaymentId(Integer cPaymentId) {
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

  public Payment cPosjournalId(Integer cPosjournalId) {
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

  public Payment cPospaymentmediumId(Integer cPospaymentmediumId) {
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

  public Payment cProjectId(Integer cProjectId) {
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

  public Payment created(String created) {
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

  public Payment createdby(Integer createdby) {
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

  public Payment creditcardexpmm(Integer creditcardexpmm) {
    this.creditcardexpmm = creditcardexpmm;
    return this;
  }

  /**
   * Mes de expiración
   * @return creditcardexpmm
   **/
  @Schema(description = "Mes de expiración")
  
    public Integer getCreditcardexpmm() {
    return creditcardexpmm;
  }

  public void setCreditcardexpmm(Integer creditcardexpmm) {
    this.creditcardexpmm = creditcardexpmm;
  }

  public Payment creditcardexpyy(Integer creditcardexpyy) {
    this.creditcardexpyy = creditcardexpyy;
    return this;
  }

  /**
   * Valido hasta (Año)
   * @return creditcardexpyy
   **/
  @Schema(description = "Valido hasta (Año)")
  
    public Integer getCreditcardexpyy() {
    return creditcardexpyy;
  }

  public void setCreditcardexpyy(Integer creditcardexpyy) {
    this.creditcardexpyy = creditcardexpyy;
  }

  public Payment creditcardnumber(String creditcardnumber) {
    this.creditcardnumber = creditcardnumber;
    return this;
  }

  /**
   * Número de Tarjeta de Crédito
   * @return creditcardnumber
   **/
  @Schema(description = "Número de Tarjeta de Crédito")
  
    public String getCreditcardnumber() {
    return creditcardnumber;
  }

  public void setCreditcardnumber(String creditcardnumber) {
    this.creditcardnumber = creditcardnumber;
  }

  public Payment creditcardtype(String creditcardtype) {
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

  public Payment creditcardvv(String creditcardvv) {
    this.creditcardvv = creditcardvv;
    return this;
  }

  /**
   * Código de verificación en la tarjeta de crédito
   * @return creditcardvv
   **/
  @Schema(description = "Código de verificación en la tarjeta de crédito")
  
    public String getCreditcardvv() {
    return creditcardvv;
  }

  public void setCreditcardvv(String creditcardvv) {
    this.creditcardvv = creditcardvv;
  }

  public Payment dateacct(String dateacct) {
    this.dateacct = dateacct;
    return this;
  }

  /**
   * Fecha contable
   * @return dateacct
   **/
  @Schema(required = true, description = "Fecha contable")
      @NotNull

    public String getDateacct() {
    return dateacct;
  }

  public void setDateacct(String dateacct) {
    this.dateacct = dateacct;
  }

  public Payment dateemissioncheck(String dateemissioncheck) {
    this.dateemissioncheck = dateemissioncheck;
    return this;
  }

  /**
   *  
   * @return dateemissioncheck
   **/
  @Schema(description = " ")
  
    public String getDateemissioncheck() {
    return dateemissioncheck;
  }

  public void setDateemissioncheck(String dateemissioncheck) {
    this.dateemissioncheck = dateemissioncheck;
  }

  public Payment datetrx(String datetrx) {
    this.datetrx = datetrx;
    return this;
  }

  /**
   * Fecha de la transacción
   * @return datetrx
   **/
  @Schema(required = true, description = "Fecha de la transacción")
      @NotNull

    public String getDatetrx() {
    return datetrx;
  }

  public void setDatetrx(String datetrx) {
    this.datetrx = datetrx;
  }

  public Payment description(String description) {
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

  public Payment discountamt(BigDecimal discountamt) {
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

  public Payment docaction(String docaction) {
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

  public Payment docstatus(String docstatus) {
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

  public Payment documentno(String documentno) {
    this.documentno = documentno;
    return this;
  }

  /**
   * Número de secuencia del documento para cada documento
   * @return documentno
   **/
  @Schema(required = true, description = "Número de secuencia del documento para cada documento")
      @NotNull

    public String getDocumentno() {
    return documentno;
  }

  public void setDocumentno(String documentno) {
    this.documentno = documentno;
  }

  public Payment duedate(String duedate) {
    this.duedate = duedate;
    return this;
  }

  /**
   * Fecha de Vencimiento
   * @return duedate
   **/
  @Schema(description = "Fecha de Vencimiento")
  
    public String getDuedate() {
    return duedate;
  }

  public void setDuedate(String duedate) {
    this.duedate = duedate;
  }

  public Payment isactive(Boolean isactive) {
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

  public Payment isallocated(Boolean isallocated) {
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

  public Payment isapproved(Boolean isapproved) {
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

  public Payment isdelayedcapture(Boolean isdelayedcapture) {
    this.isdelayedcapture = isdelayedcapture;
    return this;
  }

  /**
   * Pago tras Envio
   * @return isdelayedcapture
   **/
  @Schema(required = true, description = "Pago tras Envio")
      @NotNull

    public Boolean isIsdelayedcapture() {
    return isdelayedcapture;
  }

  public void setIsdelayedcapture(Boolean isdelayedcapture) {
    this.isdelayedcapture = isdelayedcapture;
  }

  public Payment ismanual(Boolean ismanual) {
    this.ismanual = ismanual;
    return this;
  }

  /**
   * Éste es un proceso manual
   * @return ismanual
   **/
  @Schema(required = true, description = "Éste es un proceso manual")
      @NotNull

    public Boolean isIsmanual() {
    return ismanual;
  }

  public void setIsmanual(Boolean ismanual) {
    this.ismanual = ismanual;
  }

  public Payment isonline(Boolean isonline) {
    this.isonline = isonline;
    return this;
  }

  /**
   * Puede ser accedido en línea
   * @return isonline
   **/
  @Schema(required = true, description = "Puede ser accedido en línea")
      @NotNull

    public Boolean isIsonline() {
    return isonline;
  }

  public void setIsonline(Boolean isonline) {
    this.isonline = isonline;
  }

  public Payment isoverunderpayment(Boolean isoverunderpayment) {
    this.isoverunderpayment = isoverunderpayment;
    return this;
  }

  /**
   * Sobre pago (no contabilizado) o sub pago (pago parcial)
   * @return isoverunderpayment
   **/
  @Schema(required = true, description = "Sobre pago (no contabilizado) o sub pago (pago parcial)")
      @NotNull

    public Boolean isIsoverunderpayment() {
    return isoverunderpayment;
  }

  public void setIsoverunderpayment(Boolean isoverunderpayment) {
    this.isoverunderpayment = isoverunderpayment;
  }

  public Payment isprepayment(Boolean isprepayment) {
    this.isprepayment = isprepayment;
    return this;
  }

  /**
   * Prepago
   * @return isprepayment
   **/
  @Schema(required = true, description = "Prepago")
      @NotNull

    public Boolean isIsprepayment() {
    return isprepayment;
  }

  public void setIsprepayment(Boolean isprepayment) {
    this.isprepayment = isprepayment;
  }

  public Payment isreceipt(String isreceipt) {
    this.isreceipt = isreceipt;
    return this;
  }

  /**
   * Ésta es una transacción de ventas
   * @return isreceipt
   **/
  @Schema(required = true, description = "Ésta es una transacción de ventas")
      @NotNull

    public String getIsreceipt() {
    return isreceipt;
  }

  public void setIsreceipt(String isreceipt) {
    this.isreceipt = isreceipt;
  }

  public Payment isreconciled(Boolean isreconciled) {
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

  public Payment isselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
    return this;
  }

  /**
   * Disp. en Web
   * @return isselfservice
   **/
  @Schema(required = true, description = "Disp. en Web")
      @NotNull

    public Boolean isIsselfservice() {
    return isselfservice;
  }

  public void setIsselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
  }

  public Payment issotrx(Boolean issotrx) {
    this.issotrx = issotrx;
    return this;
  }

  /**
   * Esta es una transacción de ventas
   * @return issotrx
   **/
  @Schema(required = true, description = "Esta es una transacción de ventas")
      @NotNull

    public Boolean isIssotrx() {
    return issotrx;
  }

  public void setIssotrx(Boolean issotrx) {
    this.issotrx = issotrx;
  }

  public Payment mBoletadepositoId(Integer mBoletadepositoId) {
    this.mBoletadepositoId = mBoletadepositoId;
    return this;
  }

  /**
   *  
   * @return mBoletadepositoId
   **/
  @Schema(description = " ")
  
    public Integer getMBoletadepositoId() {
    return mBoletadepositoId;
  }

  public void setMBoletadepositoId(Integer mBoletadepositoId) {
    this.mBoletadepositoId = mBoletadepositoId;
  }

  public Payment mEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
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

  public Payment micr(String micr) {
    this.micr = micr;
    return this;
  }

  /**
   * Combinación de No. de Sucursal; Cta. y Cheque
   * @return micr
   **/
  @Schema(description = "Combinación de No. de Sucursal; Cta. y Cheque")
  
    public String getMicr() {
    return micr;
  }

  public void setMicr(String micr) {
    this.micr = micr;
  }

  public Payment oprocessing(String oprocessing) {
    this.oprocessing = oprocessing;
    return this;
  }

  /**
   * Este pago puede ser procesado en línea
   * @return oprocessing
   **/
  @Schema(description = "Este pago puede ser procesado en línea")
  
    public String getOprocessing() {
    return oprocessing;
  }

  public void setOprocessing(String oprocessing) {
    this.oprocessing = oprocessing;
  }

  public Payment originalRefPaymentId(Integer originalRefPaymentId) {
    this.originalRefPaymentId = originalRefPaymentId;
    return this;
  }

  /**
   * Referencia al Pago Original ya que semánticamente el registro actual actúa como duplicado
   * @return originalRefPaymentId
   **/
  @Schema(description = "Referencia al Pago Original ya que semánticamente el registro actual actúa como duplicado")
  
    public Integer getOriginalRefPaymentId() {
    return originalRefPaymentId;
  }

  public void setOriginalRefPaymentId(Integer originalRefPaymentId) {
    this.originalRefPaymentId = originalRefPaymentId;
  }

  public Payment origTrxid(String origTrxid) {
    this.origTrxid = origTrxid;
    return this;
  }

  /**
   * ID de la transacción original
   * @return origTrxid
   **/
  @Schema(description = "ID de la transacción original")
  
    public String getOrigTrxid() {
    return origTrxid;
  }

  public void setOrigTrxid(String origTrxid) {
    this.origTrxid = origTrxid;
  }

  public Payment overunderamt(BigDecimal overunderamt) {
    this.overunderamt = overunderamt;
    return this;
  }

  /**
   * Importes con sobre/sub pago
   * @return overunderamt
   **/
  @Schema(description = "Importes con sobre/sub pago")
  
    @Valid
    public BigDecimal getOverunderamt() {
    return overunderamt;
  }

  public void setOverunderamt(BigDecimal overunderamt) {
    this.overunderamt = overunderamt;
  }

  public Payment payamt(BigDecimal payamt) {
    this.payamt = payamt;
    return this;
  }

  /**
   * Importe del Pago
   * @return payamt
   **/
  @Schema(required = true, description = "Importe del Pago")
      @NotNull

    @Valid
    public BigDecimal getPayamt() {
    return payamt;
  }

  public void setPayamt(BigDecimal payamt) {
    this.payamt = payamt;
  }

  public Payment ponum(String ponum) {
    this.ponum = ponum;
    return this;
  }

  /**
   * Número de Pedido de Clientes
   * @return ponum
   **/
  @Schema(description = "Número de Pedido de Clientes")
  
    public String getPonum() {
    return ponum;
  }

  public void setPonum(String ponum) {
    this.ponum = ponum;
  }

  public Payment posnet(String posnet) {
    this.posnet = posnet;
    return this;
  }

  /**
   *  
   * @return posnet
   **/
  @Schema(description = " ")
  
    public String getPosnet() {
    return posnet;
  }

  public void setPosnet(String posnet) {
    this.posnet = posnet;
  }

  public Payment posted(String posted) {
    this.posted = posted;
    return this;
  }

  /**
   * Las transacciones de Contabilidad General han sido procesadas
   * @return posted
   **/
  @Schema(required = true, description = "Las transacciones de Contabilidad General han sido procesadas")
      @NotNull

    public String getPosted() {
    return posted;
  }

  public void setPosted(String posted) {
    this.posted = posted;
  }

  public Payment processed(Boolean processed) {
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

  public Payment processing(String processing) {
    this.processing = processing;
    return this;
  }

  /**
   *  
   * @return processing
   **/
  @Schema(description = " ")
  
    public String getProcessing() {
    return processing;
  }

  public void setProcessing(String processing) {
    this.processing = processing;
  }

  public Payment rAuthcode(String rAuthcode) {
    this.rAuthcode = rAuthcode;
    return this;
  }

  /**
   * Autorización del Código devuelto
   * @return rAuthcode
   **/
  @Schema(description = "Autorización del Código devuelto")
  
    public String getRAuthcode() {
    return rAuthcode;
  }

  public void setRAuthcode(String rAuthcode) {
    this.rAuthcode = rAuthcode;
  }

  public Payment rAuthcodeDc(String rAuthcodeDc) {
    this.rAuthcodeDc = rAuthcodeDc;
    return this;
  }

  /**
   * Codigo de Autorización (DC)
   * @return rAuthcodeDc
   **/
  @Schema(description = "Codigo de Autorización (DC)")
  
    public String getRAuthcodeDc() {
    return rAuthcodeDc;
  }

  public void setRAuthcodeDc(String rAuthcodeDc) {
    this.rAuthcodeDc = rAuthcodeDc;
  }

  public Payment rAvsaddr(String rAvsaddr) {
    this.rAvsaddr = rAvsaddr;
    return this;
  }

  /**
   * Esta dirección ha sido devuelta
   * @return rAvsaddr
   **/
  @Schema(description = "Esta dirección ha sido devuelta")
  
    public String getRAvsaddr() {
    return rAvsaddr;
  }

  public void setRAvsaddr(String rAvsaddr) {
    this.rAvsaddr = rAvsaddr;
  }

  public Payment rAvszip(String rAvszip) {
    this.rAvszip = rAvszip;
    return this;
  }

  /**
   * El Código Postal ha sido verificado
   * @return rAvszip
   **/
  @Schema(description = "El Código Postal ha sido verificado")
  
    public String getRAvszip() {
    return rAvszip;
  }

  public void setRAvszip(String rAvszip) {
    this.rAvszip = rAvszip;
  }

  public Payment rCvv2match(Boolean rCvv2match) {
    this.rCvv2match = rCvv2match;
    return this;
  }

  /**
   * Comprobación del Código de Verificación de la Tarjeta de Crédito
   * @return rCvv2match
   **/
  @Schema(description = "Comprobación del Código de Verificación de la Tarjeta de Crédito")
  
    public Boolean isRCvv2match() {
    return rCvv2match;
  }

  public void setRCvv2match(Boolean rCvv2match) {
    this.rCvv2match = rCvv2match;
  }

  public Payment refPaymentId(Integer refPaymentId) {
    this.refPaymentId = refPaymentId;
    return this;
  }

  /**
   *  
   * @return refPaymentId
   **/
  @Schema(description = " ")
  
    public Integer getRefPaymentId() {
    return refPaymentId;
  }

  public void setRefPaymentId(Integer refPaymentId) {
    this.refPaymentId = refPaymentId;
  }

  public Payment rejectedcomments(String rejectedcomments) {
    this.rejectedcomments = rejectedcomments;
    return this;
  }

  /**
   *  
   * @return rejectedcomments
   **/
  @Schema(description = " ")
  
    public String getRejectedcomments() {
    return rejectedcomments;
  }

  public void setRejectedcomments(String rejectedcomments) {
    this.rejectedcomments = rejectedcomments;
  }

  public Payment rejecteddate(String rejecteddate) {
    this.rejecteddate = rejecteddate;
    return this;
  }

  /**
   *  
   * @return rejecteddate
   **/
  @Schema(description = " ")
  
    public String getRejecteddate() {
    return rejecteddate;
  }

  public void setRejecteddate(String rejecteddate) {
    this.rejecteddate = rejecteddate;
  }

  public Payment rInfo(String rInfo) {
    this.rInfo = rInfo;
    return this;
  }

  /**
   * Respuesta info
   * @return rInfo
   **/
  @Schema(description = "Respuesta info")
  
    public String getRInfo() {
    return rInfo;
  }

  public void setRInfo(String rInfo) {
    this.rInfo = rInfo;
  }

  public Payment routingno(String routingno) {
    this.routingno = routingno;
    return this;
  }

  /**
   * Número de sucursal bancaria
   * @return routingno
   **/
  @Schema(description = "Número de sucursal bancaria")
  
    public String getRoutingno() {
    return routingno;
  }

  public void setRoutingno(String routingno) {
    this.routingno = routingno;
  }

  public Payment rPnref(String rPnref) {
    this.rPnref = rPnref;
    return this;
  }

  /**
   * Referencia del pago
   * @return rPnref
   **/
  @Schema(description = "Referencia del pago")
  
    public String getRPnref() {
    return rPnref;
  }

  public void setRPnref(String rPnref) {
    this.rPnref = rPnref;
  }

  public Payment rPnrefDc(String rPnrefDc) {
    this.rPnrefDc = rPnrefDc;
    return this;
  }

  /**
   * Referencia de Pago pendiente
   * @return rPnrefDc
   **/
  @Schema(description = "Referencia de Pago pendiente")
  
    public String getRPnrefDc() {
    return rPnrefDc;
  }

  public void setRPnrefDc(String rPnrefDc) {
    this.rPnrefDc = rPnrefDc;
  }

  public Payment rRespmsg(String rRespmsg) {
    this.rRespmsg = rRespmsg;
    return this;
  }

  /**
   * Mensaje de respuesta
   * @return rRespmsg
   **/
  @Schema(description = "Mensaje de respuesta")
  
    public String getRRespmsg() {
    return rRespmsg;
  }

  public void setRRespmsg(String rRespmsg) {
    this.rRespmsg = rRespmsg;
  }

  public Payment rResult(String rResult) {
    this.rResult = rResult;
    return this;
  }

  /**
   * Resultado de la transmisión
   * @return rResult
   **/
  @Schema(description = "Resultado de la transmisión")
  
    public String getRResult() {
    return rResult;
  }

  public void setRResult(String rResult) {
    this.rResult = rResult;
  }

  public Payment swipe(String swipe) {
    this.swipe = swipe;
    return this;
  }

  /**
   * Pista 1 y 2 de la Tarjeta de Credito
   * @return swipe
   **/
  @Schema(description = "Pista 1 y 2 de la Tarjeta de Credito")
  
    public String getSwipe() {
    return swipe;
  }

  public void setSwipe(String swipe) {
    this.swipe = swipe;
  }

  public Payment taxamt(BigDecimal taxamt) {
    this.taxamt = taxamt;
    return this;
  }

  /**
   * Importe del Impuesto
   * @return taxamt
   **/
  @Schema(description = "Importe del Impuesto")
  
    @Valid
    public BigDecimal getTaxamt() {
    return taxamt;
  }

  public void setTaxamt(BigDecimal taxamt) {
    this.taxamt = taxamt;
  }

  public Payment tendertype(String tendertype) {
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

  public Payment trxtype(String trxtype) {
    this.trxtype = trxtype;
    return this;
  }

  /**
   * Tipo de transacción de la tarjeta de crédito
   * @return trxtype
   **/
  @Schema(required = true, description = "Tipo de transacción de la tarjeta de crédito")
      @NotNull

    public String getTrxtype() {
    return trxtype;
  }

  public void setTrxtype(String trxtype) {
    this.trxtype = trxtype;
  }

  public Payment updated(String updated) {
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

  public Payment updatedby(Integer updatedby) {
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

  public Payment user1Id(Integer user1Id) {
    this.user1Id = user1Id;
    return this;
  }

  /**
   * El usuario definió el elemento # 1
   * @return user1Id
   **/
  @Schema(description = "El usuario definió el elemento # 1")
  
    public Integer getUser1Id() {
    return user1Id;
  }

  public void setUser1Id(Integer user1Id) {
    this.user1Id = user1Id;
  }

  public Payment user2Id(Integer user2Id) {
    this.user2Id = user2Id;
    return this;
  }

  /**
   * El usuario definió el elemento # 2
   * @return user2Id
   **/
  @Schema(description = "El usuario definió el elemento # 2")
  
    public Integer getUser2Id() {
    return user2Id;
  }

  public void setUser2Id(Integer user2Id) {
    this.user2Id = user2Id;
  }

  public Payment voiceauthcode(String voiceauthcode) {
    this.voiceauthcode = voiceauthcode;
    return this;
  }

  /**
   * Código de Autorización de voz de la compañía de la tarjeta de crédito
   * @return voiceauthcode
   **/
  @Schema(description = "Código de Autorización de voz de la compañía de la tarjeta de crédito")
  
    public String getVoiceauthcode() {
    return voiceauthcode;
  }

  public void setVoiceauthcode(String voiceauthcode) {
    this.voiceauthcode = voiceauthcode;
  }

  public Payment writeoffamt(BigDecimal writeoffamt) {
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

  public Payment additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Payment addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Payment referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Payment addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Payment payment = (Payment) o;
    return Objects.equals(this.aBank, payment.aBank) &&
        Objects.equals(this.accountingCChargeId, payment.accountingCChargeId) &&
        Objects.equals(this.accountno, payment.accountno) &&
        Objects.equals(this.aCity, payment.aCity) &&
        Objects.equals(this.aCountry, payment.aCountry) &&
        Objects.equals(this.aCuit, payment.aCuit) &&
        Objects.equals(this.adClientId, payment.adClientId) &&
        Objects.equals(this.adOrgId, payment.adOrgId) &&
        Objects.equals(this.adOrgtrxId, payment.adOrgtrxId) &&
        Objects.equals(this.aEmail, payment.aEmail) &&
        Objects.equals(this.aIdentDl, payment.aIdentDl) &&
        Objects.equals(this.aIdentSsn, payment.aIdentSsn) &&
        Objects.equals(this.aName, payment.aName) &&
        Objects.equals(this.aState, payment.aState) &&
        Objects.equals(this.aStreet, payment.aStreet) &&
        Objects.equals(this.auditstatus, payment.auditstatus) &&
        Objects.equals(this.authcode, payment.authcode) &&
        Objects.equals(this.authmatch, payment.authmatch) &&
        Objects.equals(this.aZip, payment.aZip) &&
        Objects.equals(this.banklistRegisterno, payment.banklistRegisterno) &&
        Objects.equals(this.bankPaymentDate, payment.bankPaymentDate) &&
        Objects.equals(this.bankPaymentDocumentno, payment.bankPaymentDocumentno) &&
        Objects.equals(this.bankPaymentMsgDescription, payment.bankPaymentMsgDescription) &&
        Objects.equals(this.cActivityId, payment.cActivityId) &&
        Objects.equals(this.cBankaccountId, payment.cBankaccountId) &&
        Objects.equals(this.cBankId, payment.cBankId) &&
        Objects.equals(this.cBankpaymentstatusId, payment.cBankpaymentstatusId) &&
        Objects.equals(this.cBpartnerId, payment.cBpartnerId) &&
        Objects.equals(this.cBpBankaccountId, payment.cBpBankaccountId) &&
        Objects.equals(this.cCampaignId, payment.cCampaignId) &&
        Objects.equals(this.cChargeId, payment.cChargeId) &&
        Objects.equals(this.cConversiontypeId, payment.cConversiontypeId) &&
        Objects.equals(this.cCurrencyId, payment.cCurrencyId) &&
        Objects.equals(this.cDoctypeId, payment.cDoctypeId) &&
        Objects.equals(this.chargeamt, payment.chargeamt) &&
        Objects.equals(this.checked, payment.checked) &&
        Objects.equals(this.checkno, payment.checkno) &&
        Objects.equals(this.checkstatus, payment.checkstatus) &&
        Objects.equals(this.cInvoiceCheckRejectedId, payment.cInvoiceCheckRejectedId) &&
        Objects.equals(this.cInvoiceId, payment.cInvoiceId) &&
        Objects.equals(this.cOrderId, payment.cOrderId) &&
        Objects.equals(this.couponbatchnumber, payment.couponbatchnumber) &&
        Objects.equals(this.couponnumber, payment.couponnumber) &&
        Objects.equals(this.cPaymentbatchId, payment.cPaymentbatchId) &&
        Objects.equals(this.cPaymentId, payment.cPaymentId) &&
        Objects.equals(this.cPosjournalId, payment.cPosjournalId) &&
        Objects.equals(this.cPospaymentmediumId, payment.cPospaymentmediumId) &&
        Objects.equals(this.cProjectId, payment.cProjectId) &&
        Objects.equals(this.created, payment.created) &&
        Objects.equals(this.createdby, payment.createdby) &&
        Objects.equals(this.creditcardexpmm, payment.creditcardexpmm) &&
        Objects.equals(this.creditcardexpyy, payment.creditcardexpyy) &&
        Objects.equals(this.creditcardnumber, payment.creditcardnumber) &&
        Objects.equals(this.creditcardtype, payment.creditcardtype) &&
        Objects.equals(this.creditcardvv, payment.creditcardvv) &&
        Objects.equals(this.dateacct, payment.dateacct) &&
        Objects.equals(this.dateemissioncheck, payment.dateemissioncheck) &&
        Objects.equals(this.datetrx, payment.datetrx) &&
        Objects.equals(this.description, payment.description) &&
        Objects.equals(this.discountamt, payment.discountamt) &&
        Objects.equals(this.docaction, payment.docaction) &&
        Objects.equals(this.docstatus, payment.docstatus) &&
        Objects.equals(this.documentno, payment.documentno) &&
        Objects.equals(this.duedate, payment.duedate) &&
        Objects.equals(this.isactive, payment.isactive) &&
        Objects.equals(this.isallocated, payment.isallocated) &&
        Objects.equals(this.isapproved, payment.isapproved) &&
        Objects.equals(this.isdelayedcapture, payment.isdelayedcapture) &&
        Objects.equals(this.ismanual, payment.ismanual) &&
        Objects.equals(this.isonline, payment.isonline) &&
        Objects.equals(this.isoverunderpayment, payment.isoverunderpayment) &&
        Objects.equals(this.isprepayment, payment.isprepayment) &&
        Objects.equals(this.isreceipt, payment.isreceipt) &&
        Objects.equals(this.isreconciled, payment.isreconciled) &&
        Objects.equals(this.isselfservice, payment.isselfservice) &&
        Objects.equals(this.issotrx, payment.issotrx) &&
        Objects.equals(this.mBoletadepositoId, payment.mBoletadepositoId) &&
        Objects.equals(this.mEntidadfinancieraplanId, payment.mEntidadfinancieraplanId) &&
        Objects.equals(this.micr, payment.micr) &&
        Objects.equals(this.oprocessing, payment.oprocessing) &&
        Objects.equals(this.originalRefPaymentId, payment.originalRefPaymentId) &&
        Objects.equals(this.origTrxid, payment.origTrxid) &&
        Objects.equals(this.overunderamt, payment.overunderamt) &&
        Objects.equals(this.payamt, payment.payamt) &&
        Objects.equals(this.ponum, payment.ponum) &&
        Objects.equals(this.posnet, payment.posnet) &&
        Objects.equals(this.posted, payment.posted) &&
        Objects.equals(this.processed, payment.processed) &&
        Objects.equals(this.processing, payment.processing) &&
        Objects.equals(this.rAuthcode, payment.rAuthcode) &&
        Objects.equals(this.rAuthcodeDc, payment.rAuthcodeDc) &&
        Objects.equals(this.rAvsaddr, payment.rAvsaddr) &&
        Objects.equals(this.rAvszip, payment.rAvszip) &&
        Objects.equals(this.rCvv2match, payment.rCvv2match) &&
        Objects.equals(this.refPaymentId, payment.refPaymentId) &&
        Objects.equals(this.rejectedcomments, payment.rejectedcomments) &&
        Objects.equals(this.rejecteddate, payment.rejecteddate) &&
        Objects.equals(this.rInfo, payment.rInfo) &&
        Objects.equals(this.routingno, payment.routingno) &&
        Objects.equals(this.rPnref, payment.rPnref) &&
        Objects.equals(this.rPnrefDc, payment.rPnrefDc) &&
        Objects.equals(this.rRespmsg, payment.rRespmsg) &&
        Objects.equals(this.rResult, payment.rResult) &&
        Objects.equals(this.swipe, payment.swipe) &&
        Objects.equals(this.taxamt, payment.taxamt) &&
        Objects.equals(this.tendertype, payment.tendertype) &&
        Objects.equals(this.trxtype, payment.trxtype) &&
        Objects.equals(this.updated, payment.updated) &&
        Objects.equals(this.updatedby, payment.updatedby) &&
        Objects.equals(this.user1Id, payment.user1Id) &&
        Objects.equals(this.user2Id, payment.user2Id) &&
        Objects.equals(this.voiceauthcode, payment.voiceauthcode) &&
        Objects.equals(this.writeoffamt, payment.writeoffamt) &&
        Objects.equals(this.additionalvalues, payment.additionalvalues) &&
        Objects.equals(this.referencedvalues, payment.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBank, accountingCChargeId, accountno, aCity, aCountry, aCuit, adClientId, adOrgId, adOrgtrxId, aEmail, aIdentDl, aIdentSsn, aName, aState, aStreet, auditstatus, authcode, authmatch, aZip, banklistRegisterno, bankPaymentDate, bankPaymentDocumentno, bankPaymentMsgDescription, cActivityId, cBankaccountId, cBankId, cBankpaymentstatusId, cBpartnerId, cBpBankaccountId, cCampaignId, cChargeId, cConversiontypeId, cCurrencyId, cDoctypeId, chargeamt, checked, checkno, checkstatus, cInvoiceCheckRejectedId, cInvoiceId, cOrderId, couponbatchnumber, couponnumber, cPaymentbatchId, cPaymentId, cPosjournalId, cPospaymentmediumId, cProjectId, created, createdby, creditcardexpmm, creditcardexpyy, creditcardnumber, creditcardtype, creditcardvv, dateacct, dateemissioncheck, datetrx, description, discountamt, docaction, docstatus, documentno, duedate, isactive, isallocated, isapproved, isdelayedcapture, ismanual, isonline, isoverunderpayment, isprepayment, isreceipt, isreconciled, isselfservice, issotrx, mBoletadepositoId, mEntidadfinancieraplanId, micr, oprocessing, originalRefPaymentId, origTrxid, overunderamt, payamt, ponum, posnet, posted, processed, processing, rAuthcode, rAuthcodeDc, rAvsaddr, rAvszip, rCvv2match, refPaymentId, rejectedcomments, rejecteddate, rInfo, routingno, rPnref, rPnrefDc, rRespmsg, rResult, swipe, taxamt, tendertype, trxtype, updated, updatedby, user1Id, user2Id, voiceauthcode, writeoffamt, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    aBank: ").append(toIndentedString(aBank)).append("\n");
    sb.append("    accountingCChargeId: ").append(toIndentedString(accountingCChargeId)).append("\n");
    sb.append("    accountno: ").append(toIndentedString(accountno)).append("\n");
    sb.append("    aCity: ").append(toIndentedString(aCity)).append("\n");
    sb.append("    aCountry: ").append(toIndentedString(aCountry)).append("\n");
    sb.append("    aCuit: ").append(toIndentedString(aCuit)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    aEmail: ").append(toIndentedString(aEmail)).append("\n");
    sb.append("    aIdentDl: ").append(toIndentedString(aIdentDl)).append("\n");
    sb.append("    aIdentSsn: ").append(toIndentedString(aIdentSsn)).append("\n");
    sb.append("    aName: ").append(toIndentedString(aName)).append("\n");
    sb.append("    aState: ").append(toIndentedString(aState)).append("\n");
    sb.append("    aStreet: ").append(toIndentedString(aStreet)).append("\n");
    sb.append("    auditstatus: ").append(toIndentedString(auditstatus)).append("\n");
    sb.append("    authcode: ").append(toIndentedString(authcode)).append("\n");
    sb.append("    authmatch: ").append(toIndentedString(authmatch)).append("\n");
    sb.append("    aZip: ").append(toIndentedString(aZip)).append("\n");
    sb.append("    banklistRegisterno: ").append(toIndentedString(banklistRegisterno)).append("\n");
    sb.append("    bankPaymentDate: ").append(toIndentedString(bankPaymentDate)).append("\n");
    sb.append("    bankPaymentDocumentno: ").append(toIndentedString(bankPaymentDocumentno)).append("\n");
    sb.append("    bankPaymentMsgDescription: ").append(toIndentedString(bankPaymentMsgDescription)).append("\n");
    sb.append("    cActivityId: ").append(toIndentedString(cActivityId)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBankId: ").append(toIndentedString(cBankId)).append("\n");
    sb.append("    cBankpaymentstatusId: ").append(toIndentedString(cBankpaymentstatusId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cBpBankaccountId: ").append(toIndentedString(cBpBankaccountId)).append("\n");
    sb.append("    cCampaignId: ").append(toIndentedString(cCampaignId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cConversiontypeId: ").append(toIndentedString(cConversiontypeId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    chargeamt: ").append(toIndentedString(chargeamt)).append("\n");
    sb.append("    checked: ").append(toIndentedString(checked)).append("\n");
    sb.append("    checkno: ").append(toIndentedString(checkno)).append("\n");
    sb.append("    checkstatus: ").append(toIndentedString(checkstatus)).append("\n");
    sb.append("    cInvoiceCheckRejectedId: ").append(toIndentedString(cInvoiceCheckRejectedId)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("    couponbatchnumber: ").append(toIndentedString(couponbatchnumber)).append("\n");
    sb.append("    couponnumber: ").append(toIndentedString(couponnumber)).append("\n");
    sb.append("    cPaymentbatchId: ").append(toIndentedString(cPaymentbatchId)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    cPosjournalId: ").append(toIndentedString(cPosjournalId)).append("\n");
    sb.append("    cPospaymentmediumId: ").append(toIndentedString(cPospaymentmediumId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditcardexpmm: ").append(toIndentedString(creditcardexpmm)).append("\n");
    sb.append("    creditcardexpyy: ").append(toIndentedString(creditcardexpyy)).append("\n");
    sb.append("    creditcardnumber: ").append(toIndentedString(creditcardnumber)).append("\n");
    sb.append("    creditcardtype: ").append(toIndentedString(creditcardtype)).append("\n");
    sb.append("    creditcardvv: ").append(toIndentedString(creditcardvv)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    dateemissioncheck: ").append(toIndentedString(dateemissioncheck)).append("\n");
    sb.append("    datetrx: ").append(toIndentedString(datetrx)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountamt: ").append(toIndentedString(discountamt)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    duedate: ").append(toIndentedString(duedate)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isallocated: ").append(toIndentedString(isallocated)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    isdelayedcapture: ").append(toIndentedString(isdelayedcapture)).append("\n");
    sb.append("    ismanual: ").append(toIndentedString(ismanual)).append("\n");
    sb.append("    isonline: ").append(toIndentedString(isonline)).append("\n");
    sb.append("    isoverunderpayment: ").append(toIndentedString(isoverunderpayment)).append("\n");
    sb.append("    isprepayment: ").append(toIndentedString(isprepayment)).append("\n");
    sb.append("    isreceipt: ").append(toIndentedString(isreceipt)).append("\n");
    sb.append("    isreconciled: ").append(toIndentedString(isreconciled)).append("\n");
    sb.append("    isselfservice: ").append(toIndentedString(isselfservice)).append("\n");
    sb.append("    issotrx: ").append(toIndentedString(issotrx)).append("\n");
    sb.append("    mBoletadepositoId: ").append(toIndentedString(mBoletadepositoId)).append("\n");
    sb.append("    mEntidadfinancieraplanId: ").append(toIndentedString(mEntidadfinancieraplanId)).append("\n");
    sb.append("    micr: ").append(toIndentedString(micr)).append("\n");
    sb.append("    oprocessing: ").append(toIndentedString(oprocessing)).append("\n");
    sb.append("    originalRefPaymentId: ").append(toIndentedString(originalRefPaymentId)).append("\n");
    sb.append("    origTrxid: ").append(toIndentedString(origTrxid)).append("\n");
    sb.append("    overunderamt: ").append(toIndentedString(overunderamt)).append("\n");
    sb.append("    payamt: ").append(toIndentedString(payamt)).append("\n");
    sb.append("    ponum: ").append(toIndentedString(ponum)).append("\n");
    sb.append("    posnet: ").append(toIndentedString(posnet)).append("\n");
    sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    rAuthcode: ").append(toIndentedString(rAuthcode)).append("\n");
    sb.append("    rAuthcodeDc: ").append(toIndentedString(rAuthcodeDc)).append("\n");
    sb.append("    rAvsaddr: ").append(toIndentedString(rAvsaddr)).append("\n");
    sb.append("    rAvszip: ").append(toIndentedString(rAvszip)).append("\n");
    sb.append("    rCvv2match: ").append(toIndentedString(rCvv2match)).append("\n");
    sb.append("    refPaymentId: ").append(toIndentedString(refPaymentId)).append("\n");
    sb.append("    rejectedcomments: ").append(toIndentedString(rejectedcomments)).append("\n");
    sb.append("    rejecteddate: ").append(toIndentedString(rejecteddate)).append("\n");
    sb.append("    rInfo: ").append(toIndentedString(rInfo)).append("\n");
    sb.append("    routingno: ").append(toIndentedString(routingno)).append("\n");
    sb.append("    rPnref: ").append(toIndentedString(rPnref)).append("\n");
    sb.append("    rPnrefDc: ").append(toIndentedString(rPnrefDc)).append("\n");
    sb.append("    rRespmsg: ").append(toIndentedString(rRespmsg)).append("\n");
    sb.append("    rResult: ").append(toIndentedString(rResult)).append("\n");
    sb.append("    swipe: ").append(toIndentedString(swipe)).append("\n");
    sb.append("    taxamt: ").append(toIndentedString(taxamt)).append("\n");
    sb.append("    tendertype: ").append(toIndentedString(tendertype)).append("\n");
    sb.append("    trxtype: ").append(toIndentedString(trxtype)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    user1Id: ").append(toIndentedString(user1Id)).append("\n");
    sb.append("    user2Id: ").append(toIndentedString(user2Id)).append("\n");
    sb.append("    voiceauthcode: ").append(toIndentedString(voiceauthcode)).append("\n");
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
