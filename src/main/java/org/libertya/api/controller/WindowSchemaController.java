package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.WindowSchemaRepository;
import org.libertya.api.stub.iface.WindowschemaApi;
import org.libertya.api.stub.model.WindowSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WindowSchemaController implements WindowschemaApi {

    private final WindowSchemaRepository repository;

    @Override
    public ResponseEntity<WindowSchema> retrieveWindowSchema(Integer id) {
        return ResponseEntity.ok(repository.retrieve(id));
    }
}