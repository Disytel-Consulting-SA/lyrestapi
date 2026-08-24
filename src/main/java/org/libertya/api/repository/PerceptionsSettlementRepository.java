package org.libertya.api.repository;

import org.libertya.api.stub.model.PerceptionsSettlement;
import org.openXpertya.model.X_C_PerceptionsSettlement;
import org.springframework.stereotype.Repository;

/**
 * Percepciones de una liquidacion de tarjetas (C_PerceptionsSettlement).
 *
 * Las filas las genera el propio modelo: al crear la cabecera de la liquidacion, generateAllChildrens() deja
 * una fila en cero por cada percepcion activa. Esta API solo las lista y les carga el importe.
 *
 * El recalculo del total Perception de la cabecera lo hace MPerceptionsSettlement.doAfterSave(), que corre porque
 * updateEntity() persiste con PO.save(). Aca no hay nada que elegir: el nombre de tabla va como constante de
 * la clase X_ pero es solo un String, y M_Table.getPO() resuelve la clase del modelo por convencion de
 * nombres, probando org.openXpertya.model.MPerceptionsSettlement antes de caer a la X_.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class PerceptionsSettlementRepository extends AbstractRepository {

    public PerceptionsSettlementRepository() {
        tableName = X_C_PerceptionsSettlement.Table_Name;
        iface = PerceptionsSettlement::new;
    }
}
