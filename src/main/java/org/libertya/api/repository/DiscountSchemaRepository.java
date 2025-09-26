package org.libertya.api.repository;

import org.libertya.api.stub.model.DiscountSchema;
import org.openXpertya.model.X_M_DiscountSchema;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountSchemaRepository extends AbstractRepository {

    public DiscountSchemaRepository() {
        tableName = X_M_DiscountSchema.Table_Name;
        iface = DiscountSchema::new;
    }
}
