package org.libertya.api.repository;

import org.libertya.api.stub.model.CashBook;
import org.openXpertya.model.X_C_CashBook;
import org.springframework.stereotype.Repository;

@Repository
public class CashBookRepository  extends AbstractRepository {

    public CashBookRepository() {
        tableName = X_C_CashBook.Table_Name;
        iface = CashBook::new;
    }
}
