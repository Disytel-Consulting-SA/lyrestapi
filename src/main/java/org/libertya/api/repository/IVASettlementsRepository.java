package org.libertya.api.repository;

import org.libertya.api.stub.model.IVASettlements;
import org.openXpertya.model.X_C_IVASettlements;
import org.springframework.stereotype.Repository;

/**
 * IVA de una liquidacion de tarjetas (C_IVASettlements).
 *
 * Las filas las genera el propio modelo: al crear la cabecera de la liquidacion, generateAllChildrens() deja
 * una fila en cero por cada impuesto activo. Esta API solo las lista y les carga el importe.
 *
 * El recalculo del total IVAAmount de la cabecera lo hace MIVASettlements.doAfterSave(), que corre porque
 * updateEntity() persiste con PO.save(). Aca no hay nada que elegir: el nombre de tabla va como constante de
 * la clase X_ pero es solo un String, y M_Table.getPO() resuelve la clase del modelo por convencion de
 * nombres, probando org.openXpertya.model.MIVASettlements antes de caer a la X_.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class IVASettlementsRepository extends AbstractRepository {

    public IVASettlementsRepository() {
        tableName = X_C_IVASettlements.Table_Name;
        iface = IVASettlements::new;
    }
}
