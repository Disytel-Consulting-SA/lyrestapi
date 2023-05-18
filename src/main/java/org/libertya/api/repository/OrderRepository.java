package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.Order;
import org.openXpertya.model.X_C_Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepository extends AbstractRepository {

    protected final String tableName = X_C_Order.Table_Name;

    public Optional<Order> retrieveOrder(int id) {
        return loadEntityFromPO(id, tableName, null, Order::new);
    }

    public Optional<Order> retrieveOrder(int id, String fields) {
        return loadEntityFromPO(id, tableName, fields, Order::new);
    }

    public List<Order> retrieveAllOrders(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllEntities(tableName, id -> retrieveOrder(id, fields), filter, sort, limit, offset);
    }

    public void deleteOrder(int id) throws ModelException, NotFoundException {
        deleteEntity(tableName, id);
    }

    public void updateOrder(int id, Order payload, boolean ignoreNulls) throws ModelException, NotFoundException {
        updateEntity(id, tableName, payload, ignoreNulls);
    }

    public String insertOrder(Order payload) throws ModelException {
        return insertEntity(tableName, payload);
    }

    public String processOrder(int id, String action) throws ModelException, NotFoundException {
        return processEntity(tableName, id, action);
    }
}
