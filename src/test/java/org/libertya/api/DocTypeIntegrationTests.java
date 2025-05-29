package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.DocType;

import java.sql.Timestamp;

public class DocTypeIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        DocType docType = new DocType();
        docType.setAdClientId(1010016);
        docType.setAdOrgId(1010053);
        docType.setName("Prueba");
        docType.setPrintname("Prueba");
        docType.setDescription(null);
        docType.setDocbasetype("ZZZ");
        docType.setIssotrx(false);
        docType.setGlCategoryId(1010104);
        docType.setAdPrintformatId(1010968);
        docType.setIsfiscal(false);
        docType.setCControladorFiscalId(null);
        docType.setFiscaldocument(null);
        docType.setDoctypekey("ZZZ");
        docType.setIsfiscaldocument(true);
        docType.setIselectronic(false);
        docType.setDocsubtypeinv("SF");
        docType.setDocsubtypecae(null);
        docType.setCai(null);
        docType.setCInvoiceId(null);
        docType.setOpenCloseByPos(null);
        docType.setNotinvoiceable(false);

        return objectMapper.writeValueAsString(docType);
    }

    @Override
    protected String getMaestroPath() {
        return "doctypes/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000310";
    }
}
