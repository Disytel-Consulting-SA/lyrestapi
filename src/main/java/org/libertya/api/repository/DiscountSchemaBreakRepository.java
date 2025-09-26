package org.libertya.api.repository;

import org.libertya.api.stub.model.DiscountSchemaBreak;
import org.openXpertya.model.X_M_DiscountSchemaBreak;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountSchemaBreakRepository extends AbstractRepository {

    public DiscountSchemaBreakRepository() {
        tableName = X_M_DiscountSchemaBreak.Table_Name;
        iface = DiscountSchemaBreak::new;
    }
}
