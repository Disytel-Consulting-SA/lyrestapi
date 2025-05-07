package org.libertya.api.repository;

import org.libertya.api.stub.model.DocType;
import org.openXpertya.model.X_C_DocType;
import org.springframework.stereotype.Repository;

@Repository
public class DocTypeRepository extends AbstractRepository {

    public DocTypeRepository() {
        tableName = X_C_DocType.Table_Name;
        iface = DocType::new;
    }
}
