package org.libertya.api.repository;

import org.libertya.api.stub.model.Year;
import org.openXpertya.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class YearRepository extends AbstractRepository {

    public YearRepository() {
        tableName = X_C_Year.Table_Name;
        iface = Year::new;
    }

}
