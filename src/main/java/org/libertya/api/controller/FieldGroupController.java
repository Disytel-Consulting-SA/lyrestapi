package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.FieldGroupRepository;
import org.libertya.api.stub.iface.FieldgroupApi;
import org.libertya.api.stub.model.FieldGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FieldGroupController extends AbstractController implements FieldgroupApi {

    private final HttpServletRequest request;

    private final FieldGroupRepository repository;

    @Override
    public ResponseEntity<List<FieldGroup>> getAllFieldGroups(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<FieldGroup> retrieveFieldGroup(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}