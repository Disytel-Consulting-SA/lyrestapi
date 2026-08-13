package org.libertya.api.repository;

import org.libertya.api.stub.model.TableTrl;
import org.openXpertya.model.X_AD_Table_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class TableTrlRepository extends AbstractRepository {

    public TableTrlRepository() {
        tableName = X_AD_Table_Trl.Table_Name;
        iface = TableTrl::new;
        pkColumns = new String[] {"AD_Table_ID", "AD_Language"};
    }
}
