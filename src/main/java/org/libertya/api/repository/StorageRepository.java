package org.libertya.api.repository;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.stub.model.Storage;
import org.openXpertya.model.X_M_Storage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Stock por producto y ubicacion (M_Storage).
 *
 * NOTA: el campo derivado m_warehouse_id se quito al regenerar los schemas para LY 26.05 — no es columna de
 * M_Storage y no forma parte del modelo.  El filtrado por almacen SI sigue disponible
 * (?filter=M_Warehouse_ID=&lt;n&gt;), resuelto contra el locator en rewriteWarehouseFilter.
 */
@Repository
public class StorageRepository extends AbstractRepository {

    public StorageRepository() {
        tableName = X_M_Storage.Table_Name;
        iface = Storage::new;
        pkColumns = new String[] {"M_Product_ID", "M_Locator_ID"};
    }

    @Override
    public <T> List<T> retrieveAll(UserInfo info, QueryParams params) throws ModelException, AuthException {
        return super.retrieveAll(info, rewriteWarehouseFilter(params));
    }

    @Override
    public <T> List<T> retrieveAll(UserInfo info, String trxName, QueryParams params) throws ModelException, AuthException {
        return super.retrieveAll(info, trxName, rewriteWarehouseFilter(params));
    }

    @Override
    public int countAll(UserInfo info, QueryParams params) throws ModelException, AuthException {
        return super.countAll(info, rewriteWarehouseFilter(params));
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
