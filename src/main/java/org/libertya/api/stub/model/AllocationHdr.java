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
 * AllocationHdr
 */
@Validated



public class AllocationHdr   {
  @JsonProperty("actiondetail")
  private String actiondetail = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("allocationaction")
  private String allocationaction = null;

  @JsonProperty("allocationtype")
  private String allocationtype = null;

  @JsonProperty("approvalamt")
  private BigDecimal approvalamt = null;

  @JsonProperty("c_allocationhdr_id")
  private Integer cAllocationhdrId = null;

  @JsonProperty("c_banklist_id")
  private Integer cBanklistId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("c_posjournal_id")
  private Integer cPosjournalId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("datetrx")
  private String datetrx = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("grandtotal")
  private BigDecimal grandtotal = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("ismanual")
  private Boolean ismanual = null;

  @JsonProperty("posted")
  private String posted = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private Boolean processing = null;

  @JsonProperty("retencion_amt")
  private BigDecimal retencionAmt = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public AllocationHdr actiondetail(String actiondetail) {
    this.actiondetail = actiondetail;
    return this;
  }

  /**
   * Detalle del resultado de la ejecución de la acción específica del documento
   * @return actiondetail
   **/
  @Schema(description = "Detalle del resultado de la ejecución de la acción específica del documento")
  
    public String getActiondetail() {
    return actiondetail;
  }

  public void setActiondetail(String actiondetail) {
    this.actiondetail = actiondetail;
  }

  public AllocationHdr adClientId(Integer adClientId) {
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

  public AllocationHdr adOrgId(Integer adOrgId) {
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

  public AllocationHdr allocationaction(String allocationaction) {
    this.allocationaction = allocationaction;
    return this;
  }

  /**
   *  
   * @return allocationaction
   **/
  @Schema(description = " ")
  
    public String getAllocationaction() {
    return allocationaction;
  }

  public void setAllocationaction(String allocationaction) {
    this.allocationaction = allocationaction;
  }

  public AllocationHdr allocationtype(String allocationtype) {
    this.allocationtype = allocationtype;
    return this;
  }

  /**
   *  
   * @return allocationtype
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getAllocationtype() {
    return allocationtype;
  }

  public void setAllocationtype(String allocationtype) {
    this.allocationtype = allocationtype;
  }

  public AllocationHdr approvalamt(BigDecimal approvalamt) {
    this.approvalamt = approvalamt;
    return this;
  }

  /**
   * Cantidad Aprobada para el Documento
   * @return approvalamt
   **/
  @Schema(required = true, description = "Cantidad Aprobada para el Documento")
      @NotNull

    @Valid
    public BigDecimal getApprovalamt() {
    return approvalamt;
  }

  public void setApprovalamt(BigDecimal approvalamt) {
    this.approvalamt = approvalamt;
  }

  public AllocationHdr cAllocationhdrId(Integer cAllocationhdrId) {
    this.cAllocationhdrId = cAllocationhdrId;
    return this;
  }

  /**
   * Asignación de pagos
   * @return cAllocationhdrId
   **/
  @Schema(required = true, description = "Asignación de pagos")
      @NotNull

    public Integer getCAllocationhdrId() {
    return cAllocationhdrId;
  }

  public void setCAllocationhdrId(Integer cAllocationhdrId) {
    this.cAllocationhdrId = cAllocationhdrId;
  }

  public AllocationHdr cBanklistId(Integer cBanklistId) {
    this.cBanklistId = cBanklistId;
    return this;
  }

  /**
   * Lista de Banco
   * @return cBanklistId
   **/
  @Schema(description = "Lista de Banco")
  
    public Integer getCBanklistId() {
    return cBanklistId;
  }

  public void setCBanklistId(Integer cBanklistId) {
    this.cBanklistId = cBanklistId;
  }

  public AllocationHdr cBpartnerId(Integer cBpartnerId) {
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

  public AllocationHdr cCurrencyId(Integer cCurrencyId) {
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

  public AllocationHdr cDoctypeId(Integer cDoctypeId) {
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

  public AllocationHdr cPosjournalId(Integer cPosjournalId) {
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

  public AllocationHdr created(String created) {
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

  public AllocationHdr createdby(Integer createdby) {
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

  public AllocationHdr dateacct(String dateacct) {
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

  public AllocationHdr datetrx(String datetrx) {
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

  public AllocationHdr description(String description) {
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

  public AllocationHdr docaction(String docaction) {
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

  public AllocationHdr docstatus(String docstatus) {
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

  public AllocationHdr documentno(String documentno) {
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

  public AllocationHdr grandtotal(BigDecimal grandtotal) {
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

  public AllocationHdr isactive(Boolean isactive) {
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

  public AllocationHdr isapproved(Boolean isapproved) {
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

  public AllocationHdr ismanual(Boolean ismanual) {
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

  public AllocationHdr posted(String posted) {
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

  public AllocationHdr processed(Boolean processed) {
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

  public AllocationHdr processing(Boolean processing) {
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

  public AllocationHdr retencionAmt(BigDecimal retencionAmt) {
    this.retencionAmt = retencionAmt;
    return this;
  }

  /**
   *  
   * @return retencionAmt
   **/
  @Schema(required = true, description = " ")
      @NotNull

    @Valid
    public BigDecimal getRetencionAmt() {
    return retencionAmt;
  }

  public void setRetencionAmt(BigDecimal retencionAmt) {
    this.retencionAmt = retencionAmt;
  }

  public AllocationHdr updated(String updated) {
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

  public AllocationHdr updatedby(Integer updatedby) {
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

  public AllocationHdr additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public AllocationHdr addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public AllocationHdr referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public AllocationHdr addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    AllocationHdr allocationHdr = (AllocationHdr) o;
    return Objects.equals(this.actiondetail, allocationHdr.actiondetail) &&
        Objects.equals(this.adClientId, allocationHdr.adClientId) &&
        Objects.equals(this.adOrgId, allocationHdr.adOrgId) &&
        Objects.equals(this.allocationaction, allocationHdr.allocationaction) &&
        Objects.equals(this.allocationtype, allocationHdr.allocationtype) &&
        Objects.equals(this.approvalamt, allocationHdr.approvalamt) &&
        Objects.equals(this.cAllocationhdrId, allocationHdr.cAllocationhdrId) &&
        Objects.equals(this.cBanklistId, allocationHdr.cBanklistId) &&
        Objects.equals(this.cBpartnerId, allocationHdr.cBpartnerId) &&
        Objects.equals(this.cCurrencyId, allocationHdr.cCurrencyId) &&
        Objects.equals(this.cDoctypeId, allocationHdr.cDoctypeId) &&
        Objects.equals(this.cPosjournalId, allocationHdr.cPosjournalId) &&
        Objects.equals(this.created, allocationHdr.created) &&
        Objects.equals(this.createdby, allocationHdr.createdby) &&
        Objects.equals(this.dateacct, allocationHdr.dateacct) &&
        Objects.equals(this.datetrx, allocationHdr.datetrx) &&
        Objects.equals(this.description, allocationHdr.description) &&
        Objects.equals(this.docaction, allocationHdr.docaction) &&
        Objects.equals(this.docstatus, allocationHdr.docstatus) &&
        Objects.equals(this.documentno, allocationHdr.documentno) &&
        Objects.equals(this.grandtotal, allocationHdr.grandtotal) &&
        Objects.equals(this.isactive, allocationHdr.isactive) &&
        Objects.equals(this.isapproved, allocationHdr.isapproved) &&
        Objects.equals(this.ismanual, allocationHdr.ismanual) &&
        Objects.equals(this.posted, allocationHdr.posted) &&
        Objects.equals(this.processed, allocationHdr.processed) &&
        Objects.equals(this.processing, allocationHdr.processing) &&
        Objects.equals(this.retencionAmt, allocationHdr.retencionAmt) &&
        Objects.equals(this.updated, allocationHdr.updated) &&
        Objects.equals(this.updatedby, allocationHdr.updatedby) &&
        Objects.equals(this.additionalvalues, allocationHdr.additionalvalues) &&
        Objects.equals(this.referencedvalues, allocationHdr.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actiondetail, adClientId, adOrgId, allocationaction, allocationtype, approvalamt, cAllocationhdrId, cBanklistId, cBpartnerId, cCurrencyId, cDoctypeId, cPosjournalId, created, createdby, dateacct, datetrx, description, docaction, docstatus, documentno, grandtotal, isactive, isapproved, ismanual, posted, processed, processing, retencionAmt, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocationHdr {\n");
    
    sb.append("    actiondetail: ").append(toIndentedString(actiondetail)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    allocationaction: ").append(toIndentedString(allocationaction)).append("\n");
    sb.append("    allocationtype: ").append(toIndentedString(allocationtype)).append("\n");
    sb.append("    approvalamt: ").append(toIndentedString(approvalamt)).append("\n");
    sb.append("    cAllocationhdrId: ").append(toIndentedString(cAllocationhdrId)).append("\n");
    sb.append("    cBanklistId: ").append(toIndentedString(cBanklistId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    cPosjournalId: ").append(toIndentedString(cPosjournalId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    datetrx: ").append(toIndentedString(datetrx)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    grandtotal: ").append(toIndentedString(grandtotal)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    ismanual: ").append(toIndentedString(ismanual)).append("\n");
    sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    retencionAmt: ").append(toIndentedString(retencionAmt)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
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
