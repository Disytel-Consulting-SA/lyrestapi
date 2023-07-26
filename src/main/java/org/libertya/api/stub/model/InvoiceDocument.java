package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Invoice;
import org.libertya.api.stub.model.InvoiceLine;
import org.libertya.api.stub.model.InvoiceTax;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InvoiceDocument
 */
@Validated



public class InvoiceDocument   {
  @JsonProperty("header")
  private Invoice header = null;

  @JsonProperty("lines")
  @Valid
  private List<InvoiceLine> lines = null;

  @JsonProperty("taxes")
  @Valid
  private List<InvoiceTax> taxes = null;

  public InvoiceDocument header(Invoice header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
   **/
  @Schema(description = "")
  
    @Valid
    public Invoice getHeader() {
    return header;
  }

  public void setHeader(Invoice header) {
    this.header = header;
  }

  public InvoiceDocument lines(List<InvoiceLine> lines) {
    this.lines = lines;
    return this;
  }

  public InvoiceDocument addLinesItem(InvoiceLine linesItem) {
    if (this.lines == null) {
      this.lines = new ArrayList<>();
    }
    this.lines.add(linesItem);
    return this;
  }

  /**
   * Get lines
   * @return lines
   **/
  @Schema(description = "")
      @Valid
    public List<InvoiceLine> getLines() {
    return lines;
  }

  public void setLines(List<InvoiceLine> lines) {
    this.lines = lines;
  }

  public InvoiceDocument taxes(List<InvoiceTax> taxes) {
    this.taxes = taxes;
    return this;
  }

  public InvoiceDocument addTaxesItem(InvoiceTax taxesItem) {
    if (this.taxes == null) {
      this.taxes = new ArrayList<>();
    }
    this.taxes.add(taxesItem);
    return this;
  }

  /**
   * Get taxes
   * @return taxes
   **/
  @Schema(description = "")
      @Valid
    public List<InvoiceTax> getTaxes() {
    return taxes;
  }

  public void setTaxes(List<InvoiceTax> taxes) {
    this.taxes = taxes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceDocument invoiceDocument = (InvoiceDocument) o;
    return Objects.equals(this.header, invoiceDocument.header) &&
        Objects.equals(this.lines, invoiceDocument.lines) &&
        Objects.equals(this.taxes, invoiceDocument.taxes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, lines, taxes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceDocument {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    lines: ").append(toIndentedString(lines)).append("\n");
    sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
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
