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
        return loadEntityFromPO(id, X_M_Product.Table_Name, Product::new);
    }

    public List<Product> retrieveAllProducts(String filter, String sort, Integer limit, Integer offset) {
        return retrieveAllEntities(X_M_Product.Table_Name, this::retrieveProduct, filter, sort, limit, offset);
    }

    public void deleteProduct(int id) throws ModelException, NotFoundException {
        deleteEntity(X_M_Product.Table_Name, id);
    }

    public void updateProduct(int id, Product payload, boolean ignoreNulls) throws ModelException, NotFoundException {
        updateEntity(id, X_M_Product.Table_Name, payload, ignoreNulls);
    }

    public void insertProduct(Product payload) throws ModelException {
        insertEntity(X_M_Product.Table_Name, payload);
    }
}
