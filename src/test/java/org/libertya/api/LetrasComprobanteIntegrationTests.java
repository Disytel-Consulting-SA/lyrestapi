package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.LetraComprobante;

import java.sql.Timestamp;

public class LetrasComprobanteIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        LetraComprobante letraComprobante = new LetraComprobante();
        letraComprobante.setAdClientId(1010016);
        letraComprobante.setAdOrgId(1010053);
        letraComprobante.setLetra("Z");
        letraComprobante.setDescription("Prueba");
        letraComprobante.setIsdefault(false);

        return objectMapper.writeValueAsString(letraComprobante);
    }

    @Override
    protected String getMaestroPath() {
        return "letrascomprobante/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getModificationBody() {
        //return "{ \"description\" : \"X\"}";   <-- 409 CONFLICT Conflict,La entrada en un campo clave no es única
        return "{ \"letra\" : \"X\"}";
    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "-1"; // <-- No existe registro valido en BD
    }
}
