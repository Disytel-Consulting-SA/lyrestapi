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
 * Storage
 */
@Validated



public class Storage   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("datelastinventory")
  private String datelastinventory = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("m_attributesetinstance_id")
  private Integer mAttributesetinstanceId = null;

  @JsonProperty("m_locator_id")
  private Integer mLocatorId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("qtyonhand")
  private BigDecimal qtyonhand = null;

  @JsonProperty("qtyordered")
  private BigDecimal qtyordered = null;

  @JsonProperty("qtyreserved")
  private BigDecimal qtyreserved = null;

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

  public Storage adClientId(Integer adClientId) {
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

  public Storage adOrgId(Integer adOrgId) {
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

  public Storage created(String created) {
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

  public Storage createdby(Integer createdby) {
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

  public Storage datelastinventory(String datelastinventory) {
    this.datelastinventory = datelastinventory;
    return this;
  }

  /**
   * Ultima Fecha de Recuento de Inventarios
   * @return datelastinventory
   **/
  @Schema(description = "Ultima Fecha de Recuento de Inventarios")
  
    public String getDatelastinventory() {
    return datelastinventory;
  }

  public void setDatelastinventory(String datelastinventory) {
    this.datelastinventory = datelastinventory;
  }

  public Storage isactive(Boolean isactive) {
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

  public Storage mAttributesetinstanceId(Integer mAttributesetinstanceId) {
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

  public Storage mLocatorId(Integer mLocatorId) {
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

  public Storage mProductId(Integer mProductId) {
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

  public Storage qtyonhand(BigDecimal qtyonhand) {
    this.qtyonhand = qtyonhand;
    return this;
  }

  /**
   * Cantidad en existencia
   * @return qtyonhand
   **/
  @Schema(required = true, description = "Cantidad en existencia")
      @NotNull

    @Valid
    public BigDecimal getQtyonhand() {
    return qtyonhand;
  }

  public void setQtyonhand(BigDecimal qtyonhand) {
    this.qtyonhand = qtyonhand;
  }

  public Storage qtyordered(BigDecimal qtyordered) {
    this.qtyordered = qtyordered;
    return this;
  }

  /**
   * Cantidad ordenada
   * @return qtyordered
   **/
  @Schema(required = true, description = "Cantidad ordenada")
      @NotNull

    @Valid
    public BigDecimal getQtyordered() {
    return qtyordered;
  }

  public void setQtyordered(BigDecimal qtyordered) {
    this.qtyordered = qtyordered;
  }

  public Storage qtyreserved(BigDecimal qtyreserved) {
    this.qtyreserved = qtyreserved;
    return this;
  }

  /**
   * Cantidad reservada
   * @return qtyreserved
   **/
  @Schema(required = true, description = "Cantidad reservada")
      @NotNull

    @Valid
    public BigDecimal getQtyreserved() {
    return qtyreserved;
  }

  public void setQtyreserved(BigDecimal qtyreserved) {
    this.qtyreserved = qtyreserved;
  }

  public Storage updated(String updated) {
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

  public Storage updatedby(Integer updatedby) {
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

  public Storage additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Storage addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Storage referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Storage addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Storage storage = (Storage) o;
    return Objects.equals(this.adClientId, storage.adClientId) &&
        Objects.equals(this.adOrgId, storage.adOrgId) &&
        Objects.equals(this.created, storage.created) &&
        Objects.equals(this.createdby, storage.createdby) &&
        Objects.equals(this.datelastinventory, storage.datelastinventory) &&
        Objects.equals(this.isactive, storage.isactive) &&
        Objects.equals(this.mAttributesetinstanceId, storage.mAttributesetinstanceId) &&
        Objects.equals(this.mLocatorId, storage.mLocatorId) &&
        Objects.equals(this.mProductId, storage.mProductId) &&
        Objects.equals(this.qtyonhand, storage.qtyonhand) &&
        Objects.equals(this.qtyordered, storage.qtyordered) &&
        Objects.equals(this.qtyreserved, storage.qtyreserved) &&
        Objects.equals(this.updated, storage.updated) &&
        Objects.equals(this.updatedby, storage.updatedby) &&
        Objects.equals(this.additionalvalues, storage.additionalvalues) &&
        Objects.equals(this.referencedvalues, storage.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, created, createdby, datelastinventory, isactive, mAttributesetinstanceId, mLocatorId, mProductId, qtyonhand, qtyordered, qtyreserved, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Storage {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    datelastinventory: ").append(toIndentedString(datelastinventory)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    mAttributesetinstanceId: ").append(toIndentedString(mAttributesetinstanceId)).append("\n");
    sb.append("    mLocatorId: ").append(toIndentedString(mLocatorId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    qtyonhand: ").append(toIndentedString(qtyonhand)).append("\n");
    sb.append("    qtyordered: ").append(toIndentedString(qtyordered)).append("\n");
    sb.append("    qtyreserved: ").append(toIndentedString(qtyreserved)).append("\n");
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
