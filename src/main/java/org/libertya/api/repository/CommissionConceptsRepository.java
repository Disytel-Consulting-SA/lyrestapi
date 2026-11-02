package org.libertya.api.repository;

import org.libertya.api.stub.model.CommissionConcepts;
import org.openXpertya.model.X_C_CommissionConcepts;
import org.springframework.stereotype.Repository;

/**
 * Comisiones de una liquidacion de tarjetas (C_CommissionConcepts).
 *
 * Las filas las genera el propio modelo: al crear la cabecera de la liquidacion, generateAllChildrens() deja
 * una fila en cero por cada concepto de tarjeta de tipo comision (type='CO'). Esta API solo las lista y les carga el importe.
 *
 * El recalculo del total CommissionAmount de la cabecera lo hace MCommissionConcepts.doAfterSave(), que corre porque
 * updateEntity() persiste con PO.save(). Aca no hay nada que elegir: el nombre de tabla va como constante de
 * la clase X_ pero es solo un String, y M_Table.getPO() resuelve la clase del modelo por convencion de
 * nombres, probando org.openXpertya.model.MCommissionConcepts antes de caer a la X_.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class CommissionConceptsRepository extends AbstractRepository {

    public CommissionConceptsRepository() {
        tableName = X_C_CommissionConcepts.Table_Name;
        iface = CommissionConcepts::new;
    }
}
