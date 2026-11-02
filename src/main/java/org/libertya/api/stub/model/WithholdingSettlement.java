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
 * WithholdingSettlement
 */
@Validated



public class WithholdingSettlement   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_region_id")
  private Integer cRegionId = null;

  @JsonProperty("c_retencionschema_id")
  private Integer cRetencionschemaId = null;

  @JsonProperty("c_withholdingsettlement_id")
  private Integer cWithholdingsettlementId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

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

  public WithholdingSettlement adClientId(Integer adClientId) {
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

  public WithholdingSettlement adOrgId(Integer adOrgId) {
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

  public WithholdingSettlement amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Importe en una moneda definida
   * @return amount
   **/
  @Schema(description = "Importe en una moneda definida")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public WithholdingSettlement cCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
    return this;
  }

  /**
   * Liquidaciones de Tarjetas de Crédito
   * @return cCreditcardsettlementId
   **/
  @Schema(required = true, description = "Liquidaciones de Tarjetas de Crédito")
      @NotNull

    public Integer getCCreditcardsettlementId() {
    return cCreditcardsettlementId;
  }

  public void setCCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
  }

  public WithholdingSettlement created(String created) {
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

  public WithholdingSettlement createdby(Integer createdby) {
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

  public WithholdingSettlement cRegionId(Integer cRegionId) {
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

  public WithholdingSettlement cRetencionschemaId(Integer cRetencionschemaId) {
    this.cRetencionschemaId = cRetencionschemaId;
    return this;
  }

  /**
   *  
   * @return cRetencionschemaId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCRetencionschemaId() {
    return cRetencionschemaId;
  }

  public void setCRetencionschemaId(Integer cRetencionschemaId) {
    this.cRetencionschemaId = cRetencionschemaId;
  }

  public WithholdingSettlement cWithholdingsettlementId(Integer cWithholdingsettlementId) {
    this.cWithholdingsettlementId = cWithholdingsettlementId;
    return this;
  }

  /**
   *  
   * @return cWithholdingsettlementId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCWithholdingsettlementId() {
    return cWithholdingsettlementId;
  }

  public void setCWithholdingsettlementId(Integer cWithholdingsettlementId) {
    this.cWithholdingsettlementId = cWithholdingsettlementId;
  }

  public WithholdingSettlement isactive(Boolean isactive) {
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

  public WithholdingSettlement updated(String updated) {
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

  public WithholdingSettlement updatedby(Integer updatedby) {
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

  public WithholdingSettlement additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public WithholdingSettlement addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public WithholdingSettlement referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public WithholdingSettlement addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    WithholdingSettlement withholdingSettlement = (WithholdingSettlement) o;
    return Objects.equals(this.adClientId, withholdingSettlement.adClientId) &&
        Objects.equals(this.adOrgId, withholdingSettlement.adOrgId) &&
        Objects.equals(this.amount, withholdingSettlement.amount) &&
        Objects.equals(this.cCreditcardsettlementId, withholdingSettlement.cCreditcardsettlementId) &&
        Objects.equals(this.created, withholdingSettlement.created) &&
        Objects.equals(this.createdby, withholdingSettlement.createdby) &&
        Objects.equals(this.cRegionId, withholdingSettlement.cRegionId) &&
        Objects.equals(this.cRetencionschemaId, withholdingSettlement.cRetencionschemaId) &&
        Objects.equals(this.cWithholdingsettlementId, withholdingSettlement.cWithholdingsettlementId) &&
        Objects.equals(this.isactive, withholdingSettlement.isactive) &&
        Objects.equals(this.updated, withholdingSettlement.updated) &&
        Objects.equals(this.updatedby, withholdingSettlement.updatedby) &&
        Objects.equals(this.additionalvalues, withholdingSettlement.additionalvalues) &&
        Objects.equals(this.referencedvalues, withholdingSettlement.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, amount, cCreditcardsettlementId, created, createdby, cRegionId, cRetencionschemaId, cWithholdingsettlementId, isactive, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WithholdingSettlement {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRegionId: ").append(toIndentedString(cRegionId)).append("\n");
    sb.append("    cRetencionschemaId: ").append(toIndentedString(cRetencionschemaId)).append("\n");
    sb.append("    cWithholdingsettlementId: ").append(toIndentedString(cWithholdingsettlementId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
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
