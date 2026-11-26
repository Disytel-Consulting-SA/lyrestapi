package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.libertya.api.stub.model.GenericRecord;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IdentityRecordWrite
 */
@Validated



public class IdentityRecordWrite   {
  @JsonProperty("identity")
  private GenericRecord identity = null;

  @JsonProperty("values")
  private GenericRecord values = null;

  public IdentityRecordWrite identity(GenericRecord identity) {
    this.identity = identity;
    return this;
  }

  /**
   * Get identity
   * @return identity
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public GenericRecord getIdentity() {
    return identity;
  }

  public void setIdentity(GenericRecord identity) {
    this.identity = identity;
  }

  public IdentityRecordWrite values(GenericRecord values) {
    this.values = values;
    return this;
  }

  /**
   * Get values
   * @return values
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public GenericRecord getValues() {
    return values;
  }

  public void setValues(GenericRecord values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityRecordWrite identityRecordWrite = (IdentityRecordWrite) o;
    return Objects.equals(this.identity, identityRecordWrite.identity) &&
        Objects.equals(this.values, identityRecordWrite.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityRecordWrite {\n");
    
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
