package org.libertya.api.repository;

import org.libertya.api.stub.model.POSJournal;
import org.openXpertya.model.X_C_POSJournal;
import org.springframework.stereotype.Repository;

@Repository
public class POSJournalRepository extends AbstractRepository {

    public POSJournalRepository() {
        tableName = X_C_POSJournal.Table_Name;
        iface = POSJournal::new;
    }
}
