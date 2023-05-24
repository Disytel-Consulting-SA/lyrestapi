package org.libertya.api.repository;

import org.openXpertya.model.X_C_OrderLine;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLineRepository extends AbstractRepository {

    public OrderLineRepository() {
        tableName = X_C_OrderLine.Table_Name;
        iface = OrderLineRepository::new;
    }
}
