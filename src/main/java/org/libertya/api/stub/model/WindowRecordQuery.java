package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Parametros para consultar los registros pertenecientes a una pestana dinamica de Libertya. 
 */
@Schema(description = "Parametros para consultar los registros pertenecientes a una pestana dinamica de Libertya. ")
@Validated



public class WindowRecordQuery   {
  @JsonProperty("parent_values")
  @Valid
  private Map<String, String> parentValues = null;

  @JsonProperty("filter")
  private String filter = null;

  @JsonProperty("fields")
  private String fields = null;

  @JsonProperty("sort")
  private String sort = null;

  @JsonProperty("limit")
  private Integer limit = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("include_total")
  private Boolean includeTotal = false;

  public WindowRecordQuery parentValues(Map<String, String> parentValues) {
    this.parentValues = parentValues;
    return this;
  }

  public WindowRecordQuery putParentValuesItem(String key, String parentValuesItem) {
    if (this.parentValues == null) {
      this.parentValues = new HashMap<>();
    }
    this.parentValues.put(key, parentValuesItem);
    return this;
  }

  /**
   * Valores provenientes del registro padre para pestanas master/detail, indexados por nombre de columna. Los valores se representan uniformemente como strings. 
   * @return parentValues
   **/
  @Schema(description = "Valores provenientes del registro padre para pestanas master/detail, indexados por nombre de columna. Los valores se representan uniformemente como strings. ")
  
    public Map<String, String> getParentValues() {
    return parentValues;
  }

  public void setParentValues(Map<String, String> parentValues) {
    this.parentValues = parentValues;
  }

  public WindowRecordQuery filter(String filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Criterio adicional de filtrado. Este filtro se aplica sobre el universo de registros definido por la pestana y nunca reemplaza las restricciones de metadata o de acceso. 
   * @return filter
   **/
  @Schema(description = "Criterio adicional de filtrado. Este filtro se aplica sobre el universo de registros definido por la pestana y nunca reemplaza las restricciones de metadata o de acceso. ")
  
    public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public WindowRecordQuery fields(String fields) {
    this.fields = fields;
    return this;
  }

  /**
   * Campos a recuperar.
   * @return fields
   **/
  @Schema(description = "Campos a recuperar.")
  
    public String getFields() {
    return fields;
  }

  public void setFields(String fields) {
    this.fields = fields;
  }

  public WindowRecordQuery sort(String sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Criterio de ordenado. Si no se especifica se utiliza el OrderByClause definido por la pestana. 
   * @return sort
   **/
  @Schema(description = "Criterio de ordenado. Si no se especifica se utiliza el OrderByClause definido por la pestana. ")
  
    public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public WindowRecordQuery limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Limite de elementos a retornar por pagina.
   * @return limit
   **/
  @Schema(description = "Limite de elementos a retornar por pagina.")
  
    public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public WindowRecordQuery page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Numero de pagina.
   * @return page
   **/
  @Schema(description = "Numero de pagina.")
  
    public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public WindowRecordQuery includeTotal(Boolean includeTotal) {
    this.includeTotal = includeTotal;
    return this;
  }

  /**
   * Indica si debe calcularse el total de registros que cumplen las condiciones de la consulta. 
   * @return includeTotal
   **/
  @Schema(description = "Indica si debe calcularse el total de registros que cumplen las condiciones de la consulta. ")
  
    public Boolean isIncludeTotal() {
    return includeTotal;
  }

  public void setIncludeTotal(Boolean includeTotal) {
    this.includeTotal = includeTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WindowRecordQuery windowRecordQuery = (WindowRecordQuery) o;
    return Objects.equals(this.parentValues, windowRecordQuery.parentValues) &&
        Objects.equals(this.filter, windowRecordQuery.filter) &&
        Objects.equals(this.fields, windowRecordQuery.fields) &&
        Objects.equals(this.sort, windowRecordQuery.sort) &&
        Objects.equals(this.limit, windowRecordQuery.limit) &&
        Objects.equals(this.page, windowRecordQuery.page) &&
        Objects.equals(this.includeTotal, windowRecordQuery.includeTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentValues, filter, fields, sort, limit, page, includeTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WindowRecordQuery {\n");
    
    sb.append("    parentValues: ").append(toIndentedString(parentValues)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    includeTotal: ").append(toIndentedString(includeTotal)).append("\n");
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
