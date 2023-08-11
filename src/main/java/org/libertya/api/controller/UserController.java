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

    @Override
    public ResponseEntity<String> addUser(User body) {
        return insertAction(request, (info) -> service.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteUser(Integer id) {
        return deleteAction(request, (info) -> service.delete(info, id));
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
