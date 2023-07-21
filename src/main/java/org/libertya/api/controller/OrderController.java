package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrderRepository;
import org.libertya.api.service.OrderService;
import org.libertya.api.stub.iface.OrderApi;
import org.libertya.api.stub.model.Order;
import org.libertya.api.stub.model.OrderDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController extends AbstractController implements OrderApi {

    private final HttpServletRequest request;

    private final OrderRepository repository;

    private final OrderService service;

    @Override
    public ResponseEntity<String> addOrder(OrderDocument body) {
        return insertAction(request, (info) -> service.create(info, body));
    }

    @Override
    public ResponseEntity<String> deleteOrder(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, filter, fields, sort, limit, page);
    }

    @Override
    public ResponseEntity<OrderDocument> retrieveOrder(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateOrder(Order body, Integer id) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processOrder(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}
