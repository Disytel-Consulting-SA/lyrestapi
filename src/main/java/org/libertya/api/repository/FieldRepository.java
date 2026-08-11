package org.libertya.api.repository;

import org.libertya.api.stub.model.Field;
import org.openXpertya.model.X_AD_Field;
import org.springframework.stereotype.Repository;

@Repository
public class FieldRepository extends AbstractRepository {

    public FieldRepository() {
        tableName = X_AD_Field.Table_Name;
        iface = Field::new;
    }
}
