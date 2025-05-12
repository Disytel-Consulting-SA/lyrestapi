package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.LetraAceptaIVARepository;
import org.libertya.api.stub.iface.LetraaceptaivaApi;
import org.libertya.api.stub.model.LetraAceptaIVA;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LetraAceptaIVAController extends AbstractController implements LetraaceptaivaApi {

    private final HttpServletRequest request;

    private final LetraAceptaIVARepository repository;

    @Override
    public ResponseEntity<String> addLetraAceptaIVA(LetraAceptaIVA body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteLetraAceptaIVA(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<LetraAceptaIVA>> getAllLetraAceptaIVA(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<LetraAceptaIVA> retrieveLetraAceptaIVA(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateLetraAceptaIVA(Integer id, LetraAceptaIVA body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
