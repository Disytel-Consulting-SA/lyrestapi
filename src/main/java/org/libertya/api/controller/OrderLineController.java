package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrderLineRepository;
import org.libertya.api.stub.iface.OrderlineApi;
import org.libertya.api.stub.model.OrderLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderLineController extends AbstractController implements OrderlineApi {

    private final HttpServletRequest request;

    private final OrderLineRepository repository;


    @Override
    public ResponseEntity<String> addOrderLine(OrderLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteOrderLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<OrderLine>> getAllOrderLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<OrderLine> retrieveOrderLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateOrderLine(Integer id, OrderLine body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
