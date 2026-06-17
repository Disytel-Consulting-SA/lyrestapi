package org.libertya.api.repository;

import org.libertya.api.stub.model.ComboLine;
import org.openXpertya.model.X_C_ComboLine;
import org.springframework.stereotype.Repository;

@Repository
public class ComboLineRepository extends AbstractRepository {

    public ComboLineRepository() {
        tableName = X_C_ComboLine.Table_Name;
        iface = ComboLine::new;
    }
}
