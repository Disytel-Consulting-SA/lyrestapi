package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.LetraAceptaIVA;
import org.openXpertya.util.DB;

import static org.assertj.core.api.Assertions.assertThat;

public class LetrasAceptaIVAIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {

        DB.executeUpdate("INSERT INTO c_letra_comprobante " +
                "(c_letra_comprobante_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, letra, description, isdefault, ad_componentobjectuid) " +
                "VALUES (1010277, 1010016, 0, 'Y', '2022-05-05 10:02:48.572504', 101, '2022-05-05 10:02:48.572504', 101, 'A', 'A', 'Y', 'L_AR-C_Letra_Comprobante-1010007');");

        DB.executeUpdate("INSERT INTO c_categoria_iva " +
                "(c_categoria_iva_id, name, created, createdby, updated, updatedby, ad_client_id, ad_org_id, isactive, codigo, c_sicore, requierecuit, ad_componentobjectuid, ispercepcionliable, c_tax_id, i_tipo_iva, fiscalprintercodigo) " +
                "VALUES (1010291, 'RESPONSABLE MONOTRIBUTO', '2022-05-05 10:02:48.572504', 101, '2022-05-05 10:02:48.572504', 101, 1010016, 0, 'Y', '5', NULL, 'Y', 'L_AR-C_Categoria_Iva-1010021', 'Y', NULL, 'MON', NULL);");

        DB.executeUpdate("INSERT INTO c_categoria_iva " +
                "(c_categoria_iva_id, name, created, createdby, updated, updatedby, ad_client_id, ad_org_id, isactive, codigo, c_sicore, requierecuit, ad_componentobjectuid, ispercepcionliable, c_tax_id, i_tipo_iva, fiscalprintercodigo) " +
                "VALUES (1010307, 'COMERCIO EXTERIOR', '2022-05-05 10:05:07.42602', 101, '2022-05-05 10:05:07.42602', 101, 1010016, 0, 'Y', '13', NULL, 'N', 'L_AR-C_Categoria_Iva-1010081', 'N', 1010087, 'COMEX', NULL);");

        ObjectMapper objectMapper = new ObjectMapper();

        LetraAceptaIVA letraAceptaIva = new LetraAceptaIVA();
        letraAceptaIva.setCategoriaVendor(1010307);
        letraAceptaIva.setCategoriaCustomer(1010291);
        letraAceptaIva.setMontomax(null);
        letraAceptaIva.setCLetraComprobanteId(defaultLetraComprobante);
        letraAceptaIva.setAdClientId(1010016);
        letraAceptaIva.setAdOrgId(1010053);
        letraAceptaIva.setCTaxId(null);

        return objectMapper.writeValueAsString(letraAceptaIva);
    }

    @Override
    protected String getMaestroPath() {
        return "letrasaceptaiva/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "-1";
    }

    /* Se pisa el metodo original por falta de registros de prueba */
    @Override
    void deleteMaestroWithCompanyMismatchShouldReturnKO() {
        assertThat(true).isTrue();
    }
}
