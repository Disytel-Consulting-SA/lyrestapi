package org.libertya.api.repository;

import org.libertya.api.stub.model.BPartner;
import org.openXpertya.model.X_C_BPartner;
import org.springframework.stereotype.Repository;

@Repository
public class BPartnerRepository extends AbstractRepository {

    public BPartnerRepository() {
        tableName = X_C_BPartner.Table_Name;
        iface = BPartner::new;
    }


}
