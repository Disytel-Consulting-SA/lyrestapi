package org.libertya.api.repository;

import org.libertya.api.stub.model.Invoice;
import org.openXpertya.model.X_C_Invoice;
import org.springframework.stereotype.Repository;


@Repository
public class InvoiceRepository extends AbstractRepository {

    public InvoiceRepository() {
        tableName = X_C_Invoice.Table_Name;
        iface = Invoice::new;
    }
}
