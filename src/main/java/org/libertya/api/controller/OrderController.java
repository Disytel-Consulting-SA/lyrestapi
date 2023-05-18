package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrderRepository;
import org.libertya.api.stub.iface.OrderApi;
import org.libertya.api.stub.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController extends AbstractController implements OrderApi {

    private final OrderRepository repository;

    @Override
    public ResponseEntity<String> addOrder(Order body) {
        return insertAction(() -> repository.insertOrder(body));
    }

    @Override
    public ResponseEntity<String> deleteOrder(Integer id) {
        return deleteAction(() -> repository.deleteOrder(id));
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders(String filter, String fields, String sort, Integer limit, Integer offset) {
        return new ResponseEntity<>(repository.retrieveAllOrders(filter, fields, sort, limit, offset), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> retrieveOrder(Integer id) {
        return retrieveAction(() -> repository.retrieveOrder(id), Order.class);
    }

    @Override
    public ResponseEntity<String> updateOrder(Order body, Integer id) {
        return updateAction(() -> repository.updateOrder(id, body, true));
    }

    @Override
    public ResponseEntity<String> processOrder(Integer id, String action) {
        return processAction(() -> repository.processOrder(id, action));
    }
}
