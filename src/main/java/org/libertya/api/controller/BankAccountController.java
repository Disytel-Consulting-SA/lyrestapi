package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.BankAccountRepository;
import org.libertya.api.stub.iface.BankaccountApi;
import org.libertya.api.stub.model.BankAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BankAccountController extends AbstractController implements BankaccountApi {

    private final HttpServletRequest request;

    private final BankAccountRepository repository;

    @Override
    public ResponseEntity<String> addBankAccount(BankAccount body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteBankAccount(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<BankAccount>> getAllBankAccounts(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<BankAccount> retrieveBankAccount(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateBankAccount(Integer id, BankAccount body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
