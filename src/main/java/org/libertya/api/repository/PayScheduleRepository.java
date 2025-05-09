package org.libertya.api.repository;

import org.libertya.api.stub.model.PaySchedule;
import org.openXpertya.model.X_C_PaySchedule;
import org.springframework.stereotype.Repository;

@Repository
public class PayScheduleRepository extends AbstractRepository {

    public PayScheduleRepository() {
        tableName = X_C_PaySchedule.Table_Name;
        iface = PaySchedule::new;
    }
}
