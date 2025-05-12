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
 * POS
 */
@Validated



public class POS   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_role_id")
  private Integer adRoleId = null;

  @JsonProperty("allowcreditnotesearch")
  private Boolean allowcreditnotesearch = null;

  @JsonProperty("authorizegeneralmanualdiscount")
  private Boolean authorizegeneralmanualdiscount = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bpartnercashtrx_id")
  private Integer cBpartnercashtrxId = null;

  @JsonProperty("c_cashbook_id")
  private Integer cCashbookId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("c_inoutdoctype_id")
  private Integer cInoutdoctypeId = null;

  @JsonProperty("c_invoicedoctype_id")
  private Integer cInvoicedoctypeId = null;

  @JsonProperty("c_orderdoctype_id")
  private Integer cOrderdoctypeId = null;

  @JsonProperty("c_pos_id")
  private Integer cPosId = null;

  @JsonProperty("c_poskeylayout_id")
  private Integer cPoskeylayoutId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("creditcardcashretirement_charge_id")
  private Integer creditcardcashretirementChargeId = null;

  @JsonProperty("creditcardcashretirement_doctype_id")
  private Integer creditcardcashretirementDoctypeId = null;

  @JsonProperty("creditcardcashretirement_product_id")
  private Integer creditcardcashretirementProductId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("draftedinout")
  private Boolean draftedinout = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("initialposauthorization")
  private Boolean initialposauthorization = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isallowcreditcardcashretirement")
  private Boolean isallowcreditcardcashretirement = null;

  @JsonProperty("iscopyentity")
  private Boolean iscopyentity = null;

  @JsonProperty("iscreateinvoice")
  private Boolean iscreateinvoice = null;

  @JsonProperty("isdeliverorderinwarehouse")
  private Boolean isdeliverorderinwarehouse = null;

  @JsonProperty("ismodifyprice")
  private Boolean ismodifyprice = null;

  @JsonProperty("isprintcurrentaccountdocument")
  private Boolean isprintcurrentaccountdocument = null;

  @JsonProperty("isprintwarehousedeliverdocument")
  private Boolean isprintwarehousedeliverdocument = null;

  @JsonProperty("issalewithoutstock")
  private Boolean issalewithoutstock = null;

  @JsonProperty("issearchbyname")
  private Boolean issearchbyname = null;

  @JsonProperty("issearchbynamelike")
  private Boolean issearchbynamelike = null;

  @JsonProperty("issearchbyupc")
  private Boolean issearchbyupc = null;

  @JsonProperty("issearchbyupclike")
  private Boolean issearchbyupclike = null;

  @JsonProperty("issearchbyvalue")
  private Boolean issearchbyvalue = null;

  @JsonProperty("issearchbyvaluelike")
  private Boolean issearchbyvaluelike = null;

  @JsonProperty("issearchtoday")
  private Boolean issearchtoday = null;

  @JsonProperty("lockedclosed")
  private Boolean lockedclosed = null;

  @JsonProperty("maxreturnedcashincn")
  private BigDecimal maxreturnedcashincn = null;

  @JsonProperty("m_pricelist_id")
  private Integer mPricelistId = null;

  @JsonProperty("m_warehouse_id")
  private Integer mWarehouseId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("operationmode")
  private String operationmode = null;

  @JsonProperty("posnet")
  private String posnet = null;

  @JsonProperty("posnumber")
  private Integer posnumber = null;

  @JsonProperty("printername")
  private String printername = null;

  @JsonProperty("returnedcashincncontrol")
  private Boolean returnedcashincncontrol = null;

  @JsonProperty("salesrep_id")
  private Integer salesrepId = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("voiddocuments")
  private Boolean voiddocuments = null;

  @JsonProperty("voiddocuments_ef")
  private Boolean voiddocumentsEf = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public POS adClientId(Integer adClientId) {
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

  public POS adOrgId(Integer adOrgId) {
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

  public POS adRoleId(Integer adRoleId) {
    this.adRoleId = adRoleId;
    return this;
  }

  /**
   * Perfil
   * @return adRoleId
   **/
  @Schema(required = true, description = "Perfil")
      @NotNull

    public Integer getAdRoleId() {
    return adRoleId;
  }

  public void setAdRoleId(Integer adRoleId) {
    this.adRoleId = adRoleId;
  }

  public POS allowcreditnotesearch(Boolean allowcreditnotesearch) {
    this.allowcreditnotesearch = allowcreditnotesearch;
    return this;
  }

  /**
   * Permite realizar búsquedas de Notas de Crédito permitiendo abrir la ventana de Información
   * @return allowcreditnotesearch
   **/
  @Schema(required = true, description = "Permite realizar búsquedas de Notas de Crédito permitiendo abrir la ventana de Información")
      @NotNull

    public Boolean isAllowcreditnotesearch() {
    return allowcreditnotesearch;
  }

  public void setAllowcreditnotesearch(Boolean allowcreditnotesearch) {
    this.allowcreditnotesearch = allowcreditnotesearch;
  }

  public POS authorizegeneralmanualdiscount(Boolean authorizegeneralmanualdiscount) {
    this.authorizegeneralmanualdiscount = authorizegeneralmanualdiscount;
    return this;
  }

  /**
   * Autorizar Descuento/Recargo General Manual
   * @return authorizegeneralmanualdiscount
   **/
  @Schema(required = true, description = "Autorizar Descuento/Recargo General Manual")
      @NotNull

    public Boolean isAuthorizegeneralmanualdiscount() {
    return authorizegeneralmanualdiscount;
  }

  public void setAuthorizegeneralmanualdiscount(Boolean authorizegeneralmanualdiscount) {
    this.authorizegeneralmanualdiscount = authorizegeneralmanualdiscount;
  }

  public POS cBankaccountId(Integer cBankaccountId) {
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

  public POS cBpartnercashtrxId(Integer cBpartnercashtrxId) {
    this.cBpartnercashtrxId = cBpartnercashtrxId;
    return this;
  }

  /**
   * Socio Comercial usado para crear nuevos Socios Comercial rápidamente
   * @return cBpartnercashtrxId
   **/
  @Schema(required = true, description = "Socio Comercial usado para crear nuevos Socios Comercial rápidamente")
      @NotNull

    public Integer getCBpartnercashtrxId() {
    return cBpartnercashtrxId;
  }

  public void setCBpartnercashtrxId(Integer cBpartnercashtrxId) {
    this.cBpartnercashtrxId = cBpartnercashtrxId;
  }

  public POS cCashbookId(Integer cCashbookId) {
    this.cCashbookId = cCashbookId;
    return this;
  }

  /**
   * Libro de Efectivo para registrar transacciones de caja chica
   * @return cCashbookId
   **/
  @Schema(required = true, description = "Libro de Efectivo para registrar transacciones de caja chica")
      @NotNull

    public Integer getCCashbookId() {
    return cCashbookId;
  }

  public void setCCashbookId(Integer cCashbookId) {
    this.cCashbookId = cCashbookId;
  }

  public POS cDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
    return this;
  }

  /**
   * Tipo de documento o reglas
   * @return cDoctypeId
   **/
  @Schema(description = "Tipo de documento o reglas")
  
    public Integer getCDoctypeId() {
    return cDoctypeId;
  }

  public void setCDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
  }

  public POS cInoutdoctypeId(Integer cInoutdoctypeId) {
    this.cInoutdoctypeId = cInoutdoctypeId;
    return this;
  }

  /**
   *  
   * @return cInoutdoctypeId
   **/
  @Schema(description = " ")
  
    public Integer getCInoutdoctypeId() {
    return cInoutdoctypeId;
  }

  public void setCInoutdoctypeId(Integer cInoutdoctypeId) {
    this.cInoutdoctypeId = cInoutdoctypeId;
  }

  public POS cInvoicedoctypeId(Integer cInvoicedoctypeId) {
    this.cInvoicedoctypeId = cInvoicedoctypeId;
    return this;
  }

  /**
   *  
   * @return cInvoicedoctypeId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCInvoicedoctypeId() {
    return cInvoicedoctypeId;
  }

  public void setCInvoicedoctypeId(Integer cInvoicedoctypeId) {
    this.cInvoicedoctypeId = cInvoicedoctypeId;
  }

  public POS cOrderdoctypeId(Integer cOrderdoctypeId) {
    this.cOrderdoctypeId = cOrderdoctypeId;
    return this;
  }

  /**
   *  
   * @return cOrderdoctypeId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCOrderdoctypeId() {
    return cOrderdoctypeId;
  }

  public void setCOrderdoctypeId(Integer cOrderdoctypeId) {
    this.cOrderdoctypeId = cOrderdoctypeId;
  }

  public POS cPosId(Integer cPosId) {
    this.cPosId = cPosId;
    return this;
  }

  /**
   * Terminal TPV
   * @return cPosId
   **/
  @Schema(required = true, description = "Terminal TPV")
      @NotNull

    public Integer getCPosId() {
    return cPosId;
  }

  public void setCPosId(Integer cPosId) {
    this.cPosId = cPosId;
  }

  public POS cPoskeylayoutId(Integer cPoskeylayoutId) {
    this.cPoskeylayoutId = cPoskeylayoutId;
    return this;
  }

  /**
   * Config. Teclas Rápidas TPV
   * @return cPoskeylayoutId
   **/
  @Schema(description = "Config. Teclas Rápidas TPV")
  
    public Integer getCPoskeylayoutId() {
    return cPoskeylayoutId;
  }

  public void setCPoskeylayoutId(Integer cPoskeylayoutId) {
    this.cPoskeylayoutId = cPoskeylayoutId;
  }

  public POS created(String created) {
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

  public POS createdby(Integer createdby) {
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

  public POS creditcardcashretirementChargeId(Integer creditcardcashretirementChargeId) {
    this.creditcardcashretirementChargeId = creditcardcashretirementChargeId;
    return this;
  }

  /**
   * Cargo de la línea de caja para el retiro de efectivo de tarjeta de crédito
   * @return creditcardcashretirementChargeId
   **/
  @Schema(description = "Cargo de la línea de caja para el retiro de efectivo de tarjeta de crédito")
  
    public Integer getCreditcardcashretirementChargeId() {
    return creditcardcashretirementChargeId;
  }

  public void setCreditcardcashretirementChargeId(Integer creditcardcashretirementChargeId) {
    this.creditcardcashretirementChargeId = creditcardcashretirementChargeId;
  }

  public POS creditcardcashretirementDoctypeId(Integer creditcardcashretirementDoctypeId) {
    this.creditcardcashretirementDoctypeId = creditcardcashretirementDoctypeId;
    return this;
  }

  /**
   * Tipo de Documento del débito que se genera por el retiro e imputa a la tarjeta de crédito
   * @return creditcardcashretirementDoctypeId
   **/
  @Schema(description = "Tipo de Documento del débito que se genera por el retiro e imputa a la tarjeta de crédito")
  
    public Integer getCreditcardcashretirementDoctypeId() {
    return creditcardcashretirementDoctypeId;
  }

  public void setCreditcardcashretirementDoctypeId(Integer creditcardcashretirementDoctypeId) {
    this.creditcardcashretirementDoctypeId = creditcardcashretirementDoctypeId;
  }

  public POS creditcardcashretirementProductId(Integer creditcardcashretirementProductId) {
    this.creditcardcashretirementProductId = creditcardcashretirementProductId;
    return this;
  }

  /**
   * Artículo para la línea del documento de débito generado por el retiro de efectivo
   * @return creditcardcashretirementProductId
   **/
  @Schema(description = "Artículo para la línea del documento de débito generado por el retiro de efectivo")
  
    public Integer getCreditcardcashretirementProductId() {
    return creditcardcashretirementProductId;
  }

  public void setCreditcardcashretirementProductId(Integer creditcardcashretirementProductId) {
    this.creditcardcashretirementProductId = creditcardcashretirementProductId;
  }

  public POS description(String description) {
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

  public POS draftedinout(Boolean draftedinout) {
    this.draftedinout = draftedinout;
    return this;
  }

  /**
   * El remito generado queda en estado borrador
   * @return draftedinout
   **/
  @Schema(required = true, description = "El remito generado queda en estado borrador")
      @NotNull

    public Boolean isDraftedinout() {
    return draftedinout;
  }

  public void setDraftedinout(Boolean draftedinout) {
    this.draftedinout = draftedinout;
  }

  public POS help(String help) {
    this.help = help;
    return this;
  }

  /**
   * Ayuda; Comentario o Sugerencia
   * @return help
   **/
  @Schema(description = "Ayuda; Comentario o Sugerencia")
  
    public String getHelp() {
    return help;
  }

  public void setHelp(String help) {
    this.help = help;
  }

  public POS initialposauthorization(Boolean initialposauthorization) {
    this.initialposauthorization = initialposauthorization;
    return this;
  }

  /**
   * Supervisión al iniciar la ventana TPV
   * @return initialposauthorization
   **/
  @Schema(required = true, description = "Supervisión al iniciar la ventana TPV")
      @NotNull

    public Boolean isInitialposauthorization() {
    return initialposauthorization;
  }

  public void setInitialposauthorization(Boolean initialposauthorization) {
    this.initialposauthorization = initialposauthorization;
  }

  public POS isactive(Boolean isactive) {
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

  public POS isallowcreditcardcashretirement(Boolean isallowcreditcardcashretirement) {
    this.isallowcreditcardcashretirement = isallowcreditcardcashretirement;
    return this;
  }

  /**
   * El retiro de efectivo de tarjeta de crédito está permitido
   * @return isallowcreditcardcashretirement
   **/
  @Schema(required = true, description = "El retiro de efectivo de tarjeta de crédito está permitido")
      @NotNull

    public Boolean isIsallowcreditcardcashretirement() {
    return isallowcreditcardcashretirement;
  }

  public void setIsallowcreditcardcashretirement(Boolean isallowcreditcardcashretirement) {
    this.isallowcreditcardcashretirement = isallowcreditcardcashretirement;
  }

  public POS iscopyentity(Boolean iscopyentity) {
    this.iscopyentity = iscopyentity;
    return this;
  }

  /**
   *  
   * @return iscopyentity
   **/
  @Schema(description = " ")
  
    public Boolean isIscopyentity() {
    return iscopyentity;
  }

  public void setIscopyentity(Boolean iscopyentity) {
    this.iscopyentity = iscopyentity;
  }

  public POS iscreateinvoice(Boolean iscreateinvoice) {
    this.iscreateinvoice = iscreateinvoice;
    return this;
  }

  /**
   * Inidica si se debe crear o no la factura
   * @return iscreateinvoice
   **/
  @Schema(required = true, description = "Inidica si se debe crear o no la factura")
      @NotNull

    public Boolean isIscreateinvoice() {
    return iscreateinvoice;
  }

  public void setIscreateinvoice(Boolean iscreateinvoice) {
    this.iscreateinvoice = iscreateinvoice;
  }

  public POS isdeliverorderinwarehouse(Boolean isdeliverorderinwarehouse) {
    this.isdeliverorderinwarehouse = isdeliverorderinwarehouse;
    return this;
  }

  /**
   * Los artículos de los pedidos agregados (pre-creados) no se incluyen en el remito que crea el TPV
   * @return isdeliverorderinwarehouse
   **/
  @Schema(required = true, description = "Los artículos de los pedidos agregados (pre-creados) no se incluyen en el remito que crea el TPV")
      @NotNull

    public Boolean isIsdeliverorderinwarehouse() {
    return isdeliverorderinwarehouse;
  }

  public void setIsdeliverorderinwarehouse(Boolean isdeliverorderinwarehouse) {
    this.isdeliverorderinwarehouse = isdeliverorderinwarehouse;
  }

  public POS ismodifyprice(Boolean ismodifyprice) {
    this.ismodifyprice = ismodifyprice;
    return this;
  }

  /**
   * Modificar precio
   * @return ismodifyprice
   **/
  @Schema(required = true, description = "Modificar precio")
      @NotNull

    public Boolean isIsmodifyprice() {
    return ismodifyprice;
  }

  public void setIsmodifyprice(Boolean ismodifyprice) {
    this.ismodifyprice = ismodifyprice;
  }

  public POS isprintcurrentaccountdocument(Boolean isprintcurrentaccountdocument) {
    this.isprintcurrentaccountdocument = isprintcurrentaccountdocument;
    return this;
  }

  /**
   * Imprimir Documento de Cuenta Corriente
   * @return isprintcurrentaccountdocument
   **/
  @Schema(required = true, description = "Imprimir Documento de Cuenta Corriente")
      @NotNull

    public Boolean isIsprintcurrentaccountdocument() {
    return isprintcurrentaccountdocument;
  }

  public void setIsprintcurrentaccountdocument(Boolean isprintcurrentaccountdocument) {
    this.isprintcurrentaccountdocument = isprintcurrentaccountdocument;
  }

  public POS isprintwarehousedeliverdocument(Boolean isprintwarehousedeliverdocument) {
    this.isprintwarehousedeliverdocument = isprintwarehousedeliverdocument;
    return this;
  }

  /**
   * Imprimir un comprobante con el detalle de los artículos que se retiran por Almacén
   * @return isprintwarehousedeliverdocument
   **/
  @Schema(required = true, description = "Imprimir un comprobante con el detalle de los artículos que se retiran por Almacén")
      @NotNull

    public Boolean isIsprintwarehousedeliverdocument() {
    return isprintwarehousedeliverdocument;
  }

  public void setIsprintwarehousedeliverdocument(Boolean isprintwarehousedeliverdocument) {
    this.isprintwarehousedeliverdocument = isprintwarehousedeliverdocument;
  }

  public POS issalewithoutstock(Boolean issalewithoutstock) {
    this.issalewithoutstock = issalewithoutstock;
    return this;
  }

  /**
   * Permite vender artículos sin que se posea stock del mismo
   * @return issalewithoutstock
   **/
  @Schema(required = true, description = "Permite vender artículos sin que se posea stock del mismo")
      @NotNull

    public Boolean isIssalewithoutstock() {
    return issalewithoutstock;
  }

  public void setIssalewithoutstock(Boolean issalewithoutstock) {
    this.issalewithoutstock = issalewithoutstock;
  }

  public POS issearchbyname(Boolean issearchbyname) {
    this.issearchbyname = issearchbyname;
    return this;
  }

  /**
   * Realiza una búsqueda exacta por nombre
   * @return issearchbyname
   **/
  @Schema(required = true, description = "Realiza una búsqueda exacta por nombre")
      @NotNull

    public Boolean isIssearchbyname() {
    return issearchbyname;
  }

  public void setIssearchbyname(Boolean issearchbyname) {
    this.issearchbyname = issearchbyname;
  }

  public POS issearchbynamelike(Boolean issearchbynamelike) {
    this.issearchbynamelike = issearchbynamelike;
    return this;
  }

  /**
   * Realiza una búsqueda parcial por nombre utilizando comodines en el texto ingresado
   * @return issearchbynamelike
   **/
  @Schema(required = true, description = "Realiza una búsqueda parcial por nombre utilizando comodines en el texto ingresado")
      @NotNull

    public Boolean isIssearchbynamelike() {
    return issearchbynamelike;
  }

  public void setIssearchbynamelike(Boolean issearchbynamelike) {
    this.issearchbynamelike = issearchbynamelike;
  }

  public POS issearchbyupc(Boolean issearchbyupc) {
    this.issearchbyupc = issearchbyupc;
    return this;
  }

  /**
   * Realiza una búsqueda exacta por UPC/EAN
   * @return issearchbyupc
   **/
  @Schema(required = true, description = "Realiza una búsqueda exacta por UPC/EAN")
      @NotNull

    public Boolean isIssearchbyupc() {
    return issearchbyupc;
  }

  public void setIssearchbyupc(Boolean issearchbyupc) {
    this.issearchbyupc = issearchbyupc;
  }

  public POS issearchbyupclike(Boolean issearchbyupclike) {
    this.issearchbyupclike = issearchbyupclike;
    return this;
  }

  /**
   * Realiza una búsqueda parcial por UPC/EAN utilizando comodines en el texto ingresado
   * @return issearchbyupclike
   **/
  @Schema(required = true, description = "Realiza una búsqueda parcial por UPC/EAN utilizando comodines en el texto ingresado")
      @NotNull

    public Boolean isIssearchbyupclike() {
    return issearchbyupclike;
  }

  public void setIssearchbyupclike(Boolean issearchbyupclike) {
    this.issearchbyupclike = issearchbyupclike;
  }

  public POS issearchbyvalue(Boolean issearchbyvalue) {
    this.issearchbyvalue = issearchbyvalue;
    return this;
  }

  /**
   * Realiza una búsqueda exacta por Clave de Búsqueda
   * @return issearchbyvalue
   **/
  @Schema(required = true, description = "Realiza una búsqueda exacta por Clave de Búsqueda")
      @NotNull

    public Boolean isIssearchbyvalue() {
    return issearchbyvalue;
  }

  public void setIssearchbyvalue(Boolean issearchbyvalue) {
    this.issearchbyvalue = issearchbyvalue;
  }

  public POS issearchbyvaluelike(Boolean issearchbyvaluelike) {
    this.issearchbyvaluelike = issearchbyvaluelike;
    return this;
  }

  /**
   * Realiza una búsqueda parcial por Clave de Búsqueda utilizando comodines en el texto ingresado
   * @return issearchbyvaluelike
   **/
  @Schema(required = true, description = "Realiza una búsqueda parcial por Clave de Búsqueda utilizando comodines en el texto ingresado")
      @NotNull

    public Boolean isIssearchbyvaluelike() {
    return issearchbyvaluelike;
  }

  public void setIssearchbyvaluelike(Boolean issearchbyvaluelike) {
    this.issearchbyvaluelike = issearchbyvaluelike;
  }

  public POS issearchtoday(Boolean issearchtoday) {
    this.issearchtoday = issearchtoday;
    return this;
  }

  /**
   *  
   * @return issearchtoday
   **/
  @Schema(description = " ")
  
    public Boolean isIssearchtoday() {
    return issearchtoday;
  }

  public void setIssearchtoday(Boolean issearchtoday) {
    this.issearchtoday = issearchtoday;
  }

  public POS lockedclosed(Boolean lockedclosed) {
    this.lockedclosed = lockedclosed;
    return this;
  }

  /**
   * Cierre de la ventana y de la aplicación bloqueado si el TPV posee líneas cargadas en la venta
   * @return lockedclosed
   **/
  @Schema(required = true, description = "Cierre de la ventana y de la aplicación bloqueado si el TPV posee líneas cargadas en la venta")
      @NotNull

    public Boolean isLockedclosed() {
    return lockedclosed;
  }

  public void setLockedclosed(Boolean lockedclosed) {
    this.lockedclosed = lockedclosed;
  }

  public POS maxreturnedcashincn(BigDecimal maxreturnedcashincn) {
    this.maxreturnedcashincn = maxreturnedcashincn;
    return this;
  }

  /**
   * Devolución máxima en efectivo permitida sin autorización
   * @return maxreturnedcashincn
   **/
  @Schema(required = true, description = "Devolución máxima en efectivo permitida sin autorización")
      @NotNull

    @Valid
    public BigDecimal getMaxreturnedcashincn() {
    return maxreturnedcashincn;
  }

  public void setMaxreturnedcashincn(BigDecimal maxreturnedcashincn) {
    this.maxreturnedcashincn = maxreturnedcashincn;
  }

  public POS mPricelistId(Integer mPricelistId) {
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

  public POS mWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
    return this;
  }

  /**
   * Almacén
   * @return mWarehouseId
   **/
  @Schema(required = true, description = "Almacén")
      @NotNull

    public Integer getMWarehouseId() {
    return mWarehouseId;
  }

  public void setMWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
  }

  public POS name(String name) {
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

  public POS operationmode(String operationmode) {
    this.operationmode = operationmode;
    return this;
  }

  /**
   * Modo de Operación de este TPV
   * @return operationmode
   **/
  @Schema(required = true, description = "Modo de Operación de este TPV")
      @NotNull

    public String getOperationmode() {
    return operationmode;
  }

  public void setOperationmode(String operationmode) {
    this.operationmode = operationmode;
  }

  public POS posnet(String posnet) {
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

  public POS posnumber(Integer posnumber) {
    this.posnumber = posnumber;
    return this;
  }

  /**
   * Número del punto de venta para el cual se generan las facturas
   * @return posnumber
   **/
  @Schema(required = true, description = "Número del punto de venta para el cual se generan las facturas")
      @NotNull

    public Integer getPosnumber() {
    return posnumber;
  }

  public void setPosnumber(Integer posnumber) {
    this.posnumber = posnumber;
  }

  public POS printername(String printername) {
    this.printername = printername;
    return this;
  }

  /**
   * Nombre de Impresora
   * @return printername
   **/
  @Schema(description = "Nombre de Impresora")
  
    public String getPrintername() {
    return printername;
  }

  public void setPrintername(String printername) {
    this.printername = printername;
  }

  public POS returnedcashincncontrol(Boolean returnedcashincncontrol) {
    this.returnedcashincncontrol = returnedcashincncontrol;
    return this;
  }

  /**
   * Control de Devolución de efectivo de Notas de Crédito
   * @return returnedcashincncontrol
   **/
  @Schema(required = true, description = "Control de Devolución de efectivo de Notas de Crédito")
      @NotNull

    public Boolean isReturnedcashincncontrol() {
    return returnedcashincncontrol;
  }

  public void setReturnedcashincncontrol(Boolean returnedcashincncontrol) {
    this.returnedcashincncontrol = returnedcashincncontrol;
  }

  public POS salesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
    return this;
  }

  /**
   * Comercial/Usuario
   * @return salesrepId
   **/
  @Schema(required = true, description = "Comercial/Usuario")
      @NotNull

    public Integer getSalesrepId() {
    return salesrepId;
  }

  public void setSalesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
  }

  public POS updated(String updated) {
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

  public POS updatedby(Integer updatedby) {
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

  public POS voiddocuments(Boolean voiddocuments) {
    this.voiddocuments = voiddocuments;
    return this;
  }

  /**
   * Esta configuración permite anular comprobantes en caso de error. Si no está tildado, al anular se le pedirá clave de supervisor. 
   * @return voiddocuments
   **/
  @Schema(required = true, description = "Esta configuración permite anular comprobantes en caso de error. Si no está tildado, al anular se le pedirá clave de supervisor. ")
      @NotNull

    public Boolean isVoiddocuments() {
    return voiddocuments;
  }

  public void setVoiddocuments(Boolean voiddocuments) {
    this.voiddocuments = voiddocuments;
  }

  public POS voiddocumentsEf(Boolean voiddocumentsEf) {
    this.voiddocumentsEf = voiddocumentsEf;
    return this;
  }

  /**
   * Anular Comprobantes Electrónicos luego de error en impresión fiscal
   * @return voiddocumentsEf
   **/
  @Schema(required = true, description = "Anular Comprobantes Electrónicos luego de error en impresión fiscal")
      @NotNull

    public Boolean isVoiddocumentsEf() {
    return voiddocumentsEf;
  }

  public void setVoiddocumentsEf(Boolean voiddocumentsEf) {
    this.voiddocumentsEf = voiddocumentsEf;
  }

  public POS additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public POS addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public POS referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public POS addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    POS POS = (POS) o;
    return Objects.equals(this.adClientId, POS.adClientId) &&
        Objects.equals(this.adOrgId, POS.adOrgId) &&
        Objects.equals(this.adRoleId, POS.adRoleId) &&
        Objects.equals(this.allowcreditnotesearch, POS.allowcreditnotesearch) &&
        Objects.equals(this.authorizegeneralmanualdiscount, POS.authorizegeneralmanualdiscount) &&
        Objects.equals(this.cBankaccountId, POS.cBankaccountId) &&
        Objects.equals(this.cBpartnercashtrxId, POS.cBpartnercashtrxId) &&
        Objects.equals(this.cCashbookId, POS.cCashbookId) &&
        Objects.equals(this.cDoctypeId, POS.cDoctypeId) &&
        Objects.equals(this.cInoutdoctypeId, POS.cInoutdoctypeId) &&
        Objects.equals(this.cInvoicedoctypeId, POS.cInvoicedoctypeId) &&
        Objects.equals(this.cOrderdoctypeId, POS.cOrderdoctypeId) &&
        Objects.equals(this.cPosId, POS.cPosId) &&
        Objects.equals(this.cPoskeylayoutId, POS.cPoskeylayoutId) &&
        Objects.equals(this.created, POS.created) &&
        Objects.equals(this.createdby, POS.createdby) &&
        Objects.equals(this.creditcardcashretirementChargeId, POS.creditcardcashretirementChargeId) &&
        Objects.equals(this.creditcardcashretirementDoctypeId, POS.creditcardcashretirementDoctypeId) &&
        Objects.equals(this.creditcardcashretirementProductId, POS.creditcardcashretirementProductId) &&
        Objects.equals(this.description, POS.description) &&
        Objects.equals(this.draftedinout, POS.draftedinout) &&
        Objects.equals(this.help, POS.help) &&
        Objects.equals(this.initialposauthorization, POS.initialposauthorization) &&
        Objects.equals(this.isactive, POS.isactive) &&
        Objects.equals(this.isallowcreditcardcashretirement, POS.isallowcreditcardcashretirement) &&
        Objects.equals(this.iscopyentity, POS.iscopyentity) &&
        Objects.equals(this.iscreateinvoice, POS.iscreateinvoice) &&
        Objects.equals(this.isdeliverorderinwarehouse, POS.isdeliverorderinwarehouse) &&
        Objects.equals(this.ismodifyprice, POS.ismodifyprice) &&
        Objects.equals(this.isprintcurrentaccountdocument, POS.isprintcurrentaccountdocument) &&
        Objects.equals(this.isprintwarehousedeliverdocument, POS.isprintwarehousedeliverdocument) &&
        Objects.equals(this.issalewithoutstock, POS.issalewithoutstock) &&
        Objects.equals(this.issearchbyname, POS.issearchbyname) &&
        Objects.equals(this.issearchbynamelike, POS.issearchbynamelike) &&
        Objects.equals(this.issearchbyupc, POS.issearchbyupc) &&
        Objects.equals(this.issearchbyupclike, POS.issearchbyupclike) &&
        Objects.equals(this.issearchbyvalue, POS.issearchbyvalue) &&
        Objects.equals(this.issearchbyvaluelike, POS.issearchbyvaluelike) &&
        Objects.equals(this.issearchtoday, POS.issearchtoday) &&
        Objects.equals(this.lockedclosed, POS.lockedclosed) &&
        Objects.equals(this.maxreturnedcashincn, POS.maxreturnedcashincn) &&
        Objects.equals(this.mPricelistId, POS.mPricelistId) &&
        Objects.equals(this.mWarehouseId, POS.mWarehouseId) &&
        Objects.equals(this.name, POS.name) &&
        Objects.equals(this.operationmode, POS.operationmode) &&
        Objects.equals(this.posnet, POS.posnet) &&
        Objects.equals(this.posnumber, POS.posnumber) &&
        Objects.equals(this.printername, POS.printername) &&
        Objects.equals(this.returnedcashincncontrol, POS.returnedcashincncontrol) &&
        Objects.equals(this.salesrepId, POS.salesrepId) &&
        Objects.equals(this.updated, POS.updated) &&
        Objects.equals(this.updatedby, POS.updatedby) &&
        Objects.equals(this.voiddocuments, POS.voiddocuments) &&
        Objects.equals(this.voiddocumentsEf, POS.voiddocumentsEf) &&
        Objects.equals(this.additionalvalues, POS.additionalvalues) &&
        Objects.equals(this.referencedvalues, POS.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adRoleId, allowcreditnotesearch, authorizegeneralmanualdiscount, cBankaccountId, cBpartnercashtrxId, cCashbookId, cDoctypeId, cInoutdoctypeId, cInvoicedoctypeId, cOrderdoctypeId, cPosId, cPoskeylayoutId, created, createdby, creditcardcashretirementChargeId, creditcardcashretirementDoctypeId, creditcardcashretirementProductId, description, draftedinout, help, initialposauthorization, isactive, isallowcreditcardcashretirement, iscopyentity, iscreateinvoice, isdeliverorderinwarehouse, ismodifyprice, isprintcurrentaccountdocument, isprintwarehousedeliverdocument, issalewithoutstock, issearchbyname, issearchbynamelike, issearchbyupc, issearchbyupclike, issearchbyvalue, issearchbyvaluelike, issearchtoday, lockedclosed, maxreturnedcashincn, mPricelistId, mWarehouseId, name, operationmode, posnet, posnumber, printername, returnedcashincncontrol, salesrepId, updated, updatedby, voiddocuments, voiddocumentsEf, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POS {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adRoleId: ").append(toIndentedString(adRoleId)).append("\n");
    sb.append("    allowcreditnotesearch: ").append(toIndentedString(allowcreditnotesearch)).append("\n");
    sb.append("    authorizegeneralmanualdiscount: ").append(toIndentedString(authorizegeneralmanualdiscount)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBpartnercashtrxId: ").append(toIndentedString(cBpartnercashtrxId)).append("\n");
    sb.append("    cCashbookId: ").append(toIndentedString(cCashbookId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    cInoutdoctypeId: ").append(toIndentedString(cInoutdoctypeId)).append("\n");
    sb.append("    cInvoicedoctypeId: ").append(toIndentedString(cInvoicedoctypeId)).append("\n");
    sb.append("    cOrderdoctypeId: ").append(toIndentedString(cOrderdoctypeId)).append("\n");
    sb.append("    cPosId: ").append(toIndentedString(cPosId)).append("\n");
    sb.append("    cPoskeylayoutId: ").append(toIndentedString(cPoskeylayoutId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditcardcashretirementChargeId: ").append(toIndentedString(creditcardcashretirementChargeId)).append("\n");
    sb.append("    creditcardcashretirementDoctypeId: ").append(toIndentedString(creditcardcashretirementDoctypeId)).append("\n");
    sb.append("    creditcardcashretirementProductId: ").append(toIndentedString(creditcardcashretirementProductId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    draftedinout: ").append(toIndentedString(draftedinout)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    initialposauthorization: ").append(toIndentedString(initialposauthorization)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isallowcreditcardcashretirement: ").append(toIndentedString(isallowcreditcardcashretirement)).append("\n");
    sb.append("    iscopyentity: ").append(toIndentedString(iscopyentity)).append("\n");
    sb.append("    iscreateinvoice: ").append(toIndentedString(iscreateinvoice)).append("\n");
    sb.append("    isdeliverorderinwarehouse: ").append(toIndentedString(isdeliverorderinwarehouse)).append("\n");
    sb.append("    ismodifyprice: ").append(toIndentedString(ismodifyprice)).append("\n");
    sb.append("    isprintcurrentaccountdocument: ").append(toIndentedString(isprintcurrentaccountdocument)).append("\n");
    sb.append("    isprintwarehousedeliverdocument: ").append(toIndentedString(isprintwarehousedeliverdocument)).append("\n");
    sb.append("    issalewithoutstock: ").append(toIndentedString(issalewithoutstock)).append("\n");
    sb.append("    issearchbyname: ").append(toIndentedString(issearchbyname)).append("\n");
    sb.append("    issearchbynamelike: ").append(toIndentedString(issearchbynamelike)).append("\n");
    sb.append("    issearchbyupc: ").append(toIndentedString(issearchbyupc)).append("\n");
    sb.append("    issearchbyupclike: ").append(toIndentedString(issearchbyupclike)).append("\n");
    sb.append("    issearchbyvalue: ").append(toIndentedString(issearchbyvalue)).append("\n");
    sb.append("    issearchbyvaluelike: ").append(toIndentedString(issearchbyvaluelike)).append("\n");
    sb.append("    issearchtoday: ").append(toIndentedString(issearchtoday)).append("\n");
    sb.append("    lockedclosed: ").append(toIndentedString(lockedclosed)).append("\n");
    sb.append("    maxreturnedcashincn: ").append(toIndentedString(maxreturnedcashincn)).append("\n");
    sb.append("    mPricelistId: ").append(toIndentedString(mPricelistId)).append("\n");
    sb.append("    mWarehouseId: ").append(toIndentedString(mWarehouseId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    operationmode: ").append(toIndentedString(operationmode)).append("\n");
    sb.append("    posnet: ").append(toIndentedString(posnet)).append("\n");
    sb.append("    posnumber: ").append(toIndentedString(posnumber)).append("\n");
    sb.append("    printername: ").append(toIndentedString(printername)).append("\n");
    sb.append("    returnedcashincncontrol: ").append(toIndentedString(returnedcashincncontrol)).append("\n");
    sb.append("    salesrepId: ").append(toIndentedString(salesrepId)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    voiddocuments: ").append(toIndentedString(voiddocuments)).append("\n");
    sb.append("    voiddocumentsEf: ").append(toIndentedString(voiddocumentsEf)).append("\n");
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
