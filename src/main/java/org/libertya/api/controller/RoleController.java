package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.RoleRepository;
import org.libertya.api.stub.iface.RoleApi;
import org.libertya.api.stub.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleController extends AbstractController implements RoleApi {

    private final HttpServletRequest request;

    private final RoleRepository repository;

    @Override
    public ResponseEntity<String> addRole(Role body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteRole(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Role>> getAllRoles(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Role> retrieveRole(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateRole(Integer id, Role body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
