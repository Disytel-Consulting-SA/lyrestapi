package org.libertya.api.repository;

import org.libertya.api.stub.model.InvoiceTax;
import org.openXpertya.model.X_C_InvoiceTax;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceTaxRepository extends AbstractRepository {

    public InvoiceTaxRepository() {
        tableName = X_C_InvoiceTax.Table_Name;
        iface = InvoiceTax::new;
        pkColumns = new String[]{"C_Invoice_ID", "C_Tax_ID"};
    }


}
