package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.ProductRepository;
import org.libertya.api.stub.iface.ProductApi;
import org.libertya.api.stub.model.BPartner;
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
        return null;
    }

    @Override
    public ResponseEntity<String> deleteProduct(Integer id) {
        return deleteAction(() -> repository.deleteProduct(id));
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(repository.retrieveAllProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> retrieveProduct(Integer id) {
        return retrieveAction(() -> repository.retrieveProduct(id), Product.class);
    }

    @Override
    public ResponseEntity<String> updateProduct(Product body, Integer id) {
        return null;
    }
}
