package org.libertya.api.repository;

import org.libertya.api.stub.model.CashLine;
import org.openXpertya.model.X_C_CashLine;
import org.springframework.stereotype.Repository;

@Repository
public class CashLineRepository extends AbstractRepository {

    public CashLineRepository() {
        tableName = X_C_CashLine.Table_Name;
        iface = CashLine::new;
    }
}
