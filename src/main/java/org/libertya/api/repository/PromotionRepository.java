package org.libertya.api.repository;

import org.libertya.api.stub.model.Promotion;
import org.openXpertya.model.X_C_Promotion;
import org.springframework.stereotype.Repository;

@Repository
public class PromotionRepository extends AbstractRepository {

    public PromotionRepository() {
        tableName = X_C_Promotion.Table_Name;
        iface = Promotion::new;
    }
}
