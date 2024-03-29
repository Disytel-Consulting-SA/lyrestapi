package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InvoiceRepository;
import org.libertya.api.service.InvoiceService;
import org.libertya.api.stub.iface.InvoiceApi;
import org.libertya.api.stub.model.Invoice;
import org.libertya.api.stub.model.InvoiceDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InvoiceController extends AbstractController implements InvoiceApi {

    private final HttpServletRequest request;

    private final InvoiceRepository repository;

    private final InvoiceService service;

    @Override
    public ResponseEntity<String> addInvoice(InvoiceDocument body) {
        return insertAction(request, (info) -> service.create(info, body));
    }

    @Override
    public ResponseEntity<String> deleteInvoice(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoices(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<InvoiceDocument> retrieveInvoice(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateInvoice(Integer id, Invoice body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processInvoice(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}
