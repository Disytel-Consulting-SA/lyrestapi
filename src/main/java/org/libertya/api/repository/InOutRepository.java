package org.libertya.api.repository;

import org.libertya.api.stub.model.InOut;
import org.openXpertya.model.X_M_InOut;
import org.springframework.stereotype.Repository;

@Repository
public class InOutRepository extends AbstractRepository {

    public InOutRepository() {
        tableName = X_M_InOut.Table_Name;
        iface = InOut::new;
    }
}
