package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
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

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService extends AbstractService {

    private final InvoiceRepository invRepository;

    private final InvoiceLineRepository invLineRepository;

    private final InvoiceTaxRepository invTaxRepository;

    @Override
    protected AbstractRepository getRepository() {
        return invRepository;
    }

    @Override
    protected Optional<InvoiceDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        InvoiceDocument doc = new InvoiceDocument();

        // Cabecera
        Optional<Invoice> inv = invRepository.retrieve(info, id);
        if (!inv.isPresent())
            return Optional.empty();
        doc.setHeader(inv.get());

        // Lineas
        for (Object item : invLineRepository.retrieveAll(info,"c_invoice_id="+id, null, null, null, null )) {
            doc.addLinesItem(((Optional<InvoiceLine>)item).get());
        }

        // Impuestos
        for (Object item : invTaxRepository.retrieveAll(info, "c_invoice_id="+id, null, null, null, null )) {
            doc.addTaxesItem(((Optional<InvoiceTax>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected String performCreate(UserInfo info, Object document, AbstractRepository docRepository, String trxName) throws Exception {
        InvoiceDocument invoiceDocument = (InvoiceDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(invRepository.insert(info, invoiceDocument.getHeader(), trxName));

        // Lineas
        for (InvoiceLine invoiceLine : getList(invoiceDocument.getLines())) {
            invoiceLine.setCInvoiceId(id);
            invLineRepository.insert(info, invoiceLine, trxName);
        }

        // Impuestos
        for (InvoiceTax invoiceTax : getList(invoiceDocument.getTaxes())) {
            invoiceTax.setCInvoiceId(id);
            invTaxRepository.insert(info, invoiceTax, trxName);
        }

        return Integer.toString(id);
    }



}
