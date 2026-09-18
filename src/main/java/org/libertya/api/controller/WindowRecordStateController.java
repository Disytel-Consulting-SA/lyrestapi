package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.WindowstateApi;
import org.libertya.api.stub.model.WindowCalloutRequest;
import org.libertya.api.stub.model.WindowCalloutResponse;
import org.libertya.api.stub.model.WindowRecordState;
import org.libertya.api.stub.model.WindowRecordStateRequest;
import org.libertya.api.util.WindowCalloutExecutor;
import org.libertya.api.util.WindowFieldStateEngine;
import org.openXpertya.util.CLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class WindowRecordStateController implements WindowstateApi {

    private final JWTUtils jwt;
    private final HttpServletRequest request;

    private static final CLogger log = CLogger.getCLogger(WindowRecordStateController.class);
    private static final Logger calloutLog = LoggerFactory.getLogger(WindowRecordStateController.class);

    @Override
    public ResponseEntity<WindowRecordState> createTabNewRecordState(Integer id, WindowRecordStateRequest body) {
        try {
            UserInfo info = jwt.infoOf(request);

            Map<String, String> parentValues = body != null ? body.getParentValues() : null;

            WindowFieldStateEngine engine = new WindowFieldStateEngine();
            WindowRecordState state = engine.resolveNewRecordState(info, id, parentValues);

            log.info("New record state for AD_Tab_ID=" + id + ": " + state);

            return ResponseEntity.ok(state);
        } catch (IllegalArgumentException e) {
            log.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            log.severe("Error creando estado inicial para AD_Tab_ID=" + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<WindowRecordState> evaluateTabRecordState(Integer id, WindowRecordStateRequest body) {
        try {
            UserInfo info = jwt.infoOf(request);

            if (body == null) {
                body = new WindowRecordStateRequest();
            }

            WindowFieldStateEngine engine = new WindowFieldStateEngine();
            WindowRecordState state = engine.resolveRecordState(
                    info,
                    id,
                    body.getValues(),
                    body.getParentValues(),
                    Boolean.TRUE.equals(body.isInserting())
            );

            log.info("Evaluated record state for AD_Tab_ID=" + id + ": " + state);

            return ResponseEntity.ok(state);
        } catch (IllegalArgumentException e) {
            log.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            log.severe("Error evaluando estado para AD_Tab_ID=" + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<WindowCalloutResponse> executeTabFieldCallout(Integer id, WindowCalloutRequest body) {
        try {
            UserInfo info = jwt.infoOf(request);
            WindowCalloutResponse result = new WindowCalloutExecutor().execute(info, id, body);
            return ResponseEntity.ok(result);
        } catch (AuthException e) {
            calloutLog.warn("Callout AD_Tab_ID={}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (SecurityException e) {
            calloutLog.warn("Callout AD_Tab_ID={}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (NoSuchElementException e) {
            calloutLog.warn("Callout AD_Tab_ID={}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            calloutLog.warn("Callout AD_Tab_ID={}: {}", id, e.getMessage());
            WindowCalloutResponse error = new WindowCalloutResponse();
            error.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception e) {
            calloutLog.error("Error ejecutando callout para AD_Tab_ID={}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
