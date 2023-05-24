package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.InvoiceLineRepository;
import org.libertya.api.repository.InvoiceRepository;
import org.libertya.api.repository.InvoiceTaxRepository;
import org.libertya.api.stub.model.InvoiceDocument;
import org.libertya.api.stub.model.InvoiceLine;
import org.libertya.api.stub.model.InvoiceTax;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService extends AbstractService{

    private final InvoiceRepository invRepository;

    private final InvoiceLineRepository invLineRepository;

    private final InvoiceTaxRepository invTaxRepository;

    public String createInvoice(InvoiceDocument invoiceDocument) throws ModelException {
        return super.create(invoiceDocument, invRepository);
    }

    @Override
    public String perform(Object document, AbstractRepository docRepository, String trxName) throws Exception {
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
