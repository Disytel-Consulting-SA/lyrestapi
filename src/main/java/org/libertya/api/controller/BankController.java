package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.BankRepository;
import org.libertya.api.stub.iface.BankApi;
import org.libertya.api.stub.model.Bank;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BankController extends AbstractController implements BankApi {

    private final HttpServletRequest request;

    private final BankRepository repository;

    @Override
    public ResponseEntity<String> addBank(Bank body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteBank(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Bank>> getAllBanks(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Bank> retrieveBank(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateBank(Integer id, Bank body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
