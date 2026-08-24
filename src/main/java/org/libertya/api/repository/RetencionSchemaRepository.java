package org.libertya.api.repository;

import org.libertya.api.stub.model.RetencionSchema;
import org.openXpertya.model.X_C_RetencionSchema;
import org.springframework.stereotype.Repository;

/**
 * Maestro de esquemas de retencion (C_RetencionSchema), de solo lectura.
 *
 * Resuelve contra que esquema se imputa cada fila de C_WithholdingSettlement. Las de una liquidacion de
 * tarjetas son las SUFRIDAS: retencionapplication='S'. Ese filtro NO se aplica aca sino que se deja al
 * parametro filter generico, porque el maestro tambien tiene las emitidas ('E') y limitarlo del lado del
 * servidor lo volveria inservible para cualquier otro uso.
 *
 * c_region_id viaja en la propia fila; no hay que resolverlo por separado.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class RetencionSchemaRepository extends AbstractRepository {

    public RetencionSchemaRepository() {
        tableName = X_C_RetencionSchema.Table_Name;
        iface = RetencionSchema::new;
    }
}
