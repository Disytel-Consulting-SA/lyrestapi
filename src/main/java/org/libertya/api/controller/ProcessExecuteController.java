package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.iface.ProcessexecuteApi;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.libertya.api.stub.model.ProcessExecuteResponse;
import org.libertya.api.util.ProcessExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ProcessExecuteController implements ProcessexecuteApi {
    private final JWTUtils jwt;
    private final HttpServletRequest request;
    private static final Logger log = LoggerFactory.getLogger(ProcessExecuteController.class);

    @Override
    public ResponseEntity<ProcessExecuteResponse> executeProcess(Integer id, ProcessExecuteRequest body) {
        try {
            UserInfo info = jwt.infoOf(request);
            return ResponseEntity.ok(new ProcessExecutor().execute(info, id, body));
        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (IllegalArgumentException e) {
            log.warn("Process execute {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (SecurityException e) {
            log.warn("Process execute {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (Exception e) {
            log.error("Error ejecutando proceso {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
