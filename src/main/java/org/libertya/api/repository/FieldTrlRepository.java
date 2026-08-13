package org.libertya.api.repository;

import org.libertya.api.stub.model.FieldTrl;
import org.openXpertya.model.X_AD_Field_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class FieldTrlRepository extends AbstractRepository {

    public FieldTrlRepository() {
        tableName = X_AD_Field_Trl.Table_Name;
        iface = FieldTrl::new;
        pkColumns = new String[] {"AD_Field_ID", "AD_Language"};
    }
}
