package org.libertya.api.repository;

import org.libertya.api.stub.model.ProductGamas;
import org.openXpertya.model.X_M_Product_Gamas;
import org.springframework.stereotype.Repository;

@Repository
public class ProductGamasRepository extends AbstractRepository {

    public ProductGamasRepository() {
        tableName = X_M_Product_Gamas.Table_Name;
        iface = ProductGamas::new;
    }
}
