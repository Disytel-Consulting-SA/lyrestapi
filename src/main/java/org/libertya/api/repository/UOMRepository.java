package org.libertya.api.repository;

import org.libertya.api.stub.model.UOM;
import org.openXpertya.model.X_C_UOM;
import org.springframework.stereotype.Repository;

@Repository
public class UOMRepository extends AbstractRepository {

    public UOMRepository() {
        tableName = X_C_UOM.Table_Name;
        iface = UOM::new;
    }
}
