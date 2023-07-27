package org.libertya.api.util;

import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.DB;
import org.openXpertya.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class SchemaUtils {

    @Value("${restapi.libertya.app.referencedValuesDetailSuffix}")
    private String referencedValuesDetailSuffix;

    @Value("${restapi.libertya.app.referencedValuesValueSuffix}")
    private String referencedValuesValueSuffix;

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
}
