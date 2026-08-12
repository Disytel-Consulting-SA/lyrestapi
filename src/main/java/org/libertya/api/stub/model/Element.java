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
 * Element
 */
@Validated



public class Element   {
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

  @JsonProperty("columnname")
  private String columnname = null;

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

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("po_description")
  private String poDescription = null;

  @JsonProperty("po_help")
  private String poHelp = null;

  @JsonProperty("po_name")
  private String poName = null;

  @JsonProperty("po_printname")
  private String poPrintname = null;

  @JsonProperty("printname")
  private String printname = null;

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

  public Element adClientId(Integer adClientId) {
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

  public Element adComponentobjectuid(String adComponentobjectuid) {
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

  public Element adComponentversionId(Integer adComponentversionId) {
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

  public Element adElementId(Integer adElementId) {
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

  public Element adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Entidad organizacional dentro de la compañía
   * @return adOrgId
   **/
  @Schema(description = "Entidad organizacional dentro de la compañía")
  
    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public Element columnname(String columnname) {
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

  public Element created(String created) {
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

  public Element createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Usuario que creó este registro
   * @return createdby
   **/
  @Schema(description = "Usuario que creó este registro")
  
    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public Element description(String description) {
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

  public Element entitytype(String entitytype) {
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

  public Element help(String help) {
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

  public Element isactive(Boolean isactive) {
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

  public Element name(String name) {
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

  public Element poDescription(String poDescription) {
    this.poDescription = poDescription;
    return this;
  }

  /**
   * Descripción del Pedido a Cliente
   * @return poDescription
   **/
  @Schema(description = "Descripción del Pedido a Cliente")
  
    public String getPoDescription() {
    return poDescription;
  }

  public void setPoDescription(String poDescription) {
    this.poDescription = poDescription;
  }

  public Element poHelp(String poHelp) {
    this.poHelp = poHelp;
    return this;
  }

  /**
   * Ayuda Transacciones de Compra
   * @return poHelp
   **/
  @Schema(description = "Ayuda Transacciones de Compra")
  
    public String getPoHelp() {
    return poHelp;
  }

  public void setPoHelp(String poHelp) {
    this.poHelp = poHelp;
  }

  public Element poName(String poName) {
    this.poName = poName;
    return this;
  }

  /**
   * Nombre en Transaccion de Ventas
   * @return poName
   **/
  @Schema(description = "Nombre en Transaccion de Ventas")
  
    public String getPoName() {
    return poName;
  }

  public void setPoName(String poName) {
    this.poName = poName;
  }

  public Element poPrintname(String poPrintname) {
    this.poPrintname = poPrintname;
    return this;
  }

  /**
   * Nombre a Imprimir en Transaccion de Ventas
   * @return poPrintname
   **/
  @Schema(description = "Nombre a Imprimir en Transaccion de Ventas")
  
    public String getPoPrintname() {
    return poPrintname;
  }

  public void setPoPrintname(String poPrintname) {
    this.poPrintname = poPrintname;
  }

  public Element printname(String printname) {
    this.printname = printname;
    return this;
  }

  /**
   * Texto a Imprimir
   * @return printname
   **/
  @Schema(required = true, description = "Texto a Imprimir")
      @NotNull

    public String getPrintname() {
    return printname;
  }

  public void setPrintname(String printname) {
    this.printname = printname;
  }

  public Element updated(String updated) {
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

  public Element updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Determina quien actualizó el campo
   * @return updatedby
   **/
  @Schema(description = "Determina quien actualizó el campo")
  
    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

  public Element additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Element addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Element referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Element addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Element element = (Element) o;
    return Objects.equals(this.adClientId, element.adClientId) &&
        Objects.equals(this.adComponentobjectuid, element.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, element.adComponentversionId) &&
        Objects.equals(this.adElementId, element.adElementId) &&
        Objects.equals(this.adOrgId, element.adOrgId) &&
        Objects.equals(this.columnname, element.columnname) &&
        Objects.equals(this.created, element.created) &&
        Objects.equals(this.createdby, element.createdby) &&
        Objects.equals(this.description, element.description) &&
        Objects.equals(this.entitytype, element.entitytype) &&
        Objects.equals(this.help, element.help) &&
        Objects.equals(this.isactive, element.isactive) &&
        Objects.equals(this.name, element.name) &&
        Objects.equals(this.poDescription, element.poDescription) &&
        Objects.equals(this.poHelp, element.poHelp) &&
        Objects.equals(this.poName, element.poName) &&
        Objects.equals(this.poPrintname, element.poPrintname) &&
        Objects.equals(this.printname, element.printname) &&
        Objects.equals(this.updated, element.updated) &&
        Objects.equals(this.updatedby, element.updatedby) &&
        Objects.equals(this.additionalvalues, element.additionalvalues) &&
        Objects.equals(this.referencedvalues, element.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adElementId, adOrgId, columnname, created, createdby, description, entitytype, help, isactive, name, poDescription, poHelp, poName, poPrintname, printname, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Element {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adElementId: ").append(toIndentedString(adElementId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    columnname: ").append(toIndentedString(columnname)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    entitytype: ").append(toIndentedString(entitytype)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    poDescription: ").append(toIndentedString(poDescription)).append("\n");
    sb.append("    poHelp: ").append(toIndentedString(poHelp)).append("\n");
    sb.append("    poName: ").append(toIndentedString(poName)).append("\n");
    sb.append("    poPrintname: ").append(toIndentedString(poPrintname)).append("\n");
    sb.append("    printname: ").append(toIndentedString(printname)).append("\n");
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
