package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InventoryRepository;
import org.libertya.api.service.InventoryService;
import org.libertya.api.stub.iface.InventoryApi;
import org.libertya.api.stub.model.Inventory;
import org.libertya.api.stub.model.InventoryDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InventoryController extends AbstractController implements InventoryApi {

    private final HttpServletRequest request;

    private final InventoryRepository repository;

    private final InventoryService service;

    @Override
    public ResponseEntity<String> addInventory(InventoryDocument body) {
        return insertAction(request, (info) -> service.create(info, body));
    }

    @Override
    public ResponseEntity<String> deleteInventory(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Inventory>> getAllInventories(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllAction(request, repository, filter, fields, sort, limit, offset);
    }

    @Override
    public ResponseEntity<InventoryDocument> retrieveInventory(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateInventory(Inventory body, Integer id) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processInventory(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}
