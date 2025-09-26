package org.libertya.api.repository;

import org.libertya.api.stub.model.DiscountConfig;
import org.openXpertya.model.X_M_DiscountConfig;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountConfigRepository extends AbstractRepository {

    public DiscountConfigRepository() {
        tableName = X_M_DiscountConfig.Table_Name;
        iface = DiscountConfig::new;
    }
}
