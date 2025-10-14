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
 * POSLetter
 */
@Validated



public class POSLetter   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_pos_id")
  private Integer cPosId = null;

  @JsonProperty("c_posletter_id")
  private Integer cPosletterId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("letter")
  private String letter = null;

  @JsonProperty("posnumber")
  private Integer posnumber = null;

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

  public POSLetter adClientId(Integer adClientId) {
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

  public POSLetter adOrgId(Integer adOrgId) {
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

  public POSLetter cPosId(Integer cPosId) {
    this.cPosId = cPosId;
    return this;
  }

  /**
   * Terminal TPV
   * @return cPosId
   **/
  @Schema(required = true, description = "Terminal TPV")
      @NotNull

    public Integer getCPosId() {
    return cPosId;
  }

  public void setCPosId(Integer cPosId) {
    this.cPosId = cPosId;
  }

  public POSLetter cPosletterId(Integer cPosletterId) {
    this.cPosletterId = cPosletterId;
    return this;
  }

  /**
   *  
   * @return cPosletterId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCPosletterId() {
    return cPosletterId;
  }

  public void setCPosletterId(Integer cPosletterId) {
    this.cPosletterId = cPosletterId;
  }

  public POSLetter created(String created) {
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

  public POSLetter createdby(Integer createdby) {
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

  public POSLetter isactive(Boolean isactive) {
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

  public POSLetter letter(String letter) {
    this.letter = letter;
    return this;
  }

  /**
   * Letra del Comprobante
   * @return letter
   **/
  @Schema(required = true, description = "Letra del Comprobante")
      @NotNull

    public String getLetter() {
    return letter;
  }

  public void setLetter(String letter) {
    this.letter = letter;
  }

  public POSLetter posnumber(Integer posnumber) {
    this.posnumber = posnumber;
    return this;
  }

  /**
   * Número del punto de venta para el cual se generan las facturas
   * @return posnumber
   **/
  @Schema(required = true, description = "Número del punto de venta para el cual se generan las facturas")
      @NotNull

    public Integer getPosnumber() {
    return posnumber;
  }

  public void setPosnumber(Integer posnumber) {
    this.posnumber = posnumber;
  }

  public POSLetter updated(String updated) {
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

  public POSLetter updatedby(Integer updatedby) {
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

  public POSLetter additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public POSLetter addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public POSLetter referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public POSLetter addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    POSLetter poSLetter = (POSLetter) o;
    return Objects.equals(this.adClientId, poSLetter.adClientId) &&
        Objects.equals(this.adOrgId, poSLetter.adOrgId) &&
        Objects.equals(this.cPosId, poSLetter.cPosId) &&
        Objects.equals(this.cPosletterId, poSLetter.cPosletterId) &&
        Objects.equals(this.created, poSLetter.created) &&
        Objects.equals(this.createdby, poSLetter.createdby) &&
        Objects.equals(this.isactive, poSLetter.isactive) &&
        Objects.equals(this.letter, poSLetter.letter) &&
        Objects.equals(this.posnumber, poSLetter.posnumber) &&
        Objects.equals(this.updated, poSLetter.updated) &&
        Objects.equals(this.updatedby, poSLetter.updatedby) &&
        Objects.equals(this.additionalvalues, poSLetter.additionalvalues) &&
        Objects.equals(this.referencedvalues, poSLetter.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cPosId, cPosletterId, created, createdby, isactive, letter, posnumber, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSLetter {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cPosId: ").append(toIndentedString(cPosId)).append("\n");
    sb.append("    cPosletterId: ").append(toIndentedString(cPosletterId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    letter: ").append(toIndentedString(letter)).append("\n");
    sb.append("    posnumber: ").append(toIndentedString(posnumber)).append("\n");
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
