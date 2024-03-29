package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductRepository;
import org.libertya.api.stub.iface.ProductApi;
import org.libertya.api.stub.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController extends AbstractController implements ProductApi {

    private final HttpServletRequest request;

    private final ProductRepository repository;

    @Override
    public ResponseEntity<String> addProduct(Product body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteProduct(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Product> retrieveProduct(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateProduct(Integer id, Product body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
