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
 * Promotion
 */
@Validated



public class Promotion   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_promotion_id")
  private Integer cPromotionId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("discountapplication")
  private String discountapplication = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("maxpromotionalcodes")
  private Integer maxpromotionalcodes = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("promotiontype")
  private String promotiontype = null;

  @JsonProperty("publishstatus")
  private String publishstatus = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("validfrom")
  private String validfrom = null;

  @JsonProperty("validto")
  private String validto = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Promotion adClientId(Integer adClientId) {
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

  public Promotion adOrgId(Integer adOrgId) {
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

  public Promotion cPromotionId(Integer cPromotionId) {
    this.cPromotionId = cPromotionId;
    return this;
  }

  /**
   * Promoción de Artículos
   * @return cPromotionId
   **/
  @Schema(required = true, description = "Promoción de Artículos")
      @NotNull

    public Integer getCPromotionId() {
    return cPromotionId;
  }

  public void setCPromotionId(Integer cPromotionId) {
    this.cPromotionId = cPromotionId;
  }

  public Promotion created(String created) {
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

  public Promotion createdby(Integer createdby) {
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

  public Promotion description(String description) {
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

  public Promotion discountapplication(String discountapplication) {
    this.discountapplication = discountapplication;
    return this;
  }

  /**
   * Forma de Aplicación del Descuento
   * @return discountapplication
   **/
  @Schema(required = true, description = "Forma de Aplicación del Descuento")
      @NotNull

    public String getDiscountapplication() {
    return discountapplication;
  }

  public void setDiscountapplication(String discountapplication) {
    this.discountapplication = discountapplication;
  }

  public Promotion isactive(Boolean isactive) {
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

  public Promotion maxpromotionalcodes(Integer maxpromotionalcodes) {
    this.maxpromotionalcodes = maxpromotionalcodes;
    return this;
  }

  /**
   * Cantidad máxima de códigos a generar para esta promoción
   * @return maxpromotionalcodes
   **/
  @Schema(required = true, description = "Cantidad máxima de códigos a generar para esta promoción")
      @NotNull

    public Integer getMaxpromotionalcodes() {
    return maxpromotionalcodes;
  }

  public void setMaxpromotionalcodes(Integer maxpromotionalcodes) {
    this.maxpromotionalcodes = maxpromotionalcodes;
  }

  public Promotion mDiscountschemaId(Integer mDiscountschemaId) {
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

  public Promotion name(String name) {
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

  public Promotion processed(Boolean processed) {
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

  public Promotion promotiontype(String promotiontype) {
    this.promotiontype = promotiontype;
    return this;
  }

  /**
   * Tipo de Promoción
   * @return promotiontype
   **/
  @Schema(required = true, description = "Tipo de Promoción")
      @NotNull

    public String getPromotiontype() {
    return promotiontype;
  }

  public void setPromotiontype(String promotiontype) {
    this.promotiontype = promotiontype;
  }

  public Promotion publishstatus(String publishstatus) {
    this.publishstatus = publishstatus;
    return this;
  }

  /**
   * Estado de Publicación
   * @return publishstatus
   **/
  @Schema(required = true, description = "Estado de Publicación")
      @NotNull

    public String getPublishstatus() {
    return publishstatus;
  }

  public void setPublishstatus(String publishstatus) {
    this.publishstatus = publishstatus;
  }

  public Promotion updated(String updated) {
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

  public Promotion updatedby(Integer updatedby) {
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

  public Promotion validfrom(String validfrom) {
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

  public Promotion validto(String validto) {
    this.validto = validto;
    return this;
  }

  /**
   * Válido hasta; incluyendo esta fecha (ultimo día)
   * @return validto
   **/
  @Schema(description = "Válido hasta; incluyendo esta fecha (ultimo día)")
  
    public String getValidto() {
    return validto;
  }

  public void setValidto(String validto) {
    this.validto = validto;
  }

  public Promotion additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Promotion addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Promotion referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Promotion addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Promotion promotion = (Promotion) o;
    return Objects.equals(this.adClientId, promotion.adClientId) &&
        Objects.equals(this.adOrgId, promotion.adOrgId) &&
        Objects.equals(this.cPromotionId, promotion.cPromotionId) &&
        Objects.equals(this.created, promotion.created) &&
        Objects.equals(this.createdby, promotion.createdby) &&
        Objects.equals(this.description, promotion.description) &&
        Objects.equals(this.discountapplication, promotion.discountapplication) &&
        Objects.equals(this.isactive, promotion.isactive) &&
        Objects.equals(this.maxpromotionalcodes, promotion.maxpromotionalcodes) &&
        Objects.equals(this.mDiscountschemaId, promotion.mDiscountschemaId) &&
        Objects.equals(this.name, promotion.name) &&
        Objects.equals(this.processed, promotion.processed) &&
        Objects.equals(this.promotiontype, promotion.promotiontype) &&
        Objects.equals(this.publishstatus, promotion.publishstatus) &&
        Objects.equals(this.updated, promotion.updated) &&
        Objects.equals(this.updatedby, promotion.updatedby) &&
        Objects.equals(this.validfrom, promotion.validfrom) &&
        Objects.equals(this.validto, promotion.validto) &&
        Objects.equals(this.additionalvalues, promotion.additionalvalues) &&
        Objects.equals(this.referencedvalues, promotion.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cPromotionId, created, createdby, description, discountapplication, isactive, maxpromotionalcodes, mDiscountschemaId, name, processed, promotiontype, publishstatus, updated, updatedby, validfrom, validto, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Promotion {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cPromotionId: ").append(toIndentedString(cPromotionId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountapplication: ").append(toIndentedString(discountapplication)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    maxpromotionalcodes: ").append(toIndentedString(maxpromotionalcodes)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    promotiontype: ").append(toIndentedString(promotiontype)).append("\n");
    sb.append("    publishstatus: ").append(toIndentedString(publishstatus)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    validfrom: ").append(toIndentedString(validfrom)).append("\n");
    sb.append("    validto: ").append(toIndentedString(validto)).append("\n");
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
