package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.DiscountSchemaBreakRepository;
import org.libertya.api.stub.iface.DiscountschemabreakApi;
import org.libertya.api.stub.model.DiscountSchemaBreak;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DiscountSchemaBreakController extends AbstractController implements DiscountschemabreakApi {

    private final HttpServletRequest request;

    private final DiscountSchemaBreakRepository repository;

    @Override
    public ResponseEntity<String> addDiscountSchemaBreak(DiscountSchemaBreak body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteDiscountSchemaBreak(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<DiscountSchemaBreak>> getAllDiscountSchemaBreaks(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<DiscountSchemaBreak> retrieveDiscountSchemaBreak(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateDiscountSchemaBreak(Integer id, DiscountSchemaBreak body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
