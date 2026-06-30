package org.libertya.api.repository;

import org.libertya.api.stub.model.Warehouse;
import org.openXpertya.model.X_M_Warehouse;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseRepository extends AbstractRepository {

    public WarehouseRepository() {
        tableName = X_M_Warehouse.Table_Name;
        iface = Warehouse::new;
    }
}
