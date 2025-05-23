package org.libertya.api.repository;

import org.libertya.api.stub.model.PriceListVersion;
import org.openXpertya.model.X_M_PriceList;
import org.springframework.stereotype.Repository;

@Repository
public class PriceListRepository extends AbstractRepository {

    public PriceListRepository() {
        tableName = X_M_PriceList.Table_Name;
        iface = PriceListVersion::new;
    }
}
