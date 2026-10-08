package org.libertya.api.stub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class ProcessSchema {
    @JsonProperty("process_id") private Integer processId;
    @JsonProperty("name") private String name;
    @JsonProperty("description") private String description;
    @JsonProperty("help") private String help;
    @JsonProperty("parameters") private List<ProcessSchemaParameter> parameters;

    public ProcessSchema processId(Integer value) { processId = value; return this; }
    public ProcessSchema name(String value) { name = value; return this; }
    public ProcessSchema description(String value) { description = value; return this; }
    public ProcessSchema help(String value) { help = value; return this; }
    public ProcessSchema parameters(List<ProcessSchemaParameter> value) { parameters = value; return this; }
    public ProcessSchema addParametersItem(ProcessSchemaParameter value) { if (parameters == null) parameters = new ArrayList<>(); parameters.add(value); return this; }
    public Integer getProcessId() { return processId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getHelp() { return help; }
    public List<ProcessSchemaParameter> getParameters() { return parameters; }
}
