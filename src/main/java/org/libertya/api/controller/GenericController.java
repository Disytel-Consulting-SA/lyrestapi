package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.GenericRepository;
import org.libertya.api.stub.iface.GenericApi;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.DocumentActions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Endpoint generico: CRUD y procesado sobre cualquier tabla de AD_Table. Ver docs/referencia/endpoint-generico-api.md */
@Controller
@RequiredArgsConstructor
public class GenericController extends AbstractController implements GenericApi {

    private final HttpServletRequest request;

    private final GenericRepository repository;

    @Override
    public ResponseEntity<String> addGenericRecord(String table, Map<String, Object> body) {
        return insertAction(request, (info) -> repository.insertRecord(info, table, body));
    }

    @Override
    public ResponseEntity<String> deleteGenericRecord(String table, Integer id) {
        return deleteAction(request, (info) -> repository.deleteRecord(info, table, id));
    }

    @Override
    public ResponseEntity<List<GenericRecord>> getAllGenericRecords(String table, String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request,
                (info, p) -> repository.retrieveAllRecords(info, table, p),
                (info, p) -> repository.countAllRecords(info, table, p),
                query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<DocumentActions> getGenericRecordProcessActions(String table, Integer id) {
        return retrieveAction(request, (info) -> Optional.of(repository.getDocumentActions(info, table, id)));
    }

    @Override
    public ResponseEntity<String> processGenericRecord(String table, Integer id, String action) {
        return processAction(request, (info) -> repository.processRecord(info, table, id, action));
    }

    @Override
    public ResponseEntity<GenericRecord> retrieveGenericRecord(String table, Integer id, String fields) {
        return retrieveAction(request, (info) -> repository.retrieveRecord(info, table, id, fields));
    }

    @Override
    public ResponseEntity<String> updateGenericRecord(String table, Integer id, Map<String, Object> body) {
        return updateAction(request, (info) -> repository.updateRecord(info, table, id, body));
    }
}
