package org.libertya.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.ProcessParameterLookupRepository;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.ProcessparameterlookupApi;
import org.libertya.api.stub.model.ColumnLookupValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProcessParameterLookupController implements ProcessparameterlookupApi {
    private final ProcessParameterLookupRepository repository;
    private final JWTUtils jwt;
    private final HttpServletRequest request;
    private final ObjectMapper objectMapper;

    @Override
    @GetMapping(value = "/v1.0/processes/{id}/parameters/{parameterId}/lookup", produces = "application/json")
    public ResponseEntity<List<ColumnLookupValue>> retrieveProcessParameterLookup(@PathVariable Integer id, @PathVariable Integer parameterId, @RequestParam(required = false, defaultValue = "50") Integer limit, @RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false) String search, @RequestParam(required = false) String value, @RequestParam(required = false) String context) {
        try {
            UserInfo info = jwt.infoOf(request);
            Map<String, String> contextValues = context == null || context.trim().isEmpty() ? Collections.emptyMap() : objectMapper.readValue(context, new TypeReference<Map<String, String>>() {});
            List<ColumnLookupValue> values = repository.retrieve(info, id, parameterId, limit, page, search, value, contextValues);
            return values == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(values);
        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            throw new RuntimeException("Error procesando contexto del lookup de parametro de proceso", e);
        }
    }
}
