package org.libertya.api.repository;

import org.libertya.api.stub.model.Tax;
import org.openXpertya.model.X_C_Tax;
import org.springframework.stereotype.Repository;

@Repository
public class TaxRepository extends AbstractRepository {

    public TaxRepository () {
        tableName = X_C_Tax.Table_Name;
        iface = Tax::new;
    }
}
