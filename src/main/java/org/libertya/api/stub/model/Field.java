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
 * Field
 */
@Validated



public class Field   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_column_id")
  private Integer adColumnId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_fieldgroup_id")
  private Integer adFieldgroupId = null;

  @JsonProperty("ad_field_id")
  private Integer adFieldId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_tab_id")
  private Integer adTabId = null;

  @JsonProperty("ad_val_rule_id")
  private Integer adValRuleId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("defaultvalue")
  private String defaultvalue = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("displaylength")
  private Integer displaylength = null;

  @JsonProperty("displaylogic")
  private String displaylogic = null;

  @JsonProperty("entitytype")
  private String entitytype = null;

  @JsonProperty("exportrealvalue")
  private Boolean exportrealvalue = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("iscentrallymaintained")
  private Boolean iscentrallymaintained = null;

  @JsonProperty("isdisplayed")
  private Boolean isdisplayed = null;

  @JsonProperty("isdisplayedingrid")
  private Boolean isdisplayedingrid = null;

  @JsonProperty("isencrypted")
  private Boolean isencrypted = null;

  @JsonProperty("isfieldonly")
  private Boolean isfieldonly = null;

  @JsonProperty("isheading")
  private Boolean isheading = null;

  @JsonProperty("isreadonly")
  private Boolean isreadonly = null;

  @JsonProperty("issameline")
  private Boolean issameline = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("obscuretype")
  private String obscuretype = null;

  @JsonProperty("seqno")
  private Integer seqno = null;

  @JsonProperty("sortno")
  private BigDecimal sortno = null;

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

  public Field adClientId(Integer adClientId) {
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

  public Field adColumnId(Integer adColumnId) {
    this.adColumnId = adColumnId;
    return this;
  }

  /**
   * Columna en la tabla
   * @return adColumnId
   **/
  @Schema(required = true, description = "Columna en la tabla")
      @NotNull

    public Integer getAdColumnId() {
    return adColumnId;
  }

  public void setAdColumnId(Integer adColumnId) {
    this.adColumnId = adColumnId;
  }

  public Field adComponentobjectuid(String adComponentobjectuid) {
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

  public Field adComponentversionId(Integer adComponentversionId) {
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

  public Field adFieldgroupId(Integer adFieldgroupId) {
    this.adFieldgroupId = adFieldgroupId;
    return this;
  }

  /**
   * Agrupación Lógica del campo
   * @return adFieldgroupId
   **/
  @Schema(description = "Agrupación Lógica del campo")
  
    public Integer getAdFieldgroupId() {
    return adFieldgroupId;
  }

  public void setAdFieldgroupId(Integer adFieldgroupId) {
    this.adFieldgroupId = adFieldgroupId;
  }

  public Field adFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
    return this;
  }

  /**
   * Campo en una base de datos
   * @return adFieldId
   **/
  @Schema(required = true, description = "Campo en una base de datos")
      @NotNull

    public Integer getAdFieldId() {
    return adFieldId;
  }

  public void setAdFieldId(Integer adFieldId) {
    this.adFieldId = adFieldId;
  }

  public Field adOrgId(Integer adOrgId) {
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

  public Field adTabId(Integer adTabId) {
    this.adTabId = adTabId;
    return this;
  }

  /**
   * Pestaña dentro de una Ventana
   * @return adTabId
   **/
  @Schema(required = true, description = "Pestaña dentro de una Ventana")
      @NotNull

    public Integer getAdTabId() {
    return adTabId;
  }

  public void setAdTabId(Integer adTabId) {
    this.adTabId = adTabId;
  }

  public Field adValRuleId(Integer adValRuleId) {
    this.adValRuleId = adValRuleId;
    return this;
  }

  /**
   * Regla de validación
   * @return adValRuleId
   **/
  @Schema(description = "Regla de validación")
  
    public Integer getAdValRuleId() {
    return adValRuleId;
  }

  public void setAdValRuleId(Integer adValRuleId) {
    this.adValRuleId = adValRuleId;
  }

  public Field created(String created) {
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

  public Field createdby(Integer createdby) {
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

  public Field defaultvalue(String defaultvalue) {
    this.defaultvalue = defaultvalue;
    return this;
  }

  /**
   * Jerarquía de valores predeterminados; separados por ;
   * @return defaultvalue
   **/
  @Schema(description = "Jerarquía de valores predeterminados; separados por ;")
  
    public String getDefaultvalue() {
    return defaultvalue;
  }

  public void setDefaultvalue(String defaultvalue) {
    this.defaultvalue = defaultvalue;
  }

  public Field description(String description) {
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

  public Field displaylength(Integer displaylength) {
    this.displaylength = displaylength;
    return this;
  }

  /**
   * Longitud del despliegue en caracteres
   * @return displaylength
   **/
  @Schema(description = "Longitud del despliegue en caracteres")
  
    public Integer getDisplaylength() {
    return displaylength;
  }

  public void setDisplaylength(Integer displaylength) {
    this.displaylength = displaylength;
  }

  public Field displaylogic(String displaylogic) {
    this.displaylogic = displaylogic;
    return this;
  }

  /**
   * Si el campo es desplegado; el resultado determina si el campo es efectivamente desplegado
   * @return displaylogic
   **/
  @Schema(description = "Si el campo es desplegado; el resultado determina si el campo es efectivamente desplegado")
  
    public String getDisplaylogic() {
    return displaylogic;
  }

  public void setDisplaylogic(String displaylogic) {
    this.displaylogic = displaylogic;
  }

  public Field entitytype(String entitytype) {
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

  public Field exportrealvalue(Boolean exportrealvalue) {
    this.exportrealvalue = exportrealvalue;
    return this;
  }

  /**
   * Al exportar el valor del campo a un archivo, se exporta el valor real del campo
   * @return exportrealvalue
   **/
  @Schema(required = true, description = "Al exportar el valor del campo a un archivo, se exporta el valor real del campo")
      @NotNull

    public Boolean isExportrealvalue() {
    return exportrealvalue;
  }

  public void setExportrealvalue(Boolean exportrealvalue) {
    this.exportrealvalue = exportrealvalue;
  }

  public Field help(String help) {
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

  public Field isactive(Boolean isactive) {
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

  public Field iscentrallymaintained(Boolean iscentrallymaintained) {
    this.iscentrallymaintained = iscentrallymaintained;
    return this;
  }

  /**
   * Información mantenida en la tabla Elementos del Sistema
   * @return iscentrallymaintained
   **/
  @Schema(required = true, description = "Información mantenida en la tabla Elementos del Sistema")
      @NotNull

    public Boolean isIscentrallymaintained() {
    return iscentrallymaintained;
  }

  public void setIscentrallymaintained(Boolean iscentrallymaintained) {
    this.iscentrallymaintained = iscentrallymaintained;
  }

  public Field isdisplayed(Boolean isdisplayed) {
    this.isdisplayed = isdisplayed;
    return this;
  }

  /**
   * Determina; si este campo es desplegado
   * @return isdisplayed
   **/
  @Schema(required = true, description = "Determina; si este campo es desplegado")
      @NotNull

    public Boolean isIsdisplayed() {
    return isdisplayed;
  }

  public void setIsdisplayed(Boolean isdisplayed) {
    this.isdisplayed = isdisplayed;
  }

  public Field isdisplayedingrid(Boolean isdisplayedingrid) {
    this.isdisplayedingrid = isdisplayedingrid;
    return this;
  }

  /**
   *  
   * @return isdisplayedingrid
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsdisplayedingrid() {
    return isdisplayedingrid;
  }

  public void setIsdisplayedingrid(Boolean isdisplayedingrid) {
    this.isdisplayedingrid = isdisplayedingrid;
  }

  public Field isencrypted(Boolean isencrypted) {
    this.isencrypted = isencrypted;
    return this;
  }

  /**
   * Despliegue encriptado
   * @return isencrypted
   **/
  @Schema(required = true, description = "Despliegue encriptado")
      @NotNull

    public Boolean isIsencrypted() {
    return isencrypted;
  }

  public void setIsencrypted(Boolean isencrypted) {
    this.isencrypted = isencrypted;
  }

  public Field isfieldonly(Boolean isfieldonly) {
    this.isfieldonly = isfieldonly;
    return this;
  }

  /**
   * La etiqueta no se muestra
   * @return isfieldonly
   **/
  @Schema(required = true, description = "La etiqueta no se muestra")
      @NotNull

    public Boolean isIsfieldonly() {
    return isfieldonly;
  }

  public void setIsfieldonly(Boolean isfieldonly) {
    this.isfieldonly = isfieldonly;
  }

  public Field isheading(Boolean isheading) {
    this.isheading = isheading;
    return this;
  }

  /**
   * Campo sin columna - Solamente la etiqueta se muestra
   * @return isheading
   **/
  @Schema(required = true, description = "Campo sin columna - Solamente la etiqueta se muestra")
      @NotNull

    public Boolean isIsheading() {
    return isheading;
  }

  public void setIsheading(Boolean isheading) {
    this.isheading = isheading;
  }

  public Field isreadonly(Boolean isreadonly) {
    this.isreadonly = isreadonly;
    return this;
  }

  /**
   * El campo es de sólo lectura
   * @return isreadonly
   **/
  @Schema(required = true, description = "El campo es de sólo lectura")
      @NotNull

    public Boolean isIsreadonly() {
    return isreadonly;
  }

  public void setIsreadonly(Boolean isreadonly) {
    this.isreadonly = isreadonly;
  }

  public Field issameline(Boolean issameline) {
    this.issameline = issameline;
    return this;
  }

  /**
   * Desplegado en la misma línea que el campo previo
   * @return issameline
   **/
  @Schema(required = true, description = "Desplegado en la misma línea que el campo previo")
      @NotNull

    public Boolean isIssameline() {
    return issameline;
  }

  public void setIssameline(Boolean issameline) {
    this.issameline = issameline;
  }

  public Field name(String name) {
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

  public Field obscuretype(String obscuretype) {
    this.obscuretype = obscuretype;
    return this;
  }

  /**
   * Restringir (limitar datos mostrados)
   * @return obscuretype
   **/
  @Schema(description = "Restringir (limitar datos mostrados)")
  
    public String getObscuretype() {
    return obscuretype;
  }

  public void setObscuretype(String obscuretype) {
    this.obscuretype = obscuretype;
  }

  public Field seqno(Integer seqno) {
    this.seqno = seqno;
    return this;
  }

  /**
   * Método de ordenar registros; el número más bajo viene primero
   * @return seqno
   **/
  @Schema(description = "Método de ordenar registros; el número más bajo viene primero")
  
    public Integer getSeqno() {
    return seqno;
  }

  public void setSeqno(Integer seqno) {
    this.seqno = seqno;
  }

  public Field sortno(BigDecimal sortno) {
    this.sortno = sortno;
    return this;
  }

  /**
   * Determina en que orden son desplegados los productos
   * @return sortno
   **/
  @Schema(description = "Determina en que orden son desplegados los productos")
  
    @Valid
    public BigDecimal getSortno() {
    return sortno;
  }

  public void setSortno(BigDecimal sortno) {
    this.sortno = sortno;
  }

  public Field updated(String updated) {
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

  public Field updatedby(Integer updatedby) {
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

  public Field additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Field addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Field referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Field addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Field field = (Field) o;
    return Objects.equals(this.adClientId, field.adClientId) &&
        Objects.equals(this.adColumnId, field.adColumnId) &&
        Objects.equals(this.adComponentobjectuid, field.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, field.adComponentversionId) &&
        Objects.equals(this.adFieldgroupId, field.adFieldgroupId) &&
        Objects.equals(this.adFieldId, field.adFieldId) &&
        Objects.equals(this.adOrgId, field.adOrgId) &&
        Objects.equals(this.adTabId, field.adTabId) &&
        Objects.equals(this.adValRuleId, field.adValRuleId) &&
        Objects.equals(this.created, field.created) &&
        Objects.equals(this.createdby, field.createdby) &&
        Objects.equals(this.defaultvalue, field.defaultvalue) &&
        Objects.equals(this.description, field.description) &&
        Objects.equals(this.displaylength, field.displaylength) &&
        Objects.equals(this.displaylogic, field.displaylogic) &&
        Objects.equals(this.entitytype, field.entitytype) &&
        Objects.equals(this.exportrealvalue, field.exportrealvalue) &&
        Objects.equals(this.help, field.help) &&
        Objects.equals(this.isactive, field.isactive) &&
        Objects.equals(this.iscentrallymaintained, field.iscentrallymaintained) &&
        Objects.equals(this.isdisplayed, field.isdisplayed) &&
        Objects.equals(this.isdisplayedingrid, field.isdisplayedingrid) &&
        Objects.equals(this.isencrypted, field.isencrypted) &&
        Objects.equals(this.isfieldonly, field.isfieldonly) &&
        Objects.equals(this.isheading, field.isheading) &&
        Objects.equals(this.isreadonly, field.isreadonly) &&
        Objects.equals(this.issameline, field.issameline) &&
        Objects.equals(this.name, field.name) &&
        Objects.equals(this.obscuretype, field.obscuretype) &&
        Objects.equals(this.seqno, field.seqno) &&
        Objects.equals(this.sortno, field.sortno) &&
        Objects.equals(this.updated, field.updated) &&
        Objects.equals(this.updatedby, field.updatedby) &&
        Objects.equals(this.additionalvalues, field.additionalvalues) &&
        Objects.equals(this.referencedvalues, field.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adColumnId, adComponentobjectuid, adComponentversionId, adFieldgroupId, adFieldId, adOrgId, adTabId, adValRuleId, created, createdby, defaultvalue, description, displaylength, displaylogic, entitytype, exportrealvalue, help, isactive, iscentrallymaintained, isdisplayed, isdisplayedingrid, isencrypted, isfieldonly, isheading, isreadonly, issameline, name, obscuretype, seqno, sortno, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Field {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adColumnId: ").append(toIndentedString(adColumnId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adFieldgroupId: ").append(toIndentedString(adFieldgroupId)).append("\n");
    sb.append("    adFieldId: ").append(toIndentedString(adFieldId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adTabId: ").append(toIndentedString(adTabId)).append("\n");
    sb.append("    adValRuleId: ").append(toIndentedString(adValRuleId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    defaultvalue: ").append(toIndentedString(defaultvalue)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displaylength: ").append(toIndentedString(displaylength)).append("\n");
    sb.append("    displaylogic: ").append(toIndentedString(displaylogic)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    exportrealvalue: ").append(toIndentedString(exportrealvalue)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    iscentrallymaintained: ").append(toIndentedString(iscentrallymaintained)).append("\n");
    sb.append("    isdisplayed: ").append(toIndentedString(isdisplayed)).append("\n");
    sb.append("    isdisplayedingrid: ").append(toIndentedString(isdisplayedingrid)).append("\n");
    sb.append("    isencrypted: ").append(toIndentedString(isencrypted)).append("\n");
    sb.append("    isfieldonly: ").append(toIndentedString(isfieldonly)).append("\n");
    sb.append("    isheading: ").append(toIndentedString(isheading)).append("\n");
    sb.append("    isreadonly: ").append(toIndentedString(isreadonly)).append("\n");
    sb.append("    issameline: ").append(toIndentedString(issameline)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    obscuretype: ").append(toIndentedString(obscuretype)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
    sb.append("    sortno: ").append(toIndentedString(sortno)).append("\n");
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
