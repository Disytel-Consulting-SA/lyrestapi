package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.TaxCategoryRepository;
import org.libertya.api.stub.iface.TaxcategoryApi;
import org.libertya.api.stub.model.TaxCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaxCategoryController extends AbstractController implements TaxcategoryApi {

    private final HttpServletRequest request;

    private final TaxCategoryRepository repository;

    @Override
    public ResponseEntity<String> addTaxCategory(TaxCategory body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteTaxCategory(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<TaxCategory>> getAllTaxCategories(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<TaxCategory> retrieveTaxCategory(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateTaxCategory(Integer id, TaxCategory body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
