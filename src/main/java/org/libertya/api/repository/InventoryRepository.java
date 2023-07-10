package org.libertya.api.repository;

import org.libertya.api.stub.model.Inventory;
import org.openXpertya.model.X_M_Inventory;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepository extends AbstractRepository {

    public InventoryRepository() {
        tableName = X_M_Inventory.Table_Name;
        iface = Inventory::new;
    }
}
