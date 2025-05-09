package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PaymentTermRepository;
import org.libertya.api.stub.iface.PaymenttermApi;
import org.libertya.api.stub.model.PaymentTerm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentTermController extends AbstractController implements PaymenttermApi {

    private final HttpServletRequest request;

    private final PaymentTermRepository repository;

    @Override
    public ResponseEntity<String> addPaymentTerm(PaymentTerm body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePaymentTerm(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<PaymentTerm>> getAllPaymentTerms(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<PaymentTerm> retrievePaymentTerm(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePaymentTerm(Integer id, PaymentTerm body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
