package org.libertya.api.repository;

import org.libertya.api.stub.model.RefTable;
import org.openXpertya.model.X_AD_Ref_Table;
import org.springframework.stereotype.Repository;

@Repository
public class RefTableRepository extends AbstractRepository {

    public RefTableRepository() {
        tableName = X_AD_Ref_Table.Table_Name;
        iface = RefTable::new;
        pkColumns = new String[] {"AD_Reference_ID"};
    }
}
