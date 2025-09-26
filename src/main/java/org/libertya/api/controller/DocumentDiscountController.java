package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.DocumentDiscountRepository;
import org.libertya.api.stub.iface.DocumentdiscountApi;
import org.libertya.api.stub.model.DocumentDiscount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DocumentDiscountController extends AbstractController implements DocumentdiscountApi {

    private final HttpServletRequest request;

    private final DocumentDiscountRepository repository;

    @Override
    public ResponseEntity<String> addDocumentDiscount(DocumentDiscount body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteDocumentDiscount(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<DocumentDiscount>> getAllDocumentDiscounts(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<DocumentDiscount> retrieveDocumentDiscount(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateDocumentDiscount(Integer id, DocumentDiscount body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
