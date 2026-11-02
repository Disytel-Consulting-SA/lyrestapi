package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.CreditCardSettlementChild;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditCardSettlementCreated
 */
@Validated



public class CreditCardSettlementCreated   {
  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("c_creditcardcouponfilter_id")
  private Integer cCreditcardcouponfilterId = null;

  @JsonProperty("children")
  @Valid
  private List<CreditCardSettlementChild> children = null;

  public CreditCardSettlementCreated cCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
    return this;
  }

  /**
   * ID de la liquidacion creada
   * @return cCreditcardsettlementId
   **/
  @Schema(description = "ID de la liquidacion creada")
  
    public Integer getCCreditcardsettlementId() {
    return cCreditcardsettlementId;
  }

  public void setCCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
  }

  public CreditCardSettlementCreated cCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
    return this;
  }

  /**
   * ID del filtro por defecto creado, del cual deben colgarse los cupones
   * @return cCreditcardcouponfilterId
   **/
  @Schema(description = "ID del filtro por defecto creado, del cual deben colgarse los cupones")
  
    public Integer getCCreditcardcouponfilterId() {
    return cCreditcardcouponfilterId;
  }

  public void setCCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
  }

  public CreditCardSettlementCreated children(List<CreditCardSettlementChild> children) {
    this.children = children;
    return this;
  }

  public CreditCardSettlementCreated addChildrenItem(CreditCardSettlementChild childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * Filas hijas que genero el modelo de Libertya por si solo (generateAllChildrens): una fila en cero por cada impuesto, esquema de retencion aplicable y concepto de liquidacion configurado como maestro en el ERP. Se devuelven para ahorrar un GET por liquidacion. 
   * @return children
   **/
  @Schema(description = "Filas hijas que genero el modelo de Libertya por si solo (generateAllChildrens): una fila en cero por cada impuesto, esquema de retencion aplicable y concepto de liquidacion configurado como maestro en el ERP. Se devuelven para ahorrar un GET por liquidacion. ")
      @Valid
    public List<CreditCardSettlementChild> getChildren() {
    return children;
  }

  public void setChildren(List<CreditCardSettlementChild> children) {
    this.children = children;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCardSettlementCreated creditCardSettlementCreated = (CreditCardSettlementCreated) o;
    return Objects.equals(this.cCreditcardsettlementId, creditCardSettlementCreated.cCreditcardsettlementId) &&
        Objects.equals(this.cCreditcardcouponfilterId, creditCardSettlementCreated.cCreditcardcouponfilterId) &&
        Objects.equals(this.children, creditCardSettlementCreated.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cCreditcardsettlementId, cCreditcardcouponfilterId, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardSettlementCreated {\n");
    
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    cCreditcardcouponfilterId: ").append(toIndentedString(cCreditcardcouponfilterId)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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
