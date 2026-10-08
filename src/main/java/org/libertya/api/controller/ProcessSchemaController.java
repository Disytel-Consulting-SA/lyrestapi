package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.ProcessSchemaRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.ProcessschemaApi;
import org.libertya.api.stub.model.ProcessSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ProcessSchemaController implements ProcessschemaApi {
    private final ProcessSchemaRepository repository;
    private final JWTUtils jwt;
    private final HttpServletRequest request;

    @Override
    @GetMapping("/v1.0/processes/{id}/schema")
    public ResponseEntity<ProcessSchema> retrieveProcessSchema(@PathVariable("id") Integer id, @RequestParam(value = "language", required = false, defaultValue = "es_AR") String language) {
        try {
            UserInfo info = jwt.infoOf(request);
            ProcessSchema schema = repository.retrieve(info, id, language);
            return schema != null ? ResponseEntity.ok(schema) : ResponseEntity.notFound().build();
        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
