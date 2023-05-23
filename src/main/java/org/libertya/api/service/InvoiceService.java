package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.InvoiceLineRepository;
import org.libertya.api.repository.InvoiceRepository;
import org.libertya.api.repository.InvoiceTaxRepository;
import org.libertya.api.stub.model.InvoiceDocument;
import org.libertya.api.stub.model.InvoiceLine;
import org.libertya.api.stub.model.InvoiceTax;
import org.openXpertya.util.Trx;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invRepository;

    private final InvoiceLineRepository invLineRepository;

    private final InvoiceTaxRepository invTaxRepository;

    public String createInvoice(InvoiceDocument invoiceDocument) throws ModelException {

        // TODO!!!
        return null;
    }
}
