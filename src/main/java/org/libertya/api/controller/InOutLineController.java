package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InOutLineRepository;
import org.libertya.api.stub.iface.InoutlineApi;
import org.libertya.api.stub.model.InOutLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InOutLineController extends AbstractController implements InoutlineApi {

    private final HttpServletRequest request;

    private final InOutLineRepository repository;


    @Override
    public ResponseEntity<String> addInOutLine(InOutLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteInOutLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<InOutLine>> getAllInOutLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<InOutLine> retrieveInOutLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateInOutLine(Integer id, InOutLine body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
