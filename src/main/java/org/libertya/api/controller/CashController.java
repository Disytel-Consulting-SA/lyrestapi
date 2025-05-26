package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CashRepository;
import org.libertya.api.stub.iface.CashApi;
import org.libertya.api.stub.model.Cash;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CashController extends AbstractController implements CashApi {

    private final HttpServletRequest request;

    private final CashRepository repository;

    @Override
    public ResponseEntity<String> addCash(Cash body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCash(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Cash>> getAllCash(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Cash> retrieveCash(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCash(Integer id, Cash body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processCash(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }

}
