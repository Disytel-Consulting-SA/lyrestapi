package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.LocatorRepository;
import org.libertya.api.stub.iface.LocatorApi;
import org.libertya.api.stub.model.Locator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LocatorController extends AbstractController implements LocatorApi {

    private final HttpServletRequest request;

    private final LocatorRepository repository;

    @Override
    public ResponseEntity<String> addLocator(Locator body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteLocator(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Locator>> getAllLocators(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Locator> retrieveLocator(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateLocator(Integer id, Locator body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
