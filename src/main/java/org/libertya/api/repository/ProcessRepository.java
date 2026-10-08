package org.libertya.api.repository;

import org.libertya.api.stub.model.Process;
import org.openXpertya.model.X_AD_Process;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessRepository extends AbstractRepository {

    public ProcessRepository() {
        tableName = X_AD_Process.Table_Name;
        iface = Process::new;
    }
}
