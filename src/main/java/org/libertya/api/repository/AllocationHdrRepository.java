package org.libertya.api.repository;

import org.libertya.api.stub.model.AllocationHdr;
import org.openXpertya.model.X_C_AllocationHdr;
import org.springframework.stereotype.Repository;

@Repository
public class AllocationHdrRepository extends AbstractRepository {

    public AllocationHdrRepository() {
        tableName = X_C_AllocationHdr.Table_Name;
        iface = AllocationHdr::new;
    }
}
