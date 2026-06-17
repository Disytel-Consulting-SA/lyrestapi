package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ComboLineRepository;
import org.libertya.api.stub.iface.CombolineApi;
import org.libertya.api.stub.model.ComboLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ComboLineController extends AbstractController implements CombolineApi {

    private final HttpServletRequest request;

    private final ComboLineRepository repository;

    @Override
    public ResponseEntity<String> addComboLine(ComboLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteComboLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<ComboLine>> getAllComboLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ComboLine> retrieveComboLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateComboLine(Integer id, ComboLine body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
