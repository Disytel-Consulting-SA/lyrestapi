package org.libertya.api.repository;

import org.libertya.api.stub.model.Locator;
import org.openXpertya.model.X_M_Locator;
import org.springframework.stereotype.Repository;

@Repository
public class LocatorRepository extends AbstractRepository {

    public LocatorRepository() {
        tableName = X_M_Locator.Table_Name;
        iface = Locator::new;
    }
}
