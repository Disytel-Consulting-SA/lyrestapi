package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.WarehouseRepository;
import org.libertya.api.stub.iface.WarehouseApi;
import org.libertya.api.stub.model.Warehouse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WarehouseController extends AbstractController implements WarehouseApi {

    private final HttpServletRequest request;

    private final WarehouseRepository repository;

    @Override
    public ResponseEntity<String> addWarehouse(Warehouse body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteWarehouse(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Warehouse>> getAllWarehouses(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Warehouse> retrieveWarehouse(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }


    @Override
    public ResponseEntity<String> updateWarehouse(Integer id, Warehouse body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }


}
