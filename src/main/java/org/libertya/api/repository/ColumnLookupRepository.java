package org.libertya.api.repository;

import org.libertya.api.stub.model.ColumnLookupValue;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ColumnLookupRepository {

    private static final int REFERENCE_TABLE = 18;
    private static final int REFERENCE_TABLE_DIRECT = 19;

    private static final int DEFAULT_LIMIT = 50;
    private static final int DEFAULT_PAGE = 1;


    public List<ColumnLookupValue> retrieve(
            Integer columnId,
            Integer limit,
            Integer page,
            String search,
            String value) {

        ColumnInfo column =
                loadColumnInfo(columnId);

        if (column == null) {
            return null;
        }


        int effectiveLimit =
                limit != null && limit > 0
                        ? limit
                        : DEFAULT_LIMIT;

        int effectivePage =
                page != null && page > 0
                        ? page
                        : DEFAULT_PAGE;


        if (column.referenceId == REFERENCE_TABLE) {

            return retrieveTable(
                    column,
                    effectiveLimit,
                    effectivePage,
                    search,
                    value
            );
        }


        if (column.referenceId == REFERENCE_TABLE_DIRECT) {

            return retrieveTableDirect(
                    column,
                    effectiveLimit,
                    effectivePage,
                    search,
                    value
            );
        }


        return new ArrayList<>();
    }


    /**
     * Metadata básica de AD_Column.
     */
    private ColumnInfo loadColumnInfo(
            Integer columnId) {

        String sql =
                " SELECT " +
                        "   c.ad_column_id, " +
                        "   c.columnname, " +
                        "   c.ad_reference_id, " +
                        "   c.ad_reference_value_id " +
                        " FROM ad_column c " +
                        " WHERE c.ad_column_id = ? " +
                        "   AND c.isactive = 'Y' ";


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(
                    sql,
                    null
            );

            ps.setInt(
                    1,
                    columnId
            );

            rs = ps.executeQuery();


            if (!rs.next()) {
                return null;
            }


            ColumnInfo result =
                    new ColumnInfo();

            result.columnId =
                    rs.getInt(
                            "ad_column_id"
                    );

            result.columnName =
                    rs.getString(
                            "columnname"
                    );

            result.referenceId =
                    rs.getInt(
                            "ad_reference_id"
                    );

            result.referenceValueId =
                    rs.getInt(
                            "ad_reference_value_id"
                    );


            return result;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando metadata "
                            + "de AD_Column "
                            + columnId,
                    e
            );

        } finally {

            DB.close(rs, ps);
        }
    }


    /**
     * =========================================================
     * TABLE
     * =========================================================
     */
    private List<ColumnLookupValue> retrieveTable(
            ColumnInfo column,
            int limit,
            int page,
            String search,
            String value) {

        if (column.referenceValueId == null
                || column.referenceValueId <= 0) {

            return new ArrayList<>();
        }


        TableReferenceInfo referenceInfo =
                loadTableReferenceInfo(
                        column.referenceValueId
                );


        if (referenceInfo == null
                || referenceInfo.tableName == null
                || referenceInfo.keyColumn == null
                || referenceInfo.displayColumn == null) {

            return new ArrayList<>();
        }


        String displayExpression =
                buildTableDisplayExpression(
                        referenceInfo
                );


        StringBuilder sql =
                new StringBuilder();


        sql.append(" SELECT ");

        sql.append(referenceInfo.tableName);
        sql.append(".");
        sql.append(referenceInfo.keyColumn);
        sql.append(" AS lookup_value, ");

        sql.append(displayExpression);
        sql.append(" AS lookup_name, ");

        sql.append(referenceInfo.tableName);
        sql.append(".isactive AS lookup_isactive ");

        sql.append(" FROM ");
        sql.append(referenceInfo.tableName);
        sql.append(" ");


        boolean hasSearch =
                search != null
                        && !search.trim().isEmpty();

        boolean hasValue =
                value != null
                        && !value.trim().isEmpty();


        boolean hasWhere = false;


        if (hasValue) {

            sql.append(" WHERE ");

            sql.append(referenceInfo.tableName);
            sql.append(".");
            sql.append(referenceInfo.keyColumn);

            sql.append(" = ? ");

            hasWhere = true;
        }


        if (hasSearch) {

            sql.append(
                    hasWhere
                            ? " AND "
                            : " WHERE "
            );

            sql.append(" lower(");
            sql.append(displayExpression);
            sql.append(") LIKE ? ");
        }


        sql.append(
                " ORDER BY lookup_name "
        );

        sql.append(
                " LIMIT ? OFFSET ? "
        );


        return executeLookupQuery(
                sql.toString(),
                limit,
                page,
                search,
                hasSearch,
                value,
                hasValue,
                "Table para columna "
                        + column.columnId
        );
    }


    /**
     * Recupera la configuración explícita de AD_Ref_Table.
     */
    private TableReferenceInfo loadTableReferenceInfo(
            Integer referenceId) {

        String sql =
                " SELECT " +
                        "   t.tablename, " +
                        "   ck.columnname AS key_column, " +
                        "   cd.columnname AS display_column, " +
                        "   rt.isvaluedisplayed, " +
                        "   rt.whereclause, " +
                        "   rt.orderbyclause " +

                        " FROM ad_ref_table rt " +

                        " JOIN ad_table t " +
                        "   ON t.ad_table_id = rt.ad_table_id " +

                        " JOIN ad_column ck " +
                        "   ON ck.ad_column_id = rt.ad_key " +

                        " JOIN ad_column cd " +
                        "   ON cd.ad_column_id = rt.ad_display " +

                        " WHERE rt.ad_reference_id = ? ";


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(
                    sql,
                    null
            );

            ps.setInt(
                    1,
                    referenceId
            );

            rs = ps.executeQuery();


            if (!rs.next()) {
                return null;
            }


            TableReferenceInfo result =
                    new TableReferenceInfo();

            result.tableName =
                    rs.getString(
                            "tablename"
                    );

            result.keyColumn =
                    rs.getString(
                            "key_column"
                    );

            result.displayColumn =
                    rs.getString(
                            "display_column"
                    );

            result.valueDisplayed =
                    "Y".equals(
                            rs.getString(
                                    "isvaluedisplayed"
                            )
                    );

            result.whereClause =
                    rs.getString(
                            "whereclause"
                    );

            result.orderByClause =
                    rs.getString(
                            "orderbyclause"
                    );


            return result;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando AD_Ref_Table "
                            + "para AD_Reference_ID "
                            + referenceId,
                    e
            );

        } finally {

            DB.close(rs, ps);
        }
    }


    /**
     * Primera implementación:
     * usa directamente AD_Ref_Table.AD_Display.
     */
    private String buildTableDisplayExpression(
            TableReferenceInfo referenceInfo) {

        return "COALESCE(CAST("
                + referenceInfo.tableName
                + "."
                + referenceInfo.displayColumn
                + " AS VARCHAR), '')";
    }


    /**
     * =========================================================
     * TABLE DIRECT
     * =========================================================
     */
    private List<ColumnLookupValue> retrieveTableDirect(
            ColumnInfo column,
            int limit,
            int page,
            String search,
            String value) {

        String tableName =
                inferTableName(
                        column.columnName
                );


        if (tableName == null) {
            return new ArrayList<>();
        }


        TableLookupInfo lookupInfo =
                loadTableLookupInfo(
                        tableName
                );


        if (lookupInfo == null
                || lookupInfo.keyColumn == null
                || lookupInfo.identifierColumns.isEmpty()) {

            return new ArrayList<>();
        }


        String displayExpression =
                buildTableDirectDisplayExpression(
                        tableName,
                        lookupInfo.identifierColumns
                );


        StringBuilder sql =
                new StringBuilder();


        sql.append(" SELECT ");

        sql.append(tableName);
        sql.append(".");
        sql.append(lookupInfo.keyColumn);
        sql.append(" AS lookup_value, ");

        sql.append(displayExpression);
        sql.append(" AS lookup_name, ");

        sql.append(tableName);
        sql.append(".isactive AS lookup_isactive ");

        sql.append(" FROM ");
        sql.append(tableName);
        sql.append(" ");


        boolean hasSearch =
                search != null
                        && !search.trim().isEmpty();

        boolean hasValue =
                value != null
                        && !value.trim().isEmpty();


        boolean hasWhere = false;


        if (hasValue) {

            sql.append(" WHERE ");

            sql.append(tableName);
            sql.append(".");
            sql.append(lookupInfo.keyColumn);

            sql.append(" = ? ");

            hasWhere = true;
        }


        if (hasSearch) {

            sql.append(
                    hasWhere
                            ? " AND "
                            : " WHERE "
            );

            sql.append(" lower(");
            sql.append(displayExpression);
            sql.append(") LIKE ? ");
        }


        sql.append(
                " ORDER BY lookup_name "
        );

        sql.append(
                " LIMIT ? OFFSET ? "
        );


        return executeLookupQuery(
                sql.toString(),
                limit,
                page,
                search,
                hasSearch,
                value,
                hasValue,
                "Table Direct para columna "
                        + column.columnId
        );
    }


    /**
     * Inferencia Table Direct.
     */
    private String inferTableName(
            String columnName) {

        if (columnName == null) {
            return null;
        }


        /*
         * Excepción histórica de Libertya.
         */
        if ("AD_OrgBP_ID".equalsIgnoreCase(
                columnName)) {

            return "AD_Org";
        }


        if (!columnName
                .toUpperCase()
                .endsWith("_ID")) {

            return null;
        }


        return columnName.substring(
                0,
                columnName.length() - 3
        );
    }


    /**
     * Recupera key e identificadores de la tabla referenciada.
     */
    private TableLookupInfo loadTableLookupInfo(
            String tableName) {

        String sql =
                " SELECT " +
                        "   c.columnname, " +
                        "   c.iskey, " +
                        "   c.isidentifier, " +
                        "   c.seqno " +

                        " FROM ad_table t " +

                        " JOIN ad_column c " +
                        "   ON c.ad_table_id = t.ad_table_id " +

                        " WHERE lower(t.tablename) = lower(?) " +
                        "   AND t.isactive = 'Y' " +
                        "   AND c.isactive = 'Y' " +
                        "   AND (" +
                        "       c.iskey = 'Y' " +
                        "       OR c.isidentifier = 'Y'" +
                        "   ) " +

                        " ORDER BY c.seqno ";


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(
                    sql,
                    null
            );

            ps.setString(
                    1,
                    tableName
            );

            rs = ps.executeQuery();


            TableLookupInfo result =
                    new TableLookupInfo();


            while (rs.next()) {

                String columnName =
                        rs.getString(
                                "columnname"
                        );


                if ("Y".equals(
                        rs.getString(
                                "iskey"
                        ))) {

                    result.keyColumn =
                            columnName;
                }


                if ("Y".equals(
                        rs.getString(
                                "isidentifier"
                        ))) {

                    result.identifierColumns.add(
                            columnName
                    );
                }
            }


            if (result.keyColumn == null
                    && result.identifierColumns.isEmpty()) {

                return null;
            }


            return result;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando metadata "
                            + "de lookup para tabla "
                            + tableName,
                    e
            );

        } finally {

            DB.close(rs, ps);
        }
    }


    /**
     * Construye el texto visible para Table Direct.
     */
    private String buildTableDirectDisplayExpression(
            String tableName,
            List<String> identifierColumns) {

        StringBuilder result =
                new StringBuilder();


        for (int i = 0;
             i < identifierColumns.size();
             i++) {

            if (i > 0) {

                result.append(
                        " || '_' || "
                );
            }


            result.append(
                    "COALESCE(CAST("
            );

            result.append(
                    tableName
            );

            result.append(".");

            result.append(
                    identifierColumns.get(i)
            );

            result.append(
                    " AS VARCHAR), '')"
            );
        }


        return result.toString();
    }


    /**
     * Ejecución común para Table y Table Direct.
     */
    private List<ColumnLookupValue> executeLookupQuery(
            String sql,
            int limit,
            int page,
            String search,
            boolean hasSearch,
            String value,
            boolean hasValue,
            String description) {

        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(
                    sql,
                    null
            );


            int parameterIndex = 1;


            if (hasValue) {

                try {
                    ps.setInt(
                            parameterIndex++,
                            Integer.parseInt(value)
                    );
                } catch (NumberFormatException e) {
                    ps.setString(
                            parameterIndex++,
                            value
                    );
                }
            }


            if (hasSearch) {

                ps.setString(
                        parameterIndex++,
                        "%"
                                + search
                                .trim()
                                .toLowerCase()
                                + "%"
                );
            }


            ps.setInt(
                    parameterIndex++,
                    limit
            );


            int offset =
                    (page - 1) * limit;


            ps.setInt(
                    parameterIndex,
                    offset
            );


            rs = ps.executeQuery();


            List<ColumnLookupValue> result =
                    new ArrayList<>();


            while (rs.next()) {

                Object key =
                        rs.getObject(
                                "lookup_value"
                        );


                ColumnLookupValue valueItem =
                        new ColumnLookupValue()
                                .value(
                                        key != null
                                                ? String.valueOf(key)
                                                : null
                                )
                                .name(
                                        rs.getString(
                                                "lookup_name"
                                        )
                                )
                                .isactive(
                                        "Y".equals(
                                                rs.getString(
                                                        "lookup_isactive"
                                                )
                                        )
                                );


                result.add(
                        valueItem
                );
            }


            return result;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando lookup "
                            + description,
                    e
            );

        } finally {

            DB.close(rs, ps);
        }
    }


    private static class ColumnInfo {

        private Integer columnId;

        private String columnName;

        private Integer referenceId;

        private Integer referenceValueId;
    }


    private static class TableLookupInfo {

        private String keyColumn;

        private final List<String> identifierColumns =
                new ArrayList<>();
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