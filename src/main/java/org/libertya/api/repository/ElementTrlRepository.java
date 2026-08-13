package org.libertya.api.repository;

import org.libertya.api.stub.model.ElementTrl;
import org.openXpertya.model.X_AD_Element_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class ElementTrlRepository extends AbstractRepository {

    public ElementTrlRepository() {
        tableName = X_AD_Element_Trl.Table_Name;
        iface = ElementTrl::new;
        pkColumns = new String[] {"AD_Column_ID", "AD_Language"};
    }
}
