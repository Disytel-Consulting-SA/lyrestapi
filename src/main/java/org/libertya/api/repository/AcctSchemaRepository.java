package org.libertya.api.repository;

import org.libertya.api.stub.model.AcctSchema;
import org.openXpertya.model.X_C_AcctSchema;
import org.springframework.stereotype.Repository;

@Repository
public class AcctSchemaRepository extends AbstractRepository {

    public AcctSchemaRepository() {
        tableName = X_C_AcctSchema.Table_Name;
        iface = AcctSchema::new;
    }
}
