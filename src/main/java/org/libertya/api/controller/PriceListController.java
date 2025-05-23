package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PriceListRepository;
import org.libertya.api.stub.iface.PricelistApi;
import org.libertya.api.stub.model.PriceList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PriceListController extends AbstractController implements PricelistApi {

    private final HttpServletRequest request;

    private final PriceListRepository repository;

    @Override
    public ResponseEntity<String> addPriceList(PriceList body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePriceList(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<PriceList>> getAllPriceLists(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<PriceList> retrievePriceList(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePriceList(Integer id, PriceList body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
