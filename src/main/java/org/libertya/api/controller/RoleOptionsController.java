package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.RoleOptionsRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.RoleoptionsApi;
import org.libertya.api.stub.model.RoleOption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleOptionsController implements RoleoptionsApi {

    private final RoleOptionsRepository repository;
    private final JWTUtils jwt;
    private final HttpServletRequest request;

    @Override
    public ResponseEntity<List<RoleOption>> retrieveRoleOptions() {
        try {
            String userName = jwt.infoOf(request).getUserName();
            return ResponseEntity.ok(repository.retrieve(userName));
        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}