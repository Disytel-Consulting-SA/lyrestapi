package org.libertya.api.repository;

import org.libertya.api.stub.model.TaxCategory;
import org.openXpertya.model.X_C_TaxCategory;
import org.springframework.stereotype.Repository;

@Repository
public class TaxCategoryRepository extends AbstractRepository {

    public TaxCategoryRepository() {
        tableName = X_C_TaxCategory.Table_Name;
        iface = TaxCategory::new;
    }
}
