package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.WindowstateApi;
import org.libertya.api.stub.model.WindowRecordState;
import org.libertya.api.stub.model.WindowRecordStateRequest;
import org.libertya.api.util.WindowFieldStateEngine;
import org.openXpertya.util.CLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WindowRecordStateController implements WindowstateApi {

    private final JWTUtils jwt;
    private final HttpServletRequest request;

    private static final CLogger log = CLogger.getCLogger(WindowRecordStateController.class);

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
}