package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InvoiceLineRepository;
import org.libertya.api.stub.iface.InvoicelineApi;
import org.libertya.api.stub.model.InvoiceLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InvoiceLineController extends AbstractController implements InvoicelineApi {

    private final HttpServletRequest request;

    private final InvoiceLineRepository repository;


    @Override
    public ResponseEntity<String> addInvoiceLine(InvoiceLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteInvoiceLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<InvoiceLine>> getAllInvoiceLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<InvoiceLine> retrieveInvoiceLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateInvoiceLine(Integer id, InvoiceLine body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
