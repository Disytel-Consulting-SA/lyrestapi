package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.Bank;

import java.sql.Timestamp;

public class BanksIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Bank bank = new Bank();
        bank.setAdClientId(1010016);
        bank.setAdOrgId(1010053);
        bank.setName("Prueba");
        bank.setRoutingno("1");
        bank.setCLocationId(null);
        bank.setSwiftcode(null);
        bank.setIsownbank(true);
        bank.setDescription(null);

        return objectMapper.writeValueAsString(bank);
    }

    @Override
    protected String getMaestroPath() {
        return "banks/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000030";
    }
}
