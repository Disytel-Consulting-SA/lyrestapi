package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.AllocationHdrRepository;
import org.libertya.api.service.AllocationService;
import org.libertya.api.stub.iface.AllocationApi;
import org.libertya.api.stub.model.AllocationDocument;
import org.libertya.api.stub.model.AllocationHdr;
import org.libertya.api.stub.model.AllocationNew;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AllocationController extends AbstractController implements AllocationApi {

    private final HttpServletRequest request;

    private final AllocationHdrRepository repository;

    private final AllocationService service;

    @Override
    public ResponseEntity<String> addAllocation(AllocationNew body) {
        return insertAction(request, (info) -> service.create(info, body));
    }

    @Override
    public ResponseEntity<String> deleteAllocation(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<AllocationHdr>> getAllAllocations(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllAction(request, repository, filter, fields, sort, limit, offset);
    }

    @Override
    public ResponseEntity<String> processAllocation(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }

    @Override
    public ResponseEntity<AllocationDocument> retrieveAllocation(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateAllocation(AllocationHdr body, Integer id) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
