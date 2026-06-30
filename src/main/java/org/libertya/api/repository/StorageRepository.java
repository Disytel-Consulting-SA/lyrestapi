package org.libertya.api.repository;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.stub.model.Storage;
import org.openXpertya.model.X_M_Storage;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class StorageRepository extends AbstractRepository {

    /**
     * Nombre normalizado (lowercase, sin underscores) del campo derivado m_warehouse_id,
     * usado para respetar el filtro de campos (parametro "fields").
     *
     * NOTA: m_warehouse_id NO es columna de M_Storage; es un campo DERIVADO que se resuelve aqui
     *       (M_Storage.M_Locator_ID -> M_Locator.M_Warehouse_ID), por lo que AbstractRepository no lo
     *       puede mapear automaticamente. Este campo se agrego manualmente en model/storage.yaml y en
     *       Storage.java; si se regenera el schema/clases con genSchema.sh/genClasses.sh debe reponerse.
     */
    private static final String WAREHOUSE_FIELD = "mwarehouseid";

    public StorageRepository() {
        tableName = X_M_Storage.Table_Name;
        iface = Storage::new;
        pkColumns = new String[] {"M_Product_ID", "M_Locator_ID"};
    }

    /**
     * Sobreescribe la carga de la entidad para completar el campo derivado m_warehouse_id a partir del locator.
     * Tanto la recuperacion individual como los listados pasan por este metodo, con lo cual queda cubierto en ambos casos.
     */
    @Override
    protected <T> Optional<T> loadEntityFromPO(UserInfo info, int[] id, String tableName, String trxName, String filterFields, SpawnModelInstanceInterface target) throws ModelException, AuthException {
        Optional<T> result = super.loadEntityFromPO(info, id, tableName, trxName, filterFields, target);
        // Respetar el filtro de campos (parametro "fields"): solo completar si se pidio (o si no hay filtro)
        Set<String> includeFields = getFilterFields(filterFields);
        if (includeFields != null && !includeFields.contains(WAREHOUSE_FIELD)) {
            return result;
        }
        // El locator es la segunda columna de la PK de M_Storage (pkColumns = {M_Product_ID, M_Locator_ID}).
        // Se usa el id de la PK (en lugar de storage.getMLocatorId()) para no depender de si el campo m_locator_id
        // fue o no incluido segun el parametro "fields".
        Integer locatorId = (id != null && id.length >= 2) ? id[1] : null;
        result.ifPresent(entity -> {
            Storage storage = (Storage) entity;
            Integer theLocator = locatorId != null ? locatorId : storage.getMLocatorId();
            if (theLocator != null) {
                int warehouseId = DB.getSQLValue(trxName,
                        "SELECT M_Warehouse_ID FROM M_Locator WHERE M_Locator_ID = ?",
                        theLocator);
                if (warehouseId > 0) {
                    storage.setMWarehouseId(warehouseId);
                }
            }
        });
        return result;
    }

    @Override
    public <T> List<T> retrieveAll(UserInfo info, QueryParams params) throws ModelException, AuthException {
        return super.retrieveAll(info, rewriteWarehouseFilter(params));
    }

    @Override
    public <T> List<T> retrieveAll(UserInfo info, String trxName, QueryParams params) throws ModelException, AuthException {
        return super.retrieveAll(info, trxName, rewriteWarehouseFilter(params));
    }

    /**
     * Permite filtrar por almacen (?filter=M_Warehouse_ID=&lt;n&gt;) pese a que dicha columna no existe en M_Storage.
     * Reescribe la condicion de igualdad sobre M_Warehouse_ID a un subquery sobre el locator, dado que el motor de
     * listados de AbstractRepository inyecta el filtro como WHERE directo sobre la tabla de la entidad (M_Storage).
     */
    protected QueryParams rewriteWarehouseFilter(QueryParams params) {
        if (params == null || params.getFilter() == null) {
            return params;
        }
        String rewritten = params.getFilter().replaceAll(
                "(?i)M_Warehouse_ID\\s*=\\s*(\\d+)",
                "M_Locator_ID IN (SELECT M_Locator_ID FROM M_Locator WHERE M_Warehouse_ID = $1)");
        if (rewritten.equals(params.getFilter())) {
            return params;
        }
        return new QueryParams(rewritten, params.getFields(), params.getSort(), params.getLimit(), params.getPage());
    }
}
