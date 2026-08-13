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
 * ElementTrl
 */
@Validated



public class ElementTrl   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_element_id")
  private Integer adElementId = null;

  @JsonProperty("ad_language")
  private String adLanguage = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("istranslated")
  private Boolean istranslated = null;

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

  public ElementTrl adClientId(Integer adClientId) {
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

  public ElementTrl adComponentobjectuid(String adComponentobjectuid) {
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

  public ElementTrl adComponentversionId(Integer adComponentversionId) {
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

  public ElementTrl adElementId(Integer adElementId) {
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

  public ElementTrl adLanguage(String adLanguage) {
    this.adLanguage = adLanguage;
    return this;
  }

  /**
   * Lenguaje para esta aplicación
   * @return adLanguage
   **/
  @Schema(required = true, description = "Lenguaje para esta aplicación")
      @NotNull

    public String getAdLanguage() {
    return adLanguage;
  }

  public void setAdLanguage(String adLanguage) {
    this.adLanguage = adLanguage;
  }

  public ElementTrl adOrgId(Integer adOrgId) {
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

  public ElementTrl created(String created) {
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

  public ElementTrl createdby(Integer createdby) {
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

  public ElementTrl description(String description) {
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

  public ElementTrl help(String help) {
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

  public ElementTrl isactive(Boolean isactive) {
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

  public ElementTrl istranslated(Boolean istranslated) {
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

  public ElementTrl name(String name) {
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

  public ElementTrl poDescription(String poDescription) {
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

  public ElementTrl poHelp(String poHelp) {
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

  public ElementTrl poName(String poName) {
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

  public ElementTrl poPrintname(String poPrintname) {
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

  public ElementTrl printname(String printname) {
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

  public ElementTrl updated(String updated) {
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

  public ElementTrl updatedby(Integer updatedby) {
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

  public ElementTrl additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ElementTrl addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ElementTrl referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ElementTrl addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ElementTrl elementTrl = (ElementTrl) o;
    return Objects.equals(this.adClientId, elementTrl.adClientId) &&
        Objects.equals(this.adComponentobjectuid, elementTrl.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, elementTrl.adComponentversionId) &&
        Objects.equals(this.adElementId, elementTrl.adElementId) &&
        Objects.equals(this.adLanguage, elementTrl.adLanguage) &&
        Objects.equals(this.adOrgId, elementTrl.adOrgId) &&
        Objects.equals(this.created, elementTrl.created) &&
        Objects.equals(this.createdby, elementTrl.createdby) &&
        Objects.equals(this.description, elementTrl.description) &&
        Objects.equals(this.help, elementTrl.help) &&
        Objects.equals(this.isactive, elementTrl.isactive) &&
        Objects.equals(this.istranslated, elementTrl.istranslated) &&
        Objects.equals(this.name, elementTrl.name) &&
        Objects.equals(this.poDescription, elementTrl.poDescription) &&
        Objects.equals(this.poHelp, elementTrl.poHelp) &&
        Objects.equals(this.poName, elementTrl.poName) &&
        Objects.equals(this.poPrintname, elementTrl.poPrintname) &&
        Objects.equals(this.printname, elementTrl.printname) &&
        Objects.equals(this.updated, elementTrl.updated) &&
        Objects.equals(this.updatedby, elementTrl.updatedby) &&
        Objects.equals(this.additionalvalues, elementTrl.additionalvalues) &&
        Objects.equals(this.referencedvalues, elementTrl.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adElementId, adLanguage, adOrgId, created, createdby, description, help, isactive, istranslated, name, poDescription, poHelp, poName, poPrintname, printname, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementTrl {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adElementId: ").append(toIndentedString(adElementId)).append("\n");
    sb.append("    adLanguage: ").append(toIndentedString(adLanguage)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    istranslated: ").append(toIndentedString(istranslated)).append("\n");
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
