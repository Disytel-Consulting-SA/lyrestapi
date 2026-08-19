package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ReferenceRepository;
import org.libertya.api.stub.iface.ReferenceApi;
import org.libertya.api.stub.model.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReferenceController extends AbstractController implements ReferenceApi {

    private final HttpServletRequest request;

    private final ReferenceRepository repository;

    @Override
    public ResponseEntity<List<Reference>> getAllReferences(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Reference> retrieveReference(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}