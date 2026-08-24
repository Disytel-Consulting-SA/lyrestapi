package org.libertya.api.repository;

import org.libertya.api.stub.model.WithholdingSettlement;
import org.openXpertya.model.X_C_WithholdingSettlement;
import org.springframework.stereotype.Repository;

/**
 * Retenciones sufridas de una liquidacion de tarjetas (C_WithholdingSettlement).
 *
 * Las filas las genera el propio modelo: al crear la cabecera de la liquidacion, generateAllChildrens() deja
 * una fila en cero por cada esquema de retencion sufrida activo (retencionapplication='S'). Esta API solo las lista y les carga el importe.
 *
 * El recalculo del total Withholding de la cabecera lo hace MWithholdingSettlement.doAfterSave(), que corre porque
 * updateEntity() persiste con PO.save(). Aca no hay nada que elegir: el nombre de tabla va como constante de
 * la clase X_ pero es solo un String, y M_Table.getPO() resuelve la clase del modelo por convencion de
 * nombres, probando org.openXpertya.model.MWithholdingSettlement antes de caer a la X_.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class WithholdingSettlementRepository extends AbstractRepository {

    public WithholdingSettlementRepository() {
        tableName = X_C_WithholdingSettlement.Table_Name;
        iface = WithholdingSettlement::new;
    }
}
