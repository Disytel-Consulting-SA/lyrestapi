package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrderTaxRepository;
import org.libertya.api.stub.iface.OrdertaxApi;
import org.libertya.api.stub.model.OrderTax;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderTaxController extends AbstractController implements OrdertaxApi {

    private final HttpServletRequest request;

    private final OrderTaxRepository repository;

    @Override
    public ResponseEntity<String> addOrderTax(OrderTax body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteOrderTax(Integer idOrder, Integer idTaxListVersion) {
        return deleteAction(request, (info) -> repository.delete(info, new int[]{idOrder, idTaxListVersion}));
    }

    @Override
    public ResponseEntity<List<OrderTax>> getAllOrderTaxes(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<OrderTax> retrieveOrderTax(Integer idOrder, Integer idTaxListVersion) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new int[]{idOrder, idTaxListVersion}));
    }

    @Override
    public ResponseEntity<String> updateOrderTax(Integer idOrder, Integer idTaxListVersion, OrderTax body) {
        return updateAction(request, (info) -> repository.update(info, new int[]{idOrder, idTaxListVersion}, body));
    }
}
