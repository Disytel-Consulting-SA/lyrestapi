package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.WindowRecordRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.WindowrecordsApi;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.ContextualRecordWrite;
import org.libertya.api.stub.model.WindowRecordQuery;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WindowRecordController implements WindowrecordsApi {

    private final JWTUtils jwt;
    private final HttpServletRequest request;
    private final WindowRecordRepository repository;

    @Override
    public ResponseEntity<List<GenericRecord>> getTabRecords(
            Integer id,
            WindowRecordQuery body) {

        try {
            UserInfo info = jwt.infoOf(request);

            WindowRecordQuery query =
                    body != null ? body : new WindowRecordQuery();

            List<GenericRecord> records =
                    repository.retrieveTabRecords(info, id, query);

            HttpHeaders headers = new HttpHeaders();

            if (Boolean.TRUE.equals(query.isIncludeTotal())) {
                int total =
                        repository.countTabRecords(info, id, query);

                headers.add(
                        "X-Total-Count",
                        String.valueOf(total)
                );
            }

            return new ResponseEntity<>(
                    records,
                    headers,
                    HttpStatus.OK
            );

        } catch (NotFoundException e) {
            return error(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (AuthException e) {
            return error(e.getMessage(), HttpStatus.UNAUTHORIZED);

        } catch (SecurityException e) {
            return error(e.getMessage(), HttpStatus.FORBIDDEN);

        } catch (ModelException e) {
            return error(e.getMessage(), HttpStatus.CONFLICT);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /**
     * Operaciones contextuales para registros existentes.
     * El body separa los valores del registro del contexto maestro/detalle.
     */
    @Override
    public ResponseEntity<String> insertContextualRecord(Integer tabId,
            ContextualRecordWrite body) {
        try {
            if (body == null || body.getValues() == null || body.getValues().isEmpty())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Debe indicar los valores del nuevo registro");
            String id = repository.insertTabRecord(jwt.infoOf(request), tabId,
                    body.getParentValues(), body.getValues());
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (AuthException | SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (ModelException | IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> updateContextualRecord(Integer tabId,
            Integer recordId, ContextualRecordWrite body) {
        try {
            if (body == null || body.getValues() == null || body.getValues().isEmpty())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Debe indicar al menos un campo para actualizar");
            repository.updateTabRecord(jwt.infoOf(request), tabId, recordId,
                    body.getParentValues(), body.getValues());
            return ResponseEntity.ok("OK");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (AuthException | SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (ModelException | IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteContextualRecord(Integer tabId,
            Integer recordId, @RequestBody(required = false) Map<String, String> parentValues) {
        try {
            repository.deleteTabRecord(jwt.infoOf(request), tabId, recordId, parentValues);
            return ResponseEntity.ok("OK");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (AuthException | SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (ModelException | IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @SuppressWarnings({
            "rawtypes",
            "unchecked"
    })
    private ResponseEntity<List<GenericRecord>> error(
            String message,
            HttpStatus status) {

        List error = new ArrayList();
        error.add(message);

        return new ResponseEntity<>(
                error,
                status
        );
    }
}