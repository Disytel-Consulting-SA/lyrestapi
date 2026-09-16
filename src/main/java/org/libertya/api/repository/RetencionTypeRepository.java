package org.libertya.api.repository;

import org.libertya.api.stub.model.RetencionType;
import org.openXpertya.model.X_C_RetencionType;
import org.springframework.stereotype.Repository;

/**
 * Maestro de tipos de retencion (C_RetencionType), de solo lectura.
 *
 * Traduce el codigo de negocio retentiontype ('B' = IIBB, 'G' = Ganancias, 'I' = IVA, 'J' = SIJP) a los
 * c_retenciontype_id reales, que es lo que C_RetencionSchema referencia. Con eso el consumidor puede filtrar
 * retencionschemas por tipo, que es el paso que resuelve el esquema de IIBB sufrida por jurisdiccion.
 *
 * OJO: no es una relacion 1 a 1. En una instancia real hay VARIOS tipos activos con retentiontype='B' (uno
 * por jurisdiccion mas los sufridos), asi que el filtro sobre retencionschemas tiene que ser
 * c_retenciontype_id IN (...), nunca un igual. Ningun filtro se aplica del lado del servidor.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class RetencionTypeRepository extends AbstractRepository {

    public RetencionTypeRepository() {
        tableName = X_C_RetencionType.Table_Name;
        iface = RetencionType::new;
    }
}
