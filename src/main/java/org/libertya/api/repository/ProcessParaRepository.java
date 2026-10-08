package org.libertya.api.repository;

import org.libertya.api.stub.model.ProcessPara;
import org.openXpertya.model.X_AD_Process_Para;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessParaRepository extends AbstractRepository {

    public ProcessParaRepository() {
        tableName = X_AD_Process_Para.Table_Name;
        iface = ProcessPara::new;
    }
}
