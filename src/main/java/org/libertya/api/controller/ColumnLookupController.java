package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.ColumnLookupRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.ColumnlookupApi;
import org.libertya.api.stub.model.ColumnLookupValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class ColumnLookupController
        implements ColumnlookupApi {

    private final ColumnLookupRepository repository;

    private final JWTUtils jwt;

    private final HttpServletRequest request;


    @Override
    public ResponseEntity<List<ColumnLookupValue>>
    retrieveColumnLookup(
            Integer id,
            Integer limit,
            Integer page,
            String search,
            String value) {

        try {

            /*
             * Recuperar contexto del request.
             *
             * clientID y orgID provienen del JWT.
             */
            UserInfo info =
                    jwt.infoOf(request);


            List<ColumnLookupValue> values =
                    repository.retrieve(
                            info,
                            id,
                            limit,
                            page,
                            search,
                            value
                    );


            if (values == null) {

                return ResponseEntity
                        .notFound()
                        .build();
            }


            return ResponseEntity.ok(
                    values
            );


        } catch (AuthException e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        }
    }
}