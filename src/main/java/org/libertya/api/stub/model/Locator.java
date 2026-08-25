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
 * Locator
 */
@Validated



public class Locator   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("depth")
  private BigDecimal depth = null;

  @JsonProperty("height")
  private BigDecimal height = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("m_locator_id")
  private Integer mLocatorId = null;

  @JsonProperty("m_warehouse_id")
  private Integer mWarehouseId = null;

  @JsonProperty("priorityno")
  private Integer priorityno = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("width")
  private BigDecimal width = null;

  @JsonProperty("x")
  private String x = null;

  @JsonProperty("y")
  private String y = null;

  @JsonProperty("z")
  private String z = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Locator adClientId(Integer adClientId) {
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

  public Locator adComponentobjectuid(String adComponentobjectuid) {
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

  public Locator adOrgId(Integer adOrgId) {
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

  public Locator created(String created) {
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

  public Locator createdby(Integer createdby) {
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

  public Locator depth(BigDecimal depth) {
    this.depth = depth;
    return this;
  }

  /**
   *  
   * @return depth
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getDepth() {
    return depth;
  }

  public void setDepth(BigDecimal depth) {
    this.depth = depth;
  }

  public Locator height(BigDecimal height) {
    this.height = height;
    return this;
  }

  /**
   *  
   * @return height
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  public Locator isactive(Boolean isactive) {
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

  public Locator isdefault(Boolean isdefault) {
    this.isdefault = isdefault;
    return this;
  }

  /**
   * Valor Predeterminado
   * @return isdefault
   **/
  @Schema(required = true, description = "Valor Predeterminado")
      @NotNull

    public Boolean isIsdefault() {
    return isdefault;
  }

  public void setIsdefault(Boolean isdefault) {
    this.isdefault = isdefault;
  }

  public Locator mLocatorId(Integer mLocatorId) {
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

  public Locator mWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
    return this;
  }

  /**
   * Almacén
   * @return mWarehouseId
   **/
  @Schema(required = true, description = "Almacén")
      @NotNull

    public Integer getMWarehouseId() {
    return mWarehouseId;
  }

  public void setMWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
  }

  public Locator priorityno(Integer priorityno) {
    this.priorityno = priorityno;
    return this;
  }

  /**
   * De donde se seleccionará primero el inventario
   * @return priorityno
   **/
  @Schema(required = true, description = "De donde se seleccionará primero el inventario")
      @NotNull

    public Integer getPriorityno() {
    return priorityno;
  }

  public void setPriorityno(Integer priorityno) {
    this.priorityno = priorityno;
  }

  public Locator updated(String updated) {
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

  public Locator updatedby(Integer updatedby) {
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

  public Locator value(String value) {
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

  public Locator width(BigDecimal width) {
    this.width = width;
    return this;
  }

  /**
   *  
   * @return width
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getWidth() {
    return width;
  }

  public void setWidth(BigDecimal width) {
    this.width = width;
  }

  public Locator x(String x) {
    this.x = x;
    return this;
  }

  /**
   * Dimensión X; Ej. Pasillo
   * @return x
   **/
  @Schema(required = true, description = "Dimensión X; Ej. Pasillo")
      @NotNull

    public String getX() {
    return x;
  }

  public void setX(String x) {
    this.x = x;
  }

  public Locator y(String y) {
    this.y = y;
    return this;
  }

  /**
   * Dimensión Y
   * @return y
   **/
  @Schema(required = true, description = "Dimensión Y")
      @NotNull

    public String getY() {
    return y;
  }

  public void setY(String y) {
    this.y = y;
  }

  public Locator z(String z) {
    this.z = z;
    return this;
  }

  /**
   * Dimensión Z; Ej. Nivel
   * @return z
   **/
  @Schema(required = true, description = "Dimensión Z; Ej. Nivel")
      @NotNull

    public String getZ() {
    return z;
  }

  public void setZ(String z) {
    this.z = z;
  }

  public Locator additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Locator addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Locator referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Locator addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Locator locator = (Locator) o;
    return Objects.equals(this.adClientId, locator.adClientId) &&
        Objects.equals(this.adComponentobjectuid, locator.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, locator.adOrgId) &&
        Objects.equals(this.created, locator.created) &&
        Objects.equals(this.createdby, locator.createdby) &&
        Objects.equals(this.depth, locator.depth) &&
        Objects.equals(this.height, locator.height) &&
        Objects.equals(this.isactive, locator.isactive) &&
        Objects.equals(this.isdefault, locator.isdefault) &&
        Objects.equals(this.mLocatorId, locator.mLocatorId) &&
        Objects.equals(this.mWarehouseId, locator.mWarehouseId) &&
        Objects.equals(this.priorityno, locator.priorityno) &&
        Objects.equals(this.updated, locator.updated) &&
        Objects.equals(this.updatedby, locator.updatedby) &&
        Objects.equals(this.value, locator.value) &&
        Objects.equals(this.width, locator.width) &&
        Objects.equals(this.x, locator.x) &&
        Objects.equals(this.y, locator.y) &&
        Objects.equals(this.z, locator.z) &&
        Objects.equals(this.additionalvalues, locator.additionalvalues) &&
        Objects.equals(this.referencedvalues, locator.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, created, createdby, depth, height, isactive, isdefault, mLocatorId, mWarehouseId, priorityno, updated, updatedby, value, width, x, y, z, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Locator {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    depth: ").append(toIndentedString(depth)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    mLocatorId: ").append(toIndentedString(mLocatorId)).append("\n");
    sb.append("    mWarehouseId: ").append(toIndentedString(mWarehouseId)).append("\n");
    sb.append("    priorityno: ").append(toIndentedString(priorityno)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    z: ").append(toIndentedString(z)).append("\n");
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
