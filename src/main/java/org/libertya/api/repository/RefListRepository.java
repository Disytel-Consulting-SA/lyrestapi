package org.libertya.api.repository;

import org.libertya.api.stub.model.RefList;
import org.openXpertya.model.X_AD_Ref_List;
import org.springframework.stereotype.Repository;

@Repository
public class RefListRepository extends AbstractRepository {

    public RefListRepository() {
        tableName = X_AD_Ref_List.Table_Name;
        iface = RefList::new;
    }
}
