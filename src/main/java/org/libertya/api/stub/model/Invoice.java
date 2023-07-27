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
 * Invoice
 */
@Validated



public class Invoice   {
  @JsonProperty("actualizarpreciosconfacturadecompra")
  private Boolean actualizarpreciosconfacturadecompra = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("ad_user_id")
  private Integer adUserId = null;

  @JsonProperty("applypercepcion")
  private Boolean applypercepcion = null;

  @JsonProperty("authcode")
  private String authcode = null;

  @JsonProperty("authmatch")
  private Boolean authmatch = null;

  @JsonProperty("authorizationchainstatus")
  private String authorizationchainstatus = null;

  @JsonProperty("c_activity_id")
  private Integer cActivityId = null;

  @JsonProperty("cae")
  private String cae = null;

  @JsonProperty("caecbte")
  private Integer caecbte = null;

  @JsonProperty("caeerror")
  private String caeerror = null;

  @JsonProperty("cai")
  private String cai = null;

  @JsonProperty("caja")
  private String caja = null;

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

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("c_invoice_orig_id")
  private Integer cInvoiceOrigId = null;

  @JsonProperty("c_letra_comprobante_id")
  private Integer cLetraComprobanteId = null;

  @JsonProperty("codigocategoriaiva")
  private Integer codigocategoriaiva = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  @JsonProperty("c_order_orig_id")
  private Integer cOrderOrigId = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("c_paymentterm_id")
  private Integer cPaymenttermId = null;

  @JsonProperty("c_posjournal_id")
  private Integer cPosjournalId = null;

  @JsonProperty("c_pospaymentmedium_credit_id")
  private Integer cPospaymentmediumCreditId = null;

  @JsonProperty("c_pospaymentmedium_id")
  private Integer cPospaymentmediumId = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("createcashline")
  private Boolean createcashline = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_region_delivery_id")
  private Integer cRegionDeliveryId = null;

  @JsonProperty("c_region_id")
  private Integer cRegionId = null;

  @JsonProperty("cuit")
  private String cuit = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("datecai")
  private String datecai = null;

  @JsonProperty("dateinvoiced")
  private String dateinvoiced = null;

  @JsonProperty("dateordered")
  private String dateordered = null;

  @JsonProperty("dateprinted")
  private String dateprinted = null;

  @JsonProperty("daterecepted")
  private String daterecepted = null;

  @JsonProperty("deliveryviarule")
  private String deliveryviarule = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("fechadetcparaactualizarprecios")
  private String fechadetcparaactualizarprecios = null;

  @JsonProperty("fiscalalreadyprinted")
  private Boolean fiscalalreadyprinted = null;

  @JsonProperty("fiscaldescription")
  private String fiscaldescription = null;

  @JsonProperty("grandtotal")
  private BigDecimal grandtotal = null;

  @JsonProperty("idcae")
  private String idcae = null;

  @JsonProperty("importclearance")
  private String importclearance = null;

  @JsonProperty("initialcurrentaccountamt")
  private BigDecimal initialcurrentaccountamt = null;

  @JsonProperty("invoice_adress")
  private String invoiceAdress = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("iscopy")
  private Boolean iscopy = null;

  @JsonProperty("isdiscountprinted")
  private Boolean isdiscountprinted = null;

  @JsonProperty("isexchange")
  private Boolean isexchange = null;

  @JsonProperty("isindispute")
  private Boolean isindispute = null;

  @JsonProperty("ispaid")
  private Boolean ispaid = null;

  @JsonProperty("ispayschedulevalid")
  private Boolean ispayschedulevalid = null;

  @JsonProperty("isprinted")
  private Boolean isprinted = null;

  @JsonProperty("isselfservice")
  private Boolean isselfservice = null;

  @JsonProperty("issotrx")
  private Boolean issotrx = null;

  @JsonProperty("istaxincluded")
  private Boolean istaxincluded = null;

  @JsonProperty("istransferred")
  private Boolean istransferred = null;

  @JsonProperty("isvoidable")
  private Boolean isvoidable = null;

  @JsonProperty("managedragorderdiscounts")
  private Boolean managedragorderdiscounts = null;

  @JsonProperty("managedragordersurcharges")
  private Boolean managedragordersurcharges = null;

  @JsonProperty("manualdocumentno")
  private Boolean manualdocumentno = null;

  @JsonProperty("manualgeneraldiscount")
  private BigDecimal manualgeneraldiscount = null;

  @JsonProperty("m_authorizationchain_id")
  private Integer mAuthorizationchainId = null;

  @JsonProperty("m_inouttransport_id")
  private Integer mInouttransportId = null;

  @JsonProperty("m_pricelist_id")
  private Integer mPricelistId = null;

  @JsonProperty("m_rma_id")
  private Integer mRmaId = null;

  @JsonProperty("netamount")
  private BigDecimal netamount = null;

  @JsonProperty("nombrecli")
  private String nombrecli = null;

  @JsonProperty("notexchangeablecredit")
  private Boolean notexchangeablecredit = null;

  @JsonProperty("nroidentificcliente")
  private String nroidentificcliente = null;

  @JsonProperty("numerocomprobante")
  private Integer numerocomprobante = null;

  @JsonProperty("numerodedocumento")
  private String numerodedocumento = null;

  @JsonProperty("oldgrandtotal")
  private BigDecimal oldgrandtotal = null;

  @JsonProperty("originvfecha")
  private String originvfecha = null;

  @JsonProperty("originvnro")
  private Integer originvnro = null;

  @JsonProperty("originvptovta")
  private Integer originvptovta = null;

  @JsonProperty("originvtipo")
  private String originvtipo = null;

  @JsonProperty("paymentrule")
  private String paymentrule = null;

  @JsonProperty("poreference")
  private String poreference = null;

  @JsonProperty("pricelistcurrency")
  private Integer pricelistcurrency = null;

  @JsonProperty("printtype")
  private String printtype = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("puntodeventa")
  private Integer puntodeventa = null;

  @JsonProperty("ref_invoice_id")
  private Integer refInvoiceId = null;

  @JsonProperty("salesrep_id")
  private Integer salesrepId = null;

  @JsonProperty("sendemail")
  private Boolean sendemail = null;

  @JsonProperty("skipipnocaevalidation")
  private Boolean skipipnocaevalidation = null;

  @JsonProperty("tipocomprobante")
  private String tipocomprobante = null;

  @JsonProperty("totallines")
  private BigDecimal totallines = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("updateorderqty")
  private Boolean updateorderqty = null;

  @JsonProperty("user1_id")
  private Integer user1Id = null;

  @JsonProperty("user2_id")
  private Integer user2Id = null;

  @JsonProperty("vtocae")
  private String vtocae = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Invoice actualizarpreciosconfacturadecompra(Boolean actualizarpreciosconfacturadecompra) {
    this.actualizarpreciosconfacturadecompra = actualizarpreciosconfacturadecompra;
    return this;
  }

  /**
   * Get actualizarpreciosconfacturadecompra
   * @return actualizarpreciosconfacturadecompra
   **/
  @Schema(description = "")
  
    public Boolean isActualizarpreciosconfacturadecompra() {
    return actualizarpreciosconfacturadecompra;
  }

  public void setActualizarpreciosconfacturadecompra(Boolean actualizarpreciosconfacturadecompra) {
    this.actualizarpreciosconfacturadecompra = actualizarpreciosconfacturadecompra;
  }

  public Invoice adClientId(Integer adClientId) {
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

  public Invoice adOrgId(Integer adOrgId) {
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

  public Invoice adOrgtrxId(Integer adOrgtrxId) {
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

  public Invoice adUserId(Integer adUserId) {
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

  public Invoice applypercepcion(Boolean applypercepcion) {
    this.applypercepcion = applypercepcion;
    return this;
  }

  /**
   * Get applypercepcion
   * @return applypercepcion
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isApplypercepcion() {
    return applypercepcion;
  }

  public void setApplypercepcion(Boolean applypercepcion) {
    this.applypercepcion = applypercepcion;
  }

  public Invoice authcode(String authcode) {
    this.authcode = authcode;
    return this;
  }

  /**
   * Get authcode
   * @return authcode
   **/
  @Schema(description = "")
  
    public String getAuthcode() {
    return authcode;
  }

  public void setAuthcode(String authcode) {
    this.authcode = authcode;
  }

  public Invoice authmatch(Boolean authmatch) {
    this.authmatch = authmatch;
    return this;
  }

  /**
   * Get authmatch
   * @return authmatch
   **/
  @Schema(description = "")
  
    public Boolean isAuthmatch() {
    return authmatch;
  }

  public void setAuthmatch(Boolean authmatch) {
    this.authmatch = authmatch;
  }

  public Invoice authorizationchainstatus(String authorizationchainstatus) {
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

  public Invoice cActivityId(Integer cActivityId) {
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

  public Invoice cae(String cae) {
    this.cae = cae;
    return this;
  }

  /**
   * Get cae
   * @return cae
   **/
  @Schema(description = "")
  
    public String getCae() {
    return cae;
  }

  public void setCae(String cae) {
    this.cae = cae;
  }

  public Invoice caecbte(Integer caecbte) {
    this.caecbte = caecbte;
    return this;
  }

  /**
   * Get caecbte
   * @return caecbte
   **/
  @Schema(description = "")
  
    public Integer getCaecbte() {
    return caecbte;
  }

  public void setCaecbte(Integer caecbte) {
    this.caecbte = caecbte;
  }

  public Invoice caeerror(String caeerror) {
    this.caeerror = caeerror;
    return this;
  }

  /**
   * Get caeerror
   * @return caeerror
   **/
  @Schema(description = "")
  
    public String getCaeerror() {
    return caeerror;
  }

  public void setCaeerror(String caeerror) {
    this.caeerror = caeerror;
  }

  public Invoice cai(String cai) {
    this.cai = cai;
    return this;
  }

  /**
   * Get cai
   * @return cai
   **/
  @Schema(description = "")
  
    public String getCai() {
    return cai;
  }

  public void setCai(String cai) {
    this.cai = cai;
  }

  public Invoice caja(String caja) {
    this.caja = caja;
    return this;
  }

  /**
   * Get caja
   * @return caja
   **/
  @Schema(description = "")
  
    public String getCaja() {
    return caja;
  }

  public void setCaja(String caja) {
    this.caja = caja;
  }

  public Invoice cBpartnerId(Integer cBpartnerId) {
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

  public Invoice cBpartnerLocationId(Integer cBpartnerLocationId) {
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

  public Invoice cCampaignId(Integer cCampaignId) {
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

  public Invoice cCashlineId(Integer cCashlineId) {
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

  public Invoice cChargeId(Integer cChargeId) {
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

  public Invoice cConversiontypeId(Integer cConversiontypeId) {
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

  public Invoice cCurrencyId(Integer cCurrencyId) {
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

  public Invoice cDoctypeId(Integer cDoctypeId) {
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

  public Invoice cDoctypetargetId(Integer cDoctypetargetId) {
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

  public Invoice chargeamt(BigDecimal chargeamt) {
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

  public Invoice cInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
    return this;
  }

  /**
   * Get cInvoiceId
   * @return cInvoiceId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCInvoiceId() {
    return cInvoiceId;
  }

  public void setCInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
  }

  public Invoice cInvoiceOrigId(Integer cInvoiceOrigId) {
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

  public Invoice cLetraComprobanteId(Integer cLetraComprobanteId) {
    this.cLetraComprobanteId = cLetraComprobanteId;
    return this;
  }

  /**
   * Get cLetraComprobanteId
   * @return cLetraComprobanteId
   **/
  @Schema(description = "")
  
    public Integer getCLetraComprobanteId() {
    return cLetraComprobanteId;
  }

  public void setCLetraComprobanteId(Integer cLetraComprobanteId) {
    this.cLetraComprobanteId = cLetraComprobanteId;
  }

  public Invoice codigocategoriaiva(Integer codigocategoriaiva) {
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

  public Invoice cOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
    return this;
  }

  /**
   * Get cOrderId
   * @return cOrderId
   **/
  @Schema(description = "")
  
    public Integer getCOrderId() {
    return cOrderId;
  }

  public void setCOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
  }

  public Invoice cOrderOrigId(Integer cOrderOrigId) {
    this.cOrderOrigId = cOrderOrigId;
    return this;
  }

  /**
   * Get cOrderOrigId
   * @return cOrderOrigId
   **/
  @Schema(description = "")
  
    public Integer getCOrderOrigId() {
    return cOrderOrigId;
  }

  public void setCOrderOrigId(Integer cOrderOrigId) {
    this.cOrderOrigId = cOrderOrigId;
  }

  public Invoice cPaymentId(Integer cPaymentId) {
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

  public Invoice cPaymenttermId(Integer cPaymenttermId) {
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

  public Invoice cPosjournalId(Integer cPosjournalId) {
    this.cPosjournalId = cPosjournalId;
    return this;
  }

  /**
   * Get cPosjournalId
   * @return cPosjournalId
   **/
  @Schema(description = "")
  
    public Integer getCPosjournalId() {
    return cPosjournalId;
  }

  public void setCPosjournalId(Integer cPosjournalId) {
    this.cPosjournalId = cPosjournalId;
  }

  public Invoice cPospaymentmediumCreditId(Integer cPospaymentmediumCreditId) {
    this.cPospaymentmediumCreditId = cPospaymentmediumCreditId;
    return this;
  }

  /**
   * Get cPospaymentmediumCreditId
   * @return cPospaymentmediumCreditId
   **/
  @Schema(description = "")
  
    public Integer getCPospaymentmediumCreditId() {
    return cPospaymentmediumCreditId;
  }

  public void setCPospaymentmediumCreditId(Integer cPospaymentmediumCreditId) {
    this.cPospaymentmediumCreditId = cPospaymentmediumCreditId;
  }

  public Invoice cPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
    return this;
  }

  /**
   * Get cPospaymentmediumId
   * @return cPospaymentmediumId
   **/
  @Schema(description = "")
  
    public Integer getCPospaymentmediumId() {
    return cPospaymentmediumId;
  }

  public void setCPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
  }

  public Invoice cProjectId(Integer cProjectId) {
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

  public Invoice createcashline(Boolean createcashline) {
    this.createcashline = createcashline;
    return this;
  }

  /**
   * Get createcashline
   * @return createcashline
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isCreatecashline() {
    return createcashline;
  }

  public void setCreatecashline(Boolean createcashline) {
    this.createcashline = createcashline;
  }

  public Invoice created(String created) {
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

  public Invoice createdby(Integer createdby) {
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

  public Invoice cRegionDeliveryId(Integer cRegionDeliveryId) {
    this.cRegionDeliveryId = cRegionDeliveryId;
    return this;
  }

  /**
   * Get cRegionDeliveryId
   * @return cRegionDeliveryId
   **/
  @Schema(description = "")
  
    public Integer getCRegionDeliveryId() {
    return cRegionDeliveryId;
  }

  public void setCRegionDeliveryId(Integer cRegionDeliveryId) {
    this.cRegionDeliveryId = cRegionDeliveryId;
  }

  public Invoice cRegionId(Integer cRegionId) {
    this.cRegionId = cRegionId;
    return this;
  }

  /**
   * Get cRegionId
   * @return cRegionId
   **/
  @Schema(description = "")
  
    public Integer getCRegionId() {
    return cRegionId;
  }

  public void setCRegionId(Integer cRegionId) {
    this.cRegionId = cRegionId;
  }

  public Invoice cuit(String cuit) {
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

  public Invoice dateacct(String dateacct) {
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

  public Invoice datecai(String datecai) {
    this.datecai = datecai;
    return this;
  }

  /**
   * Get datecai
   * @return datecai
   **/
  @Schema(description = "")
  
    public String getDatecai() {
    return datecai;
  }

  public void setDatecai(String datecai) {
    this.datecai = datecai;
  }

  public Invoice dateinvoiced(String dateinvoiced) {
    this.dateinvoiced = dateinvoiced;
    return this;
  }

  /**
   * Get dateinvoiced
   * @return dateinvoiced
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDateinvoiced() {
    return dateinvoiced;
  }

  public void setDateinvoiced(String dateinvoiced) {
    this.dateinvoiced = dateinvoiced;
  }

  public Invoice dateordered(String dateordered) {
    this.dateordered = dateordered;
    return this;
  }

  /**
   * Get dateordered
   * @return dateordered
   **/
  @Schema(description = "")
  
    public String getDateordered() {
    return dateordered;
  }

  public void setDateordered(String dateordered) {
    this.dateordered = dateordered;
  }

  public Invoice dateprinted(String dateprinted) {
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

  public Invoice daterecepted(String daterecepted) {
    this.daterecepted = daterecepted;
    return this;
  }

  /**
   * Get daterecepted
   * @return daterecepted
   **/
  @Schema(description = "")
  
    public String getDaterecepted() {
    return daterecepted;
  }

  public void setDaterecepted(String daterecepted) {
    this.daterecepted = daterecepted;
  }

  public Invoice deliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
    return this;
  }

  /**
   * Get deliveryviarule
   * @return deliveryviarule
   **/
  @Schema(description = "")
  
    public String getDeliveryviarule() {
    return deliveryviarule;
  }

  public void setDeliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
  }

  public Invoice description(String description) {
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

  public Invoice docstatus(String docstatus) {
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

  public Invoice documentno(String documentno) {
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

  public Invoice fechadetcparaactualizarprecios(String fechadetcparaactualizarprecios) {
    this.fechadetcparaactualizarprecios = fechadetcparaactualizarprecios;
    return this;
  }

  /**
   * Get fechadetcparaactualizarprecios
   * @return fechadetcparaactualizarprecios
   **/
  @Schema(description = "")
  
    public String getFechadetcparaactualizarprecios() {
    return fechadetcparaactualizarprecios;
  }

  public void setFechadetcparaactualizarprecios(String fechadetcparaactualizarprecios) {
    this.fechadetcparaactualizarprecios = fechadetcparaactualizarprecios;
  }

  public Invoice fiscalalreadyprinted(Boolean fiscalalreadyprinted) {
    this.fiscalalreadyprinted = fiscalalreadyprinted;
    return this;
  }

  /**
   * Get fiscalalreadyprinted
   * @return fiscalalreadyprinted
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isFiscalalreadyprinted() {
    return fiscalalreadyprinted;
  }

  public void setFiscalalreadyprinted(Boolean fiscalalreadyprinted) {
    this.fiscalalreadyprinted = fiscalalreadyprinted;
  }

  public Invoice fiscaldescription(String fiscaldescription) {
    this.fiscaldescription = fiscaldescription;
    return this;
  }

  /**
   * Get fiscaldescription
   * @return fiscaldescription
   **/
  @Schema(description = "")
  
    public String getFiscaldescription() {
    return fiscaldescription;
  }

  public void setFiscaldescription(String fiscaldescription) {
    this.fiscaldescription = fiscaldescription;
  }

  public Invoice grandtotal(BigDecimal grandtotal) {
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

  public Invoice idcae(String idcae) {
    this.idcae = idcae;
    return this;
  }

  /**
   * Get idcae
   * @return idcae
   **/
  @Schema(description = "")
  
    public String getIdcae() {
    return idcae;
  }

  public void setIdcae(String idcae) {
    this.idcae = idcae;
  }

  public Invoice importclearance(String importclearance) {
    this.importclearance = importclearance;
    return this;
  }

  /**
   * Get importclearance
   * @return importclearance
   **/
  @Schema(description = "")
  
    public String getImportclearance() {
    return importclearance;
  }

  public void setImportclearance(String importclearance) {
    this.importclearance = importclearance;
  }

  public Invoice initialcurrentaccountamt(BigDecimal initialcurrentaccountamt) {
    this.initialcurrentaccountamt = initialcurrentaccountamt;
    return this;
  }

  /**
   * Get initialcurrentaccountamt
   * @return initialcurrentaccountamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getInitialcurrentaccountamt() {
    return initialcurrentaccountamt;
  }

  public void setInitialcurrentaccountamt(BigDecimal initialcurrentaccountamt) {
    this.initialcurrentaccountamt = initialcurrentaccountamt;
  }

  public Invoice invoiceAdress(String invoiceAdress) {
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

  public Invoice isactive(Boolean isactive) {
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

  public Invoice isapproved(Boolean isapproved) {
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

  public Invoice iscopy(Boolean iscopy) {
    this.iscopy = iscopy;
    return this;
  }

  /**
   * Get iscopy
   * @return iscopy
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIscopy() {
    return iscopy;
  }

  public void setIscopy(Boolean iscopy) {
    this.iscopy = iscopy;
  }

  public Invoice isdiscountprinted(Boolean isdiscountprinted) {
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

  public Invoice isexchange(Boolean isexchange) {
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

  public Invoice isindispute(Boolean isindispute) {
    this.isindispute = isindispute;
    return this;
  }

  /**
   * Get isindispute
   * @return isindispute
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsindispute() {
    return isindispute;
  }

  public void setIsindispute(Boolean isindispute) {
    this.isindispute = isindispute;
  }

  public Invoice ispaid(Boolean ispaid) {
    this.ispaid = ispaid;
    return this;
  }

  /**
   * Get ispaid
   * @return ispaid
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIspaid() {
    return ispaid;
  }

  public void setIspaid(Boolean ispaid) {
    this.ispaid = ispaid;
  }

  public Invoice ispayschedulevalid(Boolean ispayschedulevalid) {
    this.ispayschedulevalid = ispayschedulevalid;
    return this;
  }

  /**
   * Get ispayschedulevalid
   * @return ispayschedulevalid
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIspayschedulevalid() {
    return ispayschedulevalid;
  }

  public void setIspayschedulevalid(Boolean ispayschedulevalid) {
    this.ispayschedulevalid = ispayschedulevalid;
  }

  public Invoice isprinted(Boolean isprinted) {
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

  public Invoice isselfservice(Boolean isselfservice) {
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

  public Invoice issotrx(Boolean issotrx) {
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

  public Invoice istaxincluded(Boolean istaxincluded) {
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

  public Invoice istransferred(Boolean istransferred) {
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

  public Invoice isvoidable(Boolean isvoidable) {
    this.isvoidable = isvoidable;
    return this;
  }

  /**
   * Get isvoidable
   * @return isvoidable
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsvoidable() {
    return isvoidable;
  }

  public void setIsvoidable(Boolean isvoidable) {
    this.isvoidable = isvoidable;
  }

  public Invoice managedragorderdiscounts(Boolean managedragorderdiscounts) {
    this.managedragorderdiscounts = managedragorderdiscounts;
    return this;
  }

  /**
   * Get managedragorderdiscounts
   * @return managedragorderdiscounts
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isManagedragorderdiscounts() {
    return managedragorderdiscounts;
  }

  public void setManagedragorderdiscounts(Boolean managedragorderdiscounts) {
    this.managedragorderdiscounts = managedragorderdiscounts;
  }

  public Invoice managedragordersurcharges(Boolean managedragordersurcharges) {
    this.managedragordersurcharges = managedragordersurcharges;
    return this;
  }

  /**
   * Get managedragordersurcharges
   * @return managedragordersurcharges
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isManagedragordersurcharges() {
    return managedragordersurcharges;
  }

  public void setManagedragordersurcharges(Boolean managedragordersurcharges) {
    this.managedragordersurcharges = managedragordersurcharges;
  }

  public Invoice manualdocumentno(Boolean manualdocumentno) {
    this.manualdocumentno = manualdocumentno;
    return this;
  }

  /**
   * Get manualdocumentno
   * @return manualdocumentno
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isManualdocumentno() {
    return manualdocumentno;
  }

  public void setManualdocumentno(Boolean manualdocumentno) {
    this.manualdocumentno = manualdocumentno;
  }

  public Invoice manualgeneraldiscount(BigDecimal manualgeneraldiscount) {
    this.manualgeneraldiscount = manualgeneraldiscount;
    return this;
  }

  /**
   * Get manualgeneraldiscount
   * @return manualgeneraldiscount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getManualgeneraldiscount() {
    return manualgeneraldiscount;
  }

  public void setManualgeneraldiscount(BigDecimal manualgeneraldiscount) {
    this.manualgeneraldiscount = manualgeneraldiscount;
  }

  public Invoice mAuthorizationchainId(Integer mAuthorizationchainId) {
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

  public Invoice mInouttransportId(Integer mInouttransportId) {
    this.mInouttransportId = mInouttransportId;
    return this;
  }

  /**
   * Get mInouttransportId
   * @return mInouttransportId
   **/
  @Schema(description = "")
  
    public Integer getMInouttransportId() {
    return mInouttransportId;
  }

  public void setMInouttransportId(Integer mInouttransportId) {
    this.mInouttransportId = mInouttransportId;
  }

  public Invoice mPricelistId(Integer mPricelistId) {
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

  public Invoice mRmaId(Integer mRmaId) {
    this.mRmaId = mRmaId;
    return this;
  }

  /**
   * Get mRmaId
   * @return mRmaId
   **/
  @Schema(description = "")
  
    public Integer getMRmaId() {
    return mRmaId;
  }

  public void setMRmaId(Integer mRmaId) {
    this.mRmaId = mRmaId;
  }

  public Invoice netamount(BigDecimal netamount) {
    this.netamount = netamount;
    return this;
  }

  /**
   * Get netamount
   * @return netamount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getNetamount() {
    return netamount;
  }

  public void setNetamount(BigDecimal netamount) {
    this.netamount = netamount;
  }

  public Invoice nombrecli(String nombrecli) {
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

  public Invoice notexchangeablecredit(Boolean notexchangeablecredit) {
    this.notexchangeablecredit = notexchangeablecredit;
    return this;
  }

  /**
   * Get notexchangeablecredit
   * @return notexchangeablecredit
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isNotexchangeablecredit() {
    return notexchangeablecredit;
  }

  public void setNotexchangeablecredit(Boolean notexchangeablecredit) {
    this.notexchangeablecredit = notexchangeablecredit;
  }

  public Invoice nroidentificcliente(String nroidentificcliente) {
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

  public Invoice numerocomprobante(Integer numerocomprobante) {
    this.numerocomprobante = numerocomprobante;
    return this;
  }

  /**
   * Get numerocomprobante
   * @return numerocomprobante
   **/
  @Schema(description = "")
  
    public Integer getNumerocomprobante() {
    return numerocomprobante;
  }

  public void setNumerocomprobante(Integer numerocomprobante) {
    this.numerocomprobante = numerocomprobante;
  }

  public Invoice numerodedocumento(String numerodedocumento) {
    this.numerodedocumento = numerodedocumento;
    return this;
  }

  /**
   * Get numerodedocumento
   * @return numerodedocumento
   **/
  @Schema(description = "")
  
    public String getNumerodedocumento() {
    return numerodedocumento;
  }

  public void setNumerodedocumento(String numerodedocumento) {
    this.numerodedocumento = numerodedocumento;
  }

  public Invoice oldgrandtotal(BigDecimal oldgrandtotal) {
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

  public Invoice originvfecha(String originvfecha) {
    this.originvfecha = originvfecha;
    return this;
  }

  /**
   * Get originvfecha
   * @return originvfecha
   **/
  @Schema(description = "")
  
    public String getOriginvfecha() {
    return originvfecha;
  }

  public void setOriginvfecha(String originvfecha) {
    this.originvfecha = originvfecha;
  }

  public Invoice originvnro(Integer originvnro) {
    this.originvnro = originvnro;
    return this;
  }

  /**
   * Get originvnro
   * @return originvnro
   **/
  @Schema(description = "")
  
    public Integer getOriginvnro() {
    return originvnro;
  }

  public void setOriginvnro(Integer originvnro) {
    this.originvnro = originvnro;
  }

  public Invoice originvptovta(Integer originvptovta) {
    this.originvptovta = originvptovta;
    return this;
  }

  /**
   * Get originvptovta
   * @return originvptovta
   **/
  @Schema(description = "")
  
    public Integer getOriginvptovta() {
    return originvptovta;
  }

  public void setOriginvptovta(Integer originvptovta) {
    this.originvptovta = originvptovta;
  }

  public Invoice originvtipo(String originvtipo) {
    this.originvtipo = originvtipo;
    return this;
  }

  /**
   * Get originvtipo
   * @return originvtipo
   **/
  @Schema(description = "")
  
    public String getOriginvtipo() {
    return originvtipo;
  }

  public void setOriginvtipo(String originvtipo) {
    this.originvtipo = originvtipo;
  }

  public Invoice paymentrule(String paymentrule) {
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

  public Invoice poreference(String poreference) {
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

  public Invoice pricelistcurrency(Integer pricelistcurrency) {
    this.pricelistcurrency = pricelistcurrency;
    return this;
  }

  /**
   * Get pricelistcurrency
   * @return pricelistcurrency
   **/
  @Schema(description = "")
  
    public Integer getPricelistcurrency() {
    return pricelistcurrency;
  }

  public void setPricelistcurrency(Integer pricelistcurrency) {
    this.pricelistcurrency = pricelistcurrency;
  }

  public Invoice printtype(String printtype) {
    this.printtype = printtype;
    return this;
  }

  /**
   * Get printtype
   * @return printtype
   **/
  @Schema(description = "")
  
    public String getPrinttype() {
    return printtype;
  }

  public void setPrinttype(String printtype) {
    this.printtype = printtype;
  }

  public Invoice processed(Boolean processed) {
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

  public Invoice puntodeventa(Integer puntodeventa) {
    this.puntodeventa = puntodeventa;
    return this;
  }

  /**
   * Get puntodeventa
   * @return puntodeventa
   **/
  @Schema(description = "")
  
    public Integer getPuntodeventa() {
    return puntodeventa;
  }

  public void setPuntodeventa(Integer puntodeventa) {
    this.puntodeventa = puntodeventa;
  }

  public Invoice refInvoiceId(Integer refInvoiceId) {
    this.refInvoiceId = refInvoiceId;
    return this;
  }

  /**
   * Get refInvoiceId
   * @return refInvoiceId
   **/
  @Schema(description = "")
  
    public Integer getRefInvoiceId() {
    return refInvoiceId;
  }

  public void setRefInvoiceId(Integer refInvoiceId) {
    this.refInvoiceId = refInvoiceId;
  }

  public Invoice salesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
    return this;
  }

  /**
   * Get salesrepId
   * @return salesrepId
   **/
  @Schema(description = "")
  
    public Integer getSalesrepId() {
    return salesrepId;
  }

  public void setSalesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
  }

  public Invoice sendemail(Boolean sendemail) {
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

  public Invoice skipipnocaevalidation(Boolean skipipnocaevalidation) {
    this.skipipnocaevalidation = skipipnocaevalidation;
    return this;
  }

  /**
   * Get skipipnocaevalidation
   * @return skipipnocaevalidation
   **/
  @Schema(description = "")
  
    public Boolean isSkipipnocaevalidation() {
    return skipipnocaevalidation;
  }

  public void setSkipipnocaevalidation(Boolean skipipnocaevalidation) {
    this.skipipnocaevalidation = skipipnocaevalidation;
  }

  public Invoice tipocomprobante(String tipocomprobante) {
    this.tipocomprobante = tipocomprobante;
    return this;
  }

  /**
   * Get tipocomprobante
   * @return tipocomprobante
   **/
  @Schema(description = "")
  
    public String getTipocomprobante() {
    return tipocomprobante;
  }

  public void setTipocomprobante(String tipocomprobante) {
    this.tipocomprobante = tipocomprobante;
  }

  public Invoice totallines(BigDecimal totallines) {
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

  public Invoice updated(String updated) {
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

  public Invoice updatedby(Integer updatedby) {
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

  public Invoice updateorderqty(Boolean updateorderqty) {
    this.updateorderqty = updateorderqty;
    return this;
  }

  /**
   * Get updateorderqty
   * @return updateorderqty
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isUpdateorderqty() {
    return updateorderqty;
  }

  public void setUpdateorderqty(Boolean updateorderqty) {
    this.updateorderqty = updateorderqty;
  }

  public Invoice user1Id(Integer user1Id) {
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

  public Invoice user2Id(Integer user2Id) {
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

  public Invoice vtocae(String vtocae) {
    this.vtocae = vtocae;
    return this;
  }

  /**
   * Get vtocae
   * @return vtocae
   **/
  @Schema(description = "")
  
    public String getVtocae() {
    return vtocae;
  }

  public void setVtocae(String vtocae) {
    this.vtocae = vtocae;
  }

  public Invoice referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Invoice addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Invoice invoice = (Invoice) o;
    return Objects.equals(this.actualizarpreciosconfacturadecompra, invoice.actualizarpreciosconfacturadecompra) &&
        Objects.equals(this.adClientId, invoice.adClientId) &&
        Objects.equals(this.adOrgId, invoice.adOrgId) &&
        Objects.equals(this.adOrgtrxId, invoice.adOrgtrxId) &&
        Objects.equals(this.adUserId, invoice.adUserId) &&
        Objects.equals(this.applypercepcion, invoice.applypercepcion) &&
        Objects.equals(this.authcode, invoice.authcode) &&
        Objects.equals(this.authmatch, invoice.authmatch) &&
        Objects.equals(this.authorizationchainstatus, invoice.authorizationchainstatus) &&
        Objects.equals(this.cActivityId, invoice.cActivityId) &&
        Objects.equals(this.cae, invoice.cae) &&
        Objects.equals(this.caecbte, invoice.caecbte) &&
        Objects.equals(this.caeerror, invoice.caeerror) &&
        Objects.equals(this.cai, invoice.cai) &&
        Objects.equals(this.caja, invoice.caja) &&
        Objects.equals(this.cBpartnerId, invoice.cBpartnerId) &&
        Objects.equals(this.cBpartnerLocationId, invoice.cBpartnerLocationId) &&
        Objects.equals(this.cCampaignId, invoice.cCampaignId) &&
        Objects.equals(this.cCashlineId, invoice.cCashlineId) &&
        Objects.equals(this.cChargeId, invoice.cChargeId) &&
        Objects.equals(this.cConversiontypeId, invoice.cConversiontypeId) &&
        Objects.equals(this.cCurrencyId, invoice.cCurrencyId) &&
        Objects.equals(this.cDoctypeId, invoice.cDoctypeId) &&
        Objects.equals(this.cDoctypetargetId, invoice.cDoctypetargetId) &&
        Objects.equals(this.chargeamt, invoice.chargeamt) &&
        Objects.equals(this.cInvoiceId, invoice.cInvoiceId) &&
        Objects.equals(this.cInvoiceOrigId, invoice.cInvoiceOrigId) &&
        Objects.equals(this.cLetraComprobanteId, invoice.cLetraComprobanteId) &&
        Objects.equals(this.codigocategoriaiva, invoice.codigocategoriaiva) &&
        Objects.equals(this.cOrderId, invoice.cOrderId) &&
        Objects.equals(this.cOrderOrigId, invoice.cOrderOrigId) &&
        Objects.equals(this.cPaymentId, invoice.cPaymentId) &&
        Objects.equals(this.cPaymenttermId, invoice.cPaymenttermId) &&
        Objects.equals(this.cPosjournalId, invoice.cPosjournalId) &&
        Objects.equals(this.cPospaymentmediumCreditId, invoice.cPospaymentmediumCreditId) &&
        Objects.equals(this.cPospaymentmediumId, invoice.cPospaymentmediumId) &&
        Objects.equals(this.cProjectId, invoice.cProjectId) &&
        Objects.equals(this.createcashline, invoice.createcashline) &&
        Objects.equals(this.created, invoice.created) &&
        Objects.equals(this.createdby, invoice.createdby) &&
        Objects.equals(this.cRegionDeliveryId, invoice.cRegionDeliveryId) &&
        Objects.equals(this.cRegionId, invoice.cRegionId) &&
        Objects.equals(this.cuit, invoice.cuit) &&
        Objects.equals(this.dateacct, invoice.dateacct) &&
        Objects.equals(this.datecai, invoice.datecai) &&
        Objects.equals(this.dateinvoiced, invoice.dateinvoiced) &&
        Objects.equals(this.dateordered, invoice.dateordered) &&
        Objects.equals(this.dateprinted, invoice.dateprinted) &&
        Objects.equals(this.daterecepted, invoice.daterecepted) &&
        Objects.equals(this.deliveryviarule, invoice.deliveryviarule) &&
        Objects.equals(this.description, invoice.description) &&
        Objects.equals(this.docstatus, invoice.docstatus) &&
        Objects.equals(this.documentno, invoice.documentno) &&
        Objects.equals(this.fechadetcparaactualizarprecios, invoice.fechadetcparaactualizarprecios) &&
        Objects.equals(this.fiscalalreadyprinted, invoice.fiscalalreadyprinted) &&
        Objects.equals(this.fiscaldescription, invoice.fiscaldescription) &&
        Objects.equals(this.grandtotal, invoice.grandtotal) &&
        Objects.equals(this.idcae, invoice.idcae) &&
        Objects.equals(this.importclearance, invoice.importclearance) &&
        Objects.equals(this.initialcurrentaccountamt, invoice.initialcurrentaccountamt) &&
        Objects.equals(this.invoiceAdress, invoice.invoiceAdress) &&
        Objects.equals(this.isactive, invoice.isactive) &&
        Objects.equals(this.isapproved, invoice.isapproved) &&
        Objects.equals(this.iscopy, invoice.iscopy) &&
        Objects.equals(this.isdiscountprinted, invoice.isdiscountprinted) &&
        Objects.equals(this.isexchange, invoice.isexchange) &&
        Objects.equals(this.isindispute, invoice.isindispute) &&
        Objects.equals(this.ispaid, invoice.ispaid) &&
        Objects.equals(this.ispayschedulevalid, invoice.ispayschedulevalid) &&
        Objects.equals(this.isprinted, invoice.isprinted) &&
        Objects.equals(this.isselfservice, invoice.isselfservice) &&
        Objects.equals(this.issotrx, invoice.issotrx) &&
        Objects.equals(this.istaxincluded, invoice.istaxincluded) &&
        Objects.equals(this.istransferred, invoice.istransferred) &&
        Objects.equals(this.isvoidable, invoice.isvoidable) &&
        Objects.equals(this.managedragorderdiscounts, invoice.managedragorderdiscounts) &&
        Objects.equals(this.managedragordersurcharges, invoice.managedragordersurcharges) &&
        Objects.equals(this.manualdocumentno, invoice.manualdocumentno) &&
        Objects.equals(this.manualgeneraldiscount, invoice.manualgeneraldiscount) &&
        Objects.equals(this.mAuthorizationchainId, invoice.mAuthorizationchainId) &&
        Objects.equals(this.mInouttransportId, invoice.mInouttransportId) &&
        Objects.equals(this.mPricelistId, invoice.mPricelistId) &&
        Objects.equals(this.mRmaId, invoice.mRmaId) &&
        Objects.equals(this.netamount, invoice.netamount) &&
        Objects.equals(this.nombrecli, invoice.nombrecli) &&
        Objects.equals(this.notexchangeablecredit, invoice.notexchangeablecredit) &&
        Objects.equals(this.nroidentificcliente, invoice.nroidentificcliente) &&
        Objects.equals(this.numerocomprobante, invoice.numerocomprobante) &&
        Objects.equals(this.numerodedocumento, invoice.numerodedocumento) &&
        Objects.equals(this.oldgrandtotal, invoice.oldgrandtotal) &&
        Objects.equals(this.originvfecha, invoice.originvfecha) &&
        Objects.equals(this.originvnro, invoice.originvnro) &&
        Objects.equals(this.originvptovta, invoice.originvptovta) &&
        Objects.equals(this.originvtipo, invoice.originvtipo) &&
        Objects.equals(this.paymentrule, invoice.paymentrule) &&
        Objects.equals(this.poreference, invoice.poreference) &&
        Objects.equals(this.pricelistcurrency, invoice.pricelistcurrency) &&
        Objects.equals(this.printtype, invoice.printtype) &&
        Objects.equals(this.processed, invoice.processed) &&
        Objects.equals(this.puntodeventa, invoice.puntodeventa) &&
        Objects.equals(this.refInvoiceId, invoice.refInvoiceId) &&
        Objects.equals(this.salesrepId, invoice.salesrepId) &&
        Objects.equals(this.sendemail, invoice.sendemail) &&
        Objects.equals(this.skipipnocaevalidation, invoice.skipipnocaevalidation) &&
        Objects.equals(this.tipocomprobante, invoice.tipocomprobante) &&
        Objects.equals(this.totallines, invoice.totallines) &&
        Objects.equals(this.updated, invoice.updated) &&
        Objects.equals(this.updatedby, invoice.updatedby) &&
        Objects.equals(this.updateorderqty, invoice.updateorderqty) &&
        Objects.equals(this.user1Id, invoice.user1Id) &&
        Objects.equals(this.user2Id, invoice.user2Id) &&
        Objects.equals(this.vtocae, invoice.vtocae) &&
        Objects.equals(this.referencedvalues, invoice.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actualizarpreciosconfacturadecompra, adClientId, adOrgId, adOrgtrxId, adUserId, applypercepcion, authcode, authmatch, authorizationchainstatus, cActivityId, cae, caecbte, caeerror, cai, caja, cBpartnerId, cBpartnerLocationId, cCampaignId, cCashlineId, cChargeId, cConversiontypeId, cCurrencyId, cDoctypeId, cDoctypetargetId, chargeamt, cInvoiceId, cInvoiceOrigId, cLetraComprobanteId, codigocategoriaiva, cOrderId, cOrderOrigId, cPaymentId, cPaymenttermId, cPosjournalId, cPospaymentmediumCreditId, cPospaymentmediumId, cProjectId, createcashline, created, createdby, cRegionDeliveryId, cRegionId, cuit, dateacct, datecai, dateinvoiced, dateordered, dateprinted, daterecepted, deliveryviarule, description, docstatus, documentno, fechadetcparaactualizarprecios, fiscalalreadyprinted, fiscaldescription, grandtotal, idcae, importclearance, initialcurrentaccountamt, invoiceAdress, isactive, isapproved, iscopy, isdiscountprinted, isexchange, isindispute, ispaid, ispayschedulevalid, isprinted, isselfservice, issotrx, istaxincluded, istransferred, isvoidable, managedragorderdiscounts, managedragordersurcharges, manualdocumentno, manualgeneraldiscount, mAuthorizationchainId, mInouttransportId, mPricelistId, mRmaId, netamount, nombrecli, notexchangeablecredit, nroidentificcliente, numerocomprobante, numerodedocumento, oldgrandtotal, originvfecha, originvnro, originvptovta, originvtipo, paymentrule, poreference, pricelistcurrency, printtype, processed, puntodeventa, refInvoiceId, salesrepId, sendemail, skipipnocaevalidation, tipocomprobante, totallines, updated, updatedby, updateorderqty, user1Id, user2Id, vtocae, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invoice {\n");
    
    sb.append("    actualizarpreciosconfacturadecompra: ").append(toIndentedString(actualizarpreciosconfacturadecompra)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    adUserId: ").append(toIndentedString(adUserId)).append("\n");
    sb.append("    applypercepcion: ").append(toIndentedString(applypercepcion)).append("\n");
    sb.append("    authcode: ").append(toIndentedString(authcode)).append("\n");
    sb.append("    authmatch: ").append(toIndentedString(authmatch)).append("\n");
    sb.append("    authorizationchainstatus: ").append(toIndentedString(authorizationchainstatus)).append("\n");
    sb.append("    cActivityId: ").append(toIndentedString(cActivityId)).append("\n");
    sb.append("    cae: ").append(toIndentedString(cae)).append("\n");
    sb.append("    caecbte: ").append(toIndentedString(caecbte)).append("\n");
    sb.append("    caeerror: ").append(toIndentedString(caeerror)).append("\n");
    sb.append("    cai: ").append(toIndentedString(cai)).append("\n");
    sb.append("    caja: ").append(toIndentedString(caja)).append("\n");
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
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    cInvoiceOrigId: ").append(toIndentedString(cInvoiceOrigId)).append("\n");
    sb.append("    cLetraComprobanteId: ").append(toIndentedString(cLetraComprobanteId)).append("\n");
    sb.append("    codigocategoriaiva: ").append(toIndentedString(codigocategoriaiva)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("    cOrderOrigId: ").append(toIndentedString(cOrderOrigId)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    cPaymenttermId: ").append(toIndentedString(cPaymenttermId)).append("\n");
    sb.append("    cPosjournalId: ").append(toIndentedString(cPosjournalId)).append("\n");
    sb.append("    cPospaymentmediumCreditId: ").append(toIndentedString(cPospaymentmediumCreditId)).append("\n");
    sb.append("    cPospaymentmediumId: ").append(toIndentedString(cPospaymentmediumId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    createcashline: ").append(toIndentedString(createcashline)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRegionDeliveryId: ").append(toIndentedString(cRegionDeliveryId)).append("\n");
    sb.append("    cRegionId: ").append(toIndentedString(cRegionId)).append("\n");
    sb.append("    cuit: ").append(toIndentedString(cuit)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    datecai: ").append(toIndentedString(datecai)).append("\n");
    sb.append("    dateinvoiced: ").append(toIndentedString(dateinvoiced)).append("\n");
    sb.append("    dateordered: ").append(toIndentedString(dateordered)).append("\n");
    sb.append("    dateprinted: ").append(toIndentedString(dateprinted)).append("\n");
    sb.append("    daterecepted: ").append(toIndentedString(daterecepted)).append("\n");
    sb.append("    deliveryviarule: ").append(toIndentedString(deliveryviarule)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    fechadetcparaactualizarprecios: ").append(toIndentedString(fechadetcparaactualizarprecios)).append("\n");
    sb.append("    fiscalalreadyprinted: ").append(toIndentedString(fiscalalreadyprinted)).append("\n");
    sb.append("    fiscaldescription: ").append(toIndentedString(fiscaldescription)).append("\n");
    sb.append("    grandtotal: ").append(toIndentedString(grandtotal)).append("\n");
    sb.append("    idcae: ").append(toIndentedString(idcae)).append("\n");
    sb.append("    importclearance: ").append(toIndentedString(importclearance)).append("\n");
    sb.append("    initialcurrentaccountamt: ").append(toIndentedString(initialcurrentaccountamt)).append("\n");
    sb.append("    invoiceAdress: ").append(toIndentedString(invoiceAdress)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    iscopy: ").append(toIndentedString(iscopy)).append("\n");
    sb.append("    isdiscountprinted: ").append(toIndentedString(isdiscountprinted)).append("\n");
    sb.append("    isexchange: ").append(toIndentedString(isexchange)).append("\n");
    sb.append("    isindispute: ").append(toIndentedString(isindispute)).append("\n");
    sb.append("    ispaid: ").append(toIndentedString(ispaid)).append("\n");
    sb.append("    ispayschedulevalid: ").append(toIndentedString(ispayschedulevalid)).append("\n");
    sb.append("    isprinted: ").append(toIndentedString(isprinted)).append("\n");
    sb.append("    isselfservice: ").append(toIndentedString(isselfservice)).append("\n");
    sb.append("    issotrx: ").append(toIndentedString(issotrx)).append("\n");
    sb.append("    istaxincluded: ").append(toIndentedString(istaxincluded)).append("\n");
    sb.append("    istransferred: ").append(toIndentedString(istransferred)).append("\n");
    sb.append("    isvoidable: ").append(toIndentedString(isvoidable)).append("\n");
    sb.append("    managedragorderdiscounts: ").append(toIndentedString(managedragorderdiscounts)).append("\n");
    sb.append("    managedragordersurcharges: ").append(toIndentedString(managedragordersurcharges)).append("\n");
    sb.append("    manualdocumentno: ").append(toIndentedString(manualdocumentno)).append("\n");
    sb.append("    manualgeneraldiscount: ").append(toIndentedString(manualgeneraldiscount)).append("\n");
    sb.append("    mAuthorizationchainId: ").append(toIndentedString(mAuthorizationchainId)).append("\n");
    sb.append("    mInouttransportId: ").append(toIndentedString(mInouttransportId)).append("\n");
    sb.append("    mPricelistId: ").append(toIndentedString(mPricelistId)).append("\n");
    sb.append("    mRmaId: ").append(toIndentedString(mRmaId)).append("\n");
    sb.append("    netamount: ").append(toIndentedString(netamount)).append("\n");
    sb.append("    nombrecli: ").append(toIndentedString(nombrecli)).append("\n");
    sb.append("    notexchangeablecredit: ").append(toIndentedString(notexchangeablecredit)).append("\n");
    sb.append("    nroidentificcliente: ").append(toIndentedString(nroidentificcliente)).append("\n");
    sb.append("    numerocomprobante: ").append(toIndentedString(numerocomprobante)).append("\n");
    sb.append("    numerodedocumento: ").append(toIndentedString(numerodedocumento)).append("\n");
    sb.append("    oldgrandtotal: ").append(toIndentedString(oldgrandtotal)).append("\n");
    sb.append("    originvfecha: ").append(toIndentedString(originvfecha)).append("\n");
    sb.append("    originvnro: ").append(toIndentedString(originvnro)).append("\n");
    sb.append("    originvptovta: ").append(toIndentedString(originvptovta)).append("\n");
    sb.append("    originvtipo: ").append(toIndentedString(originvtipo)).append("\n");
    sb.append("    paymentrule: ").append(toIndentedString(paymentrule)).append("\n");
    sb.append("    poreference: ").append(toIndentedString(poreference)).append("\n");
    sb.append("    pricelistcurrency: ").append(toIndentedString(pricelistcurrency)).append("\n");
    sb.append("    printtype: ").append(toIndentedString(printtype)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    puntodeventa: ").append(toIndentedString(puntodeventa)).append("\n");
    sb.append("    refInvoiceId: ").append(toIndentedString(refInvoiceId)).append("\n");
    sb.append("    salesrepId: ").append(toIndentedString(salesrepId)).append("\n");
    sb.append("    sendemail: ").append(toIndentedString(sendemail)).append("\n");
    sb.append("    skipipnocaevalidation: ").append(toIndentedString(skipipnocaevalidation)).append("\n");
    sb.append("    tipocomprobante: ").append(toIndentedString(tipocomprobante)).append("\n");
    sb.append("    totallines: ").append(toIndentedString(totallines)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    updateorderqty: ").append(toIndentedString(updateorderqty)).append("\n");
    sb.append("    user1Id: ").append(toIndentedString(user1Id)).append("\n");
    sb.append("    user2Id: ").append(toIndentedString(user2Id)).append("\n");
    sb.append("    vtocae: ").append(toIndentedString(vtocae)).append("\n");
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
