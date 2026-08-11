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
 * Table
 */
@Validated



public class Table   {
  @JsonProperty("accesslevel")
  private String accesslevel = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_table_id")
  private Integer adTableId = null;

  @JsonProperty("ad_val_rule_id")
  private Integer adValRuleId = null;

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

  @JsonProperty("generatedirectmethods")
  private Boolean generatedirectmethods = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("importtable")
  private String importtable = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("ischangelog")
  private Boolean ischangelog = null;

  @JsonProperty("isdeleteable")
  private Boolean isdeleteable = null;

  @JsonProperty("ishighvolume")
  private Boolean ishighvolume = null;

  @JsonProperty("issecurityenabled")
  private Boolean issecurityenabled = null;

  @JsonProperty("isview")
  private Boolean isview = null;

  @JsonProperty("loadseq")
  private Integer loadseq = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("po_window_id")
  private Integer poWindowId = null;

  @JsonProperty("replicationtype")
  private String replicationtype = null;

  @JsonProperty("tablename")
  private String tablename = null;

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

  public Table accesslevel(String accesslevel) {
    this.accesslevel = accesslevel;
    return this;
  }

  /**
   * Nivel de Acceso requerido
   * @return accesslevel
   **/
  @Schema(required = true, description = "Nivel de Acceso requerido")
      @NotNull

    public String getAccesslevel() {
    return accesslevel;
  }

  public void setAccesslevel(String accesslevel) {
    this.accesslevel = accesslevel;
  }

  public Table adClientId(Integer adClientId) {
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

  public Table adComponentobjectuid(String adComponentobjectuid) {
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

  public Table adComponentversionId(Integer adComponentversionId) {
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

  public Table adOrgId(Integer adOrgId) {
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

  public Table adTableId(Integer adTableId) {
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

  public Table adValRuleId(Integer adValRuleId) {
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

  public Table adWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
    return this;
  }

  /**
   * Ventana de Entrada de datos o despliegue
   * @return adWindowId
   **/
  @Schema(description = "Ventana de Entrada de datos o despliegue")
  
    public Integer getAdWindowId() {
    return adWindowId;
  }

  public void setAdWindowId(Integer adWindowId) {
    this.adWindowId = adWindowId;
  }

  public Table created(String created) {
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

  public Table createdby(Integer createdby) {
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

  public Table description(String description) {
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

  public Table entitytype(String entitytype) {
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

  public Table generatedirectmethods(Boolean generatedirectmethods) {
    this.generatedirectmethods = generatedirectmethods;
    return this;
  }

  /**
   * Utilizado por el GenerateModel para saber que clases X deberan generarse con el metodo insertDirect()
   * @return generatedirectmethods
   **/
  @Schema(description = "Utilizado por el GenerateModel para saber que clases X deberan generarse con el metodo insertDirect()")
  
    public Boolean isGeneratedirectmethods() {
    return generatedirectmethods;
  }

  public void setGeneratedirectmethods(Boolean generatedirectmethods) {
    this.generatedirectmethods = generatedirectmethods;
  }

  public Table help(String help) {
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

  public Table importtable(String importtable) {
    this.importtable = importtable;
    return this;
  }

  /**
   * Importa columnas de tabla desde Base de Datos
   * @return importtable
   **/
  @Schema(description = "Importa columnas de tabla desde Base de Datos")
  
    public String getImporttable() {
    return importtable;
  }

  public void setImporttable(String importtable) {
    this.importtable = importtable;
  }

  public Table isactive(Boolean isactive) {
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

  public Table ischangelog(Boolean ischangelog) {
    this.ischangelog = ischangelog;
    return this;
  }

  /**
   * Mantener Archivo (log) de Cambios
   * @return ischangelog
   **/
  @Schema(required = true, description = "Mantener Archivo (log) de Cambios")
      @NotNull

    public Boolean isIschangelog() {
    return ischangelog;
  }

  public void setIschangelog(Boolean ischangelog) {
    this.ischangelog = ischangelog;
  }

  public Table isdeleteable(Boolean isdeleteable) {
    this.isdeleteable = isdeleteable;
    return this;
  }

  /**
   * Indica si los registros pueden ser eliminados de la base de datos
   * @return isdeleteable
   **/
  @Schema(required = true, description = "Indica si los registros pueden ser eliminados de la base de datos")
      @NotNull

    public Boolean isIsdeleteable() {
    return isdeleteable;
  }

  public void setIsdeleteable(Boolean isdeleteable) {
    this.isdeleteable = isdeleteable;
  }

  public Table ishighvolume(Boolean ishighvolume) {
    this.ishighvolume = ishighvolume;
    return this;
  }

  /**
   * Use búsqueda en lugar de lista de recolección
   * @return ishighvolume
   **/
  @Schema(required = true, description = "Use búsqueda en lugar de lista de recolección")
      @NotNull

    public Boolean isIshighvolume() {
    return ishighvolume;
  }

  public void setIshighvolume(Boolean ishighvolume) {
    this.ishighvolume = ishighvolume;
  }

  public Table issecurityenabled(Boolean issecurityenabled) {
    this.issecurityenabled = issecurityenabled;
    return this;
  }

  /**
   * Si la seguridad esta habilitada; el acceso del usuario a los datos puede ser restringido vía Perfiles
   * @return issecurityenabled
   **/
  @Schema(required = true, description = "Si la seguridad esta habilitada; el acceso del usuario a los datos puede ser restringido vía Perfiles")
      @NotNull

    public Boolean isIssecurityenabled() {
    return issecurityenabled;
  }

  public void setIssecurityenabled(Boolean issecurityenabled) {
    this.issecurityenabled = issecurityenabled;
  }

  public Table isview(Boolean isview) {
    this.isview = isview;
    return this;
  }

  /**
   * Ésta es una vista
   * @return isview
   **/
  @Schema(required = true, description = "Ésta es una vista")
      @NotNull

    public Boolean isIsview() {
    return isview;
  }

  public void setIsview(Boolean isview) {
    this.isview = isview;
  }

  public Table loadseq(Integer loadseq) {
    this.loadseq = loadseq;
    return this;
  }

  /**
   *  
   * @return loadseq
   **/
  @Schema(description = " ")
  
    public Integer getLoadseq() {
    return loadseq;
  }

  public void setLoadseq(Integer loadseq) {
    this.loadseq = loadseq;
  }

  public Table name(String name) {
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

  public Table poWindowId(Integer poWindowId) {
    this.poWindowId = poWindowId;
    return this;
  }

  /**
   * Ventana de Transaccion de Compras
   * @return poWindowId
   **/
  @Schema(description = "Ventana de Transaccion de Compras")
  
    public Integer getPoWindowId() {
    return poWindowId;
  }

  public void setPoWindowId(Integer poWindowId) {
    this.poWindowId = poWindowId;
  }

  public Table replicationtype(String replicationtype) {
    this.replicationtype = replicationtype;
    return this;
  }

  /**
   * Tipo de Replicación
   * @return replicationtype
   **/
  @Schema(required = true, description = "Tipo de Replicación")
      @NotNull

    public String getReplicationtype() {
    return replicationtype;
  }

  public void setReplicationtype(String replicationtype) {
    this.replicationtype = replicationtype;
  }

  public Table tablename(String tablename) {
    this.tablename = tablename;
    return this;
  }

  /**
   * Nombre de la tabla en la base de datos
   * @return tablename
   **/
  @Schema(required = true, description = "Nombre de la tabla en la base de datos")
      @NotNull

    public String getTablename() {
    return tablename;
  }

  public void setTablename(String tablename) {
    this.tablename = tablename;
  }

  public Table updated(String updated) {
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

  public Table updatedby(Integer updatedby) {
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

  public Table additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Table addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Table referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Table addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Table table = (Table) o;
    return Objects.equals(this.accesslevel, table.accesslevel) &&
        Objects.equals(this.adClientId, table.adClientId) &&
        Objects.equals(this.adComponentobjectuid, table.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, table.adComponentversionId) &&
        Objects.equals(this.adOrgId, table.adOrgId) &&
        Objects.equals(this.adTableId, table.adTableId) &&
        Objects.equals(this.adValRuleId, table.adValRuleId) &&
        Objects.equals(this.adWindowId, table.adWindowId) &&
        Objects.equals(this.created, table.created) &&
        Objects.equals(this.createdby, table.createdby) &&
        Objects.equals(this.description, table.description) &&
        Objects.equals(this.entitytype, table.entitytype) &&
        Objects.equals(this.generatedirectmethods, table.generatedirectmethods) &&
        Objects.equals(this.help, table.help) &&
        Objects.equals(this.importtable, table.importtable) &&
        Objects.equals(this.isactive, table.isactive) &&
        Objects.equals(this.ischangelog, table.ischangelog) &&
        Objects.equals(this.isdeleteable, table.isdeleteable) &&
        Objects.equals(this.ishighvolume, table.ishighvolume) &&
        Objects.equals(this.issecurityenabled, table.issecurityenabled) &&
        Objects.equals(this.isview, table.isview) &&
        Objects.equals(this.loadseq, table.loadseq) &&
        Objects.equals(this.name, table.name) &&
        Objects.equals(this.poWindowId, table.poWindowId) &&
        Objects.equals(this.replicationtype, table.replicationtype) &&
        Objects.equals(this.tablename, table.tablename) &&
        Objects.equals(this.updated, table.updated) &&
        Objects.equals(this.updatedby, table.updatedby) &&
        Objects.equals(this.additionalvalues, table.additionalvalues) &&
        Objects.equals(this.referencedvalues, table.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accesslevel, adClientId, adComponentobjectuid, adComponentversionId, adOrgId, adTableId, adValRuleId, adWindowId, created, createdby, description, entitytype, generatedirectmethods, help, importtable, isactive, ischangelog, isdeleteable, ishighvolume, issecurityenabled, isview, loadseq, name, poWindowId, replicationtype, tablename, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Table {\n");
    
    sb.append("    accesslevel: ").append(toIndentedString(accesslevel)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adTableId: ").append(toIndentedString(adTableId)).append("\n");
    sb.append("    adValRuleId: ").append(toIndentedString(adValRuleId)).append("\n");
    sb.append("    adWindowId: ").append(toIndentedString(adWindowId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    generatedirectmethods: ").append(toIndentedString(generatedirectmethods)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    importtable: ").append(toIndentedString(importtable)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    ischangelog: ").append(toIndentedString(ischangelog)).append("\n");
    sb.append("    isdeleteable: ").append(toIndentedString(isdeleteable)).append("\n");
    sb.append("    ishighvolume: ").append(toIndentedString(ishighvolume)).append("\n");
    sb.append("    issecurityenabled: ").append(toIndentedString(issecurityenabled)).append("\n");
    sb.append("    isview: ").append(toIndentedString(isview)).append("\n");
    sb.append("    loadseq: ").append(toIndentedString(loadseq)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    poWindowId: ").append(toIndentedString(poWindowId)).append("\n");
    sb.append("    replicationtype: ").append(toIndentedString(replicationtype)).append("\n");
    sb.append("    tablename: ").append(toIndentedString(tablename)).append("\n");
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
