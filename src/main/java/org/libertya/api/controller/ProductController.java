package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductRepository;
import org.libertya.api.stub.iface.V10Api;
import org.libertya.api.stub.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController implements V10Api {

    private final ProductRepository repository;

    @Override
    public ResponseEntity<String> addProduct(Product body) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteProduct(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(repository.retrieveAllProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> retrieveProduct(Integer id) {
        return repository.retrieveProduct(id)
                .map(simpleMap -> new ResponseEntity<>(simpleMap, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<String> updateProduct(Product body, Integer id) {
        return null;
    }
}
