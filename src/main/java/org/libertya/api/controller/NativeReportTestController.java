package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.security.JWTUtils;
import org.openXpertya.model.MQuery;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.PrintInfo;
import org.openXpertya.print.MPrintFormat;
import org.openXpertya.print.ReportEngine;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * Prueba aislada del motor de impresión nativo.
 *
 * Solo se registra al activar explícitamente el perfil "prueba-reportes".
 * NO habilitar en ambientes productivos: faltan controles de autorización
 * por registro y restricciones adicionales del reporteador.
 */
@RestController
@Profile("prueba-reportes")
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class NativeReportTestController {

    private static final int PRINT_FORMAT_ID = 1011063;
    private static final int BANK_ACCOUNT_ID = 1010455;

    private final JWTUtils jwt;
    private final HttpServletRequest request;

    @GetMapping(value = "/native-report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generate() throws Exception {
        UserInfo user = jwt.infoOf(request);
        if (!user.hasRole()) {
            throw new SecurityException("La prueba requiere un rol autenticado");
        }

        Properties ctx = new Properties();
        ctx.putAll(user.getCtx());

        MPrintFormat format = MPrintFormat.get(ctx, PRINT_FORMAT_ID, true);
        if (format == null || format.getID() <= 0) {
            throw new IllegalStateException("No se encontró el formato de impresión " + PRINT_FORMAT_ID);
        }

        String tableName = M_Table.getTableName(ctx, format.getAD_Table_ID());
        if (tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalStateException("No se encontró la tabla asociada al formato");
        }

        MQuery query = new MQuery(tableName);
        query.addRestriction("C_BankAccount_ID", MQuery.EQUAL, BANK_ACCOUNT_ID);

        PrintInfo printInfo = new PrintInfo(format.getName(), format.getAD_Table_ID(), 0);
        ReportEngine engine = new ReportEngine(ctx, format, query, printInfo);
        byte[] pdf = engine.createPDFData();

        if (pdf == null || pdf.length < 5
                || pdf[0] != '%' || pdf[1] != 'P' || pdf[2] != 'D'
                || pdf[3] != 'F' || pdf[4] != '-') {
            throw new IllegalStateException("El reporteador no devolvió un PDF válido");
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"movimientos-bancarios.pdf\"")
                .body(pdf);
    }
}
