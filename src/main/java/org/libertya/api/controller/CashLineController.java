package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CashLineRepository;
import org.libertya.api.stub.iface.CashlineApi;
import org.libertya.api.stub.model.CashLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CashLineController extends AbstractController implements CashlineApi {
    
    private final HttpServletRequest request;
    
    private final CashLineRepository repository;

    @Override
    public ResponseEntity<String> addCashLine(CashLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCashLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<CashLine>> getAllCashLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CashLine> retrieveCashLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCashLine(CashLine body, Integer id) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processCashLine(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}
