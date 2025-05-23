package org.libertya.api.repository;

import org.libertya.api.stub.model.BankAccount;
import org.openXpertya.model.X_C_BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountRepository extends AbstractRepository {

    public BankAccountRepository() {
        tableName = X_C_BankAccount.Table_Name;
        iface = BankAccount::new;
    }
}
