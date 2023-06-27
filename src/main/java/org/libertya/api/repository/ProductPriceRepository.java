package org.libertya.api.repository;

import org.libertya.api.stub.model.ProductPrice;
import org.openXpertya.model.X_M_ProductPrice;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPriceRepository extends AbstractRepository {

    public ProductPriceRepository() {
        tableName = X_M_ProductPrice.Table_Name;
        iface = ProductPrice::new;
        pkColumns = new String[]{"M_Product_ID", "M_PriceList_Version_ID"};
    }
}
