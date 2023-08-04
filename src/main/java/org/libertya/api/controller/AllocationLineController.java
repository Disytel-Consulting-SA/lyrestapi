package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.AllocationLineRepository;
import org.libertya.api.stub.iface.AllocationlineApi;
import org.libertya.api.stub.model.AllocationLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AllocationLineController extends AbstractController implements AllocationlineApi {

    private final HttpServletRequest request;

    private final AllocationLineRepository repository;

    @Override
    public ResponseEntity<String> addAllocationLine(AllocationLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteAllocationLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<AllocationLine>> getAllAllocationLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<AllocationLine> retrieveAllocationLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateAllocationLine(Integer id, AllocationLine body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
