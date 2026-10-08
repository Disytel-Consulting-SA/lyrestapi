package org.libertya.api.stub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessSchemaParameter {
    @JsonProperty("process_para_id") private Integer processParaId;
    @JsonProperty("name") private String name;
    @JsonProperty("description") private String description;
    @JsonProperty("help") private String help;
    @JsonProperty("seqno") private Integer seqno;
    @JsonProperty("columnname") private String columnname;
    @JsonProperty("ad_reference_id") private Integer adReferenceId;
    @JsonProperty("ad_reference_value_id") private Integer adReferenceValueId;
    @JsonProperty("ad_val_rule_id") private Integer adValRuleId;
    @JsonProperty("ismandatory") private Boolean ismandatory;
    @JsonProperty("isrange") private Boolean isrange;
    @JsonProperty("issameline") private Boolean issameline;
    @JsonProperty("isreadonly") private Boolean isreadonly;
    @JsonProperty("has_callout") private Boolean hasCallout;
    @JsonProperty("calloutalsoonload") private Boolean calloutalsoonload;
    @JsonProperty("defaultvalue") private String defaultvalue;
    @JsonProperty("defaultvalue2") private String defaultvalue2;
    @JsonProperty("displaylogic") private String displaylogic;
    @JsonProperty("readonlylogic") private String readonlylogic;
    @JsonProperty("fieldlength") private Integer fieldlength;
    @JsonProperty("vformat") private String vformat;
    @JsonProperty("valuemin") private String valuemin;
    @JsonProperty("valuemax") private String valuemax;
    @JsonProperty("reference") private ProcessSchemaReference reference;

    public ProcessSchemaParameter processParaId(Integer v){processParaId=v;return this;} public ProcessSchemaParameter name(String v){name=v;return this;}
    public ProcessSchemaParameter description(String v){description=v;return this;} public ProcessSchemaParameter help(String v){help=v;return this;}
    public ProcessSchemaParameter seqno(Integer v){seqno=v;return this;} public ProcessSchemaParameter columnname(String v){columnname=v;return this;}
    public ProcessSchemaParameter adReferenceId(Integer v){adReferenceId=v;return this;} public ProcessSchemaParameter adReferenceValueId(Integer v){adReferenceValueId=v;return this;}
    public ProcessSchemaParameter adValRuleId(Integer v){adValRuleId=v;return this;} public ProcessSchemaParameter ismandatory(Boolean v){ismandatory=v;return this;}
    public ProcessSchemaParameter isrange(Boolean v){isrange=v;return this;} public ProcessSchemaParameter issameline(Boolean v){issameline=v;return this;}
    public ProcessSchemaParameter isreadonly(Boolean v){isreadonly=v;return this;} public ProcessSchemaParameter hasCallout(Boolean v){hasCallout=v;return this;}
    public ProcessSchemaParameter calloutalsoonload(Boolean v){calloutalsoonload=v;return this;} public ProcessSchemaParameter defaultvalue(String v){defaultvalue=v;return this;}
    public ProcessSchemaParameter defaultvalue2(String v){defaultvalue2=v;return this;} public ProcessSchemaParameter displaylogic(String v){displaylogic=v;return this;}
    public ProcessSchemaParameter readonlylogic(String v){readonlylogic=v;return this;} public ProcessSchemaParameter fieldlength(Integer v){fieldlength=v;return this;}
    public ProcessSchemaParameter vformat(String v){vformat=v;return this;} public ProcessSchemaParameter valuemin(String v){valuemin=v;return this;}
    public ProcessSchemaParameter valuemax(String v){valuemax=v;return this;} public ProcessSchemaParameter reference(ProcessSchemaReference v){reference=v;return this;}
}
