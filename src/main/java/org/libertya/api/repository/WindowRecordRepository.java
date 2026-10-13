package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.WindowRecordQuery;
import org.openXpertya.model.MQueryPreparation;
import org.openXpertya.model.MTab;
import org.openXpertya.model.MTabQueryDefinition;
import org.openXpertya.model.MWindow;
import org.openXpertya.model.MWindowVO;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
@RequiredArgsConstructor
public class WindowRecordRepository extends AbstractRepository {

    private static final AtomicInteger NEXT_WINDOW_NO = new AtomicInteger(2000);

    /*
     * Los filtros HTTP admiten solamente la sintaxis que actualmente
     * genera el frontend. Las cláusulas de metadata no pasan por aquí.
     */
    private static final Pattern FILTER_COLUMN_PATTERN = Pattern.compile(
            "(?i)([A-Za-z][A-Za-z0-9_]*)\\s*(?:=|<>|!=|ILIKE|LIKE|IS\\s+NULL|IS\\s+NOT\\s+NULL)");

    private static final Pattern SAFE_FILTER_PATTERN = Pattern.compile(
            "(?is)^[A-Za-z0-9_\\s().'%,=<>!+-]+$");

    private static final Pattern SORT_PATTERN = Pattern.compile(
            "(?i)^([A-Za-z][A-Za-z0-9_]*)(?:\\s+(ASC|DESC))?$");

    private final GenericRepository genericRepository;


    /* =========================== API pública =========================== */

    public List<GenericRecord> retrieveTabRecords(UserInfo info, int adTabId, WindowRecordQuery query)
            throws ModelException, NotFoundException, AuthException {

        return withTab(info, adTabId, query,
                (tab, windowNo) -> retrieveRecords(info, tab, windowNo, query));
    }

    public int countTabRecords(UserInfo info, int adTabId, WindowRecordQuery query)
            throws ModelException, NotFoundException, AuthException {

        return withTab(info, adTabId, query,
                (tab, windowNo) -> countRecords(info, tab, windowNo, query));
    }


    /* =========================== Recuperación =========================== */

    private List<GenericRecord> retrieveRecords(UserInfo info, MTab tab, int windowNo, WindowRecordQuery query)
            throws ModelException, NotFoundException, AuthException {

        MTabQueryDefinition definition = tab.getQueryDefinition();
        GenericRepository.TableSpec table = genericRepository.resolveTable(info, definition.getTableName());

        String sql = buildBaseSelect(info, tab, windowNo, table, query);

        /*
         * El sort explícito tiene prioridad. Si no viene, usamos
         * el OrderByClause efectivo de la pestaña.
         */
        String orderBy = validateSort(info, table, query != null ? query.getSort() : null);

        if (orderBy == null) {
            orderBy = MQueryPreparation.resolveContext(
                    info.getCtx(), windowNo, definition.getOrderByClause());
        }

        if (orderBy != null && !orderBy.trim().isEmpty()) {
            sql += " ORDER BY " + orderBy;
        }

        int limit = query != null && query.getLimit() != null ? query.getLimit() : DEFAULT_LIMIT;
        int page = query != null && query.getPage() != null ? query.getPage() : 1;

        if (limit <= 0) {
            limit = DEFAULT_LIMIT;
        }
        if (page <= 0) {
            page = 1;
        }

        int offset = (page - 1) * limit;
        sql += " LIMIT " + limit + " OFFSET " + offset;

        List<Integer> ids = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = DB.prepareStatement(sql, null);
            result = statement.executeQuery();

            while (result.next()) {
                ids.add(result.getInt(1));
            }
        } catch (Exception e) {
            throw new ModelException(
                    "Error consultando registros de AD_Tab_ID=" + tab.getAD_Tab_ID() + ": " + e.getMessage());
        } finally {
            DB.close(result, statement);
        }

        List<GenericRecord> records = new ArrayList<>();
        String fields = query != null ? query.getFields() : null;

        for (Integer id : ids) {
            loadRecordFromPO(info, table.getTableName(), table.getKeyColumn(), id, null, fields)
                    .ifPresent(values -> records.add(toGenericRecord(values)));
        }

        return records;
    }


    /* =========================== Count =========================== */

    private int countRecords(UserInfo info, MTab tab, int windowNo, WindowRecordQuery query)
            throws ModelException, NotFoundException {

        MTabQueryDefinition definition = tab.getQueryDefinition();
        GenericRepository.TableSpec table = genericRepository.resolveTable(info, definition.getTableName());

        /*
         * Mismo universo que retrieveRecords(), pero sin ORDER BY
         * ni paginación.
         */
        String innerSql = buildBaseSelect(info, tab, windowNo, table, query);
        String sql = "SELECT COUNT(*) FROM (" + innerSql + ") tab_records";

        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = DB.prepareStatement(sql, null);
            result = statement.executeQuery();
            return result.next() ? result.getInt(1) : 0;
        } catch (Exception e) {
            throw new ModelException(
                    "Error contando registros de AD_Tab_ID=" + tab.getAD_Tab_ID() + ": " + e.getMessage());
        } finally {
            DB.close(result, statement);
        }
    }


    /* =========================== SELECT base =========================== */

    private String buildBaseSelect(UserInfo info, MTab tab, int windowNo,
                                   GenericRepository.TableSpec table, WindowRecordQuery query)
            throws ModelException {

        MTabQueryDefinition definition = tab.getQueryDefinition();

        /*
         * El WhereClause viene de CORE y, en pestañas detail,
         * incluye además la relación con el registro padre.
         */
        String whereClause = tab.getContextualWhereClause();
        whereClause = MQueryPreparation.resolveContext(info.getCtx(), windowNo, whereClause);

        /*
         * El filtro HTTP es input externo y por eso sí se valida.
         */
        String userFilter = query != null
                ? validateFilter(info, table, query.getFilter())
                : null;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(table.getTableName()).append(".").append(table.getKeyColumn())
                .append(" FROM ").append(table.getTableName());

        boolean hasWhere = false;

        if (whereClause != null && !whereClause.trim().isEmpty()) {
            sql.append(" WHERE (").append(whereClause).append(")");
            hasWhere = true;
        }

        /*
         * El filtro del usuario siempre se agrega con AND:
         * puede reducir el universo de CORE, nunca ampliarlo.
         */
        if (userFilter != null && !userFilter.isEmpty()) {
            sql.append(hasWhere ? " AND (" : " WHERE (").append(userFilter).append(")");
        }

        return MQueryPreparation.applyReadAccess(
                info.getCtx(), sql.toString(), definition.getTableName());
    }


    /* =========================== Filtro HTTP =========================== */

    private String validateFilter(UserInfo info, GenericRepository.TableSpec tableSpec, String filter)
            throws ModelException {

        if (filter == null || filter.trim().isEmpty()) {
            return null;
        }

        String value = filter.trim();

        if (value.contains(";") || value.contains("--") || value.contains("/*") || value.contains("*/")
                || !SAFE_FILTER_PATTERN.matcher(value).matches()) {
            throw new ModelException("Filtro no permitido");
        }

        Set<String> columns = getTableColumns(info, tableSpec.getTableName());
        Matcher matcher = FILTER_COLUMN_PATTERN.matcher(value);
        boolean foundCondition = false;

        while (matcher.find()) {
            foundCondition = true;
            String column = matcher.group(1).toLowerCase();

            if (!columns.contains(column)) {
                throw new ModelException("Columna no valida en filtro: " + matcher.group(1));
            }
        }

        if (!foundCondition) {
            throw new ModelException("Filtro no valido");
        }

        String padded = " " + value.toUpperCase() + " ";
        String[] forbidden = {
                " SELECT ", " INSERT ", " UPDATE ", " DELETE ", " DROP ",
                " ALTER ", " CREATE ", " UNION ", " JOIN ", " FROM ", " EXISTS "
        };

        for (String keyword : forbidden) {
            if (padded.contains(keyword)) {
                throw new ModelException("Filtro no permitido");
            }
        }

        return value;
    }


    /* =========================== Sort HTTP =========================== */

    private String validateSort(UserInfo info, GenericRepository.TableSpec tableSpec, String sort)
            throws ModelException {

        if (sort == null || sort.trim().isEmpty()) {
            return null;
        }

        Matcher matcher = SORT_PATTERN.matcher(sort.trim());

        if (!matcher.matches()) {
            throw new ModelException("Orden no valido: " + sort);
        }

        Set<String> columns = getTableColumns(info, tableSpec.getTableName());
        String column = matcher.group(1);

        if (!columns.contains(column.toLowerCase())) {
            throw new ModelException("Columna no valida para ordenar: " + column);
        }

        String direction = matcher.group(2);
        return column + (direction != null ? " " + direction.toUpperCase() : "");
    }


    /* =========================== Metadata =========================== */

    private Set<String> getTableColumns(UserInfo info, String tableName) {

        M_Table table = M_Table.get(info.getCtx(), tableName);
        Set<String> columns = new HashSet<>();

        for (M_Column column : table.getColumns(false)) {
            columns.add(column.getColumnName().toLowerCase());
        }

        return columns;
    }


    /* =========================== GenericRecord =========================== */

    private GenericRecord toGenericRecord(Map<String, Object> values) {
        GenericRecord record = new GenericRecord();
        record.putAll(values);
        return record;
    }


    /* =========================== MWindow / MTab =========================== */

    private <T> T withTab(UserInfo info, int adTabId, WindowRecordQuery query, TabOperation<T> operation)
            throws ModelException, NotFoundException, AuthException {

        if (info == null) {
            throw new AuthException("Usuario no autenticado");
        }

        if (!info.hasRole()) {
            throw new AuthException("El token no contiene AD_Role_ID");
        }

        int adWindowId = findWindowId(adTabId);
        int windowNo = NEXT_WINDOW_NO.incrementAndGet();

        MWindowVO vo = MWindowVO.create(info.getCtx(), windowNo, adWindowId);

        if (vo == null) {
            throw new SecurityException("El rol no tiene acceso a AD_Window_ID=" + adWindowId);
        }

        MWindow window = new MWindow(vo);

        try {
            MTab tab = findTab(window, adTabId);

            applyParentContext(
                    info,
                    windowNo,
                    query != null ? query.getParentValues() : null);

            return operation.perform(tab, windowNo);
        } finally {
            window.dispose();
            Env.clearWinContext(info.getCtx(), windowNo);
        }
    }

    private void applyParentContext(UserInfo info, int windowNo, Map<String, String> parentValues) {

        if (parentValues == null) {
            return;
        }

        for (Map.Entry<String, String> entry : parentValues.entrySet()) {
            if (entry.getKey() == null || entry.getKey().trim().isEmpty()) {
                continue;
            }

            Env.setContext(info.getCtx(), windowNo, entry.getKey(), entry.getValue());
        }
    }


    /* =========================== AD_Tab / AD_Window =========================== */

    private int findWindowId(int adTabId) throws NotFoundException, ModelException {

        String sql = "SELECT AD_Window_ID FROM AD_Tab WHERE AD_Tab_ID=? AND IsActive='Y'";

        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = DB.prepareStatement(sql, null);
            statement.setInt(1, adTabId);
            result = statement.executeQuery();

            if (!result.next()) {
                throw new NotFoundException("No existe AD_Tab_ID=" + adTabId);
            }

            return result.getInt(1);
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelException("Error recuperando AD_Tab_ID=" + adTabId + ": " + e.getMessage());
        } finally {
            DB.close(result, statement);
        }
    }

    private MTab findTab(MWindow window, int adTabId) {

        for (int i = 0; i < window.getTabCount(); i++) {
            MTab tab = window.getTab(i);

            if (tab.getAD_Tab_ID() == adTabId) {
                return tab;
            }
        }

        throw new SecurityException("El rol no tiene acceso a AD_Tab_ID=" + adTabId);
    }


    /* =========================== Callback interno =========================== */

    @FunctionalInterface
    private interface TabOperation<T> {
        T perform(MTab tab, int windowNo)
                throws ModelException, NotFoundException, AuthException;
    }
}