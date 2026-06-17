package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ComboRepository;
import org.libertya.api.stub.iface.ComboApi;
import org.libertya.api.stub.model.Combo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ComboController extends AbstractController implements ComboApi {

    private final HttpServletRequest request;

    private final ComboRepository repository;

    @Override
    public ResponseEntity<String> addCombo(Combo body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCombo(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Combo>> getAllCombos(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Combo> retrieveCombo(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCombo(Integer id, Combo body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
