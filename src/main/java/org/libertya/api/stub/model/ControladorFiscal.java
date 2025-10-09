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
 * ControladorFiscal
 */
@Validated



public class ControladorFiscal   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("askwhenerror")
  private Boolean askwhenerror = null;

  @JsonProperty("c_controlador_fiscal_id")
  private Integer cControladorFiscalId = null;

  @JsonProperty("c_controlador_fiscal_type_id")
  private Integer cControladorFiscalTypeId = null;

  @JsonProperty("cmdcancelbeforeprintdocument")
  private Boolean cmdcancelbeforeprintdocument = null;

  @JsonProperty("connectiontype")
  private String connectiontype = null;

  @JsonProperty("controladorfiscaltype")
  private String controladorfiscaltype = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("host")
  private String host = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isremote")
  private Boolean isremote = null;

  @JsonProperty("logtyperecorded")
  private String logtyperecorded = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("onlylinedescription")
  private Boolean onlylinedescription = null;

  @JsonProperty("onprintproductformat")
  private String onprintproductformat = null;

  @JsonProperty("onprintuseproductreference")
  private Boolean onprintuseproductreference = null;

  @JsonProperty("operation_date")
  private String operationDate = null;

  @JsonProperty("port")
  private Integer port = null;

  @JsonProperty("printername")
  private String printername = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("usedby_id")
  private Integer usedbyId = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public ControladorFiscal adClientId(Integer adClientId) {
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

  public ControladorFiscal adComponentobjectuid(String adComponentobjectuid) {
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

  public ControladorFiscal adOrgId(Integer adOrgId) {
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

  public ControladorFiscal askwhenerror(Boolean askwhenerror) {
    this.askwhenerror = askwhenerror;
    return this;
  }

  /**
   * Requerir confirmación por parte del usuario en caso de error de impresión del documento
   * @return askwhenerror
   **/
  @Schema(required = true, description = "Requerir confirmación por parte del usuario en caso de error de impresión del documento")
      @NotNull

    public Boolean isAskwhenerror() {
    return askwhenerror;
  }

  public void setAskwhenerror(Boolean askwhenerror) {
    this.askwhenerror = askwhenerror;
  }

  public ControladorFiscal cControladorFiscalId(Integer cControladorFiscalId) {
    this.cControladorFiscalId = cControladorFiscalId;
    return this;
  }

  /**
   *  
   * @return cControladorFiscalId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCControladorFiscalId() {
    return cControladorFiscalId;
  }

  public void setCControladorFiscalId(Integer cControladorFiscalId) {
    this.cControladorFiscalId = cControladorFiscalId;
  }

  public ControladorFiscal cControladorFiscalTypeId(Integer cControladorFiscalTypeId) {
    this.cControladorFiscalTypeId = cControladorFiscalTypeId;
    return this;
  }

  /**
   *  
   * @return cControladorFiscalTypeId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCControladorFiscalTypeId() {
    return cControladorFiscalTypeId;
  }

  public void setCControladorFiscalTypeId(Integer cControladorFiscalTypeId) {
    this.cControladorFiscalTypeId = cControladorFiscalTypeId;
  }

  public ControladorFiscal cmdcancelbeforeprintdocument(Boolean cmdcancelbeforeprintdocument) {
    this.cmdcancelbeforeprintdocument = cmdcancelbeforeprintdocument;
    return this;
  }

  /**
   * Enviar el comando de cancelación antes de imprimir un documento
   * @return cmdcancelbeforeprintdocument
   **/
  @Schema(required = true, description = "Enviar el comando de cancelación antes de imprimir un documento")
      @NotNull

    public Boolean isCmdcancelbeforeprintdocument() {
    return cmdcancelbeforeprintdocument;
  }

  public void setCmdcancelbeforeprintdocument(Boolean cmdcancelbeforeprintdocument) {
    this.cmdcancelbeforeprintdocument = cmdcancelbeforeprintdocument;
  }

  public ControladorFiscal connectiontype(String connectiontype) {
    this.connectiontype = connectiontype;
    return this;
  }

  /**
   *  
   * @return connectiontype
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getConnectiontype() {
    return connectiontype;
  }

  public void setConnectiontype(String connectiontype) {
    this.connectiontype = connectiontype;
  }

  public ControladorFiscal controladorfiscaltype(String controladorfiscaltype) {
    this.controladorfiscaltype = controladorfiscaltype;
    return this;
  }

  /**
   *  
   * @return controladorfiscaltype
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getControladorfiscaltype() {
    return controladorfiscaltype;
  }

  public void setControladorfiscaltype(String controladorfiscaltype) {
    this.controladorfiscaltype = controladorfiscaltype;
  }

  public ControladorFiscal created(String created) {
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

  public ControladorFiscal createdby(Integer createdby) {
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

  public ControladorFiscal description(String description) {
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

  public ControladorFiscal host(String host) {
    this.host = host;
    return this;
  }

  /**
   *  
   * @return host
   **/
  @Schema(description = " ")
  
    public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public ControladorFiscal isactive(Boolean isactive) {
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

  public ControladorFiscal isremote(Boolean isremote) {
    this.isremote = isremote;
    return this;
  }

  /**
   * Impresión fiscal remota
   * @return isremote
   **/
  @Schema(required = true, description = "Impresión fiscal remota")
      @NotNull

    public Boolean isIsremote() {
    return isremote;
  }

  public void setIsremote(Boolean isremote) {
    this.isremote = isremote;
  }

  public ControladorFiscal logtyperecorded(String logtyperecorded) {
    this.logtyperecorded = logtyperecorded;
    return this;
  }

  /**
   * Tipo de log de comandos a registrar
   * @return logtyperecorded
   **/
  @Schema(description = "Tipo de log de comandos a registrar")
  
    public String getLogtyperecorded() {
    return logtyperecorded;
  }

  public void setLogtyperecorded(String logtyperecorded) {
    this.logtyperecorded = logtyperecorded;
  }

  public ControladorFiscal name(String name) {
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

  public ControladorFiscal onlylinedescription(Boolean onlylinedescription) {
    this.onlylinedescription = onlylinedescription;
    return this;
  }

  /**
   *  
   * @return onlylinedescription
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isOnlylinedescription() {
    return onlylinedescription;
  }

  public void setOnlylinedescription(Boolean onlylinedescription) {
    this.onlylinedescription = onlylinedescription;
  }

  public ControladorFiscal onprintproductformat(String onprintproductformat) {
    this.onprintproductformat = onprintproductformat;
    return this;
  }

  /**
   *  
   * @return onprintproductformat
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getOnprintproductformat() {
    return onprintproductformat;
  }

  public void setOnprintproductformat(String onprintproductformat) {
    this.onprintproductformat = onprintproductformat;
  }

  public ControladorFiscal onprintuseproductreference(Boolean onprintuseproductreference) {
    this.onprintuseproductreference = onprintuseproductreference;
    return this;
  }

  /**
   *  
   * @return onprintuseproductreference
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isOnprintuseproductreference() {
    return onprintuseproductreference;
  }

  public void setOnprintuseproductreference(Boolean onprintuseproductreference) {
    this.onprintuseproductreference = onprintuseproductreference;
  }

  public ControladorFiscal operationDate(String operationDate) {
    this.operationDate = operationDate;
    return this;
  }

  /**
   *  
   * @return operationDate
   **/
  @Schema(description = " ")
  
    public String getOperationDate() {
    return operationDate;
  }

  public void setOperationDate(String operationDate) {
    this.operationDate = operationDate;
  }

  public ControladorFiscal port(Integer port) {
    this.port = port;
    return this;
  }

  /**
   *  
   * @return port
   **/
  @Schema(description = " ")
  
    public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public ControladorFiscal printername(String printername) {
    this.printername = printername;
    return this;
  }

  /**
   * Nombre de Impresora
   * @return printername
   **/
  @Schema(description = "Nombre de Impresora")
  
    public String getPrintername() {
    return printername;
  }

  public void setPrintername(String printername) {
    this.printername = printername;
  }

  public ControladorFiscal status(String status) {
    this.status = status;
    return this;
  }

  /**
   *  
   * @return status
   **/
  @Schema(description = " ")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ControladorFiscal updated(String updated) {
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

  public ControladorFiscal updatedby(Integer updatedby) {
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

  public ControladorFiscal usedbyId(Integer usedbyId) {
    this.usedbyId = usedbyId;
    return this;
  }

  /**
   *  
   * @return usedbyId
   **/
  @Schema(description = " ")
  
    public Integer getUsedbyId() {
    return usedbyId;
  }

  public void setUsedbyId(Integer usedbyId) {
    this.usedbyId = usedbyId;
  }

  public ControladorFiscal additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ControladorFiscal addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ControladorFiscal referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ControladorFiscal addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ControladorFiscal controladorFiscal = (ControladorFiscal) o;
    return Objects.equals(this.adClientId, controladorFiscal.adClientId) &&
        Objects.equals(this.adComponentobjectuid, controladorFiscal.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, controladorFiscal.adOrgId) &&
        Objects.equals(this.askwhenerror, controladorFiscal.askwhenerror) &&
        Objects.equals(this.cControladorFiscalId, controladorFiscal.cControladorFiscalId) &&
        Objects.equals(this.cControladorFiscalTypeId, controladorFiscal.cControladorFiscalTypeId) &&
        Objects.equals(this.cmdcancelbeforeprintdocument, controladorFiscal.cmdcancelbeforeprintdocument) &&
        Objects.equals(this.connectiontype, controladorFiscal.connectiontype) &&
        Objects.equals(this.controladorfiscaltype, controladorFiscal.controladorfiscaltype) &&
        Objects.equals(this.created, controladorFiscal.created) &&
        Objects.equals(this.createdby, controladorFiscal.createdby) &&
        Objects.equals(this.description, controladorFiscal.description) &&
        Objects.equals(this.host, controladorFiscal.host) &&
        Objects.equals(this.isactive, controladorFiscal.isactive) &&
        Objects.equals(this.isremote, controladorFiscal.isremote) &&
        Objects.equals(this.logtyperecorded, controladorFiscal.logtyperecorded) &&
        Objects.equals(this.name, controladorFiscal.name) &&
        Objects.equals(this.onlylinedescription, controladorFiscal.onlylinedescription) &&
        Objects.equals(this.onprintproductformat, controladorFiscal.onprintproductformat) &&
        Objects.equals(this.onprintuseproductreference, controladorFiscal.onprintuseproductreference) &&
        Objects.equals(this.operationDate, controladorFiscal.operationDate) &&
        Objects.equals(this.port, controladorFiscal.port) &&
        Objects.equals(this.printername, controladorFiscal.printername) &&
        Objects.equals(this.status, controladorFiscal.status) &&
        Objects.equals(this.updated, controladorFiscal.updated) &&
        Objects.equals(this.updatedby, controladorFiscal.updatedby) &&
        Objects.equals(this.usedbyId, controladorFiscal.usedbyId) &&
        Objects.equals(this.additionalvalues, controladorFiscal.additionalvalues) &&
        Objects.equals(this.referencedvalues, controladorFiscal.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, askwhenerror, cControladorFiscalId, cControladorFiscalTypeId, cmdcancelbeforeprintdocument, connectiontype, controladorfiscaltype, created, createdby, description, host, isactive, isremote, logtyperecorded, name, onlylinedescription, onprintproductformat, onprintuseproductreference, operationDate, port, printername, status, updated, updatedby, usedbyId, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ControladorFiscal {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    askwhenerror: ").append(toIndentedString(askwhenerror)).append("\n");
    sb.append("    cControladorFiscalId: ").append(toIndentedString(cControladorFiscalId)).append("\n");
    sb.append("    cControladorFiscalTypeId: ").append(toIndentedString(cControladorFiscalTypeId)).append("\n");
    sb.append("    cmdcancelbeforeprintdocument: ").append(toIndentedString(cmdcancelbeforeprintdocument)).append("\n");
    sb.append("    connectiontype: ").append(toIndentedString(connectiontype)).append("\n");
    sb.append("    controladorfiscaltype: ").append(toIndentedString(controladorfiscaltype)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isremote: ").append(toIndentedString(isremote)).append("\n");
    sb.append("    logtyperecorded: ").append(toIndentedString(logtyperecorded)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    onlylinedescription: ").append(toIndentedString(onlylinedescription)).append("\n");
    sb.append("    onprintproductformat: ").append(toIndentedString(onprintproductformat)).append("\n");
    sb.append("    onprintuseproductreference: ").append(toIndentedString(onprintuseproductreference)).append("\n");
    sb.append("    operationDate: ").append(toIndentedString(operationDate)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    printername: ").append(toIndentedString(printername)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    usedbyId: ").append(toIndentedString(usedbyId)).append("\n");
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
