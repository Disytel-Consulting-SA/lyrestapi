package org.libertya.api.repository;

import org.libertya.api.security.SafeQueryFilter;
import org.libertya.api.stub.model.Storage;
import org.openXpertya.model.X_M_Storage;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Map;

/**
 * Stock por producto y ubicacion (M_Storage).
 *
 * NOTA: el campo derivado m_warehouse_id se quito al regenerar los schemas para LY 26.05 — no es columna de
 * M_Storage y no forma parte del modelo.  El filtrado por almacen SI sigue disponible
 * (?filter=M_Warehouse_ID=&lt;n&gt; o M_Warehouse_ID IN (&lt;n&gt;, ...)), como columna derivada del filtro.
 */
@Repository
public class StorageRepository extends AbstractRepository {

    /**
     * M_Warehouse_ID no existe en M_Storage: se filtra por los locators del almacen. El SQL es fijo; del filtro
     * solo se toman los ids del almacen, como parametros.
     */
    private static final Map<String, SafeQueryFilter.DerivedColumn> DERIVED_FILTER_COLUMNS =
            Collections.singletonMap("m_warehouse_id", new SafeQueryFilter.DerivedColumn(
                    "M_Locator_ID IN (SELECT l.M_Locator_ID FROM M_Locator l WHERE l.M_Warehouse_ID IN ("
                            + SafeQueryFilter.DerivedColumn.VALUES + "))"));

    public StorageRepository() {
        tableName = X_M_Storage.Table_Name;
        iface = Storage::new;
        pkColumns = new String[] {"M_Product_ID", "M_Locator_ID"};
    }

    @Override
    protected Map<String, SafeQueryFilter.DerivedColumn> derivedFilterColumns() {
        return DERIVED_FILTER_COLUMNS;
    }
}
