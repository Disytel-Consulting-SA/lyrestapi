package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.BPartner;
import org.openXpertya.util.DB;

import java.math.BigDecimal;

public class BPartnerIntegrationTests extends MaestroIntegrationTests{


    @Override
    protected String getMaestroContent() throws JsonProcessingException {

        // Se requiere categoria de iva
        DB.executeUpdate("INSERT INTO c_categoria_iva " +
                "(c_categoria_iva_id, name, created, createdby, updated, updatedby, ad_client_id, ad_org_id, isactive, codigo, c_sicore, requierecuit, ad_componentobjectuid, ispercepcionliable, c_tax_id, i_tipo_iva, fiscalprintercodigo) " +
                "VALUES (1010287, 'CONSUMIDOR FINAL', '2022-05-05 10:02:48.572504', 101, '2022-05-05 10:02:48.572504', 101, 1010016, 0, 'Y', '1', NULL, 'N', 'L_AR-C_Categoria_Iva-1010017', 'N', NULL, 'CF', NULL);");

        ObjectMapper objectMapper = new ObjectMapper();

        BPartner bp = new BPartner();
        bp.setAdClientId(1010016);
        bp.setAdOrgId(1010053);
        bp.setIsactive(true);
        bp.setValue("Test");
        bp.setName("Test");
        bp.setName2(null);
        bp.setDescription(null);
        bp.setIssummary(false);
        bp.setCBpGroupId(1010045);
        bp.setIsonetime(false);
        bp.setIsprospect(false);
        bp.setIsvendor(false);
        bp.setIscustomer(false);
        bp.setIsemployee(false);
        bp.setIssalesrep(false);
        bp.setReferenceno(null);
        bp.setDuns(null);
        bp.setUrl(null);
//        bp.setAdLanguage("es_AR");
        bp.setTaxid("20-12801863-9");
        bp.setTaxidtype("80");
        bp.setIstaxexempt(false);
        bp.setCPaymenttermId(1010083);
        bp.setMPricelistId(1000587);
        bp.setIsdiscountprinted(false);
        bp.setSendemail(false);
        bp.setSocreditstatus("X");
        bp.setFlatdiscount(BigDecimal.ZERO);
        bp.setSoCreditlimit(BigDecimal.ZERO);
        bp.setSoCreditused(BigDecimal.ZERO);
        bp.setCGreetingId(null);
        bp.setCustomertype(null);
        bp.setIsiso(false);
        bp.setIscompoundtax(false);
        bp.setCCategoriaIvaId(1010287);

        bp.setSecondarycreditstatus("OK");
        bp.setCreditminimumamt(BigDecimal.ZERO);
        bp.setIsgroupinvoices(false);
        bp.setAutomaticcreditnotes(false);
        bp.setSearchunallocatedpayments(true);
        bp.setIsmulticuit(false);
        bp.setAllowadvancedpaymentreceipts(true);
        bp.setAllowpartialpayment(true);
        bp.setBuiltcabajurisdiction(false);
        bp.setIsmandatorycai(false);
        bp.setProcesspo("Y");
        bp.setPaymentblocked(false);
        bp.setTrxenabled(true);
        bp.setEmitirMiPyme(false);
        bp.setCBankaccountId(99999999); // <-- obtengo: java.lang.NumberFormatException: For input string: "null"

        return objectMapper.writeValueAsString(bp);
    }

    @Override
    protected String getMaestroPath() {
        return "bpartners/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getModificationBody() {
        return "{ \"descrption\" : \"Prueba en bpartner\"}";
    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1002088"; // <-- Registro con AD_CLIENT_ID = 1000005
    }
}
