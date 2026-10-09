package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.ProcessstateApi;
import org.libertya.api.stub.model.ProcessState;
import org.libertya.api.stub.model.ProcessStateRequest;
import org.libertya.api.util.ProcessFieldStateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ProcessStateController implements ProcessstateApi {
    private final JWTUtils jwt;
    private final HttpServletRequest request;
    private static final Logger log = LoggerFactory.getLogger(ProcessStateController.class);

    @Override
    public ResponseEntity<ProcessState> evaluateProcessState(Integer id, ProcessStateRequest body) {
        try {
            UserInfo info = jwt.infoOf(request);
            ProcessState state = new ProcessFieldStateEngine().resolve(info, id, body);
            return ResponseEntity.ok(state);
        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (IllegalArgumentException e) {
            log.warn("Process state {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (SecurityException e) {
            log.warn("Process state {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (Exception e) {
            log.error("Error resolviendo estado del proceso {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
