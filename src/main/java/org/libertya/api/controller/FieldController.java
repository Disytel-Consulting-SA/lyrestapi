package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.FieldRepository;
import org.libertya.api.stub.iface.FieldApi;
import org.libertya.api.stub.model.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FieldController extends AbstractController implements FieldApi {

    private final HttpServletRequest request;

    private final FieldRepository repository;

    @Override
    public ResponseEntity<List<Field>> getAllFields(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Field> retrieveField(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}