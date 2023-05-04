package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.Product;
import org.openXpertya.model.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository @RequiredArgsConstructor
public class ProductRepository extends AbstractRepository {

    public Optional<Product> retrieveProduct(int id) {
        return retrieveEntity(id, X_M_Product.Table_Name, Product::new);
    }

    public List<Product> retrieveAllProducts() {
        return retrieveAllEntities(X_M_Product.Table_Name, this::retrieveProduct);
    }

    public void deleteProduct(int id) throws ModelException, NotFoundException {
        deleteEntity(X_M_Product.Table_Name, id);
    }

}
