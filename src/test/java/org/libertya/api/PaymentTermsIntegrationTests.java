package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.PaymentTerm;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PaymentTermsIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        PaymentTerm paymentTerm = new PaymentTerm();
        paymentTerm.setAdClientId(1010016);
        paymentTerm.setAdOrgId(1010053);
        paymentTerm.setName("Prueba");
        paymentTerm.setDescription("");
        paymentTerm.setDocumentnote("");
        paymentTerm.setAfterdelivery(false);
        paymentTerm.setIsduefixed(false);
        paymentTerm.setNetdays(0);
        paymentTerm.setGracedays(0);
        paymentTerm.setFixmonthcutoff(0);
        paymentTerm.setFixmonthday(0);
        paymentTerm.setFixmonthoffset(0);
        paymentTerm.setDiscountdays(0);
        paymentTerm.setDiscount(BigDecimal.ZERO);
        paymentTerm.setDiscountdays2(0);
        paymentTerm.setDiscount2(BigDecimal.ZERO);
        paymentTerm.setIsnextbusinessday(false);
        paymentTerm.setIsdefault(false);
        paymentTerm.setValue("30");
        paymentTerm.setNetday(null);
        paymentTerm.setIsvalid(true);
        paymentTerm.setProcessing("N");
        paymentTerm.setFixmonthday2(null);
        paymentTerm.setDiscountapplicationtype(null);
        paymentTerm.setDiscountapplicationtype2(null);
        paymentTerm.setGracedays2(0);
        paymentTerm.setCPospaymentmediumId(null);
        paymentTerm.setApplicationdate("I");
        paymentTerm.setApplicationcontext("B");

        return objectMapper.writeValueAsString(paymentTerm);
    }

    @Override
    protected String getMaestroPath() {
        return "paymentterms/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000054";
    }
}
