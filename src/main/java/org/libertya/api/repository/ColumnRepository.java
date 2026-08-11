package org.libertya.api.repository;

import org.libertya.api.stub.model.Column;
import org.openXpertya.model.X_AD_Column;
import org.springframework.stereotype.Repository;

@Repository
public class ColumnRepository extends AbstractRepository {

    public ColumnRepository() {
        tableName = X_AD_Column.Table_Name;
        iface = Column::new;
    }
}
