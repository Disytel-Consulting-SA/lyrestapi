package org.libertya.api.repository;

import org.libertya.api.stub.model.ProcessTrl;
import org.openXpertya.model.X_AD_Process_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessTrlRepository extends AbstractRepository {

    public ProcessTrlRepository() {
        tableName = X_AD_Process_Trl.Table_Name;
        iface = ProcessTrl::new;
        pkColumns = new String[] {"AD_Process_ID", "AD_Language"};
    }
}
