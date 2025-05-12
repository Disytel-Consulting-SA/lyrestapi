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

  @JsonProperty("authorize")
  private String authorize = null;

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

  @JsonProperty("copyfrom")
  private String copyfrom = null;

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

  @JsonProperty("createfrom")
  private String createfrom = null;

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

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("docsubtypeinv")
  private String docsubtypeinv = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("fechadetcparaactualizarprecios")
  private String fechadetcparaactualizarprecios = null;

  @JsonProperty("fiscalalreadyprinted")
  private Boolean fiscalalreadyprinted = null;

  @JsonProperty("fiscaldescription")
  private String fiscaldescription = null;

  @JsonProperty("generateto")
  private String generateto = null;

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

  @JsonProperty("lyeicaeainformed")
  private String lyeicaeainformed = null;

  @JsonProperty("lyeicaeainformeddetail")
  private String lyeicaeainformeddetail = null;

  @JsonProperty("lyeimanageelectronicinvoiceprocess")
  private String lyeimanageelectronicinvoiceprocess = null;

  @JsonProperty("managedragorderdiscounts")
  private Boolean managedragorderdiscounts = null;

  @JsonProperty("managedragordersurcharges")
  private Boolean managedragordersurcharges = null;

  @JsonProperty("manageelectronicinvoice")
  private String manageelectronicinvoice = null;

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

  @JsonProperty("posted")
  private String posted = null;

  @JsonProperty("pricelistcurrency")
  private Integer pricelistcurrency = null;

  @JsonProperty("printtype")
  private String printtype = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private String processing = null;

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

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Invoice actualizarpreciosconfacturadecompra(Boolean actualizarpreciosconfacturadecompra) {
    this.actualizarpreciosconfacturadecompra = actualizarpreciosconfacturadecompra;
    return this;
  }

  /**
   *  
   * @return actualizarpreciosconfacturadecompra
   **/
  @Schema(description = " ")
  
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

  public Invoice adOrgId(Integer adOrgId) {
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

  public Invoice adOrgtrxId(Integer adOrgtrxId) {
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

  public Invoice adUserId(Integer adUserId) {
    this.adUserId = adUserId;
    return this;
  }

  /**
   * ID de Usuario dentro del sistema
   * @return adUserId
   **/
  @Schema(description = "ID de Usuario dentro del sistema")
  
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
   *  
   * @return applypercepcion
   **/
  @Schema(required = true, description = " ")
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

  public Invoice authmatch(Boolean authmatch) {
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

  public Invoice authorizationchainstatus(String authorizationchainstatus) {
    this.authorizationchainstatus = authorizationchainstatus;
    return this;
  }

  /**
   *  
   * @return authorizationchainstatus
   **/
  @Schema(description = " ")
  
    public String getAuthorizationchainstatus() {
    return authorizationchainstatus;
  }

  public void setAuthorizationchainstatus(String authorizationchainstatus) {
    this.authorizationchainstatus = authorizationchainstatus;
  }

  public Invoice authorize(String authorize) {
    this.authorize = authorize;
    return this;
  }

  /**
   *  
   * @return authorize
   **/
  @Schema(description = " ")
  
    public String getAuthorize() {
    return authorize;
  }

  public void setAuthorize(String authorize) {
    this.authorize = authorize;
  }

  public Invoice cActivityId(Integer cActivityId) {
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

  public Invoice cae(String cae) {
    this.cae = cae;
    return this;
  }

  /**
   *  
   * @return cae
   **/
  @Schema(description = " ")
  
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
   *  
   * @return caecbte
   **/
  @Schema(description = " ")
  
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
   *  
   * @return caeerror
   **/
  @Schema(description = " ")
  
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
   *  
   * @return cai
   **/
  @Schema(description = " ")
  
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
   *  
   * @return caja
   **/
  @Schema(description = " ")
  
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

  public Invoice cBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
    return this;
  }

  /**
   * Dirección de la Entidad Comercial
   * @return cBpartnerLocationId
   **/
  @Schema(required = true, description = "Dirección de la Entidad Comercial")
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

  public Invoice cCashlineId(Integer cCashlineId) {
    this.cCashlineId = cCashlineId;
    return this;
  }

  /**
   * Línea del Libro de Caja
   * @return cCashlineId
   **/
  @Schema(description = "Línea del Libro de Caja")
  
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

  public Invoice cConversiontypeId(Integer cConversiontypeId) {
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

  public Invoice cCurrencyId(Integer cCurrencyId) {
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

  public Invoice cDoctypeId(Integer cDoctypeId) {
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

  public Invoice cDoctypetargetId(Integer cDoctypetargetId) {
    this.cDoctypetargetId = cDoctypetargetId;
    return this;
  }

  /**
   * Tipo de documento destino para convertir documentos
   * @return cDoctypetargetId
   **/
  @Schema(required = true, description = "Tipo de documento destino para convertir documentos")
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
   * Importe de Cargo
   * @return chargeamt
   **/
  @Schema(description = "Importe de Cargo")
  
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
   * Identificador de la factura
   * @return cInvoiceId
   **/
  @Schema(required = true, description = "Identificador de la factura")
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
   *  
   * @return cInvoiceOrigId
   **/
  @Schema(description = " ")
  
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
   *  
   * @return cLetraComprobanteId
   **/
  @Schema(description = " ")
  
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
   *  
   * @return codigocategoriaiva
   **/
  @Schema(description = " ")
  
    public Integer getCodigocategoriaiva() {
    return codigocategoriaiva;
  }

  public void setCodigocategoriaiva(Integer codigocategoriaiva) {
    this.codigocategoriaiva = codigocategoriaiva;
  }

  public Invoice copyfrom(String copyfrom) {
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

  public Invoice cOrderId(Integer cOrderId) {
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

  public Invoice cOrderOrigId(Integer cOrderOrigId) {
    this.cOrderOrigId = cOrderOrigId;
    return this;
  }

  /**
   *  
   * @return cOrderOrigId
   **/
  @Schema(description = " ")
  
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

  public Invoice cPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
    return this;
  }

  /**
   * Programa de Vctos.
   * @return cPaymenttermId
   **/
  @Schema(required = true, description = "Programa de Vctos.")
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

  public Invoice cPospaymentmediumCreditId(Integer cPospaymentmediumCreditId) {
    this.cPospaymentmediumCreditId = cPospaymentmediumCreditId;
    return this;
  }

  /**
   * Medio de cobro crédito relacionado con este comprobante.
   * @return cPospaymentmediumCreditId
   **/
  @Schema(description = "Medio de cobro crédito relacionado con este comprobante.")
  
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

  public Invoice cProjectId(Integer cProjectId) {
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

  public Invoice createcashline(Boolean createcashline) {
    this.createcashline = createcashline;
    return this;
  }

  /**
   * Crear línea de Ingreso/Egreso de Efectivo en el libro de caja correspondiente
   * @return createcashline
   **/
  @Schema(required = true, description = "Crear línea de Ingreso/Egreso de Efectivo en el libro de caja correspondiente")
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

  public Invoice createdby(Integer createdby) {
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

  public Invoice createfrom(String createfrom) {
    this.createfrom = createfrom;
    return this;
  }

  /**
   * Proceso que generará un nuevo documento
   * @return createfrom
   **/
  @Schema(description = "Proceso que generará un nuevo documento")
  
    public String getCreatefrom() {
    return createfrom;
  }

  public void setCreatefrom(String createfrom) {
    this.createfrom = createfrom;
  }

  public Invoice cRegionDeliveryId(Integer cRegionDeliveryId) {
    this.cRegionDeliveryId = cRegionDeliveryId;
    return this;
  }

  /**
   * Lugar de entrega de la factura. Permite definir el lugar correspondiente de la factura.
   * @return cRegionDeliveryId
   **/
  @Schema(description = "Lugar de entrega de la factura. Permite definir el lugar correspondiente de la factura.")
  
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
   * Identifica una región geográfica
   * @return cRegionId
   **/
  @Schema(description = "Identifica una región geográfica")
  
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
   *  
   * @return cuit
   **/
  @Schema(description = " ")
  
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

  public Invoice datecai(String datecai) {
    this.datecai = datecai;
    return this;
  }

  /**
   *  
   * @return datecai
   **/
  @Schema(description = " ")
  
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
   * Fecha impresa en la factura
   * @return dateinvoiced
   **/
  @Schema(required = true, description = "Fecha impresa en la factura")
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
   * Fecha del Pedido
   * @return dateordered
   **/
  @Schema(description = "Fecha del Pedido")
  
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
   * Fecha en que el documento fue impreso
   * @return dateprinted
   **/
  @Schema(description = "Fecha en que el documento fue impreso")
  
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
   *  
   * @return daterecepted
   **/
  @Schema(description = " ")
  
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

  public Invoice description(String description) {
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

  public Invoice docaction(String docaction) {
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

  public Invoice docstatus(String docstatus) {
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

  public Invoice docsubtypeinv(String docsubtypeinv) {
    this.docsubtypeinv = docsubtypeinv;
    return this;
  }

  /**
   *  
   * @return docsubtypeinv
   **/
  @Schema(description = " ")
  
    public String getDocsubtypeinv() {
    return docsubtypeinv;
  }

  public void setDocsubtypeinv(String docsubtypeinv) {
    this.docsubtypeinv = docsubtypeinv;
  }

  public Invoice documentno(String documentno) {
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

  public Invoice fechadetcparaactualizarprecios(String fechadetcparaactualizarprecios) {
    this.fechadetcparaactualizarprecios = fechadetcparaactualizarprecios;
    return this;
  }

  /**
   *  
   * @return fechadetcparaactualizarprecios
   **/
  @Schema(description = " ")
  
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
   *  
   * @return fiscalalreadyprinted
   **/
  @Schema(required = true, description = " ")
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
   * Descripción que se imprimirá en el ticket fiscal.
   * @return fiscaldescription
   **/
  @Schema(description = "Descripción que se imprimirá en el ticket fiscal.")
  
    public String getFiscaldescription() {
    return fiscaldescription;
  }

  public void setFiscaldescription(String fiscaldescription) {
    this.fiscaldescription = fiscaldescription;
  }

  public Invoice generateto(String generateto) {
    this.generateto = generateto;
    return this;
  }

  /**
   *  
   * @return generateto
   **/
  @Schema(description = " ")
  
    public String getGenerateto() {
    return generateto;
  }

  public void setGenerateto(String generateto) {
    this.generateto = generateto;
  }

  public Invoice grandtotal(BigDecimal grandtotal) {
    this.grandtotal = grandtotal;
    return this;
  }

  /**
   * Importe total del documento
   * @return grandtotal
   **/
  @Schema(required = true, description = "Importe total del documento")
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
   *  
   * @return idcae
   **/
  @Schema(description = " ")
  
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
   *  
   * @return importclearance
   **/
  @Schema(description = " ")
  
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
   * Monto a Crédito inicial de la factura
   * @return initialcurrentaccountamt
   **/
  @Schema(required = true, description = "Monto a Crédito inicial de la factura")
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
   *  
   * @return invoiceAdress
   **/
  @Schema(description = " ")
  
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

  public Invoice isapproved(Boolean isapproved) {
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

  public Invoice iscopy(Boolean iscopy) {
    this.iscopy = iscopy;
    return this;
  }

  /**
   * Este registro es copia de otro registro
   * @return iscopy
   **/
  @Schema(required = true, description = "Este registro es copia de otro registro")
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
   * Imprimir el descuento en la Factura y la Orden
   * @return isdiscountprinted
   **/
  @Schema(required = true, description = "Imprimir el descuento en la Factura y la Orden")
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
   *  
   * @return isexchange
   **/
  @Schema(required = true, description = " ")
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
   * Sin Confirmar
   * @return isindispute
   **/
  @Schema(required = true, description = "Sin Confirmar")
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
   *  
   * @return ispaid
   **/
  @Schema(required = true, description = " ")
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
   * Esquema de Pago Válido
   * @return ispayschedulevalid
   **/
  @Schema(required = true, description = "Esquema de Pago Válido")
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
   * Indica si este documento es impreso
   * @return isprinted
   **/
  @Schema(required = true, description = "Indica si este documento es impreso")
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

  public Invoice issotrx(Boolean issotrx) {
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

  public Invoice istaxincluded(Boolean istaxincluded) {
    this.istaxincluded = istaxincluded;
    return this;
  }

  /**
   * Impuesto incluido en el precio
   * @return istaxincluded
   **/
  @Schema(required = true, description = "Impuesto incluido en el precio")
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
   * Transferido a la Contabilidad General (Contabilizado)
   * @return istransferred
   **/
  @Schema(required = true, description = "Transferido a la Contabilidad General (Contabilizado)")
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
   * Es Anulable en Anulación global de factura
   * @return isvoidable
   **/
  @Schema(required = true, description = "Es Anulable en Anulación global de factura")
      @NotNull

    public Boolean isIsvoidable() {
    return isvoidable;
  }

  public void setIsvoidable(Boolean isvoidable) {
    this.isvoidable = isvoidable;
  }

  public Invoice lyeicaeainformed(String lyeicaeainformed) {
    this.lyeicaeainformed = lyeicaeainformed;
    return this;
  }

  /**
   *  
   * @return lyeicaeainformed
   **/
  @Schema(description = " ")
  
    public String getLyeicaeainformed() {
    return lyeicaeainformed;
  }

  public void setLyeicaeainformed(String lyeicaeainformed) {
    this.lyeicaeainformed = lyeicaeainformed;
  }

  public Invoice lyeicaeainformeddetail(String lyeicaeainformeddetail) {
    this.lyeicaeainformeddetail = lyeicaeainformeddetail;
    return this;
  }

  /**
   *  
   * @return lyeicaeainformeddetail
   **/
  @Schema(description = " ")
  
    public String getLyeicaeainformeddetail() {
    return lyeicaeainformeddetail;
  }

  public void setLyeicaeainformeddetail(String lyeicaeainformeddetail) {
    this.lyeicaeainformeddetail = lyeicaeainformeddetail;
  }

  public Invoice lyeimanageelectronicinvoiceprocess(String lyeimanageelectronicinvoiceprocess) {
    this.lyeimanageelectronicinvoiceprocess = lyeimanageelectronicinvoiceprocess;
    return this;
  }

  /**
   *  
   * @return lyeimanageelectronicinvoiceprocess
   **/
  @Schema(description = " ")
  
    public String getLyeimanageelectronicinvoiceprocess() {
    return lyeimanageelectronicinvoiceprocess;
  }

  public void setLyeimanageelectronicinvoiceprocess(String lyeimanageelectronicinvoiceprocess) {
    this.lyeimanageelectronicinvoiceprocess = lyeimanageelectronicinvoiceprocess;
  }

  public Invoice managedragorderdiscounts(Boolean managedragorderdiscounts) {
    this.managedragorderdiscounts = managedragorderdiscounts;
    return this;
  }

  /**
   * Marca al documento para indicar que debe gestionar los descuentos a nivel de línea o documento arrastrados del pedido
   * @return managedragorderdiscounts
   **/
  @Schema(required = true, description = "Marca al documento para indicar que debe gestionar los descuentos a nivel de línea o documento arrastrados del pedido")
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
   * Marca al documento para indicar que debe gestionar los recargos a nivel de línea o documento arrastrados del pedido
   * @return managedragordersurcharges
   **/
  @Schema(required = true, description = "Marca al documento para indicar que debe gestionar los recargos a nivel de línea o documento arrastrados del pedido")
      @NotNull

    public Boolean isManagedragordersurcharges() {
    return managedragordersurcharges;
  }

  public void setManagedragordersurcharges(Boolean managedragordersurcharges) {
    this.managedragordersurcharges = managedragordersurcharges;
  }

  public Invoice manageelectronicinvoice(String manageelectronicinvoice) {
    this.manageelectronicinvoice = manageelectronicinvoice;
    return this;
  }

  /**
   *  
   * @return manageelectronicinvoice
   **/
  @Schema(description = " ")
  
    public String getManageelectronicinvoice() {
    return manageelectronicinvoice;
  }

  public void setManageelectronicinvoice(String manageelectronicinvoice) {
    this.manageelectronicinvoice = manageelectronicinvoice;
  }

  public Invoice manualdocumentno(Boolean manualdocumentno) {
    this.manualdocumentno = manualdocumentno;
    return this;
  }

  /**
   * Indica si esta factura posee el nro de documento agregado de forma manual
   * @return manualdocumentno
   **/
  @Schema(required = true, description = "Indica si esta factura posee el nro de documento agregado de forma manual")
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
   * Descuento manual general
   * @return manualgeneraldiscount
   **/
  @Schema(required = true, description = "Descuento manual general")
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
   *  
   * @return mAuthorizationchainId
   **/
  @Schema(description = " ")
  
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
   * Asociado a factura de fletes o transporte
   * @return mInouttransportId
   **/
  @Schema(description = "Asociado a factura de fletes o transporte")
  
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
   * Identificador único de mi lista de precios
   * @return mPricelistId
   **/
  @Schema(required = true, description = "Identificador único de mi lista de precios")
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
   * Autorización de Devolución de Material
   * @return mRmaId
   **/
  @Schema(description = "Autorización de Devolución de Material")
  
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
   *  
   * @return netamount
   **/
  @Schema(required = true, description = " ")
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
   *  
   * @return nombrecli
   **/
  @Schema(description = " ")
  
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
   * Crédito sin la posibilidad de utilizarlo como cobro de crédito
   * @return notexchangeablecredit
   **/
  @Schema(required = true, description = "Crédito sin la posibilidad de utilizarlo como cobro de crédito")
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
   * Número de DNI, Cédula, Libreta de Enrolamiento, Pasaporte o Libreta Cívica del cliente.
   * @return nroidentificcliente
   **/
  @Schema(description = "Número de DNI, Cédula, Libreta de Enrolamiento, Pasaporte o Libreta Cívica del cliente.")
  
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
   *  
   * @return numerocomprobante
   **/
  @Schema(description = " ")
  
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
   *  
   * @return numerodedocumento
   **/
  @Schema(description = " ")
  
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
   *  
   * @return oldgrandtotal
   **/
  @Schema(description = " ")
  
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
   *  
   * @return originvfecha
   **/
  @Schema(description = " ")
  
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
   *  
   * @return originvnro
   **/
  @Schema(description = " ")
  
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
   *  
   * @return originvptovta
   **/
  @Schema(description = " ")
  
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
   *  
   * @return originvtipo
   **/
  @Schema(description = " ")
  
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
   * Como se pagará la factura
   * @return paymentrule
   **/
  @Schema(required = true, description = "Como se pagará la factura")
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

  public Invoice posted(String posted) {
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

  public Invoice pricelistcurrency(Integer pricelistcurrency) {
    this.pricelistcurrency = pricelistcurrency;
    return this;
  }

  /**
   *  
   * @return pricelistcurrency
   **/
  @Schema(description = " ")
  
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
   *  
   * @return printtype
   **/
  @Schema(description = " ")
  
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

  public Invoice processing(String processing) {
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

  public Invoice puntodeventa(Integer puntodeventa) {
    this.puntodeventa = puntodeventa;
    return this;
  }

  /**
   *  
   * @return puntodeventa
   **/
  @Schema(description = " ")
  
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
   *  
   * @return refInvoiceId
   **/
  @Schema(description = " ")
  
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

  public Invoice sendemail(Boolean sendemail) {
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

  public Invoice skipipnocaevalidation(Boolean skipipnocaevalidation) {
    this.skipipnocaevalidation = skipipnocaevalidation;
    return this;
  }

  /**
   *  
   * @return skipipnocaevalidation
   **/
  @Schema(description = " ")
  
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
   *  
   * @return tipocomprobante
   **/
  @Schema(description = " ")
  
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
   * Total de todas las líneas del documento
   * @return totallines
   **/
  @Schema(required = true, description = "Total de todas las líneas del documento")
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

  public Invoice updatedby(Integer updatedby) {
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

  public Invoice updateorderqty(Boolean updateorderqty) {
    this.updateorderqty = updateorderqty;
    return this;
  }

  /**
   * Actualiza la cantidad pedida y reservada del pedido relacionado
   * @return updateorderqty
   **/
  @Schema(required = true, description = "Actualiza la cantidad pedida y reservada del pedido relacionado")
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

  public Invoice user2Id(Integer user2Id) {
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

  public Invoice vtocae(String vtocae) {
    this.vtocae = vtocae;
    return this;
  }

  /**
   *  
   * @return vtocae
   **/
  @Schema(description = " ")
  
    public String getVtocae() {
    return vtocae;
  }

  public void setVtocae(String vtocae) {
    this.vtocae = vtocae;
  }

  public Invoice additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Invoice addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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
        Objects.equals(this.authorize, invoice.authorize) &&
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
        Objects.equals(this.copyfrom, invoice.copyfrom) &&
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
        Objects.equals(this.createfrom, invoice.createfrom) &&
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
        Objects.equals(this.docaction, invoice.docaction) &&
        Objects.equals(this.docstatus, invoice.docstatus) &&
        Objects.equals(this.docsubtypeinv, invoice.docsubtypeinv) &&
        Objects.equals(this.documentno, invoice.documentno) &&
        Objects.equals(this.fechadetcparaactualizarprecios, invoice.fechadetcparaactualizarprecios) &&
        Objects.equals(this.fiscalalreadyprinted, invoice.fiscalalreadyprinted) &&
        Objects.equals(this.fiscaldescription, invoice.fiscaldescription) &&
        Objects.equals(this.generateto, invoice.generateto) &&
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
        Objects.equals(this.lyeicaeainformed, invoice.lyeicaeainformed) &&
        Objects.equals(this.lyeicaeainformeddetail, invoice.lyeicaeainformeddetail) &&
        Objects.equals(this.lyeimanageelectronicinvoiceprocess, invoice.lyeimanageelectronicinvoiceprocess) &&
        Objects.equals(this.managedragorderdiscounts, invoice.managedragorderdiscounts) &&
        Objects.equals(this.managedragordersurcharges, invoice.managedragordersurcharges) &&
        Objects.equals(this.manageelectronicinvoice, invoice.manageelectronicinvoice) &&
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
        Objects.equals(this.posted, invoice.posted) &&
        Objects.equals(this.pricelistcurrency, invoice.pricelistcurrency) &&
        Objects.equals(this.printtype, invoice.printtype) &&
        Objects.equals(this.processed, invoice.processed) &&
        Objects.equals(this.processing, invoice.processing) &&
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
        Objects.equals(this.additionalvalues, invoice.additionalvalues) &&
        Objects.equals(this.referencedvalues, invoice.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actualizarpreciosconfacturadecompra, adClientId, adOrgId, adOrgtrxId, adUserId, applypercepcion, authcode, authmatch, authorizationchainstatus, authorize, cActivityId, cae, caecbte, caeerror, cai, caja, cBpartnerId, cBpartnerLocationId, cCampaignId, cCashlineId, cChargeId, cConversiontypeId, cCurrencyId, cDoctypeId, cDoctypetargetId, chargeamt, cInvoiceId, cInvoiceOrigId, cLetraComprobanteId, codigocategoriaiva, copyfrom, cOrderId, cOrderOrigId, cPaymentId, cPaymenttermId, cPosjournalId, cPospaymentmediumCreditId, cPospaymentmediumId, cProjectId, createcashline, created, createdby, createfrom, cRegionDeliveryId, cRegionId, cuit, dateacct, datecai, dateinvoiced, dateordered, dateprinted, daterecepted, deliveryviarule, description, docaction, docstatus, docsubtypeinv, documentno, fechadetcparaactualizarprecios, fiscalalreadyprinted, fiscaldescription, generateto, grandtotal, idcae, importclearance, initialcurrentaccountamt, invoiceAdress, isactive, isapproved, iscopy, isdiscountprinted, isexchange, isindispute, ispaid, ispayschedulevalid, isprinted, isselfservice, issotrx, istaxincluded, istransferred, isvoidable, lyeicaeainformed, lyeicaeainformeddetail, lyeimanageelectronicinvoiceprocess, managedragorderdiscounts, managedragordersurcharges, manageelectronicinvoice, manualdocumentno, manualgeneraldiscount, mAuthorizationchainId, mInouttransportId, mPricelistId, mRmaId, netamount, nombrecli, notexchangeablecredit, nroidentificcliente, numerocomprobante, numerodedocumento, oldgrandtotal, originvfecha, originvnro, originvptovta, originvtipo, paymentrule, poreference, posted, pricelistcurrency, printtype, processed, processing, puntodeventa, refInvoiceId, salesrepId, sendemail, skipipnocaevalidation, tipocomprobante, totallines, updated, updatedby, updateorderqty, user1Id, user2Id, vtocae, additionalvalues, referencedvalues);
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
    sb.append("    authorize: ").append(toIndentedString(authorize)).append("\n");
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
    sb.append("    copyfrom: ").append(toIndentedString(copyfrom)).append("\n");
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
    sb.append("    createfrom: ").append(toIndentedString(createfrom)).append("\n");
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
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    docsubtypeinv: ").append(toIndentedString(docsubtypeinv)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    fechadetcparaactualizarprecios: ").append(toIndentedString(fechadetcparaactualizarprecios)).append("\n");
    sb.append("    fiscalalreadyprinted: ").append(toIndentedString(fiscalalreadyprinted)).append("\n");
    sb.append("    fiscaldescription: ").append(toIndentedString(fiscaldescription)).append("\n");
    sb.append("    generateto: ").append(toIndentedString(generateto)).append("\n");
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
    sb.append("    lyeicaeainformed: ").append(toIndentedString(lyeicaeainformed)).append("\n");
    sb.append("    lyeicaeainformeddetail: ").append(toIndentedString(lyeicaeainformeddetail)).append("\n");
    sb.append("    lyeimanageelectronicinvoiceprocess: ").append(toIndentedString(lyeimanageelectronicinvoiceprocess)).append("\n");
    sb.append("    managedragorderdiscounts: ").append(toIndentedString(managedragorderdiscounts)).append("\n");
    sb.append("    managedragordersurcharges: ").append(toIndentedString(managedragordersurcharges)).append("\n");
    sb.append("    manageelectronicinvoice: ").append(toIndentedString(manageelectronicinvoice)).append("\n");
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
    sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
    sb.append("    pricelistcurrency: ").append(toIndentedString(pricelistcurrency)).append("\n");
    sb.append("    printtype: ").append(toIndentedString(printtype)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
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
