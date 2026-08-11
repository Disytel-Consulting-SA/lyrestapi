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
 * Window
 */
@Validated



public class Window   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_color_id")
  private Integer adColorId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_image_id")
  private Integer adImageId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_window_id")
  private Integer adWindowId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("entitytype")
  private String entitytype = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isbetafunctionality")
  private Boolean isbetafunctionality = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("issotrx")
  private Boolean issotrx = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("processing")
  private String processing = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("windowtype")
  private String windowtype = null;

  @JsonProperty("winheight")
  private Integer winheight = null;

  @JsonProperty("winwidth")
  private Integer winwidth = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Window adClientId(Integer adClientId) {
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

  public Window adColorId(Integer adColorId) {
    this.adColorId = adColorId;
    return this;
  }

  /**
   * Color para el fondo o indicadores
   * @return adColorId
   **/
  @Schema(description = "Color para el fondo o indicadores")
  
    public Integer getAdColorId() {
    return adColorId;
  }

  public void setAdColorId(Integer adColorId) {
    this.adColorId = adColorId;
  }

  public Window adComponentobjectuid(String adComponentobjectuid) {
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

  public Window adComponentversionId(Integer adComponentversionId) {
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

  public Window adImageId(Integer adImageId) {
    this.adImageId = adImageId;
    return this;
  }

  /**
   * Imagen del sistema
   * @return adImageId
   **/
  @Schema(description = "Imagen del sistema")
  
    public Integer getAdImageId() {
    return adImageId;
  }

  public void setAdImageId(Integer adImageId) {
    this.adImageId = adImageId;
  }

  public Window adOrgId(Integer adOrgId) {
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

  public Window adWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
    return this;
  }

  /**
   * Ventana de Entrada de datos o despliegue
   * @return adWindowId
   **/
  @Schema(required = true, description = "Ventana de Entrada de datos o despliegue")
      @NotNull

    public Integer getAdWindowId() {
    return adWindowId;
  }

  public void setAdWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
  }

  public Window created(String created) {
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

  public Window createdby(Integer createdby) {
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

  public Window description(String description) {
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

  public Window entitytype(String entitytype) {
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

  public Window help(String help) {
    this.help = help;
    return this;
  }

  /**
   * Ayuda; Comentario o Sugerencia
   * @return help
   **/
  @Schema(description = "Ayuda; Comentario o Sugerencia")
  
    public String getHelp() {
    return help;
  }

  public void setHelp(String help) {
    this.help = help;
  }

  public Window isactive(Boolean isactive) {
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

  public Window isbetafunctionality(Boolean isbetafunctionality) {
    this.isbetafunctionality = isbetafunctionality;
    return this;
  }

  /**
   * Esta función esta en Version Beta
   * @return isbetafunctionality
   **/
  @Schema(required = true, description = "Esta función esta en Version Beta")
      @NotNull

    public Boolean isIsbetafunctionality() {
    return isbetafunctionality;
  }

  public void setIsbetafunctionality(Boolean isbetafunctionality) {
    this.isbetafunctionality = isbetafunctionality;
  }

  public Window isdefault(Boolean isdefault) {
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

  public Window issotrx(Boolean issotrx) {
    this.issotrx = issotrx;
    return this;
  }

  /**
   * Esta es una transacción de ventas
   * @return issotrx
   **/
  @Schema(required = true, description = "Esta es una transacción de ventas")
      @NotNull

    public Boolean isIssotrx() {
    return issotrx;
  }

  public void setIssotrx(Boolean issotrx) {
    this.issotrx = issotrx;
  }

  public Window name(String name) {
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

  public Window processing(String processing) {
    this.processing = processing;
    return this;
  }

  /**
   *  
   * @return processing
   **/
  @Schema(description = " ")
  
    public String getProcessing() {
    return processing;
  }

  public void setProcessing(String processing) {
    this.processing = processing;
  }

  public Window updated(String updated) {
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

  public Window updatedby(Integer updatedby) {
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

  public Window windowtype(String windowtype) {
    this.windowtype = windowtype;
    return this;
  }

  /**
   * Tipo de clasificación de una ventana
   * @return windowtype
   **/
  @Schema(required = true, description = "Tipo de clasificación de una ventana")
      @NotNull

    public String getWindowtype() {
    return windowtype;
  }

  public void setWindowtype(String windowtype) {
    this.windowtype = windowtype;
  }

  public Window winheight(Integer winheight) {
    this.winheight = winheight;
    return this;
  }

  /**
   * Altura de la ventana
   * @return winheight
   **/
  @Schema(description = "Altura de la ventana")
  
    public Integer getWinheight() {
    return winheight;
  }

  public void setWinheight(Integer winheight) {
    this.winheight = winheight;
  }

  public Window winwidth(Integer winwidth) {
    this.winwidth = winwidth;
    return this;
  }

  /**
   * Ancho de la ventana
   * @return winwidth
   **/
  @Schema(description = "Ancho de la ventana")
  
    public Integer getWinwidth() {
    return winwidth;
  }

  public void setWinwidth(Integer winwidth) {
    this.winwidth = winwidth;
  }

  public Window additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Window addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Window referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Window addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Window window = (Window) o;
    return Objects.equals(this.adClientId, window.adClientId) &&
        Objects.equals(this.adColorId, window.adColorId) &&
        Objects.equals(this.adComponentobjectuid, window.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, window.adComponentversionId) &&
        Objects.equals(this.adImageId, window.adImageId) &&
        Objects.equals(this.adOrgId, window.adOrgId) &&
        Objects.equals(this.adWindowId, window.adWindowId) &&
        Objects.equals(this.created, window.created) &&
        Objects.equals(this.createdby, window.createdby) &&
        Objects.equals(this.description, window.description) &&
        Objects.equals(this.entitytype, window.entitytype) &&
        Objects.equals(this.help, window.help) &&
        Objects.equals(this.isactive, window.isactive) &&
        Objects.equals(this.isbetafunctionality, window.isbetafunctionality) &&
        Objects.equals(this.isdefault, window.isdefault) &&
        Objects.equals(this.issotrx, window.issotrx) &&
        Objects.equals(this.name, window.name) &&
        Objects.equals(this.processing, window.processing) &&
        Objects.equals(this.updated, window.updated) &&
        Objects.equals(this.updatedby, window.updatedby) &&
        Objects.equals(this.windowtype, window.windowtype) &&
        Objects.equals(this.winheight, window.winheight) &&
        Objects.equals(this.winwidth, window.winwidth) &&
        Objects.equals(this.additionalvalues, window.additionalvalues) &&
        Objects.equals(this.referencedvalues, window.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adColorId, adComponentobjectuid, adComponentversionId, adImageId, adOrgId, adWindowId, created, createdby, description, entitytype, help, isactive, isbetafunctionality, isdefault, issotrx, name, processing, updated, updatedby, windowtype, winheight, winwidth, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Window {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adColorId: ").append(toIndentedString(adColorId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adImageId: ").append(toIndentedString(adImageId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adWindowId: ").append(toIndentedString(adWindowId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isbetafunctionality: ").append(toIndentedString(isbetafunctionality)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    issotrx: ").append(toIndentedString(issotrx)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    windowtype: ").append(toIndentedString(windowtype)).append("\n");
    sb.append("    winheight: ").append(toIndentedString(winheight)).append("\n");
    sb.append("    winwidth: ").append(toIndentedString(winwidth)).append("\n");
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
