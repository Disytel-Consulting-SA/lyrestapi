package org.libertya.api.repository;

import org.libertya.api.stub.model.Tab;
import org.openXpertya.model.X_AD_Tab;
import org.springframework.stereotype.Repository;

@Repository
public class TabRepository extends AbstractRepository {

    public TabRepository() {
        tableName = X_AD_Tab.Table_Name;
        iface = Tab::new;
    }
}
