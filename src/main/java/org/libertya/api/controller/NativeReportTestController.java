package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.libertya.api.util.NativeReportGenerator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

/**
 * Endpoint temporal de diagnóstico. No publicar en producción:
 * la autorización de informes y de sus registros todavía está pendiente.
 */
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class NativeReportTestController {

    private static final int PROCESS_ID = 1000157;
    private static final int BANK_ACCOUNT_ID = 1010455;

    private final JWTUtils jwt;
    private final HttpServletRequest request;

    @GetMapping(value = "/native-report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generate() {
        UserInfo user = jwt.infoOf(request);

        ProcessExecuteRequest parameters = new ProcessExecuteRequest()
                .values(Collections.singletonMap("C_BankAccount_ID", String.valueOf(BANK_ACCOUNT_ID)));
        byte[] pdf = new NativeReportGenerator().generate(user, PROCESS_ID, parameters);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"movimientos-bancarios.pdf\"")
                .body(pdf);
    }
}
