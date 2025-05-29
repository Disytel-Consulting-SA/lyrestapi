package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.CashBook;

import java.sql.Timestamp;

public class CashBooksIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CashBook cashBook = new CashBook();
        cashBook.setAdClientId(1010016);
        cashBook.setAdOrgId(1010053);
        cashBook.setName("Prueba");
        cashBook.setDescription("");
        cashBook.setIsdefault(false);
        cashBook.setCCurrencyId(118);
        cashBook.setCashbooktype("G");
        return objectMapper.writeValueAsString(cashBook);
    }

    @Override
    protected String getMaestroPath() {
        return "cashbooks/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000010";
    }
}
