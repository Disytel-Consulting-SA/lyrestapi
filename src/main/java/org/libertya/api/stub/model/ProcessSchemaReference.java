package org.libertya.api.stub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessSchemaReference {
    @JsonProperty("type") private String type;
    public ProcessSchemaReference type(String value) { type = value; return this; }
    public String getType() { return type; }
}
