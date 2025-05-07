package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.TaxRepository;
import org.libertya.api.stub.iface.TaxApi;
import org.libertya.api.stub.model.Tax;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaxController extends AbstractController implements TaxApi {

    private final HttpServletRequest request;

    private final TaxRepository repository;

    @Override
    public ResponseEntity<String> addTax(Tax body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteTax(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Tax>> getAllTaxes(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Tax> retrieveTax(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateTax(Integer id, Tax body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
