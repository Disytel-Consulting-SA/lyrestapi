package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductFamiliesRepository;
import org.libertya.api.stub.iface.ProductfamiliesApi;
import org.libertya.api.stub.model.ProductFamilies;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductFamiliesController extends AbstractController implements ProductfamiliesApi {

    private final HttpServletRequest request;

    private final ProductFamiliesRepository repository;

    @Override
    public ResponseEntity<String> addProductFamily(ProductFamilies body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteProductFamily(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<ProductFamilies>> getAllProductFamilies(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProductFamilies> retrieveProductFamily(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateProductFamily(Integer id, ProductFamilies body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
