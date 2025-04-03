package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductGamasRepository;
import org.libertya.api.stub.iface.ProductgamasApi;
import org.libertya.api.stub.model.ProductGamas;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductGamasController extends AbstractController implements ProductgamasApi {

    private final HttpServletRequest request;

    private final ProductGamasRepository repository;

    @Override
    public ResponseEntity<String> addProductGama(ProductGamas body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteProductGama(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<ProductGamas>> getAllProductGamas(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProductGamas> retrieveProductGama(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateProductGama(Integer id, ProductGamas body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
