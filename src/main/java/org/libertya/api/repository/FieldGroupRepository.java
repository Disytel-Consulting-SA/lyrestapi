package org.libertya.api.repository;

import org.libertya.api.stub.model.FieldGroup;
import org.openXpertya.model.X_AD_FieldGroup;
import org.springframework.stereotype.Repository;

@Repository
public class FieldGroupRepository extends AbstractRepository {

    public FieldGroupRepository() {
        tableName = X_AD_FieldGroup.Table_Name;
        iface = FieldGroup::new;
    }
}
