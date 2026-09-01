package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.WindowSchemaRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.WindowschemaApi;
import org.libertya.api.stub.model.WindowSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequiredArgsConstructor
public class WindowSchemaController
        implements WindowschemaApi {

    private final WindowSchemaRepository repository;

    private final JWTUtils jwt;

    private final HttpServletRequest request;


    @Override
    public ResponseEntity<WindowSchema>
    retrieveWindowSchema(
            Integer id,
            String language) {

        try {

            UserInfo info =
                    jwt.infoOf(request);


            return ResponseEntity.ok(
                    repository.retrieve(
                            info,
                            id,
                            language
                    )
            );


        } catch (AuthException e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        }
    }
}