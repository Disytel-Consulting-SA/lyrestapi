package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.WindowOptionsRepository;
import org.libertya.api.stub.iface.WindowoptionsApi;
import org.libertya.api.stub.model.WindowOption;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WindowOptionsController
        implements WindowoptionsApi {

    private final WindowOptionsRepository repository;


    @Override
    public ResponseEntity<List<WindowOption>> retrieveWindowOptions(
            String language) {

        return ResponseEntity.ok(
                repository.retrieve(
                        language
                )
        );
    }
}