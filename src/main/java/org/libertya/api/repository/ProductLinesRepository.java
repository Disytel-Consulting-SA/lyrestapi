package org.libertya.api.repository;

import org.libertya.api.stub.model.ProductLines;
import org.openXpertya.model.X_M_Product_Lines;
import org.springframework.stereotype.Repository;

@Repository
public class ProductLinesRepository extends AbstractRepository {

    public ProductLinesRepository() {
        tableName = X_M_Product_Lines.Table_Name;
        iface = ProductLines::new;
    }
}
