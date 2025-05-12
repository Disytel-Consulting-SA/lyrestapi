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
 * User
 */
@Validated



public class User   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("ad_user_id")
  private Integer adUserId = null;

  @JsonProperty("birthday")
  private String birthday = null;

  @JsonProperty("c_bpartner_contact_id")
  private Integer cBpartnerContactId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_bpartner_location_id")
  private Integer cBpartnerLocationId = null;

  @JsonProperty("c_greeting_id")
  private Integer cGreetingId = null;

  @JsonProperty("comments")
  private String comments = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("emailuser")
  private String emailuser = null;

  @JsonProperty("emailuserpw")
  private String emailuserpw = null;

  @JsonProperty("emailverify")
  private String emailverify = null;

  @JsonProperty("emailverifydate")
  private String emailverifydate = null;

  @JsonProperty("fax")
  private String fax = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isldapauthorized")
  private Boolean isldapauthorized = null;

  @JsonProperty("issystemaccess")
  private Boolean issystemaccess = null;

  @JsonProperty("lastcontact")
  private String lastcontact = null;

  @JsonProperty("lastpasswordchangedate")
  private String lastpasswordchangedate = null;

  @JsonProperty("lastresult")
  private String lastresult = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("notificationtype")
  private String notificationtype = null;

  @JsonProperty("notifyonconversationactivity")
  private Boolean notifyonconversationactivity = null;

  @JsonProperty("pa_goal_id")
  private Integer paGoalId = null;

  @JsonProperty("pa_goalprivate_id")
  private Integer paGoalprivateId = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("phone2")
  private String phone2 = null;

  @JsonProperty("phone3")
  private String phone3 = null;

  @JsonProperty("processing")
  private String processing = null;

  @JsonProperty("supervisor_id")
  private Integer supervisorId = null;

  @JsonProperty("title")
  private String title = null;

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

  public User adClientId(Integer adClientId) {
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

  public User adComponentobjectuid(String adComponentobjectuid) {
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

  public User adOrgId(Integer adOrgId) {
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

  public User adOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
    return this;
  }

  /**
   * Organización que inicia o ejecuta la transacción
   * @return adOrgtrxId
   **/
  @Schema(description = "Organización que inicia o ejecuta la transacción")
  
    public Integer getAdOrgtrxId() {
    return adOrgtrxId;
  }

  public void setAdOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
  }

  public User adUserId(Integer adUserId) {
    this.adUserId = adUserId;
    return this;
  }

  /**
   * ID de Usuario dentro del sistema
   * @return adUserId
   **/
  @Schema(required = true, description = "ID de Usuario dentro del sistema")
      @NotNull

    public Integer getAdUserId() {
    return adUserId;
  }

  public void setAdUserId(Integer adUserId) {
    this.adUserId = adUserId;
  }

  public User birthday(String birthday) {
    this.birthday = birthday;
    return this;
  }

  /**
   * Cumpleaños o día de aniversario
   * @return birthday
   **/
  @Schema(description = "Cumpleaños o día de aniversario")
  
    public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public User cBpartnerContactId(Integer cBpartnerContactId) {
    this.cBpartnerContactId = cBpartnerContactId;
    return this;
  }

  /**
   *  
   * @return cBpartnerContactId
   **/
  @Schema(description = " ")
  
    public Integer getCBpartnerContactId() {
    return cBpartnerContactId;
  }

  public void setCBpartnerContactId(Integer cBpartnerContactId) {
    this.cBpartnerContactId = cBpartnerContactId;
  }

  public User cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Identifica una Entidad Comercial
   * @return cBpartnerId
   **/
  @Schema(description = "Identifica una Entidad Comercial")
  
    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public User cBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
    return this;
  }

  /**
   * Dirección de la Entidad Comercial
   * @return cBpartnerLocationId
   **/
  @Schema(description = "Dirección de la Entidad Comercial")
  
    public Integer getCBpartnerLocationId() {
    return cBpartnerLocationId;
  }

  public void setCBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
  }

  public User cGreetingId(Integer cGreetingId) {
    this.cGreetingId = cGreetingId;
    return this;
  }

  /**
   * Saludo para imprimir en la correspondencia
   * @return cGreetingId
   **/
  @Schema(description = "Saludo para imprimir en la correspondencia")
  
    public Integer getCGreetingId() {
    return cGreetingId;
  }

  public void setCGreetingId(Integer cGreetingId) {
    this.cGreetingId = cGreetingId;
  }

  public User comments(String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * Comentarios o información adicional
   * @return comments
   **/
  @Schema(description = "Comentarios o información adicional")
  
    public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public User created(String created) {
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

  public User createdby(Integer createdby) {
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

  public User description(String description) {
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

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * ID de correo electrónico
   * @return email
   **/
  @Schema(description = "ID de correo electrónico")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User emailuser(String emailuser) {
    this.emailuser = emailuser;
    return this;
  }

  /**
   * ID del Usuario
   * @return emailuser
   **/
  @Schema(description = "ID del Usuario")
  
    public String getEmailuser() {
    return emailuser;
  }

  public void setEmailuser(String emailuser) {
    this.emailuser = emailuser;
  }

  public User emailuserpw(String emailuserpw) {
    this.emailuserpw = emailuserpw;
    return this;
  }

  /**
   * Contraseña de su usuario de email
   * @return emailuserpw
   **/
  @Schema(description = "Contraseña de su usuario de email")
  
    public String getEmailuserpw() {
    return emailuserpw;
  }

  public void setEmailuserpw(String emailuserpw) {
    this.emailuserpw = emailuserpw;
  }

  public User emailverify(String emailverify) {
    this.emailverify = emailverify;
    return this;
  }

  /**
   * Verificación de dirección de E-Mail
   * @return emailverify
   **/
  @Schema(description = "Verificación de dirección de E-Mail")
  
    public String getEmailverify() {
    return emailverify;
  }

  public void setEmailverify(String emailverify) {
    this.emailverify = emailverify;
  }

  public User emailverifydate(String emailverifydate) {
    this.emailverifydate = emailverifydate;
    return this;
  }

  /**
   * Verificar E-mail
   * @return emailverifydate
   **/
  @Schema(description = "Verificar E-mail")
  
    public String getEmailverifydate() {
    return emailverifydate;
  }

  public void setEmailverifydate(String emailverifydate) {
    this.emailverifydate = emailverifydate;
  }

  public User fax(String fax) {
    this.fax = fax;
    return this;
  }

  /**
   * Número de Fax
   * @return fax
   **/
  @Schema(description = "Número de Fax")
  
    public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public User isactive(Boolean isactive) {
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

  public User isldapauthorized(Boolean isldapauthorized) {
    this.isldapauthorized = isldapauthorized;
    return this;
  }

  /**
   * Autorizar via LDAP
   * @return isldapauthorized
   **/
  @Schema(required = true, description = "Autorizar via LDAP")
      @NotNull

    public Boolean isIsldapauthorized() {
    return isldapauthorized;
  }

  public void setIsldapauthorized(Boolean isldapauthorized) {
    this.isldapauthorized = isldapauthorized;
  }

  public User issystemaccess(Boolean issystemaccess) {
    this.issystemaccess = issystemaccess;
    return this;
  }

  /**
   * Usuario con acceso al sistema
   * @return issystemaccess
   **/
  @Schema(required = true, description = "Usuario con acceso al sistema")
      @NotNull

    public Boolean isIssystemaccess() {
    return issystemaccess;
  }

  public void setIssystemaccess(Boolean issystemaccess) {
    this.issystemaccess = issystemaccess;
  }

  public User lastcontact(String lastcontact) {
    this.lastcontact = lastcontact;
    return this;
  }

  /**
   * Fecha en que este individuo fue contactado por última vez
   * @return lastcontact
   **/
  @Schema(description = "Fecha en que este individuo fue contactado por última vez")
  
    public String getLastcontact() {
    return lastcontact;
  }

  public void setLastcontact(String lastcontact) {
    this.lastcontact = lastcontact;
  }

  public User lastpasswordchangedate(String lastpasswordchangedate) {
    this.lastpasswordchangedate = lastpasswordchangedate;
    return this;
  }

  /**
   * Última fecha de cambio de clave
   * @return lastpasswordchangedate
   **/
  @Schema(description = "Última fecha de cambio de clave")
  
    public String getLastpasswordchangedate() {
    return lastpasswordchangedate;
  }

  public void setLastpasswordchangedate(String lastpasswordchangedate) {
    this.lastpasswordchangedate = lastpasswordchangedate;
  }

  public User lastresult(String lastresult) {
    this.lastresult = lastresult;
    return this;
  }

  /**
   * Resultado del último contacto
   * @return lastresult
   **/
  @Schema(description = "Resultado del último contacto")
  
    public String getLastresult() {
    return lastresult;
  }

  public void setLastresult(String lastresult) {
    this.lastresult = lastresult;
  }

  public User name(String name) {
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

  public User notificationtype(String notificationtype) {
    this.notificationtype = notificationtype;
    return this;
  }

  /**
   * Tipo de Notificacion
   * @return notificationtype
   **/
  @Schema(required = true, description = "Tipo de Notificacion")
      @NotNull

    public String getNotificationtype() {
    return notificationtype;
  }

  public void setNotificationtype(String notificationtype) {
    this.notificationtype = notificationtype;
  }

  public User notifyonconversationactivity(Boolean notifyonconversationactivity) {
    this.notifyonconversationactivity = notifyonconversationactivity;
    return this;
  }

  /**
   *  
   * @return notifyonconversationactivity
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isNotifyonconversationactivity() {
    return notifyonconversationactivity;
  }

  public void setNotifyonconversationactivity(Boolean notifyonconversationactivity) {
    this.notifyonconversationactivity = notifyonconversationactivity;
  }

  public User paGoalId(Integer paGoalId) {
    this.paGoalId = paGoalId;
    return this;
  }

  /**
   * Objetivo de Resultados
   * @return paGoalId
   **/
  @Schema(description = "Objetivo de Resultados")
  
    public Integer getPaGoalId() {
    return paGoalId;
  }

  public void setPaGoalId(Integer paGoalId) {
    this.paGoalId = paGoalId;
  }

  public User paGoalprivateId(Integer paGoalprivateId) {
    this.paGoalprivateId = paGoalprivateId;
    return this;
  }

  /**
   * Jerarquía de objetivos solamente visible para el usuario
   * @return paGoalprivateId
   **/
  @Schema(description = "Jerarquía de objetivos solamente visible para el usuario")
  
    public Integer getPaGoalprivateId() {
    return paGoalprivateId;
  }

  public void setPaGoalprivateId(Integer paGoalprivateId) {
    this.paGoalprivateId = paGoalprivateId;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Contraseña de cualquier longitud (Sensible a mayúsculas y minúsculas
   * @return password
   **/
  @Schema(description = "Contraseña de cualquier longitud (Sensible a mayúsculas y minúsculas")
  
    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Identifica un número telefónico
   * @return phone
   **/
  @Schema(description = "Identifica un número telefónico")
  
    public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public User phone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  /**
   * Identifica un número telefónico alterno
   * @return phone2
   **/
  @Schema(description = "Identifica un número telefónico alterno")
  
    public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public User phone3(String phone3) {
    this.phone3 = phone3;
    return this;
  }

  /**
   * Identifica un número telefónico
   * @return phone3
   **/
  @Schema(description = "Identifica un número telefónico")
  
    public String getPhone3() {
    return phone3;
  }

  public void setPhone3(String phone3) {
    this.phone3 = phone3;
  }

  public User processing(String processing) {
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

  public User supervisorId(Integer supervisorId) {
    this.supervisorId = supervisorId;
    return this;
  }

  /**
   * Supervisor para este usuario - usado para escalación
   * @return supervisorId
   **/
  @Schema(description = "Supervisor para este usuario - usado para escalación")
  
    public Integer getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(Integer supervisorId) {
    this.supervisorId = supervisorId;
  }

  public User title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Nombre como se conoce esta entidad
   * @return title
   **/
  @Schema(description = "Nombre como se conoce esta entidad")
  
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public User updated(String updated) {
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

  public User updatedby(Integer updatedby) {
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

  public User additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public User addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public User referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public User addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    User user = (User) o;
    return Objects.equals(this.adClientId, user.adClientId) &&
        Objects.equals(this.adComponentobjectuid, user.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, user.adOrgId) &&
        Objects.equals(this.adOrgtrxId, user.adOrgtrxId) &&
        Objects.equals(this.adUserId, user.adUserId) &&
        Objects.equals(this.birthday, user.birthday) &&
        Objects.equals(this.cBpartnerContactId, user.cBpartnerContactId) &&
        Objects.equals(this.cBpartnerId, user.cBpartnerId) &&
        Objects.equals(this.cBpartnerLocationId, user.cBpartnerLocationId) &&
        Objects.equals(this.cGreetingId, user.cGreetingId) &&
        Objects.equals(this.comments, user.comments) &&
        Objects.equals(this.created, user.created) &&
        Objects.equals(this.createdby, user.createdby) &&
        Objects.equals(this.description, user.description) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.emailuser, user.emailuser) &&
        Objects.equals(this.emailuserpw, user.emailuserpw) &&
        Objects.equals(this.emailverify, user.emailverify) &&
        Objects.equals(this.emailverifydate, user.emailverifydate) &&
        Objects.equals(this.fax, user.fax) &&
        Objects.equals(this.isactive, user.isactive) &&
        Objects.equals(this.isldapauthorized, user.isldapauthorized) &&
        Objects.equals(this.issystemaccess, user.issystemaccess) &&
        Objects.equals(this.lastcontact, user.lastcontact) &&
        Objects.equals(this.lastpasswordchangedate, user.lastpasswordchangedate) &&
        Objects.equals(this.lastresult, user.lastresult) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.notificationtype, user.notificationtype) &&
        Objects.equals(this.notifyonconversationactivity, user.notifyonconversationactivity) &&
        Objects.equals(this.paGoalId, user.paGoalId) &&
        Objects.equals(this.paGoalprivateId, user.paGoalprivateId) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.phone, user.phone) &&
        Objects.equals(this.phone2, user.phone2) &&
        Objects.equals(this.phone3, user.phone3) &&
        Objects.equals(this.processing, user.processing) &&
        Objects.equals(this.supervisorId, user.supervisorId) &&
        Objects.equals(this.title, user.title) &&
        Objects.equals(this.updated, user.updated) &&
        Objects.equals(this.updatedby, user.updatedby) &&
        Objects.equals(this.additionalvalues, user.additionalvalues) &&
        Objects.equals(this.referencedvalues, user.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, adOrgtrxId, adUserId, birthday, cBpartnerContactId, cBpartnerId, cBpartnerLocationId, cGreetingId, comments, created, createdby, description, email, emailuser, emailuserpw, emailverify, emailverifydate, fax, isactive, isldapauthorized, issystemaccess, lastcontact, lastpasswordchangedate, lastresult, name, notificationtype, notifyonconversationactivity, paGoalId, paGoalprivateId, password, phone, phone2, phone3, processing, supervisorId, title, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    adUserId: ").append(toIndentedString(adUserId)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("    cBpartnerContactId: ").append(toIndentedString(cBpartnerContactId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cBpartnerLocationId: ").append(toIndentedString(cBpartnerLocationId)).append("\n");
    sb.append("    cGreetingId: ").append(toIndentedString(cGreetingId)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    emailuser: ").append(toIndentedString(emailuser)).append("\n");
    sb.append("    emailuserpw: ").append(toIndentedString(emailuserpw)).append("\n");
    sb.append("    emailverify: ").append(toIndentedString(emailverify)).append("\n");
    sb.append("    emailverifydate: ").append(toIndentedString(emailverifydate)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isldapauthorized: ").append(toIndentedString(isldapauthorized)).append("\n");
    sb.append("    issystemaccess: ").append(toIndentedString(issystemaccess)).append("\n");
    sb.append("    lastcontact: ").append(toIndentedString(lastcontact)).append("\n");
    sb.append("    lastpasswordchangedate: ").append(toIndentedString(lastpasswordchangedate)).append("\n");
    sb.append("    lastresult: ").append(toIndentedString(lastresult)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notificationtype: ").append(toIndentedString(notificationtype)).append("\n");
    sb.append("    notifyonconversationactivity: ").append(toIndentedString(notifyonconversationactivity)).append("\n");
    sb.append("    paGoalId: ").append(toIndentedString(paGoalId)).append("\n");
    sb.append("    paGoalprivateId: ").append(toIndentedString(paGoalprivateId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    phone2: ").append(toIndentedString(phone2)).append("\n");
    sb.append("    phone3: ").append(toIndentedString(phone3)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    supervisorId: ").append(toIndentedString(supervisorId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
