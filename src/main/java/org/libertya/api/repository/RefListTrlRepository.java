package org.libertya.api.repository;

import org.libertya.api.stub.model.RefListTrl;
import org.openXpertya.model.X_AD_Ref_List_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class RefListTrlRepository extends AbstractRepository {

    public RefListTrlRepository() {
        tableName = X_AD_Ref_List_Trl.Table_Name;
        iface = RefListTrl::new;
        pkColumns = new String[] {"AD_Ref_List_ID", "AD_Language"};
    }
}
