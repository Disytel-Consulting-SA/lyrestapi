package org.libertya.api.repository;

import org.libertya.api.stub.model.ExpenseConcepts;
import org.openXpertya.model.X_C_ExpenseConcepts;
import org.springframework.stereotype.Repository;

/**
 * Otros costos de una liquidacion de tarjetas (C_ExpenseConcepts).
 *
 * Las filas las genera el propio modelo: al crear la cabecera de la liquidacion, generateAllChildrens() deja
 * una fila en cero por cada concepto de tarjeta de tipo otros (type='OT'). Esta API solo las lista y les carga el importe.
 *
 * El recalculo del total Expenses de la cabecera lo hace MExpenseConcepts.doAfterSave(), que corre porque
 * updateEntity() persiste con PO.save(). Aca no hay nada que elegir: el nombre de tabla va como constante de
 * la clase X_ pero es solo un String, y M_Table.getPO() resuelve la clase del modelo por convencion de
 * nombres, probando org.openXpertya.model.MExpenseConcepts antes de caer a la X_.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class ExpenseConceptsRepository extends AbstractRepository {

    public ExpenseConceptsRepository() {
        tableName = X_C_ExpenseConcepts.Table_Name;
        iface = ExpenseConcepts::new;
    }
}
