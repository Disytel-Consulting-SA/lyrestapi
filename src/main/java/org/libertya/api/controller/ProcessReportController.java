package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.libertya.api.util.NativeReportGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Informes nativos síncronos. Los reportes Jasper se incorporarán luego.
 * Se exige rol explícito para evitar consultas de informes sin autorización.
 */
@RestController
@RequiredArgsConstructor
public class ProcessReportController {

    private static final Logger log = LoggerFactory.getLogger(ProcessReportController.class);
    private final JWTUtils jwt;
    private final HttpServletRequest request;

    @PostMapping(value = "/v1.0/processes/{id}/report",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateProcessReport(
            @PathVariable("id") Integer id,
            @RequestBody(required = false) ProcessExecuteRequest body) {
        try {
            UserInfo info = jwt.infoOf(request);
            byte[] pdf = new NativeReportGenerator().generate(info, id, body);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"reporte-" + id + ".pdf\"")
                    .body(pdf);
        } catch (AuthException e) {
            log.warn("Autenticación o acceso al informe {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (SecurityException e) {
            log.warn("Acceso denegado al informe {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (IllegalArgumentException e) {
            log.warn("Parámetros inválidos del informe {}: {}", id, e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            log.error("Error generando informe {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
