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
 * TabTrl
 */
@Validated



public class TabTrl   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_language")
  private String adLanguage = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_tab_id")
  private Integer adTabId = null;

  @JsonProperty("commitwarning")
  private String commitwarning = null;

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

  public TabTrl adClientId(Integer adClientId) {
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

  public TabTrl adComponentobjectuid(String adComponentobjectuid) {
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

  public TabTrl adComponentversionId(Integer adComponentversionId) {
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

  public TabTrl adLanguage(String adLanguage) {
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

  public TabTrl adOrgId(Integer adOrgId) {
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

  public TabTrl adTabId(Integer adTabId) {
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

  public TabTrl commitwarning(String commitwarning) {
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

  public TabTrl created(String created) {
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

  public TabTrl createdby(Integer createdby) {
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

  public TabTrl description(String description) {
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

  public TabTrl help(String help) {
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

  public TabTrl isactive(Boolean isactive) {
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

  public TabTrl istranslated(Boolean istranslated) {
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

  public TabTrl name(String name) {
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

  public TabTrl updated(String updated) {
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

  public TabTrl updatedby(Integer updatedby) {
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

  public TabTrl additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public TabTrl addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public TabTrl referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public TabTrl addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    TabTrl tabTrl = (TabTrl) o;
    return Objects.equals(this.adClientId, tabTrl.adClientId) &&
        Objects.equals(this.adComponentobjectuid, tabTrl.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, tabTrl.adComponentversionId) &&
        Objects.equals(this.adLanguage, tabTrl.adLanguage) &&
        Objects.equals(this.adOrgId, tabTrl.adOrgId) &&
        Objects.equals(this.adTabId, tabTrl.adTabId) &&
        Objects.equals(this.commitwarning, tabTrl.commitwarning) &&
        Objects.equals(this.created, tabTrl.created) &&
        Objects.equals(this.createdby, tabTrl.createdby) &&
        Objects.equals(this.description, tabTrl.description) &&
        Objects.equals(this.help, tabTrl.help) &&
        Objects.equals(this.isactive, tabTrl.isactive) &&
        Objects.equals(this.istranslated, tabTrl.istranslated) &&
        Objects.equals(this.name, tabTrl.name) &&
        Objects.equals(this.updated, tabTrl.updated) &&
        Objects.equals(this.updatedby, tabTrl.updatedby) &&
        Objects.equals(this.additionalvalues, tabTrl.additionalvalues) &&
        Objects.equals(this.referencedvalues, tabTrl.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adLanguage, adOrgId, adTabId, commitwarning, created, createdby, description, help, isactive, istranslated, name, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TabTrl {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adLanguage: ").append(toIndentedString(adLanguage)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adTabId: ").append(toIndentedString(adTabId)).append("\n");
    sb.append("    commitwarning: ").append(toIndentedString(commitwarning)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    istranslated: ").append(toIndentedString(istranslated)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
