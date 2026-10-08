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
 * Process
 */
@Validated



public class Process   {
  @JsonProperty("accesslevel")
  private String accesslevel = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_expformat_id")
  private Integer adExpformatId = null;

  @JsonProperty("ad_form_id")
  private Integer adFormId = null;

  @JsonProperty("ad_jasperreport_id")
  private Integer adJasperreportId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_printformat_id")
  private Integer adPrintformatId = null;

  @JsonProperty("ad_process_id")
  private Integer adProcessId = null;

  @JsonProperty("ad_reportview_id")
  private Integer adReportviewId = null;

  @JsonProperty("ad_workflow_id")
  private Integer adWorkflowId = null;

  @JsonProperty("classname")
  private String classname = null;

  @JsonProperty("concurrentexecution")
  private String concurrentexecution = null;

  @JsonProperty("copyparameters")
  private String copyparameters = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("dynamicreport")
  private Boolean dynamicreport = null;

  @JsonProperty("entitytype")
  private String entitytype = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isalwaysinclient")
  private Boolean isalwaysinclient = null;

  @JsonProperty("isbetafunctionality")
  private Boolean isbetafunctionality = null;

  @JsonProperty("isdirectprint")
  private Boolean isdirectprint = null;

  @JsonProperty("isjasperreport")
  private Boolean isjasperreport = null;

  @JsonProperty("isreport")
  private Boolean isreport = null;

  @JsonProperty("jasperreport")
  private String jasperreport = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("procedurename")
  private String procedurename = null;

  @JsonProperty("showhelp")
  private Boolean showhelp = null;

  @JsonProperty("statistic_count")
  private Integer statisticCount = null;

  @JsonProperty("statistic_seconds")
  private Integer statisticSeconds = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("workflowvalue")
  private String workflowvalue = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Process accesslevel(String accesslevel) {
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

  public Process adClientId(Integer adClientId) {
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

  public Process adComponentobjectuid(String adComponentobjectuid) {
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

  public Process adComponentversionId(Integer adComponentversionId) {
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

  public Process adExpformatId(Integer adExpformatId) {
    this.adExpformatId = adExpformatId;
    return this;
  }

  /**
   *  
   * @return adExpformatId
   **/
  @Schema(description = " ")
  
    public Integer getAdExpformatId() {
    return adExpformatId;
  }

  public void setAdExpformatId(Integer adExpformatId) {
    this.adExpformatId = adExpformatId;
  }

  public Process adFormId(Integer adFormId) {
    this.adFormId = adFormId;
    return this;
  }

  /**
   * Formulario
   * @return adFormId
   **/
  @Schema(description = "Formulario")
  
    public Integer getAdFormId() {
    return adFormId;
  }

  public void setAdFormId(Integer adFormId) {
    this.adFormId = adFormId;
  }

  public Process adJasperreportId(Integer adJasperreportId) {
    this.adJasperreportId = adJasperreportId;
    return this;
  }

  /**
   *  
   * @return adJasperreportId
   **/
  @Schema(description = " ")
  
    public Integer getAdJasperreportId() {
    return adJasperreportId;
  }

  public void setAdJasperreportId(Integer adJasperreportId) {
    this.adJasperreportId = adJasperreportId;
  }

  public Process adOrgId(Integer adOrgId) {
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

  public Process adPrintformatId(Integer adPrintformatId) {
    this.adPrintformatId = adPrintformatId;
    return this;
  }

  /**
   * Formato de Impresión de datos
   * @return adPrintformatId
   **/
  @Schema(description = "Formato de Impresión de datos")
  
    public Integer getAdPrintformatId() {
    return adPrintformatId;
  }

  public void setAdPrintformatId(Integer adPrintformatId) {
    this.adPrintformatId = adPrintformatId;
  }

  public Process adProcessId(Integer adProcessId) {
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

  public Process adReportviewId(Integer adReportviewId) {
    this.adReportviewId = adReportviewId;
    return this;
  }

  /**
   * Vista usada para generar este informe
   * @return adReportviewId
   **/
  @Schema(description = "Vista usada para generar este informe")
  
    public Integer getAdReportviewId() {
    return adReportviewId;
  }

  public void setAdReportviewId(Integer adReportviewId) {
    this.adReportviewId = adReportviewId;
  }

  public Process adWorkflowId(Integer adWorkflowId) {
    this.adWorkflowId = adWorkflowId;
    return this;
  }

  /**
   * Flujo de trabajo o combinación de tareas
   * @return adWorkflowId
   **/
  @Schema(description = "Flujo de trabajo o combinación de tareas")
  
    public Integer getAdWorkflowId() {
    return adWorkflowId;
  }

  public void setAdWorkflowId(Integer adWorkflowId) {
    this.adWorkflowId = adWorkflowId;
  }

  public Process classname(String classname) {
    this.classname = classname;
    return this;
  }

  /**
   * Nombre de la clase Java
   * @return classname
   **/
  @Schema(description = "Nombre de la clase Java")
  
    public String getClassname() {
    return classname;
  }

  public void setClassname(String classname) {
    this.classname = classname;
  }

  public Process concurrentexecution(String concurrentexecution) {
    this.concurrentexecution = concurrentexecution;
    return this;
  }

  /**
   *  
   * @return concurrentexecution
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getConcurrentexecution() {
    return concurrentexecution;
  }

  public void setConcurrentexecution(String concurrentexecution) {
    this.concurrentexecution = concurrentexecution;
  }

  public Process copyparameters(String copyparameters) {
    this.copyparameters = copyparameters;
    return this;
  }

  /**
   * Copiar parámetros de un proceso
   * @return copyparameters
   **/
  @Schema(description = "Copiar parámetros de un proceso")
  
    public String getCopyparameters() {
    return copyparameters;
  }

  public void setCopyparameters(String copyparameters) {
    this.copyparameters = copyparameters;
  }

  public Process created(String created) {
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

  public Process createdby(Integer createdby) {
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

  public Process description(String description) {
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

  public Process dynamicreport(Boolean dynamicreport) {
    this.dynamicreport = dynamicreport;
    return this;
  }

  /**
   *  
   * @return dynamicreport
   **/
  @Schema(description = " ")
  
    public Boolean isDynamicreport() {
    return dynamicreport;
  }

  public void setDynamicreport(Boolean dynamicreport) {
    this.dynamicreport = dynamicreport;
  }

  public Process entitytype(String entitytype) {
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

  public Process help(String help) {
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

  public Process isactive(Boolean isactive) {
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

  public Process isalwaysinclient(Boolean isalwaysinclient) {
    this.isalwaysinclient = isalwaysinclient;
    return this;
  }

  /**
   *  
   * @return isalwaysinclient
   **/
  @Schema(description = " ")
  
    public Boolean isIsalwaysinclient() {
    return isalwaysinclient;
  }

  public void setIsalwaysinclient(Boolean isalwaysinclient) {
    this.isalwaysinclient = isalwaysinclient;
  }

  public Process isbetafunctionality(Boolean isbetafunctionality) {
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

  public Process isdirectprint(Boolean isdirectprint) {
    this.isdirectprint = isdirectprint;
    return this;
  }

  /**
   * Imprimir sin Diálogo
   * @return isdirectprint
   **/
  @Schema(description = "Imprimir sin Diálogo")
  
    public Boolean isIsdirectprint() {
    return isdirectprint;
  }

  public void setIsdirectprint(Boolean isdirectprint) {
    this.isdirectprint = isdirectprint;
  }

  public Process isjasperreport(Boolean isjasperreport) {
    this.isjasperreport = isjasperreport;
    return this;
  }

  /**
   *  
   * @return isjasperreport
   **/
  @Schema(description = " ")
  
    public Boolean isIsjasperreport() {
    return isjasperreport;
  }

  public void setIsjasperreport(Boolean isjasperreport) {
    this.isjasperreport = isjasperreport;
  }

  public Process isreport(Boolean isreport) {
    this.isreport = isreport;
    return this;
  }

  /**
   * Indica un registro del Informe
   * @return isreport
   **/
  @Schema(required = true, description = "Indica un registro del Informe")
      @NotNull

    public Boolean isIsreport() {
    return isreport;
  }

  public void setIsreport(Boolean isreport) {
    this.isreport = isreport;
  }

  public Process jasperreport(String jasperreport) {
    this.jasperreport = jasperreport;
    return this;
  }

  /**
   *  
   * @return jasperreport
   **/
  @Schema(description = " ")
  
    public String getJasperreport() {
    return jasperreport;
  }

  public void setJasperreport(String jasperreport) {
    this.jasperreport = jasperreport;
  }

  public Process name(String name) {
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

  public Process procedurename(String procedurename) {
    this.procedurename = procedurename;
    return this;
  }

  /**
   * Nombre del Procedimiento de la Base de Datos
   * @return procedurename
   **/
  @Schema(description = "Nombre del Procedimiento de la Base de Datos")
  
    public String getProcedurename() {
    return procedurename;
  }

  public void setProcedurename(String procedurename) {
    this.procedurename = procedurename;
  }

  public Process showhelp(Boolean showhelp) {
    this.showhelp = showhelp;
    return this;
  }

  /**
   *  
   * @return showhelp
   **/
  @Schema(description = " ")
  
    public Boolean isShowhelp() {
    return showhelp;
  }

  public void setShowhelp(Boolean showhelp) {
    this.showhelp = showhelp;
  }

  public Process statisticCount(Integer statisticCount) {
    this.statisticCount = statisticCount;
    return this;
  }

  /**
   * Estadística interna de que tan frecuente la entidad es usada
   * @return statisticCount
   **/
  @Schema(description = "Estadística interna de que tan frecuente la entidad es usada")
  
    public Integer getStatisticCount() {
    return statisticCount;
  }

  public void setStatisticCount(Integer statisticCount) {
    this.statisticCount = statisticCount;
  }

  public Process statisticSeconds(Integer statisticSeconds) {
    this.statisticSeconds = statisticSeconds;
    return this;
  }

  /**
   * Estadísticas internas de qué tantos segundos toma un proceso
   * @return statisticSeconds
   **/
  @Schema(description = "Estadísticas internas de qué tantos segundos toma un proceso")
  
    public Integer getStatisticSeconds() {
    return statisticSeconds;
  }

  public void setStatisticSeconds(Integer statisticSeconds) {
    this.statisticSeconds = statisticSeconds;
  }

  public Process updated(String updated) {
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

  public Process updatedby(Integer updatedby) {
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

  public Process value(String value) {
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

  public Process workflowvalue(String workflowvalue) {
    this.workflowvalue = workflowvalue;
    return this;
  }

  /**
   * Clave de Flujo de Trabajo para empezar
   * @return workflowvalue
   **/
  @Schema(description = "Clave de Flujo de Trabajo para empezar")
  
    public String getWorkflowvalue() {
    return workflowvalue;
  }

  public void setWorkflowvalue(String workflowvalue) {
    this.workflowvalue = workflowvalue;
  }

  public Process additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Process addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Process referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Process addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Process process = (Process) o;
    return Objects.equals(this.accesslevel, process.accesslevel) &&
        Objects.equals(this.adClientId, process.adClientId) &&
        Objects.equals(this.adComponentobjectuid, process.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, process.adComponentversionId) &&
        Objects.equals(this.adExpformatId, process.adExpformatId) &&
        Objects.equals(this.adFormId, process.adFormId) &&
        Objects.equals(this.adJasperreportId, process.adJasperreportId) &&
        Objects.equals(this.adOrgId, process.adOrgId) &&
        Objects.equals(this.adPrintformatId, process.adPrintformatId) &&
        Objects.equals(this.adProcessId, process.adProcessId) &&
        Objects.equals(this.adReportviewId, process.adReportviewId) &&
        Objects.equals(this.adWorkflowId, process.adWorkflowId) &&
        Objects.equals(this.classname, process.classname) &&
        Objects.equals(this.concurrentexecution, process.concurrentexecution) &&
        Objects.equals(this.copyparameters, process.copyparameters) &&
        Objects.equals(this.created, process.created) &&
        Objects.equals(this.createdby, process.createdby) &&
        Objects.equals(this.description, process.description) &&
        Objects.equals(this.dynamicreport, process.dynamicreport) &&
        Objects.equals(this.entitytype, process.entitytype) &&
        Objects.equals(this.help, process.help) &&
        Objects.equals(this.isactive, process.isactive) &&
        Objects.equals(this.isalwaysinclient, process.isalwaysinclient) &&
        Objects.equals(this.isbetafunctionality, process.isbetafunctionality) &&
        Objects.equals(this.isdirectprint, process.isdirectprint) &&
        Objects.equals(this.isjasperreport, process.isjasperreport) &&
        Objects.equals(this.isreport, process.isreport) &&
        Objects.equals(this.jasperreport, process.jasperreport) &&
        Objects.equals(this.name, process.name) &&
        Objects.equals(this.procedurename, process.procedurename) &&
        Objects.equals(this.showhelp, process.showhelp) &&
        Objects.equals(this.statisticCount, process.statisticCount) &&
        Objects.equals(this.statisticSeconds, process.statisticSeconds) &&
        Objects.equals(this.updated, process.updated) &&
        Objects.equals(this.updatedby, process.updatedby) &&
        Objects.equals(this.value, process.value) &&
        Objects.equals(this.workflowvalue, process.workflowvalue) &&
        Objects.equals(this.additionalvalues, process.additionalvalues) &&
        Objects.equals(this.referencedvalues, process.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accesslevel, adClientId, adComponentobjectuid, adComponentversionId, adExpformatId, adFormId, adJasperreportId, adOrgId, adPrintformatId, adProcessId, adReportviewId, adWorkflowId, classname, concurrentexecution, copyparameters, created, createdby, description, dynamicreport, entitytype, help, isactive, isalwaysinclient, isbetafunctionality, isdirectprint, isjasperreport, isreport, jasperreport, name, procedurename, showhelp, statisticCount, statisticSeconds, updated, updatedby, value, workflowvalue, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Process {\n");
    
    sb.append("    accesslevel: ").append(toIndentedString(accesslevel)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adExpformatId: ").append(toIndentedString(adExpformatId)).append("\n");
    sb.append("    adFormId: ").append(toIndentedString(adFormId)).append("\n");
    sb.append("    adJasperreportId: ").append(toIndentedString(adJasperreportId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adPrintformatId: ").append(toIndentedString(adPrintformatId)).append("\n");
    sb.append("    adProcessId: ").append(toIndentedString(adProcessId)).append("\n");
    sb.append("    adReportviewId: ").append(toIndentedString(adReportviewId)).append("\n");
    sb.append("    adWorkflowId: ").append(toIndentedString(adWorkflowId)).append("\n");
    sb.append("    classname: ").append(toIndentedString(classname)).append("\n");
    sb.append("    concurrentexecution: ").append(toIndentedString(concurrentexecution)).append("\n");
    sb.append("    copyparameters: ").append(toIndentedString(copyparameters)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dynamicreport: ").append(toIndentedString(dynamicreport)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isalwaysinclient: ").append(toIndentedString(isalwaysinclient)).append("\n");
    sb.append("    isbetafunctionality: ").append(toIndentedString(isbetafunctionality)).append("\n");
    sb.append("    isdirectprint: ").append(toIndentedString(isdirectprint)).append("\n");
    sb.append("    isjasperreport: ").append(toIndentedString(isjasperreport)).append("\n");
    sb.append("    isreport: ").append(toIndentedString(isreport)).append("\n");
    sb.append("    jasperreport: ").append(toIndentedString(jasperreport)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    procedurename: ").append(toIndentedString(procedurename)).append("\n");
    sb.append("    showhelp: ").append(toIndentedString(showhelp)).append("\n");
    sb.append("    statisticCount: ").append(toIndentedString(statisticCount)).append("\n");
    sb.append("    statisticSeconds: ").append(toIndentedString(statisticSeconds)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    workflowvalue: ").append(toIndentedString(workflowvalue)).append("\n");
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
