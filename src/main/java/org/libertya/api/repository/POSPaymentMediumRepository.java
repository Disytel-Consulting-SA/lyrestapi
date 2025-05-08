package org.libertya.api.repository;

import org.libertya.api.stub.model.POSPaymentMedium;
import org.openXpertya.model.X_C_POSPaymentMedium;
import org.springframework.stereotype.Repository;

@Repository
public class POSPaymentMediumRepository extends AbstractRepository {

    public POSPaymentMediumRepository() {
        tableName = X_C_POSPaymentMedium.Table_Name;
        iface = POSPaymentMedium::new;
    }
}
