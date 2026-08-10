package org.libertya.api.repository;

import org.libertya.api.stub.model.Journal;
import org.openXpertya.model.X_GL_Journal;
import org.springframework.stereotype.Repository;

@Repository
public class JournalRepository extends AbstractRepository {

    public JournalRepository() {
        tableName = X_GL_Journal.Table_Name;
        iface = Journal::new;
    }
}
