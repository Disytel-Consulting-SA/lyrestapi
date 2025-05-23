package org.libertya.api.repository;

import org.libertya.api.stub.model.Bank;
import org.openXpertya.model.X_C_Bank;
import org.springframework.stereotype.Repository;

@Repository
public class BankRepository extends AbstractRepository {

    public BankRepository() {
        tableName = X_C_Bank.Table_Name;
        iface = Bank::new;
    }

}
