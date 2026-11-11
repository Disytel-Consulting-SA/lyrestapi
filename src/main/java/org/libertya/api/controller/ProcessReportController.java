package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.libertya.api.util.NativeReportGenerator;
import org.libertya.api.util.JasperReportGenerator;
import org.openXpertya.model.MProcess;
import java.util.Properties;
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
 * Informes síncronos PDF. CORE determina la definición del proceso;
 * la REST API solo devuelve el resultado del motor correspondiente.
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
        UserInfo info;
        try {
            info = jwt.infoOf(request);
        } catch (AuthException e) {
            log.warn("Autenticación inválida para informe {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            Properties ctx = new Properties();
            ctx.putAll(info.getCtx());
            MProcess process = MProcess.get(ctx, id);
            if (process == null || process.getID() <= 0 || !process.isActive() || !process.isReport()) {
                throw new IllegalArgumentException("No existe un informe activo AD_Process_ID=" + id);
            }
            byte[] pdf = process.isJasperReport()
                    ? new JasperReportGenerator().generate(info, id, body)
                    : new NativeReportGenerator().generate(info, id, body);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"reporte-" + id + ".pdf\"")
                    .body(pdf);
        } catch (AuthException | SecurityException e) {
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
