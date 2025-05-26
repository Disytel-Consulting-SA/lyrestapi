package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.UOMRepository;
import org.libertya.api.stub.iface.UomApi;
import org.libertya.api.stub.model.UOM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UOMController extends AbstractController implements UomApi {

    private final HttpServletRequest request;

    private final UOMRepository repository;

    @Override
    public ResponseEntity<String> addUOM(UOM body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteUOM(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<UOM>> getAllUOMs(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<UOM> retrieveUOM(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateUOM(Integer id, UOM body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
