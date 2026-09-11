package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.stub.model.ColumnLookupValue;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ColumnLookupRepository {

    private static final int REFERENCE_TABLE = 18;
    private static final int REFERENCE_TABLE_DIRECT = 19;
    private static final int REFERENCE_SEARCH = 30;

    private static final int DEFAULT_LIMIT = 50;
    private static final int DEFAULT_PAGE = 1;

    public List<ColumnLookupValue> retrieve(UserInfo info, Integer columnId, Integer limit, Integer page, String search, String value) {
        ColumnInfo column = loadColumnInfo(columnId);
        if (column == null) return null;

        int effectiveLimit = limit != null && limit > 0 ? limit : DEFAULT_LIMIT;
        int effectivePage = page != null && page > 0 ? page : DEFAULT_PAGE;

        /*
         * TABLE
         */
        if (column.referenceId == REFERENCE_TABLE) {
            return retrieveTable(info, column, effectiveLimit, effectivePage, search, value);
        }

        /*
         * TABLE DIRECT
         */
        if (column.referenceId == REFERENCE_TABLE_DIRECT) {
            return retrieveTableDirect(info, column, effectiveLimit, effectivePage, search, value);
        }

        /*
         * SEARCH
         *
         * Libertya trata Search de dos maneras:
         * - Con AD_Reference_Value_ID: utiliza la lógica de Table.
         * - Sin AD_Reference_Value_ID: utiliza la lógica de Table Direct.
         */
        if (column.referenceId == REFERENCE_SEARCH) {
            if (column.referenceValueId != null && column.referenceValueId > 0) {
                return retrieveTable(info, column, effectiveLimit, effectivePage, search, value);
            }

            return retrieveTableDirect(info, column, effectiveLimit, effectivePage, search, value);
        }

        return new ArrayList<>();
    }

    /**
     * Metadata básica de AD_Column.
     */
    private ColumnInfo loadColumnInfo(Integer columnId) {
        String sql = " SELECT c.ad_column_id, c.columnname, c.ad_reference_id, c.ad_reference_value_id, "
                + "   c.ad_val_rule_id, vr.code AS validation_code "
                + " FROM ad_column c "
                + " LEFT JOIN ad_val_rule vr ON vr.ad_val_rule_id = c.ad_val_rule_id AND vr.isactive = 'Y' "
                + " WHERE c.ad_column_id = ? AND c.isactive = 'Y' ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setInt(1, columnId);
            rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            ColumnInfo result = new ColumnInfo();
            result.columnId = rs.getInt("ad_column_id");
            result.columnName = rs.getString("columnname");
            result.referenceId = rs.getInt("ad_reference_id");
            result.referenceValueId = rs.getInt("ad_reference_value_id");

            int validationRuleId = rs.getInt("ad_val_rule_id");
            result.validationRuleId = rs.wasNull() ? null : validationRuleId;
            result.validationCode = rs.getString("validation_code");

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Error recuperando metadata de AD_Column " + columnId, e);
        } finally {
            DB.close(rs, ps);
        }
    }

    /**
     * =========================================================
     * TABLE
     * =========================================================
     */
    private List<ColumnLookupValue> retrieveTable(UserInfo info, ColumnInfo column, int limit, int page, String search, String value) {
        if (column.referenceValueId == null || column.referenceValueId <= 0) {
            return new ArrayList<>();
        }

        TableReferenceInfo referenceInfo = loadTableReferenceInfo(column.referenceValueId);

        if (referenceInfo == null || referenceInfo.tableName == null || referenceInfo.keyColumn == null || referenceInfo.displayColumn == null) {
            return new ArrayList<>();
        }

        String displayExpression = buildTableDisplayExpression(referenceInfo);
        boolean hasSearch = search != null && !search.trim().isEmpty();
        boolean hasValue = value != null && !value.trim().isEmpty();
        String validationCode = resolveValidationCode(info, column);

        /*
         * Sólo filtramos por client si:
         * - existe contexto de usuario
         * - no estamos en System (clientID != 0)
         * - la tabla efectivamente posee AD_Client_ID
         */
        boolean hasClientFilter = shouldFilterByClient(info, referenceInfo.tableName);

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ").append(referenceInfo.tableName).append(".").append(referenceInfo.keyColumn).append(" AS lookup_value, ");
        sql.append(displayExpression).append(" AS lookup_name, ");
        sql.append(referenceInfo.tableName).append(".isactive AS lookup_isactive ");
        sql.append(" FROM ").append(referenceInfo.tableName).append(" ");

        boolean hasWhere = false;

        /*
         * Resolución puntual por ID.
         */
        if (hasValue) {
            sql.append(" WHERE ").append(referenceInfo.tableName).append(".").append(referenceInfo.keyColumn).append(" = ? ");
            hasWhere = true;
        }

        /*
         * Búsqueda textual.
         */
        if (hasSearch) {
            sql.append(hasWhere ? " AND " : " WHERE ");
            sql.append(" lower(").append(displayExpression).append(") LIKE ? ");
            hasWhere = true;
        }

        /*
         * Filtro por compañía.
         *
         * Se permiten:
         * AD_Client_ID = 0
         * AD_Client_ID = compañía activa
         */
        if (hasClientFilter) {
            sql.append(hasWhere ? " AND " : " WHERE ");
            sql.append(referenceInfo.tableName).append(".ad_client_id IN (0, ?) ");
            hasWhere = true;
        }

        /*
         * Regla de validación definida en AD_Column.AD_Val_Rule_ID.
         */
        if (validationCode != null) {
            sql.append(hasWhere ? " AND " : " WHERE ");
            sql.append("(").append(validationCode).append(") ");
            hasWhere = true;
        }

        sql.append(" ORDER BY lookup_name ");
        sql.append(" LIMIT ? OFFSET ? ");

        return executeLookupQuery(
                sql.toString(), limit, page, search, hasSearch, value, hasValue,
                hasClientFilter ? info.getClientID() : null, hasClientFilter,
                "Table para columna " + column.columnId
        );
    }

    /**
     * Recupera la configuración explícita de AD_Ref_Table.
     */
    private TableReferenceInfo loadTableReferenceInfo(Integer referenceId) {
        String sql = " SELECT t.tablename, ck.columnname AS key_column, cd.columnname AS display_column, "
                + "   rt.isvaluedisplayed, rt.whereclause, rt.orderbyclause "
                + " FROM ad_ref_table rt "
                + " JOIN ad_table t ON t.ad_table_id = rt.ad_table_id "
                + " JOIN ad_column ck ON ck.ad_column_id = rt.ad_key "
                + " JOIN ad_column cd ON cd.ad_column_id = rt.ad_display "
                + " WHERE rt.ad_reference_id = ? ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setInt(1, referenceId);
            rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            TableReferenceInfo result = new TableReferenceInfo();
            result.tableName = rs.getString("tablename");
            result.keyColumn = rs.getString("key_column");
            result.displayColumn = rs.getString("display_column");
            result.valueDisplayed = "Y".equals(rs.getString("isvaluedisplayed"));
            result.whereClause = rs.getString("whereclause");
            result.orderByClause = rs.getString("orderbyclause");

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Error recuperando AD_Ref_Table para AD_Reference_ID " + referenceId, e);
        } finally {
            DB.close(rs, ps);
        }
    }

    /**
     * Primera implementación:
     * usa directamente AD_Ref_Table.AD_Display.
     */
    private String buildTableDisplayExpression(TableReferenceInfo referenceInfo) {
        return "COALESCE(CAST(" + referenceInfo.tableName + "." + referenceInfo.displayColumn + " AS VARCHAR), '')";
    }

    /**
     * =========================================================
     * TABLE DIRECT
     * =========================================================
     */
    private List<ColumnLookupValue> retrieveTableDirect(UserInfo info, ColumnInfo column, int limit, int page, String search, String value) {
        String tableName = inferTableName(column.columnName);
        if (tableName == null) return new ArrayList<>();

        TableLookupInfo lookupInfo = loadTableLookupInfo(tableName);
        if (lookupInfo == null || lookupInfo.keyColumn == null || lookupInfo.identifierColumns.isEmpty()) {
            return new ArrayList<>();
        }

        String displayExpression = buildTableDirectDisplayExpression(tableName, lookupInfo.identifierColumns);
        boolean hasSearch = search != null && !search.trim().isEmpty();
        boolean hasValue = value != null && !value.trim().isEmpty();
        boolean hasClientFilter = shouldFilterByClient(info, tableName);
        String validationCode = resolveValidationCode(info, column);

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ").append(tableName).append(".").append(lookupInfo.keyColumn).append(" AS lookup_value, ");
        sql.append(displayExpression).append(" AS lookup_name, ");
        sql.append(tableName).append(".isactive AS lookup_isactive ");
        sql.append(" FROM ").append(tableName).append(" ");

        boolean hasWhere = false;

        /*
         * Resolución puntual por ID.
         */
        if (hasValue) {
            sql.append(" WHERE ").append(tableName).append(".").append(lookupInfo.keyColumn).append(" = ? ");
            hasWhere = true;
        }

        /*
         * Búsqueda textual.
         */
        if (hasSearch) {
            sql.append(hasWhere ? " AND " : " WHERE ");
            sql.append(" lower(").append(displayExpression).append(") LIKE ? ");
            hasWhere = true;
        }

        /*
         * Filtro por compañía.
         */
        if (hasClientFilter) {
            sql.append(hasWhere ? " AND " : " WHERE ");
            sql.append(tableName).append(".ad_client_id IN (0, ?) ");
            hasWhere = true;
        }

        /*
         * Regla de validación definida en AD_Column.AD_Val_Rule_ID.
         */
        if (validationCode != null) {
            sql.append(hasWhere ? " AND " : " WHERE ");
            sql.append("(").append(validationCode).append(") ");
            hasWhere = true;
        }

        sql.append(" ORDER BY lookup_name ");
        sql.append(" LIMIT ? OFFSET ? ");

        return executeLookupQuery(
                sql.toString(), limit, page, search, hasSearch, value, hasValue,
                hasClientFilter ? info.getClientID() : null, hasClientFilter,
                "Table Direct para columna " + column.columnId
        );
    }

    /**
     * Inferencia Table Direct.
     */
    private String inferTableName(String columnName) {
        if (columnName == null) return null;

        /*
         * Excepción histórica de Libertya.
         */
        if ("AD_OrgBP_ID".equalsIgnoreCase(columnName)) {
            return "AD_Org";
        }

        if (!columnName.toUpperCase().endsWith("_ID")) {
            return null;
        }

        return columnName.substring(0, columnName.length() - 3);
    }

    /**
     * Recupera key e identificadores de la tabla referenciada.
     */
    private TableLookupInfo loadTableLookupInfo(String tableName) {
        String sql = " SELECT c.columnname, c.iskey, c.isidentifier, c.seqno "
                + " FROM ad_table t "
                + " JOIN ad_column c ON c.ad_table_id = t.ad_table_id "
                + " WHERE lower(t.tablename) = lower(?) AND t.isactive = 'Y' AND c.isactive = 'Y' "
                + "   AND (c.iskey = 'Y' OR c.isidentifier = 'Y') "
                + " ORDER BY c.seqno ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setString(1, tableName);
            rs = ps.executeQuery();

            TableLookupInfo result = new TableLookupInfo();

            while (rs.next()) {
                String columnName = rs.getString("columnname");

                if ("Y".equals(rs.getString("iskey"))) {
                    result.keyColumn = columnName;
                }

                if ("Y".equals(rs.getString("isidentifier"))) {
                    result.identifierColumns.add(columnName);
                }
            }

            if (result.keyColumn == null && result.identifierColumns.isEmpty()) {
                return null;
            }

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Error recuperando metadata de lookup para tabla " + tableName, e);
        } finally {
            DB.close(rs, ps);
        }
    }

    /**
     * Resuelve la regla de validación configurada en AD_Column.AD_Val_Rule_ID.
     *
     * En esta primera etapa se resuelve únicamente con el contexto global
     * disponible en UserInfo (#AD_Client_ID, #AD_Org_ID, #AD_User_ID,
     * #AD_Role_ID, etc.).
     *
     * Las reglas que todavía contengan variables de ventana/registro se
     * ignoran hasta incorporar contexto dinámico al endpoint de lookup.
     */
    private String resolveValidationCode(UserInfo info, ColumnInfo column) {
        if (info == null || column.validationCode == null || column.validationCode.trim().isEmpty()) {
            return null;
        }

        String validation = Env.parseContext(info.getCtx(), 0, column.validationCode, true, true);

        if (validation == null || validation.trim().isEmpty()) {
            return null;
        }

        /*
         * Si quedaron variables sin resolver significa que la regla depende
         * del contexto dinámico de la ventana/registro. Todavía no debemos
         * enviarla a PostgreSQL.
         */
        if (validation.indexOf('@') >= 0) {
            return null;
        }

        return validation.trim();
    }

    /**
     * Determina si debe aplicarse filtro por compañía.
     * System (clientID = 0) mantiene acceso global.
     */
    private boolean shouldFilterByClient(UserInfo info, String tableName) {
        if (info == null || info.getClientID() == 0) {
            return false;
        }
        return tableHasClientId(tableName);
    }

    /**
     * Determina mediante metadata si la tabla posee una columna AD_Client_ID activa.
     */
    private boolean tableHasClientId(String tableName) {
        String sql = " SELECT 1 FROM ad_table t "
                + " JOIN ad_column c ON c.ad_table_id = t.ad_table_id "
                + " WHERE lower(t.tablename) = lower(?) AND t.isactive = 'Y' AND c.isactive = 'Y' "
                + "   AND lower(c.columnname) = 'ad_client_id' "
                + " LIMIT 1 ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setString(1, tableName);
            rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException("Error determinando si la tabla " + tableName + " posee AD_Client_ID", e);
        } finally {
            DB.close(rs, ps);
        }
    }

    /**
     * Construye el texto visible para Table Direct.
     */
    private String buildTableDirectDisplayExpression(String tableName, List<String> identifierColumns) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < identifierColumns.size(); i++) {
            if (i > 0) {
                result.append(" || '_' || ");
            }
            result.append("COALESCE(CAST(").append(tableName).append(".").append(identifierColumns.get(i)).append(" AS VARCHAR), '')");
        }

        return result.toString();
    }

    /**
     * Ejecución común para Table, Table Direct y Search.
     */
    private List<ColumnLookupValue> executeLookupQuery(
            String sql, int limit, int page, String search, boolean hasSearch,
            String value, boolean hasValue, Integer clientId, boolean hasClientFilter, String description) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            int parameterIndex = 1;

            /*
             * El orden de parámetros debe coincidir con el armado del WHERE:
             * 1. value
             * 2. search
             * 3. clientId
             * 4. limit
             * 5. offset
             */
            if (hasValue) {
                /*
                 * La mayoría de las keys son Integer.
                 * Si no puede convertirse se utiliza String.
                 */
                try {
                    int intValue = Integer.parseInt(value);
                    ps.setInt(parameterIndex, intValue);
                } catch (NumberFormatException e) {
                    ps.setString(parameterIndex, value);
                }
                parameterIndex++;
            }

            if (hasSearch) {
                ps.setString(parameterIndex++, "%" + search.trim().toLowerCase() + "%");
            }

            if (hasClientFilter) {
                ps.setInt(parameterIndex++, clientId);
            }

            ps.setInt(parameterIndex++, limit);

            int offset = (page - 1) * limit;
            ps.setInt(parameterIndex, offset);

            rs = ps.executeQuery();
            List<ColumnLookupValue> result = new ArrayList<>();

            while (rs.next()) {
                Object key = rs.getObject("lookup_value");
                ColumnLookupValue valueItem = new ColumnLookupValue()
                        .value(key != null ? String.valueOf(key) : null)
                        .name(rs.getString("lookup_name"))
                        .isactive("Y".equals(rs.getString("lookup_isactive")));

                result.add(valueItem);
            }

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Error recuperando lookup " + description, e);
        } finally {
            DB.close(rs, ps);
        }
    }

    private static class ColumnInfo {
        private Integer columnId;
        private String columnName;
        private Integer referenceId;
        private Integer referenceValueId;
        private Integer validationRuleId;
        private String validationCode;
    }

    private static class TableLookupInfo {
        private String keyColumn;
        private final List<String> identifierColumns = new ArrayList<>();
    }

    private static class TableReferenceInfo {
        private String tableName;
        private String keyColumn;
        private String displayColumn;
        private boolean valueDisplayed;
        private String whereClause;
        private String orderByClause;
    }
}