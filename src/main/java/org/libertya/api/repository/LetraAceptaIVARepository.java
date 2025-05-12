package org.libertya.api.repository;

import org.libertya.api.stub.model.LetraAceptaIVA;
import org.openXpertya.model.X_C_Letra_Acepta_Iva;
import org.springframework.stereotype.Repository;

@Repository
public class LetraAceptaIVARepository extends AbstractRepository {

    public LetraAceptaIVARepository() {
        tableName = X_C_Letra_Acepta_Iva.Table_Name;
        iface = LetraAceptaIVA::new;
    }
}
