package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.UserRoleRepository;
import org.libertya.api.stub.iface.UserroleApi;
import org.libertya.api.stub.model.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserRoleController extends AbstractController implements UserroleApi {

    private final HttpServletRequest request;

    private final UserRoleRepository repository;

    @Override
    public ResponseEntity<String> addUserRole(UserRole body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteUserRole(Integer idUser, Integer idRole) {
        return deleteAction(request, (info) -> repository.delete(info, new int[]{idUser, idRole}));
    }

    @Override
    public ResponseEntity<List<UserRole>> getAllUserRoles(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<UserRole> retrieveUserRole(Integer idUser, Integer idRole) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new int[]{idUser, idRole}));
    }

    @Override
    public ResponseEntity<String> updateUserRole(Integer idUser, Integer idRole, UserRole body) {
        return updateAction(request, (info) -> repository.update(info, new int[]{idUser, idRole}, body));
    }
}
