package org.libertya.api.repository;

import org.libertya.api.stub.model.Combo;
import org.openXpertya.model.X_C_Combo;
import org.springframework.stereotype.Repository;

@Repository
public class ComboRepository extends AbstractRepository {

    public ComboRepository() {
        tableName = X_C_Combo.Table_Name;
        iface = Combo::new;
    }
}
