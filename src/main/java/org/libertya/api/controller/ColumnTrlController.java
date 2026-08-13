package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ColumnTrlRepository;
import org.libertya.api.stub.iface.ColumntrlApi;
import org.libertya.api.stub.model.ColumnTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ColumnTrlController extends AbstractController implements ColumntrlApi {

    private final HttpServletRequest request;

    private final ColumnTrlRepository repository;

    @Override
    public ResponseEntity<List<ColumnTrl>> getAllColumnTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ColumnTrl> retrieveColumnTrl(Integer idColumn, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idColumn, idLanguage}));
    }
}
