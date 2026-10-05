package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.DocumentAction;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DocumentActions
 */
@Validated



public class DocumentActions   {
  @JsonProperty("docStatus")
  private String docStatus = null;

  @JsonProperty("defaultAction")
  private String defaultAction = null;

  @JsonProperty("actions")
  @Valid
  private List<DocumentAction> actions = new ArrayList<>();

  public DocumentActions docStatus(String docStatus) {
    this.docStatus = docStatus;
    return this;
  }

  /**
   * Estado actual del documento
   * @return docStatus
   **/
  @Schema(example = "DR", required = true, description = "Estado actual del documento")
      @NotNull

    public String getDocStatus() {
    return docStatus;
  }

  public void setDocStatus(String docStatus) {
    this.docStatus = docStatus;
  }

  public DocumentActions defaultAction(String defaultAction) {
    this.defaultAction = defaultAction;
    return this;
  }

  /**
   * Accion sugerida por CORE entre las acciones actualmente disponibles
   * @return defaultAction
   **/
  @Schema(example = "CO", description = "Accion sugerida por CORE entre las acciones actualmente disponibles")
  
    public String getDefaultAction() {
    return defaultAction;
  }

  public void setDefaultAction(String defaultAction) {
    this.defaultAction = defaultAction;
  }

  public DocumentActions actions(List<DocumentAction> actions) {
    this.actions = actions;
    return this;
  }

  public DocumentActions addActionsItem(DocumentAction actionsItem) {
    this.actions.add(actionsItem);
    return this;
  }

  /**
   * Acciones actualmente disponibles y soportadas por la API
   * @return actions
   **/
  @Schema(required = true, description = "Acciones actualmente disponibles y soportadas por la API")
      @NotNull
    @Valid
    public List<DocumentAction> getActions() {
    return actions;
  }

  public void setActions(List<DocumentAction> actions) {
    this.actions = actions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentActions documentActions = (DocumentActions) o;
    return Objects.equals(this.docStatus, documentActions.docStatus) &&
        Objects.equals(this.defaultAction, documentActions.defaultAction) &&
        Objects.equals(this.actions, documentActions.actions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docStatus, defaultAction, actions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentActions {\n");
    
    sb.append("    docStatus: ").append(toIndentedString(docStatus)).append("\n");
    sb.append("    defaultAction: ").append(toIndentedString(defaultAction)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
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
