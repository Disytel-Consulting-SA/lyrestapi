package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductRepository;
import org.libertya.api.stub.iface.ProductApi;
import org.libertya.api.stub.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController extends AbstractController implements ProductApi {

    private final ProductRepository repository;

    @Override
    public ResponseEntity<String> addProduct(Product body) {
        return insertAction(() -> repository.insert(body));
    }

    @Override
    public ResponseEntity<String> deleteProduct(Integer id) {
        return deleteAction(() -> repository.delete(id));
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllAction(repository, filter, fields, sort, limit, offset);
    }

    @Override
    public ResponseEntity<Product> retrieveProduct(Integer id) {
        return retrieveAction(() -> repository.retrieve(id));
    }

    @Override
    public ResponseEntity<String> updateProduct(Product body, Integer id) {
        return updateAction(() -> repository.update(id, body, true));
    }

}
