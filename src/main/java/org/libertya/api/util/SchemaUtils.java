package org.libertya.api.util;

import org.libertya.api.exception.ModelException;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.DB;
import org.openXpertya.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SchemaUtils {

    @Value("${restapi.libertya.app.referencedValuesDetailSuffix}")
    private String referencedValuesDetailSuffix;

    @Value("${restapi.libertya.app.referencedValuesValueSuffix}")
    private String referencedValuesValueSuffix;

    @Value("${restapi.libertya.app.nullValue}")
    private String nullValue;

    @Value("${org.libertya.api.service.forceValues}")
    private String forceValues;

    /**
     * Obtiene el map de columnas para una tabla y lo almacena en la caché
     * @param tableName el nombre de la tabla.
     * @param ctx el contexto
     * @return el map de columnas.
     */
    @Cacheable(value = "columnNameMapCache", key = "#tableName")
    public Map<String, M_Column> getColumnNameMap(String tableName, Properties ctx) {
        return getColumnResolver(tableName, ctx).getColumnNameMap();
    }

    /**
     * Obtiene el resolver de columnas para una tabla y lo almacena en la cache.
     * Permite resolver tanto claves legacy normalizadas como nombres exactos de columna.
     * @param tableName el nombre de la tabla.
     * @param ctx el contexto
     * @return el resolver de columnas.
     */
    @Cacheable(value = "columnResolverCache", key = "#tableName")
    public ColumnResolver getColumnResolver(String tableName, Properties ctx) {
        M_Table aTable = M_Table.get(ctx, tableName);
        M_Column[] columns = aTable.getColumns(false);
        return new ColumnResolver(columns);
    }

    /** Normaliza a lowercase y sin underscores el value recibido */
    public String normalize(String value) {
        return normalizeValue(value);
    }

    private static String normalizeValue(String value) {
        return value.toLowerCase().replace("_", "");
    }

    private static String exactKey(String value) {
        return value.toLowerCase();
    }

    public static class ColumnResolver {

        private final Map<String, List<M_Column>> exactColumns = new LinkedHashMap<>();
        private final Map<String, List<M_Column>> normalizedColumns = new LinkedHashMap<>();
        private final Map<String, String> apiNamesByExactName = new LinkedHashMap<>();
        private final Map<String, M_Column> columnNameMap = new LinkedHashMap<>();

        public ColumnResolver(M_Column[] columns) {
            List<M_Column> sortedColumns = new ArrayList<>(Arrays.asList(columns));
            Collections.sort(sortedColumns, Comparator.comparingInt(M_Column::getAD_Column_ID));

            for (M_Column column : sortedColumns) {
                addColumn(exactColumns, exactKey(column.getColumnName()), column);
                addColumn(normalizedColumns, normalizeValue(column.getColumnName()), column);
            }

            for (Map.Entry<String, List<M_Column>> entry : normalizedColumns.entrySet()) {
                List<M_Column> columnsForName = entry.getValue();
                if (columnsForName.size() == 1) {
                    M_Column column = columnsForName.get(0);
                    registerApiName(column, entry.getKey());
                    columnNameMap.put(entry.getKey(), column);
                } else {
                    for (M_Column column : columnsForName) {
                        String apiName = exactKey(column.getColumnName());
                        registerApiName(column, apiName);
                        columnNameMap.put(apiName, column);
                    }
                }
            }
        }

        /**
         * Resuelve una columna desde una clave externa.
         * Primero intenta el nombre exacto lower-case; luego intenta la clave legacy normalizada.
         */
        public M_Column resolve(String fieldName) throws ModelException {
            if (fieldName == null)
                return null;

            List<M_Column> exactMatches = exactColumns.get(exactKey(fieldName));
            if (exactMatches != null && !exactMatches.isEmpty())
                return exactMatches.get(0);

            String normalizedFieldName = normalizeValue(fieldName);
            List<M_Column> normalizedMatches = normalizedColumns.get(normalizedFieldName);
            if (normalizedMatches == null || normalizedMatches.isEmpty())
                return null;

            if (normalizedMatches.size() == 1)
                return normalizedMatches.get(0);

            throw new ModelException("Nombre de columna ambiguo '" + fieldName + "'. Use una de estas claves: " + getApiNames(normalizedMatches));
        }

        /**
         * Retorna el nombre a exponer por la API: legacy normalizado salvo que exista colision.
         */
        public String getApiName(M_Column column) {
            String apiName = apiNamesByExactName.get(exactKey(column.getColumnName()));
            return apiName != null ? apiName : normalizeValue(column.getColumnName());
        }

        public Map<String, M_Column> getColumnNameMap() {
            return Collections.unmodifiableMap(columnNameMap);
        }

        private void addColumn(Map<String, List<M_Column>> target, String key, M_Column column) {
            List<M_Column> columns = target.get(key);
            if (columns == null) {
                columns = new ArrayList<>();
                target.put(key, columns);
            }
            columns.add(column);
        }

        private void registerApiName(M_Column column, String apiName) {
            apiNamesByExactName.put(exactKey(column.getColumnName()), apiName);
        }

        private String getApiNames(List<M_Column> columns) {
            Set<String> names = new LinkedHashSet<>();
            for (M_Column column : columns)
                names.add(getApiName(column));
            return String.join(", ", names);
        }
    }


    /** Retorna un tableID a partir de un referenceID utilizando la cache refTable_referenceID_tableID */
    @Cacheable(value = "tableIDFromReferenceIDCache")
    public int getTableIDFromReferenceID(int referenceID) {
        String sql = "SELECT ad_table_id FROM ad_ref_table WHERE ad_reference_id = " + referenceID;
        return DB.getSQLValue(null, sql);
    }

    /** Retorna un key a partir de un referenceID utilizando la cache refTable_referenceID_key */
    @Cacheable(value = "KeyFromReferenceIDCache")
    public int getKeyFromReferenceID(int referenceID) {
        String sql = "SELECT ad_key FROM ad_ref_table WHERE ad_reference_id = " + referenceID;
        return DB.getSQLValue(null, sql);
    }

    /** Retorna un tableName a partir de un tableID utilizando la cache table_tableID_tableName */
    @Cacheable(value = "tableNameFromTableIDCache")
    public String getTableNameFromTableID(int tableID) {
        String sql = "SELECT tablename FROM ad_table WHERE ad_table_id = ? LIMIT 1";
        return DB.getSQLValueString(null, sql, tableID);
    }

    /** Retorna el sufijo a utilizar en las propiedades referenciadas (campos identificadores) o un valor por defecto si el mismo no esta configurado */
    public String getReferencedValuesDetailSuffix() {
        if (!Util.isEmpty(referencedValuesDetailSuffix))
            return referencedValuesDetailSuffix;
        return "__detail";
    }

    /** Retorna el sufijo a utilizar en las propiedades referenciadas (campo value) o un valor por defecto si el mismo no esta configurado */
    public String getReferencedValuesValueSuffix() {
        if (!Util.isEmpty(referencedValuesValueSuffix))
            return referencedValuesValueSuffix;
        return "__value";
    }

    /** Retorna el valor para seteo de nulls en actualizaciones o un valor por defecto si el mismo no esta configurado */
    public String getNullValue() {
        if (!Util.isEmpty(nullValue))
            return nullValue;
        return "[NULL]";
    }

    /** Forzar la asignacion de valores omitiendo el modelo? Retorna el valor configurado o false en caso contrario */
    public boolean shouldForceValues() {
        return (!Util.isEmpty(forceValues) && "Y".equalsIgnoreCase(forceValues));
    }
}
