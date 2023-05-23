package org.libertya.api.repository;

import org.libertya.api.stub.model.Product;
import org.openXpertya.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends AbstractRepository {

    public ProductRepository() {
        tableName = X_M_Product.Table_Name;
        iface = Product::new;
    }

}
