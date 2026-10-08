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
 * ProcessPara
 */
@Validated



public class ProcessPara   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_element_id")
  private Integer adElementId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_process_id")
  private Integer adProcessId = null;

  @JsonProperty("ad_process_para_id")
  private Integer adProcessParaId = null;

  @JsonProperty("ad_reference_id")
  private Integer adReferenceId = null;

  @JsonProperty("ad_reference_value_id")
  private Integer adReferenceValueId = null;

  @JsonProperty("ad_val_rule_id")
  private Integer adValRuleId = null;

  @JsonProperty("callout")
  private String callout = null;

  @JsonProperty("calloutalsoonload")
  private Boolean calloutalsoonload = null;

  @JsonProperty("columnname")
  private String columnname = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("defaultvalue")
  private String defaultvalue = null;

  @JsonProperty("defaultvalue2")
  private String defaultvalue2 = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("displaylogic")
  private String displaylogic = null;

  @JsonProperty("entitytype")
  private String entitytype = null;

  @JsonProperty("fieldlength")
  private Integer fieldlength = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("iscentrallymaintained")
  private Boolean iscentrallymaintained = null;

  @JsonProperty("isencrypted")
  private Boolean isencrypted = null;

  @JsonProperty("ismandatory")
  private Boolean ismandatory = null;

  @JsonProperty("isrange")
  private Boolean isrange = null;

  @JsonProperty("isreadonly")
  private Boolean isreadonly = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("readonlylogic")
  private String readonlylogic = null;

  @JsonProperty("sameline")
  private Boolean sameline = null;

  @JsonProperty("seqno")
  private Integer seqno = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("valuemax")
  private String valuemax = null;

  @JsonProperty("valuemin")
  private String valuemin = null;

  @JsonProperty("vformat")
  private String vformat = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public ProcessPara adClientId(Integer adClientId) {
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

  public ProcessPara adComponentobjectuid(String adComponentobjectuid) {
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

  public ProcessPara adComponentversionId(Integer adComponentversionId) {
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

  public ProcessPara adElementId(Integer adElementId) {
    this.adElementId = adElementId;
    return this;
  }

  /**
   * El elemento del sistema permite el mantenimiento central de la descripción y ayuda de la columna
   * @return adElementId
   **/
  @Schema(description = "El elemento del sistema permite el mantenimiento central de la descripción y ayuda de la columna")
  
    public Integer getAdElementId() {
    return adElementId;
  }

  public void setAdElementId(Integer adElementId) {
    this.adElementId = adElementId;
  }

  public ProcessPara adOrgId(Integer adOrgId) {
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

  public ProcessPara adProcessId(Integer adProcessId) {
    this.adProcessId = adProcessId;
    return this;
  }

  /**
   * Proceso o Reporte
   * @return adProcessId
   **/
  @Schema(required = true, description = "Proceso o Reporte")
      @NotNull

    public Integer getAdProcessId() {
    return adProcessId;
  }

  public void setAdProcessId(Integer adProcessId) {
    this.adProcessId = adProcessId;
  }

  public ProcessPara adProcessParaId(Integer adProcessParaId) {
    this.adProcessParaId = adProcessParaId;
    return this;
  }

  /**
   *  
   * @return adProcessParaId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getAdProcessParaId() {
    return adProcessParaId;
  }

  public void setAdProcessParaId(Integer adProcessParaId) {
    this.adProcessParaId = adProcessParaId;
  }

  public ProcessPara adReferenceId(Integer adReferenceId) {
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

  public ProcessPara adReferenceValueId(Integer adReferenceValueId) {
    this.adReferenceValueId = adReferenceValueId;
    return this;
  }

  /**
   * Requerido para especificar; si el Tipo de Dato es tabla o Lista
   * @return adReferenceValueId
   **/
  @Schema(description = "Requerido para especificar; si el Tipo de Dato es tabla o Lista")
  
    public Integer getAdReferenceValueId() {
    return adReferenceValueId;
  }

  public void setAdReferenceValueId(Integer adReferenceValueId) {
    this.adReferenceValueId = adReferenceValueId;
  }

  public ProcessPara adValRuleId(Integer adValRuleId) {
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

  public ProcessPara callout(String callout) {
    this.callout = callout;
    return this;
  }

  /**
   * Llamadas de función separadas por punto y coma; SE_/SL_/UE_/UL_ - 1st: System / User; 2nd: Enter / Leave; 3rd: _ Unserscore; - then Function Name
   * @return callout
   **/
  @Schema(description = "Llamadas de función separadas por punto y coma; SE_/SL_/UE_/UL_ - 1st: System / User; 2nd: Enter / Leave; 3rd: _ Unserscore; - then Function Name")
  
    public String getCallout() {
    return callout;
  }

  public void setCallout(String callout) {
    this.callout = callout;
  }

  public ProcessPara calloutalsoonload(Boolean calloutalsoonload) {
    this.calloutalsoonload = calloutalsoonload;
    return this;
  }

  /**
   *  
   * @return calloutalsoonload
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isCalloutalsoonload() {
    return calloutalsoonload;
  }

  public void setCalloutalsoonload(Boolean calloutalsoonload) {
    this.calloutalsoonload = calloutalsoonload;
  }

  public ProcessPara columnname(String columnname) {
    this.columnname = columnname;
    return this;
  }

  /**
   * Nombre de la columna en la base de datos
   * @return columnname
   **/
  @Schema(required = true, description = "Nombre de la columna en la base de datos")
      @NotNull

    public String getColumnname() {
    return columnname;
  }

  public void setColumnname(String columnname) {
    this.columnname = columnname;
  }

  public ProcessPara created(String created) {
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

  public ProcessPara createdby(Integer createdby) {
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

  public ProcessPara defaultvalue(String defaultvalue) {
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

  public ProcessPara defaultvalue2(String defaultvalue2) {
    this.defaultvalue2 = defaultvalue2;
    return this;
  }

  /**
   * Jerarquía de valores predeterminados; separados por ;
   * @return defaultvalue2
   **/
  @Schema(description = "Jerarquía de valores predeterminados; separados por ;")
  
    public String getDefaultvalue2() {
    return defaultvalue2;
  }

  public void setDefaultvalue2(String defaultvalue2) {
    this.defaultvalue2 = defaultvalue2;
  }

  public ProcessPara description(String description) {
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

  public ProcessPara displaylogic(String displaylogic) {
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

  public ProcessPara entitytype(String entitytype) {
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

  public ProcessPara fieldlength(Integer fieldlength) {
    this.fieldlength = fieldlength;
    return this;
  }

  /**
   * Longitud de la columna en la base de datos
   * @return fieldlength
   **/
  @Schema(required = true, description = "Longitud de la columna en la base de datos")
      @NotNull

    public Integer getFieldlength() {
    return fieldlength;
  }

  public void setFieldlength(Integer fieldlength) {
    this.fieldlength = fieldlength;
  }

  public ProcessPara help(String help) {
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

  public ProcessPara isactive(Boolean isactive) {
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

  public ProcessPara iscentrallymaintained(Boolean iscentrallymaintained) {
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

  public ProcessPara isencrypted(Boolean isencrypted) {
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

  public ProcessPara ismandatory(Boolean ismandatory) {
    this.ismandatory = ismandatory;
    return this;
  }

  /**
   * Entrada de datos es requerida en esta columna
   * @return ismandatory
   **/
  @Schema(required = true, description = "Entrada de datos es requerida en esta columna")
      @NotNull

    public Boolean isIsmandatory() {
    return ismandatory;
  }

  public void setIsmandatory(Boolean ismandatory) {
    this.ismandatory = ismandatory;
  }

  public ProcessPara isrange(Boolean isrange) {
    this.isrange = isrange;
    return this;
  }

  /**
   * El parámetro es un rango de valores
   * @return isrange
   **/
  @Schema(required = true, description = "El parámetro es un rango de valores")
      @NotNull

    public Boolean isIsrange() {
    return isrange;
  }

  public void setIsrange(Boolean isrange) {
    this.isrange = isrange;
  }

  public ProcessPara isreadonly(Boolean isreadonly) {
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

  public ProcessPara name(String name) {
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

  public ProcessPara readonlylogic(String readonlylogic) {
    this.readonlylogic = readonlylogic;
    return this;
  }

  /**
   * Lógica para determinar si el campo es de sólo lectura (aplica solamente cuando el campo es lectura-escritura
   * @return readonlylogic
   **/
  @Schema(description = "Lógica para determinar si el campo es de sólo lectura (aplica solamente cuando el campo es lectura-escritura")
  
    public String getReadonlylogic() {
    return readonlylogic;
  }

  public void setReadonlylogic(String readonlylogic) {
    this.readonlylogic = readonlylogic;
  }

  public ProcessPara sameline(Boolean sameline) {
    this.sameline = sameline;
    return this;
  }

  /**
   *  
   * @return sameline
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isSameline() {
    return sameline;
  }

  public void setSameline(Boolean sameline) {
    this.sameline = sameline;
  }

  public ProcessPara seqno(Integer seqno) {
    this.seqno = seqno;
    return this;
  }

  /**
   * Método de ordenar registros; el número más bajo viene primero
   * @return seqno
   **/
  @Schema(required = true, description = "Método de ordenar registros; el número más bajo viene primero")
      @NotNull

    public Integer getSeqno() {
    return seqno;
  }

  public void setSeqno(Integer seqno) {
    this.seqno = seqno;
  }

  public ProcessPara updated(String updated) {
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

  public ProcessPara updatedby(Integer updatedby) {
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

  public ProcessPara valuemax(String valuemax) {
    this.valuemax = valuemax;
    return this;
  }

  /**
   * Valor Máximo de un campo
   * @return valuemax
   **/
  @Schema(description = "Valor Máximo de un campo")
  
    public String getValuemax() {
    return valuemax;
  }

  public void setValuemax(String valuemax) {
    this.valuemax = valuemax;
  }

  public ProcessPara valuemin(String valuemin) {
    this.valuemin = valuemin;
    return this;
  }

  /**
   * Valor Mínimo de un campo
   * @return valuemin
   **/
  @Schema(description = "Valor Mínimo de un campo")
  
    public String getValuemin() {
    return valuemin;
  }

  public void setValuemin(String valuemin) {
    this.valuemin = valuemin;
  }

  public ProcessPara vformat(String vformat) {
    this.vformat = vformat;
    return this;
  }

  /**
   * Formato del valor; puede contener elementos de formato fijo; Variables: \"_lLoOaAcCa09\"
   * @return vformat
   **/
  @Schema(description = "Formato del valor; puede contener elementos de formato fijo; Variables: \"_lLoOaAcCa09\"")
  
    public String getVformat() {
    return vformat;
  }

  public void setVformat(String vformat) {
    this.vformat = vformat;
  }

  public ProcessPara additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ProcessPara addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ProcessPara referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ProcessPara addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ProcessPara processPara = (ProcessPara) o;
    return Objects.equals(this.adClientId, processPara.adClientId) &&
        Objects.equals(this.adComponentobjectuid, processPara.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, processPara.adComponentversionId) &&
        Objects.equals(this.adElementId, processPara.adElementId) &&
        Objects.equals(this.adOrgId, processPara.adOrgId) &&
        Objects.equals(this.adProcessId, processPara.adProcessId) &&
        Objects.equals(this.adProcessParaId, processPara.adProcessParaId) &&
        Objects.equals(this.adReferenceId, processPara.adReferenceId) &&
        Objects.equals(this.adReferenceValueId, processPara.adReferenceValueId) &&
        Objects.equals(this.adValRuleId, processPara.adValRuleId) &&
        Objects.equals(this.callout, processPara.callout) &&
        Objects.equals(this.calloutalsoonload, processPara.calloutalsoonload) &&
        Objects.equals(this.columnname, processPara.columnname) &&
        Objects.equals(this.created, processPara.created) &&
        Objects.equals(this.createdby, processPara.createdby) &&
        Objects.equals(this.defaultvalue, processPara.defaultvalue) &&
        Objects.equals(this.defaultvalue2, processPara.defaultvalue2) &&
        Objects.equals(this.description, processPara.description) &&
        Objects.equals(this.displaylogic, processPara.displaylogic) &&
        Objects.equals(this.entitytype, processPara.entitytype) &&
        Objects.equals(this.fieldlength, processPara.fieldlength) &&
        Objects.equals(this.help, processPara.help) &&
        Objects.equals(this.isactive, processPara.isactive) &&
        Objects.equals(this.iscentrallymaintained, processPara.iscentrallymaintained) &&
        Objects.equals(this.isencrypted, processPara.isencrypted) &&
        Objects.equals(this.ismandatory, processPara.ismandatory) &&
        Objects.equals(this.isrange, processPara.isrange) &&
        Objects.equals(this.isreadonly, processPara.isreadonly) &&
        Objects.equals(this.name, processPara.name) &&
        Objects.equals(this.readonlylogic, processPara.readonlylogic) &&
        Objects.equals(this.sameline, processPara.sameline) &&
        Objects.equals(this.seqno, processPara.seqno) &&
        Objects.equals(this.updated, processPara.updated) &&
        Objects.equals(this.updatedby, processPara.updatedby) &&
        Objects.equals(this.valuemax, processPara.valuemax) &&
        Objects.equals(this.valuemin, processPara.valuemin) &&
        Objects.equals(this.vformat, processPara.vformat) &&
        Objects.equals(this.additionalvalues, processPara.additionalvalues) &&
        Objects.equals(this.referencedvalues, processPara.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adElementId, adOrgId, adProcessId, adProcessParaId, adReferenceId, adReferenceValueId, adValRuleId, callout, calloutalsoonload, columnname, created, createdby, defaultvalue, defaultvalue2, description, displaylogic, entitytype, fieldlength, help, isactive, iscentrallymaintained, isencrypted, ismandatory, isrange, isreadonly, name, readonlylogic, sameline, seqno, updated, updatedby, valuemax, valuemin, vformat, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessPara {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adElementId: ").append(toIndentedString(adElementId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adProcessId: ").append(toIndentedString(adProcessId)).append("\n");
    sb.append("    adProcessParaId: ").append(toIndentedString(adProcessParaId)).append("\n");
    sb.append("    adReferenceId: ").append(toIndentedString(adReferenceId)).append("\n");
    sb.append("    adReferenceValueId: ").append(toIndentedString(adReferenceValueId)).append("\n");
    sb.append("    adValRuleId: ").append(toIndentedString(adValRuleId)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
    sb.append("    calloutalsoonload: ").append(toIndentedString(calloutalsoonload)).append("\n");
    sb.append("    columnname: ").append(toIndentedString(columnname)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    defaultvalue: ").append(toIndentedString(defaultvalue)).append("\n");
    sb.append("    defaultvalue2: ").append(toIndentedString(defaultvalue2)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displaylogic: ").append(toIndentedString(displaylogic)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    fieldlength: ").append(toIndentedString(fieldlength)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    iscentrallymaintained: ").append(toIndentedString(iscentrallymaintained)).append("\n");
    sb.append("    isencrypted: ").append(toIndentedString(isencrypted)).append("\n");
    sb.append("    ismandatory: ").append(toIndentedString(ismandatory)).append("\n");
    sb.append("    isrange: ").append(toIndentedString(isrange)).append("\n");
    sb.append("    isreadonly: ").append(toIndentedString(isreadonly)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    readonlylogic: ").append(toIndentedString(readonlylogic)).append("\n");
    sb.append("    sameline: ").append(toIndentedString(sameline)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    valuemax: ").append(toIndentedString(valuemax)).append("\n");
    sb.append("    valuemin: ").append(toIndentedString(valuemin)).append("\n");
    sb.append("    vformat: ").append(toIndentedString(vformat)).append("\n");
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
