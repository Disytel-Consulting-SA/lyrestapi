package org.libertya.api.repository;

import org.libertya.api.stub.model.TabTrl;
import org.openXpertya.model.X_AD_Tab_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class TabTrlRepository extends AbstractRepository {

    public TabTrlRepository() {
        tableName = X_AD_Tab_Trl.Table_Name;
        iface = TabTrl::new;
        pkColumns = new String[] {"AD_Tab_ID", "AD_Language"};
    }
}
