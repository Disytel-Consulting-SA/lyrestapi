package org.libertya.api.repository;

import org.libertya.api.stub.model.ElementValue;
import org.openXpertya.model.X_C_ElementValue;
import org.springframework.stereotype.Repository;

@Repository
public class ElementValueRepository extends AbstractRepository {

    public ElementValueRepository() {
        tableName = X_C_ElementValue.Table_Name;
        iface = ElementValue::new;
    }
}
