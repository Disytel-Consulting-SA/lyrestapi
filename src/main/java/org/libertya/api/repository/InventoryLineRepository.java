package org.libertya.api.repository;

import org.libertya.api.stub.model.InventoryLine;
import org.openXpertya.model.X_M_InventoryLine;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryLineRepository extends AbstractRepository {

    public InventoryLineRepository() {
        tableName = X_M_InventoryLine.Table_Name;
        iface = InventoryLine::new;
    }
}
