package org.libertya.api.repository;

import org.libertya.api.stub.model.Cash;
import org.openXpertya.model.X_C_Cash;
import org.springframework.stereotype.Repository;

@Repository
public class CashRepository  extends AbstractRepository {

    public CashRepository() {
        tableName = X_C_Cash.Table_Name;
        iface = Cash::new;
    }
}
