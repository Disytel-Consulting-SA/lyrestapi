package org.libertya.api.repository;

import org.libertya.api.stub.model.ConversionRate;
import org.openXpertya.model.X_C_Conversion_Rate;
import org.springframework.stereotype.Repository;

@Repository
public class ConversionRateRepository extends AbstractRepository {

    public ConversionRateRepository() {
        tableName = X_C_Conversion_Rate.Table_Name;
        iface = ConversionRate::new;
    }
}
