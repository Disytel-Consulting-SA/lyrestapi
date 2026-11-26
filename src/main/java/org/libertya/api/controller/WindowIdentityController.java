package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.WindowRecordRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.WindowidentityApi;
import org.libertya.api.stub.model.ContextualIdentityInsert;
import org.libertya.api.stub.model.ContextualIdentityUpdate;
import org.libertya.api.stub.model.ContextualIdentityDelete;
import org.libertya.api.stub.model.GenericRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WindowIdentityController extends AbstractController implements WindowidentityApi {

    private final HttpServletRequest request;
    private final WindowRecordRepository repository;
    private final JWTUtils identityJwt;

    @Override
    public ResponseEntity<GenericRecord> insertContextualRecordByIdentity(Integer tabId, ContextualIdentityInsert body) {
        return execute(HttpStatus.CREATED, info -> {
            if (body == null)
                throw new ModelException("Se requiere contexto y valores");
            GenericRecord result = new GenericRecord();
            result.putAll(repository.insertTabRecordByIdentity(info, tabId, ancestors(body.getAncestors()), body.getValues()));
            return result;
        });
    }

    @Override
    public ResponseEntity<Void> updateContextualRecordByIdentity(Integer tabId, ContextualIdentityUpdate body) {
        return execute(HttpStatus.NO_CONTENT, info -> {
            if (body == null)
                throw new ModelException("Se requiere contexto, identidad y valores");
            repository.updateTabRecordByIdentity(info, tabId, body.getIdentity(), ancestors(body.getAncestors()), body.getValues());
            return null;
        });
    }

    @Override
    public ResponseEntity<Void> deleteContextualRecordByIdentity(Integer tabId, ContextualIdentityDelete body) {
        return execute(HttpStatus.NO_CONTENT, info -> {
            if (body == null)
                throw new ModelException("Se requiere contexto e identidad");
            repository.deleteTabRecordByIdentity(info, tabId, body.getIdentity(), ancestors(body.getAncestors()));
            return null;
        });
    }

    private Map<Integer, GenericRecord> ancestors(Map<String, GenericRecord> source) throws ModelException {
        if (source == null)
            throw new ModelException("Se requiere el contexto ancestral");
        Map<Integer, GenericRecord> result = new LinkedHashMap<>();
        for (Map.Entry<String, GenericRecord> entry : source.entrySet()) {
            String key = entry.getKey();
            if (key == null || !key.matches("[1-9][0-9]*") || entry.getValue() == null || entry.getValue().isEmpty())
                throw new ModelException("Identidad ancestral inválida");
            int tabId = Integer.parseInt(key);
            if (result.putIfAbsent(tabId, entry.getValue()) != null)
                throw new ModelException("Identificador de pestaña ancestral duplicado");
        }
        return result;
    }

    @FunctionalInterface
    private interface ContextualWork<T> {
        T execute(UserInfo info) throws ModelException, NotFoundException, AuthException;
    }

    private <T> ResponseEntity<T> execute(HttpStatus success, ContextualWork<T> work) {
        try {
            T result = work.execute(identityJwt.infoOf(request));
            return ResponseEntity.status(success).body(result);
        } catch (NotFoundException e) {
            return error(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (AuthException | SecurityException e) {
            return error(HttpStatus.FORBIDDEN, e.getMessage());
        } catch (ModelException | IllegalArgumentException e) {
            return error(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private <T> ResponseEntity<T> error(HttpStatus status, String message) {
        return (ResponseEntity) ResponseEntity.status(status).body(message);
    }
}
