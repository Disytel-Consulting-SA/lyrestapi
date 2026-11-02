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
 * RetencionType
 */
@Validated



public class RetencionType   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_retenciontype_id")
  private Integer cRetenciontypeId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("is_by_region")
  private Boolean isByRegion = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("retentiontype")
  private String retentiontype = null;

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

  public RetencionType adClientId(Integer adClientId) {
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

  public RetencionType adOrgId(Integer adOrgId) {
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

  public RetencionType created(String created) {
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

  public RetencionType createdby(Integer createdby) {
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

  public RetencionType cRetenciontypeId(Integer cRetenciontypeId) {
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

  public RetencionType description(String description) {
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

  public RetencionType isactive(Boolean isactive) {
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

  public RetencionType isByRegion(Boolean isByRegion) {
    this.isByRegion = isByRegion;
    return this;
  }

  /**
   *  
   * @return isByRegion
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsByRegion() {
    return isByRegion;
  }

  public void setIsByRegion(Boolean isByRegion) {
    this.isByRegion = isByRegion;
  }

  public RetencionType mProductId(Integer mProductId) {
    this.mProductId = mProductId;
    return this;
  }

  /**
   * Producto; servicio o Artículo
   * @return mProductId
   **/
  @Schema(required = true, description = "Producto; servicio o Artículo")
      @NotNull

    public Integer getMProductId() {
    return mProductId;
  }

  public void setMProductId(Integer mProductId) {
    this.mProductId = mProductId;
  }

  public RetencionType name(String name) {
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

  public RetencionType retentiontype(String retentiontype) {
    this.retentiontype = retentiontype;
    return this;
  }

  /**
   *  
   * @return retentiontype
   **/
  @Schema(description = " ")
  
    public String getRetentiontype() {
    return retentiontype;
  }

  public void setRetentiontype(String retentiontype) {
    this.retentiontype = retentiontype;
  }

  public RetencionType updated(String updated) {
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

  public RetencionType updatedby(Integer updatedby) {
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

  public RetencionType additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public RetencionType addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public RetencionType referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public RetencionType addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    RetencionType retencionType = (RetencionType) o;
    return Objects.equals(this.adClientId, retencionType.adClientId) &&
        Objects.equals(this.adOrgId, retencionType.adOrgId) &&
        Objects.equals(this.created, retencionType.created) &&
        Objects.equals(this.createdby, retencionType.createdby) &&
        Objects.equals(this.cRetenciontypeId, retencionType.cRetenciontypeId) &&
        Objects.equals(this.description, retencionType.description) &&
        Objects.equals(this.isactive, retencionType.isactive) &&
        Objects.equals(this.isByRegion, retencionType.isByRegion) &&
        Objects.equals(this.mProductId, retencionType.mProductId) &&
        Objects.equals(this.name, retencionType.name) &&
        Objects.equals(this.retentiontype, retencionType.retentiontype) &&
        Objects.equals(this.updated, retencionType.updated) &&
        Objects.equals(this.updatedby, retencionType.updatedby) &&
        Objects.equals(this.additionalvalues, retencionType.additionalvalues) &&
        Objects.equals(this.referencedvalues, retencionType.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, created, createdby, cRetenciontypeId, description, isactive, isByRegion, mProductId, name, retentiontype, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetencionType {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRetenciontypeId: ").append(toIndentedString(cRetenciontypeId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isByRegion: ").append(toIndentedString(isByRegion)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    retentiontype: ").append(toIndentedString(retentiontype)).append("\n");
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
