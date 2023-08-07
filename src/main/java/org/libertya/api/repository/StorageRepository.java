package org.libertya.api.repository;

import org.libertya.api.stub.model.Storage;
import org.openXpertya.model.X_M_Storage;
import org.springframework.stereotype.Repository;

@Repository
public class StorageRepository extends AbstractRepository {

    public StorageRepository() {
        tableName = X_M_Storage.Table_Name;
        iface = Storage::new;
        pkColumns = new String[] {"M_Product_ID", "M_Locator_ID"};
    }
}
