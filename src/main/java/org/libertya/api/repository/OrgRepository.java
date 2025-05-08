package org.libertya.api.repository;

import org.libertya.api.stub.model.Org;
import org.openXpertya.model.X_AD_Org;
import org.springframework.stereotype.Repository;

@Repository
public class OrgRepository extends AbstractRepository {

    public OrgRepository() {
        tableName = X_AD_Org.Table_Name;
        iface = Org::new;
    }
}
