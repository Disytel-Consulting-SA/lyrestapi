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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ColumnLookupController implements ColumnlookupApi {

    private final ColumnLookupRepository repository;
    private final JWTUtils jwt;
    private final HttpServletRequest request;
    private final ObjectMapper objectMapper;

    @Override
    public ResponseEntity<List<ColumnLookupValue>> retrieveColumnLookup(
            Integer id,
            Integer limit,
            Integer page,
            String search,
            String value,
            String context) {

        try {
            UserInfo info = jwt.infoOf(request);

            Map<String, String> contextValues = Collections.emptyMap();

            if (context != null && !context.trim().isEmpty()) {
                contextValues = objectMapper.readValue(
                        context,
                        new TypeReference<Map<String, String>>() {}
                );
            }

            List<ColumnLookupValue> values =
                    repository.retrieve(info, id, limit, page, search, value, contextValues);

            if (values == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(values);

        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        } catch (Exception e) {
            throw new RuntimeException("Error procesando contexto del lookup", e);
        }
    }
}