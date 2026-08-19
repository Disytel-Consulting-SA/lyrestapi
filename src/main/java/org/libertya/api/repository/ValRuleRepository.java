package org.libertya.api.repository;

import org.libertya.api.stub.model.ValRule;
import org.openXpertya.model.X_AD_Val_Rule;
import org.springframework.stereotype.Repository;

@Repository
public class ValRuleRepository extends AbstractRepository {

    public ValRuleRepository() {
        tableName = X_AD_Val_Rule.Table_Name;
        iface = ValRule::new;
    }
}
