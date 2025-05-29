package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.Cash;
import java.math.BigDecimal;

public class CashIntegrationTests extends DocumentIntegrationTests {
    @Override
    protected String getDocumentContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Cash cash = new Cash();
        cash.setAdClientId(1010016);
        cash.setAdOrgId(1010053);
        cash.setCCashbookId(1010024);
        cash.setName("01/04/2025");
        cash.setDescription("");
        cash.setStatementdate("2025-04-01 10:00:00");
        cash.setDateacct("2025-04-01 10:00:00");
        cash.setBeginningbalance(BigDecimal.valueOf(1092.60));
        cash.setEndingbalance(BigDecimal.valueOf(2185.20));
        cash.setStatementdifference(BigDecimal.valueOf(1092.60));
        cash.setProcessing(false);
        cash.setProcessed(true);
        cash.setPosted("p");
        cash.setAdOrgtrxId(null);
        cash.setCProjectId(null);
        cash.setCCampaignId(null);
        cash.setCActivityId(null);
        cash.setUser1Id(null);
        cash.setUser2Id(null);
        cash.setIsapproved(true);
        cash.setCPosjournalId(null);
        cash.setValidateposjournal(false);

        return objectMapper.writeValueAsString(cash);
    }

    @Override
    protected String getDocumentPath() {
        return "cash/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getModificationBody() {
        return "{ \"descrption\" : \"Prueba en order\"}";
    }
}
