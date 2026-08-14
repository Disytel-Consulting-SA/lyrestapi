package org.libertya.api.repository;

import org.libertya.api.stub.model.FieldGroupTrl;
import org.openXpertya.model.X_AD_FieldGroup_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class FieldGroupTrlRepository extends AbstractRepository {

    public FieldGroupTrlRepository() {
        tableName = X_AD_FieldGroup_Trl.Table_Name;
        iface = FieldGroupTrl::new;
        pkColumns = new String[] {"AD_FieldGroup_ID", "AD_Language"};
    }
}
