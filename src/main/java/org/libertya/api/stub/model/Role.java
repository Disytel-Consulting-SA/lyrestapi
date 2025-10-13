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
 * Role
 */
@Validated



public class Role   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("addsecurityvalidation_createfrominvoice")
  private Boolean addsecurityvalidationCreatefrominvoice = null;

  @JsonProperty("addsecurityvalidation_createfromshipment")
  private Boolean addsecurityvalidationCreatefromshipment = null;

  @JsonProperty("addsecurityvalidation_oprc_nc")
  private Boolean addsecurityvalidationOprcNc = null;

  @JsonProperty("addsecurityvalidation_pos_nc")
  private Boolean addsecurityvalidationPosNc = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_role_id")
  private Integer adRoleId = null;

  @JsonProperty("ad_tree_menu_id")
  private Integer adTreeMenuId = null;

  @JsonProperty("ad_tree_org_id")
  private Integer adTreeOrgId = null;

  @JsonProperty("allow_info_account")
  private Boolean allowInfoAccount = null;

  @JsonProperty("allow_info_asset")
  private Boolean allowInfoAsset = null;

  @JsonProperty("allow_info_bpartner")
  private Boolean allowInfoBpartner = null;

  @JsonProperty("allow_info_cashjournal")
  private Boolean allowInfoCashjournal = null;

  @JsonProperty("allow_info_crp")
  private Boolean allowInfoCrp = null;

  @JsonProperty("allow_info_inout")
  private Boolean allowInfoInout = null;

  @JsonProperty("allow_info_invoice")
  private Boolean allowInfoInvoice = null;

  @JsonProperty("allow_info_mrp")
  private Boolean allowInfoMrp = null;

  @JsonProperty("allow_info_order")
  private Boolean allowInfoOrder = null;

  @JsonProperty("allow_info_payment")
  private Boolean allowInfoPayment = null;

  @JsonProperty("allow_info_product")
  private Boolean allowInfoProduct = null;

  @JsonProperty("allow_info_product_ordered_tab")
  private Boolean allowInfoProductOrderedTab = null;

  @JsonProperty("allow_info_product_reserved_tab")
  private Boolean allowInfoProductReservedTab = null;

  @JsonProperty("allow_info_resource")
  private Boolean allowInfoResource = null;

  @JsonProperty("allow_info_schedule")
  private Boolean allowInfoSchedule = null;

  @JsonProperty("amtapproval")
  private BigDecimal amtapproval = null;

  @JsonProperty("applyreadonly")
  private String applyreadonly = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("confirmqueryrecords")
  private Integer confirmqueryrecords = null;

  @JsonProperty("controlcuitlimit")
  private BigDecimal controlcuitlimit = null;

  @JsonProperty("controlcuitlimitclient")
  private BigDecimal controlcuitlimitclient = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isaccessallorgs")
  private Boolean isaccessallorgs = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isallowopa")
  private Boolean isallowopa = null;

  @JsonProperty("iscanapproveowndoc")
  private Boolean iscanapproveowndoc = null;

  @JsonProperty("iscanexport")
  private Boolean iscanexport = null;

  @JsonProperty("iscanreport")
  private Boolean iscanreport = null;

  @JsonProperty("ischangelog")
  private Boolean ischangelog = null;

  @JsonProperty("isinfoassetaccess")
  private Boolean isinfoassetaccess = null;

  @JsonProperty("isinfoassignmentaccess")
  private Boolean isinfoassignmentaccess = null;

  @JsonProperty("isinfobpartneraccess")
  private Boolean isinfobpartneraccess = null;

  @JsonProperty("isinfocashlineaccess")
  private Boolean isinfocashlineaccess = null;

  @JsonProperty("isinfoinoutaccess")
  private Boolean isinfoinoutaccess = null;

  @JsonProperty("isinfoinvoiceaccess")
  private Boolean isinfoinvoiceaccess = null;

  @JsonProperty("isinfoorderaccess")
  private Boolean isinfoorderaccess = null;

  @JsonProperty("isinfopaymentaccess")
  private Boolean isinfopaymentaccess = null;

  @JsonProperty("isinfoproductaccess")
  private Boolean isinfoproductaccess = null;

  @JsonProperty("isinfoscheduleaccess")
  private Boolean isinfoscheduleaccess = null;

  @JsonProperty("ismanual")
  private Boolean ismanual = null;

  @JsonProperty("ispersonalaccess")
  private Boolean ispersonalaccess = null;

  @JsonProperty("ispersonallock")
  private Boolean ispersonallock = null;

  @JsonProperty("isshowacct")
  private Boolean isshowacct = null;

  @JsonProperty("isuseuserorgaccess")
  private Boolean isuseuserorgaccess = null;

  @JsonProperty("lookup_allow_bpartner_create_menu")
  private Boolean lookupAllowBpartnerCreateMenu = null;

  @JsonProperty("maxqueryrecords")
  private Integer maxqueryrecords = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("overwritepricelimit")
  private Boolean overwritepricelimit = null;

  @JsonProperty("paymentmedium")
  private String paymentmedium = null;

  @JsonProperty("paymentmediumlimit")
  private BigDecimal paymentmediumlimit = null;

  @JsonProperty("posjournalsupervisor")
  private Boolean posjournalsupervisor = null;

  @JsonProperty("preferencetype")
  private String preferencetype = null;

  @JsonProperty("supervisor_id")
  private Integer supervisorId = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("userlevel")
  private String userlevel = null;

  @JsonProperty("viewpurchaseprice")
  private Boolean viewpurchaseprice = null;

  @JsonProperty("viewsalesprice")
  private Boolean viewsalesprice = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Role adClientId(Integer adClientId) {
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

  public Role adComponentobjectuid(String adComponentobjectuid) {
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

  public Role adComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
    return this;
  }

  /**
   * Versión de Componente propietaria de este registro
   * @return adComponentversionId
   **/
  @Schema(description = "Versión de Componente propietaria de este registro")
  
    public Integer getAdComponentversionId() {
    return adComponentversionId;
  }

  public void setAdComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
  }

  public Role addsecurityvalidationCreatefrominvoice(Boolean addsecurityvalidationCreatefrominvoice) {
    this.addsecurityvalidationCreatefrominvoice = addsecurityvalidationCreatefrominvoice;
    return this;
  }

  /**
   * Botón Crear Desde en ventana de Facturas
   * @return addsecurityvalidationCreatefrominvoice
   **/
  @Schema(required = true, description = "Botón Crear Desde en ventana de Facturas")
      @NotNull

    public Boolean isAddsecurityvalidationCreatefrominvoice() {
    return addsecurityvalidationCreatefrominvoice;
  }

  public void setAddsecurityvalidationCreatefrominvoice(Boolean addsecurityvalidationCreatefrominvoice) {
    this.addsecurityvalidationCreatefrominvoice = addsecurityvalidationCreatefrominvoice;
  }

  public Role addsecurityvalidationCreatefromshipment(Boolean addsecurityvalidationCreatefromshipment) {
    this.addsecurityvalidationCreatefromshipment = addsecurityvalidationCreatefromshipment;
    return this;
  }

  /**
   * Botón Crear Desde en ventana de Remitos
   * @return addsecurityvalidationCreatefromshipment
   **/
  @Schema(required = true, description = "Botón Crear Desde en ventana de Remitos")
      @NotNull

    public Boolean isAddsecurityvalidationCreatefromshipment() {
    return addsecurityvalidationCreatefromshipment;
  }

  public void setAddsecurityvalidationCreatefromshipment(Boolean addsecurityvalidationCreatefromshipment) {
    this.addsecurityvalidationCreatefromshipment = addsecurityvalidationCreatefromshipment;
  }

  public Role addsecurityvalidationOprcNc(Boolean addsecurityvalidationOprcNc) {
    this.addsecurityvalidationOprcNc = addsecurityvalidationOprcNc;
    return this;
  }

  /**
   * Campo Nota de Crédito de Orden de Pago / Recibos de Cliente
   * @return addsecurityvalidationOprcNc
   **/
  @Schema(required = true, description = "Campo Nota de Crédito de Orden de Pago / Recibos de Cliente")
      @NotNull

    public Boolean isAddsecurityvalidationOprcNc() {
    return addsecurityvalidationOprcNc;
  }

  public void setAddsecurityvalidationOprcNc(Boolean addsecurityvalidationOprcNc) {
    this.addsecurityvalidationOprcNc = addsecurityvalidationOprcNc;
  }

  public Role addsecurityvalidationPosNc(Boolean addsecurityvalidationPosNc) {
    this.addsecurityvalidationPosNc = addsecurityvalidationPosNc;
    return this;
  }

  /**
   * Campo Nota de Crédito en TPV
   * @return addsecurityvalidationPosNc
   **/
  @Schema(required = true, description = "Campo Nota de Crédito en TPV")
      @NotNull

    public Boolean isAddsecurityvalidationPosNc() {
    return addsecurityvalidationPosNc;
  }

  public void setAddsecurityvalidationPosNc(Boolean addsecurityvalidationPosNc) {
    this.addsecurityvalidationPosNc = addsecurityvalidationPosNc;
  }

  public Role adOrgId(Integer adOrgId) {
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

  public Role adRoleId(Integer adRoleId) {
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

  public Role adTreeMenuId(Integer adTreeMenuId) {
    this.adTreeMenuId = adTreeMenuId;
    return this;
  }

  /**
   * Árbol de Menú Primario
   * @return adTreeMenuId
   **/
  @Schema(description = "Árbol de Menú Primario")
  
    public Integer getAdTreeMenuId() {
    return adTreeMenuId;
  }

  public void setAdTreeMenuId(Integer adTreeMenuId) {
    this.adTreeMenuId = adTreeMenuId;
  }

  public Role adTreeOrgId(Integer adTreeOrgId) {
    this.adTreeOrgId = adTreeOrgId;
    return this;
  }

  /**
   * Árbol de Organización Primario
   * @return adTreeOrgId
   **/
  @Schema(description = "Árbol de Organización Primario")
  
    public Integer getAdTreeOrgId() {
    return adTreeOrgId;
  }

  public void setAdTreeOrgId(Integer adTreeOrgId) {
    this.adTreeOrgId = adTreeOrgId;
  }

  public Role allowInfoAccount(Boolean allowInfoAccount) {
    this.allowInfoAccount = allowInfoAccount;
    return this;
  }

  /**
   *  
   * @return allowInfoAccount
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoAccount() {
    return allowInfoAccount;
  }

  public void setAllowInfoAccount(Boolean allowInfoAccount) {
    this.allowInfoAccount = allowInfoAccount;
  }

  public Role allowInfoAsset(Boolean allowInfoAsset) {
    this.allowInfoAsset = allowInfoAsset;
    return this;
  }

  /**
   *  
   * @return allowInfoAsset
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoAsset() {
    return allowInfoAsset;
  }

  public void setAllowInfoAsset(Boolean allowInfoAsset) {
    this.allowInfoAsset = allowInfoAsset;
  }

  public Role allowInfoBpartner(Boolean allowInfoBpartner) {
    this.allowInfoBpartner = allowInfoBpartner;
    return this;
  }

  /**
   *  
   * @return allowInfoBpartner
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoBpartner() {
    return allowInfoBpartner;
  }

  public void setAllowInfoBpartner(Boolean allowInfoBpartner) {
    this.allowInfoBpartner = allowInfoBpartner;
  }

  public Role allowInfoCashjournal(Boolean allowInfoCashjournal) {
    this.allowInfoCashjournal = allowInfoCashjournal;
    return this;
  }

  /**
   *  
   * @return allowInfoCashjournal
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoCashjournal() {
    return allowInfoCashjournal;
  }

  public void setAllowInfoCashjournal(Boolean allowInfoCashjournal) {
    this.allowInfoCashjournal = allowInfoCashjournal;
  }

  public Role allowInfoCrp(Boolean allowInfoCrp) {
    this.allowInfoCrp = allowInfoCrp;
    return this;
  }

  /**
   *  
   * @return allowInfoCrp
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoCrp() {
    return allowInfoCrp;
  }

  public void setAllowInfoCrp(Boolean allowInfoCrp) {
    this.allowInfoCrp = allowInfoCrp;
  }

  public Role allowInfoInout(Boolean allowInfoInout) {
    this.allowInfoInout = allowInfoInout;
    return this;
  }

  /**
   *  
   * @return allowInfoInout
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoInout() {
    return allowInfoInout;
  }

  public void setAllowInfoInout(Boolean allowInfoInout) {
    this.allowInfoInout = allowInfoInout;
  }

  public Role allowInfoInvoice(Boolean allowInfoInvoice) {
    this.allowInfoInvoice = allowInfoInvoice;
    return this;
  }

  /**
   *  
   * @return allowInfoInvoice
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoInvoice() {
    return allowInfoInvoice;
  }

  public void setAllowInfoInvoice(Boolean allowInfoInvoice) {
    this.allowInfoInvoice = allowInfoInvoice;
  }

  public Role allowInfoMrp(Boolean allowInfoMrp) {
    this.allowInfoMrp = allowInfoMrp;
    return this;
  }

  /**
   *  
   * @return allowInfoMrp
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoMrp() {
    return allowInfoMrp;
  }

  public void setAllowInfoMrp(Boolean allowInfoMrp) {
    this.allowInfoMrp = allowInfoMrp;
  }

  public Role allowInfoOrder(Boolean allowInfoOrder) {
    this.allowInfoOrder = allowInfoOrder;
    return this;
  }

  /**
   *  
   * @return allowInfoOrder
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoOrder() {
    return allowInfoOrder;
  }

  public void setAllowInfoOrder(Boolean allowInfoOrder) {
    this.allowInfoOrder = allowInfoOrder;
  }

  public Role allowInfoPayment(Boolean allowInfoPayment) {
    this.allowInfoPayment = allowInfoPayment;
    return this;
  }

  /**
   *  
   * @return allowInfoPayment
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoPayment() {
    return allowInfoPayment;
  }

  public void setAllowInfoPayment(Boolean allowInfoPayment) {
    this.allowInfoPayment = allowInfoPayment;
  }

  public Role allowInfoProduct(Boolean allowInfoProduct) {
    this.allowInfoProduct = allowInfoProduct;
    return this;
  }

  /**
   *  
   * @return allowInfoProduct
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoProduct() {
    return allowInfoProduct;
  }

  public void setAllowInfoProduct(Boolean allowInfoProduct) {
    this.allowInfoProduct = allowInfoProduct;
  }

  public Role allowInfoProductOrderedTab(Boolean allowInfoProductOrderedTab) {
    this.allowInfoProductOrderedTab = allowInfoProductOrderedTab;
    return this;
  }

  /**
   * Visualizar pestaña Pendiente Recibir en ventana Historial
   * @return allowInfoProductOrderedTab
   **/
  @Schema(required = true, description = "Visualizar pestaña Pendiente Recibir en ventana Historial")
      @NotNull

    public Boolean isAllowInfoProductOrderedTab() {
    return allowInfoProductOrderedTab;
  }

  public void setAllowInfoProductOrderedTab(Boolean allowInfoProductOrderedTab) {
    this.allowInfoProductOrderedTab = allowInfoProductOrderedTab;
  }

  public Role allowInfoProductReservedTab(Boolean allowInfoProductReservedTab) {
    this.allowInfoProductReservedTab = allowInfoProductReservedTab;
    return this;
  }

  /**
   * Visualizar pestaña Pendiente Entrega en ventana Historial
   * @return allowInfoProductReservedTab
   **/
  @Schema(required = true, description = "Visualizar pestaña Pendiente Entrega en ventana Historial")
      @NotNull

    public Boolean isAllowInfoProductReservedTab() {
    return allowInfoProductReservedTab;
  }

  public void setAllowInfoProductReservedTab(Boolean allowInfoProductReservedTab) {
    this.allowInfoProductReservedTab = allowInfoProductReservedTab;
  }

  public Role allowInfoResource(Boolean allowInfoResource) {
    this.allowInfoResource = allowInfoResource;
    return this;
  }

  /**
   *  
   * @return allowInfoResource
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoResource() {
    return allowInfoResource;
  }

  public void setAllowInfoResource(Boolean allowInfoResource) {
    this.allowInfoResource = allowInfoResource;
  }

  public Role allowInfoSchedule(Boolean allowInfoSchedule) {
    this.allowInfoSchedule = allowInfoSchedule;
    return this;
  }

  /**
   *  
   * @return allowInfoSchedule
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowInfoSchedule() {
    return allowInfoSchedule;
  }

  public void setAllowInfoSchedule(Boolean allowInfoSchedule) {
    this.allowInfoSchedule = allowInfoSchedule;
  }

  public Role amtapproval(BigDecimal amtapproval) {
    this.amtapproval = amtapproval;
    return this;
  }

  /**
   * Importe límite aprobado para este perfil
   * @return amtapproval
   **/
  @Schema(description = "Importe límite aprobado para este perfil")
  
    @Valid
    public BigDecimal getAmtapproval() {
    return amtapproval;
  }

  public void setAmtapproval(BigDecimal amtapproval) {
    this.amtapproval = amtapproval;
  }

  public Role applyreadonly(String applyreadonly) {
    this.applyreadonly = applyreadonly;
    return this;
  }

  /**
   * Setea Sólo Lectura a todos los componentes relacionados al perfil
   * @return applyreadonly
   **/
  @Schema(description = "Setea Sólo Lectura a todos los componentes relacionados al perfil")
  
    public String getApplyreadonly() {
    return applyreadonly;
  }

  public void setApplyreadonly(String applyreadonly) {
    this.applyreadonly = applyreadonly;
  }

  public Role cCurrencyId(Integer cCurrencyId) {
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

  public Role confirmqueryrecords(Integer confirmqueryrecords) {
    this.confirmqueryrecords = confirmqueryrecords;
    return this;
  }

  /**
   *  
   * @return confirmqueryrecords
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getConfirmqueryrecords() {
    return confirmqueryrecords;
  }

  public void setConfirmqueryrecords(Integer confirmqueryrecords) {
    this.confirmqueryrecords = confirmqueryrecords;
  }

  public Role controlcuitlimit(BigDecimal controlcuitlimit) {
    this.controlcuitlimit = controlcuitlimit;
    return this;
  }

  /**
   * Monto Límite permitido a configurar para el Control de CUIT de cheques por Organización
   * @return controlcuitlimit
   **/
  @Schema(required = true, description = "Monto Límite permitido a configurar para el Control de CUIT de cheques por Organización")
      @NotNull

    @Valid
    public BigDecimal getControlcuitlimit() {
    return controlcuitlimit;
  }

  public void setControlcuitlimit(BigDecimal controlcuitlimit) {
    this.controlcuitlimit = controlcuitlimit;
  }

  public Role controlcuitlimitclient(BigDecimal controlcuitlimitclient) {
    this.controlcuitlimitclient = controlcuitlimitclient;
    return this;
  }

  /**
   * Monto Límite permitido a configurar para el Control de CUIT de cheques por Compañía o registro Organización *
   * @return controlcuitlimitclient
   **/
  @Schema(required = true, description = "Monto Límite permitido a configurar para el Control de CUIT de cheques por Compañía o registro Organización *")
      @NotNull

    @Valid
    public BigDecimal getControlcuitlimitclient() {
    return controlcuitlimitclient;
  }

  public void setControlcuitlimitclient(BigDecimal controlcuitlimitclient) {
    this.controlcuitlimitclient = controlcuitlimitclient;
  }

  public Role created(String created) {
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

  public Role createdby(Integer createdby) {
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

  public Role description(String description) {
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

  public Role isaccessallorgs(Boolean isaccessallorgs) {
    this.isaccessallorgs = isaccessallorgs;
    return this;
  }

  /**
   * Acceder a Todas las organizaciones
   * @return isaccessallorgs
   **/
  @Schema(required = true, description = "Acceder a Todas las organizaciones")
      @NotNull

    public Boolean isIsaccessallorgs() {
    return isaccessallorgs;
  }

  public void setIsaccessallorgs(Boolean isaccessallorgs) {
    this.isaccessallorgs = isaccessallorgs;
  }

  public Role isactive(Boolean isactive) {
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

  public Role isallowopa(Boolean isallowopa) {
    this.isallowopa = isallowopa;
    return this;
  }

  /**
   *  
   * @return isallowopa
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsallowopa() {
    return isallowopa;
  }

  public void setIsallowopa(Boolean isallowopa) {
    this.isallowopa = isallowopa;
  }

  public Role iscanapproveowndoc(Boolean iscanapproveowndoc) {
    this.iscanapproveowndoc = iscanapproveowndoc;
    return this;
  }

  /**
   * Usuarios con este rol pueden aprobar sus propios documentos
   * @return iscanapproveowndoc
   **/
  @Schema(required = true, description = "Usuarios con este rol pueden aprobar sus propios documentos")
      @NotNull

    public Boolean isIscanapproveowndoc() {
    return iscanapproveowndoc;
  }

  public void setIscanapproveowndoc(Boolean iscanapproveowndoc) {
    this.iscanapproveowndoc = iscanapproveowndoc;
  }

  public Role iscanexport(Boolean iscanexport) {
    this.iscanexport = iscanexport;
    return this;
  }

  /**
   * Usuarios con este rol pueden exportar datos
   * @return iscanexport
   **/
  @Schema(required = true, description = "Usuarios con este rol pueden exportar datos")
      @NotNull

    public Boolean isIscanexport() {
    return iscanexport;
  }

  public void setIscanexport(Boolean iscanexport) {
    this.iscanexport = iscanexport;
  }

  public Role iscanreport(Boolean iscanreport) {
    this.iscanreport = iscanreport;
    return this;
  }

  /**
   * Usuarios con este rol pueden crear Informes
   * @return iscanreport
   **/
  @Schema(required = true, description = "Usuarios con este rol pueden crear Informes")
      @NotNull

    public Boolean isIscanreport() {
    return iscanreport;
  }

  public void setIscanreport(Boolean iscanreport) {
    this.iscanreport = iscanreport;
  }

  public Role ischangelog(Boolean ischangelog) {
    this.ischangelog = ischangelog;
    return this;
  }

  /**
   * Mantener Archivo (log) de Cambios
   * @return ischangelog
   **/
  @Schema(required = true, description = "Mantener Archivo (log) de Cambios")
      @NotNull

    public Boolean isIschangelog() {
    return ischangelog;
  }

  public void setIschangelog(Boolean ischangelog) {
    this.ischangelog = ischangelog;
  }

  public Role isinfoassetaccess(Boolean isinfoassetaccess) {
    this.isinfoassetaccess = isinfoassetaccess;
    return this;
  }

  /**
   *  
   * @return isinfoassetaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfoassetaccess() {
    return isinfoassetaccess;
  }

  public void setIsinfoassetaccess(Boolean isinfoassetaccess) {
    this.isinfoassetaccess = isinfoassetaccess;
  }

  public Role isinfoassignmentaccess(Boolean isinfoassignmentaccess) {
    this.isinfoassignmentaccess = isinfoassignmentaccess;
    return this;
  }

  /**
   *  
   * @return isinfoassignmentaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfoassignmentaccess() {
    return isinfoassignmentaccess;
  }

  public void setIsinfoassignmentaccess(Boolean isinfoassignmentaccess) {
    this.isinfoassignmentaccess = isinfoassignmentaccess;
  }

  public Role isinfobpartneraccess(Boolean isinfobpartneraccess) {
    this.isinfobpartneraccess = isinfobpartneraccess;
    return this;
  }

  /**
   *  
   * @return isinfobpartneraccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfobpartneraccess() {
    return isinfobpartneraccess;
  }

  public void setIsinfobpartneraccess(Boolean isinfobpartneraccess) {
    this.isinfobpartneraccess = isinfobpartneraccess;
  }

  public Role isinfocashlineaccess(Boolean isinfocashlineaccess) {
    this.isinfocashlineaccess = isinfocashlineaccess;
    return this;
  }

  /**
   *  
   * @return isinfocashlineaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfocashlineaccess() {
    return isinfocashlineaccess;
  }

  public void setIsinfocashlineaccess(Boolean isinfocashlineaccess) {
    this.isinfocashlineaccess = isinfocashlineaccess;
  }

  public Role isinfoinoutaccess(Boolean isinfoinoutaccess) {
    this.isinfoinoutaccess = isinfoinoutaccess;
    return this;
  }

  /**
   *  
   * @return isinfoinoutaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfoinoutaccess() {
    return isinfoinoutaccess;
  }

  public void setIsinfoinoutaccess(Boolean isinfoinoutaccess) {
    this.isinfoinoutaccess = isinfoinoutaccess;
  }

  public Role isinfoinvoiceaccess(Boolean isinfoinvoiceaccess) {
    this.isinfoinvoiceaccess = isinfoinvoiceaccess;
    return this;
  }

  /**
   *  
   * @return isinfoinvoiceaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfoinvoiceaccess() {
    return isinfoinvoiceaccess;
  }

  public void setIsinfoinvoiceaccess(Boolean isinfoinvoiceaccess) {
    this.isinfoinvoiceaccess = isinfoinvoiceaccess;
  }

  public Role isinfoorderaccess(Boolean isinfoorderaccess) {
    this.isinfoorderaccess = isinfoorderaccess;
    return this;
  }

  /**
   *  
   * @return isinfoorderaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfoorderaccess() {
    return isinfoorderaccess;
  }

  public void setIsinfoorderaccess(Boolean isinfoorderaccess) {
    this.isinfoorderaccess = isinfoorderaccess;
  }

  public Role isinfopaymentaccess(Boolean isinfopaymentaccess) {
    this.isinfopaymentaccess = isinfopaymentaccess;
    return this;
  }

  /**
   *  
   * @return isinfopaymentaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfopaymentaccess() {
    return isinfopaymentaccess;
  }

  public void setIsinfopaymentaccess(Boolean isinfopaymentaccess) {
    this.isinfopaymentaccess = isinfopaymentaccess;
  }

  public Role isinfoproductaccess(Boolean isinfoproductaccess) {
    this.isinfoproductaccess = isinfoproductaccess;
    return this;
  }

  /**
   * Indica si los usuarios con este perfil pueden ver y utilizar el Buscador de Artículos
   * @return isinfoproductaccess
   **/
  @Schema(required = true, description = "Indica si los usuarios con este perfil pueden ver y utilizar el Buscador de Artículos")
      @NotNull

    public Boolean isIsinfoproductaccess() {
    return isinfoproductaccess;
  }

  public void setIsinfoproductaccess(Boolean isinfoproductaccess) {
    this.isinfoproductaccess = isinfoproductaccess;
  }

  public Role isinfoscheduleaccess(Boolean isinfoscheduleaccess) {
    this.isinfoscheduleaccess = isinfoscheduleaccess;
    return this;
  }

  /**
   *  
   * @return isinfoscheduleaccess
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsinfoscheduleaccess() {
    return isinfoscheduleaccess;
  }

  public void setIsinfoscheduleaccess(Boolean isinfoscheduleaccess) {
    this.isinfoscheduleaccess = isinfoscheduleaccess;
  }

  public Role ismanual(Boolean ismanual) {
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

  public Role ispersonalaccess(Boolean ispersonalaccess) {
    this.ispersonalaccess = ispersonalaccess;
    return this;
  }

  /**
   * Permitir acceso a los registros marcados como personales por otros perfiles
   * @return ispersonalaccess
   **/
  @Schema(required = true, description = "Permitir acceso a los registros marcados como personales por otros perfiles")
      @NotNull

    public Boolean isIspersonalaccess() {
    return ispersonalaccess;
  }

  public void setIspersonalaccess(Boolean ispersonalaccess) {
    this.ispersonalaccess = ispersonalaccess;
  }

  public Role ispersonallock(Boolean ispersonallock) {
    this.ispersonallock = ispersonallock;
    return this;
  }

  /**
   * Se marcan los ficheros como personales y otros perfiles no pueden acceder a ellos
   * @return ispersonallock
   **/
  @Schema(required = true, description = "Se marcan los ficheros como personales y otros perfiles no pueden acceder a ellos")
      @NotNull

    public Boolean isIspersonallock() {
    return ispersonallock;
  }

  public void setIspersonallock(Boolean ispersonallock) {
    this.ispersonallock = ispersonallock;
  }

  public Role isshowacct(Boolean isshowacct) {
    this.isshowacct = isshowacct;
    return this;
  }

  /**
   * Mostrar Contabilidad para usuarios con este Rol
   * @return isshowacct
   **/
  @Schema(required = true, description = "Mostrar Contabilidad para usuarios con este Rol")
      @NotNull

    public Boolean isIsshowacct() {
    return isshowacct;
  }

  public void setIsshowacct(Boolean isshowacct) {
    this.isshowacct = isshowacct;
  }

  public Role isuseuserorgaccess(Boolean isuseuserorgaccess) {
    this.isuseuserorgaccess = isuseuserorgaccess;
    return this;
  }

  /**
   * Usar Acceso de la Org del Uusario
   * @return isuseuserorgaccess
   **/
  @Schema(required = true, description = "Usar Acceso de la Org del Uusario")
      @NotNull

    public Boolean isIsuseuserorgaccess() {
    return isuseuserorgaccess;
  }

  public void setIsuseuserorgaccess(Boolean isuseuserorgaccess) {
    this.isuseuserorgaccess = isuseuserorgaccess;
  }

  public Role lookupAllowBpartnerCreateMenu(Boolean lookupAllowBpartnerCreateMenu) {
    this.lookupAllowBpartnerCreateMenu = lookupAllowBpartnerCreateMenu;
    return this;
  }

  /**
   * Permitir Menú Creación de Entidades Comerciales
   * @return lookupAllowBpartnerCreateMenu
   **/
  @Schema(required = true, description = "Permitir Menú Creación de Entidades Comerciales")
      @NotNull

    public Boolean isLookupAllowBpartnerCreateMenu() {
    return lookupAllowBpartnerCreateMenu;
  }

  public void setLookupAllowBpartnerCreateMenu(Boolean lookupAllowBpartnerCreateMenu) {
    this.lookupAllowBpartnerCreateMenu = lookupAllowBpartnerCreateMenu;
  }

  public Role maxqueryrecords(Integer maxqueryrecords) {
    this.maxqueryrecords = maxqueryrecords;
    return this;
  }

  /**
   *  
   * @return maxqueryrecords
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getMaxqueryrecords() {
    return maxqueryrecords;
  }

  public void setMaxqueryrecords(Integer maxqueryrecords) {
    this.maxqueryrecords = maxqueryrecords;
  }

  public Role name(String name) {
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

  public Role overwritepricelimit(Boolean overwritepricelimit) {
    this.overwritepricelimit = overwritepricelimit;
    return this;
  }

  /**
   * Sobreescribir Precio Limite
   * @return overwritepricelimit
   **/
  @Schema(required = true, description = "Sobreescribir Precio Limite")
      @NotNull

    public Boolean isOverwritepricelimit() {
    return overwritepricelimit;
  }

  public void setOverwritepricelimit(Boolean overwritepricelimit) {
    this.overwritepricelimit = overwritepricelimit;
  }

  public Role paymentmedium(String paymentmedium) {
    this.paymentmedium = paymentmedium;
    return this;
  }

  /**
   *  
   * @return paymentmedium
   **/
  @Schema(description = " ")
  
    public String getPaymentmedium() {
    return paymentmedium;
  }

  public void setPaymentmedium(String paymentmedium) {
    this.paymentmedium = paymentmedium;
  }

  public Role paymentmediumlimit(BigDecimal paymentmediumlimit) {
    this.paymentmediumlimit = paymentmediumlimit;
    return this;
  }

  /**
   *  
   * @return paymentmediumlimit
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getPaymentmediumlimit() {
    return paymentmediumlimit;
  }

  public void setPaymentmediumlimit(BigDecimal paymentmediumlimit) {
    this.paymentmediumlimit = paymentmediumlimit;
  }

  public Role posjournalsupervisor(Boolean posjournalsupervisor) {
    this.posjournalsupervisor = posjournalsupervisor;
    return this;
  }

  /**
   * Este perfil es Supervisor de Cajas Diarias
   * @return posjournalsupervisor
   **/
  @Schema(required = true, description = "Este perfil es Supervisor de Cajas Diarias")
      @NotNull

    public Boolean isPosjournalsupervisor() {
    return posjournalsupervisor;
  }

  public void setPosjournalsupervisor(Boolean posjournalsupervisor) {
    this.posjournalsupervisor = posjournalsupervisor;
  }

  public Role preferencetype(String preferencetype) {
    this.preferencetype = preferencetype;
    return this;
  }

  /**
   * Nivel de Preferencia
   * @return preferencetype
   **/
  @Schema(required = true, description = "Nivel de Preferencia")
      @NotNull

    public String getPreferencetype() {
    return preferencetype;
  }

  public void setPreferencetype(String preferencetype) {
    this.preferencetype = preferencetype;
  }

  public Role supervisorId(Integer supervisorId) {
    this.supervisorId = supervisorId;
    return this;
  }

  /**
   * Supervisor para este usuario - usado para escalación
   * @return supervisorId
   **/
  @Schema(description = "Supervisor para este usuario - usado para escalación")
  
    public Integer getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(Integer supervisorId) {
    this.supervisorId = supervisorId;
  }

  public Role updated(String updated) {
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

  public Role updatedby(Integer updatedby) {
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

  public Role userlevel(String userlevel) {
    this.userlevel = userlevel;
    return this;
  }

  /**
   * Sistema Compañía Organización
   * @return userlevel
   **/
  @Schema(description = "Sistema Compañía Organización")
  
    public String getUserlevel() {
    return userlevel;
  }

  public void setUserlevel(String userlevel) {
    this.userlevel = userlevel;
  }

  public Role viewpurchaseprice(Boolean viewpurchaseprice) {
    this.viewpurchaseprice = viewpurchaseprice;
    return this;
  }

  /**
   *  
   * @return viewpurchaseprice
   **/
  @Schema(description = " ")
  
    public Boolean isViewpurchaseprice() {
    return viewpurchaseprice;
  }

  public void setViewpurchaseprice(Boolean viewpurchaseprice) {
    this.viewpurchaseprice = viewpurchaseprice;
  }

  public Role viewsalesprice(Boolean viewsalesprice) {
    this.viewsalesprice = viewsalesprice;
    return this;
  }

  /**
   *  
   * @return viewsalesprice
   **/
  @Schema(description = " ")
  
    public Boolean isViewsalesprice() {
    return viewsalesprice;
  }

  public void setViewsalesprice(Boolean viewsalesprice) {
    this.viewsalesprice = viewsalesprice;
  }

  public Role additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Role addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Role referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Role addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Role role = (Role) o;
    return Objects.equals(this.adClientId, role.adClientId) &&
        Objects.equals(this.adComponentobjectuid, role.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, role.adComponentversionId) &&
        Objects.equals(this.addsecurityvalidationCreatefrominvoice, role.addsecurityvalidationCreatefrominvoice) &&
        Objects.equals(this.addsecurityvalidationCreatefromshipment, role.addsecurityvalidationCreatefromshipment) &&
        Objects.equals(this.addsecurityvalidationOprcNc, role.addsecurityvalidationOprcNc) &&
        Objects.equals(this.addsecurityvalidationPosNc, role.addsecurityvalidationPosNc) &&
        Objects.equals(this.adOrgId, role.adOrgId) &&
        Objects.equals(this.adRoleId, role.adRoleId) &&
        Objects.equals(this.adTreeMenuId, role.adTreeMenuId) &&
        Objects.equals(this.adTreeOrgId, role.adTreeOrgId) &&
        Objects.equals(this.allowInfoAccount, role.allowInfoAccount) &&
        Objects.equals(this.allowInfoAsset, role.allowInfoAsset) &&
        Objects.equals(this.allowInfoBpartner, role.allowInfoBpartner) &&
        Objects.equals(this.allowInfoCashjournal, role.allowInfoCashjournal) &&
        Objects.equals(this.allowInfoCrp, role.allowInfoCrp) &&
        Objects.equals(this.allowInfoInout, role.allowInfoInout) &&
        Objects.equals(this.allowInfoInvoice, role.allowInfoInvoice) &&
        Objects.equals(this.allowInfoMrp, role.allowInfoMrp) &&
        Objects.equals(this.allowInfoOrder, role.allowInfoOrder) &&
        Objects.equals(this.allowInfoPayment, role.allowInfoPayment) &&
        Objects.equals(this.allowInfoProduct, role.allowInfoProduct) &&
        Objects.equals(this.allowInfoProductOrderedTab, role.allowInfoProductOrderedTab) &&
        Objects.equals(this.allowInfoProductReservedTab, role.allowInfoProductReservedTab) &&
        Objects.equals(this.allowInfoResource, role.allowInfoResource) &&
        Objects.equals(this.allowInfoSchedule, role.allowInfoSchedule) &&
        Objects.equals(this.amtapproval, role.amtapproval) &&
        Objects.equals(this.applyreadonly, role.applyreadonly) &&
        Objects.equals(this.cCurrencyId, role.cCurrencyId) &&
        Objects.equals(this.confirmqueryrecords, role.confirmqueryrecords) &&
        Objects.equals(this.controlcuitlimit, role.controlcuitlimit) &&
        Objects.equals(this.controlcuitlimitclient, role.controlcuitlimitclient) &&
        Objects.equals(this.created, role.created) &&
        Objects.equals(this.createdby, role.createdby) &&
        Objects.equals(this.description, role.description) &&
        Objects.equals(this.isaccessallorgs, role.isaccessallorgs) &&
        Objects.equals(this.isactive, role.isactive) &&
        Objects.equals(this.isallowopa, role.isallowopa) &&
        Objects.equals(this.iscanapproveowndoc, role.iscanapproveowndoc) &&
        Objects.equals(this.iscanexport, role.iscanexport) &&
        Objects.equals(this.iscanreport, role.iscanreport) &&
        Objects.equals(this.ischangelog, role.ischangelog) &&
        Objects.equals(this.isinfoassetaccess, role.isinfoassetaccess) &&
        Objects.equals(this.isinfoassignmentaccess, role.isinfoassignmentaccess) &&
        Objects.equals(this.isinfobpartneraccess, role.isinfobpartneraccess) &&
        Objects.equals(this.isinfocashlineaccess, role.isinfocashlineaccess) &&
        Objects.equals(this.isinfoinoutaccess, role.isinfoinoutaccess) &&
        Objects.equals(this.isinfoinvoiceaccess, role.isinfoinvoiceaccess) &&
        Objects.equals(this.isinfoorderaccess, role.isinfoorderaccess) &&
        Objects.equals(this.isinfopaymentaccess, role.isinfopaymentaccess) &&
        Objects.equals(this.isinfoproductaccess, role.isinfoproductaccess) &&
        Objects.equals(this.isinfoscheduleaccess, role.isinfoscheduleaccess) &&
        Objects.equals(this.ismanual, role.ismanual) &&
        Objects.equals(this.ispersonalaccess, role.ispersonalaccess) &&
        Objects.equals(this.ispersonallock, role.ispersonallock) &&
        Objects.equals(this.isshowacct, role.isshowacct) &&
        Objects.equals(this.isuseuserorgaccess, role.isuseuserorgaccess) &&
        Objects.equals(this.lookupAllowBpartnerCreateMenu, role.lookupAllowBpartnerCreateMenu) &&
        Objects.equals(this.maxqueryrecords, role.maxqueryrecords) &&
        Objects.equals(this.name, role.name) &&
        Objects.equals(this.overwritepricelimit, role.overwritepricelimit) &&
        Objects.equals(this.paymentmedium, role.paymentmedium) &&
        Objects.equals(this.paymentmediumlimit, role.paymentmediumlimit) &&
        Objects.equals(this.posjournalsupervisor, role.posjournalsupervisor) &&
        Objects.equals(this.preferencetype, role.preferencetype) &&
        Objects.equals(this.supervisorId, role.supervisorId) &&
        Objects.equals(this.updated, role.updated) &&
        Objects.equals(this.updatedby, role.updatedby) &&
        Objects.equals(this.userlevel, role.userlevel) &&
        Objects.equals(this.viewpurchaseprice, role.viewpurchaseprice) &&
        Objects.equals(this.viewsalesprice, role.viewsalesprice) &&
        Objects.equals(this.additionalvalues, role.additionalvalues) &&
        Objects.equals(this.referencedvalues, role.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, addsecurityvalidationCreatefrominvoice, addsecurityvalidationCreatefromshipment, addsecurityvalidationOprcNc, addsecurityvalidationPosNc, adOrgId, adRoleId, adTreeMenuId, adTreeOrgId, allowInfoAccount, allowInfoAsset, allowInfoBpartner, allowInfoCashjournal, allowInfoCrp, allowInfoInout, allowInfoInvoice, allowInfoMrp, allowInfoOrder, allowInfoPayment, allowInfoProduct, allowInfoProductOrderedTab, allowInfoProductReservedTab, allowInfoResource, allowInfoSchedule, amtapproval, applyreadonly, cCurrencyId, confirmqueryrecords, controlcuitlimit, controlcuitlimitclient, created, createdby, description, isaccessallorgs, isactive, isallowopa, iscanapproveowndoc, iscanexport, iscanreport, ischangelog, isinfoassetaccess, isinfoassignmentaccess, isinfobpartneraccess, isinfocashlineaccess, isinfoinoutaccess, isinfoinvoiceaccess, isinfoorderaccess, isinfopaymentaccess, isinfoproductaccess, isinfoscheduleaccess, ismanual, ispersonalaccess, ispersonallock, isshowacct, isuseuserorgaccess, lookupAllowBpartnerCreateMenu, maxqueryrecords, name, overwritepricelimit, paymentmedium, paymentmediumlimit, posjournalsupervisor, preferencetype, supervisorId, updated, updatedby, userlevel, viewpurchaseprice, viewsalesprice, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Role {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    addsecurityvalidationCreatefrominvoice: ").append(toIndentedString(addsecurityvalidationCreatefrominvoice)).append("\n");
    sb.append("    addsecurityvalidationCreatefromshipment: ").append(toIndentedString(addsecurityvalidationCreatefromshipment)).append("\n");
    sb.append("    addsecurityvalidationOprcNc: ").append(toIndentedString(addsecurityvalidationOprcNc)).append("\n");
    sb.append("    addsecurityvalidationPosNc: ").append(toIndentedString(addsecurityvalidationPosNc)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adRoleId: ").append(toIndentedString(adRoleId)).append("\n");
    sb.append("    adTreeMenuId: ").append(toIndentedString(adTreeMenuId)).append("\n");
    sb.append("    adTreeOrgId: ").append(toIndentedString(adTreeOrgId)).append("\n");
    sb.append("    allowInfoAccount: ").append(toIndentedString(allowInfoAccount)).append("\n");
    sb.append("    allowInfoAsset: ").append(toIndentedString(allowInfoAsset)).append("\n");
    sb.append("    allowInfoBpartner: ").append(toIndentedString(allowInfoBpartner)).append("\n");
    sb.append("    allowInfoCashjournal: ").append(toIndentedString(allowInfoCashjournal)).append("\n");
    sb.append("    allowInfoCrp: ").append(toIndentedString(allowInfoCrp)).append("\n");
    sb.append("    allowInfoInout: ").append(toIndentedString(allowInfoInout)).append("\n");
    sb.append("    allowInfoInvoice: ").append(toIndentedString(allowInfoInvoice)).append("\n");
    sb.append("    allowInfoMrp: ").append(toIndentedString(allowInfoMrp)).append("\n");
    sb.append("    allowInfoOrder: ").append(toIndentedString(allowInfoOrder)).append("\n");
    sb.append("    allowInfoPayment: ").append(toIndentedString(allowInfoPayment)).append("\n");
    sb.append("    allowInfoProduct: ").append(toIndentedString(allowInfoProduct)).append("\n");
    sb.append("    allowInfoProductOrderedTab: ").append(toIndentedString(allowInfoProductOrderedTab)).append("\n");
    sb.append("    allowInfoProductReservedTab: ").append(toIndentedString(allowInfoProductReservedTab)).append("\n");
    sb.append("    allowInfoResource: ").append(toIndentedString(allowInfoResource)).append("\n");
    sb.append("    allowInfoSchedule: ").append(toIndentedString(allowInfoSchedule)).append("\n");
    sb.append("    amtapproval: ").append(toIndentedString(amtapproval)).append("\n");
    sb.append("    applyreadonly: ").append(toIndentedString(applyreadonly)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    confirmqueryrecords: ").append(toIndentedString(confirmqueryrecords)).append("\n");
    sb.append("    controlcuitlimit: ").append(toIndentedString(controlcuitlimit)).append("\n");
    sb.append("    controlcuitlimitclient: ").append(toIndentedString(controlcuitlimitclient)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isaccessallorgs: ").append(toIndentedString(isaccessallorgs)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isallowopa: ").append(toIndentedString(isallowopa)).append("\n");
    sb.append("    iscanapproveowndoc: ").append(toIndentedString(iscanapproveowndoc)).append("\n");
    sb.append("    iscanexport: ").append(toIndentedString(iscanexport)).append("\n");
    sb.append("    iscanreport: ").append(toIndentedString(iscanreport)).append("\n");
    sb.append("    ischangelog: ").append(toIndentedString(ischangelog)).append("\n");
    sb.append("    isinfoassetaccess: ").append(toIndentedString(isinfoassetaccess)).append("\n");
    sb.append("    isinfoassignmentaccess: ").append(toIndentedString(isinfoassignmentaccess)).append("\n");
    sb.append("    isinfobpartneraccess: ").append(toIndentedString(isinfobpartneraccess)).append("\n");
    sb.append("    isinfocashlineaccess: ").append(toIndentedString(isinfocashlineaccess)).append("\n");
    sb.append("    isinfoinoutaccess: ").append(toIndentedString(isinfoinoutaccess)).append("\n");
    sb.append("    isinfoinvoiceaccess: ").append(toIndentedString(isinfoinvoiceaccess)).append("\n");
    sb.append("    isinfoorderaccess: ").append(toIndentedString(isinfoorderaccess)).append("\n");
    sb.append("    isinfopaymentaccess: ").append(toIndentedString(isinfopaymentaccess)).append("\n");
    sb.append("    isinfoproductaccess: ").append(toIndentedString(isinfoproductaccess)).append("\n");
    sb.append("    isinfoscheduleaccess: ").append(toIndentedString(isinfoscheduleaccess)).append("\n");
    sb.append("    ismanual: ").append(toIndentedString(ismanual)).append("\n");
    sb.append("    ispersonalaccess: ").append(toIndentedString(ispersonalaccess)).append("\n");
    sb.append("    ispersonallock: ").append(toIndentedString(ispersonallock)).append("\n");
    sb.append("    isshowacct: ").append(toIndentedString(isshowacct)).append("\n");
    sb.append("    isuseuserorgaccess: ").append(toIndentedString(isuseuserorgaccess)).append("\n");
    sb.append("    lookupAllowBpartnerCreateMenu: ").append(toIndentedString(lookupAllowBpartnerCreateMenu)).append("\n");
    sb.append("    maxqueryrecords: ").append(toIndentedString(maxqueryrecords)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    overwritepricelimit: ").append(toIndentedString(overwritepricelimit)).append("\n");
    sb.append("    paymentmedium: ").append(toIndentedString(paymentmedium)).append("\n");
    sb.append("    paymentmediumlimit: ").append(toIndentedString(paymentmediumlimit)).append("\n");
    sb.append("    posjournalsupervisor: ").append(toIndentedString(posjournalsupervisor)).append("\n");
    sb.append("    preferencetype: ").append(toIndentedString(preferencetype)).append("\n");
    sb.append("    supervisorId: ").append(toIndentedString(supervisorId)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    userlevel: ").append(toIndentedString(userlevel)).append("\n");
    sb.append("    viewpurchaseprice: ").append(toIndentedString(viewpurchaseprice)).append("\n");
    sb.append("    viewsalesprice: ").append(toIndentedString(viewsalesprice)).append("\n");
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
