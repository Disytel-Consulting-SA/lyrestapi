package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InventoryLineRepository;
import org.libertya.api.stub.iface.InventorylineApi;
import org.libertya.api.stub.model.InventoryLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InventoryLineController extends AbstractController implements InventorylineApi {

    private final HttpServletRequest request;

    private final InventoryLineRepository repository;


    @Override
    public ResponseEntity<String> addInventoryLine(InventoryLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteInventoryLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<InventoryLine>> getAllInventoryLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<InventoryLine> retrieveInventoryLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateInventoryLine(Integer id, InventoryLine body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
