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
 * RefTable
 */
@Validated



public class RefTable   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_display")
  private Integer adDisplay = null;

  @JsonProperty("ad_key")
  private Integer adKey = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_reference_id")
  private Integer adReferenceId = null;

  @JsonProperty("ad_table_id")
  private Integer adTableId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("entitytype")
  private String entitytype = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdisplayidentifiers")
  private Boolean isdisplayidentifiers = null;

  @JsonProperty("isvaluedisplayed")
  private Boolean isvaluedisplayed = null;

  @JsonProperty("orderbyclause")
  private String orderbyclause = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("whereclause")
  private String whereclause = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public RefTable adClientId(Integer adClientId) {
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

  public RefTable adComponentobjectuid(String adComponentobjectuid) {
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

  public RefTable adComponentversionId(Integer adComponentversionId) {
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

  public RefTable adDisplay(Integer adDisplay) {
    this.adDisplay = adDisplay;
    return this;
  }

  /**
   * Columna que desplegará
   * @return adDisplay
   **/
  @Schema(required = true, description = "Columna que desplegará")
      @NotNull

    public Integer getAdDisplay() {
    return adDisplay;
  }

  public void setAdDisplay(Integer adDisplay) {
    this.adDisplay = adDisplay;
  }

  public RefTable adKey(Integer adKey) {
    this.adKey = adKey;
    return this;
  }

  /**
   * Identificador único de un registro
   * @return adKey
   **/
  @Schema(required = true, description = "Identificador único de un registro")
      @NotNull

    public Integer getAdKey() {
    return adKey;
  }

  public void setAdKey(Integer adKey) {
    this.adKey = adKey;
  }

  public RefTable adOrgId(Integer adOrgId) {
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

  public RefTable adReferenceId(Integer adReferenceId) {
    this.adReferenceId = adReferenceId;
    return this;
  }

  /**
   * Referencia del Sistema (Lista de Selección)
   * @return adReferenceId
   **/
  @Schema(required = true, description = "Referencia del Sistema (Lista de Selección)")
      @NotNull

    public Integer getAdReferenceId() {
    return adReferenceId;
  }

  public void setAdReferenceId(Integer adReferenceId) {
    this.adReferenceId = adReferenceId;
  }

  public RefTable adTableId(Integer adTableId) {
    this.adTableId = adTableId;
    return this;
  }

  /**
   * Tabla para los campos
   * @return adTableId
   **/
  @Schema(required = true, description = "Tabla para los campos")
      @NotNull

    public Integer getAdTableId() {
    return adTableId;
  }

  public void setAdTableId(Integer adTableId) {
    this.adTableId = adTableId;
  }

  public RefTable created(String created) {
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

  public RefTable createdby(Integer createdby) {
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

  public RefTable entitytype(String entitytype) {
    this.entitytype = entitytype;
    return this;
  }

  /**
   * Tipo de Entidad Diccionario; determina propiedad y sincronización
   * @return entitytype
   **/
  @Schema(required = true, description = "Tipo de Entidad Diccionario; determina propiedad y sincronización")
      @NotNull

    public String getEntitytype() {
    return entitytype;
  }

  public void setEntitytype(String entitytype) {
    this.entitytype = entitytype;
  }

  public RefTable isactive(Boolean isactive) {
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

  public RefTable isdisplayidentifiers(Boolean isdisplayidentifiers) {
    this.isdisplayidentifiers = isdisplayidentifiers;
    return this;
  }

  /**
   * El valor mostrado corresponde a la concatenación de las columnas marcadas como identificadores
   * @return isdisplayidentifiers
   **/
  @Schema(required = true, description = "El valor mostrado corresponde a la concatenación de las columnas marcadas como identificadores")
      @NotNull

    public Boolean isIsdisplayidentifiers() {
    return isdisplayidentifiers;
  }

  public void setIsdisplayidentifiers(Boolean isdisplayidentifiers) {
    this.isdisplayidentifiers = isdisplayidentifiers;
  }

  public RefTable isvaluedisplayed(Boolean isvaluedisplayed) {
    this.isvaluedisplayed = isvaluedisplayed;
    return this;
  }

  /**
   * Despliega la columna valor con la columna despliegue
   * @return isvaluedisplayed
   **/
  @Schema(required = true, description = "Despliega la columna valor con la columna despliegue")
      @NotNull

    public Boolean isIsvaluedisplayed() {
    return isvaluedisplayed;
  }

  public void setIsvaluedisplayed(Boolean isvaluedisplayed) {
    this.isvaluedisplayed = isvaluedisplayed;
  }

  public RefTable orderbyclause(String orderbyclause) {
    this.orderbyclause = orderbyclause;
    return this;
  }

  /**
   * Cláusula completamente calificada ORDER BY
   * @return orderbyclause
   **/
  @Schema(description = "Cláusula completamente calificada ORDER BY")
  
    public String getOrderbyclause() {
    return orderbyclause;
  }

  public void setOrderbyclause(String orderbyclause) {
    this.orderbyclause = orderbyclause;
  }

  public RefTable updated(String updated) {
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

  public RefTable updatedby(Integer updatedby) {
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

  public RefTable whereclause(String whereclause) {
    this.whereclause = whereclause;
    return this;
  }

  /**
   * Cláusula WHERE completamente calificada
   * @return whereclause
   **/
  @Schema(description = "Cláusula WHERE completamente calificada")
  
    public String getWhereclause() {
    return whereclause;
  }

  public void setWhereclause(String whereclause) {
    this.whereclause = whereclause;
  }

  public RefTable additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public RefTable addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public RefTable referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public RefTable addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    RefTable refTable = (RefTable) o;
    return Objects.equals(this.adClientId, refTable.adClientId) &&
        Objects.equals(this.adComponentobjectuid, refTable.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, refTable.adComponentversionId) &&
        Objects.equals(this.adDisplay, refTable.adDisplay) &&
        Objects.equals(this.adKey, refTable.adKey) &&
        Objects.equals(this.adOrgId, refTable.adOrgId) &&
        Objects.equals(this.adReferenceId, refTable.adReferenceId) &&
        Objects.equals(this.adTableId, refTable.adTableId) &&
        Objects.equals(this.created, refTable.created) &&
        Objects.equals(this.createdby, refTable.createdby) &&
        Objects.equals(this.entitytype, refTable.entitytype) &&
        Objects.equals(this.isactive, refTable.isactive) &&
        Objects.equals(this.isdisplayidentifiers, refTable.isdisplayidentifiers) &&
        Objects.equals(this.isvaluedisplayed, refTable.isvaluedisplayed) &&
        Objects.equals(this.orderbyclause, refTable.orderbyclause) &&
        Objects.equals(this.updated, refTable.updated) &&
        Objects.equals(this.updatedby, refTable.updatedby) &&
        Objects.equals(this.whereclause, refTable.whereclause) &&
        Objects.equals(this.additionalvalues, refTable.additionalvalues) &&
        Objects.equals(this.referencedvalues, refTable.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adDisplay, adKey, adOrgId, adReferenceId, adTableId, created, createdby, entitytype, isactive, isdisplayidentifiers, isvaluedisplayed, orderbyclause, updated, updatedby, whereclause, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefTable {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adDisplay: ").append(toIndentedString(adDisplay)).append("\n");
    sb.append("    adKey: ").append(toIndentedString(adKey)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adReferenceId: ").append(toIndentedString(adReferenceId)).append("\n");
    sb.append("    adTableId: ").append(toIndentedString(adTableId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdisplayidentifiers: ").append(toIndentedString(isdisplayidentifiers)).append("\n");
    sb.append("    isvaluedisplayed: ").append(toIndentedString(isvaluedisplayed)).append("\n");
    sb.append("    orderbyclause: ").append(toIndentedString(orderbyclause)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    whereclause: ").append(toIndentedString(whereclause)).append("\n");
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
