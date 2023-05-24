package org.libertya.api.repository;

import org.libertya.api.stub.model.OrderTax;
import org.openXpertya.model.X_C_OrderTax;
import org.springframework.stereotype.Repository;

@Repository
public class OrderTaxRepository  extends AbstractRepository {

    public OrderTaxRepository() {
        tableName = X_C_OrderTax.Table_Name;
        iface = OrderTax::new;
    }
}
