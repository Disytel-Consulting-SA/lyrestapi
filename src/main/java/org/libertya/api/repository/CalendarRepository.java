package org.libertya.api.repository;

import org.libertya.api.stub.model.Calendar;
import org.openXpertya.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class CalendarRepository extends AbstractRepository {

    public CalendarRepository() {
        tableName = X_C_Calendar.Table_Name;
        iface = Calendar::new;
    }

}
