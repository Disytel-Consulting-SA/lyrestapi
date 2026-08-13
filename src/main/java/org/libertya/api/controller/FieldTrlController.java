package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.FieldTrlRepository;
import org.libertya.api.stub.iface.FieldtrlApi;
import org.libertya.api.stub.model.FieldTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FieldTrlController extends AbstractController implements FieldtrlApi {

    private final HttpServletRequest request;

    private final FieldTrlRepository repository;

    @Override
    public ResponseEntity<List<FieldTrl>> getAllFieldTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<FieldTrl> retrieveFieldTrl(Integer idField, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idField, idLanguage}));
    }
}
