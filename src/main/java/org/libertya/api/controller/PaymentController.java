package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PaymentRepository;
import org.libertya.api.service.PaymentService;
import org.libertya.api.stub.iface.PaymentApi;
import org.libertya.api.stub.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentController extends AbstractController implements PaymentApi {

    private final HttpServletRequest request;

    private final PaymentRepository repository;

    private final PaymentService service;

    @Override
    public ResponseEntity<String> addPayment(Payment body) {
        return insertAction(request, (info) -> service.create(info, body));
    }

    @Override
    public ResponseEntity<String> deletePayment(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Payment>> getAllPayments(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllAction(request, repository, filter, fields, sort, limit, offset);
    }

    @Override
    public ResponseEntity<Payment> retrievePayment(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePayment(Payment body, Integer id) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processPayment(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}