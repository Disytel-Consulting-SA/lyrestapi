package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
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

  @JsonProperty("program_amt")
  private BigDecimal programAmt = null;

  @JsonProperty("program_amt_used")
  private BigDecimal programAmtUsed = null;

  @JsonProperty("program_invoice")
  private Integer programInvoice = null;

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

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("value")
  private String value = null;

  public BPartner acqusitioncost(BigDecimal acqusitioncost) {
    this.acqusitioncost = acqusitioncost;
    return this;
  }

  /**
   * Get acqusitioncost
   * @return acqusitioncost
  **/
  @ApiModelProperty(value = "")
  
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
   * Get actuallifetimevalue
   * @return actuallifetimevalue
  **/
  @ApiModelProperty(value = "")
  
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
   * Get adClientId
   * @return adClientId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get adComponentobjectuid
   * @return adComponentobjectuid
  **/
  @ApiModelProperty(value = "")
  
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
   * Get adLanguage
   * @return adLanguage
  **/
  @ApiModelProperty(value = "")
  
    public Integer getAdLanguage() {
    return adLanguage;
  }

  public void setAdLanguage(Integer adLanguage) {
    this.adLanguage = adLanguage;
  }

  public BPartner adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get allowadvancedpaymentreceipts
   * @return allowadvancedpaymentreceipts
  **/
  @ApiModelProperty(value = "")
  
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
   * Get allowpartialpayment
   * @return allowpartialpayment
  **/
  @ApiModelProperty(value = "")
  
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
   * Get aNameCheck
   * @return aNameCheck
  **/
  @ApiModelProperty(value = "")
  
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
   * Get automaticcreditnotes
   * @return automaticcreditnotes
  **/
  @ApiModelProperty(value = "")
  
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
   * Get batchPaymentRule
   * @return batchPaymentRule
  **/
  @ApiModelProperty(value = "")
  
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
   * Get bpartnerParentId
   * @return bpartnerParentId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get builtcabajurisdiction
   * @return builtcabajurisdiction
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cBankaccountId
   * @return cBankaccountId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cBpartnerId
   * @return cBpartnerId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cBpGroupId
   * @return cBpGroupId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cCategoriaIvaId
   * @return cCategoriaIvaId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cDunningId
   * @return cDunningId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cGreetingId
   * @return cGreetingId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cInvoicescheduleId
   * @return cInvoicescheduleId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cJobcategoryId
   * @return cJobcategoryId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cLocationId
   * @return cLocationId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCLocationId() {
    return cLocationId;
  }

  public void setCLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
  }

  public BPartner cPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
    return this;
  }

  /**
   * Get cPaymenttermId
   * @return cPaymenttermId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cPospaymentmediumId
   * @return cPospaymentmediumId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  
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
   * Get createdby
   * @return createdby
  **/
  @ApiModelProperty(value = "")
  
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
   * Get creditminimumamt
   * @return creditminimumamt
  **/
  @ApiModelProperty(value = "")
  
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
   * Get creditsituation
   * @return creditsituation
  **/
  @ApiModelProperty(value = "")
  
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
   * Get cRegionSedeId
   * @return cRegionSedeId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get customertype
   * @return customertype
  **/
  @ApiModelProperty(value = "")
  
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
   * Get deliveryrule
   * @return deliveryrule
  **/
  @ApiModelProperty(value = "")
  
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
   * Get deliveryviarule
   * @return deliveryviarule
  **/
  @ApiModelProperty(value = "")
  
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
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  
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
   * Get discountcontext
   * @return discountcontext
  **/
  @ApiModelProperty(value = "")
  
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
   * Get documentcopies
   * @return documentcopies
  **/
  @ApiModelProperty(value = "")
  
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
   * Get duns
   * @return duns
  **/
  @ApiModelProperty(value = "")
  
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
   * Get emitirMiPyme
   * @return emitirMiPyme
  **/
  @ApiModelProperty(value = "")
  
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
   * Get endholidays
   * @return endholidays
  **/
  @ApiModelProperty(value = "")
  
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
   * Get endholidays2
   * @return endholidays2
  **/
  @ApiModelProperty(value = "")
  
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
   * Get firstsale
   * @return firstsale
  **/
  @ApiModelProperty(value = "")
  
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
   * Get flatdiscount
   * @return flatdiscount
  **/
  @ApiModelProperty(value = "")
  
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
   * Get freightcostrule
   * @return freightcostrule
  **/
  @ApiModelProperty(value = "")
  
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
   * Get goal
   * @return goal
  **/
  @ApiModelProperty(value = "")
  
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
   * Get iibb
   * @return iibb
  **/
  @ApiModelProperty(value = "")
  
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
   * Get iibbtype
   * @return iibbtype
  **/
  @ApiModelProperty(value = "")
  
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
   * Get invoicePrintformatId
   * @return invoicePrintformatId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get invoicerule
   * @return invoicerule
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isactive
   * @return isactive
  **/
  @ApiModelProperty(value = "")
  
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
   * Get iscompoundtax
   * @return iscompoundtax
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isconveniomultilateral
   * @return isconveniomultilateral
  **/
  @ApiModelProperty(value = "")
  
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
   * Get iscustomer
   * @return iscustomer
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isdiscountprinted
   * @return isdiscountprinted
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isemployee
   * @return isemployee
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isgroupinvoices
   * @return isgroupinvoices
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isiso
   * @return isiso
  **/
  @ApiModelProperty(value = "")
  
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
   * Get ismandatorycai
   * @return ismandatorycai
  **/
  @ApiModelProperty(value = "")
  
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
   * Get ismulticuit
   * @return ismulticuit
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isonetime
   * @return isonetime
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isprospect
   * @return isprospect
  **/
  @ApiModelProperty(value = "")
  
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
   * Get issalesrep
   * @return issalesrep
  **/
  @ApiModelProperty(value = "")
  
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
   * Get issummary
   * @return issummary
  **/
  @ApiModelProperty(value = "")
  
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
   * Get istaxexempt
   * @return istaxexempt
  **/
  @ApiModelProperty(value = "")
  
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
   * Get isvendor
   * @return isvendor
  **/
  @ApiModelProperty(value = "")
  
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
   * Get mDiscountschemaId
   * @return mDiscountschemaId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get minimumpurchasedamt
   * @return minimumpurchasedamt
  **/
  @ApiModelProperty(value = "")
  
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
   * Get minOrderQty
   * @return minOrderQty
  **/
  @ApiModelProperty(value = "")
  
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
   * Get mPricelistId
   * @return mPricelistId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get mProductRelatedId
   * @return mProductRelatedId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get mShipperId
   * @return mShipperId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get naics
   * @return naics
  **/
  @ApiModelProperty(value = "")
  
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
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
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
   * Get name2
   * @return name2
  **/
  @ApiModelProperty(value = "")
  
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
   * Get numberemployees
   * @return numberemployees
  **/
  @ApiModelProperty(value = "")
  
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
   * Get paymentblocked
   * @return paymentblocked
  **/
  @ApiModelProperty(value = "")
  
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
   * Get paymentblockeddescr
   * @return paymentblockeddescr
  **/
  @ApiModelProperty(value = "")
  
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
   * Get paymentrule
   * @return paymentrule
  **/
  @ApiModelProperty(value = "")
  
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
   * Get paymentrulepo
   * @return paymentrulepo
  **/
  @ApiModelProperty(value = "")
  
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
   * Get poDiscountschemaId
   * @return poDiscountschemaId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get poPaymenttermId
   * @return poPaymenttermId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get poPricelistId
   * @return poPricelistId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get poreference
   * @return poreference
  **/
  @ApiModelProperty(value = "")
  
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
   * Get potentiallifetimevalue
   * @return potentiallifetimevalue
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getPotentiallifetimevalue() {
    return potentiallifetimevalue;
  }

  public void setPotentiallifetimevalue(BigDecimal potentiallifetimevalue) {
    this.potentiallifetimevalue = potentiallifetimevalue;
  }

  public BPartner programAmt(BigDecimal programAmt) {
    this.programAmt = programAmt;
    return this;
  }

  /**
   * Get programAmt
   * @return programAmt
  **/
  @ApiModelProperty(value = "")
  
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
   * Get programAmtUsed
   * @return programAmtUsed
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getProgramAmtUsed() {
    return programAmtUsed;
  }

  public void setProgramAmtUsed(BigDecimal programAmtUsed) {
    this.programAmtUsed = programAmtUsed;
  }

  public BPartner programInvoice(Integer programInvoice) {
    this.programInvoice = programInvoice;
    return this;
  }

  /**
   * Get programInvoice
   * @return programInvoice
  **/
  @ApiModelProperty(value = "")
  
    public Integer getProgramInvoice() {
    return programInvoice;
  }

  public void setProgramInvoice(Integer programInvoice) {
    this.programInvoice = programInvoice;
  }

  public BPartner rating(String rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
  **/
  @ApiModelProperty(value = "")
  
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
   * Get referenceno
   * @return referenceno
  **/
  @ApiModelProperty(value = "")
  
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
   * Get salesrepId
   * @return salesrepId
  **/
  @ApiModelProperty(value = "")
  
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
   * Get salesvolume
   * @return salesvolume
  **/
  @ApiModelProperty(value = "")
  
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
   * Get searchunallocatedpayments
   * @return searchunallocatedpayments
  **/
  @ApiModelProperty(value = "")
  
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
   * Get secondarycreditstatus
   * @return secondarycreditstatus
  **/
  @ApiModelProperty(value = "")
  
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
   * Get sendemail
   * @return sendemail
  **/
  @ApiModelProperty(value = "")
  
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
   * Get shareofcustomer
   * @return shareofcustomer
  **/
  @ApiModelProperty(value = "")
  
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
   * Get shelflifeminpct
   * @return shelflifeminpct
  **/
  @ApiModelProperty(value = "")
  
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
   * Get soCreditlimit
   * @return soCreditlimit
  **/
  @ApiModelProperty(value = "")
  
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
   * Get socreditstatus
   * @return socreditstatus
  **/
  @ApiModelProperty(value = "")
  
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
   * Get soCreditused
   * @return soCreditused
  **/
  @ApiModelProperty(value = "")
  
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
   * Get soDescription
   * @return soDescription
  **/
  @ApiModelProperty(value = "")
  
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
   * Get startholidays
   * @return startholidays
  **/
  @ApiModelProperty(value = "")
  
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
   * Get startholidays2
   * @return startholidays2
  **/
  @ApiModelProperty(value = "")
  
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
   * Get taxid
   * @return taxid
  **/
  @ApiModelProperty(value = "")
  
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
   * Get taxidtype
   * @return taxidtype
  **/
  @ApiModelProperty(value = "")
  
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
   * Get totalopenbalance
   * @return totalopenbalance
  **/
  @ApiModelProperty(value = "")
  
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
   * Get trxenabled
   * @return trxenabled
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isTrxenabled() {
    return trxenabled;
  }

  public void setTrxenabled(Boolean trxenabled) {
    this.trxenabled = trxenabled;
  }

  public BPartner updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
  **/
  @ApiModelProperty(value = "")
  
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
   * Get updatedby
   * @return updatedby
  **/
  @ApiModelProperty(value = "")
  
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
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  
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
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
        Objects.equals(this.programAmt, bpartner.programAmt) &&
        Objects.equals(this.programAmtUsed, bpartner.programAmtUsed) &&
        Objects.equals(this.programInvoice, bpartner.programInvoice) &&
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
        Objects.equals(this.updated, bpartner.updated) &&
        Objects.equals(this.updatedby, bpartner.updatedby) &&
        Objects.equals(this.url, bpartner.url) &&
        Objects.equals(this.value, bpartner.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acqusitioncost, actuallifetimevalue, adClientId, adComponentobjectuid, adLanguage, adOrgId, allowadvancedpaymentreceipts, allowpartialpayment, aNameCheck, automaticcreditnotes, batchPaymentRule, bpartnerParentId, builtcabajurisdiction, cBankaccountId, cBpartnerId, cBpGroupId, cCategoriaIvaId, cDunningId, cGreetingId, cInvoicescheduleId, cJobcategoryId, cLocationId, cPaymenttermId, cPospaymentmediumId, created, createdby, creditminimumamt, creditsituation, cRegionSedeId, customertype, deliveryrule, deliveryviarule, description, discountcontext, documentcopies, duns, emitirMiPyme, endholidays, endholidays2, firstsale, flatdiscount, freightcostrule, goal, iibb, iibbtype, invoicePrintformatId, invoicerule, isactive, iscompoundtax, isconveniomultilateral, iscustomer, isdiscountprinted, isemployee, isgroupinvoices, isiso, ismandatorycai, ismulticuit, isonetime, isprospect, issalesrep, issummary, istaxexempt, isvendor, mDiscountschemaId, minimumpurchasedamt, minOrderQty, mPricelistId, mProductRelatedId, mShipperId, naics, name, name2, numberemployees, paymentblocked, paymentblockeddescr, paymentrule, paymentrulepo, poDiscountschemaId, poPaymenttermId, poPricelistId, poreference, potentiallifetimevalue, programAmt, programAmtUsed, programInvoice, rating, referenceno, salesrepId, salesvolume, searchunallocatedpayments, secondarycreditstatus, sendemail, shareofcustomer, shelflifeminpct, soCreditlimit, socreditstatus, soCreditused, soDescription, startholidays, startholidays2, taxid, taxidtype, totalopenbalance, trxenabled, updated, updatedby, url, value);
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
    sb.append("    programAmt: ").append(toIndentedString(programAmt)).append("\n");
    sb.append("    programAmtUsed: ").append(toIndentedString(programAmtUsed)).append("\n");
    sb.append("    programInvoice: ").append(toIndentedString(programInvoice)).append("\n");
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
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
