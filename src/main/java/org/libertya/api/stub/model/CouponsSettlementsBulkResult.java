package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.CouponsSettlementsItemResult;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CouponsSettlementsBulkResult
 */
@Validated



public class CouponsSettlementsBulkResult   {
  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("creados")
  private Integer creados = null;

  @JsonProperty("ya_existian")
  private Integer yaExistian = null;

  @JsonProperty("conflictos")
  private Integer conflictos = null;

  @JsonProperty("resultados")
  @Valid
  private List<CouponsSettlementsItemResult> resultados = null;

  public CouponsSettlementsBulkResult cCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
    return this;
  }

  /**
   * Liquidacion sobre la que se opero
   * @return cCreditcardsettlementId
   **/
  @Schema(description = "Liquidacion sobre la que se opero")
  
    public Integer getCCreditcardsettlementId() {
    return cCreditcardsettlementId;
  }

  public void setCCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
  }

  public CouponsSettlementsBulkResult creados(Integer creados) {
    this.creados = creados;
    return this;
  }

  /**
   * Cantidad de cupones efectivamente creados
   * @return creados
   **/
  @Schema(description = "Cantidad de cupones efectivamente creados")
  
    public Integer getCreados() {
    return creados;
  }

  public void setCreados(Integer creados) {
    this.creados = creados;
  }

  public CouponsSettlementsBulkResult yaExistian(Integer yaExistian) {
    this.yaExistian = yaExistian;
    return this;
  }

  /**
   * Cantidad de cupones que ya estaban colgados de esta misma liquidacion
   * @return yaExistian
   **/
  @Schema(description = "Cantidad de cupones que ya estaban colgados de esta misma liquidacion")
  
    public Integer getYaExistian() {
    return yaExistian;
  }

  public void setYaExistian(Integer yaExistian) {
    this.yaExistian = yaExistian;
  }

  public CouponsSettlementsBulkResult conflictos(Integer conflictos) {
    this.conflictos = conflictos;
    return this;
  }

  /**
   * Cantidad de cupones rechazados por el modelo (R6/R7) o por error
   * @return conflictos
   **/
  @Schema(description = "Cantidad de cupones rechazados por el modelo (R6/R7) o por error")
  
    public Integer getConflictos() {
    return conflictos;
  }

  public void setConflictos(Integer conflictos) {
    this.conflictos = conflictos;
  }

  public CouponsSettlementsBulkResult resultados(List<CouponsSettlementsItemResult> resultados) {
    this.resultados = resultados;
    return this;
  }

  public CouponsSettlementsBulkResult addResultadosItem(CouponsSettlementsItemResult resultadosItem) {
    if (this.resultados == null) {
      this.resultados = new ArrayList<>();
    }
    this.resultados.add(resultadosItem);
    return this;
  }

  /**
   * Un resultado por cada cupon enviado, en el mismo orden
   * @return resultados
   **/
  @Schema(description = "Un resultado por cada cupon enviado, en el mismo orden")
      @Valid
    public List<CouponsSettlementsItemResult> getResultados() {
    return resultados;
  }

  public void setResultados(List<CouponsSettlementsItemResult> resultados) {
    this.resultados = resultados;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponsSettlementsBulkResult couponsSettlementsBulkResult = (CouponsSettlementsBulkResult) o;
    return Objects.equals(this.cCreditcardsettlementId, couponsSettlementsBulkResult.cCreditcardsettlementId) &&
        Objects.equals(this.creados, couponsSettlementsBulkResult.creados) &&
        Objects.equals(this.yaExistian, couponsSettlementsBulkResult.yaExistian) &&
        Objects.equals(this.conflictos, couponsSettlementsBulkResult.conflictos) &&
        Objects.equals(this.resultados, couponsSettlementsBulkResult.resultados);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cCreditcardsettlementId, creados, yaExistian, conflictos, resultados);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponsSettlementsBulkResult {\n");
    
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    creados: ").append(toIndentedString(creados)).append("\n");
    sb.append("    yaExistian: ").append(toIndentedString(yaExistian)).append("\n");
    sb.append("    conflictos: ").append(toIndentedString(conflictos)).append("\n");
    sb.append("    resultados: ").append(toIndentedString(resultados)).append("\n");
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
