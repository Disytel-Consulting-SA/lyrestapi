package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.GenericRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.GenericidentityApi;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.IdentityRecordWrite;
import org.openXpertya.util.Trx;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GenericIdentityController extends AbstractController implements GenericidentityApi {

    private final HttpServletRequest request;
    private final GenericRepository repository;
    private final JWTUtils identityJwt;

    @Override
    public ResponseEntity<List<GenericRecord>> getAllGenericRecordsByIdentity(String table, String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request,
                (info, p) -> repository.retrieveAllRecordsByIdentity(info, table, p),
                (info, p) -> repository.countAllRecordsByIdentity(info, table, p),
                query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<GenericRecord> retrieveGenericRecordByIdentity(String table, Map<String, Object> body, String fields) {
        try {
            return repository.retrieveRecord(identityJwt.infoOf(request), table, body, fields)
                    .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (NotFoundException e) {
            return error(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (AuthException | SecurityException e) {
            return error(HttpStatus.FORBIDDEN, e.getMessage());
        } catch (ModelException | IllegalArgumentException e) {
            return error(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<GenericRecord> addGenericRecordByIdentity(String table, Map<String, Object> body) {
        return write(HttpStatus.OK, (info, trxName) -> {
            GenericRecord result = new GenericRecord();
            result.putAll(repository.insertRecordByIdentity(info, table, body, trxName));
            return result;
        });
    }

    @Override
    public ResponseEntity<Void> updateGenericRecordByIdentity(String table, IdentityRecordWrite body) {
        return write(HttpStatus.NO_CONTENT, (info, trxName) -> {
            if (body == null)
                throw new ModelException("Se requiere identidad y valores");
            repository.updateRecord(info, table, body.getIdentity(), body.getValues(), trxName);
            return null;
        });
    }

    @Override
    public ResponseEntity<Void> deleteGenericRecordByIdentity(String table, Map<String, Object> body) {
        return write(HttpStatus.NO_CONTENT, (info, trxName) -> {
            repository.deleteRecord(info, table, body, trxName);
            return null;
        });
    }

    @FunctionalInterface
    private interface TransactionWork<T> {
        T execute(UserInfo info, String trxName) throws ModelException, NotFoundException, AuthException;
    }

    private <T> ResponseEntity<T> write(HttpStatus success, TransactionWork<T> work) {
        Trx trx = null;
        boolean committed = false;
        try {
            UserInfo info = identityJwt.infoOf(request);
            trx = Trx.createTrx(Trx.createTrxName());
            T result = work.execute(info, trx.getTrxName());
            if (!trx.commit())
                throw new ModelException("No se pudo confirmar la transaccion");
            committed = true;
            return ResponseEntity.status(success).body(result);
        } catch (NotFoundException e) {
            return error(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (AuthException | SecurityException e) {
            return error(HttpStatus.FORBIDDEN, e.getMessage());
        } catch (ModelException | IllegalArgumentException e) {
            return error(HttpStatus.CONFLICT, e.getMessage());
        } finally {
            if (trx != null) {
                try {
                    if (!committed)
                        trx.rollback();
                } finally {
                    trx.close(false);
                }
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private <T> ResponseEntity<T> error(HttpStatus status, String message) {
        return (ResponseEntity) ResponseEntity.status(status).body(message);
    }
}
