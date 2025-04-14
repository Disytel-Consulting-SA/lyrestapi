package org.libertya.api.repository;

import org.libertya.api.stub.model.ProductFamilies;
import org.openXpertya.model.X_M_Product_Family;
import org.springframework.stereotype.Repository;

@Repository
public class ProductFamiliesRepository extends AbstractRepository {

    public ProductFamiliesRepository() {
        tableName = X_M_Product_Family.Table_Name;
        iface = ProductFamilies::new;
    }
}
