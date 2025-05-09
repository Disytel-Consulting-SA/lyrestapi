package org.libertya.api.repository;

import org.libertya.api.stub.model.PaymentTerm;
import org.openXpertya.model.X_C_PaymentTerm;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentTermRepository extends AbstractRepository {

    public PaymentTermRepository() {
        tableName = X_C_PaymentTerm.Table_Name;
        iface = PaymentTerm::new;
    }
}
