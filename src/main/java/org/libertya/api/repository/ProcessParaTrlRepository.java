package org.libertya.api.repository;

import org.libertya.api.stub.model.ProcessParaTrl;
import org.openXpertya.model.X_AD_Process_Para_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessParaTrlRepository extends AbstractRepository {

    public ProcessParaTrlRepository() {
        tableName = X_AD_Process_Para_Trl.Table_Name;
        iface = ProcessParaTrl::new;
        pkColumns = new String[] {"AD_Process_Para_ID", "AD_Language"};
    }
}
