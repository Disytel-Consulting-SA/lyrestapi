package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductLinesRepository;
import org.libertya.api.stub.iface.ProductlinesApi;
import org.libertya.api.stub.model.Product;
import org.libertya.api.stub.model.ProductLines;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductLinesController extends AbstractController implements ProductlinesApi {

    private final HttpServletRequest request;

    private final ProductLinesRepository repository;

    @Override
    public ResponseEntity<String> addProductLine(ProductLines body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteProductLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<ProductLines>> getAllProductLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProductLines> retrieveProductLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateProductLine(Integer id, ProductLines body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
