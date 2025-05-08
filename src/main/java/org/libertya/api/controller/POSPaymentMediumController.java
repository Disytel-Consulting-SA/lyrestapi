package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.POSPaymentMediumRepository;
import org.libertya.api.stub.iface.PospaymentmediumApi;
import org.libertya.api.stub.model.POSPaymentMedium;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class POSPaymentMediumController extends AbstractController implements PospaymentmediumApi {

    private final HttpServletRequest request;

    private final POSPaymentMediumRepository repository;

    @Override
    public ResponseEntity<String> addPOSPaymentMedium(POSPaymentMedium body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePOSPaymentMedium(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<POSPaymentMedium>> getAllPOSPaymentMedium(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<POSPaymentMedium> retrievePOSPaymentMedium(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePOSPaymentMedium(Integer id, POSPaymentMedium body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
