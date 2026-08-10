package org.libertya.api.repository;

import org.libertya.api.stub.model.ValidCombination;
import org.openXpertya.model.X_C_ValidCombination;
import org.springframework.stereotype.Repository;

@Repository
public class ValidCombinationRepository extends AbstractRepository {

    public ValidCombinationRepository() {
        tableName = X_C_ValidCombination.Table_Name;
        iface = ValidCombination::new;
    }
}
