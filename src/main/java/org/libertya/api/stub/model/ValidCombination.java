package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Propertiesmap;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ValidCombination
 */
@Validated



public class ValidCombination   {
  @JsonProperty("account_id")
  private Integer accountId = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("alias")
  private String alias = null;

  @JsonProperty("c_acctschema_id")
  private Integer cAcctschemaId = null;

  @JsonProperty("c_activity_id")
  private Integer cActivityId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_campaign_id")
  private Integer cCampaignId = null;

  @JsonProperty("combination")
  private String combination = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_salesregion_id")
  private Integer cSalesregionId = null;

  @JsonProperty("c_validcombination_id")
  private Integer cValidcombinationId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isfullyqualified")
  private Boolean isfullyqualified = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

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

  public ValidCombination accountId(Integer accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Cuenta usada
   * @return accountId
   **/
  @Schema(required = true, description = "Cuenta usada")
      @NotNull

    public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public ValidCombination adClientId(Integer adClientId) {
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

  public ValidCombination adOrgId(Integer adOrgId) {
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

  public ValidCombination adOrgtrxId(Integer adOrgtrxId) {
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

  public ValidCombination alias(String alias) {
    this.alias = alias;
    return this;
  }

  /**
   * Define un método alterno de identificar una combinación de cuenta
   * @return alias
   **/
  @Schema(description = "Define un método alterno de identificar una combinación de cuenta")
  
    public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public ValidCombination cAcctschemaId(Integer cAcctschemaId) {
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

  public ValidCombination cActivityId(Integer cActivityId) {
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

  public ValidCombination cBpartnerId(Integer cBpartnerId) {
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

  public ValidCombination cCampaignId(Integer cCampaignId) {
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

  public ValidCombination combination(String combination) {
    this.combination = combination;
    return this;
  }

  /**
   * Cuenta Contable
   * @return combination
   **/
  @Schema(description = "Cuenta Contable")
  
    public String getCombination() {
    return combination;
  }

  public void setCombination(String combination) {
    this.combination = combination;
  }

  public ValidCombination cProjectId(Integer cProjectId) {
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

  public ValidCombination created(String created) {
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

  public ValidCombination createdby(Integer createdby) {
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

  public ValidCombination cSalesregionId(Integer cSalesregionId) {
    this.cSalesregionId = cSalesregionId;
    return this;
  }

  /**
   * Región de cobertura de ventas
   * @return cSalesregionId
   **/
  @Schema(description = "Región de cobertura de ventas")
  
    public Integer getCSalesregionId() {
    return cSalesregionId;
  }

  public void setCSalesregionId(Integer cSalesregionId) {
    this.cSalesregionId = cSalesregionId;
  }

  public ValidCombination cValidcombinationId(Integer cValidcombinationId) {
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

  public ValidCombination description(String description) {
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

  public ValidCombination isactive(Boolean isactive) {
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

  public ValidCombination isfullyqualified(Boolean isfullyqualified) {
    this.isfullyqualified = isfullyqualified;
    return this;
  }

  /**
   * Esta cuenta es completamente calificada
   * @return isfullyqualified
   **/
  @Schema(required = true, description = "Esta cuenta es completamente calificada")
      @NotNull

    public Boolean isIsfullyqualified() {
    return isfullyqualified;
  }

  public void setIsfullyqualified(Boolean isfullyqualified) {
    this.isfullyqualified = isfullyqualified;
  }

  public ValidCombination mProductId(Integer mProductId) {
    this.mProductId = mProductId;
    return this;
  }

  /**
   * Producto; servicio o Artículo
   * @return mProductId
   **/
  @Schema(description = "Producto; servicio o Artículo")
  
    public Integer getMProductId() {
    return mProductId;
  }

  public void setMProductId(Integer mProductId) {
    this.mProductId = mProductId;
  }

  public ValidCombination updated(String updated) {
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

  public ValidCombination updatedby(Integer updatedby) {
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

  public ValidCombination additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ValidCombination addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ValidCombination referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ValidCombination addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ValidCombination validCombination = (ValidCombination) o;
    return Objects.equals(this.accountId, validCombination.accountId) &&
        Objects.equals(this.adClientId, validCombination.adClientId) &&
        Objects.equals(this.adOrgId, validCombination.adOrgId) &&
        Objects.equals(this.adOrgtrxId, validCombination.adOrgtrxId) &&
        Objects.equals(this.alias, validCombination.alias) &&
        Objects.equals(this.cAcctschemaId, validCombination.cAcctschemaId) &&
        Objects.equals(this.cActivityId, validCombination.cActivityId) &&
        Objects.equals(this.cBpartnerId, validCombination.cBpartnerId) &&
        Objects.equals(this.cCampaignId, validCombination.cCampaignId) &&
        Objects.equals(this.combination, validCombination.combination) &&
        Objects.equals(this.cProjectId, validCombination.cProjectId) &&
        Objects.equals(this.created, validCombination.created) &&
        Objects.equals(this.createdby, validCombination.createdby) &&
        Objects.equals(this.cSalesregionId, validCombination.cSalesregionId) &&
        Objects.equals(this.cValidcombinationId, validCombination.cValidcombinationId) &&
        Objects.equals(this.description, validCombination.description) &&
        Objects.equals(this.isactive, validCombination.isactive) &&
        Objects.equals(this.isfullyqualified, validCombination.isfullyqualified) &&
        Objects.equals(this.mProductId, validCombination.mProductId) &&
        Objects.equals(this.updated, validCombination.updated) &&
        Objects.equals(this.updatedby, validCombination.updatedby) &&
        Objects.equals(this.additionalvalues, validCombination.additionalvalues) &&
        Objects.equals(this.referencedvalues, validCombination.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, adClientId, adOrgId, adOrgtrxId, alias, cAcctschemaId, cActivityId, cBpartnerId, cCampaignId, combination, cProjectId, created, createdby, cSalesregionId, cValidcombinationId, description, isactive, isfullyqualified, mProductId, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidCombination {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    cAcctschemaId: ").append(toIndentedString(cAcctschemaId)).append("\n");
    sb.append("    cActivityId: ").append(toIndentedString(cActivityId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCampaignId: ").append(toIndentedString(cCampaignId)).append("\n");
    sb.append("    combination: ").append(toIndentedString(combination)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cSalesregionId: ").append(toIndentedString(cSalesregionId)).append("\n");
    sb.append("    cValidcombinationId: ").append(toIndentedString(cValidcombinationId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isfullyqualified: ").append(toIndentedString(isfullyqualified)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
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
