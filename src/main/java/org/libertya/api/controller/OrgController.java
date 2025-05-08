package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrgRepository;
import org.libertya.api.stub.iface.OrgApi;
import org.libertya.api.stub.model.Org;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrgController extends AbstractController implements OrgApi {

    private final HttpServletRequest request;

    private final OrgRepository repository;

    @Override
    public ResponseEntity<String> addOrg(Org body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteOrg(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Org>> getAllOrgs(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Org> retrieveOrg(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateOrg(Integer id, Org body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
