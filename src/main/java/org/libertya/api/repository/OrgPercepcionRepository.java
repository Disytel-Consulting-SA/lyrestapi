package org.libertya.api.repository;

import org.libertya.api.stub.model.OrgPercepcion;
import org.openXpertya.model.X_AD_Org_Percepcion;
import org.springframework.stereotype.Repository;

@Repository
public class OrgPercepcionRepository extends AbstractRepository {

    public OrgPercepcionRepository() {
        tableName = X_AD_Org_Percepcion.Table_Name;
        iface = OrgPercepcion::new;
    }
}
