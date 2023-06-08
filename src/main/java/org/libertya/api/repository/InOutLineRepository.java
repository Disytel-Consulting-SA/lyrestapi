package org.libertya.api.repository;

import org.libertya.api.stub.model.InOutLine;
import org.openXpertya.model.X_M_InOutLine;
import org.springframework.stereotype.Repository;

@Repository
public class InOutLineRepository  extends AbstractRepository {

    public InOutLineRepository() {
        tableName = X_M_InOutLine.Table_Name;
        iface = InOutLine::new;
    }
}
