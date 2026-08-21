package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ColumnLookupRepository;
import org.libertya.api.stub.iface.ColumnlookupApi;
import org.libertya.api.stub.model.ColumnLookupValue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ColumnLookupController implements ColumnlookupApi {

    private final ColumnLookupRepository repository;

    @Override
    public ResponseEntity<List<ColumnLookupValue>> retrieveColumnLookup(
            Integer id,
            Integer limit,
            Integer page,
            String search,
            String value) {

        List<ColumnLookupValue> values =
                repository.retrieve(
                        id,
                        limit,
                        page,
                        search,
                        value
                );

        if (values == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(values);
    }
}