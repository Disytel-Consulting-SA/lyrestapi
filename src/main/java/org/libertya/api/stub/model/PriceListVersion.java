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
 * PriceListVersion
 */
@Validated



public class PriceListVersion   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("m_pricelist_id")
  private Integer mPricelistId = null;

  @JsonProperty("m_pricelist_version_base_id")
  private Integer mPricelistVersionBaseId = null;

  @JsonProperty("m_pricelist_version_id")
  private Integer mPricelistVersionId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("proccreate")
  private String proccreate = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("validfrom")
  private String validfrom = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public PriceListVersion adClientId(Integer adClientId) {
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

  public PriceListVersion adComponentobjectuid(String adComponentobjectuid) {
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

  public PriceListVersion adComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
    return this;
  }

  /**
   * Versión de Componente propietaria de este registro
   * @return adComponentversionId
   **/
  @Schema(description = "Versión de Componente propietaria de este registro")
  
    public Integer getAdComponentversionId() {
    return adComponentversionId;
  }

  public void setAdComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
  }

  public PriceListVersion adOrgId(Integer adOrgId) {
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

  public PriceListVersion created(String created) {
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

  public PriceListVersion createdby(Integer createdby) {
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

  public PriceListVersion description(String description) {
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

  public PriceListVersion isactive(Boolean isactive) {
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

  public PriceListVersion mDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
    return this;
  }

  /**
   * Esquema para calcular el porcentaje de descuento comercial
   * @return mDiscountschemaId
   **/
  @Schema(required = true, description = "Esquema para calcular el porcentaje de descuento comercial")
      @NotNull

    public Integer getMDiscountschemaId() {
    return mDiscountschemaId;
  }

  public void setMDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
  }

  public PriceListVersion mPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
    return this;
  }

  /**
   * Identificador único de mi lista de precios
   * @return mPricelistId
   **/
  @Schema(required = true, description = "Identificador único de mi lista de precios")
      @NotNull

    public Integer getMPricelistId() {
    return mPricelistId;
  }

  public void setMPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
  }

  public PriceListVersion mPricelistVersionBaseId(Integer mPricelistVersionBaseId) {
    this.mPricelistVersionBaseId = mPricelistVersionBaseId;
    return this;
  }

  /**
   * Fuente para el cálculo de la Lista de Precios
   * @return mPricelistVersionBaseId
   **/
  @Schema(description = "Fuente para el cálculo de la Lista de Precios")
  
    public Integer getMPricelistVersionBaseId() {
    return mPricelistVersionBaseId;
  }

  public void setMPricelistVersionBaseId(Integer mPricelistVersionBaseId) {
    this.mPricelistVersionBaseId = mPricelistVersionBaseId;
  }

  public PriceListVersion mPricelistVersionId(Integer mPricelistVersionId) {
    this.mPricelistVersionId = mPricelistVersionId;
    return this;
  }

  /**
   * Versión de Tarifa
   * @return mPricelistVersionId
   **/
  @Schema(required = true, description = "Versión de Tarifa")
      @NotNull

    public Integer getMPricelistVersionId() {
    return mPricelistVersionId;
  }

  public void setMPricelistVersionId(Integer mPricelistVersionId) {
    this.mPricelistVersionId = mPricelistVersionId;
  }

  public PriceListVersion name(String name) {
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

  public PriceListVersion proccreate(String proccreate) {
    this.proccreate = proccreate;
    return this;
  }

  /**
   *  
   * @return proccreate
   **/
  @Schema(description = " ")
  
    public String getProccreate() {
    return proccreate;
  }

  public void setProccreate(String proccreate) {
    this.proccreate = proccreate;
  }

  public PriceListVersion updated(String updated) {
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

  public PriceListVersion updatedby(Integer updatedby) {
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

  public PriceListVersion validfrom(String validfrom) {
    this.validfrom = validfrom;
    return this;
  }

  /**
   * Válido desde; incluyendo esta fecha (primer día)
   * @return validfrom
   **/
  @Schema(required = true, description = "Válido desde; incluyendo esta fecha (primer día)")
      @NotNull

    public String getValidfrom() {
    return validfrom;
  }

  public void setValidfrom(String validfrom) {
    this.validfrom = validfrom;
  }

  public PriceListVersion additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public PriceListVersion addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public PriceListVersion referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public PriceListVersion addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    PriceListVersion priceListVersion = (PriceListVersion) o;
    return Objects.equals(this.adClientId, priceListVersion.adClientId) &&
        Objects.equals(this.adComponentobjectuid, priceListVersion.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, priceListVersion.adComponentversionId) &&
        Objects.equals(this.adOrgId, priceListVersion.adOrgId) &&
        Objects.equals(this.created, priceListVersion.created) &&
        Objects.equals(this.createdby, priceListVersion.createdby) &&
        Objects.equals(this.description, priceListVersion.description) &&
        Objects.equals(this.isactive, priceListVersion.isactive) &&
        Objects.equals(this.mDiscountschemaId, priceListVersion.mDiscountschemaId) &&
        Objects.equals(this.mPricelistId, priceListVersion.mPricelistId) &&
        Objects.equals(this.mPricelistVersionBaseId, priceListVersion.mPricelistVersionBaseId) &&
        Objects.equals(this.mPricelistVersionId, priceListVersion.mPricelistVersionId) &&
        Objects.equals(this.name, priceListVersion.name) &&
        Objects.equals(this.proccreate, priceListVersion.proccreate) &&
        Objects.equals(this.updated, priceListVersion.updated) &&
        Objects.equals(this.updatedby, priceListVersion.updatedby) &&
        Objects.equals(this.validfrom, priceListVersion.validfrom) &&
        Objects.equals(this.additionalvalues, priceListVersion.additionalvalues) &&
        Objects.equals(this.referencedvalues, priceListVersion.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adOrgId, created, createdby, description, isactive, mDiscountschemaId, mPricelistId, mPricelistVersionBaseId, mPricelistVersionId, name, proccreate, updated, updatedby, validfrom, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceListVersion {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    mPricelistId: ").append(toIndentedString(mPricelistId)).append("\n");
    sb.append("    mPricelistVersionBaseId: ").append(toIndentedString(mPricelistVersionBaseId)).append("\n");
    sb.append("    mPricelistVersionId: ").append(toIndentedString(mPricelistVersionId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    proccreate: ").append(toIndentedString(proccreate)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    validfrom: ").append(toIndentedString(validfrom)).append("\n");
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
