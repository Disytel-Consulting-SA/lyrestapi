package org.libertya.api.repository;

import org.libertya.api.stub.model.PriceListVersion;
import org.openXpertya.model.X_M_PriceList_Version;
import org.springframework.stereotype.Repository;

@Repository
public class PriceListVersionRepository extends AbstractRepository {

    public PriceListVersionRepository() {
        tableName = X_M_PriceList_Version.Table_Name;
        iface = PriceListVersion::new;
    }
}
