package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.WindowOptionsRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.WindowoptionsApi;
import org.libertya.api.stub.model.WindowOption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WindowOptionsController implements WindowoptionsApi {

    private final WindowOptionsRepository repository;
    private final JWTUtils jwt;
    private final HttpServletRequest request;

    @Override
    public ResponseEntity<List<WindowOption>> retrieveWindowOptions(String language) {
        try {
            UserInfo info = jwt.infoOf(request);

            if (!info.hasRole()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            return ResponseEntity.ok(repository.retrieve(language, info.getRoleID()));

        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}