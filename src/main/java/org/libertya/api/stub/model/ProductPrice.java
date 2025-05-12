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
 * ProductPrice
 */
@Validated



public class ProductPrice   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("m_pricelist_version_id")
  private Integer mPricelistVersionId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("pricelimit")
  private BigDecimal pricelimit = null;

  @JsonProperty("pricelist")
  private BigDecimal pricelist = null;

  @JsonProperty("pricestd")
  private BigDecimal pricestd = null;

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

  public ProductPrice adClientId(Integer adClientId) {
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

  public ProductPrice adOrgId(Integer adOrgId) {
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

  public ProductPrice created(String created) {
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

  public ProductPrice createdby(Integer createdby) {
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

  public ProductPrice isactive(Boolean isactive) {
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

  public ProductPrice mPricelistVersionId(Integer mPricelistVersionId) {
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

  public ProductPrice mProductId(Integer mProductId) {
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

  public ProductPrice pricelimit(BigDecimal pricelimit) {
    this.pricelimit = pricelimit;
    return this;
  }

  /**
   * Precio más bajo del producto
   * @return pricelimit
   **/
  @Schema(required = true, description = "Precio más bajo del producto")
      @NotNull

    @Valid
    public BigDecimal getPricelimit() {
    return pricelimit;
  }

  public void setPricelimit(BigDecimal pricelimit) {
    this.pricelimit = pricelimit;
  }

  public ProductPrice pricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
    return this;
  }

  /**
   * Precio de Tarifa
   * @return pricelist
   **/
  @Schema(required = true, description = "Precio de Tarifa")
      @NotNull

    @Valid
    public BigDecimal getPricelist() {
    return pricelist;
  }

  public void setPricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
  }

  public ProductPrice pricestd(BigDecimal pricestd) {
    this.pricestd = pricestd;
    return this;
  }

  /**
   * Precio Estándar
   * @return pricestd
   **/
  @Schema(required = true, description = "Precio Estándar")
      @NotNull

    @Valid
    public BigDecimal getPricestd() {
    return pricestd;
  }

  public void setPricestd(BigDecimal pricestd) {
    this.pricestd = pricestd;
  }

  public ProductPrice updated(String updated) {
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

  public ProductPrice updatedby(Integer updatedby) {
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

  public ProductPrice additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ProductPrice addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ProductPrice referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ProductPrice addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ProductPrice productPrice = (ProductPrice) o;
    return Objects.equals(this.adClientId, productPrice.adClientId) &&
        Objects.equals(this.adOrgId, productPrice.adOrgId) &&
        Objects.equals(this.created, productPrice.created) &&
        Objects.equals(this.createdby, productPrice.createdby) &&
        Objects.equals(this.isactive, productPrice.isactive) &&
        Objects.equals(this.mPricelistVersionId, productPrice.mPricelistVersionId) &&
        Objects.equals(this.mProductId, productPrice.mProductId) &&
        Objects.equals(this.pricelimit, productPrice.pricelimit) &&
        Objects.equals(this.pricelist, productPrice.pricelist) &&
        Objects.equals(this.pricestd, productPrice.pricestd) &&
        Objects.equals(this.updated, productPrice.updated) &&
        Objects.equals(this.updatedby, productPrice.updatedby) &&
        Objects.equals(this.additionalvalues, productPrice.additionalvalues) &&
        Objects.equals(this.referencedvalues, productPrice.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, created, createdby, isactive, mPricelistVersionId, mProductId, pricelimit, pricelist, pricestd, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductPrice {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    mPricelistVersionId: ").append(toIndentedString(mPricelistVersionId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    pricelimit: ").append(toIndentedString(pricelimit)).append("\n");
    sb.append("    pricelist: ").append(toIndentedString(pricelist)).append("\n");
    sb.append("    pricestd: ").append(toIndentedString(pricestd)).append("\n");
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
