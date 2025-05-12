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
 * BPartner
 */
@Validated



public class BPartner   {
  @JsonProperty("acqusitioncost")
  private BigDecimal acqusitioncost = null;

  @JsonProperty("actuallifetimevalue")
  private BigDecimal actuallifetimevalue = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_language")
  private Integer adLanguage = null;

  @JsonProperty("ad_orgbp_id")
  private String adOrgbpId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("allowadvancedpaymentreceipts")
  private Boolean allowadvancedpaymentreceipts = null;

  @JsonProperty("allowpartialpayment")
  private Boolean allowpartialpayment = null;

  @JsonProperty("a_name_check")
  private String aNameCheck = null;

  @JsonProperty("automaticcreditnotes")
  private Boolean automaticcreditnotes = null;

  @JsonProperty("batch_payment_rule")
  private String batchPaymentRule = null;

  @JsonProperty("bpartner_parent_id")
  private Integer bpartnerParentId = null;

  @JsonProperty("builtcabajurisdiction")
  private Boolean builtcabajurisdiction = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_bp_group_id")
  private Integer cBpGroupId = null;

  @JsonProperty("c_categoria_iva_id")
  private Integer cCategoriaIvaId = null;

  @JsonProperty("c_dunning_id")
  private Integer cDunningId = null;

  @JsonProperty("c_greeting_id")
  private Integer cGreetingId = null;

  @JsonProperty("c_invoiceschedule_id")
  private Integer cInvoicescheduleId = null;

  @JsonProperty("c_jobcategory_id")
  private Integer cJobcategoryId = null;

  @JsonProperty("c_location_id")
  private Integer cLocationId = null;

  @JsonProperty("copyfrom")
  private String copyfrom = null;

  @JsonProperty("copyvendorproducts")
  private String copyvendorproducts = null;

  @JsonProperty("c_paymentterm_id")
  private Integer cPaymenttermId = null;

  @JsonProperty("c_pospaymentmedium_id")
  private Integer cPospaymentmediumId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("creditminimumamt")
  private BigDecimal creditminimumamt = null;

  @JsonProperty("creditsituation")
  private String creditsituation = null;

  @JsonProperty("c_region_sede_id")
  private Integer cRegionSedeId = null;

  @JsonProperty("customertype")
  private String customertype = null;

  @JsonProperty("deliveryrule")
  private String deliveryrule = null;

  @JsonProperty("deliveryviarule")
  private String deliveryviarule = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("discountcontext")
  private String discountcontext = null;

  @JsonProperty("documentcopies")
  private Integer documentcopies = null;

  @JsonProperty("duns")
  private String duns = null;

  @JsonProperty("emitir_mi_pyme")
  private Boolean emitirMiPyme = null;

  @JsonProperty("endholidays")
  private String endholidays = null;

  @JsonProperty("endholidays2")
  private String endholidays2 = null;

  @JsonProperty("firstsale")
  private String firstsale = null;

  @JsonProperty("flatdiscount")
  private BigDecimal flatdiscount = null;

  @JsonProperty("freightcostrule")
  private String freightcostrule = null;

  @JsonProperty("goal")
  private BigDecimal goal = null;

  @JsonProperty("iibb")
  private String iibb = null;

  @JsonProperty("iibbtype")
  private String iibbtype = null;

  @JsonProperty("invoice_printformat_id")
  private Integer invoicePrintformatId = null;

  @JsonProperty("invoicerule")
  private String invoicerule = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("iscompoundtax")
  private Boolean iscompoundtax = null;

  @JsonProperty("isconveniomultilateral")
  private String isconveniomultilateral = null;

  @JsonProperty("iscustomer")
  private Boolean iscustomer = null;

  @JsonProperty("isdiscountprinted")
  private Boolean isdiscountprinted = null;

  @JsonProperty("isemployee")
  private Boolean isemployee = null;

  @JsonProperty("isgroupinvoices")
  private Boolean isgroupinvoices = null;

  @JsonProperty("isiso")
  private Boolean isiso = null;

  @JsonProperty("ismandatorycai")
  private Boolean ismandatorycai = null;

  @JsonProperty("ismulticuit")
  private Boolean ismulticuit = null;

  @JsonProperty("isonetime")
  private Boolean isonetime = null;

  @JsonProperty("isprospect")
  private Boolean isprospect = null;

  @JsonProperty("issalesrep")
  private Boolean issalesrep = null;

  @JsonProperty("issummary")
  private Boolean issummary = null;

  @JsonProperty("istaxexempt")
  private Boolean istaxexempt = null;

  @JsonProperty("isvendor")
  private Boolean isvendor = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("minimumpurchasedamt")
  private BigDecimal minimumpurchasedamt = null;

  @JsonProperty("min_order_qty")
  private BigDecimal minOrderQty = null;

  @JsonProperty("m_pricelist_id")
  private Integer mPricelistId = null;

  @JsonProperty("m_product_related_id")
  private Integer mProductRelatedId = null;

  @JsonProperty("m_shipper_id")
  private Integer mShipperId = null;

  @JsonProperty("naics")
  private String naics = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("name2")
  private String name2 = null;

  @JsonProperty("numberemployees")
  private Integer numberemployees = null;

  @JsonProperty("paymentblocked")
  private Boolean paymentblocked = null;

  @JsonProperty("paymentblockeddescr")
  private String paymentblockeddescr = null;

  @JsonProperty("paymentrule")
  private String paymentrule = null;

  @JsonProperty("paymentrulepo")
  private String paymentrulepo = null;

  @JsonProperty("po_discountschema_id")
  private Integer poDiscountschemaId = null;

  @JsonProperty("po_paymentterm_id")
  private Integer poPaymenttermId = null;

  @JsonProperty("po_pricelist_id")
  private Integer poPricelistId = null;

  @JsonProperty("poreference")
  private String poreference = null;

  @JsonProperty("potentiallifetimevalue")
  private BigDecimal potentiallifetimevalue = null;

  @JsonProperty("processpo")
  private String processpo = null;

  @JsonProperty("program_amt")
  private BigDecimal programAmt = null;

  @JsonProperty("program_amt_used")
  private BigDecimal programAmtUsed = null;

  @JsonProperty("rating")
  private String rating = null;

  @JsonProperty("referenceno")
  private String referenceno = null;

  @JsonProperty("salesrep_id")
  private Integer salesrepId = null;

  @JsonProperty("salesvolume")
  private Integer salesvolume = null;

  @JsonProperty("searchunallocatedpayments")
  private Boolean searchunallocatedpayments = null;

  @JsonProperty("secondarycreditstatus")
  private String secondarycreditstatus = null;

  @JsonProperty("sendemail")
  private Boolean sendemail = null;

  @JsonProperty("shareofcustomer")
  private Integer shareofcustomer = null;

  @JsonProperty("shelflifeminpct")
  private Integer shelflifeminpct = null;

  @JsonProperty("so_creditlimit")
  private BigDecimal soCreditlimit = null;

  @JsonProperty("socreditstatus")
  private String socreditstatus = null;

  @JsonProperty("so_creditused")
  private BigDecimal soCreditused = null;

  @JsonProperty("so_description")
  private String soDescription = null;

  @JsonProperty("startholidays")
  private String startholidays = null;

  @JsonProperty("startholidays2")
  private String startholidays2 = null;

  @JsonProperty("taxid")
  private String taxid = null;

  @JsonProperty("taxidtype")
  private String taxidtype = null;

  @JsonProperty("totalopenbalance")
  private BigDecimal totalopenbalance = null;

  @JsonProperty("trxenabled")
  private Boolean trxenabled = null;

  @JsonProperty("updatebalance")
  private String updatebalance = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public BPartner acqusitioncost(BigDecimal acqusitioncost) {
    this.acqusitioncost = acqusitioncost;
    return this;
  }

  /**
   * Coste de conseguir el Prospecto como Cliente
   * @return acqusitioncost
   **/
  @Schema(description = "Coste de conseguir el Prospecto como Cliente")
  
    @Valid
    public BigDecimal getAcqusitioncost() {
    return acqusitioncost;
  }

  public void setAcqusitioncost(BigDecimal acqusitioncost) {
    this.acqusitioncost = acqusitioncost;
  }

  public BPartner actuallifetimevalue(BigDecimal actuallifetimevalue) {
    this.actuallifetimevalue = actuallifetimevalue;
    return this;
  }

  /**
   * Ingreso en el tiempo de vida real
   * @return actuallifetimevalue
   **/
  @Schema(description = "Ingreso en el tiempo de vida real")
  
    @Valid
    public BigDecimal getActuallifetimevalue() {
    return actuallifetimevalue;
  }

  public void setActuallifetimevalue(BigDecimal actuallifetimevalue) {
    this.actuallifetimevalue = actuallifetimevalue;
  }

  public BPartner adClientId(Integer adClientId) {
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

  public BPartner adComponentobjectuid(String adComponentobjectuid) {
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

  public BPartner adLanguage(Integer adLanguage) {
    this.adLanguage = adLanguage;
    return this;
  }

  /**
   * Lenguaje para esta aplicación
   * @return adLanguage
   **/
  @Schema(description = "Lenguaje para esta aplicación")
  
    public Integer getAdLanguage() {
    return adLanguage;
  }

  public void setAdLanguage(Integer adLanguage) {
    this.adLanguage = adLanguage;
  }

  public BPartner adOrgbpId(String adOrgbpId) {
    this.adOrgbpId = adOrgbpId;
    return this;
  }

  /**
   * Organización Asociada
   * @return adOrgbpId
   **/
  @Schema(description = "Organización Asociada")
  
    public String getAdOrgbpId() {
    return adOrgbpId;
  }

  public void setAdOrgbpId(String adOrgbpId) {
    this.adOrgbpId = adOrgbpId;
  }

  public BPartner adOrgId(Integer adOrgId) {
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

  public BPartner allowadvancedpaymentreceipts(Boolean allowadvancedpaymentreceipts) {
    this.allowadvancedpaymentreceipts = allowadvancedpaymentreceipts;
    return this;
  }

  /**
   *  
   * @return allowadvancedpaymentreceipts
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowadvancedpaymentreceipts() {
    return allowadvancedpaymentreceipts;
  }

  public void setAllowadvancedpaymentreceipts(Boolean allowadvancedpaymentreceipts) {
    this.allowadvancedpaymentreceipts = allowadvancedpaymentreceipts;
  }

  public BPartner allowpartialpayment(Boolean allowpartialpayment) {
    this.allowpartialpayment = allowpartialpayment;
    return this;
  }

  /**
   *  
   * @return allowpartialpayment
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowpartialpayment() {
    return allowpartialpayment;
  }

  public void setAllowpartialpayment(Boolean allowpartialpayment) {
    this.allowpartialpayment = allowpartialpayment;
  }

  public BPartner aNameCheck(String aNameCheck) {
    this.aNameCheck = aNameCheck;
    return this;
  }

  /**
   *  
   * @return aNameCheck
   **/
  @Schema(description = " ")
  
    public String getANameCheck() {
    return aNameCheck;
  }

  public void setANameCheck(String aNameCheck) {
    this.aNameCheck = aNameCheck;
  }

  public BPartner automaticcreditnotes(Boolean automaticcreditnotes) {
    this.automaticcreditnotes = automaticcreditnotes;
    return this;
  }

  /**
   * Esta configuración permite imputar las notas de crédito automáticamente a las facturas más antiguas. 
   * @return automaticcreditnotes
   **/
  @Schema(required = true, description = "Esta configuración permite imputar las notas de crédito automáticamente a las facturas más antiguas. ")
      @NotNull

    public Boolean isAutomaticcreditnotes() {
    return automaticcreditnotes;
  }

  public void setAutomaticcreditnotes(Boolean automaticcreditnotes) {
    this.automaticcreditnotes = automaticcreditnotes;
  }

  public BPartner batchPaymentRule(String batchPaymentRule) {
    this.batchPaymentRule = batchPaymentRule;
    return this;
  }

  /**
   *  
   * @return batchPaymentRule
   **/
  @Schema(description = " ")
  
    public String getBatchPaymentRule() {
    return batchPaymentRule;
  }

  public void setBatchPaymentRule(String batchPaymentRule) {
    this.batchPaymentRule = batchPaymentRule;
  }

  public BPartner bpartnerParentId(Integer bpartnerParentId) {
    this.bpartnerParentId = bpartnerParentId;
    return this;
  }

  /**
   * Organización Superior de la Entidad
   * @return bpartnerParentId
   **/
  @Schema(description = "Organización Superior de la Entidad")
  
    public Integer getBpartnerParentId() {
    return bpartnerParentId;
  }

  public void setBpartnerParentId(Integer bpartnerParentId) {
    this.bpartnerParentId = bpartnerParentId;
  }

  public BPartner builtcabajurisdiction(Boolean builtcabajurisdiction) {
    this.builtcabajurisdiction = builtcabajurisdiction;
    return this;
  }

  /**
   *  
   * @return builtcabajurisdiction
   **/
  @Schema(description = " ")
  
    public Boolean isBuiltcabajurisdiction() {
    return builtcabajurisdiction;
  }

  public void setBuiltcabajurisdiction(Boolean builtcabajurisdiction) {
    this.builtcabajurisdiction = builtcabajurisdiction;
  }

  public BPartner cBankaccountId(Integer cBankaccountId) {
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

  public BPartner cBpartnerId(Integer cBpartnerId) {
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

  public BPartner cBpGroupId(Integer cBpGroupId) {
    this.cBpGroupId = cBpGroupId;
    return this;
  }

  /**
   * ID del Grupo de Entidad Comercial
   * @return cBpGroupId
   **/
  @Schema(required = true, description = "ID del Grupo de Entidad Comercial")
      @NotNull

    public Integer getCBpGroupId() {
    return cBpGroupId;
  }

  public void setCBpGroupId(Integer cBpGroupId) {
    this.cBpGroupId = cBpGroupId;
  }

  public BPartner cCategoriaIvaId(Integer cCategoriaIvaId) {
    this.cCategoriaIvaId = cCategoriaIvaId;
    return this;
  }

  /**
   *  
   * @return cCategoriaIvaId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCCategoriaIvaId() {
    return cCategoriaIvaId;
  }

  public void setCCategoriaIvaId(Integer cCategoriaIvaId) {
    this.cCategoriaIvaId = cCategoriaIvaId;
  }

  public BPartner cDunningId(Integer cDunningId) {
    this.cDunningId = cDunningId;
    return this;
  }

  /**
   * Reglas de impagos para facturas vencidas
   * @return cDunningId
   **/
  @Schema(description = "Reglas de impagos para facturas vencidas")
  
    public Integer getCDunningId() {
    return cDunningId;
  }

  public void setCDunningId(Integer cDunningId) {
    this.cDunningId = cDunningId;
  }

  public BPartner cGreetingId(Integer cGreetingId) {
    this.cGreetingId = cGreetingId;
    return this;
  }

  /**
   * Saludo para imprimir en la correspondencia
   * @return cGreetingId
   **/
  @Schema(description = "Saludo para imprimir en la correspondencia")
  
    public Integer getCGreetingId() {
    return cGreetingId;
  }

  public void setCGreetingId(Integer cGreetingId) {
    this.cGreetingId = cGreetingId;
  }

  public BPartner cInvoicescheduleId(Integer cInvoicescheduleId) {
    this.cInvoicescheduleId = cInvoicescheduleId;
    return this;
  }

  /**
   * Programa para generar facturas
   * @return cInvoicescheduleId
   **/
  @Schema(description = "Programa para generar facturas")
  
    public Integer getCInvoicescheduleId() {
    return cInvoicescheduleId;
  }

  public void setCInvoicescheduleId(Integer cInvoicescheduleId) {
    this.cInvoicescheduleId = cInvoicescheduleId;
  }

  public BPartner cJobcategoryId(Integer cJobcategoryId) {
    this.cJobcategoryId = cJobcategoryId;
    return this;
  }

  /**
   * Categoria del Puesto
   * @return cJobcategoryId
   **/
  @Schema(description = "Categoria del Puesto")
  
    public Integer getCJobcategoryId() {
    return cJobcategoryId;
  }

  public void setCJobcategoryId(Integer cJobcategoryId) {
    this.cJobcategoryId = cJobcategoryId;
  }

  public BPartner cLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
    return this;
  }

  /**
   * Ubicación o Dirección
   * @return cLocationId
   **/
  @Schema(description = "Ubicación o Dirección")
  
    public Integer getCLocationId() {
    return cLocationId;
  }

  public void setCLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
  }

  public BPartner copyfrom(String copyfrom) {
    this.copyfrom = copyfrom;
    return this;
  }

  /**
   * Copiar Registros desde
   * @return copyfrom
   **/
  @Schema(description = "Copiar Registros desde")
  
    public String getCopyfrom() {
    return copyfrom;
  }

  public void setCopyfrom(String copyfrom) {
    this.copyfrom = copyfrom;
  }

  public BPartner copyvendorproducts(String copyvendorproducts) {
    this.copyvendorproducts = copyvendorproducts;
    return this;
  }

  /**
   *  
   * @return copyvendorproducts
   **/
  @Schema(description = " ")
  
    public String getCopyvendorproducts() {
    return copyvendorproducts;
  }

  public void setCopyvendorproducts(String copyvendorproducts) {
    this.copyvendorproducts = copyvendorproducts;
  }

  public BPartner cPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
    return this;
  }

  /**
   * Programa de Vctos.
   * @return cPaymenttermId
   **/
  @Schema(description = "Programa de Vctos.")
  
    public Integer getCPaymenttermId() {
    return cPaymenttermId;
  }

  public void setCPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
  }

  public BPartner cPospaymentmediumId(Integer cPospaymentmediumId) {
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

  public BPartner created(String created) {
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

  public BPartner createdby(Integer createdby) {
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

  public BPartner creditminimumamt(BigDecimal creditminimumamt) {
    this.creditminimumamt = creditminimumamt;
    return this;
  }

  /**
   * El monto mínimo de bloqueo determina un mínimo que se considera al cliente no moroso.
   * @return creditminimumamt
   **/
  @Schema(required = true, description = "El monto mínimo de bloqueo determina un mínimo que se considera al cliente no moroso.")
      @NotNull

    @Valid
    public BigDecimal getCreditminimumamt() {
    return creditminimumamt;
  }

  public void setCreditminimumamt(BigDecimal creditminimumamt) {
    this.creditminimumamt = creditminimumamt;
  }

  public BPartner creditsituation(String creditsituation) {
    this.creditsituation = creditsituation;
    return this;
  }

  /**
   *  
   * @return creditsituation
   **/
  @Schema(description = " ")
  
    public String getCreditsituation() {
    return creditsituation;
  }

  public void setCreditsituation(String creditsituation) {
    this.creditsituation = creditsituation;
  }

  public BPartner cRegionSedeId(Integer cRegionSedeId) {
    this.cRegionSedeId = cRegionSedeId;
    return this;
  }

  /**
   *  
   * @return cRegionSedeId
   **/
  @Schema(description = " ")
  
    public Integer getCRegionSedeId() {
    return cRegionSedeId;
  }

  public void setCRegionSedeId(Integer cRegionSedeId) {
    this.cRegionSedeId = cRegionSedeId;
  }

  public BPartner customertype(String customertype) {
    this.customertype = customertype;
    return this;
  }

  /**
   *  
   * @return customertype
   **/
  @Schema(description = " ")
  
    public String getCustomertype() {
    return customertype;
  }

  public void setCustomertype(String customertype) {
    this.customertype = customertype;
  }

  public BPartner deliveryrule(String deliveryrule) {
    this.deliveryrule = deliveryrule;
    return this;
  }

  /**
   * Define los tiempos de entrega
   * @return deliveryrule
   **/
  @Schema(description = "Define los tiempos de entrega")
  
    public String getDeliveryrule() {
    return deliveryrule;
  }

  public void setDeliveryrule(String deliveryrule) {
    this.deliveryrule = deliveryrule;
  }

  public BPartner deliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
    return this;
  }

  /**
   * Como será entregada la orden
   * @return deliveryviarule
   **/
  @Schema(description = "Como será entregada la orden")
  
    public String getDeliveryviarule() {
    return deliveryviarule;
  }

  public void setDeliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
  }

  public BPartner description(String description) {
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

  public BPartner discountcontext(String discountcontext) {
    this.discountcontext = discountcontext;
    return this;
  }

  /**
   * Contexto de aplicación del descuento
   * @return discountcontext
   **/
  @Schema(required = true, description = "Contexto de aplicación del descuento")
      @NotNull

    public String getDiscountcontext() {
    return discountcontext;
  }

  public void setDiscountcontext(String discountcontext) {
    this.discountcontext = discountcontext;
  }

  public BPartner documentcopies(Integer documentcopies) {
    this.documentcopies = documentcopies;
    return this;
  }

  /**
   * Número de copias a ser impresas
   * @return documentcopies
   **/
  @Schema(description = "Número de copias a ser impresas")
  
    public Integer getDocumentcopies() {
    return documentcopies;
  }

  public void setDocumentcopies(Integer documentcopies) {
    this.documentcopies = documentcopies;
  }

  public BPartner duns(String duns) {
    this.duns = duns;
    return this;
  }

  /**
   * Introduzca el CIF/NIF DE LA EMPRESA O PARTICULAR
   * @return duns
   **/
  @Schema(description = "Introduzca el CIF/NIF DE LA EMPRESA O PARTICULAR")
  
    public String getDuns() {
    return duns;
  }

  public void setDuns(String duns) {
    this.duns = duns;
  }

  public BPartner emitirMiPyme(Boolean emitirMiPyme) {
    this.emitirMiPyme = emitirMiPyme;
    return this;
  }

  /**
   *  
   * @return emitirMiPyme
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isEmitirMiPyme() {
    return emitirMiPyme;
  }

  public void setEmitirMiPyme(Boolean emitirMiPyme) {
    this.emitirMiPyme = emitirMiPyme;
  }

  public BPartner endholidays(String endholidays) {
    this.endholidays = endholidays;
    return this;
  }

  /**
   *  
   * @return endholidays
   **/
  @Schema(description = " ")
  
    public String getEndholidays() {
    return endholidays;
  }

  public void setEndholidays(String endholidays) {
    this.endholidays = endholidays;
  }

  public BPartner endholidays2(String endholidays2) {
    this.endholidays2 = endholidays2;
    return this;
  }

  /**
   *  
   * @return endholidays2
   **/
  @Schema(description = " ")
  
    public String getEndholidays2() {
    return endholidays2;
  }

  public void setEndholidays2(String endholidays2) {
    this.endholidays2 = endholidays2;
  }

  public BPartner firstsale(String firstsale) {
    this.firstsale = firstsale;
    return this;
  }

  /**
   * Fecha de la primera venta
   * @return firstsale
   **/
  @Schema(description = "Fecha de la primera venta")
  
    public String getFirstsale() {
    return firstsale;
  }

  public void setFirstsale(String firstsale) {
    this.firstsale = firstsale;
  }

  public BPartner flatdiscount(BigDecimal flatdiscount) {
    this.flatdiscount = flatdiscount;
    return this;
  }

  /**
   * Porcentaje de descuento simple
   * @return flatdiscount
   **/
  @Schema(description = "Porcentaje de descuento simple")
  
    @Valid
    public BigDecimal getFlatdiscount() {
    return flatdiscount;
  }

  public void setFlatdiscount(BigDecimal flatdiscount) {
    this.flatdiscount = flatdiscount;
  }

  public BPartner freightcostrule(String freightcostrule) {
    this.freightcostrule = freightcostrule;
    return this;
  }

  /**
   * Regla de Coste de Transporte
   * @return freightcostrule
   **/
  @Schema(description = "Regla de Coste de Transporte")
  
    public String getFreightcostrule() {
    return freightcostrule;
  }

  public void setFreightcostrule(String freightcostrule) {
    this.freightcostrule = freightcostrule;
  }

  public BPartner goal(BigDecimal goal) {
    this.goal = goal;
    return this;
  }

  /**
   * Meta del Rendimiento desde 0.1
   * @return goal
   **/
  @Schema(description = "Meta del Rendimiento desde 0.1")
  
    @Valid
    public BigDecimal getGoal() {
    return goal;
  }

  public void setGoal(BigDecimal goal) {
    this.goal = goal;
  }

  public BPartner iibb(String iibb) {
    this.iibb = iibb;
    return this;
  }

  /**
   *  
   * @return iibb
   **/
  @Schema(description = " ")
  
    public String getIibb() {
    return iibb;
  }

  public void setIibb(String iibb) {
    this.iibb = iibb;
  }

  public BPartner iibbtype(String iibbtype) {
    this.iibbtype = iibbtype;
    return this;
  }

  /**
   *  
   * @return iibbtype
   **/
  @Schema(description = " ")
  
    public String getIibbtype() {
    return iibbtype;
  }

  public void setIibbtype(String iibbtype) {
    this.iibbtype = iibbtype;
  }

  public BPartner invoicePrintformatId(Integer invoicePrintformatId) {
    this.invoicePrintformatId = invoicePrintformatId;
    return this;
  }

  /**
   * Formato de impresión usado para imprimir facturas
   * @return invoicePrintformatId
   **/
  @Schema(description = "Formato de impresión usado para imprimir facturas")
  
    public Integer getInvoicePrintformatId() {
    return invoicePrintformatId;
  }

  public void setInvoicePrintformatId(Integer invoicePrintformatId) {
    this.invoicePrintformatId = invoicePrintformatId;
  }

  public BPartner invoicerule(String invoicerule) {
    this.invoicerule = invoicerule;
    return this;
  }

  /**
   * Frecuencia y métodos de facturación
   * @return invoicerule
   **/
  @Schema(description = "Frecuencia y métodos de facturación")
  
    public String getInvoicerule() {
    return invoicerule;
  }

  public void setInvoicerule(String invoicerule) {
    this.invoicerule = invoicerule;
  }

  public BPartner isactive(Boolean isactive) {
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

  public BPartner iscompoundtax(Boolean iscompoundtax) {
    this.iscompoundtax = iscompoundtax;
    return this;
  }

  /**
   *  
   * @return iscompoundtax
   **/
  @Schema(description = " ")
  
    public Boolean isIscompoundtax() {
    return iscompoundtax;
  }

  public void setIscompoundtax(Boolean iscompoundtax) {
    this.iscompoundtax = iscompoundtax;
  }

  public BPartner isconveniomultilateral(String isconveniomultilateral) {
    this.isconveniomultilateral = isconveniomultilateral;
    return this;
  }

  /**
   * Entidades comerciales en Convenio Multilateral
   * @return isconveniomultilateral
   **/
  @Schema(description = "Entidades comerciales en Convenio Multilateral")
  
    public String getIsconveniomultilateral() {
    return isconveniomultilateral;
  }

  public void setIsconveniomultilateral(String isconveniomultilateral) {
    this.isconveniomultilateral = isconveniomultilateral;
  }

  public BPartner iscustomer(Boolean iscustomer) {
    this.iscustomer = iscustomer;
    return this;
  }

  /**
   * Indica si la Entidad Comercial es un cliente de la compañia
   * @return iscustomer
   **/
  @Schema(required = true, description = "Indica si la Entidad Comercial es un cliente de la compañia")
      @NotNull

    public Boolean isIscustomer() {
    return iscustomer;
  }

  public void setIscustomer(Boolean iscustomer) {
    this.iscustomer = iscustomer;
  }

  public BPartner isdiscountprinted(Boolean isdiscountprinted) {
    this.isdiscountprinted = isdiscountprinted;
    return this;
  }

  /**
   * Imprimir el descuento en la Factura y la Orden
   * @return isdiscountprinted
   **/
  @Schema(description = "Imprimir el descuento en la Factura y la Orden")
  
    public Boolean isIsdiscountprinted() {
    return isdiscountprinted;
  }

  public void setIsdiscountprinted(Boolean isdiscountprinted) {
    this.isdiscountprinted = isdiscountprinted;
  }

  public BPartner isemployee(Boolean isemployee) {
    this.isemployee = isemployee;
    return this;
  }

  /**
   * Indica si el Socio Comercial es un empleado
   * @return isemployee
   **/
  @Schema(required = true, description = "Indica si el Socio Comercial es un empleado")
      @NotNull

    public Boolean isIsemployee() {
    return isemployee;
  }

  public void setIsemployee(Boolean isemployee) {
    this.isemployee = isemployee;
  }

  public BPartner isgroupinvoices(Boolean isgroupinvoices) {
    this.isgroupinvoices = isgroupinvoices;
    return this;
  }

  /**
   * Indica que en Recibos de Cliente se deben agrupar las facturas.
   * @return isgroupinvoices
   **/
  @Schema(required = true, description = "Indica que en Recibos de Cliente se deben agrupar las facturas.")
      @NotNull

    public Boolean isIsgroupinvoices() {
    return isgroupinvoices;
  }

  public void setIsgroupinvoices(Boolean isgroupinvoices) {
    this.isgroupinvoices = isgroupinvoices;
  }

  public BPartner isiso(Boolean isiso) {
    this.isiso = isiso;
    return this;
  }

  /**
   *  
   * @return isiso
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsiso() {
    return isiso;
  }

  public void setIsiso(Boolean isiso) {
    this.isiso = isiso;
  }

  public BPartner ismandatorycai(Boolean ismandatorycai) {
    this.ismandatorycai = ismandatorycai;
    return this;
  }

  /**
   * Validar CAI Obligatorio
   * @return ismandatorycai
   **/
  @Schema(required = true, description = "Validar CAI Obligatorio")
      @NotNull

    public Boolean isIsmandatorycai() {
    return ismandatorycai;
  }

  public void setIsmandatorycai(Boolean ismandatorycai) {
    this.ismandatorycai = ismandatorycai;
  }

  public BPartner ismulticuit(Boolean ismulticuit) {
    this.ismulticuit = ismulticuit;
    return this;
  }

  /**
   * El CUIT/CUIL ingresado puede repetirse dentro del sistema
   * @return ismulticuit
   **/
  @Schema(required = true, description = "El CUIT/CUIL ingresado puede repetirse dentro del sistema")
      @NotNull

    public Boolean isIsmulticuit() {
    return ismulticuit;
  }

  public void setIsmulticuit(Boolean ismulticuit) {
    this.ismulticuit = ismulticuit;
  }

  public BPartner isonetime(Boolean isonetime) {
    this.isonetime = isonetime;
    return this;
  }

  /**
   *  
   * @return isonetime
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsonetime() {
    return isonetime;
  }

  public void setIsonetime(Boolean isonetime) {
    this.isonetime = isonetime;
  }

  public BPartner isprospect(Boolean isprospect) {
    this.isprospect = isprospect;
    return this;
  }

  /**
   * Cliente potencial u objetivo posible.
   * @return isprospect
   **/
  @Schema(required = true, description = "Cliente potencial u objetivo posible.")
      @NotNull

    public Boolean isIsprospect() {
    return isprospect;
  }

  public void setIsprospect(Boolean isprospect) {
    this.isprospect = isprospect;
  }

  public BPartner issalesrep(Boolean issalesrep) {
    this.issalesrep = issalesrep;
    return this;
  }

  /**
   * Indica si el empleado es un Comercial
   * @return issalesrep
   **/
  @Schema(required = true, description = "Indica si el empleado es un Comercial")
      @NotNull

    public Boolean isIssalesrep() {
    return issalesrep;
  }

  public void setIssalesrep(Boolean issalesrep) {
    this.issalesrep = issalesrep;
  }

  public BPartner issummary(Boolean issummary) {
    this.issummary = issummary;
    return this;
  }

  /**
   * Carpeta
   * @return issummary
   **/
  @Schema(required = true, description = "Carpeta")
      @NotNull

    public Boolean isIssummary() {
    return issummary;
  }

  public void setIssummary(Boolean issummary) {
    this.issummary = issummary;
  }

  public BPartner istaxexempt(Boolean istaxexempt) {
    this.istaxexempt = istaxexempt;
    return this;
  }

  /**
   * Este Socio del Negocio esta exento del impuesto de ventas
   * @return istaxexempt
   **/
  @Schema(description = "Este Socio del Negocio esta exento del impuesto de ventas")
  
    public Boolean isIstaxexempt() {
    return istaxexempt;
  }

  public void setIstaxexempt(Boolean istaxexempt) {
    this.istaxexempt = istaxexempt;
  }

  public BPartner isvendor(Boolean isvendor) {
    this.isvendor = isvendor;
    return this;
  }

  /**
   * Indica si el Socio Comercial es un Proveedor
   * @return isvendor
   **/
  @Schema(required = true, description = "Indica si el Socio Comercial es un Proveedor")
      @NotNull

    public Boolean isIsvendor() {
    return isvendor;
  }

  public void setIsvendor(Boolean isvendor) {
    this.isvendor = isvendor;
  }

  public BPartner mDiscountschemaId(Integer mDiscountschemaId) {
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

  public BPartner minimumpurchasedamt(BigDecimal minimumpurchasedamt) {
    this.minimumpurchasedamt = minimumpurchasedamt;
    return this;
  }

  /**
   * No se permite realizar una orden de compra por debajo de este monto.
   * @return minimumpurchasedamt
   **/
  @Schema(required = true, description = "No se permite realizar una orden de compra por debajo de este monto.")
      @NotNull

    @Valid
    public BigDecimal getMinimumpurchasedamt() {
    return minimumpurchasedamt;
  }

  public void setMinimumpurchasedamt(BigDecimal minimumpurchasedamt) {
    this.minimumpurchasedamt = minimumpurchasedamt;
  }

  public BPartner minOrderQty(BigDecimal minOrderQty) {
    this.minOrderQty = minOrderQty;
    return this;
  }

  /**
   *  
   * @return minOrderQty
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getMinOrderQty() {
    return minOrderQty;
  }

  public void setMinOrderQty(BigDecimal minOrderQty) {
    this.minOrderQty = minOrderQty;
  }

  public BPartner mPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
    return this;
  }

  /**
   * Identificador único de mi lista de precios
   * @return mPricelistId
   **/
  @Schema(description = "Identificador único de mi lista de precios")
  
    public Integer getMPricelistId() {
    return mPricelistId;
  }

  public void setMPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
  }

  public BPartner mProductRelatedId(Integer mProductRelatedId) {
    this.mProductRelatedId = mProductRelatedId;
    return this;
  }

  /**
   * Artículo Vinculado en Facturas Generadas Automáticamente
   * @return mProductRelatedId
   **/
  @Schema(description = "Artículo Vinculado en Facturas Generadas Automáticamente")
  
    public Integer getMProductRelatedId() {
    return mProductRelatedId;
  }

  public void setMProductRelatedId(Integer mProductRelatedId) {
    this.mProductRelatedId = mProductRelatedId;
  }

  public BPartner mShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
    return this;
  }

  /**
   * Método o manera de entrega del producto
   * @return mShipperId
   **/
  @Schema(description = "Método o manera de entrega del producto")
  
    public Integer getMShipperId() {
    return mShipperId;
  }

  public void setMShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
  }

  public BPartner naics(String naics) {
    this.naics = naics;
    return this;
  }

  /**
   * Standard Industry Code o su susesor NAIC - http://www.osha.gov/oshstats/sicser.html
   * @return naics
   **/
  @Schema(description = "Standard Industry Code o su susesor NAIC - http://www.osha.gov/oshstats/sicser.html")
  
    public String getNaics() {
    return naics;
  }

  public void setNaics(String naics) {
    this.naics = naics;
  }

  public BPartner name(String name) {
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

  public BPartner name2(String name2) {
    this.name2 = name2;
    return this;
  }

  /**
   * Nombre adicional
   * @return name2
   **/
  @Schema(description = "Nombre adicional")
  
    public String getName2() {
    return name2;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }

  public BPartner numberemployees(Integer numberemployees) {
    this.numberemployees = numberemployees;
    return this;
  }

  /**
   * Número de empleados
   * @return numberemployees
   **/
  @Schema(description = "Número de empleados")
  
    public Integer getNumberemployees() {
    return numberemployees;
  }

  public void setNumberemployees(Integer numberemployees) {
    this.numberemployees = numberemployees;
  }

  public BPartner paymentblocked(Boolean paymentblocked) {
    this.paymentblocked = paymentblocked;
    return this;
  }

  /**
   *  
   * @return paymentblocked
   **/
  @Schema(description = " ")
  
    public Boolean isPaymentblocked() {
    return paymentblocked;
  }

  public void setPaymentblocked(Boolean paymentblocked) {
    this.paymentblocked = paymentblocked;
  }

  public BPartner paymentblockeddescr(String paymentblockeddescr) {
    this.paymentblockeddescr = paymentblockeddescr;
    return this;
  }

  /**
   *  
   * @return paymentblockeddescr
   **/
  @Schema(description = " ")
  
    public String getPaymentblockeddescr() {
    return paymentblockeddescr;
  }

  public void setPaymentblockeddescr(String paymentblockeddescr) {
    this.paymentblockeddescr = paymentblockeddescr;
  }

  public BPartner paymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
    return this;
  }

  /**
   * Como se pagará la factura
   * @return paymentrule
   **/
  @Schema(description = "Como se pagará la factura")
  
    public String getPaymentrule() {
    return paymentrule;
  }

  public void setPaymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
  }

  public BPartner paymentrulepo(String paymentrulepo) {
    this.paymentrulepo = paymentrulepo;
    return this;
  }

  /**
   * Opción de pago por compras
   * @return paymentrulepo
   **/
  @Schema(description = "Opción de pago por compras")
  
    public String getPaymentrulepo() {
    return paymentrulepo;
  }

  public void setPaymentrulepo(String paymentrulepo) {
    this.paymentrulepo = paymentrulepo;
  }

  public BPartner poDiscountschemaId(Integer poDiscountschemaId) {
    this.poDiscountschemaId = poDiscountschemaId;
    return this;
  }

  /**
   * Esquema Del Descuento en Pedido a Proveedor
   * @return poDiscountschemaId
   **/
  @Schema(description = "Esquema Del Descuento en Pedido a Proveedor")
  
    public Integer getPoDiscountschemaId() {
    return poDiscountschemaId;
  }

  public void setPoDiscountschemaId(Integer poDiscountschemaId) {
    this.poDiscountschemaId = poDiscountschemaId;
  }

  public BPartner poPaymenttermId(Integer poPaymenttermId) {
    this.poPaymenttermId = poPaymenttermId;
    return this;
  }

  /**
   * Reglas de Pago en Pedido de Cliente
   * @return poPaymenttermId
   **/
  @Schema(description = "Reglas de Pago en Pedido de Cliente")
  
    public Integer getPoPaymenttermId() {
    return poPaymenttermId;
  }

  public void setPoPaymenttermId(Integer poPaymenttermId) {
    this.poPaymenttermId = poPaymenttermId;
  }

  public BPartner poPricelistId(Integer poPricelistId) {
    this.poPricelistId = poPricelistId;
    return this;
  }

  /**
   * Lista de precios usada por este Socio del Negocio
   * @return poPricelistId
   **/
  @Schema(description = "Lista de precios usada por este Socio del Negocio")
  
    public Integer getPoPricelistId() {
    return poPricelistId;
  }

  public void setPoPricelistId(Integer poPricelistId) {
    this.poPricelistId = poPricelistId;
  }

  public BPartner poreference(String poreference) {
    this.poreference = poreference;
    return this;
  }

  /**
   * Referencia de Pedido de la Entidad
   * @return poreference
   **/
  @Schema(description = "Referencia de Pedido de la Entidad")
  
    public String getPoreference() {
    return poreference;
  }

  public void setPoreference(String poreference) {
    this.poreference = poreference;
  }

  public BPartner potentiallifetimevalue(BigDecimal potentiallifetimevalue) {
    this.potentiallifetimevalue = potentiallifetimevalue;
    return this;
  }

  /**
   * Total de ingresos esperados
   * @return potentiallifetimevalue
   **/
  @Schema(description = "Total de ingresos esperados")
  
    @Valid
    public BigDecimal getPotentiallifetimevalue() {
    return potentiallifetimevalue;
  }

  public void setPotentiallifetimevalue(BigDecimal potentiallifetimevalue) {
    this.potentiallifetimevalue = potentiallifetimevalue;
  }

  public BPartner processpo(String processpo) {
    this.processpo = processpo;
    return this;
  }

  /**
   *  
   * @return processpo
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getProcesspo() {
    return processpo;
  }

  public void setProcesspo(String processpo) {
    this.processpo = processpo;
  }

  public BPartner programAmt(BigDecimal programAmt) {
    this.programAmt = programAmt;
    return this;
  }

  /**
   *  
   * @return programAmt
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getProgramAmt() {
    return programAmt;
  }

  public void setProgramAmt(BigDecimal programAmt) {
    this.programAmt = programAmt;
  }

  public BPartner programAmtUsed(BigDecimal programAmtUsed) {
    this.programAmtUsed = programAmtUsed;
    return this;
  }

  /**
   *  
   * @return programAmtUsed
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getProgramAmtUsed() {
    return programAmtUsed;
  }

  public void setProgramAmtUsed(BigDecimal programAmtUsed) {
    this.programAmtUsed = programAmtUsed;
  }

  public BPartner rating(String rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Valoración
   * @return rating
   **/
  @Schema(description = "Valoración")
  
    public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public BPartner referenceno(String referenceno) {
    this.referenceno = referenceno;
    return this;
  }

  /**
   * Su número de cliente o proveedor con el Socio Comercial
   * @return referenceno
   **/
  @Schema(description = "Su número de cliente o proveedor con el Socio Comercial")
  
    public String getReferenceno() {
    return referenceno;
  }

  public void setReferenceno(String referenceno) {
    this.referenceno = referenceno;
  }

  public BPartner salesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
    return this;
  }

  /**
   * Comercial/Usuario
   * @return salesrepId
   **/
  @Schema(description = "Comercial/Usuario")
  
    public Integer getSalesrepId() {
    return salesrepId;
  }

  public void setSalesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
  }

  public BPartner salesvolume(Integer salesvolume) {
    this.salesvolume = salesvolume;
    return this;
  }

  /**
   * Volumen total de Ventas
   * @return salesvolume
   **/
  @Schema(description = "Volumen total de Ventas")
  
    public Integer getSalesvolume() {
    return salesvolume;
  }

  public void setSalesvolume(Integer salesvolume) {
    this.salesvolume = salesvolume;
  }

  public BPartner searchunallocatedpayments(Boolean searchunallocatedpayments) {
    this.searchunallocatedpayments = searchunallocatedpayments;
    return this;
  }

  /**
   * Buscar Pagos/Cobros sin asignar en Ordenes de Pago/Recibos de Cliente
   * @return searchunallocatedpayments
   **/
  @Schema(required = true, description = "Buscar Pagos/Cobros sin asignar en Ordenes de Pago/Recibos de Cliente")
      @NotNull

    public Boolean isSearchunallocatedpayments() {
    return searchunallocatedpayments;
  }

  public void setSearchunallocatedpayments(Boolean searchunallocatedpayments) {
    this.searchunallocatedpayments = searchunallocatedpayments;
  }

  public BPartner secondarycreditstatus(String secondarycreditstatus) {
    this.secondarycreditstatus = secondarycreditstatus;
    return this;
  }

  /**
   * Este estado de crédito describe la situación actual del cliente
   * @return secondarycreditstatus
   **/
  @Schema(required = true, description = "Este estado de crédito describe la situación actual del cliente")
      @NotNull

    public String getSecondarycreditstatus() {
    return secondarycreditstatus;
  }

  public void setSecondarycreditstatus(String secondarycreditstatus) {
    this.secondarycreditstatus = secondarycreditstatus;
  }

  public BPartner sendemail(Boolean sendemail) {
    this.sendemail = sendemail;
    return this;
  }

  /**
   * Permite enviar Documentos vía E-Mail
   * @return sendemail
   **/
  @Schema(required = true, description = "Permite enviar Documentos vía E-Mail")
      @NotNull

    public Boolean isSendemail() {
    return sendemail;
  }

  public void setSendemail(Boolean sendemail) {
    this.sendemail = sendemail;
  }

  public BPartner shareofcustomer(Integer shareofcustomer) {
    this.shareofcustomer = shareofcustomer;
    return this;
  }

  /**
   * Participación del Cliente
   * @return shareofcustomer
   **/
  @Schema(description = "Participación del Cliente")
  
    public Integer getShareofcustomer() {
    return shareofcustomer;
  }

  public void setShareofcustomer(Integer shareofcustomer) {
    this.shareofcustomer = shareofcustomer;
  }

  public BPartner shelflifeminpct(Integer shelflifeminpct) {
    this.shelflifeminpct = shelflifeminpct;
    return this;
  }

  /**
   * Minimo de Vida en Estanteria (%)
   * @return shelflifeminpct
   **/
  @Schema(description = "Minimo de Vida en Estanteria (%)")
  
    public Integer getShelflifeminpct() {
    return shelflifeminpct;
  }

  public void setShelflifeminpct(Integer shelflifeminpct) {
    this.shelflifeminpct = shelflifeminpct;
  }

  public BPartner soCreditlimit(BigDecimal soCreditlimit) {
    this.soCreditlimit = soCreditlimit;
    return this;
  }

  /**
   * Total pendiente del importe de la factura pendiente
   * @return soCreditlimit
   **/
  @Schema(required = true, description = "Total pendiente del importe de la factura pendiente")
      @NotNull

    @Valid
    public BigDecimal getSoCreditlimit() {
    return soCreditlimit;
  }

  public void setSoCreditlimit(BigDecimal soCreditlimit) {
    this.soCreditlimit = soCreditlimit;
  }

  public BPartner socreditstatus(String socreditstatus) {
    this.socreditstatus = socreditstatus;
    return this;
  }

  /**
   * Estado de Crédito de Ventas
   * @return socreditstatus
   **/
  @Schema(description = "Estado de Crédito de Ventas")
  
    public String getSocreditstatus() {
    return socreditstatus;
  }

  public void setSocreditstatus(String socreditstatus) {
    this.socreditstatus = socreditstatus;
  }

  public BPartner soCreditused(BigDecimal soCreditused) {
    this.soCreditused = soCreditused;
    return this;
  }

  /**
   * Balance actual abierto
   * @return soCreditused
   **/
  @Schema(required = true, description = "Balance actual abierto")
      @NotNull

    @Valid
    public BigDecimal getSoCreditused() {
    return soCreditused;
  }

  public void setSoCreditused(BigDecimal soCreditused) {
    this.soCreditused = soCreditused;
  }

  public BPartner soDescription(String soDescription) {
    this.soDescription = soDescription;
    return this;
  }

  /**
   * Descripción a ser usada en órdenes
   * @return soDescription
   **/
  @Schema(description = "Descripción a ser usada en órdenes")
  
    public String getSoDescription() {
    return soDescription;
  }

  public void setSoDescription(String soDescription) {
    this.soDescription = soDescription;
  }

  public BPartner startholidays(String startholidays) {
    this.startholidays = startholidays;
    return this;
  }

  /**
   *  
   * @return startholidays
   **/
  @Schema(description = " ")
  
    public String getStartholidays() {
    return startholidays;
  }

  public void setStartholidays(String startholidays) {
    this.startholidays = startholidays;
  }

  public BPartner startholidays2(String startholidays2) {
    this.startholidays2 = startholidays2;
    return this;
  }

  /**
   *  
   * @return startholidays2
   **/
  @Schema(description = " ")
  
    public String getStartholidays2() {
    return startholidays2;
  }

  public void setStartholidays2(String startholidays2) {
    this.startholidays2 = startholidays2;
  }

  public BPartner taxid(String taxid) {
    this.taxid = taxid;
    return this;
  }

  /**
   * Codigo único de Identificacion Tributaria / Documento Nacional de Identidad
   * @return taxid
   **/
  @Schema(description = "Codigo único de Identificacion Tributaria / Documento Nacional de Identidad")
  
    public String getTaxid() {
    return taxid;
  }

  public void setTaxid(String taxid) {
    this.taxid = taxid;
  }

  public BPartner taxidtype(String taxidtype) {
    this.taxidtype = taxidtype;
    return this;
  }

  /**
   *  
   * @return taxidtype
   **/
  @Schema(description = " ")
  
    public String getTaxidtype() {
    return taxidtype;
  }

  public void setTaxidtype(String taxidtype) {
    this.taxidtype = taxidtype;
  }

  public BPartner totalopenbalance(BigDecimal totalopenbalance) {
    this.totalopenbalance = totalopenbalance;
    return this;
  }

  /**
   * Balance Abierto
   * @return totalopenbalance
   **/
  @Schema(description = "Balance Abierto")
  
    @Valid
    public BigDecimal getTotalopenbalance() {
    return totalopenbalance;
  }

  public void setTotalopenbalance(BigDecimal totalopenbalance) {
    this.totalopenbalance = totalopenbalance;
  }

  public BPartner trxenabled(Boolean trxenabled) {
    this.trxenabled = trxenabled;
    return this;
  }

  /**
   * La entidad comercial está habilitada para realizar transacciones dentro del sistema
   * @return trxenabled
   **/
  @Schema(required = true, description = "La entidad comercial está habilitada para realizar transacciones dentro del sistema")
      @NotNull

    public Boolean isTrxenabled() {
    return trxenabled;
  }

  public void setTrxenabled(Boolean trxenabled) {
    this.trxenabled = trxenabled;
  }

  public BPartner updatebalance(String updatebalance) {
    this.updatebalance = updatebalance;
    return this;
  }

  /**
   * Actualizar Saldo de la Entidad Comercial
   * @return updatebalance
   **/
  @Schema(description = "Actualizar Saldo de la Entidad Comercial")
  
    public String getUpdatebalance() {
    return updatebalance;
  }

  public void setUpdatebalance(String updatebalance) {
    this.updatebalance = updatebalance;
  }

  public BPartner updated(String updated) {
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

  public BPartner updatedby(Integer updatedby) {
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

  public BPartner url(String url) {
    this.url = url;
    return this;
  }

  /**
   * URL
   * @return url
   **/
  @Schema(description = "URL")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public BPartner value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Clave de búsqueda para el registro en el formato requerido; debe ser única
   * @return value
   **/
  @Schema(required = true, description = "Clave de búsqueda para el registro en el formato requerido; debe ser única")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public BPartner additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public BPartner addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public BPartner referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public BPartner addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    BPartner bpartner = (BPartner) o;
    return Objects.equals(this.acqusitioncost, bpartner.acqusitioncost) &&
        Objects.equals(this.actuallifetimevalue, bpartner.actuallifetimevalue) &&
        Objects.equals(this.adClientId, bpartner.adClientId) &&
        Objects.equals(this.adComponentobjectuid, bpartner.adComponentobjectuid) &&
        Objects.equals(this.adLanguage, bpartner.adLanguage) &&
        Objects.equals(this.adOrgbpId, bpartner.adOrgbpId) &&
        Objects.equals(this.adOrgId, bpartner.adOrgId) &&
        Objects.equals(this.allowadvancedpaymentreceipts, bpartner.allowadvancedpaymentreceipts) &&
        Objects.equals(this.allowpartialpayment, bpartner.allowpartialpayment) &&
        Objects.equals(this.aNameCheck, bpartner.aNameCheck) &&
        Objects.equals(this.automaticcreditnotes, bpartner.automaticcreditnotes) &&
        Objects.equals(this.batchPaymentRule, bpartner.batchPaymentRule) &&
        Objects.equals(this.bpartnerParentId, bpartner.bpartnerParentId) &&
        Objects.equals(this.builtcabajurisdiction, bpartner.builtcabajurisdiction) &&
        Objects.equals(this.cBankaccountId, bpartner.cBankaccountId) &&
        Objects.equals(this.cBpartnerId, bpartner.cBpartnerId) &&
        Objects.equals(this.cBpGroupId, bpartner.cBpGroupId) &&
        Objects.equals(this.cCategoriaIvaId, bpartner.cCategoriaIvaId) &&
        Objects.equals(this.cDunningId, bpartner.cDunningId) &&
        Objects.equals(this.cGreetingId, bpartner.cGreetingId) &&
        Objects.equals(this.cInvoicescheduleId, bpartner.cInvoicescheduleId) &&
        Objects.equals(this.cJobcategoryId, bpartner.cJobcategoryId) &&
        Objects.equals(this.cLocationId, bpartner.cLocationId) &&
        Objects.equals(this.copyfrom, bpartner.copyfrom) &&
        Objects.equals(this.copyvendorproducts, bpartner.copyvendorproducts) &&
        Objects.equals(this.cPaymenttermId, bpartner.cPaymenttermId) &&
        Objects.equals(this.cPospaymentmediumId, bpartner.cPospaymentmediumId) &&
        Objects.equals(this.created, bpartner.created) &&
        Objects.equals(this.createdby, bpartner.createdby) &&
        Objects.equals(this.creditminimumamt, bpartner.creditminimumamt) &&
        Objects.equals(this.creditsituation, bpartner.creditsituation) &&
        Objects.equals(this.cRegionSedeId, bpartner.cRegionSedeId) &&
        Objects.equals(this.customertype, bpartner.customertype) &&
        Objects.equals(this.deliveryrule, bpartner.deliveryrule) &&
        Objects.equals(this.deliveryviarule, bpartner.deliveryviarule) &&
        Objects.equals(this.description, bpartner.description) &&
        Objects.equals(this.discountcontext, bpartner.discountcontext) &&
        Objects.equals(this.documentcopies, bpartner.documentcopies) &&
        Objects.equals(this.duns, bpartner.duns) &&
        Objects.equals(this.emitirMiPyme, bpartner.emitirMiPyme) &&
        Objects.equals(this.endholidays, bpartner.endholidays) &&
        Objects.equals(this.endholidays2, bpartner.endholidays2) &&
        Objects.equals(this.firstsale, bpartner.firstsale) &&
        Objects.equals(this.flatdiscount, bpartner.flatdiscount) &&
        Objects.equals(this.freightcostrule, bpartner.freightcostrule) &&
        Objects.equals(this.goal, bpartner.goal) &&
        Objects.equals(this.iibb, bpartner.iibb) &&
        Objects.equals(this.iibbtype, bpartner.iibbtype) &&
        Objects.equals(this.invoicePrintformatId, bpartner.invoicePrintformatId) &&
        Objects.equals(this.invoicerule, bpartner.invoicerule) &&
        Objects.equals(this.isactive, bpartner.isactive) &&
        Objects.equals(this.iscompoundtax, bpartner.iscompoundtax) &&
        Objects.equals(this.isconveniomultilateral, bpartner.isconveniomultilateral) &&
        Objects.equals(this.iscustomer, bpartner.iscustomer) &&
        Objects.equals(this.isdiscountprinted, bpartner.isdiscountprinted) &&
        Objects.equals(this.isemployee, bpartner.isemployee) &&
        Objects.equals(this.isgroupinvoices, bpartner.isgroupinvoices) &&
        Objects.equals(this.isiso, bpartner.isiso) &&
        Objects.equals(this.ismandatorycai, bpartner.ismandatorycai) &&
        Objects.equals(this.ismulticuit, bpartner.ismulticuit) &&
        Objects.equals(this.isonetime, bpartner.isonetime) &&
        Objects.equals(this.isprospect, bpartner.isprospect) &&
        Objects.equals(this.issalesrep, bpartner.issalesrep) &&
        Objects.equals(this.issummary, bpartner.issummary) &&
        Objects.equals(this.istaxexempt, bpartner.istaxexempt) &&
        Objects.equals(this.isvendor, bpartner.isvendor) &&
        Objects.equals(this.mDiscountschemaId, bpartner.mDiscountschemaId) &&
        Objects.equals(this.minimumpurchasedamt, bpartner.minimumpurchasedamt) &&
        Objects.equals(this.minOrderQty, bpartner.minOrderQty) &&
        Objects.equals(this.mPricelistId, bpartner.mPricelistId) &&
        Objects.equals(this.mProductRelatedId, bpartner.mProductRelatedId) &&
        Objects.equals(this.mShipperId, bpartner.mShipperId) &&
        Objects.equals(this.naics, bpartner.naics) &&
        Objects.equals(this.name, bpartner.name) &&
        Objects.equals(this.name2, bpartner.name2) &&
        Objects.equals(this.numberemployees, bpartner.numberemployees) &&
        Objects.equals(this.paymentblocked, bpartner.paymentblocked) &&
        Objects.equals(this.paymentblockeddescr, bpartner.paymentblockeddescr) &&
        Objects.equals(this.paymentrule, bpartner.paymentrule) &&
        Objects.equals(this.paymentrulepo, bpartner.paymentrulepo) &&
        Objects.equals(this.poDiscountschemaId, bpartner.poDiscountschemaId) &&
        Objects.equals(this.poPaymenttermId, bpartner.poPaymenttermId) &&
        Objects.equals(this.poPricelistId, bpartner.poPricelistId) &&
        Objects.equals(this.poreference, bpartner.poreference) &&
        Objects.equals(this.potentiallifetimevalue, bpartner.potentiallifetimevalue) &&
        Objects.equals(this.processpo, bpartner.processpo) &&
        Objects.equals(this.programAmt, bpartner.programAmt) &&
        Objects.equals(this.programAmtUsed, bpartner.programAmtUsed) &&
        Objects.equals(this.rating, bpartner.rating) &&
        Objects.equals(this.referenceno, bpartner.referenceno) &&
        Objects.equals(this.salesrepId, bpartner.salesrepId) &&
        Objects.equals(this.salesvolume, bpartner.salesvolume) &&
        Objects.equals(this.searchunallocatedpayments, bpartner.searchunallocatedpayments) &&
        Objects.equals(this.secondarycreditstatus, bpartner.secondarycreditstatus) &&
        Objects.equals(this.sendemail, bpartner.sendemail) &&
        Objects.equals(this.shareofcustomer, bpartner.shareofcustomer) &&
        Objects.equals(this.shelflifeminpct, bpartner.shelflifeminpct) &&
        Objects.equals(this.soCreditlimit, bpartner.soCreditlimit) &&
        Objects.equals(this.socreditstatus, bpartner.socreditstatus) &&
        Objects.equals(this.soCreditused, bpartner.soCreditused) &&
        Objects.equals(this.soDescription, bpartner.soDescription) &&
        Objects.equals(this.startholidays, bpartner.startholidays) &&
        Objects.equals(this.startholidays2, bpartner.startholidays2) &&
        Objects.equals(this.taxid, bpartner.taxid) &&
        Objects.equals(this.taxidtype, bpartner.taxidtype) &&
        Objects.equals(this.totalopenbalance, bpartner.totalopenbalance) &&
        Objects.equals(this.trxenabled, bpartner.trxenabled) &&
        Objects.equals(this.updatebalance, bpartner.updatebalance) &&
        Objects.equals(this.updated, bpartner.updated) &&
        Objects.equals(this.updatedby, bpartner.updatedby) &&
        Objects.equals(this.url, bpartner.url) &&
        Objects.equals(this.value, bpartner.value) &&
        Objects.equals(this.additionalvalues, bpartner.additionalvalues) &&
        Objects.equals(this.referencedvalues, bpartner.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acqusitioncost, actuallifetimevalue, adClientId, adComponentobjectuid, adLanguage, adOrgbpId, adOrgId, allowadvancedpaymentreceipts, allowpartialpayment, aNameCheck, automaticcreditnotes, batchPaymentRule, bpartnerParentId, builtcabajurisdiction, cBankaccountId, cBpartnerId, cBpGroupId, cCategoriaIvaId, cDunningId, cGreetingId, cInvoicescheduleId, cJobcategoryId, cLocationId, copyfrom, copyvendorproducts, cPaymenttermId, cPospaymentmediumId, created, createdby, creditminimumamt, creditsituation, cRegionSedeId, customertype, deliveryrule, deliveryviarule, description, discountcontext, documentcopies, duns, emitirMiPyme, endholidays, endholidays2, firstsale, flatdiscount, freightcostrule, goal, iibb, iibbtype, invoicePrintformatId, invoicerule, isactive, iscompoundtax, isconveniomultilateral, iscustomer, isdiscountprinted, isemployee, isgroupinvoices, isiso, ismandatorycai, ismulticuit, isonetime, isprospect, issalesrep, issummary, istaxexempt, isvendor, mDiscountschemaId, minimumpurchasedamt, minOrderQty, mPricelistId, mProductRelatedId, mShipperId, naics, name, name2, numberemployees, paymentblocked, paymentblockeddescr, paymentrule, paymentrulepo, poDiscountschemaId, poPaymenttermId, poPricelistId, poreference, potentiallifetimevalue, processpo, programAmt, programAmtUsed, rating, referenceno, salesrepId, salesvolume, searchunallocatedpayments, secondarycreditstatus, sendemail, shareofcustomer, shelflifeminpct, soCreditlimit, socreditstatus, soCreditused, soDescription, startholidays, startholidays2, taxid, taxidtype, totalopenbalance, trxenabled, updatebalance, updated, updatedby, url, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BPartner {\n");
    
    sb.append("    acqusitioncost: ").append(toIndentedString(acqusitioncost)).append("\n");
    sb.append("    actuallifetimevalue: ").append(toIndentedString(actuallifetimevalue)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adLanguage: ").append(toIndentedString(adLanguage)).append("\n");
    sb.append("    adOrgbpId: ").append(toIndentedString(adOrgbpId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    allowadvancedpaymentreceipts: ").append(toIndentedString(allowadvancedpaymentreceipts)).append("\n");
    sb.append("    allowpartialpayment: ").append(toIndentedString(allowpartialpayment)).append("\n");
    sb.append("    aNameCheck: ").append(toIndentedString(aNameCheck)).append("\n");
    sb.append("    automaticcreditnotes: ").append(toIndentedString(automaticcreditnotes)).append("\n");
    sb.append("    batchPaymentRule: ").append(toIndentedString(batchPaymentRule)).append("\n");
    sb.append("    bpartnerParentId: ").append(toIndentedString(bpartnerParentId)).append("\n");
    sb.append("    builtcabajurisdiction: ").append(toIndentedString(builtcabajurisdiction)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cBpGroupId: ").append(toIndentedString(cBpGroupId)).append("\n");
    sb.append("    cCategoriaIvaId: ").append(toIndentedString(cCategoriaIvaId)).append("\n");
    sb.append("    cDunningId: ").append(toIndentedString(cDunningId)).append("\n");
    sb.append("    cGreetingId: ").append(toIndentedString(cGreetingId)).append("\n");
    sb.append("    cInvoicescheduleId: ").append(toIndentedString(cInvoicescheduleId)).append("\n");
    sb.append("    cJobcategoryId: ").append(toIndentedString(cJobcategoryId)).append("\n");
    sb.append("    cLocationId: ").append(toIndentedString(cLocationId)).append("\n");
    sb.append("    copyfrom: ").append(toIndentedString(copyfrom)).append("\n");
    sb.append("    copyvendorproducts: ").append(toIndentedString(copyvendorproducts)).append("\n");
    sb.append("    cPaymenttermId: ").append(toIndentedString(cPaymenttermId)).append("\n");
    sb.append("    cPospaymentmediumId: ").append(toIndentedString(cPospaymentmediumId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditminimumamt: ").append(toIndentedString(creditminimumamt)).append("\n");
    sb.append("    creditsituation: ").append(toIndentedString(creditsituation)).append("\n");
    sb.append("    cRegionSedeId: ").append(toIndentedString(cRegionSedeId)).append("\n");
    sb.append("    customertype: ").append(toIndentedString(customertype)).append("\n");
    sb.append("    deliveryrule: ").append(toIndentedString(deliveryrule)).append("\n");
    sb.append("    deliveryviarule: ").append(toIndentedString(deliveryviarule)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountcontext: ").append(toIndentedString(discountcontext)).append("\n");
    sb.append("    documentcopies: ").append(toIndentedString(documentcopies)).append("\n");
    sb.append("    duns: ").append(toIndentedString(duns)).append("\n");
    sb.append("    emitirMiPyme: ").append(toIndentedString(emitirMiPyme)).append("\n");
    sb.append("    endholidays: ").append(toIndentedString(endholidays)).append("\n");
    sb.append("    endholidays2: ").append(toIndentedString(endholidays2)).append("\n");
    sb.append("    firstsale: ").append(toIndentedString(firstsale)).append("\n");
    sb.append("    flatdiscount: ").append(toIndentedString(flatdiscount)).append("\n");
    sb.append("    freightcostrule: ").append(toIndentedString(freightcostrule)).append("\n");
    sb.append("    goal: ").append(toIndentedString(goal)).append("\n");
    sb.append("    iibb: ").append(toIndentedString(iibb)).append("\n");
    sb.append("    iibbtype: ").append(toIndentedString(iibbtype)).append("\n");
    sb.append("    invoicePrintformatId: ").append(toIndentedString(invoicePrintformatId)).append("\n");
    sb.append("    invoicerule: ").append(toIndentedString(invoicerule)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    iscompoundtax: ").append(toIndentedString(iscompoundtax)).append("\n");
    sb.append("    isconveniomultilateral: ").append(toIndentedString(isconveniomultilateral)).append("\n");
    sb.append("    iscustomer: ").append(toIndentedString(iscustomer)).append("\n");
    sb.append("    isdiscountprinted: ").append(toIndentedString(isdiscountprinted)).append("\n");
    sb.append("    isemployee: ").append(toIndentedString(isemployee)).append("\n");
    sb.append("    isgroupinvoices: ").append(toIndentedString(isgroupinvoices)).append("\n");
    sb.append("    isiso: ").append(toIndentedString(isiso)).append("\n");
    sb.append("    ismandatorycai: ").append(toIndentedString(ismandatorycai)).append("\n");
    sb.append("    ismulticuit: ").append(toIndentedString(ismulticuit)).append("\n");
    sb.append("    isonetime: ").append(toIndentedString(isonetime)).append("\n");
    sb.append("    isprospect: ").append(toIndentedString(isprospect)).append("\n");
    sb.append("    issalesrep: ").append(toIndentedString(issalesrep)).append("\n");
    sb.append("    issummary: ").append(toIndentedString(issummary)).append("\n");
    sb.append("    istaxexempt: ").append(toIndentedString(istaxexempt)).append("\n");
    sb.append("    isvendor: ").append(toIndentedString(isvendor)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    minimumpurchasedamt: ").append(toIndentedString(minimumpurchasedamt)).append("\n");
    sb.append("    minOrderQty: ").append(toIndentedString(minOrderQty)).append("\n");
    sb.append("    mPricelistId: ").append(toIndentedString(mPricelistId)).append("\n");
    sb.append("    mProductRelatedId: ").append(toIndentedString(mProductRelatedId)).append("\n");
    sb.append("    mShipperId: ").append(toIndentedString(mShipperId)).append("\n");
    sb.append("    naics: ").append(toIndentedString(naics)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    name2: ").append(toIndentedString(name2)).append("\n");
    sb.append("    numberemployees: ").append(toIndentedString(numberemployees)).append("\n");
    sb.append("    paymentblocked: ").append(toIndentedString(paymentblocked)).append("\n");
    sb.append("    paymentblockeddescr: ").append(toIndentedString(paymentblockeddescr)).append("\n");
    sb.append("    paymentrule: ").append(toIndentedString(paymentrule)).append("\n");
    sb.append("    paymentrulepo: ").append(toIndentedString(paymentrulepo)).append("\n");
    sb.append("    poDiscountschemaId: ").append(toIndentedString(poDiscountschemaId)).append("\n");
    sb.append("    poPaymenttermId: ").append(toIndentedString(poPaymenttermId)).append("\n");
    sb.append("    poPricelistId: ").append(toIndentedString(poPricelistId)).append("\n");
    sb.append("    poreference: ").append(toIndentedString(poreference)).append("\n");
    sb.append("    potentiallifetimevalue: ").append(toIndentedString(potentiallifetimevalue)).append("\n");
    sb.append("    processpo: ").append(toIndentedString(processpo)).append("\n");
    sb.append("    programAmt: ").append(toIndentedString(programAmt)).append("\n");
    sb.append("    programAmtUsed: ").append(toIndentedString(programAmtUsed)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    referenceno: ").append(toIndentedString(referenceno)).append("\n");
    sb.append("    salesrepId: ").append(toIndentedString(salesrepId)).append("\n");
    sb.append("    salesvolume: ").append(toIndentedString(salesvolume)).append("\n");
    sb.append("    searchunallocatedpayments: ").append(toIndentedString(searchunallocatedpayments)).append("\n");
    sb.append("    secondarycreditstatus: ").append(toIndentedString(secondarycreditstatus)).append("\n");
    sb.append("    sendemail: ").append(toIndentedString(sendemail)).append("\n");
    sb.append("    shareofcustomer: ").append(toIndentedString(shareofcustomer)).append("\n");
    sb.append("    shelflifeminpct: ").append(toIndentedString(shelflifeminpct)).append("\n");
    sb.append("    soCreditlimit: ").append(toIndentedString(soCreditlimit)).append("\n");
    sb.append("    socreditstatus: ").append(toIndentedString(socreditstatus)).append("\n");
    sb.append("    soCreditused: ").append(toIndentedString(soCreditused)).append("\n");
    sb.append("    soDescription: ").append(toIndentedString(soDescription)).append("\n");
    sb.append("    startholidays: ").append(toIndentedString(startholidays)).append("\n");
    sb.append("    startholidays2: ").append(toIndentedString(startholidays2)).append("\n");
    sb.append("    taxid: ").append(toIndentedString(taxid)).append("\n");
    sb.append("    taxidtype: ").append(toIndentedString(taxidtype)).append("\n");
    sb.append("    totalopenbalance: ").append(toIndentedString(totalopenbalance)).append("\n");
    sb.append("    trxenabled: ").append(toIndentedString(trxenabled)).append("\n");
    sb.append("    updatebalance: ").append(toIndentedString(updatebalance)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
