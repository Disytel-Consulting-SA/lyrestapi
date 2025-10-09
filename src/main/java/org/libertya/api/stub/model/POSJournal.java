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
 * POSJournal
 */
@Validated



public class POSJournal   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_user_id")
  private Integer adUserId = null;

  @JsonProperty("cashbalance")
  private BigDecimal cashbalance = null;

  @JsonProperty("cashstatementamt")
  private BigDecimal cashstatementamt = null;

  @JsonProperty("cashtransfer")
  private String cashtransfer = null;

  @JsonProperty("c_cash_id")
  private Integer cCashId = null;

  @JsonProperty("c_cashtarget_id")
  private Integer cCashtargetId = null;

  @JsonProperty("c_pos_id")
  private Integer cPosId = null;

  @JsonProperty("c_posjournal_id")
  private Integer cPosjournalId = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("datetrx")
  private String datetrx = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("processed")
  private Boolean processed = null;

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

  public POSJournal adClientId(Integer adClientId) {
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

  public POSJournal adOrgId(Integer adOrgId) {
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

  public POSJournal adUserId(Integer adUserId) {
    this.adUserId = adUserId;
    return this;
  }

  /**
   * ID de Usuario dentro del sistema
   * @return adUserId
   **/
  @Schema(required = true, description = "ID de Usuario dentro del sistema")
      @NotNull

    public Integer getAdUserId() {
    return adUserId;
  }

  public void setAdUserId(Integer adUserId) {
    this.adUserId = adUserId;
  }

  public POSJournal cashbalance(BigDecimal cashbalance) {
    this.cashbalance = cashbalance;
    return this;
  }

  /**
   * Saldo de Caja
   * @return cashbalance
   **/
  @Schema(description = "Saldo de Caja")
  
    @Valid
    public BigDecimal getCashbalance() {
    return cashbalance;
  }

  public void setCashbalance(BigDecimal cashbalance) {
    this.cashbalance = cashbalance;
  }

  public POSJournal cashstatementamt(BigDecimal cashstatementamt) {
    this.cashstatementamt = cashstatementamt;
    return this;
  }

  /**
   * Importe de la suma de declaración de valores en caja
   * @return cashstatementamt
   **/
  @Schema(required = true, description = "Importe de la suma de declaración de valores en caja")
      @NotNull

    @Valid
    public BigDecimal getCashstatementamt() {
    return cashstatementamt;
  }

  public void setCashstatementamt(BigDecimal cashstatementamt) {
    this.cashstatementamt = cashstatementamt;
  }

  public POSJournal cashtransfer(String cashtransfer) {
    this.cashtransfer = cashtransfer;
    return this;
  }

  /**
   * Transferencia de efectivo entre cajas
   * @return cashtransfer
   **/
  @Schema(description = "Transferencia de efectivo entre cajas")
  
    public String getCashtransfer() {
    return cashtransfer;
  }

  public void setCashtransfer(String cashtransfer) {
    this.cashtransfer = cashtransfer;
  }

  public POSJournal cCashId(Integer cCashId) {
    this.cCashId = cCashId;
    return this;
  }

  /**
   * Libro de Caja
   * @return cCashId
   **/
  @Schema(description = "Libro de Caja")
  
    public Integer getCCashId() {
    return cCashId;
  }

  public void setCCashId(Integer cCashId) {
    this.cCashId = cCashId;
  }

  public POSJournal cCashtargetId(Integer cCashtargetId) {
    this.cCashtargetId = cCashtargetId;
    return this;
  }

  /**
   * Libro de Caja Destino
   * @return cCashtargetId
   **/
  @Schema(description = "Libro de Caja Destino")
  
    public Integer getCCashtargetId() {
    return cCashtargetId;
  }

  public void setCCashtargetId(Integer cCashtargetId) {
    this.cCashtargetId = cCashtargetId;
  }

  public POSJournal cPosId(Integer cPosId) {
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

  public POSJournal cPosjournalId(Integer cPosjournalId) {
    this.cPosjournalId = cPosjournalId;
    return this;
  }

  /**
   * Caja Diaria
   * @return cPosjournalId
   **/
  @Schema(required = true, description = "Caja Diaria")
      @NotNull

    public Integer getCPosjournalId() {
    return cPosjournalId;
  }

  public void setCPosjournalId(Integer cPosjournalId) {
    this.cPosjournalId = cPosjournalId;
  }

  public POSJournal cProjectId(Integer cProjectId) {
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

  public POSJournal created(String created) {
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

  public POSJournal createdby(Integer createdby) {
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

  public POSJournal datetrx(String datetrx) {
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

  public POSJournal docaction(String docaction) {
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

  public POSJournal docstatus(String docstatus) {
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

  public POSJournal isactive(Boolean isactive) {
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

  public POSJournal processed(Boolean processed) {
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

  public POSJournal updated(String updated) {
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

  public POSJournal updatedby(Integer updatedby) {
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

  public POSJournal additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public POSJournal addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public POSJournal referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public POSJournal addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    POSJournal poSJournal = (POSJournal) o;
    return Objects.equals(this.adClientId, poSJournal.adClientId) &&
        Objects.equals(this.adOrgId, poSJournal.adOrgId) &&
        Objects.equals(this.adUserId, poSJournal.adUserId) &&
        Objects.equals(this.cashbalance, poSJournal.cashbalance) &&
        Objects.equals(this.cashstatementamt, poSJournal.cashstatementamt) &&
        Objects.equals(this.cashtransfer, poSJournal.cashtransfer) &&
        Objects.equals(this.cCashId, poSJournal.cCashId) &&
        Objects.equals(this.cCashtargetId, poSJournal.cCashtargetId) &&
        Objects.equals(this.cPosId, poSJournal.cPosId) &&
        Objects.equals(this.cPosjournalId, poSJournal.cPosjournalId) &&
        Objects.equals(this.cProjectId, poSJournal.cProjectId) &&
        Objects.equals(this.created, poSJournal.created) &&
        Objects.equals(this.createdby, poSJournal.createdby) &&
        Objects.equals(this.datetrx, poSJournal.datetrx) &&
        Objects.equals(this.docaction, poSJournal.docaction) &&
        Objects.equals(this.docstatus, poSJournal.docstatus) &&
        Objects.equals(this.isactive, poSJournal.isactive) &&
        Objects.equals(this.processed, poSJournal.processed) &&
        Objects.equals(this.updated, poSJournal.updated) &&
        Objects.equals(this.updatedby, poSJournal.updatedby) &&
        Objects.equals(this.additionalvalues, poSJournal.additionalvalues) &&
        Objects.equals(this.referencedvalues, poSJournal.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adUserId, cashbalance, cashstatementamt, cashtransfer, cCashId, cCashtargetId, cPosId, cPosjournalId, cProjectId, created, createdby, datetrx, docaction, docstatus, isactive, processed, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSJournal {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adUserId: ").append(toIndentedString(adUserId)).append("\n");
    sb.append("    cashbalance: ").append(toIndentedString(cashbalance)).append("\n");
    sb.append("    cashstatementamt: ").append(toIndentedString(cashstatementamt)).append("\n");
    sb.append("    cashtransfer: ").append(toIndentedString(cashtransfer)).append("\n");
    sb.append("    cCashId: ").append(toIndentedString(cCashId)).append("\n");
    sb.append("    cCashtargetId: ").append(toIndentedString(cCashtargetId)).append("\n");
    sb.append("    cPosId: ").append(toIndentedString(cPosId)).append("\n");
    sb.append("    cPosjournalId: ").append(toIndentedString(cPosjournalId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    datetrx: ").append(toIndentedString(datetrx)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
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
