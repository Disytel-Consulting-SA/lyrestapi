package org.libertya.api.repository;

import org.libertya.api.stub.model.AllocationLine;
import org.openXpertya.model.X_C_AllocationLine;
import org.springframework.stereotype.Repository;

@Repository
public class AllocationLineRepository extends AbstractRepository {

    public AllocationLineRepository() {
        tableName = X_C_AllocationLine.Table_Name;
        iface = AllocationLine::new;
    }
}
