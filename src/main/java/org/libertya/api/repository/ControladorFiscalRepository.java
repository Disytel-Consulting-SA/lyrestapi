package org.libertya.api.repository;

import org.libertya.api.stub.model.ControladorFiscal;
import org.openXpertya.model.X_C_Controlador_Fiscal;
import org.springframework.stereotype.Repository;

@Repository
public class ControladorFiscalRepository  extends AbstractRepository {

    public ControladorFiscalRepository() {
        tableName = X_C_Controlador_Fiscal.Table_Name;
        iface = ControladorFiscal::new;
    }
}
