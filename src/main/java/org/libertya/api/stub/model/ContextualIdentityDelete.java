package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.libertya.api.stub.model.GenericRecord;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContextualIdentityDelete
 */
@Validated



public class ContextualIdentityDelete   {
  @JsonProperty("ancestors")
  @Valid
  private Map<String, GenericRecord> ancestors = new HashMap<>();

  @JsonProperty("identity")
  private GenericRecord identity = null;

  public ContextualIdentityDelete ancestors(Map<String, GenericRecord> ancestors) {
    this.ancestors = ancestors;
    return this;
  }

  public ContextualIdentityDelete putAncestorsItem(String key, GenericRecord ancestorsItem) {
    this.ancestors.put(key, ancestorsItem);
    return this;
  }

  /**
   * Identidades completas de ancestros indexadas por AD_Tab_ID decimal. Objeto vacio para pestañas raiz.
   * @return ancestors
   **/
  @Schema(required = true, description = "Identidades completas de ancestros indexadas por AD_Tab_ID decimal. Objeto vacio para pestañas raiz.")
      @NotNull
    @Valid
    public Map<String, GenericRecord> getAncestors() {
    return ancestors;
  }

  public void setAncestors(Map<String, GenericRecord> ancestors) {
    this.ancestors = ancestors;
  }

  public ContextualIdentityDelete identity(GenericRecord identity) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContextualIdentityDelete contextualIdentityDelete = (ContextualIdentityDelete) o;
    return Objects.equals(this.ancestors, contextualIdentityDelete.ancestors) &&
        Objects.equals(this.identity, contextualIdentityDelete.identity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ancestors, identity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextualIdentityDelete {\n");
    
    sb.append("    ancestors: ").append(toIndentedString(ancestors)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
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
