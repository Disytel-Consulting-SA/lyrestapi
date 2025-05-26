package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CashBookRepository;
import org.libertya.api.stub.iface.CashbookApi;
import org.libertya.api.stub.model.CashBook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CashBookController extends AbstractController implements CashbookApi {

    private final HttpServletRequest request;

    private final CashBookRepository repository;

    @Override
    public ResponseEntity<String> addCashBook(CashBook body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCashBook(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<CashBook>> getAllCashBooks(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CashBook> retrieveCashBook(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCashBook(Integer id, CashBook body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
