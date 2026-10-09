package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.libertya.api.stub.model.ProcessSchemaReference;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProcessSchemaParameter
 */
@Validated



public class ProcessSchemaParameter   {
  @JsonProperty("process_para_id")
  private Integer processParaId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("seqno")
  private Integer seqno = null;

  @JsonProperty("columnname")
  private String columnname = null;

  @JsonProperty("ad_reference_id")
  private Integer adReferenceId = null;

  @JsonProperty("ad_reference_value_id")
  private Integer adReferenceValueId = null;

  @JsonProperty("ad_val_rule_id")
  private Integer adValRuleId = null;

  @JsonProperty("ismandatory")
  private Boolean ismandatory = null;

  @JsonProperty("isrange")
  private Boolean isrange = null;

  @JsonProperty("issameline")
  private Boolean issameline = null;

  @JsonProperty("isreadonly")
  private Boolean isreadonly = null;

  @JsonProperty("has_callout")
  private Boolean hasCallout = null;

  @JsonProperty("calloutalsoonload")
  private Boolean calloutalsoonload = null;

  @JsonProperty("defaultvalue")
  private String defaultvalue = null;

  @JsonProperty("defaultvalue2")
  private String defaultvalue2 = null;

  @JsonProperty("displaylogic")
  private String displaylogic = null;

  @JsonProperty("readonlylogic")
  private String readonlylogic = null;

  @JsonProperty("fieldlength")
  private Integer fieldlength = null;

  @JsonProperty("vformat")
  private String vformat = null;

  @JsonProperty("valuemin")
  private String valuemin = null;

  @JsonProperty("valuemax")
  private String valuemax = null;

  @JsonProperty("reference")
  private ProcessSchemaReference reference = null;

  public ProcessSchemaParameter processParaId(Integer processParaId) {
    this.processParaId = processParaId;
    return this;
  }

  /**
   * Get processParaId
   * @return processParaId
   **/
  @Schema(description = "")
  
    public Integer getProcessParaId() {
    return processParaId;
  }

  public void setProcessParaId(Integer processParaId) {
    this.processParaId = processParaId;
  }

  public ProcessSchemaParameter name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProcessSchemaParameter description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProcessSchemaParameter help(String help) {
    this.help = help;
    return this;
  }

  /**
   * Get help
   * @return help
   **/
  @Schema(description = "")
  
    public String getHelp() {
    return help;
  }

  public void setHelp(String help) {
    this.help = help;
  }

  public ProcessSchemaParameter seqno(Integer seqno) {
    this.seqno = seqno;
    return this;
  }

  /**
   * Get seqno
   * @return seqno
   **/
  @Schema(description = "")
  
    public Integer getSeqno() {
    return seqno;
  }

  public void setSeqno(Integer seqno) {
    this.seqno = seqno;
  }

  public ProcessSchemaParameter columnname(String columnname) {
    this.columnname = columnname;
    return this;
  }

  /**
   * Get columnname
   * @return columnname
   **/
  @Schema(description = "")
  
    public String getColumnname() {
    return columnname;
  }

  public void setColumnname(String columnname) {
    this.columnname = columnname;
  }

  public ProcessSchemaParameter adReferenceId(Integer adReferenceId) {
    this.adReferenceId = adReferenceId;
    return this;
  }

  /**
   * Get adReferenceId
   * @return adReferenceId
   **/
  @Schema(description = "")
  
    public Integer getAdReferenceId() {
    return adReferenceId;
  }

  public void setAdReferenceId(Integer adReferenceId) {
    this.adReferenceId = adReferenceId;
  }

  public ProcessSchemaParameter adReferenceValueId(Integer adReferenceValueId) {
    this.adReferenceValueId = adReferenceValueId;
    return this;
  }

  /**
   * Get adReferenceValueId
   * @return adReferenceValueId
   **/
  @Schema(description = "")
  
    public Integer getAdReferenceValueId() {
    return adReferenceValueId;
  }

  public void setAdReferenceValueId(Integer adReferenceValueId) {
    this.adReferenceValueId = adReferenceValueId;
  }

  public ProcessSchemaParameter adValRuleId(Integer adValRuleId) {
    this.adValRuleId = adValRuleId;
    return this;
  }

  /**
   * Get adValRuleId
   * @return adValRuleId
   **/
  @Schema(description = "")
  
    public Integer getAdValRuleId() {
    return adValRuleId;
  }

  public void setAdValRuleId(Integer adValRuleId) {
    this.adValRuleId = adValRuleId;
  }

  public ProcessSchemaParameter ismandatory(Boolean ismandatory) {
    this.ismandatory = ismandatory;
    return this;
  }

  /**
   * Get ismandatory
   * @return ismandatory
   **/
  @Schema(description = "")
  
    public Boolean isIsmandatory() {
    return ismandatory;
  }

  public void setIsmandatory(Boolean ismandatory) {
    this.ismandatory = ismandatory;
  }

  public ProcessSchemaParameter isrange(Boolean isrange) {
    this.isrange = isrange;
    return this;
  }

  /**
   * Get isrange
   * @return isrange
   **/
  @Schema(description = "")
  
    public Boolean isIsrange() {
    return isrange;
  }

  public void setIsrange(Boolean isrange) {
    this.isrange = isrange;
  }

  public ProcessSchemaParameter issameline(Boolean issameline) {
    this.issameline = issameline;
    return this;
  }

  /**
   * Get issameline
   * @return issameline
   **/
  @Schema(description = "")
  
    public Boolean isIssameline() {
    return issameline;
  }

  public void setIssameline(Boolean issameline) {
    this.issameline = issameline;
  }

  public ProcessSchemaParameter isreadonly(Boolean isreadonly) {
    this.isreadonly = isreadonly;
    return this;
  }

  /**
   * Get isreadonly
   * @return isreadonly
   **/
  @Schema(description = "")
  
    public Boolean isIsreadonly() {
    return isreadonly;
  }

  public void setIsreadonly(Boolean isreadonly) {
    this.isreadonly = isreadonly;
  }

  public ProcessSchemaParameter hasCallout(Boolean hasCallout) {
    this.hasCallout = hasCallout;
    return this;
  }

  /**
   * Get hasCallout
   * @return hasCallout
   **/
  @Schema(description = "")
  
    public Boolean isHasCallout() {
    return hasCallout;
  }

  public void setHasCallout(Boolean hasCallout) {
    this.hasCallout = hasCallout;
  }

  public ProcessSchemaParameter calloutalsoonload(Boolean calloutalsoonload) {
    this.calloutalsoonload = calloutalsoonload;
    return this;
  }

  /**
   * Get calloutalsoonload
   * @return calloutalsoonload
   **/
  @Schema(description = "")
  
    public Boolean isCalloutalsoonload() {
    return calloutalsoonload;
  }

  public void setCalloutalsoonload(Boolean calloutalsoonload) {
    this.calloutalsoonload = calloutalsoonload;
  }

  public ProcessSchemaParameter defaultvalue(String defaultvalue) {
    this.defaultvalue = defaultvalue;
    return this;
  }

  /**
   * Valor por defecto efectivo resuelto por el backend
   * @return defaultvalue
   **/
  @Schema(description = "Valor por defecto efectivo resuelto por el backend")
  
    public String getDefaultvalue() {
    return defaultvalue;
  }

  public void setDefaultvalue(String defaultvalue) {
    this.defaultvalue = defaultvalue;
  }

  public ProcessSchemaParameter defaultvalue2(String defaultvalue2) {
    this.defaultvalue2 = defaultvalue2;
    return this;
  }

  /**
   * Segundo valor por defecto efectivo para parámetros de rango
   * @return defaultvalue2
   **/
  @Schema(description = "Segundo valor por defecto efectivo para parámetros de rango")
  
    public String getDefaultvalue2() {
    return defaultvalue2;
  }

  public void setDefaultvalue2(String defaultvalue2) {
    this.defaultvalue2 = defaultvalue2;
  }

  public ProcessSchemaParameter displaylogic(String displaylogic) {
    this.displaylogic = displaylogic;
    return this;
  }

  /**
   * Get displaylogic
   * @return displaylogic
   **/
  @Schema(description = "")
  
    public String getDisplaylogic() {
    return displaylogic;
  }

  public void setDisplaylogic(String displaylogic) {
    this.displaylogic = displaylogic;
  }

  public ProcessSchemaParameter readonlylogic(String readonlylogic) {
    this.readonlylogic = readonlylogic;
    return this;
  }

  /**
   * Get readonlylogic
   * @return readonlylogic
   **/
  @Schema(description = "")
  
    public String getReadonlylogic() {
    return readonlylogic;
  }

  public void setReadonlylogic(String readonlylogic) {
    this.readonlylogic = readonlylogic;
  }

  public ProcessSchemaParameter fieldlength(Integer fieldlength) {
    this.fieldlength = fieldlength;
    return this;
  }

  /**
   * Get fieldlength
   * @return fieldlength
   **/
  @Schema(description = "")
  
    public Integer getFieldlength() {
    return fieldlength;
  }

  public void setFieldlength(Integer fieldlength) {
    this.fieldlength = fieldlength;
  }

  public ProcessSchemaParameter vformat(String vformat) {
    this.vformat = vformat;
    return this;
  }

  /**
   * Get vformat
   * @return vformat
   **/
  @Schema(description = "")
  
    public String getVformat() {
    return vformat;
  }

  public void setVformat(String vformat) {
    this.vformat = vformat;
  }

  public ProcessSchemaParameter valuemin(String valuemin) {
    this.valuemin = valuemin;
    return this;
  }

  /**
   * Get valuemin
   * @return valuemin
   **/
  @Schema(description = "")
  
    public String getValuemin() {
    return valuemin;
  }

  public void setValuemin(String valuemin) {
    this.valuemin = valuemin;
  }

  public ProcessSchemaParameter valuemax(String valuemax) {
    this.valuemax = valuemax;
    return this;
  }

  /**
   * Get valuemax
   * @return valuemax
   **/
  @Schema(description = "")
  
    public String getValuemax() {
    return valuemax;
  }

  public void setValuemax(String valuemax) {
    this.valuemax = valuemax;
  }

  public ProcessSchemaParameter reference(ProcessSchemaReference reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Get reference
   * @return reference
   **/
  @Schema(description = "")
  
    @Valid
    public ProcessSchemaReference getReference() {
    return reference;
  }

  public void setReference(ProcessSchemaReference reference) {
    this.reference = reference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessSchemaParameter processSchemaParameter = (ProcessSchemaParameter) o;
    return Objects.equals(this.processParaId, processSchemaParameter.processParaId) &&
        Objects.equals(this.name, processSchemaParameter.name) &&
        Objects.equals(this.description, processSchemaParameter.description) &&
        Objects.equals(this.help, processSchemaParameter.help) &&
        Objects.equals(this.seqno, processSchemaParameter.seqno) &&
        Objects.equals(this.columnname, processSchemaParameter.columnname) &&
        Objects.equals(this.adReferenceId, processSchemaParameter.adReferenceId) &&
        Objects.equals(this.adReferenceValueId, processSchemaParameter.adReferenceValueId) &&
        Objects.equals(this.adValRuleId, processSchemaParameter.adValRuleId) &&
        Objects.equals(this.ismandatory, processSchemaParameter.ismandatory) &&
        Objects.equals(this.isrange, processSchemaParameter.isrange) &&
        Objects.equals(this.issameline, processSchemaParameter.issameline) &&
        Objects.equals(this.isreadonly, processSchemaParameter.isreadonly) &&
        Objects.equals(this.hasCallout, processSchemaParameter.hasCallout) &&
        Objects.equals(this.calloutalsoonload, processSchemaParameter.calloutalsoonload) &&
        Objects.equals(this.defaultvalue, processSchemaParameter.defaultvalue) &&
        Objects.equals(this.defaultvalue2, processSchemaParameter.defaultvalue2) &&
        Objects.equals(this.displaylogic, processSchemaParameter.displaylogic) &&
        Objects.equals(this.readonlylogic, processSchemaParameter.readonlylogic) &&
        Objects.equals(this.fieldlength, processSchemaParameter.fieldlength) &&
        Objects.equals(this.vformat, processSchemaParameter.vformat) &&
        Objects.equals(this.valuemin, processSchemaParameter.valuemin) &&
        Objects.equals(this.valuemax, processSchemaParameter.valuemax) &&
        Objects.equals(this.reference, processSchemaParameter.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processParaId, name, description, help, seqno, columnname, adReferenceId, adReferenceValueId, adValRuleId, ismandatory, isrange, issameline, isreadonly, hasCallout, calloutalsoonload, defaultvalue, defaultvalue2, displaylogic, readonlylogic, fieldlength, vformat, valuemin, valuemax, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessSchemaParameter {\n");
    
    sb.append("    processParaId: ").append(toIndentedString(processParaId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
    sb.append("    columnname: ").append(toIndentedString(columnname)).append("\n");
    sb.append("    adReferenceId: ").append(toIndentedString(adReferenceId)).append("\n");
    sb.append("    adReferenceValueId: ").append(toIndentedString(adReferenceValueId)).append("\n");
    sb.append("    adValRuleId: ").append(toIndentedString(adValRuleId)).append("\n");
    sb.append("    ismandatory: ").append(toIndentedString(ismandatory)).append("\n");
    sb.append("    isrange: ").append(toIndentedString(isrange)).append("\n");
    sb.append("    issameline: ").append(toIndentedString(issameline)).append("\n");
    sb.append("    isreadonly: ").append(toIndentedString(isreadonly)).append("\n");
    sb.append("    hasCallout: ").append(toIndentedString(hasCallout)).append("\n");
    sb.append("    calloutalsoonload: ").append(toIndentedString(calloutalsoonload)).append("\n");
    sb.append("    defaultvalue: ").append(toIndentedString(defaultvalue)).append("\n");
    sb.append("    defaultvalue2: ").append(toIndentedString(defaultvalue2)).append("\n");
    sb.append("    displaylogic: ").append(toIndentedString(displaylogic)).append("\n");
    sb.append("    readonlylogic: ").append(toIndentedString(readonlylogic)).append("\n");
    sb.append("    fieldlength: ").append(toIndentedString(fieldlength)).append("\n");
    sb.append("    vformat: ").append(toIndentedString(vformat)).append("\n");
    sb.append("    valuemin: ").append(toIndentedString(valuemin)).append("\n");
    sb.append("    valuemax: ").append(toIndentedString(valuemax)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
