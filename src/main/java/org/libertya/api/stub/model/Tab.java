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
 * Tab
 */
@Validated



public class Tab   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_column_id")
  private Integer adColumnId = null;

  @JsonProperty("ad_columnsortorder_id")
  private Integer adColumnsortorderId = null;

  @JsonProperty("ad_columnsortyesno_id")
  private Integer adColumnsortyesnoId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_image_id")
  private Integer adImageId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_process_id")
  private Integer adProcessId = null;

  @JsonProperty("ad_tab_id")
  private Integer adTabId = null;

  @JsonProperty("ad_table_id")
  private Integer adTableId = null;

  @JsonProperty("ad_window_id")
  private Integer adWindowId = null;

  @JsonProperty("allowcopyrecord")
  private Boolean allowcopyrecord = null;

  @JsonProperty("commitwarning")
  private String commitwarning = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("displaylogic")
  private String displaylogic = null;

  @JsonProperty("entitytype")
  private String entitytype = null;

  @JsonProperty("hastree")
  private Boolean hastree = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("importfields")
  private String importfields = null;

  @JsonProperty("included_tab_id")
  private Integer includedTabId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isadvancedtab")
  private Boolean isadvancedtab = null;

  @JsonProperty("isalwaysupdateable")
  private Boolean isalwaysupdateable = null;

  @JsonProperty("isinfotab")
  private Boolean isinfotab = null;

  @JsonProperty("isinsertrecord")
  private Boolean isinsertrecord = null;

  @JsonProperty("isprocessmsgshowdialog")
  private Boolean isprocessmsgshowdialog = null;

  @JsonProperty("isreadonly")
  private Boolean isreadonly = null;

  @JsonProperty("issinglerow")
  private Boolean issinglerow = null;

  @JsonProperty("issorttab")
  private Boolean issorttab = null;

  @JsonProperty("istranslationtab")
  private Boolean istranslationtab = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("orderbyclause")
  private String orderbyclause = null;

  @JsonProperty("processing")
  private String processing = null;

  @JsonProperty("readonlylogic")
  private String readonlylogic = null;

  @JsonProperty("seqno")
  private Integer seqno = null;

  @JsonProperty("tablevel")
  private Integer tablevel = null;

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

  public Tab adClientId(Integer adClientId) {
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

  public Tab adColumnId(Integer adColumnId) {
    this.adColumnId = adColumnId;
    return this;
  }

  /**
   * Columna en la tabla
   * @return adColumnId
   **/
  @Schema(description = "Columna en la tabla")
  
    public Integer getAdColumnId() {
    return adColumnId;
  }

  public void setAdColumnId(Integer adColumnId) {
    this.adColumnId = adColumnId;
  }

  public Tab adColumnsortorderId(Integer adColumnsortorderId) {
    this.adColumnsortorderId = adColumnsortorderId;
    return this;
  }

  /**
   * Columna que determina el orden
   * @return adColumnsortorderId
   **/
  @Schema(description = "Columna que determina el orden")
  
    public Integer getAdColumnsortorderId() {
    return adColumnsortorderId;
  }

  public void setAdColumnsortorderId(Integer adColumnsortorderId) {
    this.adColumnsortorderId = adColumnsortorderId;
  }

  public Tab adColumnsortyesnoId(Integer adColumnsortyesnoId) {
    this.adColumnsortyesnoId = adColumnsortyesnoId;
    return this;
  }

  /**
   * Columna que determina si una columna de Tabla esta incluida en el ordenamiento
   * @return adColumnsortyesnoId
   **/
  @Schema(description = "Columna que determina si una columna de Tabla esta incluida en el ordenamiento")
  
    public Integer getAdColumnsortyesnoId() {
    return adColumnsortyesnoId;
  }

  public void setAdColumnsortyesnoId(Integer adColumnsortyesnoId) {
    this.adColumnsortyesnoId = adColumnsortyesnoId;
  }

  public Tab adComponentobjectuid(String adComponentobjectuid) {
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

  public Tab adComponentversionId(Integer adComponentversionId) {
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

  public Tab adImageId(Integer adImageId) {
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

  public Tab adOrgId(Integer adOrgId) {
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

  public Tab adProcessId(Integer adProcessId) {
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

  public Tab adTabId(Integer adTabId) {
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

  public Tab adTableId(Integer adTableId) {
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

  public Tab adWindowId(Integer adWindowId) {
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

  public Tab allowcopyrecord(Boolean allowcopyrecord) {
    this.allowcopyrecord = allowcopyrecord;
    return this;
  }

  /**
   * Permitir copia de registros
   * @return allowcopyrecord
   **/
  @Schema(required = true, description = "Permitir copia de registros")
      @NotNull

    public Boolean isAllowcopyrecord() {
    return allowcopyrecord;
  }

  public void setAllowcopyrecord(Boolean allowcopyrecord) {
    this.allowcopyrecord = allowcopyrecord;
  }

  public Tab commitwarning(String commitwarning) {
    this.commitwarning = commitwarning;
    return this;
  }

  /**
   * Advertencia para Guardar
   * @return commitwarning
   **/
  @Schema(description = "Advertencia para Guardar")
  
    public String getCommitwarning() {
    return commitwarning;
  }

  public void setCommitwarning(String commitwarning) {
    this.commitwarning = commitwarning;
  }

  public Tab created(String created) {
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

  public Tab createdby(Integer createdby) {
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

  public Tab description(String description) {
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

  public Tab displaylogic(String displaylogic) {
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

  public Tab entitytype(String entitytype) {
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

  public Tab hastree(Boolean hastree) {
    this.hastree = hastree;
    return this;
  }

  /**
   * La ventana tiene gráfica de árbol
   * @return hastree
   **/
  @Schema(required = true, description = "La ventana tiene gráfica de árbol")
      @NotNull

    public Boolean isHastree() {
    return hastree;
  }

  public void setHastree(Boolean hastree) {
    this.hastree = hastree;
  }

  public Tab help(String help) {
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

  public Tab importfields(String importfields) {
    this.importfields = importfields;
    return this;
  }

  /**
   * Crea campos desde columnas de tabla
   * @return importfields
   **/
  @Schema(description = "Crea campos desde columnas de tabla")
  
    public String getImportfields() {
    return importfields;
  }

  public void setImportfields(String importfields) {
    this.importfields = importfields;
  }

  public Tab includedTabId(Integer includedTabId) {
    this.includedTabId = includedTabId;
    return this;
  }

  /**
   * Pestaña Incluida en esta pestaña
   * @return includedTabId
   **/
  @Schema(description = "Pestaña Incluida en esta pestaña")
  
    public Integer getIncludedTabId() {
    return includedTabId;
  }

  public void setIncludedTabId(Integer includedTabId) {
    this.includedTabId = includedTabId;
  }

  public Tab isactive(Boolean isactive) {
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

  public Tab isadvancedtab(Boolean isadvancedtab) {
    this.isadvancedtab = isadvancedtab;
    return this;
  }

  /**
   * Pestaña con Funcionalidad Avanzada
   * @return isadvancedtab
   **/
  @Schema(required = true, description = "Pestaña con Funcionalidad Avanzada")
      @NotNull

    public Boolean isIsadvancedtab() {
    return isadvancedtab;
  }

  public void setIsadvancedtab(Boolean isadvancedtab) {
    this.isadvancedtab = isadvancedtab;
  }

  public Tab isalwaysupdateable(Boolean isalwaysupdateable) {
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

  public Tab isinfotab(Boolean isinfotab) {
    this.isinfotab = isinfotab;
    return this;
  }

  /**
   * Esta pestaña contiene información contable
   * @return isinfotab
   **/
  @Schema(description = "Esta pestaña contiene información contable")
  
    public Boolean isIsinfotab() {
    return isinfotab;
  }

  public void setIsinfotab(Boolean isinfotab) {
    this.isinfotab = isinfotab;
  }

  public Tab isinsertrecord(Boolean isinsertrecord) {
    this.isinsertrecord = isinsertrecord;
    return this;
  }

  /**
   * Insertar Registro
   * @return isinsertrecord
   **/
  @Schema(required = true, description = "Insertar Registro")
      @NotNull

    public Boolean isIsinsertrecord() {
    return isinsertrecord;
  }

  public void setIsinsertrecord(Boolean isinsertrecord) {
    this.isinsertrecord = isinsertrecord;
  }

  public Tab isprocessmsgshowdialog(Boolean isprocessmsgshowdialog) {
    this.isprocessmsgshowdialog = isprocessmsgshowdialog;
    return this;
  }

  /**
   * Muestra los mensajes de procesos ejecutados en ventanas.
   * @return isprocessmsgshowdialog
   **/
  @Schema(required = true, description = "Muestra los mensajes de procesos ejecutados en ventanas.")
      @NotNull

    public Boolean isIsprocessmsgshowdialog() {
    return isprocessmsgshowdialog;
  }

  public void setIsprocessmsgshowdialog(Boolean isprocessmsgshowdialog) {
    this.isprocessmsgshowdialog = isprocessmsgshowdialog;
  }

  public Tab isreadonly(Boolean isreadonly) {
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

  public Tab issinglerow(Boolean issinglerow) {
    this.issinglerow = issinglerow;
    return this;
  }

  /**
   * Desplegado por Defecto
   * @return issinglerow
   **/
  @Schema(required = true, description = "Desplegado por Defecto")
      @NotNull

    public Boolean isIssinglerow() {
    return issinglerow;
  }

  public void setIssinglerow(Boolean issinglerow) {
    this.issinglerow = issinglerow;
  }

  public Tab issorttab(Boolean issorttab) {
    this.issorttab = issorttab;
    return this;
  }

  /**
   * La pestaña determina el orden
   * @return issorttab
   **/
  @Schema(required = true, description = "La pestaña determina el orden")
      @NotNull

    public Boolean isIssorttab() {
    return issorttab;
  }

  public void setIssorttab(Boolean issorttab) {
    this.issorttab = issorttab;
  }

  public Tab istranslationtab(Boolean istranslationtab) {
    this.istranslationtab = istranslationtab;
    return this;
  }

  /**
   * Esta pestaña contiene información de traducción
   * @return istranslationtab
   **/
  @Schema(required = true, description = "Esta pestaña contiene información de traducción")
      @NotNull

    public Boolean isIstranslationtab() {
    return istranslationtab;
  }

  public void setIstranslationtab(Boolean istranslationtab) {
    this.istranslationtab = istranslationtab;
  }

  public Tab name(String name) {
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

  public Tab orderbyclause(String orderbyclause) {
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

  public Tab processing(String processing) {
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

  public Tab readonlylogic(String readonlylogic) {
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

  public Tab seqno(Integer seqno) {
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

  public Tab tablevel(Integer tablevel) {
    this.tablevel = tablevel;
    return this;
  }

  /**
   * Nivel de pestaña jerárquico
   * @return tablevel
   **/
  @Schema(required = true, description = "Nivel de pestaña jerárquico")
      @NotNull

    public Integer getTablevel() {
    return tablevel;
  }

  public void setTablevel(Integer tablevel) {
    this.tablevel = tablevel;
  }

  public Tab updated(String updated) {
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

  public Tab updatedby(Integer updatedby) {
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

  public Tab whereclause(String whereclause) {
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

  public Tab additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Tab addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Tab referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Tab addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Tab tab = (Tab) o;
    return Objects.equals(this.adClientId, tab.adClientId) &&
        Objects.equals(this.adColumnId, tab.adColumnId) &&
        Objects.equals(this.adColumnsortorderId, tab.adColumnsortorderId) &&
        Objects.equals(this.adColumnsortyesnoId, tab.adColumnsortyesnoId) &&
        Objects.equals(this.adComponentobjectuid, tab.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, tab.adComponentversionId) &&
        Objects.equals(this.adImageId, tab.adImageId) &&
        Objects.equals(this.adOrgId, tab.adOrgId) &&
        Objects.equals(this.adProcessId, tab.adProcessId) &&
        Objects.equals(this.adTabId, tab.adTabId) &&
        Objects.equals(this.adTableId, tab.adTableId) &&
        Objects.equals(this.adWindowId, tab.adWindowId) &&
        Objects.equals(this.allowcopyrecord, tab.allowcopyrecord) &&
        Objects.equals(this.commitwarning, tab.commitwarning) &&
        Objects.equals(this.created, tab.created) &&
        Objects.equals(this.createdby, tab.createdby) &&
        Objects.equals(this.description, tab.description) &&
        Objects.equals(this.displaylogic, tab.displaylogic) &&
        Objects.equals(this.entitytype, tab.entitytype) &&
        Objects.equals(this.hastree, tab.hastree) &&
        Objects.equals(this.help, tab.help) &&
        Objects.equals(this.importfields, tab.importfields) &&
        Objects.equals(this.includedTabId, tab.includedTabId) &&
        Objects.equals(this.isactive, tab.isactive) &&
        Objects.equals(this.isadvancedtab, tab.isadvancedtab) &&
        Objects.equals(this.isalwaysupdateable, tab.isalwaysupdateable) &&
        Objects.equals(this.isinfotab, tab.isinfotab) &&
        Objects.equals(this.isinsertrecord, tab.isinsertrecord) &&
        Objects.equals(this.isprocessmsgshowdialog, tab.isprocessmsgshowdialog) &&
        Objects.equals(this.isreadonly, tab.isreadonly) &&
        Objects.equals(this.issinglerow, tab.issinglerow) &&
        Objects.equals(this.issorttab, tab.issorttab) &&
        Objects.equals(this.istranslationtab, tab.istranslationtab) &&
        Objects.equals(this.name, tab.name) &&
        Objects.equals(this.orderbyclause, tab.orderbyclause) &&
        Objects.equals(this.processing, tab.processing) &&
        Objects.equals(this.readonlylogic, tab.readonlylogic) &&
        Objects.equals(this.seqno, tab.seqno) &&
        Objects.equals(this.tablevel, tab.tablevel) &&
        Objects.equals(this.updated, tab.updated) &&
        Objects.equals(this.updatedby, tab.updatedby) &&
        Objects.equals(this.whereclause, tab.whereclause) &&
        Objects.equals(this.additionalvalues, tab.additionalvalues) &&
        Objects.equals(this.referencedvalues, tab.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adColumnId, adColumnsortorderId, adColumnsortyesnoId, adComponentobjectuid, adComponentversionId, adImageId, adOrgId, adProcessId, adTabId, adTableId, adWindowId, allowcopyrecord, commitwarning, created, createdby, description, displaylogic, entitytype, hastree, help, importfields, includedTabId, isactive, isadvancedtab, isalwaysupdateable, isinfotab, isinsertrecord, isprocessmsgshowdialog, isreadonly, issinglerow, issorttab, istranslationtab, name, orderbyclause, processing, readonlylogic, seqno, tablevel, updated, updatedby, whereclause, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tab {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adColumnId: ").append(toIndentedString(adColumnId)).append("\n");
    sb.append("    adColumnsortorderId: ").append(toIndentedString(adColumnsortorderId)).append("\n");
    sb.append("    adColumnsortyesnoId: ").append(toIndentedString(adColumnsortyesnoId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adImageId: ").append(toIndentedString(adImageId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adProcessId: ").append(toIndentedString(adProcessId)).append("\n");
    sb.append("    adTabId: ").append(toIndentedString(adTabId)).append("\n");
    sb.append("    adTableId: ").append(toIndentedString(adTableId)).append("\n");
    sb.append("    adWindowId: ").append(toIndentedString(adWindowId)).append("\n");
    sb.append("    allowcopyrecord: ").append(toIndentedString(allowcopyrecord)).append("\n");
    sb.append("    commitwarning: ").append(toIndentedString(commitwarning)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displaylogic: ").append(toIndentedString(displaylogic)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    hastree: ").append(toIndentedString(hastree)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    importfields: ").append(toIndentedString(importfields)).append("\n");
    sb.append("    includedTabId: ").append(toIndentedString(includedTabId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isadvancedtab: ").append(toIndentedString(isadvancedtab)).append("\n");
    sb.append("    isalwaysupdateable: ").append(toIndentedString(isalwaysupdateable)).append("\n");
    sb.append("    isinfotab: ").append(toIndentedString(isinfotab)).append("\n");
    sb.append("    isinsertrecord: ").append(toIndentedString(isinsertrecord)).append("\n");
    sb.append("    isprocessmsgshowdialog: ").append(toIndentedString(isprocessmsgshowdialog)).append("\n");
    sb.append("    isreadonly: ").append(toIndentedString(isreadonly)).append("\n");
    sb.append("    issinglerow: ").append(toIndentedString(issinglerow)).append("\n");
    sb.append("    issorttab: ").append(toIndentedString(issorttab)).append("\n");
    sb.append("    istranslationtab: ").append(toIndentedString(istranslationtab)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orderbyclause: ").append(toIndentedString(orderbyclause)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    readonlylogic: ").append(toIndentedString(readonlylogic)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
    sb.append("    tablevel: ").append(toIndentedString(tablevel)).append("\n");
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
