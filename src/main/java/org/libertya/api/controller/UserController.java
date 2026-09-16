package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.UserRepository;
import org.libertya.api.service.UserService;
import org.libertya.api.stub.iface.UserApi;
import org.libertya.api.stub.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController extends AbstractController implements UserApi {

    private final HttpServletRequest request;

    private final UserService service;

    private final UserRepository repository;

    @Override
    public ResponseEntity<String> addUser(User body) {
        return insertAction(request, (info) -> service.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteUser(Integer id) {
        return deleteAction(request, (info) -> service.delete(info, id));
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<User> retrieveUser(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateUser(Integer id, User body) {
        return updateAction(request, (info) -> service.update(info, id, body));
    }


}
