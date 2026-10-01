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
import org.libertya.api.stub.model.WindowRecordQuery;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

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