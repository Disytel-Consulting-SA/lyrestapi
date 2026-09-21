package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrderRepository;
import org.libertya.api.stub.iface.OrderheaderApi;
import org.libertya.api.stub.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class OrderHeaderController extends AbstractController implements OrderheaderApi {

    private final HttpServletRequest request;

    private final OrderRepository repository;

    @Override
    public ResponseEntity<String> addOrderHeader(Order body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }
}