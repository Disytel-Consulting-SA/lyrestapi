package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.DocTypeRepository;
import org.libertya.api.stub.iface.DoctypeApi;
import org.libertya.api.stub.model.DocType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DocTypeController extends AbstractController implements DoctypeApi {

    private final HttpServletRequest request;

    private final DocTypeRepository repository;

    @Override
    public ResponseEntity<String> addDocType(DocType body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteDocType(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<DocType>> getAllDocTypes(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<DocType> retrieveDocType(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateDocType(Integer id, DocType body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
