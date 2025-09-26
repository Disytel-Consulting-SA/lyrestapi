package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.DiscountSchemaRepository;
import org.libertya.api.stub.iface.DiscountschemaApi;
import org.libertya.api.stub.model.DiscountSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DiscountSchemaController extends AbstractController implements DiscountschemaApi {

    private final HttpServletRequest request;

    private final DiscountSchemaRepository repository;

    @Override
    public ResponseEntity<String> addDiscountSchema(DiscountSchema body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteDiscountSchema(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<DiscountSchema>> getAllDiscountSchemas(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<DiscountSchema> retrieveDiscountSchema(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateDiscountSchema(Integer id, DiscountSchema body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
