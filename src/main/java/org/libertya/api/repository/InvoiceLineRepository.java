package org.libertya.api.repository;

import org.libertya.api.stub.model.InvoiceLine;
import org.openXpertya.model.X_C_InvoiceLine;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceLineRepository extends AbstractRepository {

    public InvoiceLineRepository() {
        tableName = X_C_InvoiceLine.Table_Name;
        iface = InvoiceLine::new;
    }
}
