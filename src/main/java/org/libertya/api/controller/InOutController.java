package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InOutRepository;
import org.libertya.api.service.InOutService;
import org.libertya.api.stub.iface.InoutApi;
import org.libertya.api.stub.model.InOut;
import org.libertya.api.stub.model.InOutDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InOutController extends AbstractController implements InoutApi {

    private final HttpServletRequest request;

    private final InOutRepository repository;

    private final InOutService service;

    @Override
    public ResponseEntity<String> addInOut(InOutDocument body) {
        return insertAction(request, (info) -> service.create(info, body));
    }

    @Override
    public ResponseEntity<String> deleteInOut(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<InOut>> getAllInOuts(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<InOutDocument> retrieveInOut(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateInOut(InOut body, Integer id) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processInOut(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}
