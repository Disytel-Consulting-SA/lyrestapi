package org.libertya.api.repository;

import org.libertya.api.stub.model.POSLetter;
import org.openXpertya.model.X_C_POSLetter;
import org.springframework.stereotype.Repository;

@Repository
public class POSLetterRepository extends AbstractRepository {

    public POSLetterRepository() {
        tableName = X_C_POSLetter.Table_Name;
        iface = POSLetter::new;
    }
}
