package org.libertya.api.repository;

import org.libertya.api.stub.model.LetraComprobante;
import org.openXpertya.model.X_C_Letra_Comprobante;
import org.springframework.stereotype.Repository;

@Repository
public class LetraComprobanteRepository extends AbstractRepository {

    public LetraComprobanteRepository() {
        tableName = X_C_Letra_Comprobante.Table_Name;
        iface = LetraComprobante::new;
    }
}
