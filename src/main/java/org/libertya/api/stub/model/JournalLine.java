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
 * JournalLine
 */
@Validated



public class JournalLine   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("amtacctcr")
  private BigDecimal amtacctcr = null;

  @JsonProperty("amtacctdr")
  private BigDecimal amtacctdr = null;

  @JsonProperty("amtsourcecr")
  private BigDecimal amtsourcecr = null;

  @JsonProperty("amtsourcedr")
  private BigDecimal amtsourcedr = null;

  @JsonProperty("c_conversiontype_id")
  private Integer cConversiontypeId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("c_elementvalue_id")
  private Integer cElementvalueId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_uom_id")
  private Integer cUomId = null;

  @JsonProperty("currencyrate")
  private BigDecimal currencyrate = null;

  @JsonProperty("c_validcombination_id")
  private Integer cValidcombinationId = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("gl_journal_id")
  private Integer glJournalId = null;

  @JsonProperty("gl_journalline_id")
  private Integer glJournallineId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isgenerated")
  private Boolean isgenerated = null;

  @JsonProperty("line")
  private Integer line = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("qty")
  private BigDecimal qty = null;

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

  public JournalLine adClientId(Integer adClientId) {
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

  public JournalLine adOrgId(Integer adOrgId) {
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

  public JournalLine amtacctcr(BigDecimal amtacctcr) {
    this.amtacctcr = amtacctcr;
    return this;
  }

  /**
   * Haber
   * @return amtacctcr
   **/
  @Schema(required = true, description = "Haber")
      @NotNull

    @Valid
    public BigDecimal getAmtacctcr() {
    return amtacctcr;
  }

  public void setAmtacctcr(BigDecimal amtacctcr) {
    this.amtacctcr = amtacctcr;
  }

  public JournalLine amtacctdr(BigDecimal amtacctdr) {
    this.amtacctdr = amtacctdr;
    return this;
  }

  /**
   * Importe del Débito contabilizado
   * @return amtacctdr
   **/
  @Schema(required = true, description = "Importe del Débito contabilizado")
      @NotNull

    @Valid
    public BigDecimal getAmtacctdr() {
    return amtacctdr;
  }

  public void setAmtacctdr(BigDecimal amtacctdr) {
    this.amtacctdr = amtacctdr;
  }

  public JournalLine amtsourcecr(BigDecimal amtsourcecr) {
    this.amtsourcecr = amtsourcecr;
    return this;
  }

  /**
   * Importe del Crédito en moneda fuente
   * @return amtsourcecr
   **/
  @Schema(required = true, description = "Importe del Crédito en moneda fuente")
      @NotNull

    @Valid
    public BigDecimal getAmtsourcecr() {
    return amtsourcecr;
  }

  public void setAmtsourcecr(BigDecimal amtsourcecr) {
    this.amtsourcecr = amtsourcecr;
  }

  public JournalLine amtsourcedr(BigDecimal amtsourcedr) {
    this.amtsourcedr = amtsourcedr;
    return this;
  }

  /**
   * Importe del Débito en moneda fuente
   * @return amtsourcedr
   **/
  @Schema(required = true, description = "Importe del Débito en moneda fuente")
      @NotNull

    @Valid
    public BigDecimal getAmtsourcedr() {
    return amtsourcedr;
  }

  public void setAmtsourcedr(BigDecimal amtsourcedr) {
    this.amtsourcedr = amtsourcedr;
  }

  public JournalLine cConversiontypeId(Integer cConversiontypeId) {
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

  public JournalLine cCurrencyId(Integer cCurrencyId) {
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

  public JournalLine cElementvalueId(Integer cElementvalueId) {
    this.cElementvalueId = cElementvalueId;
    return this;
  }

  /**
   * Valor del Elemento
   * @return cElementvalueId
   **/
  @Schema(description = "Valor del Elemento")
  
    public Integer getCElementvalueId() {
    return cElementvalueId;
  }

  public void setCElementvalueId(Integer cElementvalueId) {
    this.cElementvalueId = cElementvalueId;
  }

  public JournalLine created(String created) {
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

  public JournalLine createdby(Integer createdby) {
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

  public JournalLine cUomId(Integer cUomId) {
    this.cUomId = cUomId;
    return this;
  }

  /**
   * Unidad de Medida
   * @return cUomId
   **/
  @Schema(description = "Unidad de Medida")
  
    public Integer getCUomId() {
    return cUomId;
  }

  public void setCUomId(Integer cUomId) {
    this.cUomId = cUomId;
  }

  public JournalLine currencyrate(BigDecimal currencyrate) {
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

  public JournalLine cValidcombinationId(Integer cValidcombinationId) {
    this.cValidcombinationId = cValidcombinationId;
    return this;
  }

  /**
   * Cuenta Contable
   * @return cValidcombinationId
   **/
  @Schema(required = true, description = "Cuenta Contable")
      @NotNull

    public Integer getCValidcombinationId() {
    return cValidcombinationId;
  }

  public void setCValidcombinationId(Integer cValidcombinationId) {
    this.cValidcombinationId = cValidcombinationId;
  }

  public JournalLine dateacct(String dateacct) {
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

  public JournalLine description(String description) {
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

  public JournalLine glJournalId(Integer glJournalId) {
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

  public JournalLine glJournallineId(Integer glJournallineId) {
    this.glJournallineId = glJournallineId;
    return this;
  }

  /**
   * Línea de Asiento
   * @return glJournallineId
   **/
  @Schema(required = true, description = "Línea de Asiento")
      @NotNull

    public Integer getGlJournallineId() {
    return glJournallineId;
  }

  public void setGlJournallineId(Integer glJournallineId) {
    this.glJournallineId = glJournallineId;
  }

  public JournalLine isactive(Boolean isactive) {
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

  public JournalLine isgenerated(Boolean isgenerated) {
    this.isgenerated = isgenerated;
    return this;
  }

  /**
   * Esta línea es generada
   * @return isgenerated
   **/
  @Schema(required = true, description = "Esta línea es generada")
      @NotNull

    public Boolean isIsgenerated() {
    return isgenerated;
  }

  public void setIsgenerated(Boolean isgenerated) {
    this.isgenerated = isgenerated;
  }

  public JournalLine line(Integer line) {
    this.line = line;
    return this;
  }

  /**
   * No. Línea único para este documento
   * @return line
   **/
  @Schema(required = true, description = "No. Línea único para este documento")
      @NotNull

    public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public JournalLine processed(Boolean processed) {
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

  public JournalLine qty(BigDecimal qty) {
    this.qty = qty;
    return this;
  }

  /**
   * Cantidad
   * @return qty
   **/
  @Schema(description = "Cantidad")
  
    @Valid
    public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public JournalLine updated(String updated) {
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

  public JournalLine updatedby(Integer updatedby) {
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

  public JournalLine additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public JournalLine addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public JournalLine referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public JournalLine addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    JournalLine journalLine = (JournalLine) o;
    return Objects.equals(this.adClientId, journalLine.adClientId) &&
        Objects.equals(this.adOrgId, journalLine.adOrgId) &&
        Objects.equals(this.amtacctcr, journalLine.amtacctcr) &&
        Objects.equals(this.amtacctdr, journalLine.amtacctdr) &&
        Objects.equals(this.amtsourcecr, journalLine.amtsourcecr) &&
        Objects.equals(this.amtsourcedr, journalLine.amtsourcedr) &&
        Objects.equals(this.cConversiontypeId, journalLine.cConversiontypeId) &&
        Objects.equals(this.cCurrencyId, journalLine.cCurrencyId) &&
        Objects.equals(this.cElementvalueId, journalLine.cElementvalueId) &&
        Objects.equals(this.created, journalLine.created) &&
        Objects.equals(this.createdby, journalLine.createdby) &&
        Objects.equals(this.cUomId, journalLine.cUomId) &&
        Objects.equals(this.currencyrate, journalLine.currencyrate) &&
        Objects.equals(this.cValidcombinationId, journalLine.cValidcombinationId) &&
        Objects.equals(this.dateacct, journalLine.dateacct) &&
        Objects.equals(this.description, journalLine.description) &&
        Objects.equals(this.glJournalId, journalLine.glJournalId) &&
        Objects.equals(this.glJournallineId, journalLine.glJournallineId) &&
        Objects.equals(this.isactive, journalLine.isactive) &&
        Objects.equals(this.isgenerated, journalLine.isgenerated) &&
        Objects.equals(this.line, journalLine.line) &&
        Objects.equals(this.processed, journalLine.processed) &&
        Objects.equals(this.qty, journalLine.qty) &&
        Objects.equals(this.updated, journalLine.updated) &&
        Objects.equals(this.updatedby, journalLine.updatedby) &&
        Objects.equals(this.additionalvalues, journalLine.additionalvalues) &&
        Objects.equals(this.referencedvalues, journalLine.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, amtacctcr, amtacctdr, amtsourcecr, amtsourcedr, cConversiontypeId, cCurrencyId, cElementvalueId, created, createdby, cUomId, currencyrate, cValidcombinationId, dateacct, description, glJournalId, glJournallineId, isactive, isgenerated, line, processed, qty, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JournalLine {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    amtacctcr: ").append(toIndentedString(amtacctcr)).append("\n");
    sb.append("    amtacctdr: ").append(toIndentedString(amtacctdr)).append("\n");
    sb.append("    amtsourcecr: ").append(toIndentedString(amtsourcecr)).append("\n");
    sb.append("    amtsourcedr: ").append(toIndentedString(amtsourcedr)).append("\n");
    sb.append("    cConversiontypeId: ").append(toIndentedString(cConversiontypeId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    cElementvalueId: ").append(toIndentedString(cElementvalueId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cUomId: ").append(toIndentedString(cUomId)).append("\n");
    sb.append("    currencyrate: ").append(toIndentedString(currencyrate)).append("\n");
    sb.append("    cValidcombinationId: ").append(toIndentedString(cValidcombinationId)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    glJournalId: ").append(toIndentedString(glJournalId)).append("\n");
    sb.append("    glJournallineId: ").append(toIndentedString(glJournallineId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isgenerated: ").append(toIndentedString(isgenerated)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    qty: ").append(toIndentedString(qty)).append("\n");
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
