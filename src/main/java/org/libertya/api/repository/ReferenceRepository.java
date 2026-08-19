package org.libertya.api.repository;

import org.libertya.api.stub.model.Reference;
import org.openXpertya.model.X_AD_Reference;
import org.springframework.stereotype.Repository;

@Repository
public class ReferenceRepository extends AbstractRepository {

    public ReferenceRepository() {
        tableName = X_AD_Reference.Table_Name;
        iface = Reference::new;
    }
}
