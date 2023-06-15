package org.libertya.api.repository;

import org.libertya.api.stub.model.Payment;
import org.openXpertya.model.X_C_Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository extends AbstractRepository {

    public PaymentRepository() {
        tableName = X_C_Payment.Table_Name;
        iface = Payment::new;
    }
}
