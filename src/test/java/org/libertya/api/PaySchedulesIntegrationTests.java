package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.PaySchedule;

import java.math.BigDecimal;

public class PaySchedulesIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        PaySchedule paySchedule = new PaySchedule();
        paySchedule.setAdClientId(1010016);
        paySchedule.setAdOrgId(1010053);
        paySchedule.setCPaymenttermId(1010085);
        paySchedule.setPercentage(new BigDecimal("100.000000"));
        paySchedule.setNetdays(30);
        paySchedule.setNetday(null);
        paySchedule.setDiscountdays(0);
        paySchedule.setDiscount(BigDecimal.ZERO);
        paySchedule.setIsvalid(true);
        paySchedule.setGracedays(0);
        paySchedule.setDiscountapplicationtype(null);

        return objectMapper.writeValueAsString(paySchedule);
    }

    @Override
    protected String getMaestroPath() {
        return "payschedules/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000026";
    }
}
