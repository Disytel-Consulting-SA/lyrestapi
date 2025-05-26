package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ConversionRateRepository;
import org.libertya.api.stub.iface.ConversionrateApi;
import org.libertya.api.stub.model.ConversionRate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ConversionRateController extends AbstractController implements ConversionrateApi {

    private final HttpServletRequest request;

    private final ConversionRateRepository repository;

    @Override
    public ResponseEntity<String> addConversionRate(ConversionRate body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteConversionRate(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<ConversionRate>> getAllConversionRates(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ConversionRate> retrieveConversionRate(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateConversionRate(Integer id, ConversionRate body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
