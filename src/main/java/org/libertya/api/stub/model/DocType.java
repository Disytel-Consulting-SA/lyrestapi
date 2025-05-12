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
 * DocType
 */
@Validated



public class DocType   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_printformat_id")
  private Integer adPrintformatId = null;

  @JsonProperty("ad_process_id")
  private Integer adProcessId = null;

  @JsonProperty("allowchangepricelist")
  private Boolean allowchangepricelist = null;

  @JsonProperty("allowdeliveryreturned")
  private Boolean allowdeliveryreturned = null;

  @JsonProperty("allowonlyproviders")
  private Boolean allowonlyproviders = null;

  @JsonProperty("allowotherbatchpaymentdate")
  private Boolean allowotherbatchpaymentdate = null;

  @JsonProperty("allowproposaldue")
  private Boolean allowproposaldue = null;

  @JsonProperty("applyperception")
  private Boolean applyperception = null;

  @JsonProperty("applyretention")
  private Boolean applyretention = null;

  @JsonProperty("cai")
  private String cai = null;

  @JsonProperty("caicontrol")
  private Boolean caicontrol = null;

  @JsonProperty("c_controlador_fiscal_id")
  private Integer cControladorFiscalId = null;

  @JsonProperty("c_doctypedifference_id")
  private Integer cDoctypedifferenceId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("c_doctypeinvoice_id")
  private Integer cDoctypeinvoiceId = null;

  @JsonProperty("c_doctypeproforma_id")
  private Integer cDoctypeproformaId = null;

  @JsonProperty("c_doctypeshipment_id")
  private Integer cDoctypeshipmentId = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_reversedoctype_id")
  private Integer cReversedoctypeId = null;

  @JsonProperty("datecai")
  private String datecai = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docbasetype")
  private String docbasetype = null;

  @JsonProperty("docnosequence_id")
  private Integer docnosequenceId = null;

  @JsonProperty("docnosequence_unique_id")
  private Integer docnosequenceUniqueId = null;

  @JsonProperty("docsubtypecae")
  private String docsubtypecae = null;

  @JsonProperty("docsubtypeinv")
  private String docsubtypeinv = null;

  @JsonProperty("docsubtypeso")
  private String docsubtypeso = null;

  @JsonProperty("doctypekey")
  private String doctypekey = null;

  @JsonProperty("documentcopies")
  private Integer documentcopies = null;

  @JsonProperty("documentnote")
  private String documentnote = null;

  @JsonProperty("dragorderdocumentdiscounts")
  private Boolean dragorderdocumentdiscounts = null;

  @JsonProperty("dragorderdocumentsurcharges")
  private Boolean dragorderdocumentsurcharges = null;

  @JsonProperty("dragorderlinediscounts")
  private Boolean dragorderlinediscounts = null;

  @JsonProperty("dragorderlinesurcharges")
  private Boolean dragorderlinesurcharges = null;

  @JsonProperty("dragorderprice")
  private Boolean dragorderprice = null;

  @JsonProperty("enabledinpos")
  private Boolean enabledinpos = null;

  @JsonProperty("enableincreatefromshipment")
  private Boolean enableincreatefromshipment = null;

  @JsonProperty("fiscaldocument")
  private String fiscaldocument = null;

  @JsonProperty("fiscalprintingfooterlegends")
  private String fiscalprintingfooterlegends = null;

  @JsonProperty("gl_category_id")
  private Integer glCategoryId = null;

  @JsonProperty("hascharges")
  private Boolean hascharges = null;

  @JsonProperty("hasproforma")
  private Boolean hasproforma = null;

  @JsonProperty("inout_allow_greater_qtyordered")
  private Boolean inoutAllowGreaterQtyordered = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("ischeckoutplacerestricted")
  private Boolean ischeckoutplacerestricted = null;

  @JsonProperty("iscreatecounter")
  private Boolean iscreatecounter = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("isdefaultcounterdoc")
  private Boolean isdefaultcounterdoc = null;

  @JsonProperty("isdocnocontrolled")
  private Boolean isdocnocontrolled = null;

  @JsonProperty("iselectronic")
  private Boolean iselectronic = null;

  @JsonProperty("isfiscal")
  private Boolean isfiscal = null;

  @JsonProperty("isfiscaldocument")
  private Boolean isfiscaldocument = null;

  @JsonProperty("isintransit")
  private Boolean isintransit = null;

  @JsonProperty("ispaymentorderseq")
  private Boolean ispaymentorderseq = null;

  @JsonProperty("ispickqaconfirm")
  private Boolean ispickqaconfirm = null;

  @JsonProperty("isprintatcompleting")
  private Boolean isprintatcompleting = null;

  @JsonProperty("isprintpreview")
  private Boolean isprintpreview = null;

  @JsonProperty("isreceiptseq")
  private Boolean isreceiptseq = null;

  @JsonProperty("isshipconfirm")
  private Boolean isshipconfirm = null;

  @JsonProperty("issotrx")
  private Boolean issotrx = null;

  @JsonProperty("issplitwhendifference")
  private Boolean issplitwhendifference = null;

  @JsonProperty("iswarehouseclosurecontrol")
  private Boolean iswarehouseclosurecontrol = null;

  @JsonProperty("linescountmax")
  private Integer linescountmax = null;

  @JsonProperty("lockseq")
  private Boolean lockseq = null;

  @JsonProperty("m_trannaturecodea_id")
  private BigDecimal mTrannaturecodeaId = null;

  @JsonProperty("m_trannaturecodeb_id")
  private BigDecimal mTrannaturecodebId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("notinvoiceable")
  private Boolean notinvoiceable = null;

  @JsonProperty("onlyvendorproducts")
  private Boolean onlyvendorproducts = null;

  @JsonProperty("open_close_by_pos")
  private Boolean openCloseByPos = null;

  @JsonProperty("posenabledue")
  private Boolean posenabledue = null;

  @JsonProperty("posenableduedays")
  private Integer posenableduedays = null;

  @JsonProperty("printername")
  private String printername = null;

  @JsonProperty("printname")
  private String printname = null;

  @JsonProperty("reservestockmanagment")
  private Boolean reservestockmanagment = null;

  @JsonProperty("reusedocumentno")
  private Boolean reusedocumentno = null;

  @JsonProperty("signo_issotrx")
  private String signoIssotrx = null;

  @JsonProperty("skipcurrentaccounts")
  private Boolean skipcurrentaccounts = null;

  @JsonProperty("transactiontypefrontliva")
  private String transactiontypefrontliva = null;

  @JsonProperty("uniquedocumentno")
  private Boolean uniquedocumentno = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("useorderwarehouse")
  private Boolean useorderwarehouse = null;

  @JsonProperty("validateseqlength")
  private Boolean validateseqlength = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public DocType adClientId(Integer adClientId) {
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

  public DocType adComponentobjectuid(String adComponentobjectuid) {
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

  public DocType adOrgId(Integer adOrgId) {
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

  public DocType adPrintformatId(Integer adPrintformatId) {
    this.adPrintformatId = adPrintformatId;
    return this;
  }

  /**
   * Formato de Impresión de datos
   * @return adPrintformatId
   **/
  @Schema(description = "Formato de Impresión de datos")
  
    public Integer getAdPrintformatId() {
    return adPrintformatId;
  }

  public void setAdPrintformatId(Integer adPrintformatId) {
    this.adPrintformatId = adPrintformatId;
  }

  public DocType adProcessId(Integer adProcessId) {
    this.adProcessId = adProcessId;
    return this;
  }

  /**
   * Proceso o Reporte
   * @return adProcessId
   **/
  @Schema(description = "Proceso o Reporte")
  
    public Integer getAdProcessId() {
    return adProcessId;
  }

  public void setAdProcessId(Integer adProcessId) {
    this.adProcessId = adProcessId;
  }

  public DocType allowchangepricelist(Boolean allowchangepricelist) {
    this.allowchangepricelist = allowchangepricelist;
    return this;
  }

  /**
   * Es posible modificar la tarifa del documento. Todos los precios de las líneas serán modificados.
   * @return allowchangepricelist
   **/
  @Schema(required = true, description = "Es posible modificar la tarifa del documento. Todos los precios de las líneas serán modificados.")
      @NotNull

    public Boolean isAllowchangepricelist() {
    return allowchangepricelist;
  }

  public void setAllowchangepricelist(Boolean allowchangepricelist) {
    this.allowchangepricelist = allowchangepricelist;
  }

  public DocType allowdeliveryreturned(Boolean allowdeliveryreturned) {
    this.allowdeliveryreturned = allowdeliveryreturned;
    return this;
  }

  /**
   * Permitir hacer entrega de artículos que fueron ingresados por Devoluciones
   * @return allowdeliveryreturned
   **/
  @Schema(required = true, description = "Permitir hacer entrega de artículos que fueron ingresados por Devoluciones")
      @NotNull

    public Boolean isAllowdeliveryreturned() {
    return allowdeliveryreturned;
  }

  public void setAllowdeliveryreturned(Boolean allowdeliveryreturned) {
    this.allowdeliveryreturned = allowdeliveryreturned;
  }

  public DocType allowonlyproviders(Boolean allowonlyproviders) {
    this.allowonlyproviders = allowonlyproviders;
    return this;
  }

  /**
   *  
   * @return allowonlyproviders
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAllowonlyproviders() {
    return allowonlyproviders;
  }

  public void setAllowonlyproviders(Boolean allowonlyproviders) {
    this.allowonlyproviders = allowonlyproviders;
  }

  public DocType allowotherbatchpaymentdate(Boolean allowotherbatchpaymentdate) {
    this.allowotherbatchpaymentdate = allowotherbatchpaymentdate;
    return this;
  }

  /**
   * Permitir Lote fuera de fecha, caso contrario setea la fecha actual automáticamente al procesar
   * @return allowotherbatchpaymentdate
   **/
  @Schema(required = true, description = "Permitir Lote fuera de fecha, caso contrario setea la fecha actual automáticamente al procesar")
      @NotNull

    public Boolean isAllowotherbatchpaymentdate() {
    return allowotherbatchpaymentdate;
  }

  public void setAllowotherbatchpaymentdate(Boolean allowotherbatchpaymentdate) {
    this.allowotherbatchpaymentdate = allowotherbatchpaymentdate;
  }

  public DocType allowproposaldue(Boolean allowproposaldue) {
    this.allowproposaldue = allowproposaldue;
    return this;
  }

  /**
   * Permitir crear documentos a partir de presupuestos vencidos
   * @return allowproposaldue
   **/
  @Schema(required = true, description = "Permitir crear documentos a partir de presupuestos vencidos")
      @NotNull

    public Boolean isAllowproposaldue() {
    return allowproposaldue;
  }

  public void setAllowproposaldue(Boolean allowproposaldue) {
    this.allowproposaldue = allowproposaldue;
  }

  public DocType applyperception(Boolean applyperception) {
    this.applyperception = applyperception;
    return this;
  }

  /**
   * Marca que permite o no aplicar percepciones automáticamente para comprobantes de ventas
   * @return applyperception
   **/
  @Schema(required = true, description = "Marca que permite o no aplicar percepciones automáticamente para comprobantes de ventas")
      @NotNull

    public Boolean isApplyperception() {
    return applyperception;
  }

  public void setApplyperception(Boolean applyperception) {
    this.applyperception = applyperception;
  }

  public DocType applyretention(Boolean applyretention) {
    this.applyretention = applyretention;
    return this;
  }

  /**
   *  
   * @return applyretention
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isApplyretention() {
    return applyretention;
  }

  public void setApplyretention(Boolean applyretention) {
    this.applyretention = applyretention;
  }

  public DocType cai(String cai) {
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

  public DocType caicontrol(Boolean caicontrol) {
    this.caicontrol = caicontrol;
    return this;
  }

  /**
   * Permite gestionar CAI del tipo de documento desde la ventana Gestión de CAI
   * @return caicontrol
   **/
  @Schema(required = true, description = "Permite gestionar CAI del tipo de documento desde la ventana Gestión de CAI")
      @NotNull

    public Boolean isCaicontrol() {
    return caicontrol;
  }

  public void setCaicontrol(Boolean caicontrol) {
    this.caicontrol = caicontrol;
  }

  public DocType cControladorFiscalId(Integer cControladorFiscalId) {
    this.cControladorFiscalId = cControladorFiscalId;
    return this;
  }

  /**
   *  
   * @return cControladorFiscalId
   **/
  @Schema(description = " ")
  
    public Integer getCControladorFiscalId() {
    return cControladorFiscalId;
  }

  public void setCControladorFiscalId(Integer cControladorFiscalId) {
    this.cControladorFiscalId = cControladorFiscalId;
  }

  public DocType cDoctypedifferenceId(Integer cDoctypedifferenceId) {
    this.cDoctypedifferenceId = cDoctypedifferenceId;
    return this;
  }

  /**
   * Documento de Diferencia para envios en disputa
   * @return cDoctypedifferenceId
   **/
  @Schema(description = "Documento de Diferencia para envios en disputa")
  
    public Integer getCDoctypedifferenceId() {
    return cDoctypedifferenceId;
  }

  public void setCDoctypedifferenceId(Integer cDoctypedifferenceId) {
    this.cDoctypedifferenceId = cDoctypedifferenceId;
  }

  public DocType cDoctypeId(Integer cDoctypeId) {
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

  public DocType cDoctypeinvoiceId(Integer cDoctypeinvoiceId) {
    this.cDoctypeinvoiceId = cDoctypeinvoiceId;
    return this;
  }

  /**
   * Tipo del documento usado para facturas generadas desde este documento de ventas
   * @return cDoctypeinvoiceId
   **/
  @Schema(description = "Tipo del documento usado para facturas generadas desde este documento de ventas")
  
    public Integer getCDoctypeinvoiceId() {
    return cDoctypeinvoiceId;
  }

  public void setCDoctypeinvoiceId(Integer cDoctypeinvoiceId) {
    this.cDoctypeinvoiceId = cDoctypeinvoiceId;
  }

  public DocType cDoctypeproformaId(Integer cDoctypeproformaId) {
    this.cDoctypeproformaId = cDoctypeproformaId;
    return this;
  }

  /**
   * Tipo del documento usado para facturas pro forma generadas desde este documento de ventas
   * @return cDoctypeproformaId
   **/
  @Schema(description = "Tipo del documento usado para facturas pro forma generadas desde este documento de ventas")
  
    public Integer getCDoctypeproformaId() {
    return cDoctypeproformaId;
  }

  public void setCDoctypeproformaId(Integer cDoctypeproformaId) {
    this.cDoctypeproformaId = cDoctypeproformaId;
  }

  public DocType cDoctypeshipmentId(Integer cDoctypeshipmentId) {
    this.cDoctypeshipmentId = cDoctypeshipmentId;
    return this;
  }

  /**
   * Tipo del documento usado para la entrega generados desde este documento de ventas
   * @return cDoctypeshipmentId
   **/
  @Schema(description = "Tipo del documento usado para la entrega generados desde este documento de ventas")
  
    public Integer getCDoctypeshipmentId() {
    return cDoctypeshipmentId;
  }

  public void setCDoctypeshipmentId(Integer cDoctypeshipmentId) {
    this.cDoctypeshipmentId = cDoctypeshipmentId;
  }

  public DocType cInvoiceId(Integer cInvoiceId) {
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

  public DocType created(String created) {
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

  public DocType createdby(Integer createdby) {
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

  public DocType cReversedoctypeId(Integer cReversedoctypeId) {
    this.cReversedoctypeId = cReversedoctypeId;
    return this;
  }

  /**
   *  
   * @return cReversedoctypeId
   **/
  @Schema(description = " ")
  
    public Integer getCReversedoctypeId() {
    return cReversedoctypeId;
  }

  public void setCReversedoctypeId(Integer cReversedoctypeId) {
    this.cReversedoctypeId = cReversedoctypeId;
  }

  public DocType datecai(String datecai) {
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

  public DocType description(String description) {
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

  public DocType docbasetype(String docbasetype) {
    this.docbasetype = docbasetype;
    return this;
  }

  /**
   * Identifica el punto de inicio para un documento
   * @return docbasetype
   **/
  @Schema(required = true, description = "Identifica el punto de inicio para un documento")
      @NotNull

    public String getDocbasetype() {
    return docbasetype;
  }

  public void setDocbasetype(String docbasetype) {
    this.docbasetype = docbasetype;
  }

  public DocType docnosequenceId(Integer docnosequenceId) {
    this.docnosequenceId = docnosequenceId;
    return this;
  }

  /**
   * La secuencia del documento determina la numeración del documento
   * @return docnosequenceId
   **/
  @Schema(description = "La secuencia del documento determina la numeración del documento")
  
    public Integer getDocnosequenceId() {
    return docnosequenceId;
  }

  public void setDocnosequenceId(Integer docnosequenceId) {
    this.docnosequenceId = docnosequenceId;
  }

  public DocType docnosequenceUniqueId(Integer docnosequenceUniqueId) {
    this.docnosequenceUniqueId = docnosequenceUniqueId;
    return this;
  }

  /**
   *  
   * @return docnosequenceUniqueId
   **/
  @Schema(description = " ")
  
    public Integer getDocnosequenceUniqueId() {
    return docnosequenceUniqueId;
  }

  public void setDocnosequenceUniqueId(Integer docnosequenceUniqueId) {
    this.docnosequenceUniqueId = docnosequenceUniqueId;
  }

  public DocType docsubtypecae(String docsubtypecae) {
    this.docsubtypecae = docsubtypecae;
    return this;
  }

  /**
   *  
   * @return docsubtypecae
   **/
  @Schema(description = " ")
  
    public String getDocsubtypecae() {
    return docsubtypecae;
  }

  public void setDocsubtypecae(String docsubtypecae) {
    this.docsubtypecae = docsubtypecae;
  }

  public DocType docsubtypeinv(String docsubtypeinv) {
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

  public DocType docsubtypeso(String docsubtypeso) {
    this.docsubtypeso = docsubtypeso;
    return this;
  }

  /**
   * Subtipo Pedido de Cliente
   * @return docsubtypeso
   **/
  @Schema(description = "Subtipo Pedido de Cliente")
  
    public String getDocsubtypeso() {
    return docsubtypeso;
  }

  public void setDocsubtypeso(String docsubtypeso) {
    this.docsubtypeso = docsubtypeso;
  }

  public DocType doctypekey(String doctypekey) {
    this.doctypekey = doctypekey;
    return this;
  }

  /**
   * Clave única de identificación del tipo de documento
   * @return doctypekey
   **/
  @Schema(required = true, description = "Clave única de identificación del tipo de documento")
      @NotNull

    public String getDoctypekey() {
    return doctypekey;
  }

  public void setDoctypekey(String doctypekey) {
    this.doctypekey = doctypekey;
  }

  public DocType documentcopies(Integer documentcopies) {
    this.documentcopies = documentcopies;
    return this;
  }

  /**
   * Número de copias a ser impresas
   * @return documentcopies
   **/
  @Schema(required = true, description = "Número de copias a ser impresas")
      @NotNull

    public Integer getDocumentcopies() {
    return documentcopies;
  }

  public void setDocumentcopies(Integer documentcopies) {
    this.documentcopies = documentcopies;
  }

  public DocType documentnote(String documentnote) {
    this.documentnote = documentnote;
    return this;
  }

  /**
   * Información adicional para un Documento
   * @return documentnote
   **/
  @Schema(description = "Información adicional para un Documento")
  
    public String getDocumentnote() {
    return documentnote;
  }

  public void setDocumentnote(String documentnote) {
    this.documentnote = documentnote;
  }

  public DocType dragorderdocumentdiscounts(Boolean dragorderdocumentdiscounts) {
    this.dragorderdocumentdiscounts = dragorderdocumentdiscounts;
    return this;
  }

  /**
   * Arrastrar descuentos de nivel de documento aplicados en el pedido
   * @return dragorderdocumentdiscounts
   **/
  @Schema(required = true, description = "Arrastrar descuentos de nivel de documento aplicados en el pedido")
      @NotNull

    public Boolean isDragorderdocumentdiscounts() {
    return dragorderdocumentdiscounts;
  }

  public void setDragorderdocumentdiscounts(Boolean dragorderdocumentdiscounts) {
    this.dragorderdocumentdiscounts = dragorderdocumentdiscounts;
  }

  public DocType dragorderdocumentsurcharges(Boolean dragorderdocumentsurcharges) {
    this.dragorderdocumentsurcharges = dragorderdocumentsurcharges;
    return this;
  }

  /**
   * Arrastrar recargos de nivel de documento aplicados en el pedido
   * @return dragorderdocumentsurcharges
   **/
  @Schema(required = true, description = "Arrastrar recargos de nivel de documento aplicados en el pedido")
      @NotNull

    public Boolean isDragorderdocumentsurcharges() {
    return dragorderdocumentsurcharges;
  }

  public void setDragorderdocumentsurcharges(Boolean dragorderdocumentsurcharges) {
    this.dragorderdocumentsurcharges = dragorderdocumentsurcharges;
  }

  public DocType dragorderlinediscounts(Boolean dragorderlinediscounts) {
    this.dragorderlinediscounts = dragorderlinediscounts;
    return this;
  }

  /**
   * Arrastrar descuentos de nivel de línea del pedido
   * @return dragorderlinediscounts
   **/
  @Schema(required = true, description = "Arrastrar descuentos de nivel de línea del pedido")
      @NotNull

    public Boolean isDragorderlinediscounts() {
    return dragorderlinediscounts;
  }

  public void setDragorderlinediscounts(Boolean dragorderlinediscounts) {
    this.dragorderlinediscounts = dragorderlinediscounts;
  }

  public DocType dragorderlinesurcharges(Boolean dragorderlinesurcharges) {
    this.dragorderlinesurcharges = dragorderlinesurcharges;
    return this;
  }

  /**
   * Arrastrar recargos de nivel de línea del pedido
   * @return dragorderlinesurcharges
   **/
  @Schema(required = true, description = "Arrastrar recargos de nivel de línea del pedido")
      @NotNull

    public Boolean isDragorderlinesurcharges() {
    return dragorderlinesurcharges;
  }

  public void setDragorderlinesurcharges(Boolean dragorderlinesurcharges) {
    this.dragorderlinesurcharges = dragorderlinesurcharges;
  }

  public DocType dragorderprice(Boolean dragorderprice) {
    this.dragorderprice = dragorderprice;
    return this;
  }

  /**
   * Arrastrar precios del pedido
   * @return dragorderprice
   **/
  @Schema(required = true, description = "Arrastrar precios del pedido")
      @NotNull

    public Boolean isDragorderprice() {
    return dragorderprice;
  }

  public void setDragorderprice(Boolean dragorderprice) {
    this.dragorderprice = dragorderprice;
  }

  public DocType enabledinpos(Boolean enabledinpos) {
    this.enabledinpos = enabledinpos;
    return this;
  }

  /**
   * Uso del documento habilitado en el TPV
   * @return enabledinpos
   **/
  @Schema(required = true, description = "Uso del documento habilitado en el TPV")
      @NotNull

    public Boolean isEnabledinpos() {
    return enabledinpos;
  }

  public void setEnabledinpos(Boolean enabledinpos) {
    this.enabledinpos = enabledinpos;
  }

  public DocType enableincreatefromshipment(Boolean enableincreatefromshipment) {
    this.enableincreatefromshipment = enableincreatefromshipment;
    return this;
  }

  /**
   * Habilitado para la creación de Remitos a partir de este documento
   * @return enableincreatefromshipment
   **/
  @Schema(required = true, description = "Habilitado para la creación de Remitos a partir de este documento")
      @NotNull

    public Boolean isEnableincreatefromshipment() {
    return enableincreatefromshipment;
  }

  public void setEnableincreatefromshipment(Boolean enableincreatefromshipment) {
    this.enableincreatefromshipment = enableincreatefromshipment;
  }

  public DocType fiscaldocument(String fiscaldocument) {
    this.fiscaldocument = fiscaldocument;
    return this;
  }

  /**
   * Tipo de comprobante a emitir por el controlador fiscal
   * @return fiscaldocument
   **/
  @Schema(required = true, description = "Tipo de comprobante a emitir por el controlador fiscal")
      @NotNull

    public String getFiscaldocument() {
    return fiscaldocument;
  }

  public void setFiscaldocument(String fiscaldocument) {
    this.fiscaldocument = fiscaldocument;
  }

  public DocType fiscalprintingfooterlegends(String fiscalprintingfooterlegends) {
    this.fiscalprintingfooterlegends = fiscalprintingfooterlegends;
    return this;
  }

  /**
   * Las leyendas de la impresión fiscal se deben agregar separadas por el caracter punto y coma (;)
   * @return fiscalprintingfooterlegends
   **/
  @Schema(description = "Las leyendas de la impresión fiscal se deben agregar separadas por el caracter punto y coma (;)")
  
    public String getFiscalprintingfooterlegends() {
    return fiscalprintingfooterlegends;
  }

  public void setFiscalprintingfooterlegends(String fiscalprintingfooterlegends) {
    this.fiscalprintingfooterlegends = fiscalprintingfooterlegends;
  }

  public DocType glCategoryId(Integer glCategoryId) {
    this.glCategoryId = glCategoryId;
    return this;
  }

  /**
   * Categoría de Contabilidad General
   * @return glCategoryId
   **/
  @Schema(required = true, description = "Categoría de Contabilidad General")
      @NotNull

    public Integer getGlCategoryId() {
    return glCategoryId;
  }

  public void setGlCategoryId(Integer glCategoryId) {
    this.glCategoryId = glCategoryId;
  }

  public DocType hascharges(Boolean hascharges) {
    this.hascharges = hascharges;
    return this;
  }

  /**
   * Cargos pueden ser agregados al documento
   * @return hascharges
   **/
  @Schema(required = true, description = "Cargos pueden ser agregados al documento")
      @NotNull

    public Boolean isHascharges() {
    return hascharges;
  }

  public void setHascharges(Boolean hascharges) {
    this.hascharges = hascharges;
  }

  public DocType hasproforma(Boolean hasproforma) {
    this.hasproforma = hasproforma;
    return this;
  }

  /**
   * Indica si facturas Pro Forma pueden ser generadas desde este documento
   * @return hasproforma
   **/
  @Schema(description = "Indica si facturas Pro Forma pueden ser generadas desde este documento")
  
    public Boolean isHasproforma() {
    return hasproforma;
  }

  public void setHasproforma(Boolean hasproforma) {
    this.hasproforma = hasproforma;
  }

  public DocType inoutAllowGreaterQtyordered(Boolean inoutAllowGreaterQtyordered) {
    this.inoutAllowGreaterQtyordered = inoutAllowGreaterQtyordered;
    return this;
  }

  /**
   * Permitir Cantidades Mayores a Líneas de Pedido
   * @return inoutAllowGreaterQtyordered
   **/
  @Schema(required = true, description = "Permitir Cantidades Mayores a Líneas de Pedido")
      @NotNull

    public Boolean isInoutAllowGreaterQtyordered() {
    return inoutAllowGreaterQtyordered;
  }

  public void setInoutAllowGreaterQtyordered(Boolean inoutAllowGreaterQtyordered) {
    this.inoutAllowGreaterQtyordered = inoutAllowGreaterQtyordered;
  }

  public DocType isactive(Boolean isactive) {
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

  public DocType ischeckoutplacerestricted(Boolean ischeckoutplacerestricted) {
    this.ischeckoutplacerestricted = ischeckoutplacerestricted;
    return this;
  }

  /**
   * Valida que los artículos agregados al documento sean retirados por Almacén o Ambos (Almacén + TPV)
   * @return ischeckoutplacerestricted
   **/
  @Schema(required = true, description = "Valida que los artículos agregados al documento sean retirados por Almacén o Ambos (Almacén + TPV)")
      @NotNull

    public Boolean isIscheckoutplacerestricted() {
    return ischeckoutplacerestricted;
  }

  public void setIscheckoutplacerestricted(Boolean ischeckoutplacerestricted) {
    this.ischeckoutplacerestricted = ischeckoutplacerestricted;
  }

  public DocType iscreatecounter(Boolean iscreatecounter) {
    this.iscreatecounter = iscreatecounter;
    return this;
  }

  /**
   * Crear Documento Asociado
   * @return iscreatecounter
   **/
  @Schema(required = true, description = "Crear Documento Asociado")
      @NotNull

    public Boolean isIscreatecounter() {
    return iscreatecounter;
  }

  public void setIscreatecounter(Boolean iscreatecounter) {
    this.iscreatecounter = iscreatecounter;
  }

  public DocType isdefault(Boolean isdefault) {
    this.isdefault = isdefault;
    return this;
  }

  /**
   * Valor Predeterminado
   * @return isdefault
   **/
  @Schema(required = true, description = "Valor Predeterminado")
      @NotNull

    public Boolean isIsdefault() {
    return isdefault;
  }

  public void setIsdefault(Boolean isdefault) {
    this.isdefault = isdefault;
  }

  public DocType isdefaultcounterdoc(Boolean isdefaultcounterdoc) {
    this.isdefaultcounterdoc = isdefaultcounterdoc;
    return this;
  }

  /**
   * Contrapartida por Defecto
   * @return isdefaultcounterdoc
   **/
  @Schema(required = true, description = "Contrapartida por Defecto")
      @NotNull

    public Boolean isIsdefaultcounterdoc() {
    return isdefaultcounterdoc;
  }

  public void setIsdefaultcounterdoc(Boolean isdefaultcounterdoc) {
    this.isdefaultcounterdoc = isdefaultcounterdoc;
  }

  public DocType isdocnocontrolled(Boolean isdocnocontrolled) {
    this.isdocnocontrolled = isdocnocontrolled;
    return this;
  }

  /**
   * El documento tiene una secuencia de documento
   * @return isdocnocontrolled
   **/
  @Schema(required = true, description = "El documento tiene una secuencia de documento")
      @NotNull

    public Boolean isIsdocnocontrolled() {
    return isdocnocontrolled;
  }

  public void setIsdocnocontrolled(Boolean isdocnocontrolled) {
    this.isdocnocontrolled = isdocnocontrolled;
  }

  public DocType iselectronic(Boolean iselectronic) {
    this.iselectronic = iselectronic;
    return this;
  }

  /**
   *  
   * @return iselectronic
   **/
  @Schema(description = " ")
  
    public Boolean isIselectronic() {
    return iselectronic;
  }

  public void setIselectronic(Boolean iselectronic) {
    this.iselectronic = iselectronic;
  }

  public DocType isfiscal(Boolean isfiscal) {
    this.isfiscal = isfiscal;
    return this;
  }

  /**
   *  
   * @return isfiscal
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsfiscal() {
    return isfiscal;
  }

  public void setIsfiscal(Boolean isfiscal) {
    this.isfiscal = isfiscal;
  }

  public DocType isfiscaldocument(Boolean isfiscaldocument) {
    this.isfiscaldocument = isfiscaldocument;
    return this;
  }

  /**
   * Un Documento Fiscal tiene asociadas una serie de validación que dependen de cada Localización
   * @return isfiscaldocument
   **/
  @Schema(required = true, description = "Un Documento Fiscal tiene asociadas una serie de validación que dependen de cada Localización")
      @NotNull

    public Boolean isIsfiscaldocument() {
    return isfiscaldocument;
  }

  public void setIsfiscaldocument(Boolean isfiscaldocument) {
    this.isfiscaldocument = isfiscaldocument;
  }

  public DocType isintransit(Boolean isintransit) {
    this.isintransit = isintransit;
    return this;
  }

  /**
   * El Movimiento de Material esta en Tránsito
   * @return isintransit
   **/
  @Schema(required = true, description = "El Movimiento de Material esta en Tránsito")
      @NotNull

    public Boolean isIsintransit() {
    return isintransit;
  }

  public void setIsintransit(Boolean isintransit) {
    this.isintransit = isintransit;
  }

  public DocType ispaymentorderseq(Boolean ispaymentorderseq) {
    this.ispaymentorderseq = ispaymentorderseq;
    return this;
  }

  /**
   *  
   * @return ispaymentorderseq
   **/
  @Schema(description = " ")
  
    public Boolean isIspaymentorderseq() {
    return ispaymentorderseq;
  }

  public void setIspaymentorderseq(Boolean ispaymentorderseq) {
    this.ispaymentorderseq = ispaymentorderseq;
  }

  public DocType ispickqaconfirm(Boolean ispickqaconfirm) {
    this.ispickqaconfirm = ispickqaconfirm;
    return this;
  }

  /**
   * Requiere Confirmación de Recogida antes de procesar
   * @return ispickqaconfirm
   **/
  @Schema(required = true, description = "Requiere Confirmación de Recogida antes de procesar")
      @NotNull

    public Boolean isIspickqaconfirm() {
    return ispickqaconfirm;
  }

  public void setIspickqaconfirm(Boolean ispickqaconfirm) {
    this.ispickqaconfirm = ispickqaconfirm;
  }

  public DocType isprintatcompleting(Boolean isprintatcompleting) {
    this.isprintatcompleting = isprintatcompleting;
    return this;
  }

  /**
   * El documento se imprimirá cuando se haya completado.
   * @return isprintatcompleting
   **/
  @Schema(required = true, description = "El documento se imprimirá cuando se haya completado.")
      @NotNull

    public Boolean isIsprintatcompleting() {
    return isprintatcompleting;
  }

  public void setIsprintatcompleting(Boolean isprintatcompleting) {
    this.isprintatcompleting = isprintatcompleting;
  }

  public DocType isprintpreview(Boolean isprintpreview) {
    this.isprintpreview = isprintpreview;
    return this;
  }

  /**
   *  
   * @return isprintpreview
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsprintpreview() {
    return isprintpreview;
  }

  public void setIsprintpreview(Boolean isprintpreview) {
    this.isprintpreview = isprintpreview;
  }

  public DocType isreceiptseq(Boolean isreceiptseq) {
    this.isreceiptseq = isreceiptseq;
    return this;
  }

  /**
   *  
   * @return isreceiptseq
   **/
  @Schema(description = " ")
  
    public Boolean isIsreceiptseq() {
    return isreceiptseq;
  }

  public void setIsreceiptseq(Boolean isreceiptseq) {
    this.isreceiptseq = isreceiptseq;
  }

  public DocType isshipconfirm(Boolean isshipconfirm) {
    this.isshipconfirm = isshipconfirm;
    return this;
  }

  /**
   * Pedir Confirmación Envio/Recogida antes de procesar
   * @return isshipconfirm
   **/
  @Schema(required = true, description = "Pedir Confirmación Envio/Recogida antes de procesar")
      @NotNull

    public Boolean isIsshipconfirm() {
    return isshipconfirm;
  }

  public void setIsshipconfirm(Boolean isshipconfirm) {
    this.isshipconfirm = isshipconfirm;
  }

  public DocType issotrx(Boolean issotrx) {
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

  public DocType issplitwhendifference(Boolean issplitwhendifference) {
    this.issplitwhendifference = issplitwhendifference;
    return this;
  }

  /**
   * Dividir el documento si hay diferencia
   * @return issplitwhendifference
   **/
  @Schema(required = true, description = "Dividir el documento si hay diferencia")
      @NotNull

    public Boolean isIssplitwhendifference() {
    return issplitwhendifference;
  }

  public void setIssplitwhendifference(Boolean issplitwhendifference) {
    this.issplitwhendifference = issplitwhendifference;
  }

  public DocType iswarehouseclosurecontrol(Boolean iswarehouseclosurecontrol) {
    this.iswarehouseclosurecontrol = iswarehouseclosurecontrol;
    return this;
  }

  /**
   * Se debe realizar el control de Cierre de Depósito cuando este está activado
   * @return iswarehouseclosurecontrol
   **/
  @Schema(required = true, description = "Se debe realizar el control de Cierre de Depósito cuando este está activado")
      @NotNull

    public Boolean isIswarehouseclosurecontrol() {
    return iswarehouseclosurecontrol;
  }

  public void setIswarehouseclosurecontrol(Boolean iswarehouseclosurecontrol) {
    this.iswarehouseclosurecontrol = iswarehouseclosurecontrol;
  }

  public DocType linescountmax(Integer linescountmax) {
    this.linescountmax = linescountmax;
    return this;
  }

  /**
   * Cantidad máxima de líneas del documento
   * @return linescountmax
   **/
  @Schema(required = true, description = "Cantidad máxima de líneas del documento")
      @NotNull

    public Integer getLinescountmax() {
    return linescountmax;
  }

  public void setLinescountmax(Integer linescountmax) {
    this.linescountmax = linescountmax;
  }

  public DocType lockseq(Boolean lockseq) {
    this.lockseq = lockseq;
    return this;
  }

  /**
   * Activar Bloqueo de Secuencia del Documento
   * @return lockseq
   **/
  @Schema(required = true, description = "Activar Bloqueo de Secuencia del Documento")
      @NotNull

    public Boolean isLockseq() {
    return lockseq;
  }

  public void setLockseq(Boolean lockseq) {
    this.lockseq = lockseq;
  }

  public DocType mTrannaturecodeaId(BigDecimal mTrannaturecodeaId) {
    this.mTrannaturecodeaId = mTrannaturecodeaId;
    return this;
  }

  /**
   *  
   * @return mTrannaturecodeaId
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getMTrannaturecodeaId() {
    return mTrannaturecodeaId;
  }

  public void setMTrannaturecodeaId(BigDecimal mTrannaturecodeaId) {
    this.mTrannaturecodeaId = mTrannaturecodeaId;
  }

  public DocType mTrannaturecodebId(BigDecimal mTrannaturecodebId) {
    this.mTrannaturecodebId = mTrannaturecodebId;
    return this;
  }

  /**
   *  
   * @return mTrannaturecodebId
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getMTrannaturecodebId() {
    return mTrannaturecodebId;
  }

  public void setMTrannaturecodebId(BigDecimal mTrannaturecodebId) {
    this.mTrannaturecodebId = mTrannaturecodebId;
  }

  public DocType name(String name) {
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

  public DocType notinvoiceable(Boolean notinvoiceable) {
    this.notinvoiceable = notinvoiceable;
    return this;
  }

  /**
   * No Facturable
   * @return notinvoiceable
   **/
  @Schema(required = true, description = "No Facturable")
      @NotNull

    public Boolean isNotinvoiceable() {
    return notinvoiceable;
  }

  public void setNotinvoiceable(Boolean notinvoiceable) {
    this.notinvoiceable = notinvoiceable;
  }

  public DocType onlyvendorproducts(Boolean onlyvendorproducts) {
    this.onlyvendorproducts = onlyvendorproducts;
    return this;
  }

  /**
   * Sólo es posible utilizar artículos del proveedor del pedido.
   * @return onlyvendorproducts
   **/
  @Schema(required = true, description = "Sólo es posible utilizar artículos del proveedor del pedido.")
      @NotNull

    public Boolean isOnlyvendorproducts() {
    return onlyvendorproducts;
  }

  public void setOnlyvendorproducts(Boolean onlyvendorproducts) {
    this.onlyvendorproducts = onlyvendorproducts;
  }

  public DocType openCloseByPos(Boolean openCloseByPos) {
    this.openCloseByPos = openCloseByPos;
    return this;
  }

  /**
   *  
   * @return openCloseByPos
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isOpenCloseByPos() {
    return openCloseByPos;
  }

  public void setOpenCloseByPos(Boolean openCloseByPos) {
    this.openCloseByPos = openCloseByPos;
  }

  public DocType posenabledue(Boolean posenabledue) {
    this.posenabledue = posenabledue;
    return this;
  }

  /**
   * Documento donde su habilitación en el TPV tiene vencimiento
   * @return posenabledue
   **/
  @Schema(required = true, description = "Documento donde su habilitación en el TPV tiene vencimiento")
      @NotNull

    public Boolean isPosenabledue() {
    return posenabledue;
  }

  public void setPosenabledue(Boolean posenabledue) {
    this.posenabledue = posenabledue;
  }

  public DocType posenableduedays(Integer posenableduedays) {
    this.posenableduedays = posenableduedays;
    return this;
  }

  /**
   * Cantidad de días luego de la fecha de la transacción en que se encuentra habilitado para ser utilizado en el TPV
   * @return posenableduedays
   **/
  @Schema(required = true, description = "Cantidad de días luego de la fecha de la transacción en que se encuentra habilitado para ser utilizado en el TPV")
      @NotNull

    public Integer getPosenableduedays() {
    return posenableduedays;
  }

  public void setPosenableduedays(Integer posenableduedays) {
    this.posenableduedays = posenableduedays;
  }

  public DocType printername(String printername) {
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

  public DocType printname(String printname) {
    this.printname = printname;
    return this;
  }

  /**
   * Texto a Imprimir
   * @return printname
   **/
  @Schema(required = true, description = "Texto a Imprimir")
      @NotNull

    public String getPrintname() {
    return printname;
  }

  public void setPrintname(String printname) {
    this.printname = printname;
  }

  public DocType reservestockmanagment(Boolean reservestockmanagment) {
    this.reservestockmanagment = reservestockmanagment;
    return this;
  }

  /**
   * Gestionar cantidades reservadas de pedidos y del stock
   * @return reservestockmanagment
   **/
  @Schema(required = true, description = "Gestionar cantidades reservadas de pedidos y del stock")
      @NotNull

    public Boolean isReservestockmanagment() {
    return reservestockmanagment;
  }

  public void setReservestockmanagment(Boolean reservestockmanagment) {
    this.reservestockmanagment = reservestockmanagment;
  }

  public DocType reusedocumentno(Boolean reusedocumentno) {
    this.reusedocumentno = reusedocumentno;
    return this;
  }

  /**
   *  
   * @return reusedocumentno
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isReusedocumentno() {
    return reusedocumentno;
  }

  public void setReusedocumentno(Boolean reusedocumentno) {
    this.reusedocumentno = reusedocumentno;
  }

  public DocType signoIssotrx(String signoIssotrx) {
    this.signoIssotrx = signoIssotrx;
    return this;
  }

  /**
   *  
   * @return signoIssotrx
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getSignoIssotrx() {
    return signoIssotrx;
  }

  public void setSignoIssotrx(String signoIssotrx) {
    this.signoIssotrx = signoIssotrx;
  }

  public DocType skipcurrentaccounts(Boolean skipcurrentaccounts) {
    this.skipcurrentaccounts = skipcurrentaccounts;
    return this;
  }

  /**
   * Omitir validaciones y actualizaciones relacionadas a Cuenta Corriente
   * @return skipcurrentaccounts
   **/
  @Schema(required = true, description = "Omitir validaciones y actualizaciones relacionadas a Cuenta Corriente")
      @NotNull

    public Boolean isSkipcurrentaccounts() {
    return skipcurrentaccounts;
  }

  public void setSkipcurrentaccounts(Boolean skipcurrentaccounts) {
    this.skipcurrentaccounts = skipcurrentaccounts;
  }

  public DocType transactiontypefrontliva(String transactiontypefrontliva) {
    this.transactiontypefrontliva = transactiontypefrontliva;
    return this;
  }

  /**
   * Tipo de transacción frente al libro de iva
   * @return transactiontypefrontliva
   **/
  @Schema(description = "Tipo de transacción frente al libro de iva")
  
    public String getTransactiontypefrontliva() {
    return transactiontypefrontliva;
  }

  public void setTransactiontypefrontliva(String transactiontypefrontliva) {
    this.transactiontypefrontliva = transactiontypefrontliva;
  }

  public DocType uniquedocumentno(Boolean uniquedocumentno) {
    this.uniquedocumentno = uniquedocumentno;
    return this;
  }

  /**
   *  
   * @return uniquedocumentno
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isUniquedocumentno() {
    return uniquedocumentno;
  }

  public void setUniquedocumentno(Boolean uniquedocumentno) {
    this.uniquedocumentno = uniquedocumentno;
  }

  public DocType updated(String updated) {
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

  public DocType updatedby(Integer updatedby) {
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

  public DocType useorderwarehouse(Boolean useorderwarehouse) {
    this.useorderwarehouse = useorderwarehouse;
    return this;
  }

  /**
   *  
   * @return useorderwarehouse
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isUseorderwarehouse() {
    return useorderwarehouse;
  }

  public void setUseorderwarehouse(Boolean useorderwarehouse) {
    this.useorderwarehouse = useorderwarehouse;
  }

  public DocType validateseqlength(Boolean validateseqlength) {
    this.validateseqlength = validateseqlength;
    return this;
  }

  /**
   *  
   * @return validateseqlength
   **/
  @Schema(description = " ")
  
    public Boolean isValidateseqlength() {
    return validateseqlength;
  }

  public void setValidateseqlength(Boolean validateseqlength) {
    this.validateseqlength = validateseqlength;
  }

  public DocType additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public DocType addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public DocType referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public DocType addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    DocType docType = (DocType) o;
    return Objects.equals(this.adClientId, docType.adClientId) &&
        Objects.equals(this.adComponentobjectuid, docType.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, docType.adOrgId) &&
        Objects.equals(this.adPrintformatId, docType.adPrintformatId) &&
        Objects.equals(this.adProcessId, docType.adProcessId) &&
        Objects.equals(this.allowchangepricelist, docType.allowchangepricelist) &&
        Objects.equals(this.allowdeliveryreturned, docType.allowdeliveryreturned) &&
        Objects.equals(this.allowonlyproviders, docType.allowonlyproviders) &&
        Objects.equals(this.allowotherbatchpaymentdate, docType.allowotherbatchpaymentdate) &&
        Objects.equals(this.allowproposaldue, docType.allowproposaldue) &&
        Objects.equals(this.applyperception, docType.applyperception) &&
        Objects.equals(this.applyretention, docType.applyretention) &&
        Objects.equals(this.cai, docType.cai) &&
        Objects.equals(this.caicontrol, docType.caicontrol) &&
        Objects.equals(this.cControladorFiscalId, docType.cControladorFiscalId) &&
        Objects.equals(this.cDoctypedifferenceId, docType.cDoctypedifferenceId) &&
        Objects.equals(this.cDoctypeId, docType.cDoctypeId) &&
        Objects.equals(this.cDoctypeinvoiceId, docType.cDoctypeinvoiceId) &&
        Objects.equals(this.cDoctypeproformaId, docType.cDoctypeproformaId) &&
        Objects.equals(this.cDoctypeshipmentId, docType.cDoctypeshipmentId) &&
        Objects.equals(this.cInvoiceId, docType.cInvoiceId) &&
        Objects.equals(this.created, docType.created) &&
        Objects.equals(this.createdby, docType.createdby) &&
        Objects.equals(this.cReversedoctypeId, docType.cReversedoctypeId) &&
        Objects.equals(this.datecai, docType.datecai) &&
        Objects.equals(this.description, docType.description) &&
        Objects.equals(this.docbasetype, docType.docbasetype) &&
        Objects.equals(this.docnosequenceId, docType.docnosequenceId) &&
        Objects.equals(this.docnosequenceUniqueId, docType.docnosequenceUniqueId) &&
        Objects.equals(this.docsubtypecae, docType.docsubtypecae) &&
        Objects.equals(this.docsubtypeinv, docType.docsubtypeinv) &&
        Objects.equals(this.docsubtypeso, docType.docsubtypeso) &&
        Objects.equals(this.doctypekey, docType.doctypekey) &&
        Objects.equals(this.documentcopies, docType.documentcopies) &&
        Objects.equals(this.documentnote, docType.documentnote) &&
        Objects.equals(this.dragorderdocumentdiscounts, docType.dragorderdocumentdiscounts) &&
        Objects.equals(this.dragorderdocumentsurcharges, docType.dragorderdocumentsurcharges) &&
        Objects.equals(this.dragorderlinediscounts, docType.dragorderlinediscounts) &&
        Objects.equals(this.dragorderlinesurcharges, docType.dragorderlinesurcharges) &&
        Objects.equals(this.dragorderprice, docType.dragorderprice) &&
        Objects.equals(this.enabledinpos, docType.enabledinpos) &&
        Objects.equals(this.enableincreatefromshipment, docType.enableincreatefromshipment) &&
        Objects.equals(this.fiscaldocument, docType.fiscaldocument) &&
        Objects.equals(this.fiscalprintingfooterlegends, docType.fiscalprintingfooterlegends) &&
        Objects.equals(this.glCategoryId, docType.glCategoryId) &&
        Objects.equals(this.hascharges, docType.hascharges) &&
        Objects.equals(this.hasproforma, docType.hasproforma) &&
        Objects.equals(this.inoutAllowGreaterQtyordered, docType.inoutAllowGreaterQtyordered) &&
        Objects.equals(this.isactive, docType.isactive) &&
        Objects.equals(this.ischeckoutplacerestricted, docType.ischeckoutplacerestricted) &&
        Objects.equals(this.iscreatecounter, docType.iscreatecounter) &&
        Objects.equals(this.isdefault, docType.isdefault) &&
        Objects.equals(this.isdefaultcounterdoc, docType.isdefaultcounterdoc) &&
        Objects.equals(this.isdocnocontrolled, docType.isdocnocontrolled) &&
        Objects.equals(this.iselectronic, docType.iselectronic) &&
        Objects.equals(this.isfiscal, docType.isfiscal) &&
        Objects.equals(this.isfiscaldocument, docType.isfiscaldocument) &&
        Objects.equals(this.isintransit, docType.isintransit) &&
        Objects.equals(this.ispaymentorderseq, docType.ispaymentorderseq) &&
        Objects.equals(this.ispickqaconfirm, docType.ispickqaconfirm) &&
        Objects.equals(this.isprintatcompleting, docType.isprintatcompleting) &&
        Objects.equals(this.isprintpreview, docType.isprintpreview) &&
        Objects.equals(this.isreceiptseq, docType.isreceiptseq) &&
        Objects.equals(this.isshipconfirm, docType.isshipconfirm) &&
        Objects.equals(this.issotrx, docType.issotrx) &&
        Objects.equals(this.issplitwhendifference, docType.issplitwhendifference) &&
        Objects.equals(this.iswarehouseclosurecontrol, docType.iswarehouseclosurecontrol) &&
        Objects.equals(this.linescountmax, docType.linescountmax) &&
        Objects.equals(this.lockseq, docType.lockseq) &&
        Objects.equals(this.mTrannaturecodeaId, docType.mTrannaturecodeaId) &&
        Objects.equals(this.mTrannaturecodebId, docType.mTrannaturecodebId) &&
        Objects.equals(this.name, docType.name) &&
        Objects.equals(this.notinvoiceable, docType.notinvoiceable) &&
        Objects.equals(this.onlyvendorproducts, docType.onlyvendorproducts) &&
        Objects.equals(this.openCloseByPos, docType.openCloseByPos) &&
        Objects.equals(this.posenabledue, docType.posenabledue) &&
        Objects.equals(this.posenableduedays, docType.posenableduedays) &&
        Objects.equals(this.printername, docType.printername) &&
        Objects.equals(this.printname, docType.printname) &&
        Objects.equals(this.reservestockmanagment, docType.reservestockmanagment) &&
        Objects.equals(this.reusedocumentno, docType.reusedocumentno) &&
        Objects.equals(this.signoIssotrx, docType.signoIssotrx) &&
        Objects.equals(this.skipcurrentaccounts, docType.skipcurrentaccounts) &&
        Objects.equals(this.transactiontypefrontliva, docType.transactiontypefrontliva) &&
        Objects.equals(this.uniquedocumentno, docType.uniquedocumentno) &&
        Objects.equals(this.updated, docType.updated) &&
        Objects.equals(this.updatedby, docType.updatedby) &&
        Objects.equals(this.useorderwarehouse, docType.useorderwarehouse) &&
        Objects.equals(this.validateseqlength, docType.validateseqlength) &&
        Objects.equals(this.additionalvalues, docType.additionalvalues) &&
        Objects.equals(this.referencedvalues, docType.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, adPrintformatId, adProcessId, allowchangepricelist, allowdeliveryreturned, allowonlyproviders, allowotherbatchpaymentdate, allowproposaldue, applyperception, applyretention, cai, caicontrol, cControladorFiscalId, cDoctypedifferenceId, cDoctypeId, cDoctypeinvoiceId, cDoctypeproformaId, cDoctypeshipmentId, cInvoiceId, created, createdby, cReversedoctypeId, datecai, description, docbasetype, docnosequenceId, docnosequenceUniqueId, docsubtypecae, docsubtypeinv, docsubtypeso, doctypekey, documentcopies, documentnote, dragorderdocumentdiscounts, dragorderdocumentsurcharges, dragorderlinediscounts, dragorderlinesurcharges, dragorderprice, enabledinpos, enableincreatefromshipment, fiscaldocument, fiscalprintingfooterlegends, glCategoryId, hascharges, hasproforma, inoutAllowGreaterQtyordered, isactive, ischeckoutplacerestricted, iscreatecounter, isdefault, isdefaultcounterdoc, isdocnocontrolled, iselectronic, isfiscal, isfiscaldocument, isintransit, ispaymentorderseq, ispickqaconfirm, isprintatcompleting, isprintpreview, isreceiptseq, isshipconfirm, issotrx, issplitwhendifference, iswarehouseclosurecontrol, linescountmax, lockseq, mTrannaturecodeaId, mTrannaturecodebId, name, notinvoiceable, onlyvendorproducts, openCloseByPos, posenabledue, posenableduedays, printername, printname, reservestockmanagment, reusedocumentno, signoIssotrx, skipcurrentaccounts, transactiontypefrontliva, uniquedocumentno, updated, updatedby, useorderwarehouse, validateseqlength, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocType {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adPrintformatId: ").append(toIndentedString(adPrintformatId)).append("\n");
    sb.append("    adProcessId: ").append(toIndentedString(adProcessId)).append("\n");
    sb.append("    allowchangepricelist: ").append(toIndentedString(allowchangepricelist)).append("\n");
    sb.append("    allowdeliveryreturned: ").append(toIndentedString(allowdeliveryreturned)).append("\n");
    sb.append("    allowonlyproviders: ").append(toIndentedString(allowonlyproviders)).append("\n");
    sb.append("    allowotherbatchpaymentdate: ").append(toIndentedString(allowotherbatchpaymentdate)).append("\n");
    sb.append("    allowproposaldue: ").append(toIndentedString(allowproposaldue)).append("\n");
    sb.append("    applyperception: ").append(toIndentedString(applyperception)).append("\n");
    sb.append("    applyretention: ").append(toIndentedString(applyretention)).append("\n");
    sb.append("    cai: ").append(toIndentedString(cai)).append("\n");
    sb.append("    caicontrol: ").append(toIndentedString(caicontrol)).append("\n");
    sb.append("    cControladorFiscalId: ").append(toIndentedString(cControladorFiscalId)).append("\n");
    sb.append("    cDoctypedifferenceId: ").append(toIndentedString(cDoctypedifferenceId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    cDoctypeinvoiceId: ").append(toIndentedString(cDoctypeinvoiceId)).append("\n");
    sb.append("    cDoctypeproformaId: ").append(toIndentedString(cDoctypeproformaId)).append("\n");
    sb.append("    cDoctypeshipmentId: ").append(toIndentedString(cDoctypeshipmentId)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cReversedoctypeId: ").append(toIndentedString(cReversedoctypeId)).append("\n");
    sb.append("    datecai: ").append(toIndentedString(datecai)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docbasetype: ").append(toIndentedString(docbasetype)).append("\n");
    sb.append("    docnosequenceId: ").append(toIndentedString(docnosequenceId)).append("\n");
    sb.append("    docnosequenceUniqueId: ").append(toIndentedString(docnosequenceUniqueId)).append("\n");
    sb.append("    docsubtypecae: ").append(toIndentedString(docsubtypecae)).append("\n");
    sb.append("    docsubtypeinv: ").append(toIndentedString(docsubtypeinv)).append("\n");
    sb.append("    docsubtypeso: ").append(toIndentedString(docsubtypeso)).append("\n");
    sb.append("    doctypekey: ").append(toIndentedString(doctypekey)).append("\n");
    sb.append("    documentcopies: ").append(toIndentedString(documentcopies)).append("\n");
    sb.append("    documentnote: ").append(toIndentedString(documentnote)).append("\n");
    sb.append("    dragorderdocumentdiscounts: ").append(toIndentedString(dragorderdocumentdiscounts)).append("\n");
    sb.append("    dragorderdocumentsurcharges: ").append(toIndentedString(dragorderdocumentsurcharges)).append("\n");
    sb.append("    dragorderlinediscounts: ").append(toIndentedString(dragorderlinediscounts)).append("\n");
    sb.append("    dragorderlinesurcharges: ").append(toIndentedString(dragorderlinesurcharges)).append("\n");
    sb.append("    dragorderprice: ").append(toIndentedString(dragorderprice)).append("\n");
    sb.append("    enabledinpos: ").append(toIndentedString(enabledinpos)).append("\n");
    sb.append("    enableincreatefromshipment: ").append(toIndentedString(enableincreatefromshipment)).append("\n");
    sb.append("    fiscaldocument: ").append(toIndentedString(fiscaldocument)).append("\n");
    sb.append("    fiscalprintingfooterlegends: ").append(toIndentedString(fiscalprintingfooterlegends)).append("\n");
    sb.append("    glCategoryId: ").append(toIndentedString(glCategoryId)).append("\n");
    sb.append("    hascharges: ").append(toIndentedString(hascharges)).append("\n");
    sb.append("    hasproforma: ").append(toIndentedString(hasproforma)).append("\n");
    sb.append("    inoutAllowGreaterQtyordered: ").append(toIndentedString(inoutAllowGreaterQtyordered)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    ischeckoutplacerestricted: ").append(toIndentedString(ischeckoutplacerestricted)).append("\n");
    sb.append("    iscreatecounter: ").append(toIndentedString(iscreatecounter)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    isdefaultcounterdoc: ").append(toIndentedString(isdefaultcounterdoc)).append("\n");
    sb.append("    isdocnocontrolled: ").append(toIndentedString(isdocnocontrolled)).append("\n");
    sb.append("    iselectronic: ").append(toIndentedString(iselectronic)).append("\n");
    sb.append("    isfiscal: ").append(toIndentedString(isfiscal)).append("\n");
    sb.append("    isfiscaldocument: ").append(toIndentedString(isfiscaldocument)).append("\n");
    sb.append("    isintransit: ").append(toIndentedString(isintransit)).append("\n");
    sb.append("    ispaymentorderseq: ").append(toIndentedString(ispaymentorderseq)).append("\n");
    sb.append("    ispickqaconfirm: ").append(toIndentedString(ispickqaconfirm)).append("\n");
    sb.append("    isprintatcompleting: ").append(toIndentedString(isprintatcompleting)).append("\n");
    sb.append("    isprintpreview: ").append(toIndentedString(isprintpreview)).append("\n");
    sb.append("    isreceiptseq: ").append(toIndentedString(isreceiptseq)).append("\n");
    sb.append("    isshipconfirm: ").append(toIndentedString(isshipconfirm)).append("\n");
    sb.append("    issotrx: ").append(toIndentedString(issotrx)).append("\n");
    sb.append("    issplitwhendifference: ").append(toIndentedString(issplitwhendifference)).append("\n");
    sb.append("    iswarehouseclosurecontrol: ").append(toIndentedString(iswarehouseclosurecontrol)).append("\n");
    sb.append("    linescountmax: ").append(toIndentedString(linescountmax)).append("\n");
    sb.append("    lockseq: ").append(toIndentedString(lockseq)).append("\n");
    sb.append("    mTrannaturecodeaId: ").append(toIndentedString(mTrannaturecodeaId)).append("\n");
    sb.append("    mTrannaturecodebId: ").append(toIndentedString(mTrannaturecodebId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notinvoiceable: ").append(toIndentedString(notinvoiceable)).append("\n");
    sb.append("    onlyvendorproducts: ").append(toIndentedString(onlyvendorproducts)).append("\n");
    sb.append("    openCloseByPos: ").append(toIndentedString(openCloseByPos)).append("\n");
    sb.append("    posenabledue: ").append(toIndentedString(posenabledue)).append("\n");
    sb.append("    posenableduedays: ").append(toIndentedString(posenableduedays)).append("\n");
    sb.append("    printername: ").append(toIndentedString(printername)).append("\n");
    sb.append("    printname: ").append(toIndentedString(printname)).append("\n");
    sb.append("    reservestockmanagment: ").append(toIndentedString(reservestockmanagment)).append("\n");
    sb.append("    reusedocumentno: ").append(toIndentedString(reusedocumentno)).append("\n");
    sb.append("    signoIssotrx: ").append(toIndentedString(signoIssotrx)).append("\n");
    sb.append("    skipcurrentaccounts: ").append(toIndentedString(skipcurrentaccounts)).append("\n");
    sb.append("    transactiontypefrontliva: ").append(toIndentedString(transactiontypefrontliva)).append("\n");
    sb.append("    uniquedocumentno: ").append(toIndentedString(uniquedocumentno)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    useorderwarehouse: ").append(toIndentedString(useorderwarehouse)).append("\n");
    sb.append("    validateseqlength: ").append(toIndentedString(validateseqlength)).append("\n");
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
