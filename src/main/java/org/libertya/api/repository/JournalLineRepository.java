package org.libertya.api.repository;

import org.libertya.api.stub.model.JournalLine;
import org.openXpertya.model.X_GL_JournalLine;
import org.springframework.stereotype.Repository;

@Repository
public class JournalLineRepository extends AbstractRepository {

    public JournalLineRepository() {
        tableName = X_GL_JournalLine.Table_Name;
        iface = JournalLine::new;
    }
}
