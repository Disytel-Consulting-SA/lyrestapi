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
 * MessageTrl
 */
@Validated



public class MessageTrl   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_language")
  private String adLanguage = null;

  @JsonProperty("ad_message_id")
  private Integer adMessageId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("istranslated")
  private Boolean istranslated = null;

  @JsonProperty("msgtext")
  private String msgtext = null;

  @JsonProperty("msgtip")
  private String msgtip = null;

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

  public MessageTrl adClientId(Integer adClientId) {
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

  public MessageTrl adComponentobjectuid(String adComponentobjectuid) {
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

  public MessageTrl adComponentversionId(Integer adComponentversionId) {
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

  public MessageTrl adLanguage(String adLanguage) {
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

  public MessageTrl adMessageId(Integer adMessageId) {
    this.adMessageId = adMessageId;
    return this;
  }

  /**
   * Mensaje del Sistema
   * @return adMessageId
   **/
  @Schema(required = true, description = "Mensaje del Sistema")
      @NotNull

    public Integer getAdMessageId() {
    return adMessageId;
  }

  public void setAdMessageId(Integer adMessageId) {
    this.adMessageId = adMessageId;
  }

  public MessageTrl adOrgId(Integer adOrgId) {
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

  public MessageTrl created(String created) {
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

  public MessageTrl createdby(Integer createdby) {
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

  public MessageTrl isactive(Boolean isactive) {
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

  public MessageTrl istranslated(Boolean istranslated) {
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

  public MessageTrl msgtext(String msgtext) {
    this.msgtext = msgtext;
    return this;
  }

  /**
   * Texto Informativo; Menú o Mensaje de Error
   * @return msgtext
   **/
  @Schema(required = true, description = "Texto Informativo; Menú o Mensaje de Error")
      @NotNull

    public String getMsgtext() {
    return msgtext;
  }

  public void setMsgtext(String msgtext) {
    this.msgtext = msgtext;
  }

  public MessageTrl msgtip(String msgtip) {
    this.msgtip = msgtip;
    return this;
  }

  /**
   * Sugerencia Adicional o ayuda para este mensaje
   * @return msgtip
   **/
  @Schema(description = "Sugerencia Adicional o ayuda para este mensaje")
  
    public String getMsgtip() {
    return msgtip;
  }

  public void setMsgtip(String msgtip) {
    this.msgtip = msgtip;
  }

  public MessageTrl updated(String updated) {
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

  public MessageTrl updatedby(Integer updatedby) {
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

  public MessageTrl additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public MessageTrl addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public MessageTrl referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public MessageTrl addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    MessageTrl messageTrl = (MessageTrl) o;
    return Objects.equals(this.adClientId, messageTrl.adClientId) &&
        Objects.equals(this.adComponentobjectuid, messageTrl.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, messageTrl.adComponentversionId) &&
        Objects.equals(this.adLanguage, messageTrl.adLanguage) &&
        Objects.equals(this.adMessageId, messageTrl.adMessageId) &&
        Objects.equals(this.adOrgId, messageTrl.adOrgId) &&
        Objects.equals(this.created, messageTrl.created) &&
        Objects.equals(this.createdby, messageTrl.createdby) &&
        Objects.equals(this.isactive, messageTrl.isactive) &&
        Objects.equals(this.istranslated, messageTrl.istranslated) &&
        Objects.equals(this.msgtext, messageTrl.msgtext) &&
        Objects.equals(this.msgtip, messageTrl.msgtip) &&
        Objects.equals(this.updated, messageTrl.updated) &&
        Objects.equals(this.updatedby, messageTrl.updatedby) &&
        Objects.equals(this.additionalvalues, messageTrl.additionalvalues) &&
        Objects.equals(this.referencedvalues, messageTrl.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adLanguage, adMessageId, adOrgId, created, createdby, isactive, istranslated, msgtext, msgtip, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageTrl {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adLanguage: ").append(toIndentedString(adLanguage)).append("\n");
    sb.append("    adMessageId: ").append(toIndentedString(adMessageId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    istranslated: ").append(toIndentedString(istranslated)).append("\n");
    sb.append("    msgtext: ").append(toIndentedString(msgtext)).append("\n");
    sb.append("    msgtip: ").append(toIndentedString(msgtip)).append("\n");
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
