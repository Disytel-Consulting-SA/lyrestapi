package org.libertya.api.repository;

import org.libertya.api.stub.model.CheckCuitControl;
import org.openXpertya.model.X_C_CheckCuitControl;
import org.springframework.stereotype.Repository;

@Repository
public class CheckCuitControlRepository  extends AbstractRepository {

    public CheckCuitControlRepository() {
        tableName = X_C_CheckCuitControl.Table_Name;
        iface = CheckCuitControl::new;
    }
}
