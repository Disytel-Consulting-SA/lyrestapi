package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.POSRepository;
import org.libertya.api.stub.iface.PosApi;
import org.libertya.api.stub.model.POS;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class POSController extends AbstractController implements PosApi {

    private final HttpServletRequest request;

    private final POSRepository repository;

    @Override
   public ResponseEntity<String> addPOS(POS body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePOS(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<POS>> getAllPOS(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<POS> retrievePOS(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePOS(Integer id, POS body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
