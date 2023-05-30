package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.InvoiceLineRepository;
import org.libertya.api.repository.InvoiceRepository;
import org.libertya.api.repository.InvoiceTaxRepository;
import org.libertya.api.stub.model.Invoice;
import org.libertya.api.stub.model.InvoiceDocument;
import org.libertya.api.stub.model.InvoiceLine;
import org.libertya.api.stub.model.InvoiceTax;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService extends AbstractService {

    private final InvoiceRepository invRepository;

    private final InvoiceLineRepository invLineRepository;

    private final InvoiceTaxRepository invTaxRepository;

    public String createInvoice(InvoiceDocument invoiceDocument) throws ModelException {
        return super.create(invoiceDocument, invRepository);
    }

    @Override
    public Optional<InvoiceDocument> retrieve(int id) throws ModelException  {
        InvoiceDocument doc = new InvoiceDocument();

        // Cabecera
        Optional<Invoice> inv = invRepository.retrieve(id);
        if (!inv.isPresent())
            return Optional.empty();
        doc.setHeader(inv.get());

        // Lineas
        for (Object item : invLineRepository.retrieveAll("c_invoice_id="+id, null, null, null, null )) {
            doc.addLinesItem(((Optional<InvoiceLine>)item).get());
        }

        // Impuestos
        for (Object item : invTaxRepository.retrieveAll("c_invoice_id="+id, null, null, null, null )) {
            doc.addTaxesItem(((Optional<InvoiceTax>)item).get());
        }

        return Optional.of(doc);
    }


    @Override
    protected String performCreate(Object document, AbstractRepository docRepository, String trxName) throws Exception {
        InvoiceDocument invoiceDocument = (InvoiceDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(invRepository.insert(invoiceDocument.getHeader(), trxName));

        // Lineas
        for (InvoiceLine invoiceLine : invoiceDocument.getLines()) {
            invoiceLine.setCInvoiceId(id);
            invLineRepository.insert(invoiceLine, trxName);
        }

        // Impuestos
        for (InvoiceTax invoiceTax : invoiceDocument.getTaxes()) {
            invoiceTax.setCInvoiceId(id);
            invTaxRepository.insert(invoiceTax, trxName);
        }

        return Integer.toString(id);
    }





}
