package org.libertya.api.repository;

import org.libertya.api.stub.model.ColumnTrl;
import org.openXpertya.model.X_AD_Column_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class ColumnTrlRepository extends AbstractRepository {

    public ColumnTrlRepository() {
        tableName = X_AD_Column_Trl.Table_Name;
        iface = ColumnTrl::new;
        pkColumns = new String[] {"AD_Column_ID", "AD_Language"};
    }
}
