package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InvoiceTaxRepository;
import org.libertya.api.stub.iface.InvoicetaxApi;
import org.libertya.api.stub.model.InvoiceTax;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InvoiceTaxController extends AbstractController implements InvoicetaxApi {

    private final HttpServletRequest request;

    private final InvoiceTaxRepository repository;

    @Override
    public ResponseEntity<String> addInvoiceTax(InvoiceTax body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteInvoiceTax(Integer idInvoice, Integer idTaxListVersion) {
        return deleteAction(request, (info) -> repository.delete(info, new int[]{idInvoice, idTaxListVersion}));
    }

    @Override
    public ResponseEntity<List<InvoiceTax>> getAllInvoiceTaxes(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<InvoiceTax> retrieveInvoiceTax(Integer idInvoice, Integer idTaxListVersion) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new int[]{idInvoice, idTaxListVersion}));
    }

    @Override
    public ResponseEntity<String> updateInvoiceTax(Integer idInvoice, Integer idTaxListVersion, InvoiceTax body) {
        return updateAction(request, (info) -> repository.update(info, new int[]{idInvoice, idTaxListVersion}, body));
    }
}
