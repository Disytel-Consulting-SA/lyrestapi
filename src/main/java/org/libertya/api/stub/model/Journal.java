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
 * Journal
 */
@Validated



public class Journal   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_acctschema_id")
  private Integer cAcctschemaId = null;

  @JsonProperty("c_conversiontype_id")
  private Integer cConversiontypeId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("controlamt")
  private BigDecimal controlamt = null;

  @JsonProperty("c_period_id")
  private Integer cPeriodId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("currencyrate")
  private BigDecimal currencyrate = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("datedoc")
  private String datedoc = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("gl_category_id")
  private Integer glCategoryId = null;

  @JsonProperty("gl_journalbatch_id")
  private Integer glJournalbatchId = null;

  @JsonProperty("gl_journal_id")
  private Integer glJournalId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("isprinted")
  private Boolean isprinted = null;

  @JsonProperty("isreactivated")
  private Boolean isreactivated = null;

  @JsonProperty("posted")
  private String posted = null;

  @JsonProperty("postingtype")
  private String postingtype = null;

  @JsonProperty("totalcr")
  private BigDecimal totalcr = null;

  @JsonProperty("totaldr")
  private BigDecimal totaldr = null;

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

  public Journal adClientId(Integer adClientId) {
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

  public Journal adOrgId(Integer adOrgId) {
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

  public Journal cAcctschemaId(Integer cAcctschemaId) {
    this.cAcctschemaId = cAcctschemaId;
    return this;
  }

  /**
   * Reglas para contabilizar
   * @return cAcctschemaId
   **/
  @Schema(required = true, description = "Reglas para contabilizar")
      @NotNull

    public Integer getCAcctschemaId() {
    return cAcctschemaId;
  }

  public void setCAcctschemaId(Integer cAcctschemaId) {
    this.cAcctschemaId = cAcctschemaId;
  }

  public Journal cConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
    return this;
  }

  /**
   * Tipo de Divisa
   * @return cConversiontypeId
   **/
  @Schema(required = true, description = "Tipo de Divisa")
      @NotNull

    public Integer getCConversiontypeId() {
    return cConversiontypeId;
  }

  public void setCConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
  }

  public Journal cCurrencyId(Integer cCurrencyId) {
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

  public Journal cDoctypeId(Integer cDoctypeId) {
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

  public Journal controlamt(BigDecimal controlamt) {
    this.controlamt = controlamt;
    return this;
  }

  /**
   * Si no es cero; la cantidad del débito del documento debe ser igual a esta cantidad
   * @return controlamt
   **/
  @Schema(description = "Si no es cero; la cantidad del débito del documento debe ser igual a esta cantidad")
  
    @Valid
    public BigDecimal getControlamt() {
    return controlamt;
  }

  public void setControlamt(BigDecimal controlamt) {
    this.controlamt = controlamt;
  }

  public Journal cPeriodId(Integer cPeriodId) {
    this.cPeriodId = cPeriodId;
    return this;
  }

  /**
   * Período de Calendario
   * @return cPeriodId
   **/
  @Schema(required = true, description = "Período de Calendario")
      @NotNull

    public Integer getCPeriodId() {
    return cPeriodId;
  }

  public void setCPeriodId(Integer cPeriodId) {
    this.cPeriodId = cPeriodId;
  }

  public Journal created(String created) {
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

  public Journal createdby(Integer createdby) {
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

  public Journal currencyrate(BigDecimal currencyrate) {
    this.currencyrate = currencyrate;
    return this;
  }

  /**
   * Tasa de Conversión de moneda}
   * @return currencyrate
   **/
  @Schema(required = true, description = "Tasa de Conversión de moneda}")
      @NotNull

    @Valid
    public BigDecimal getCurrencyrate() {
    return currencyrate;
  }

  public void setCurrencyrate(BigDecimal currencyrate) {
    this.currencyrate = currencyrate;
  }

  public Journal dateacct(String dateacct) {
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

  public Journal datedoc(String datedoc) {
    this.datedoc = datedoc;
    return this;
  }

  /**
   * Fecha del Documento
   * @return datedoc
   **/
  @Schema(required = true, description = "Fecha del Documento")
      @NotNull

    public String getDatedoc() {
    return datedoc;
  }

  public void setDatedoc(String datedoc) {
    this.datedoc = datedoc;
  }

  public Journal description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción corta opcional del registro
   * @return description
   **/
  @Schema(required = true, description = "Descripción corta opcional del registro")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Journal docaction(String docaction) {
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

  public Journal docstatus(String docstatus) {
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

  public Journal documentno(String documentno) {
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

  public Journal glCategoryId(Integer glCategoryId) {
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

  public Journal glJournalbatchId(Integer glJournalbatchId) {
    this.glJournalbatchId = glJournalbatchId;
    return this;
  }

  /**
   * Lote de Asientos
   * @return glJournalbatchId
   **/
  @Schema(description = "Lote de Asientos")
  
    public Integer getGlJournalbatchId() {
    return glJournalbatchId;
  }

  public void setGlJournalbatchId(Integer glJournalbatchId) {
    this.glJournalbatchId = glJournalbatchId;
  }

  public Journal glJournalId(Integer glJournalId) {
    this.glJournalId = glJournalId;
    return this;
  }

  /**
   * Asiento
   * @return glJournalId
   **/
  @Schema(required = true, description = "Asiento")
      @NotNull

    public Integer getGlJournalId() {
    return glJournalId;
  }

  public void setGlJournalId(Integer glJournalId) {
    this.glJournalId = glJournalId;
  }

  public Journal isactive(Boolean isactive) {
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

  public Journal isapproved(Boolean isapproved) {
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

  public Journal isprinted(Boolean isprinted) {
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

  public Journal isreactivated(Boolean isreactivated) {
    this.isreactivated = isreactivated;
    return this;
  }

  /**
   * Indica si el registro fue recientemente reactivado
   * @return isreactivated
   **/
  @Schema(required = true, description = "Indica si el registro fue recientemente reactivado")
      @NotNull

    public Boolean isIsreactivated() {
    return isreactivated;
  }

  public void setIsreactivated(Boolean isreactivated) {
    this.isreactivated = isreactivated;
  }

  public Journal posted(String posted) {
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

  public Journal postingtype(String postingtype) {
    this.postingtype = postingtype;
    return this;
  }

  /**
   * El tipo de monto que esta póliza actualizó
   * @return postingtype
   **/
  @Schema(required = true, description = "El tipo de monto que esta póliza actualizó")
      @NotNull

    public String getPostingtype() {
    return postingtype;
  }

  public void setPostingtype(String postingtype) {
    this.postingtype = postingtype;
  }

  public Journal totalcr(BigDecimal totalcr) {
    this.totalcr = totalcr;
    return this;
  }

  /**
   * Total de Créditos en la moneda del negocio
   * @return totalcr
   **/
  @Schema(required = true, description = "Total de Créditos en la moneda del negocio")
      @NotNull

    @Valid
    public BigDecimal getTotalcr() {
    return totalcr;
  }

  public void setTotalcr(BigDecimal totalcr) {
    this.totalcr = totalcr;
  }

  public Journal totaldr(BigDecimal totaldr) {
    this.totaldr = totaldr;
    return this;
  }

  /**
   * Total de Débitos en la moneda del negocio
   * @return totaldr
   **/
  @Schema(required = true, description = "Total de Débitos en la moneda del negocio")
      @NotNull

    @Valid
    public BigDecimal getTotaldr() {
    return totaldr;
  }

  public void setTotaldr(BigDecimal totaldr) {
    this.totaldr = totaldr;
  }

  public Journal updated(String updated) {
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

  public Journal updatedby(Integer updatedby) {
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

  public Journal additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Journal addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Journal referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Journal addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Journal journal = (Journal) o;
    return Objects.equals(this.adClientId, journal.adClientId) &&
        Objects.equals(this.adOrgId, journal.adOrgId) &&
        Objects.equals(this.cAcctschemaId, journal.cAcctschemaId) &&
        Objects.equals(this.cConversiontypeId, journal.cConversiontypeId) &&
        Objects.equals(this.cCurrencyId, journal.cCurrencyId) &&
        Objects.equals(this.cDoctypeId, journal.cDoctypeId) &&
        Objects.equals(this.controlamt, journal.controlamt) &&
        Objects.equals(this.cPeriodId, journal.cPeriodId) &&
        Objects.equals(this.created, journal.created) &&
        Objects.equals(this.createdby, journal.createdby) &&
        Objects.equals(this.currencyrate, journal.currencyrate) &&
        Objects.equals(this.dateacct, journal.dateacct) &&
        Objects.equals(this.datedoc, journal.datedoc) &&
        Objects.equals(this.description, journal.description) &&
        Objects.equals(this.docaction, journal.docaction) &&
        Objects.equals(this.docstatus, journal.docstatus) &&
        Objects.equals(this.documentno, journal.documentno) &&
        Objects.equals(this.glCategoryId, journal.glCategoryId) &&
        Objects.equals(this.glJournalbatchId, journal.glJournalbatchId) &&
        Objects.equals(this.glJournalId, journal.glJournalId) &&
        Objects.equals(this.isactive, journal.isactive) &&
        Objects.equals(this.isapproved, journal.isapproved) &&
        Objects.equals(this.isprinted, journal.isprinted) &&
        Objects.equals(this.isreactivated, journal.isreactivated) &&
        Objects.equals(this.posted, journal.posted) &&
        Objects.equals(this.postingtype, journal.postingtype) &&
        Objects.equals(this.totalcr, journal.totalcr) &&
        Objects.equals(this.totaldr, journal.totaldr) &&
        Objects.equals(this.updated, journal.updated) &&
        Objects.equals(this.updatedby, journal.updatedby) &&
        Objects.equals(this.additionalvalues, journal.additionalvalues) &&
        Objects.equals(this.referencedvalues, journal.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cAcctschemaId, cConversiontypeId, cCurrencyId, cDoctypeId, controlamt, cPeriodId, created, createdby, currencyrate, dateacct, datedoc, description, docaction, docstatus, documentno, glCategoryId, glJournalbatchId, glJournalId, isactive, isapproved, isprinted, isreactivated, posted, postingtype, totalcr, totaldr, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Journal {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cAcctschemaId: ").append(toIndentedString(cAcctschemaId)).append("\n");
    sb.append("    cConversiontypeId: ").append(toIndentedString(cConversiontypeId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    controlamt: ").append(toIndentedString(controlamt)).append("\n");
    sb.append("    cPeriodId: ").append(toIndentedString(cPeriodId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    currencyrate: ").append(toIndentedString(currencyrate)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    datedoc: ").append(toIndentedString(datedoc)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    glCategoryId: ").append(toIndentedString(glCategoryId)).append("\n");
    sb.append("    glJournalbatchId: ").append(toIndentedString(glJournalbatchId)).append("\n");
    sb.append("    glJournalId: ").append(toIndentedString(glJournalId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    isprinted: ").append(toIndentedString(isprinted)).append("\n");
    sb.append("    isreactivated: ").append(toIndentedString(isreactivated)).append("\n");
    sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
    sb.append("    postingtype: ").append(toIndentedString(postingtype)).append("\n");
    sb.append("    totalcr: ").append(toIndentedString(totalcr)).append("\n");
    sb.append("    totaldr: ").append(toIndentedString(totaldr)).append("\n");
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
