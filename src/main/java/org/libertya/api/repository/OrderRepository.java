package org.libertya.api.repository;


import org.libertya.api.stub.model.Order;
import org.openXpertya.model.X_C_Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends AbstractRepository {

    public OrderRepository() {
        tableName = X_C_Order.Table_Name;
        iface = Order::new;
    }

}
