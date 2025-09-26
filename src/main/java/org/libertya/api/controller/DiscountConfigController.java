package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.DiscountConfigRepository;
import org.libertya.api.stub.iface.DiscountconfigApi;
import org.libertya.api.stub.model.DiscountConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DiscountConfigController extends AbstractController implements DiscountconfigApi {

    private final HttpServletRequest request;

    private final DiscountConfigRepository repository;

    @Override
    public ResponseEntity<String> addDiscountConfig(DiscountConfig body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteDiscountConfig(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<DiscountConfig>> getAllDiscountConfigs(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<DiscountConfig> retrieveDiscountConfig(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateDiscountConfig(Integer id, DiscountConfig body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
