package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CurrencyRepository;
import org.libertya.api.stub.iface.CurrencyApi;
import org.libertya.api.stub.model.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CurrencyController extends AbstractController implements CurrencyApi {

    private final HttpServletRequest request;

    private final CurrencyRepository repository;

    @Override
    public ResponseEntity<String> addCurrency(Currency body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCurrency(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Currency>> getAllCurrencies(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Currency> retrieveCurrency(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCurrency(Integer id, Currency body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
