package org.libertya.api.repository;

import org.libertya.api.stub.model.DocumentDiscount;
import org.openXpertya.model.X_C_DocumentDiscount;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentDiscountRepository extends AbstractRepository {

    public DocumentDiscountRepository() {
        tableName = X_C_DocumentDiscount.Table_Name;
        iface = DocumentDiscount::new;
    }
}
