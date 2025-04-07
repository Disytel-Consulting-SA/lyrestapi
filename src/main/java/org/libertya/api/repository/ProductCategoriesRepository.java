package org.libertya.api.repository;

import org.libertya.api.stub.model.ProductCategories;
import org.openXpertya.model.X_M_Product_Category;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCategoriesRepository extends AbstractRepository {

    public ProductCategoriesRepository() {
        tableName = X_M_Product_Category.Table_Name;
        iface = ProductCategories::new;
    }
}
