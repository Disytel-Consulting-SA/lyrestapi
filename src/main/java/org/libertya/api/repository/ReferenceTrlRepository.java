package org.libertya.api.repository;

import org.libertya.api.stub.model.ReferenceTrl;
import org.openXpertya.model.X_AD_Reference_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class ReferenceTrlRepository extends AbstractRepository {

    public ReferenceTrlRepository() {
        tableName = X_AD_Reference_Trl.Table_Name;
        iface = ReferenceTrl::new;
        pkColumns = new String[] {"AD_Reference_ID", "AD_Language"};
    }
}
