package org.libertya.api.repository;

import org.libertya.api.stub.model.POS;
import org.openXpertya.model.X_C_POS;
import org.springframework.stereotype.Repository;

@Repository
public class POSRepository extends AbstractRepository {

    public POSRepository() {
        tableName = X_C_POS.Table_Name;
        iface = POS::new;
    }
}
