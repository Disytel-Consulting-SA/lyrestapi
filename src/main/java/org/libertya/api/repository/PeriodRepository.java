package org.libertya.api.repository;

import org.libertya.api.stub.model.Period;
import org.openXpertya.model.X_C_Period;
import org.springframework.stereotype.Repository;

@Repository
public class PeriodRepository extends AbstractRepository {

    public PeriodRepository() {
        tableName = X_C_Period.Table_Name;
        iface = Period::new;
    }
}
