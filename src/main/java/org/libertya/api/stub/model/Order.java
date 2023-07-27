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
 * Order
 */
@Validated



public class Order   {
  @JsonProperty("acceptance")
  private BigDecimal acceptance = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_org_transfer_id")
  private Integer adOrgTransferId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("ad_user_id")
  private Integer adUserId = null;

  @JsonProperty("allowchangepricelist")
  private Boolean allowchangepricelist = null;

  @JsonProperty("authorizationchainstatus")
  private String authorizationchainstatus = null;

  @JsonProperty("bill_bpartner_id")
  private Integer billBpartnerId = null;

  @JsonProperty("bill_location_id")
  private Integer billLocationId = null;

  @JsonProperty("bill_user_id")
  private Integer billUserId = null;

  @JsonProperty("c_activity_id")
  private Integer cActivityId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_bpartner_location_id")
  private Integer cBpartnerLocationId = null;

  @JsonProperty("c_campaign_id")
  private Integer cCampaignId = null;

  @JsonProperty("c_cashline_id")
  private Integer cCashlineId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_conversiontype_id")
  private Integer cConversiontypeId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("c_doctypetarget_id")
  private Integer cDoctypetargetId = null;

  @JsonProperty("chargeamt")
  private BigDecimal chargeamt = null;

  @JsonProperty("c_invoice_orig_id")
  private Integer cInvoiceOrigId = null;

  @JsonProperty("codigocategoriaiva")
  private Integer codigocategoriaiva = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("c_paymentterm_id")
  private Integer cPaymenttermId = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("creditrequesttype")
  private String creditrequesttype = null;

  @JsonProperty("c_repair_order_id")
  private Integer cRepairOrderId = null;

  @JsonProperty("cuit")
  private String cuit = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("dateordered")
  private String dateordered = null;

  @JsonProperty("dateprinted")
  private String dateprinted = null;

  @JsonProperty("dateprod")
  private String dateprod = null;

  @JsonProperty("datepromised")
  private String datepromised = null;

  @JsonProperty("daterealprod")
  private String daterealprod = null;

  @JsonProperty("deliveryrule")
  private String deliveryrule = null;

  @JsonProperty("deliveryviarule")
  private String deliveryviarule = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("freightamt")
  private BigDecimal freightamt = null;

  @JsonProperty("freightcostrule")
  private String freightcostrule = null;

  @JsonProperty("grandtotal")
  private BigDecimal grandtotal = null;

  @JsonProperty("invoice_adress")
  private String invoiceAdress = null;

  @JsonProperty("invoicerule")
  private String invoicerule = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("iscreditapproved")
  private Boolean iscreditapproved = null;

  @JsonProperty("isdelivered")
  private Boolean isdelivered = null;

  @JsonProperty("isdiscountprinted")
  private Boolean isdiscountprinted = null;

  @JsonProperty("isdropship")
  private Boolean isdropship = null;

  @JsonProperty("isexchange")
  private Boolean isexchange = null;

  @JsonProperty("isinvoiced")
  private Boolean isinvoiced = null;

  @JsonProperty("isprinted")
  private Boolean isprinted = null;

  @JsonProperty("isreactivated")
  private Boolean isreactivated = null;

  @JsonProperty("isselected")
  private Boolean isselected = null;

  @JsonProperty("isselfservice")
  private Boolean isselfservice = null;

  @JsonProperty("issotrx")
  private Boolean issotrx = null;

  @JsonProperty("istaxincluded")
  private Boolean istaxincluded = null;

  @JsonProperty("istpvused")
  private Boolean istpvused = null;

  @JsonProperty("istransferred")
  private Boolean istransferred = null;

  @JsonProperty("manualgeneraldiscount")
  private BigDecimal manualgeneraldiscount = null;

  @JsonProperty("m_authorizationchain_id")
  private Integer mAuthorizationchainId = null;

  @JsonProperty("m_pricelist_id")
  private Integer mPricelistId = null;

  @JsonProperty("m_shipper_id")
  private Integer mShipperId = null;

  @JsonProperty("m_warehouse_id")
  private Integer mWarehouseId = null;

  @JsonProperty("m_warehouse_transfer_id")
  private Integer mWarehouseTransferId = null;

  @JsonProperty("nombrecli")
  private String nombrecli = null;

  @JsonProperty("nroidentificcliente")
  private String nroidentificcliente = null;

  @JsonProperty("oldgrandtotal")
  private BigDecimal oldgrandtotal = null;

  @JsonProperty("pay_bpartner_id")
  private Integer payBpartnerId = null;

  @JsonProperty("pay_location_id")
  private Integer payLocationId = null;

  @JsonProperty("paymentrule")
  private String paymentrule = null;

  @JsonProperty("poreference")
  private String poreference = null;

  @JsonProperty("priorityrule")
  private String priorityrule = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("program_invoice")
  private Integer programInvoice = null;

  @JsonProperty("ref_order_id")
  private Integer refOrderId = null;

  @JsonProperty("repair_priority")
  private String repairPriority = null;

  @JsonProperty("repair_state")
  private String repairState = null;

  @JsonProperty("salesrep_id")
  private Integer salesrepId = null;

  @JsonProperty("sendemail")
  private Boolean sendemail = null;

  @JsonProperty("totallines")
  private BigDecimal totallines = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("user1_id")
  private Integer user1Id = null;

  @JsonProperty("user2_id")
  private Integer user2Id = null;

  @JsonProperty("validto")
  private String validto = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Order acceptance(BigDecimal acceptance) {
    this.acceptance = acceptance;
    return this;
  }

  /**
   * Get acceptance
   * @return acceptance
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getAcceptance() {
    return acceptance;
  }

  public void setAcceptance(BigDecimal acceptance) {
    this.acceptance = acceptance;
  }

  public Order adClientId(Integer adClientId) {
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

  public Order adOrgId(Integer adOrgId) {
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

  public Order adOrgTransferId(Integer adOrgTransferId) {
    this.adOrgTransferId = adOrgTransferId;
    return this;
  }

  /**
   * Get adOrgTransferId
   * @return adOrgTransferId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdOrgTransferId() {
    return adOrgTransferId;
  }

  public void setAdOrgTransferId(Integer adOrgTransferId) {
    this.adOrgTransferId = adOrgTransferId;
  }

  public Order adOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
    return this;
  }

  /**
   * Get adOrgtrxId
   * @return adOrgtrxId
   **/
  @Schema(description = "")
  
    public Integer getAdOrgtrxId() {
    return adOrgtrxId;
  }

  public void setAdOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
  }

  public Order adUserId(Integer adUserId) {
    this.adUserId = adUserId;
    return this;
  }

  /**
   * Get adUserId
   * @return adUserId
   **/
  @Schema(description = "")
  
    public Integer getAdUserId() {
    return adUserId;
  }

  public void setAdUserId(Integer adUserId) {
    this.adUserId = adUserId;
  }

  public Order allowchangepricelist(Boolean allowchangepricelist) {
    this.allowchangepricelist = allowchangepricelist;
    return this;
  }

  /**
   * Get allowchangepricelist
   * @return allowchangepricelist
   **/
  @Schema(description = "")
  
    public Boolean isAllowchangepricelist() {
    return allowchangepricelist;
  }

  public void setAllowchangepricelist(Boolean allowchangepricelist) {
    this.allowchangepricelist = allowchangepricelist;
  }

  public Order authorizationchainstatus(String authorizationchainstatus) {
    this.authorizationchainstatus = authorizationchainstatus;
    return this;
  }

  /**
   * Get authorizationchainstatus
   * @return authorizationchainstatus
   **/
  @Schema(description = "")
  
    public String getAuthorizationchainstatus() {
    return authorizationchainstatus;
  }

  public void setAuthorizationchainstatus(String authorizationchainstatus) {
    this.authorizationchainstatus = authorizationchainstatus;
  }

  public Order billBpartnerId(Integer billBpartnerId) {
    this.billBpartnerId = billBpartnerId;
    return this;
  }

  /**
   * Get billBpartnerId
   * @return billBpartnerId
   **/
  @Schema(description = "")
  
    public Integer getBillBpartnerId() {
    return billBpartnerId;
  }

  public void setBillBpartnerId(Integer billBpartnerId) {
    this.billBpartnerId = billBpartnerId;
  }

  public Order billLocationId(Integer billLocationId) {
    this.billLocationId = billLocationId;
    return this;
  }

  /**
   * Get billLocationId
   * @return billLocationId
   **/
  @Schema(description = "")
  
    public Integer getBillLocationId() {
    return billLocationId;
  }

  public void setBillLocationId(Integer billLocationId) {
    this.billLocationId = billLocationId;
  }

  public Order billUserId(Integer billUserId) {
    this.billUserId = billUserId;
    return this;
  }

  /**
   * Get billUserId
   * @return billUserId
   **/
  @Schema(description = "")
  
    public Integer getBillUserId() {
    return billUserId;
  }

  public void setBillUserId(Integer billUserId) {
    this.billUserId = billUserId;
  }

  public Order cActivityId(Integer cActivityId) {
    this.cActivityId = cActivityId;
    return this;
  }

  /**
   * Get cActivityId
   * @return cActivityId
   **/
  @Schema(description = "")
  
    public Integer getCActivityId() {
    return cActivityId;
  }

  public void setCActivityId(Integer cActivityId) {
    this.cActivityId = cActivityId;
  }

  public Order cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Get cBpartnerId
   * @return cBpartnerId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public Order cBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
    return this;
  }

  /**
   * Get cBpartnerLocationId
   * @return cBpartnerLocationId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCBpartnerLocationId() {
    return cBpartnerLocationId;
  }

  public void setCBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
  }

  public Order cCampaignId(Integer cCampaignId) {
    this.cCampaignId = cCampaignId;
    return this;
  }

  /**
   * Get cCampaignId
   * @return cCampaignId
   **/
  @Schema(description = "")
  
    public Integer getCCampaignId() {
    return cCampaignId;
  }

  public void setCCampaignId(Integer cCampaignId) {
    this.cCampaignId = cCampaignId;
  }

  public Order cCashlineId(Integer cCashlineId) {
    this.cCashlineId = cCashlineId;
    return this;
  }

  /**
   * Get cCashlineId
   * @return cCashlineId
   **/
  @Schema(description = "")
  
    public Integer getCCashlineId() {
    return cCashlineId;
  }

  public void setCCashlineId(Integer cCashlineId) {
    this.cCashlineId = cCashlineId;
  }

  public Order cChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
    return this;
  }

  /**
   * Get cChargeId
   * @return cChargeId
   **/
  @Schema(description = "")
  
    public Integer getCChargeId() {
    return cChargeId;
  }

  public void setCChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
  }

  public Order cConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
    return this;
  }

  /**
   * Get cConversiontypeId
   * @return cConversiontypeId
   **/
  @Schema(description = "")
  
    public Integer getCConversiontypeId() {
    return cConversiontypeId;
  }

  public void setCConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
  }

  public Order cCurrencyId(Integer cCurrencyId) {
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

  public Order cDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
    return this;
  }

  /**
   * Get cDoctypeId
   * @return cDoctypeId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCDoctypeId() {
    return cDoctypeId;
  }

  public void setCDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
  }

  public Order cDoctypetargetId(Integer cDoctypetargetId) {
    this.cDoctypetargetId = cDoctypetargetId;
    return this;
  }

  /**
   * Get cDoctypetargetId
   * @return cDoctypetargetId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCDoctypetargetId() {
    return cDoctypetargetId;
  }

  public void setCDoctypetargetId(Integer cDoctypetargetId) {
    this.cDoctypetargetId = cDoctypetargetId;
  }

  public Order chargeamt(BigDecimal chargeamt) {
    this.chargeamt = chargeamt;
    return this;
  }

  /**
   * Get chargeamt
   * @return chargeamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getChargeamt() {
    return chargeamt;
  }

  public void setChargeamt(BigDecimal chargeamt) {
    this.chargeamt = chargeamt;
  }

  public Order cInvoiceOrigId(Integer cInvoiceOrigId) {
    this.cInvoiceOrigId = cInvoiceOrigId;
    return this;
  }

  /**
   * Get cInvoiceOrigId
   * @return cInvoiceOrigId
   **/
  @Schema(description = "")
  
    public Integer getCInvoiceOrigId() {
    return cInvoiceOrigId;
  }

  public void setCInvoiceOrigId(Integer cInvoiceOrigId) {
    this.cInvoiceOrigId = cInvoiceOrigId;
  }

  public Order codigocategoriaiva(Integer codigocategoriaiva) {
    this.codigocategoriaiva = codigocategoriaiva;
    return this;
  }

  /**
   * Get codigocategoriaiva
   * @return codigocategoriaiva
   **/
  @Schema(description = "")
  
    public Integer getCodigocategoriaiva() {
    return codigocategoriaiva;
  }

  public void setCodigocategoriaiva(Integer codigocategoriaiva) {
    this.codigocategoriaiva = codigocategoriaiva;
  }

  public Order cOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
    return this;
  }

  /**
   * Get cOrderId
   * @return cOrderId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCOrderId() {
    return cOrderId;
  }

  public void setCOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
  }

  public Order cPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
    return this;
  }

  /**
   * Get cPaymentId
   * @return cPaymentId
   **/
  @Schema(description = "")
  
    public Integer getCPaymentId() {
    return cPaymentId;
  }

  public void setCPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
  }

  public Order cPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
    return this;
  }

  /**
   * Get cPaymenttermId
   * @return cPaymenttermId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCPaymenttermId() {
    return cPaymenttermId;
  }

  public void setCPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
  }

  public Order cProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
    return this;
  }

  /**
   * Get cProjectId
   * @return cProjectId
   **/
  @Schema(description = "")
  
    public Integer getCProjectId() {
    return cProjectId;
  }

  public void setCProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
  }

  public Order created(String created) {
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

  public Order createdby(Integer createdby) {
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

  public Order creditrequesttype(String creditrequesttype) {
    this.creditrequesttype = creditrequesttype;
    return this;
  }

  /**
   * Get creditrequesttype
   * @return creditrequesttype
   **/
  @Schema(description = "")
  
    public String getCreditrequesttype() {
    return creditrequesttype;
  }

  public void setCreditrequesttype(String creditrequesttype) {
    this.creditrequesttype = creditrequesttype;
  }

  public Order cRepairOrderId(Integer cRepairOrderId) {
    this.cRepairOrderId = cRepairOrderId;
    return this;
  }

  /**
   * Get cRepairOrderId
   * @return cRepairOrderId
   **/
  @Schema(description = "")
  
    public Integer getCRepairOrderId() {
    return cRepairOrderId;
  }

  public void setCRepairOrderId(Integer cRepairOrderId) {
    this.cRepairOrderId = cRepairOrderId;
  }

  public Order cuit(String cuit) {
    this.cuit = cuit;
    return this;
  }

  /**
   * Get cuit
   * @return cuit
   **/
  @Schema(description = "")
  
    public String getCuit() {
    return cuit;
  }

  public void setCuit(String cuit) {
    this.cuit = cuit;
  }

  public Order dateacct(String dateacct) {
    this.dateacct = dateacct;
    return this;
  }

  /**
   * Get dateacct
   * @return dateacct
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDateacct() {
    return dateacct;
  }

  public void setDateacct(String dateacct) {
    this.dateacct = dateacct;
  }

  public Order dateordered(String dateordered) {
    this.dateordered = dateordered;
    return this;
  }

  /**
   * Get dateordered
   * @return dateordered
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDateordered() {
    return dateordered;
  }

  public void setDateordered(String dateordered) {
    this.dateordered = dateordered;
  }

  public Order dateprinted(String dateprinted) {
    this.dateprinted = dateprinted;
    return this;
  }

  /**
   * Get dateprinted
   * @return dateprinted
   **/
  @Schema(description = "")
  
    public String getDateprinted() {
    return dateprinted;
  }

  public void setDateprinted(String dateprinted) {
    this.dateprinted = dateprinted;
  }

  public Order dateprod(String dateprod) {
    this.dateprod = dateprod;
    return this;
  }

  /**
   * Get dateprod
   * @return dateprod
   **/
  @Schema(description = "")
  
    public String getDateprod() {
    return dateprod;
  }

  public void setDateprod(String dateprod) {
    this.dateprod = dateprod;
  }

  public Order datepromised(String datepromised) {
    this.datepromised = datepromised;
    return this;
  }

  /**
   * Get datepromised
   * @return datepromised
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDatepromised() {
    return datepromised;
  }

  public void setDatepromised(String datepromised) {
    this.datepromised = datepromised;
  }

  public Order daterealprod(String daterealprod) {
    this.daterealprod = daterealprod;
    return this;
  }

  /**
   * Get daterealprod
   * @return daterealprod
   **/
  @Schema(description = "")
  
    public String getDaterealprod() {
    return daterealprod;
  }

  public void setDaterealprod(String daterealprod) {
    this.daterealprod = daterealprod;
  }

  public Order deliveryrule(String deliveryrule) {
    this.deliveryrule = deliveryrule;
    return this;
  }

  /**
   * Get deliveryrule
   * @return deliveryrule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDeliveryrule() {
    return deliveryrule;
  }

  public void setDeliveryrule(String deliveryrule) {
    this.deliveryrule = deliveryrule;
  }

  public Order deliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
    return this;
  }

  /**
   * Get deliveryviarule
   * @return deliveryviarule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDeliveryviarule() {
    return deliveryviarule;
  }

  public void setDeliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
  }

  public Order description(String description) {
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

  public Order docstatus(String docstatus) {
    this.docstatus = docstatus;
    return this;
  }

  /**
   * Get docstatus
   * @return docstatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDocstatus() {
    return docstatus;
  }

  public void setDocstatus(String docstatus) {
    this.docstatus = docstatus;
  }

  public Order documentno(String documentno) {
    this.documentno = documentno;
    return this;
  }

  /**
   * Get documentno
   * @return documentno
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDocumentno() {
    return documentno;
  }

  public void setDocumentno(String documentno) {
    this.documentno = documentno;
  }

  public Order freightamt(BigDecimal freightamt) {
    this.freightamt = freightamt;
    return this;
  }

  /**
   * Get freightamt
   * @return freightamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getFreightamt() {
    return freightamt;
  }

  public void setFreightamt(BigDecimal freightamt) {
    this.freightamt = freightamt;
  }

  public Order freightcostrule(String freightcostrule) {
    this.freightcostrule = freightcostrule;
    return this;
  }

  /**
   * Get freightcostrule
   * @return freightcostrule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getFreightcostrule() {
    return freightcostrule;
  }

  public void setFreightcostrule(String freightcostrule) {
    this.freightcostrule = freightcostrule;
  }

  public Order grandtotal(BigDecimal grandtotal) {
    this.grandtotal = grandtotal;
    return this;
  }

  /**
   * Get grandtotal
   * @return grandtotal
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getGrandtotal() {
    return grandtotal;
  }

  public void setGrandtotal(BigDecimal grandtotal) {
    this.grandtotal = grandtotal;
  }

  public Order invoiceAdress(String invoiceAdress) {
    this.invoiceAdress = invoiceAdress;
    return this;
  }

  /**
   * Get invoiceAdress
   * @return invoiceAdress
   **/
  @Schema(description = "")
  
    public String getInvoiceAdress() {
    return invoiceAdress;
  }

  public void setInvoiceAdress(String invoiceAdress) {
    this.invoiceAdress = invoiceAdress;
  }

  public Order invoicerule(String invoicerule) {
    this.invoicerule = invoicerule;
    return this;
  }

  /**
   * Get invoicerule
   * @return invoicerule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getInvoicerule() {
    return invoicerule;
  }

  public void setInvoicerule(String invoicerule) {
    this.invoicerule = invoicerule;
  }

  public Order isactive(Boolean isactive) {
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

  public Order isapproved(Boolean isapproved) {
    this.isapproved = isapproved;
    return this;
  }

  /**
   * Get isapproved
   * @return isapproved
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsapproved() {
    return isapproved;
  }

  public void setIsapproved(Boolean isapproved) {
    this.isapproved = isapproved;
  }

  public Order iscreditapproved(Boolean iscreditapproved) {
    this.iscreditapproved = iscreditapproved;
    return this;
  }

  /**
   * Get iscreditapproved
   * @return iscreditapproved
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIscreditapproved() {
    return iscreditapproved;
  }

  public void setIscreditapproved(Boolean iscreditapproved) {
    this.iscreditapproved = iscreditapproved;
  }

  public Order isdelivered(Boolean isdelivered) {
    this.isdelivered = isdelivered;
    return this;
  }

  /**
   * Get isdelivered
   * @return isdelivered
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsdelivered() {
    return isdelivered;
  }

  public void setIsdelivered(Boolean isdelivered) {
    this.isdelivered = isdelivered;
  }

  public Order isdiscountprinted(Boolean isdiscountprinted) {
    this.isdiscountprinted = isdiscountprinted;
    return this;
  }

  /**
   * Get isdiscountprinted
   * @return isdiscountprinted
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsdiscountprinted() {
    return isdiscountprinted;
  }

  public void setIsdiscountprinted(Boolean isdiscountprinted) {
    this.isdiscountprinted = isdiscountprinted;
  }

  public Order isdropship(Boolean isdropship) {
    this.isdropship = isdropship;
    return this;
  }

  /**
   * Get isdropship
   * @return isdropship
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsdropship() {
    return isdropship;
  }

  public void setIsdropship(Boolean isdropship) {
    this.isdropship = isdropship;
  }

  public Order isexchange(Boolean isexchange) {
    this.isexchange = isexchange;
    return this;
  }

  /**
   * Get isexchange
   * @return isexchange
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsexchange() {
    return isexchange;
  }

  public void setIsexchange(Boolean isexchange) {
    this.isexchange = isexchange;
  }

  public Order isinvoiced(Boolean isinvoiced) {
    this.isinvoiced = isinvoiced;
    return this;
  }

  /**
   * Get isinvoiced
   * @return isinvoiced
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsinvoiced() {
    return isinvoiced;
  }

  public void setIsinvoiced(Boolean isinvoiced) {
    this.isinvoiced = isinvoiced;
  }

  public Order isprinted(Boolean isprinted) {
    this.isprinted = isprinted;
    return this;
  }

  /**
   * Get isprinted
   * @return isprinted
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsprinted() {
    return isprinted;
  }

  public void setIsprinted(Boolean isprinted) {
    this.isprinted = isprinted;
  }

  public Order isreactivated(Boolean isreactivated) {
    this.isreactivated = isreactivated;
    return this;
  }

  /**
   * Get isreactivated
   * @return isreactivated
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsreactivated() {
    return isreactivated;
  }

  public void setIsreactivated(Boolean isreactivated) {
    this.isreactivated = isreactivated;
  }

  public Order isselected(Boolean isselected) {
    this.isselected = isselected;
    return this;
  }

  /**
   * Get isselected
   * @return isselected
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsselected() {
    return isselected;
  }

  public void setIsselected(Boolean isselected) {
    this.isselected = isselected;
  }

  public Order isselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
    return this;
  }

  /**
   * Get isselfservice
   * @return isselfservice
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsselfservice() {
    return isselfservice;
  }

  public void setIsselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
  }

  public Order issotrx(Boolean issotrx) {
    this.issotrx = issotrx;
    return this;
  }

  /**
   * Get issotrx
   * @return issotrx
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIssotrx() {
    return issotrx;
  }

  public void setIssotrx(Boolean issotrx) {
    this.issotrx = issotrx;
  }

  public Order istaxincluded(Boolean istaxincluded) {
    this.istaxincluded = istaxincluded;
    return this;
  }

  /**
   * Get istaxincluded
   * @return istaxincluded
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIstaxincluded() {
    return istaxincluded;
  }

  public void setIstaxincluded(Boolean istaxincluded) {
    this.istaxincluded = istaxincluded;
  }

  public Order istpvused(Boolean istpvused) {
    this.istpvused = istpvused;
    return this;
  }

  /**
   * Get istpvused
   * @return istpvused
   **/
  @Schema(description = "")
  
    public Boolean isIstpvused() {
    return istpvused;
  }

  public void setIstpvused(Boolean istpvused) {
    this.istpvused = istpvused;
  }

  public Order istransferred(Boolean istransferred) {
    this.istransferred = istransferred;
    return this;
  }

  /**
   * Get istransferred
   * @return istransferred
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIstransferred() {
    return istransferred;
  }

  public void setIstransferred(Boolean istransferred) {
    this.istransferred = istransferred;
  }

  public Order manualgeneraldiscount(BigDecimal manualgeneraldiscount) {
    this.manualgeneraldiscount = manualgeneraldiscount;
    return this;
  }

  /**
   * Get manualgeneraldiscount
   * @return manualgeneraldiscount
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getManualgeneraldiscount() {
    return manualgeneraldiscount;
  }

  public void setManualgeneraldiscount(BigDecimal manualgeneraldiscount) {
    this.manualgeneraldiscount = manualgeneraldiscount;
  }

  public Order mAuthorizationchainId(Integer mAuthorizationchainId) {
    this.mAuthorizationchainId = mAuthorizationchainId;
    return this;
  }

  /**
   * Get mAuthorizationchainId
   * @return mAuthorizationchainId
   **/
  @Schema(description = "")
  
    public Integer getMAuthorizationchainId() {
    return mAuthorizationchainId;
  }

  public void setMAuthorizationchainId(Integer mAuthorizationchainId) {
    this.mAuthorizationchainId = mAuthorizationchainId;
  }

  public Order mPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
    return this;
  }

  /**
   * Get mPricelistId
   * @return mPricelistId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMPricelistId() {
    return mPricelistId;
  }

  public void setMPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
  }

  public Order mShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
    return this;
  }

  /**
   * Get mShipperId
   * @return mShipperId
   **/
  @Schema(description = "")
  
    public Integer getMShipperId() {
    return mShipperId;
  }

  public void setMShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
  }

  public Order mWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
    return this;
  }

  /**
   * Get mWarehouseId
   * @return mWarehouseId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMWarehouseId() {
    return mWarehouseId;
  }

  public void setMWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
  }

  public Order mWarehouseTransferId(Integer mWarehouseTransferId) {
    this.mWarehouseTransferId = mWarehouseTransferId;
    return this;
  }

  /**
   * Get mWarehouseTransferId
   * @return mWarehouseTransferId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMWarehouseTransferId() {
    return mWarehouseTransferId;
  }

  public void setMWarehouseTransferId(Integer mWarehouseTransferId) {
    this.mWarehouseTransferId = mWarehouseTransferId;
  }

  public Order nombrecli(String nombrecli) {
    this.nombrecli = nombrecli;
    return this;
  }

  /**
   * Get nombrecli
   * @return nombrecli
   **/
  @Schema(description = "")
  
    public String getNombrecli() {
    return nombrecli;
  }

  public void setNombrecli(String nombrecli) {
    this.nombrecli = nombrecli;
  }

  public Order nroidentificcliente(String nroidentificcliente) {
    this.nroidentificcliente = nroidentificcliente;
    return this;
  }

  /**
   * Get nroidentificcliente
   * @return nroidentificcliente
   **/
  @Schema(description = "")
  
    public String getNroidentificcliente() {
    return nroidentificcliente;
  }

  public void setNroidentificcliente(String nroidentificcliente) {
    this.nroidentificcliente = nroidentificcliente;
  }

  public Order oldgrandtotal(BigDecimal oldgrandtotal) {
    this.oldgrandtotal = oldgrandtotal;
    return this;
  }

  /**
   * Get oldgrandtotal
   * @return oldgrandtotal
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getOldgrandtotal() {
    return oldgrandtotal;
  }

  public void setOldgrandtotal(BigDecimal oldgrandtotal) {
    this.oldgrandtotal = oldgrandtotal;
  }

  public Order payBpartnerId(Integer payBpartnerId) {
    this.payBpartnerId = payBpartnerId;
    return this;
  }

  /**
   * Get payBpartnerId
   * @return payBpartnerId
   **/
  @Schema(description = "")
  
    public Integer getPayBpartnerId() {
    return payBpartnerId;
  }

  public void setPayBpartnerId(Integer payBpartnerId) {
    this.payBpartnerId = payBpartnerId;
  }

  public Order payLocationId(Integer payLocationId) {
    this.payLocationId = payLocationId;
    return this;
  }

  /**
   * Get payLocationId
   * @return payLocationId
   **/
  @Schema(description = "")
  
    public Integer getPayLocationId() {
    return payLocationId;
  }

  public void setPayLocationId(Integer payLocationId) {
    this.payLocationId = payLocationId;
  }

  public Order paymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
    return this;
  }

  /**
   * Get paymentrule
   * @return paymentrule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPaymentrule() {
    return paymentrule;
  }

  public void setPaymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
  }

  public Order poreference(String poreference) {
    this.poreference = poreference;
    return this;
  }

  /**
   * Get poreference
   * @return poreference
   **/
  @Schema(description = "")
  
    public String getPoreference() {
    return poreference;
  }

  public void setPoreference(String poreference) {
    this.poreference = poreference;
  }

  public Order priorityrule(String priorityrule) {
    this.priorityrule = priorityrule;
    return this;
  }

  /**
   * Get priorityrule
   * @return priorityrule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPriorityrule() {
    return priorityrule;
  }

  public void setPriorityrule(String priorityrule) {
    this.priorityrule = priorityrule;
  }

  public Order processed(Boolean processed) {
    this.processed = processed;
    return this;
  }

  /**
   * Get processed
   * @return processed
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isProcessed() {
    return processed;
  }

  public void setProcessed(Boolean processed) {
    this.processed = processed;
  }

  public Order programInvoice(Integer programInvoice) {
    this.programInvoice = programInvoice;
    return this;
  }

  /**
   * Get programInvoice
   * @return programInvoice
   **/
  @Schema(description = "")
  
    public Integer getProgramInvoice() {
    return programInvoice;
  }

  public void setProgramInvoice(Integer programInvoice) {
    this.programInvoice = programInvoice;
  }

  public Order refOrderId(Integer refOrderId) {
    this.refOrderId = refOrderId;
    return this;
  }

  /**
   * Get refOrderId
   * @return refOrderId
   **/
  @Schema(description = "")
  
    public Integer getRefOrderId() {
    return refOrderId;
  }

  public void setRefOrderId(Integer refOrderId) {
    this.refOrderId = refOrderId;
  }

  public Order repairPriority(String repairPriority) {
    this.repairPriority = repairPriority;
    return this;
  }

  /**
   * Get repairPriority
   * @return repairPriority
   **/
  @Schema(description = "")
  
    public String getRepairPriority() {
    return repairPriority;
  }

  public void setRepairPriority(String repairPriority) {
    this.repairPriority = repairPriority;
  }

  public Order repairState(String repairState) {
    this.repairState = repairState;
    return this;
  }

  /**
   * Get repairState
   * @return repairState
   **/
  @Schema(description = "")
  
    public String getRepairState() {
    return repairState;
  }

  public void setRepairState(String repairState) {
    this.repairState = repairState;
  }

  public Order salesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
    return this;
  }

  /**
   * Get salesrepId
   * @return salesrepId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getSalesrepId() {
    return salesrepId;
  }

  public void setSalesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
  }

  public Order sendemail(Boolean sendemail) {
    this.sendemail = sendemail;
    return this;
  }

  /**
   * Get sendemail
   * @return sendemail
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isSendemail() {
    return sendemail;
  }

  public void setSendemail(Boolean sendemail) {
    this.sendemail = sendemail;
  }

  public Order totallines(BigDecimal totallines) {
    this.totallines = totallines;
    return this;
  }

  /**
   * Get totallines
   * @return totallines
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getTotallines() {
    return totallines;
  }

  public void setTotallines(BigDecimal totallines) {
    this.totallines = totallines;
  }

  public Order updated(String updated) {
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

  public Order updatedby(Integer updatedby) {
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

  public Order user1Id(Integer user1Id) {
    this.user1Id = user1Id;
    return this;
  }

  /**
   * Get user1Id
   * @return user1Id
   **/
  @Schema(description = "")
  
    public Integer getUser1Id() {
    return user1Id;
  }

  public void setUser1Id(Integer user1Id) {
    this.user1Id = user1Id;
  }

  public Order user2Id(Integer user2Id) {
    this.user2Id = user2Id;
    return this;
  }

  /**
   * Get user2Id
   * @return user2Id
   **/
  @Schema(description = "")
  
    public Integer getUser2Id() {
    return user2Id;
  }

  public void setUser2Id(Integer user2Id) {
    this.user2Id = user2Id;
  }

  public Order validto(String validto) {
    this.validto = validto;
    return this;
  }

  /**
   * Get validto
   * @return validto
   **/
  @Schema(description = "")
  
    public String getValidto() {
    return validto;
  }

  public void setValidto(String validto) {
    this.validto = validto;
  }

  public Order referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Order addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Order order = (Order) o;
    return Objects.equals(this.acceptance, order.acceptance) &&
        Objects.equals(this.adClientId, order.adClientId) &&
        Objects.equals(this.adOrgId, order.adOrgId) &&
        Objects.equals(this.adOrgTransferId, order.adOrgTransferId) &&
        Objects.equals(this.adOrgtrxId, order.adOrgtrxId) &&
        Objects.equals(this.adUserId, order.adUserId) &&
        Objects.equals(this.allowchangepricelist, order.allowchangepricelist) &&
        Objects.equals(this.authorizationchainstatus, order.authorizationchainstatus) &&
        Objects.equals(this.billBpartnerId, order.billBpartnerId) &&
        Objects.equals(this.billLocationId, order.billLocationId) &&
        Objects.equals(this.billUserId, order.billUserId) &&
        Objects.equals(this.cActivityId, order.cActivityId) &&
        Objects.equals(this.cBpartnerId, order.cBpartnerId) &&
        Objects.equals(this.cBpartnerLocationId, order.cBpartnerLocationId) &&
        Objects.equals(this.cCampaignId, order.cCampaignId) &&
        Objects.equals(this.cCashlineId, order.cCashlineId) &&
        Objects.equals(this.cChargeId, order.cChargeId) &&
        Objects.equals(this.cConversiontypeId, order.cConversiontypeId) &&
        Objects.equals(this.cCurrencyId, order.cCurrencyId) &&
        Objects.equals(this.cDoctypeId, order.cDoctypeId) &&
        Objects.equals(this.cDoctypetargetId, order.cDoctypetargetId) &&
        Objects.equals(this.chargeamt, order.chargeamt) &&
        Objects.equals(this.cInvoiceOrigId, order.cInvoiceOrigId) &&
        Objects.equals(this.codigocategoriaiva, order.codigocategoriaiva) &&
        Objects.equals(this.cOrderId, order.cOrderId) &&
        Objects.equals(this.cPaymentId, order.cPaymentId) &&
        Objects.equals(this.cPaymenttermId, order.cPaymenttermId) &&
        Objects.equals(this.cProjectId, order.cProjectId) &&
        Objects.equals(this.created, order.created) &&
        Objects.equals(this.createdby, order.createdby) &&
        Objects.equals(this.creditrequesttype, order.creditrequesttype) &&
        Objects.equals(this.cRepairOrderId, order.cRepairOrderId) &&
        Objects.equals(this.cuit, order.cuit) &&
        Objects.equals(this.dateacct, order.dateacct) &&
        Objects.equals(this.dateordered, order.dateordered) &&
        Objects.equals(this.dateprinted, order.dateprinted) &&
        Objects.equals(this.dateprod, order.dateprod) &&
        Objects.equals(this.datepromised, order.datepromised) &&
        Objects.equals(this.daterealprod, order.daterealprod) &&
        Objects.equals(this.deliveryrule, order.deliveryrule) &&
        Objects.equals(this.deliveryviarule, order.deliveryviarule) &&
        Objects.equals(this.description, order.description) &&
        Objects.equals(this.docstatus, order.docstatus) &&
        Objects.equals(this.documentno, order.documentno) &&
        Objects.equals(this.freightamt, order.freightamt) &&
        Objects.equals(this.freightcostrule, order.freightcostrule) &&
        Objects.equals(this.grandtotal, order.grandtotal) &&
        Objects.equals(this.invoiceAdress, order.invoiceAdress) &&
        Objects.equals(this.invoicerule, order.invoicerule) &&
        Objects.equals(this.isactive, order.isactive) &&
        Objects.equals(this.isapproved, order.isapproved) &&
        Objects.equals(this.iscreditapproved, order.iscreditapproved) &&
        Objects.equals(this.isdelivered, order.isdelivered) &&
        Objects.equals(this.isdiscountprinted, order.isdiscountprinted) &&
        Objects.equals(this.isdropship, order.isdropship) &&
        Objects.equals(this.isexchange, order.isexchange) &&
        Objects.equals(this.isinvoiced, order.isinvoiced) &&
        Objects.equals(this.isprinted, order.isprinted) &&
        Objects.equals(this.isreactivated, order.isreactivated) &&
        Objects.equals(this.isselected, order.isselected) &&
        Objects.equals(this.isselfservice, order.isselfservice) &&
        Objects.equals(this.issotrx, order.issotrx) &&
        Objects.equals(this.istaxincluded, order.istaxincluded) &&
        Objects.equals(this.istpvused, order.istpvused) &&
        Objects.equals(this.istransferred, order.istransferred) &&
        Objects.equals(this.manualgeneraldiscount, order.manualgeneraldiscount) &&
        Objects.equals(this.mAuthorizationchainId, order.mAuthorizationchainId) &&
        Objects.equals(this.mPricelistId, order.mPricelistId) &&
        Objects.equals(this.mShipperId, order.mShipperId) &&
        Objects.equals(this.mWarehouseId, order.mWarehouseId) &&
        Objects.equals(this.mWarehouseTransferId, order.mWarehouseTransferId) &&
        Objects.equals(this.nombrecli, order.nombrecli) &&
        Objects.equals(this.nroidentificcliente, order.nroidentificcliente) &&
        Objects.equals(this.oldgrandtotal, order.oldgrandtotal) &&
        Objects.equals(this.payBpartnerId, order.payBpartnerId) &&
        Objects.equals(this.payLocationId, order.payLocationId) &&
        Objects.equals(this.paymentrule, order.paymentrule) &&
        Objects.equals(this.poreference, order.poreference) &&
        Objects.equals(this.priorityrule, order.priorityrule) &&
        Objects.equals(this.processed, order.processed) &&
        Objects.equals(this.programInvoice, order.programInvoice) &&
        Objects.equals(this.refOrderId, order.refOrderId) &&
        Objects.equals(this.repairPriority, order.repairPriority) &&
        Objects.equals(this.repairState, order.repairState) &&
        Objects.equals(this.salesrepId, order.salesrepId) &&
        Objects.equals(this.sendemail, order.sendemail) &&
        Objects.equals(this.totallines, order.totallines) &&
        Objects.equals(this.updated, order.updated) &&
        Objects.equals(this.updatedby, order.updatedby) &&
        Objects.equals(this.user1Id, order.user1Id) &&
        Objects.equals(this.user2Id, order.user2Id) &&
        Objects.equals(this.validto, order.validto) &&
        Objects.equals(this.referencedvalues, order.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptance, adClientId, adOrgId, adOrgTransferId, adOrgtrxId, adUserId, allowchangepricelist, authorizationchainstatus, billBpartnerId, billLocationId, billUserId, cActivityId, cBpartnerId, cBpartnerLocationId, cCampaignId, cCashlineId, cChargeId, cConversiontypeId, cCurrencyId, cDoctypeId, cDoctypetargetId, chargeamt, cInvoiceOrigId, codigocategoriaiva, cOrderId, cPaymentId, cPaymenttermId, cProjectId, created, createdby, creditrequesttype, cRepairOrderId, cuit, dateacct, dateordered, dateprinted, dateprod, datepromised, daterealprod, deliveryrule, deliveryviarule, description, docstatus, documentno, freightamt, freightcostrule, grandtotal, invoiceAdress, invoicerule, isactive, isapproved, iscreditapproved, isdelivered, isdiscountprinted, isdropship, isexchange, isinvoiced, isprinted, isreactivated, isselected, isselfservice, issotrx, istaxincluded, istpvused, istransferred, manualgeneraldiscount, mAuthorizationchainId, mPricelistId, mShipperId, mWarehouseId, mWarehouseTransferId, nombrecli, nroidentificcliente, oldgrandtotal, payBpartnerId, payLocationId, paymentrule, poreference, priorityrule, processed, programInvoice, refOrderId, repairPriority, repairState, salesrepId, sendemail, totallines, updated, updatedby, user1Id, user2Id, validto, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    acceptance: ").append(toIndentedString(acceptance)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgTransferId: ").append(toIndentedString(adOrgTransferId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    adUserId: ").append(toIndentedString(adUserId)).append("\n");
    sb.append("    allowchangepricelist: ").append(toIndentedString(allowchangepricelist)).append("\n");
    sb.append("    authorizationchainstatus: ").append(toIndentedString(authorizationchainstatus)).append("\n");
    sb.append("    billBpartnerId: ").append(toIndentedString(billBpartnerId)).append("\n");
    sb.append("    billLocationId: ").append(toIndentedString(billLocationId)).append("\n");
    sb.append("    billUserId: ").append(toIndentedString(billUserId)).append("\n");
    sb.append("    cActivityId: ").append(toIndentedString(cActivityId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cBpartnerLocationId: ").append(toIndentedString(cBpartnerLocationId)).append("\n");
    sb.append("    cCampaignId: ").append(toIndentedString(cCampaignId)).append("\n");
    sb.append("    cCashlineId: ").append(toIndentedString(cCashlineId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cConversiontypeId: ").append(toIndentedString(cConversiontypeId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    cDoctypetargetId: ").append(toIndentedString(cDoctypetargetId)).append("\n");
    sb.append("    chargeamt: ").append(toIndentedString(chargeamt)).append("\n");
    sb.append("    cInvoiceOrigId: ").append(toIndentedString(cInvoiceOrigId)).append("\n");
    sb.append("    codigocategoriaiva: ").append(toIndentedString(codigocategoriaiva)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    cPaymenttermId: ").append(toIndentedString(cPaymenttermId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditrequesttype: ").append(toIndentedString(creditrequesttype)).append("\n");
    sb.append("    cRepairOrderId: ").append(toIndentedString(cRepairOrderId)).append("\n");
    sb.append("    cuit: ").append(toIndentedString(cuit)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    dateordered: ").append(toIndentedString(dateordered)).append("\n");
    sb.append("    dateprinted: ").append(toIndentedString(dateprinted)).append("\n");
    sb.append("    dateprod: ").append(toIndentedString(dateprod)).append("\n");
    sb.append("    datepromised: ").append(toIndentedString(datepromised)).append("\n");
    sb.append("    daterealprod: ").append(toIndentedString(daterealprod)).append("\n");
    sb.append("    deliveryrule: ").append(toIndentedString(deliveryrule)).append("\n");
    sb.append("    deliveryviarule: ").append(toIndentedString(deliveryviarule)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    freightamt: ").append(toIndentedString(freightamt)).append("\n");
    sb.append("    freightcostrule: ").append(toIndentedString(freightcostrule)).append("\n");
    sb.append("    grandtotal: ").append(toIndentedString(grandtotal)).append("\n");
    sb.append("    invoiceAdress: ").append(toIndentedString(invoiceAdress)).append("\n");
    sb.append("    invoicerule: ").append(toIndentedString(invoicerule)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    iscreditapproved: ").append(toIndentedString(iscreditapproved)).append("\n");
    sb.append("    isdelivered: ").append(toIndentedString(isdelivered)).append("\n");
    sb.append("    isdiscountprinted: ").append(toIndentedString(isdiscountprinted)).append("\n");
    sb.append("    isdropship: ").append(toIndentedString(isdropship)).append("\n");
    sb.append("    isexchange: ").append(toIndentedString(isexchange)).append("\n");
    sb.append("    isinvoiced: ").append(toIndentedString(isinvoiced)).append("\n");
    sb.append("    isprinted: ").append(toIndentedString(isprinted)).append("\n");
    sb.append("    isreactivated: ").append(toIndentedString(isreactivated)).append("\n");
    sb.append("    isselected: ").append(toIndentedString(isselected)).append("\n");
    sb.append("    isselfservice: ").append(toIndentedString(isselfservice)).append("\n");
    sb.append("    issotrx: ").append(toIndentedString(issotrx)).append("\n");
    sb.append("    istaxincluded: ").append(toIndentedString(istaxincluded)).append("\n");
    sb.append("    istpvused: ").append(toIndentedString(istpvused)).append("\n");
    sb.append("    istransferred: ").append(toIndentedString(istransferred)).append("\n");
    sb.append("    manualgeneraldiscount: ").append(toIndentedString(manualgeneraldiscount)).append("\n");
    sb.append("    mAuthorizationchainId: ").append(toIndentedString(mAuthorizationchainId)).append("\n");
    sb.append("    mPricelistId: ").append(toIndentedString(mPricelistId)).append("\n");
    sb.append("    mShipperId: ").append(toIndentedString(mShipperId)).append("\n");
    sb.append("    mWarehouseId: ").append(toIndentedString(mWarehouseId)).append("\n");
    sb.append("    mWarehouseTransferId: ").append(toIndentedString(mWarehouseTransferId)).append("\n");
    sb.append("    nombrecli: ").append(toIndentedString(nombrecli)).append("\n");
    sb.append("    nroidentificcliente: ").append(toIndentedString(nroidentificcliente)).append("\n");
    sb.append("    oldgrandtotal: ").append(toIndentedString(oldgrandtotal)).append("\n");
    sb.append("    payBpartnerId: ").append(toIndentedString(payBpartnerId)).append("\n");
    sb.append("    payLocationId: ").append(toIndentedString(payLocationId)).append("\n");
    sb.append("    paymentrule: ").append(toIndentedString(paymentrule)).append("\n");
    sb.append("    poreference: ").append(toIndentedString(poreference)).append("\n");
    sb.append("    priorityrule: ").append(toIndentedString(priorityrule)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    programInvoice: ").append(toIndentedString(programInvoice)).append("\n");
    sb.append("    refOrderId: ").append(toIndentedString(refOrderId)).append("\n");
    sb.append("    repairPriority: ").append(toIndentedString(repairPriority)).append("\n");
    sb.append("    repairState: ").append(toIndentedString(repairState)).append("\n");
    sb.append("    salesrepId: ").append(toIndentedString(salesrepId)).append("\n");
    sb.append("    sendemail: ").append(toIndentedString(sendemail)).append("\n");
    sb.append("    totallines: ").append(toIndentedString(totallines)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    user1Id: ").append(toIndentedString(user1Id)).append("\n");
    sb.append("    user2Id: ").append(toIndentedString(user2Id)).append("\n");
    sb.append("    validto: ").append(toIndentedString(validto)).append("\n");
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
