package org.libertya.api.repository;

import org.libertya.api.stub.model.WindowTrl;
import org.openXpertya.model.X_AD_Window_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class WindowTrlRepository extends AbstractRepository {

    public WindowTrlRepository() {
        tableName = X_AD_Window_Trl.Table_Name;
        iface = WindowTrl::new;
        pkColumns = new String[] {"AD_Window_ID", "AD_Language"};
    }
}
