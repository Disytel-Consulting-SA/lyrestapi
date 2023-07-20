package org.libertya.api.util;

import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class SchemaUtils {

    /**
     * Obtiene el map de columnas para una tabla y lo almacena en la caché
     * @param tableName el nombre de la tabla.
     * @param ctx el contexto
     * @return el map de columnas.
     */
    @Cacheable(value = "columnNameMapCache", key = "#tableName")
    public Map<String, M_Column> getColumnNameMap(String tableName, Properties ctx) {
        M_Table aTable = M_Table.get(ctx, tableName);
        M_Column[] columns = aTable.getColumns(false);
        return Arrays.stream(columns).collect(Collectors.toMap(c -> normalize(c.getColumnName()), c -> c));
    }

    /** Normaliza a lowercase y sin underscores el value recibido */
    public String normalize(String value) {
        return value.toLowerCase().replace("_", "");
    }
}
