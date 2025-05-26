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
 * Cash
 */
@Validated



public class Cash   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("beginningbalance")
  private BigDecimal beginningbalance = null;

  @JsonProperty("c_activity_id")
  private Integer cActivityId = null;

  @JsonProperty("cashbooktype")
  private String cashbooktype = null;

  @JsonProperty("c_campaign_id")
  private Integer cCampaignId = null;

  @JsonProperty("c_cashbook_id")
  private Integer cCashbookId = null;

  @JsonProperty("c_cash_id")
  private Integer cCashId = null;

  @JsonProperty("c_posjournal_id")
  private Integer cPosjournalId = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("endingbalance")
  private BigDecimal endingbalance = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("posted")
  private String posted = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private Boolean processing = null;

  @JsonProperty("statementdate")
  private String statementdate = null;

  @JsonProperty("statementdifference")
  private BigDecimal statementdifference = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("user1_id")
  private Integer user1Id = null;

  @JsonProperty("user2_id")
  private Integer user2Id = null;

  @JsonProperty("validateposjournal")
  private Boolean validateposjournal = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Cash adClientId(Integer adClientId) {
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

  public Cash adOrgId(Integer adOrgId) {
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

  public Cash adOrgtrxId(Integer adOrgtrxId) {
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

  public Cash beginningbalance(BigDecimal beginningbalance) {
    this.beginningbalance = beginningbalance;
    return this;
  }

  /**
   * Saldo anterior a cualquier transacción
   * @return beginningbalance
   **/
  @Schema(required = true, description = "Saldo anterior a cualquier transacción")
      @NotNull

    @Valid
    public BigDecimal getBeginningbalance() {
    return beginningbalance;
  }

  public void setBeginningbalance(BigDecimal beginningbalance) {
    this.beginningbalance = beginningbalance;
  }

  public Cash cActivityId(Integer cActivityId) {
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

  public Cash cashbooktype(String cashbooktype) {
    this.cashbooktype = cashbooktype;
    return this;
  }

  /**
   * Tipo de Caja
   * @return cashbooktype
   **/
  @Schema(description = "Tipo de Caja")
  
    public String getCashbooktype() {
    return cashbooktype;
  }

  public void setCashbooktype(String cashbooktype) {
    this.cashbooktype = cashbooktype;
  }

  public Cash cCampaignId(Integer cCampaignId) {
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

  public Cash cCashbookId(Integer cCashbookId) {
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

  public Cash cCashId(Integer cCashId) {
    this.cCashId = cCashId;
    return this;
  }

  /**
   * Libro de Caja
   * @return cCashId
   **/
  @Schema(required = true, description = "Libro de Caja")
      @NotNull

    public Integer getCCashId() {
    return cCashId;
  }

  public void setCCashId(Integer cCashId) {
    this.cCashId = cCashId;
  }

  public Cash cPosjournalId(Integer cPosjournalId) {
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

  public Cash cProjectId(Integer cProjectId) {
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

  public Cash created(String created) {
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

  public Cash createdby(Integer createdby) {
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

  public Cash dateacct(String dateacct) {
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

  public Cash description(String description) {
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

  public Cash docaction(String docaction) {
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

  public Cash docstatus(String docstatus) {
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

  public Cash endingbalance(BigDecimal endingbalance) {
    this.endingbalance = endingbalance;
    return this;
  }

  /**
   * Saldo final o al cierre
   * @return endingbalance
   **/
  @Schema(required = true, description = "Saldo final o al cierre")
      @NotNull

    @Valid
    public BigDecimal getEndingbalance() {
    return endingbalance;
  }

  public void setEndingbalance(BigDecimal endingbalance) {
    this.endingbalance = endingbalance;
  }

  public Cash isactive(Boolean isactive) {
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

  public Cash isapproved(Boolean isapproved) {
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

  public Cash name(String name) {
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

  public Cash posted(String posted) {
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

  public Cash processed(Boolean processed) {
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

  public Cash processing(Boolean processing) {
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

  public Cash statementdate(String statementdate) {
    this.statementdate = statementdate;
    return this;
  }

  /**
   * Fecha de proceso de un Estado de Cuentas
   * @return statementdate
   **/
  @Schema(required = true, description = "Fecha de proceso de un Estado de Cuentas")
      @NotNull

    public String getStatementdate() {
    return statementdate;
  }

  public void setStatementdate(String statementdate) {
    this.statementdate = statementdate;
  }

  public Cash statementdifference(BigDecimal statementdifference) {
    this.statementdifference = statementdifference;
    return this;
  }

  /**
   * Diferencia entre el saldo final del Estado de Cuentas y el saldo final actual
   * @return statementdifference
   **/
  @Schema(description = "Diferencia entre el saldo final del Estado de Cuentas y el saldo final actual")
  
    @Valid
    public BigDecimal getStatementdifference() {
    return statementdifference;
  }

  public void setStatementdifference(BigDecimal statementdifference) {
    this.statementdifference = statementdifference;
  }

  public Cash updated(String updated) {
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

  public Cash updatedby(Integer updatedby) {
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

  public Cash user1Id(Integer user1Id) {
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

  public Cash user2Id(Integer user2Id) {
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

  public Cash validateposjournal(Boolean validateposjournal) {
    this.validateposjournal = validateposjournal;
    return this;
  }

  /**
   * Determina si la caja debe validar la funcionalidad de cajas diarias
   * @return validateposjournal
   **/
  @Schema(required = true, description = "Determina si la caja debe validar la funcionalidad de cajas diarias")
      @NotNull

    public Boolean isValidateposjournal() {
    return validateposjournal;
  }

  public void setValidateposjournal(Boolean validateposjournal) {
    this.validateposjournal = validateposjournal;
  }

  public Cash additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Cash addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Cash referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Cash addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Cash cash = (Cash) o;
    return Objects.equals(this.adClientId, cash.adClientId) &&
        Objects.equals(this.adOrgId, cash.adOrgId) &&
        Objects.equals(this.adOrgtrxId, cash.adOrgtrxId) &&
        Objects.equals(this.beginningbalance, cash.beginningbalance) &&
        Objects.equals(this.cActivityId, cash.cActivityId) &&
        Objects.equals(this.cashbooktype, cash.cashbooktype) &&
        Objects.equals(this.cCampaignId, cash.cCampaignId) &&
        Objects.equals(this.cCashbookId, cash.cCashbookId) &&
        Objects.equals(this.cCashId, cash.cCashId) &&
        Objects.equals(this.cPosjournalId, cash.cPosjournalId) &&
        Objects.equals(this.cProjectId, cash.cProjectId) &&
        Objects.equals(this.created, cash.created) &&
        Objects.equals(this.createdby, cash.createdby) &&
        Objects.equals(this.dateacct, cash.dateacct) &&
        Objects.equals(this.description, cash.description) &&
        Objects.equals(this.docaction, cash.docaction) &&
        Objects.equals(this.docstatus, cash.docstatus) &&
        Objects.equals(this.endingbalance, cash.endingbalance) &&
        Objects.equals(this.isactive, cash.isactive) &&
        Objects.equals(this.isapproved, cash.isapproved) &&
        Objects.equals(this.name, cash.name) &&
        Objects.equals(this.posted, cash.posted) &&
        Objects.equals(this.processed, cash.processed) &&
        Objects.equals(this.processing, cash.processing) &&
        Objects.equals(this.statementdate, cash.statementdate) &&
        Objects.equals(this.statementdifference, cash.statementdifference) &&
        Objects.equals(this.updated, cash.updated) &&
        Objects.equals(this.updatedby, cash.updatedby) &&
        Objects.equals(this.user1Id, cash.user1Id) &&
        Objects.equals(this.user2Id, cash.user2Id) &&
        Objects.equals(this.validateposjournal, cash.validateposjournal) &&
        Objects.equals(this.additionalvalues, cash.additionalvalues) &&
        Objects.equals(this.referencedvalues, cash.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adOrgtrxId, beginningbalance, cActivityId, cashbooktype, cCampaignId, cCashbookId, cCashId, cPosjournalId, cProjectId, created, createdby, dateacct, description, docaction, docstatus, endingbalance, isactive, isapproved, name, posted, processed, processing, statementdate, statementdifference, updated, updatedby, user1Id, user2Id, validateposjournal, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cash {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    beginningbalance: ").append(toIndentedString(beginningbalance)).append("\n");
    sb.append("    cActivityId: ").append(toIndentedString(cActivityId)).append("\n");
    sb.append("    cashbooktype: ").append(toIndentedString(cashbooktype)).append("\n");
    sb.append("    cCampaignId: ").append(toIndentedString(cCampaignId)).append("\n");
    sb.append("    cCashbookId: ").append(toIndentedString(cCashbookId)).append("\n");
    sb.append("    cCashId: ").append(toIndentedString(cCashId)).append("\n");
    sb.append("    cPosjournalId: ").append(toIndentedString(cPosjournalId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    endingbalance: ").append(toIndentedString(endingbalance)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    statementdate: ").append(toIndentedString(statementdate)).append("\n");
    sb.append("    statementdifference: ").append(toIndentedString(statementdifference)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    user1Id: ").append(toIndentedString(user1Id)).append("\n");
    sb.append("    user2Id: ").append(toIndentedString(user2Id)).append("\n");
    sb.append("    validateposjournal: ").append(toIndentedString(validateposjournal)).append("\n");
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
