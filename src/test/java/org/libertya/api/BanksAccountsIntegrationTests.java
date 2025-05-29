package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.BankAccount;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BanksAccountsIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        BankAccount bankAccount = new BankAccount();
        bankAccount.setAdClientId(1010016);
        bankAccount.setAdOrgId(1010053);
        bankAccount.setCBankId(1010112);
        bankAccount.setCCurrencyId(118);
        bankAccount.setBankaccounttype("C");
        bankAccount.setAccountno("4343");
        bankAccount.setCurrentbalance(BigDecimal.ZERO);
        bankAccount.setCreditlimit(BigDecimal.ZERO);
        bankAccount.setIsdefault(false);
        bankAccount.setDescription("4343");
        bankAccount.setIban(null);
        bankAccount.setBban(null);
        bankAccount.setCc(null);
        bankAccount.setDc(null);
        bankAccount.setOficina(null);
        bankAccount.setSucursal("321");
        bankAccount.setIschequesencartera(false);
        bankAccount.setCBankaccountLocationId(null);
        bankAccount.setElectronicpaymentsaccount(false);

        return objectMapper.writeValueAsString(bankAccount);
    }

    @Override
    protected String getMaestroPath() {
        return "bankaccounts/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000025";
    }
}
