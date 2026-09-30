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
 * ProductPO
 */
@Validated



public class ProductPO   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_uom_id")
  private Integer cUomId = null;

  @JsonProperty("deliverytime_promised")
  private Integer deliverytimePromised = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("iscurrentvendor")
  private Boolean iscurrentvendor = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("order_min")
  private BigDecimal orderMin = null;

  @JsonProperty("order_pack")
  private BigDecimal orderPack = null;

  @JsonProperty("pricelist")
  private BigDecimal pricelist = null;

  @JsonProperty("pricepo")
  private BigDecimal pricepo = null;

  @JsonProperty("upc")
  private String upc = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("vendorproductno")
  private String vendorproductno = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public ProductPO adClientId(Integer adClientId) {
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

  public ProductPO adOrgId(Integer adOrgId) {
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

  public ProductPO cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Identifica una Entidad Comercial
   * @return cBpartnerId
   **/
  @Schema(required = true, description = "Identifica una Entidad Comercial")
      @NotNull

    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public ProductPO cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Moneda para este registro
   * @return cCurrencyId
   **/
  @Schema(description = "Moneda para este registro")
  
    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public ProductPO created(String created) {
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

  public ProductPO createdby(Integer createdby) {
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

  public ProductPO cUomId(Integer cUomId) {
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

  public ProductPO deliverytimePromised(Integer deliverytimePromised) {
    this.deliverytimePromised = deliverytimePromised;
    return this;
  }

  /**
   * Días prometidos entre la orden y la entrega
   * @return deliverytimePromised
   **/
  @Schema(description = "Días prometidos entre la orden y la entrega")
  
    public Integer getDeliverytimePromised() {
    return deliverytimePromised;
  }

  public void setDeliverytimePromised(Integer deliverytimePromised) {
    this.deliverytimePromised = deliverytimePromised;
  }

  public ProductPO isactive(Boolean isactive) {
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

  public ProductPO iscurrentvendor(Boolean iscurrentvendor) {
    this.iscurrentvendor = iscurrentvendor;
    return this;
  }

  /**
   * Use este proveedor para el cálculo de precio y reabastecimiento de inventario
   * @return iscurrentvendor
   **/
  @Schema(required = true, description = "Use este proveedor para el cálculo de precio y reabastecimiento de inventario")
      @NotNull

    public Boolean isIscurrentvendor() {
    return iscurrentvendor;
  }

  public void setIscurrentvendor(Boolean iscurrentvendor) {
    this.iscurrentvendor = iscurrentvendor;
  }

  public ProductPO mProductId(Integer mProductId) {
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

  public ProductPO orderMin(BigDecimal orderMin) {
    this.orderMin = orderMin;
    return this;
  }

  /**
   * Cantidad Mínima de Pedido en la UM
   * @return orderMin
   **/
  @Schema(description = "Cantidad Mínima de Pedido en la UM")
  
    @Valid
    public BigDecimal getOrderMin() {
    return orderMin;
  }

  public void setOrderMin(BigDecimal orderMin) {
    this.orderMin = orderMin;
  }

  public ProductPO orderPack(BigDecimal orderPack) {
    this.orderPack = orderPack;
    return this;
  }

  /**
   * Tamaño del paquete a ordenar en UM (Ej. Conjunto a ordenar de 5 unidades)
   * @return orderPack
   **/
  @Schema(description = "Tamaño del paquete a ordenar en UM (Ej. Conjunto a ordenar de 5 unidades)")
  
    @Valid
    public BigDecimal getOrderPack() {
    return orderPack;
  }

  public void setOrderPack(BigDecimal orderPack) {
    this.orderPack = orderPack;
  }

  public ProductPO pricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
    return this;
  }

  /**
   * Precio de Tarifa
   * @return pricelist
   **/
  @Schema(description = "Precio de Tarifa")
  
    @Valid
    public BigDecimal getPricelist() {
    return pricelist;
  }

  public void setPricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
  }

  public ProductPO pricepo(BigDecimal pricepo) {
    this.pricepo = pricepo;
    return this;
  }

  /**
   * Precio Pedido a Proveedor
   * @return pricepo
   **/
  @Schema(description = "Precio Pedido a Proveedor")
  
    @Valid
    public BigDecimal getPricepo() {
    return pricepo;
  }

  public void setPricepo(BigDecimal pricepo) {
    this.pricepo = pricepo;
  }

  public ProductPO upc(String upc) {
    this.upc = upc;
    return this;
  }

  /**
   * Código de Barras (Universal Product Code o su súper conjunto European Article NUMERIC)
   * @return upc
   **/
  @Schema(description = "Código de Barras (Universal Product Code o su súper conjunto European Article NUMERIC)")
  
    public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public ProductPO updated(String updated) {
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

  public ProductPO updatedby(Integer updatedby) {
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

  public ProductPO vendorproductno(String vendorproductno) {
    this.vendorproductno = vendorproductno;
    return this;
  }

  /**
   * Proveedor
   * @return vendorproductno
   **/
  @Schema(required = true, description = "Proveedor")
      @NotNull

    public String getVendorproductno() {
    return vendorproductno;
  }

  public void setVendorproductno(String vendorproductno) {
    this.vendorproductno = vendorproductno;
  }

  public ProductPO additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ProductPO addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ProductPO referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ProductPO addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ProductPO productPO = (ProductPO) o;
    return Objects.equals(this.adClientId, productPO.adClientId) &&
        Objects.equals(this.adOrgId, productPO.adOrgId) &&
        Objects.equals(this.cBpartnerId, productPO.cBpartnerId) &&
        Objects.equals(this.cCurrencyId, productPO.cCurrencyId) &&
        Objects.equals(this.created, productPO.created) &&
        Objects.equals(this.createdby, productPO.createdby) &&
        Objects.equals(this.cUomId, productPO.cUomId) &&
        Objects.equals(this.deliverytimePromised, productPO.deliverytimePromised) &&
        Objects.equals(this.isactive, productPO.isactive) &&
        Objects.equals(this.iscurrentvendor, productPO.iscurrentvendor) &&
        Objects.equals(this.mProductId, productPO.mProductId) &&
        Objects.equals(this.orderMin, productPO.orderMin) &&
        Objects.equals(this.orderPack, productPO.orderPack) &&
        Objects.equals(this.pricelist, productPO.pricelist) &&
        Objects.equals(this.pricepo, productPO.pricepo) &&
        Objects.equals(this.upc, productPO.upc) &&
        Objects.equals(this.updated, productPO.updated) &&
        Objects.equals(this.updatedby, productPO.updatedby) &&
        Objects.equals(this.vendorproductno, productPO.vendorproductno) &&
        Objects.equals(this.additionalvalues, productPO.additionalvalues) &&
        Objects.equals(this.referencedvalues, productPO.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cBpartnerId, cCurrencyId, created, createdby, cUomId, deliverytimePromised, isactive, iscurrentvendor, mProductId, orderMin, orderPack, pricelist, pricepo, upc, updated, updatedby, vendorproductno, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductPO {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cUomId: ").append(toIndentedString(cUomId)).append("\n");
    sb.append("    deliverytimePromised: ").append(toIndentedString(deliverytimePromised)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    iscurrentvendor: ").append(toIndentedString(iscurrentvendor)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    orderMin: ").append(toIndentedString(orderMin)).append("\n");
    sb.append("    orderPack: ").append(toIndentedString(orderPack)).append("\n");
    sb.append("    pricelist: ").append(toIndentedString(pricelist)).append("\n");
    sb.append("    pricepo: ").append(toIndentedString(pricepo)).append("\n");
    sb.append("    upc: ").append(toIndentedString(upc)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    vendorproductno: ").append(toIndentedString(vendorproductno)).append("\n");
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
