package org.libertya.api.repository;

import org.libertya.api.stub.model.Table;
import org.openXpertya.model.X_AD_Table;
import org.springframework.stereotype.Repository;

@Repository
public class TableRepository extends AbstractRepository {

    public TableRepository() {
        tableName = X_AD_Table.Table_Name;
        iface = Table::new;
    }
}
