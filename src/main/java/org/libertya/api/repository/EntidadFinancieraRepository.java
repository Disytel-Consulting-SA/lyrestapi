package org.libertya.api.repository;

import org.libertya.api.stub.model.EntidadFinanciera;
import org.openXpertya.model.X_M_EntidadFinanciera;
import org.springframework.stereotype.Repository;

@Repository
public class EntidadFinancieraRepository extends AbstractRepository {

    public EntidadFinancieraRepository() {
        tableName = X_M_EntidadFinanciera.Table_Name;
        iface = EntidadFinanciera::new;
    }
}
