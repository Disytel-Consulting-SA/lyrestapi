package org.libertya.api.repository;

import org.libertya.api.stub.model.BPartnerLocation;
import org.openXpertya.model.X_C_BPartner_Location;
import org.springframework.stereotype.Repository;

@Repository
public class BPartnerLocationRepository extends AbstractRepository {

    public BPartnerLocationRepository() {
        tableName = X_C_BPartner_Location.Table_Name;
        iface = BPartnerLocation::new;
    }
}
