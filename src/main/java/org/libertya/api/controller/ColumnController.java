package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ColumnRepository;
import org.libertya.api.stub.iface.ColumnApi;
import org.libertya.api.stub.model.Column;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ColumnController extends AbstractController implements ColumnApi {

    private final HttpServletRequest request;

    private final ColumnRepository repository;

    @Override
    public ResponseEntity<List<Column>> getAllColumns(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Column> retrieveColumn(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}