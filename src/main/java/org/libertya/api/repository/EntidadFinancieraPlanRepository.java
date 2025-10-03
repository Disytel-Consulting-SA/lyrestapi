package org.libertya.api.repository;

import org.libertya.api.stub.model.EntidadFinancieraPlan;
import org.openXpertya.model.X_M_EntidadFinancieraPlan;
import org.springframework.stereotype.Repository;

@Repository
public class EntidadFinancieraPlanRepository extends AbstractRepository {

    public EntidadFinancieraPlanRepository() {
        tableName = X_M_EntidadFinancieraPlan.Table_Name;
        iface = EntidadFinancieraPlan::new;
    }
}
