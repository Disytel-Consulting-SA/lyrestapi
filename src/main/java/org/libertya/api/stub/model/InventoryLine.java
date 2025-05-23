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
 * InventoryLine
 */
@Validated



public class InventoryLine   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("cost")
  private BigDecimal cost = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("inventorytype")
  private String inventorytype = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("line")
  private Integer line = null;

  @JsonProperty("m_attributesetinstance_id")
  private Integer mAttributesetinstanceId = null;

  @JsonProperty("m_inventory_id")
  private Integer mInventoryId = null;

  @JsonProperty("m_inventoryline_id")
  private Integer mInventorylineId = null;

  @JsonProperty("m_locator_id")
  private Integer mLocatorId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("qtybook")
  private BigDecimal qtybook = null;

  @JsonProperty("qtycount")
  private BigDecimal qtycount = null;

  @JsonProperty("qtycountwithoutchargesign")
  private BigDecimal qtycountwithoutchargesign = null;

  @JsonProperty("qtyinternaluse")
  private BigDecimal qtyinternaluse = null;

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

  public InventoryLine adClientId(Integer adClientId) {
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

  public InventoryLine adOrgId(Integer adOrgId) {
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

  public InventoryLine cChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
    return this;
  }

  /**
   * Cargos adicionales del documento
   * @return cChargeId
   **/
  @Schema(description = "Cargos adicionales del documento")
  
    public Integer getCChargeId() {
    return cChargeId;
  }

  public void setCChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
  }

  public InventoryLine cost(BigDecimal cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Información Coste
   * @return cost
   **/
  @Schema(required = true, description = "Información Coste")
      @NotNull

    @Valid
    public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  public InventoryLine created(String created) {
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

  public InventoryLine createdby(Integer createdby) {
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

  public InventoryLine description(String description) {
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

  public InventoryLine inventorytype(String inventorytype) {
    this.inventorytype = inventorytype;
    return this;
  }

  /**
   * Tipo de Diferencia de Inventario
   * @return inventorytype
   **/
  @Schema(required = true, description = "Tipo de Diferencia de Inventario")
      @NotNull

    public String getInventorytype() {
    return inventorytype;
  }

  public void setInventorytype(String inventorytype) {
    this.inventorytype = inventorytype;
  }

  public InventoryLine isactive(Boolean isactive) {
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

  public InventoryLine line(Integer line) {
    this.line = line;
    return this;
  }

  /**
   * No. Línea único para este documento
   * @return line
   **/
  @Schema(description = "No. Línea único para este documento")
  
    public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public InventoryLine mAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
    return this;
  }

  /**
   * Instancia del Conjunto de Attributos del Producto
   * @return mAttributesetinstanceId
   **/
  @Schema(required = true, description = "Instancia del Conjunto de Attributos del Producto")
      @NotNull

    public Integer getMAttributesetinstanceId() {
    return mAttributesetinstanceId;
  }

  public void setMAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
  }

  public InventoryLine mInventoryId(Integer mInventoryId) {
    this.mInventoryId = mInventoryId;
    return this;
  }

  /**
   * Parámetros para el Inventario Físico
   * @return mInventoryId
   **/
  @Schema(required = true, description = "Parámetros para el Inventario Físico")
      @NotNull

    public Integer getMInventoryId() {
    return mInventoryId;
  }

  public void setMInventoryId(Integer mInventoryId) {
    this.mInventoryId = mInventoryId;
  }

  public InventoryLine mInventorylineId(Integer mInventorylineId) {
    this.mInventorylineId = mInventorylineId;
    return this;
  }

  /**
   * Línea única en un documento de Inventario
   * @return mInventorylineId
   **/
  @Schema(required = true, description = "Línea única en un documento de Inventario")
      @NotNull

    public Integer getMInventorylineId() {
    return mInventorylineId;
  }

  public void setMInventorylineId(Integer mInventorylineId) {
    this.mInventorylineId = mInventorylineId;
  }

  public InventoryLine mLocatorId(Integer mLocatorId) {
    this.mLocatorId = mLocatorId;
    return this;
  }

  /**
   * Ubicación de Almacén
   * @return mLocatorId
   **/
  @Schema(required = true, description = "Ubicación de Almacén")
      @NotNull

    public Integer getMLocatorId() {
    return mLocatorId;
  }

  public void setMLocatorId(Integer mLocatorId) {
    this.mLocatorId = mLocatorId;
  }

  public InventoryLine mProductId(Integer mProductId) {
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

  public InventoryLine processed(Boolean processed) {
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

  public InventoryLine qtybook(BigDecimal qtybook) {
    this.qtybook = qtybook;
    return this;
  }

  /**
   * Cantidad en Libros
   * @return qtybook
   **/
  @Schema(required = true, description = "Cantidad en Libros")
      @NotNull

    @Valid
    public BigDecimal getQtybook() {
    return qtybook;
  }

  public void setQtybook(BigDecimal qtybook) {
    this.qtybook = qtybook;
  }

  public InventoryLine qtycount(BigDecimal qtycount) {
    this.qtycount = qtycount;
    return this;
  }

  /**
   * Cantidad Contada
   * @return qtycount
   **/
  @Schema(required = true, description = "Cantidad Contada")
      @NotNull

    @Valid
    public BigDecimal getQtycount() {
    return qtycount;
  }

  public void setQtycount(BigDecimal qtycount) {
    this.qtycount = qtycount;
  }

  public InventoryLine qtycountwithoutchargesign(BigDecimal qtycountwithoutchargesign) {
    this.qtycountwithoutchargesign = qtycountwithoutchargesign;
    return this;
  }

  /**
   * Cantidad sin el signo del cargo
   * @return qtycountwithoutchargesign
   **/
  @Schema(required = true, description = "Cantidad sin el signo del cargo")
      @NotNull

    @Valid
    public BigDecimal getQtycountwithoutchargesign() {
    return qtycountwithoutchargesign;
  }

  public void setQtycountwithoutchargesign(BigDecimal qtycountwithoutchargesign) {
    this.qtycountwithoutchargesign = qtycountwithoutchargesign;
  }

  public InventoryLine qtyinternaluse(BigDecimal qtyinternaluse) {
    this.qtyinternaluse = qtyinternaluse;
    return this;
  }

  /**
   * Cantidad de Uso Interno
   * @return qtyinternaluse
   **/
  @Schema(description = "Cantidad de Uso Interno")
  
    @Valid
    public BigDecimal getQtyinternaluse() {
    return qtyinternaluse;
  }

  public void setQtyinternaluse(BigDecimal qtyinternaluse) {
    this.qtyinternaluse = qtyinternaluse;
  }

  public InventoryLine updated(String updated) {
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

  public InventoryLine updatedby(Integer updatedby) {
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

  public InventoryLine additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public InventoryLine addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public InventoryLine referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public InventoryLine addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    InventoryLine inventoryLine = (InventoryLine) o;
    return Objects.equals(this.adClientId, inventoryLine.adClientId) &&
        Objects.equals(this.adOrgId, inventoryLine.adOrgId) &&
        Objects.equals(this.cChargeId, inventoryLine.cChargeId) &&
        Objects.equals(this.cost, inventoryLine.cost) &&
        Objects.equals(this.created, inventoryLine.created) &&
        Objects.equals(this.createdby, inventoryLine.createdby) &&
        Objects.equals(this.description, inventoryLine.description) &&
        Objects.equals(this.inventorytype, inventoryLine.inventorytype) &&
        Objects.equals(this.isactive, inventoryLine.isactive) &&
        Objects.equals(this.line, inventoryLine.line) &&
        Objects.equals(this.mAttributesetinstanceId, inventoryLine.mAttributesetinstanceId) &&
        Objects.equals(this.mInventoryId, inventoryLine.mInventoryId) &&
        Objects.equals(this.mInventorylineId, inventoryLine.mInventorylineId) &&
        Objects.equals(this.mLocatorId, inventoryLine.mLocatorId) &&
        Objects.equals(this.mProductId, inventoryLine.mProductId) &&
        Objects.equals(this.processed, inventoryLine.processed) &&
        Objects.equals(this.qtybook, inventoryLine.qtybook) &&
        Objects.equals(this.qtycount, inventoryLine.qtycount) &&
        Objects.equals(this.qtycountwithoutchargesign, inventoryLine.qtycountwithoutchargesign) &&
        Objects.equals(this.qtyinternaluse, inventoryLine.qtyinternaluse) &&
        Objects.equals(this.updated, inventoryLine.updated) &&
        Objects.equals(this.updatedby, inventoryLine.updatedby) &&
        Objects.equals(this.additionalvalues, inventoryLine.additionalvalues) &&
        Objects.equals(this.referencedvalues, inventoryLine.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cChargeId, cost, created, createdby, description, inventorytype, isactive, line, mAttributesetinstanceId, mInventoryId, mInventorylineId, mLocatorId, mProductId, processed, qtybook, qtycount, qtycountwithoutchargesign, qtyinternaluse, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InventoryLine {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    inventorytype: ").append(toIndentedString(inventorytype)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    mAttributesetinstanceId: ").append(toIndentedString(mAttributesetinstanceId)).append("\n");
    sb.append("    mInventoryId: ").append(toIndentedString(mInventoryId)).append("\n");
    sb.append("    mInventorylineId: ").append(toIndentedString(mInventorylineId)).append("\n");
    sb.append("    mLocatorId: ").append(toIndentedString(mLocatorId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    qtybook: ").append(toIndentedString(qtybook)).append("\n");
    sb.append("    qtycount: ").append(toIndentedString(qtycount)).append("\n");
    sb.append("    qtycountwithoutchargesign: ").append(toIndentedString(qtycountwithoutchargesign)).append("\n");
    sb.append("    qtyinternaluse: ").append(toIndentedString(qtyinternaluse)).append("\n");
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
