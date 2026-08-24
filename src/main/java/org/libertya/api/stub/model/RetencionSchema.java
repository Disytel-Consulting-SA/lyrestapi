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
 * RetencionSchema
 */
@Validated



public class RetencionSchema   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_bpartner_recaudador_id")
  private Integer cBpartnerRecaudadorId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_region_id")
  private Integer cRegionId = null;

  @JsonProperty("c_retencionprocessor_id")
  private Integer cRetencionprocessorId = null;

  @JsonProperty("c_retencionschema_id")
  private Integer cRetencionschemaId = null;

  @JsonProperty("c_retenciontype_id")
  private Integer cRetenciontypeId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("ismanual")
  private Boolean ismanual = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("retencionapplication")
  private String retencionapplication = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public RetencionSchema adClientId(Integer adClientId) {
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

  public RetencionSchema adOrgId(Integer adOrgId) {
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

  public RetencionSchema cBpartnerRecaudadorId(Integer cBpartnerRecaudadorId) {
    this.cBpartnerRecaudadorId = cBpartnerRecaudadorId;
    return this;
  }

  /**
   *  
   * @return cBpartnerRecaudadorId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCBpartnerRecaudadorId() {
    return cBpartnerRecaudadorId;
  }

  public void setCBpartnerRecaudadorId(Integer cBpartnerRecaudadorId) {
    this.cBpartnerRecaudadorId = cBpartnerRecaudadorId;
  }

  public RetencionSchema created(String created) {
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

  public RetencionSchema createdby(Integer createdby) {
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

  public RetencionSchema cRegionId(Integer cRegionId) {
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

  public RetencionSchema cRetencionprocessorId(Integer cRetencionprocessorId) {
    this.cRetencionprocessorId = cRetencionprocessorId;
    return this;
  }

  /**
   *  
   * @return cRetencionprocessorId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCRetencionprocessorId() {
    return cRetencionprocessorId;
  }

  public void setCRetencionprocessorId(Integer cRetencionprocessorId) {
    this.cRetencionprocessorId = cRetencionprocessorId;
  }

  public RetencionSchema cRetencionschemaId(Integer cRetencionschemaId) {
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

  public RetencionSchema cRetenciontypeId(Integer cRetenciontypeId) {
    this.cRetenciontypeId = cRetenciontypeId;
    return this;
  }

  /**
   *  
   * @return cRetenciontypeId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCRetenciontypeId() {
    return cRetenciontypeId;
  }

  public void setCRetenciontypeId(Integer cRetenciontypeId) {
    this.cRetenciontypeId = cRetenciontypeId;
  }

  public RetencionSchema description(String description) {
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

  public RetencionSchema isactive(Boolean isactive) {
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

  public RetencionSchema ismanual(Boolean ismanual) {
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

  public RetencionSchema name(String name) {
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

  public RetencionSchema retencionapplication(String retencionapplication) {
    this.retencionapplication = retencionapplication;
    return this;
  }

  /**
   * Get retencionapplication
   * @return retencionapplication
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getRetencionapplication() {
    return retencionapplication;
  }

  public void setRetencionapplication(String retencionapplication) {
    this.retencionapplication = retencionapplication;
  }

  public RetencionSchema updated(String updated) {
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

  public RetencionSchema updatedby(Integer updatedby) {
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

  public RetencionSchema value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Clave de búsqueda para el registro en el formato requerido; debe ser única
   * @return value
   **/
  @Schema(required = true, description = "Clave de búsqueda para el registro en el formato requerido; debe ser única")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public RetencionSchema additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public RetencionSchema addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public RetencionSchema referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public RetencionSchema addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    RetencionSchema retencionSchema = (RetencionSchema) o;
    return Objects.equals(this.adClientId, retencionSchema.adClientId) &&
        Objects.equals(this.adOrgId, retencionSchema.adOrgId) &&
        Objects.equals(this.cBpartnerRecaudadorId, retencionSchema.cBpartnerRecaudadorId) &&
        Objects.equals(this.created, retencionSchema.created) &&
        Objects.equals(this.createdby, retencionSchema.createdby) &&
        Objects.equals(this.cRegionId, retencionSchema.cRegionId) &&
        Objects.equals(this.cRetencionprocessorId, retencionSchema.cRetencionprocessorId) &&
        Objects.equals(this.cRetencionschemaId, retencionSchema.cRetencionschemaId) &&
        Objects.equals(this.cRetenciontypeId, retencionSchema.cRetenciontypeId) &&
        Objects.equals(this.description, retencionSchema.description) &&
        Objects.equals(this.isactive, retencionSchema.isactive) &&
        Objects.equals(this.ismanual, retencionSchema.ismanual) &&
        Objects.equals(this.name, retencionSchema.name) &&
        Objects.equals(this.retencionapplication, retencionSchema.retencionapplication) &&
        Objects.equals(this.updated, retencionSchema.updated) &&
        Objects.equals(this.updatedby, retencionSchema.updatedby) &&
        Objects.equals(this.value, retencionSchema.value) &&
        Objects.equals(this.additionalvalues, retencionSchema.additionalvalues) &&
        Objects.equals(this.referencedvalues, retencionSchema.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cBpartnerRecaudadorId, created, createdby, cRegionId, cRetencionprocessorId, cRetencionschemaId, cRetenciontypeId, description, isactive, ismanual, name, retencionapplication, updated, updatedby, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetencionSchema {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cBpartnerRecaudadorId: ").append(toIndentedString(cBpartnerRecaudadorId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRegionId: ").append(toIndentedString(cRegionId)).append("\n");
    sb.append("    cRetencionprocessorId: ").append(toIndentedString(cRetencionprocessorId)).append("\n");
    sb.append("    cRetencionschemaId: ").append(toIndentedString(cRetencionschemaId)).append("\n");
    sb.append("    cRetenciontypeId: ").append(toIndentedString(cRetenciontypeId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    ismanual: ").append(toIndentedString(ismanual)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    retencionapplication: ").append(toIndentedString(retencionapplication)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
