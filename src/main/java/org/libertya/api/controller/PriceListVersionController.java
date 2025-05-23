package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PriceListVersionRepository;
import org.libertya.api.stub.iface.PricelistversionApi;
import org.libertya.api.stub.model.PriceListVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PriceListVersionController extends AbstractController implements PricelistversionApi {

    private final HttpServletRequest request;

    private final PriceListVersionRepository repository;

    @Override
    public ResponseEntity<String> addPriceListVersion(PriceListVersion body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePriceListVersion(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<PriceListVersion>> getAllPriceListVersions(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<PriceListVersion> retrievePriceListVersion(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePriceListVersion(Integer id, PriceListVersion body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
