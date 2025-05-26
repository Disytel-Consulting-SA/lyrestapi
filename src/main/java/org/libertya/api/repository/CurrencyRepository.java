package org.libertya.api.repository;

import org.libertya.api.stub.model.Currency;
import org.openXpertya.model.X_C_Currency;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyRepository extends AbstractRepository {

    public CurrencyRepository() {
        tableName = X_C_Currency.Table_Name;
        iface = Currency::new;
    }
}
