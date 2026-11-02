package org.libertya.api.repository;

import org.libertya.api.stub.model.OrgInfo;
import org.openXpertya.model.X_AD_OrgInfo;
import org.springframework.stereotype.Repository;

/**
 * Informacion adicional de organizaciones (AD_OrgInfo), de solo lectura.
 *
 * AD_OrgInfo NO tiene AD_OrgInfo_ID: es una extension 1 a 1 de AD_Org y su PK es AD_Org_ID. Por eso se
 * declara pkColumns, igual que en las tablas _Trl: el {id} de /orginfos/{id} es directamente el ad_org_id,
 * y el consumidor no necesita pasar por filter para llegar a la fila de una organizacion.
 *
 * Lo que interesa para una liquidacion de tarjetas es c_location_id, que via locations.c_region_id da la
 * jurisdiccion de la sucursal (segundo nivel de prioridad del core al resolver el esquema de IIBB sufrida:
 * region de la entidad financiera, si no la de la organizacion, si no la del bpartner).
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Repository
public class OrgInfoRepository extends AbstractRepository {

    public OrgInfoRepository() {
        tableName = X_AD_OrgInfo.Table_Name;
        iface = OrgInfo::new;
        pkColumns = new String[] {"AD_Org_ID"};
    }
}
