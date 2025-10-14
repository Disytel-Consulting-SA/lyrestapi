package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.POSLetterRepository;
import org.libertya.api.stub.iface.PosletterApi;
import org.libertya.api.stub.model.POSLetter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class POSLetterController extends AbstractController implements PosletterApi {

    private final HttpServletRequest request;

    private final POSLetterRepository repository;

    @Override
    public ResponseEntity<String> addPOSLetter(POSLetter body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePOSLetter(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<POSLetter>> getAllPOSLetters(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<POSLetter> retrievePOSLetter(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePOSLetter(Integer id, POSLetter body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
