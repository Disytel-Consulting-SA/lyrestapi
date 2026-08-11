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
 * Column
 */
@Validated



public class Column   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_column_id")
  private Integer adColumnId = null;

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

  @JsonProperty("ad_reference_id")
  private Integer adReferenceId = null;

  @JsonProperty("ad_reference_value_id")
  private Integer adReferenceValueId = null;

  @JsonProperty("ad_table_id")
  private Integer adTableId = null;

  @JsonProperty("ad_val_rule_id")
  private Integer adValRuleId = null;

  @JsonProperty("callout")
  private String callout = null;

  @JsonProperty("calloutalsoonload")
  private Boolean calloutalsoonload = null;

  @JsonProperty("columnname")
  private String columnname = null;

  @JsonProperty("columnsql")
  private String columnsql = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("defaultvalue")
  private String defaultvalue = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("entitytype")
  private String entitytype = null;

  @JsonProperty("fieldlength")
  private Integer fieldlength = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isalwaysupdateable")
  private Boolean isalwaysupdateable = null;

  @JsonProperty("isencrypted")
  private Boolean isencrypted = null;

  @JsonProperty("isidentifier")
  private Boolean isidentifier = null;

  @JsonProperty("iskey")
  private Boolean iskey = null;

  @JsonProperty("islink")
  private Boolean islink = null;

  @JsonProperty("ismandatory")
  private Boolean ismandatory = null;

  @JsonProperty("isparent")
  private Boolean isparent = null;

  @JsonProperty("isselectioncolumn")
  private Boolean isselectioncolumn = null;

  @JsonProperty("issyncdatabase")
  private String issyncdatabase = null;

  @JsonProperty("istranslated")
  private Boolean istranslated = null;

  @JsonProperty("isupdateable")
  private Boolean isupdateable = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("prefijolink")
  private String prefijolink = null;

  @JsonProperty("readonlylogic")
  private String readonlylogic = null;

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

  @JsonProperty("version")
  private BigDecimal version = null;

  @JsonProperty("vformat")
  private String vformat = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Column adClientId(Integer adClientId) {
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

  public Column adColumnId(Integer adColumnId) {
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

  public Column adComponentobjectuid(String adComponentobjectuid) {
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

  public Column adComponentversionId(Integer adComponentversionId) {
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

  public Column adElementId(Integer adElementId) {
    this.adElementId = adElementId;
    return this;
  }

  /**
   * El elemento del sistema permite el mantenimiento central de la descripción y ayuda de la columna
   * @return adElementId
   **/
  @Schema(required = true, description = "El elemento del sistema permite el mantenimiento central de la descripción y ayuda de la columna")
      @NotNull

    public Integer getAdElementId() {
    return adElementId;
  }

  public void setAdElementId(Integer adElementId) {
    this.adElementId = adElementId;
  }

  public Column adOrgId(Integer adOrgId) {
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

  public Column adProcessId(Integer adProcessId) {
    this.adProcessId = adProcessId;
    return this;
  }

  /**
   * Proceso o Reporte
   * @return adProcessId
   **/
  @Schema(description = "Proceso o Reporte")
  
    public Integer getAdProcessId() {
    return adProcessId;
  }

  public void setAdProcessId(Integer adProcessId) {
    this.adProcessId = adProcessId;
  }

  public Column adReferenceId(Integer adReferenceId) {
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

  public Column adReferenceValueId(Integer adReferenceValueId) {
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

  public Column adTableId(Integer adTableId) {
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

  public Column adValRuleId(Integer adValRuleId) {
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

  public Column callout(String callout) {
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

  public Column calloutalsoonload(Boolean calloutalsoonload) {
    this.calloutalsoonload = calloutalsoonload;
    return this;
  }

  /**
   *  
   * @return calloutalsoonload
   **/
  @Schema(description = " ")
  
    public Boolean isCalloutalsoonload() {
    return calloutalsoonload;
  }

  public void setCalloutalsoonload(Boolean calloutalsoonload) {
    this.calloutalsoonload = calloutalsoonload;
  }

  public Column columnname(String columnname) {
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

  public Column columnsql(String columnsql) {
    this.columnsql = columnsql;
    return this;
  }

  /**
   * Columna SQL
   * @return columnsql
   **/
  @Schema(description = "Columna SQL")
  
    public String getColumnsql() {
    return columnsql;
  }

  public void setColumnsql(String columnsql) {
    this.columnsql = columnsql;
  }

  public Column created(String created) {
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

  public Column createdby(Integer createdby) {
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

  public Column defaultvalue(String defaultvalue) {
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

  public Column description(String description) {
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

  public Column entitytype(String entitytype) {
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

  public Column fieldlength(Integer fieldlength) {
    this.fieldlength = fieldlength;
    return this;
  }

  /**
   * Longitud de la columna en la base de datos
   * @return fieldlength
   **/
  @Schema(description = "Longitud de la columna en la base de datos")
  
    public Integer getFieldlength() {
    return fieldlength;
  }

  public void setFieldlength(Integer fieldlength) {
    this.fieldlength = fieldlength;
  }

  public Column help(String help) {
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

  public Column isactive(Boolean isactive) {
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

  public Column isalwaysupdateable(Boolean isalwaysupdateable) {
    this.isalwaysupdateable = isalwaysupdateable;
    return this;
  }

  /**
   * La columna siempre se puede actualizar
   * @return isalwaysupdateable
   **/
  @Schema(required = true, description = "La columna siempre se puede actualizar")
      @NotNull

    public Boolean isIsalwaysupdateable() {
    return isalwaysupdateable;
  }

  public void setIsalwaysupdateable(Boolean isalwaysupdateable) {
    this.isalwaysupdateable = isalwaysupdateable;
  }

  public Column isencrypted(Boolean isencrypted) {
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

  public Column isidentifier(Boolean isidentifier) {
    this.isidentifier = isidentifier;
    return this;
  }

  /**
   * Esta columna es parte del identificador del registro
   * @return isidentifier
   **/
  @Schema(required = true, description = "Esta columna es parte del identificador del registro")
      @NotNull

    public Boolean isIsidentifier() {
    return isidentifier;
  }

  public void setIsidentifier(Boolean isidentifier) {
    this.isidentifier = isidentifier;
  }

  public Column iskey(Boolean iskey) {
    this.iskey = iskey;
    return this;
  }

  /**
   * Esta columna es la clave en esta tabla
   * @return iskey
   **/
  @Schema(required = true, description = "Esta columna es la clave en esta tabla")
      @NotNull

    public Boolean isIskey() {
    return iskey;
  }

  public void setIskey(Boolean iskey) {
    this.iskey = iskey;
  }

  public Column islink(Boolean islink) {
    this.islink = islink;
    return this;
  }

  /**
   *  
   * @return islink
   **/
  @Schema(description = " ")
  
    public Boolean isIslink() {
    return islink;
  }

  public void setIslink(Boolean islink) {
    this.islink = islink;
  }

  public Column ismandatory(Boolean ismandatory) {
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

  public Column isparent(Boolean isparent) {
    this.isparent = isparent;
    return this;
  }

  /**
   * Esta columna es un enlace a la tabla principal (Ej. Cabecera desde líneas) - incl. Asociación con columnas clave
   * @return isparent
   **/
  @Schema(required = true, description = "Esta columna es un enlace a la tabla principal (Ej. Cabecera desde líneas) - incl. Asociación con columnas clave")
      @NotNull

    public Boolean isIsparent() {
    return isparent;
  }

  public void setIsparent(Boolean isparent) {
    this.isparent = isparent;
  }

  public Column isselectioncolumn(Boolean isselectioncolumn) {
    this.isselectioncolumn = isselectioncolumn;
    return this;
  }

  /**
   * Esta columna se usa para encontrar lineas en ventanas
   * @return isselectioncolumn
   **/
  @Schema(required = true, description = "Esta columna se usa para encontrar lineas en ventanas")
      @NotNull

    public Boolean isIsselectioncolumn() {
    return isselectioncolumn;
  }

  public void setIsselectioncolumn(Boolean isselectioncolumn) {
    this.isselectioncolumn = isselectioncolumn;
  }

  public Column issyncdatabase(String issyncdatabase) {
    this.issyncdatabase = issyncdatabase;
    return this;
  }

  /**
   * Cambia definición de tabla de base de datos cuando cambia la definición del diccionario
   * @return issyncdatabase
   **/
  @Schema(description = "Cambia definición de tabla de base de datos cuando cambia la definición del diccionario")
  
    public String getIssyncdatabase() {
    return issyncdatabase;
  }

  public void setIssyncdatabase(String issyncdatabase) {
    this.issyncdatabase = issyncdatabase;
  }

  public Column istranslated(Boolean istranslated) {
    this.istranslated = istranslated;
    return this;
  }

  /**
   * Esta columna está traducida
   * @return istranslated
   **/
  @Schema(required = true, description = "Esta columna está traducida")
      @NotNull

    public Boolean isIstranslated() {
    return istranslated;
  }

  public void setIstranslated(Boolean istranslated) {
    this.istranslated = istranslated;
  }

  public Column isupdateable(Boolean isupdateable) {
    this.isupdateable = isupdateable;
    return this;
  }

  /**
   * Determina si el campo puede ser actualizado
   * @return isupdateable
   **/
  @Schema(required = true, description = "Determina si el campo puede ser actualizado")
      @NotNull

    public Boolean isIsupdateable() {
    return isupdateable;
  }

  public void setIsupdateable(Boolean isupdateable) {
    this.isupdateable = isupdateable;
  }

  public Column name(String name) {
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

  public Column prefijolink(String prefijolink) {
    this.prefijolink = prefijolink;
    return this;
  }

  /**
   *  
   * @return prefijolink
   **/
  @Schema(description = " ")
  
    public String getPrefijolink() {
    return prefijolink;
  }

  public void setPrefijolink(String prefijolink) {
    this.prefijolink = prefijolink;
  }

  public Column readonlylogic(String readonlylogic) {
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

  public Column seqno(Integer seqno) {
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

  public Column updated(String updated) {
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

  public Column updatedby(Integer updatedby) {
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

  public Column valuemax(String valuemax) {
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

  public Column valuemin(String valuemin) {
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

  public Column version(BigDecimal version) {
    this.version = version;
    return this;
  }

  /**
   * Versión de la definición de tabla
   * @return version
   **/
  @Schema(required = true, description = "Versión de la definición de tabla")
      @NotNull

    @Valid
    public BigDecimal getVersion() {
    return version;
  }

  public void setVersion(BigDecimal version) {
    this.version = version;
  }

  public Column vformat(String vformat) {
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

  public Column additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Column addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Column referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Column addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Column column = (Column) o;
    return Objects.equals(this.adClientId, column.adClientId) &&
        Objects.equals(this.adColumnId, column.adColumnId) &&
        Objects.equals(this.adComponentobjectuid, column.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, column.adComponentversionId) &&
        Objects.equals(this.adElementId, column.adElementId) &&
        Objects.equals(this.adOrgId, column.adOrgId) &&
        Objects.equals(this.adProcessId, column.adProcessId) &&
        Objects.equals(this.adReferenceId, column.adReferenceId) &&
        Objects.equals(this.adReferenceValueId, column.adReferenceValueId) &&
        Objects.equals(this.adTableId, column.adTableId) &&
        Objects.equals(this.adValRuleId, column.adValRuleId) &&
        Objects.equals(this.callout, column.callout) &&
        Objects.equals(this.calloutalsoonload, column.calloutalsoonload) &&
        Objects.equals(this.columnname, column.columnname) &&
        Objects.equals(this.columnsql, column.columnsql) &&
        Objects.equals(this.created, column.created) &&
        Objects.equals(this.createdby, column.createdby) &&
        Objects.equals(this.defaultvalue, column.defaultvalue) &&
        Objects.equals(this.description, column.description) &&
        Objects.equals(this.entitytype, column.entitytype) &&
        Objects.equals(this.fieldlength, column.fieldlength) &&
        Objects.equals(this.help, column.help) &&
        Objects.equals(this.isactive, column.isactive) &&
        Objects.equals(this.isalwaysupdateable, column.isalwaysupdateable) &&
        Objects.equals(this.isencrypted, column.isencrypted) &&
        Objects.equals(this.isidentifier, column.isidentifier) &&
        Objects.equals(this.iskey, column.iskey) &&
        Objects.equals(this.islink, column.islink) &&
        Objects.equals(this.ismandatory, column.ismandatory) &&
        Objects.equals(this.isparent, column.isparent) &&
        Objects.equals(this.isselectioncolumn, column.isselectioncolumn) &&
        Objects.equals(this.issyncdatabase, column.issyncdatabase) &&
        Objects.equals(this.istranslated, column.istranslated) &&
        Objects.equals(this.isupdateable, column.isupdateable) &&
        Objects.equals(this.name, column.name) &&
        Objects.equals(this.prefijolink, column.prefijolink) &&
        Objects.equals(this.readonlylogic, column.readonlylogic) &&
        Objects.equals(this.seqno, column.seqno) &&
        Objects.equals(this.updated, column.updated) &&
        Objects.equals(this.updatedby, column.updatedby) &&
        Objects.equals(this.valuemax, column.valuemax) &&
        Objects.equals(this.valuemin, column.valuemin) &&
        Objects.equals(this.version, column.version) &&
        Objects.equals(this.vformat, column.vformat) &&
        Objects.equals(this.additionalvalues, column.additionalvalues) &&
        Objects.equals(this.referencedvalues, column.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adColumnId, adComponentobjectuid, adComponentversionId, adElementId, adOrgId, adProcessId, adReferenceId, adReferenceValueId, adTableId, adValRuleId, callout, calloutalsoonload, columnname, columnsql, created, createdby, defaultvalue, description, entitytype, fieldlength, help, isactive, isalwaysupdateable, isencrypted, isidentifier, iskey, islink, ismandatory, isparent, isselectioncolumn, issyncdatabase, istranslated, isupdateable, name, prefijolink, readonlylogic, seqno, updated, updatedby, valuemax, valuemin, version, vformat, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Column {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adColumnId: ").append(toIndentedString(adColumnId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adElementId: ").append(toIndentedString(adElementId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adProcessId: ").append(toIndentedString(adProcessId)).append("\n");
    sb.append("    adReferenceId: ").append(toIndentedString(adReferenceId)).append("\n");
    sb.append("    adReferenceValueId: ").append(toIndentedString(adReferenceValueId)).append("\n");
    sb.append("    adTableId: ").append(toIndentedString(adTableId)).append("\n");
    sb.append("    adValRuleId: ").append(toIndentedString(adValRuleId)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
    sb.append("    calloutalsoonload: ").append(toIndentedString(calloutalsoonload)).append("\n");
    sb.append("    columnname: ").append(toIndentedString(columnname)).append("\n");
    sb.append("    columnsql: ").append(toIndentedString(columnsql)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    defaultvalue: ").append(toIndentedString(defaultvalue)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    fieldlength: ").append(toIndentedString(fieldlength)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isalwaysupdateable: ").append(toIndentedString(isalwaysupdateable)).append("\n");
    sb.append("    isencrypted: ").append(toIndentedString(isencrypted)).append("\n");
    sb.append("    isidentifier: ").append(toIndentedString(isidentifier)).append("\n");
    sb.append("    iskey: ").append(toIndentedString(iskey)).append("\n");
    sb.append("    islink: ").append(toIndentedString(islink)).append("\n");
    sb.append("    ismandatory: ").append(toIndentedString(ismandatory)).append("\n");
    sb.append("    isparent: ").append(toIndentedString(isparent)).append("\n");
    sb.append("    isselectioncolumn: ").append(toIndentedString(isselectioncolumn)).append("\n");
    sb.append("    issyncdatabase: ").append(toIndentedString(issyncdatabase)).append("\n");
    sb.append("    istranslated: ").append(toIndentedString(istranslated)).append("\n");
    sb.append("    isupdateable: ").append(toIndentedString(isupdateable)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    prefijolink: ").append(toIndentedString(prefijolink)).append("\n");
    sb.append("    readonlylogic: ").append(toIndentedString(readonlylogic)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    valuemax: ").append(toIndentedString(valuemax)).append("\n");
    sb.append("    valuemin: ").append(toIndentedString(valuemin)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
