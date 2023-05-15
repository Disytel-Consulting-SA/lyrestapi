package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InvoiceRepository;
import org.libertya.api.stub.iface.InvoiceApi;
import org.libertya.api.stub.model.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InvoiceController extends AbstractController implements InvoiceApi {

    private final InvoiceRepository repository;

    @Override
    public ResponseEntity<String> addInvoice(Invoice body) {
        return insertAction(() -> repository.insertInvoice(body));
    }

    @Override
    public ResponseEntity<String> deleteInvoice(Integer id) {
        return deleteAction(() -> repository.deleteInvoice(id));
    }

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoices(String filter, String fields, String sort, Integer limit, Integer offset) {
        return new ResponseEntity<>(repository.retrieveAllInvoices(filter, fields, sort, limit, offset), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Invoice> retrieveInvoice(Integer id) {
        return retrieveAction(() -> repository.retrieveInvoice(id), Invoice.class);
    }

    @Override
    public ResponseEntity<String> updateInvoice(Invoice body, Integer id) {
        return updateAction(() -> repository.updateInvoice(id, body, true));
    }

    @Override
    public ResponseEntity<String> processInvoice(Integer id, String action) {
        return processAction(() -> repository.processInvoice(id, action));
    }
}
