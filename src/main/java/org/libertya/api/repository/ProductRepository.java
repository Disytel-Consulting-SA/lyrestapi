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

    protected final String tableName = X_M_Product.Table_Name;

    public Optional<Product> retrieveProduct(int id) {
        return retrieveProduct(id, null);
    }

    public Optional<Product> retrieveProduct(int id, String fields) {
        return loadEntityFromPO(id, tableName, fields, Product::new);
    }

    public List<Product> retrieveAllProducts(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllEntities(tableName, id -> retrieveProduct(id, fields), filter, sort, limit, offset);
    }

    public void deleteProduct(int id) throws ModelException, NotFoundException {
        deleteEntity(tableName, id);
    }

    public void updateProduct(int id, Product payload, boolean ignoreNulls) throws ModelException, NotFoundException {
        updateEntity(id, tableName, payload, ignoreNulls);
    }

    public String insertProduct(Product payload) throws ModelException {
        return insertEntity(tableName, payload);
    }
}
