package org.libertya.api.repository;

import org.libertya.api.stub.model.CardSettlementConcepts;
import org.openXpertya.model.X_C_CardSettlementConcepts;
import org.springframework.stereotype.Repository;

/**
 * Maestro de conceptos de liquidacion de tarjetas (C_CardSettlementConcepts), de solo lectura.
 *
 * Resuelve contra que concepto se imputa cada fila de C_CommissionConcepts y de C_ExpenseConcepts. El campo
 * type separa las dos familias: 'CO' comisiones y 'OT' otros costos. Igual que en el maestro de retenciones,
 * el filtro se deja al parametro filter generico.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class CardSettlementConceptsRepository extends AbstractRepository {

    public CardSettlementConceptsRepository() {
        tableName = X_C_CardSettlementConcepts.Table_Name;
        iface = CardSettlementConcepts::new;
    }
}
