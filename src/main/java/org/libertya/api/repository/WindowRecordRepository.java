package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.WindowRecordQuery;
import org.libertya.api.security.SafeQueryFilter;
import org.openXpertya.model.MQueryPreparation;
import org.openXpertya.model.MTab;
import org.openXpertya.model.MTabQueryDefinition;
import org.openXpertya.model.MWindow;
import org.openXpertya.model.MWindowVO;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Trx;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
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

    private static final Pattern SORT_PATTERN = Pattern.compile(
            "(?i)^([A-Za-z][A-Za-z0-9_]*)(?:\\s+(ASC|DESC))?$");

    private final GenericRepository genericRepository;

    @FunctionalInterface
    private interface CoreTransactionWork<T> {
        T execute(String trxName) throws ModelException, NotFoundException, AuthException;
    }

    /**
     * La transacción pertenece al repositorio contextual. Ante cualquier
     * fallo no se confirma ninguna escritura realizada con este trxName.
     */
    private <T> T inCoreTransaction(CoreTransactionWork<T> work)
            throws ModelException, NotFoundException, AuthException {
        String trxName = Trx.createTrx(Trx.createTrxName()).getTrxName();
        try {
            T result = work.execute(trxName);
            commitTransaction(trxName);
            return result;
        } catch (Exception ex) {
            rollbackTransaction(trxName);
            if (ex instanceof ModelException) throw (ModelException) ex;
            if (ex instanceof NotFoundException) throw (NotFoundException) ex;
            if (ex instanceof AuthException) throw (AuthException) ex;
            if (ex instanceof RuntimeException) throw (RuntimeException) ex;
            throw new ModelException("Error en operación contextual: " + ex.getMessage());
        } finally {
            closeTransaction(trxName);
        }
    }



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


    /**
     * Verifica autorización contextual para escrituras de una pestaña.
     * No ejecuta la escritura: la invocación posterior debe volver a
     * verificar los permisos de tabla/registro en el repositorio genérico.
     */
    public void validateTabWrite(UserInfo info, int adTabId, boolean inserting)
            throws ModelException, NotFoundException, AuthException {
        withTab(info, adTabId, null, (tab, windowNo) -> {
            String sql = "SELECT IsReadOnly, IsInsertRecord FROM AD_Tab WHERE AD_Tab_ID=? AND IsActive='Y'";
            try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
                ps.setInt(1, adTabId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next())
                        throw new NotFoundException("Pestaña inexistente o inactiva");
                    if ("Y".equalsIgnoreCase(rs.getString("IsReadOnly")))
                        throw new AuthException("La pestaña es de solo lectura");
                    if (inserting && !"Y".equalsIgnoreCase(rs.getString("IsInsertRecord")))
                        throw new AuthException("La pestaña no permite insertar registros");
                }
            } catch (java.sql.SQLException ex) {
                throw new ModelException("No fue posible validar los permisos de la pestaña: " + ex.getMessage());
            }
            return null;
        });
    }

    /**
     * Escrituras contextuales: comprueba el registro contra el mismo universo
     * de consulta de la pestaña, con contexto maestro/detalle.
     */
    /**
     * Creación contextual de pestañas raíz. Las pestañas detalle requieren
     * validación explícita de la relación padre/hijo antes de habilitar POST.
     */
    /**
     * Inserción contextual. En detalles solo se habilita una relación directa
     * inequívoca con el padre, que se valida y se impone desde el servidor.
     */
    public String insertTabRecord(UserInfo info, int tabId,
            Map<String, String> parentValues, Map<String, Object> values)
            throws ModelException, NotFoundException, AuthException {
        if (values == null || values.isEmpty())
            throw new ModelException("Debe indicar los valores del nuevo registro");
        validateWriteParentValues(info, tabId, parentValues);
        return inCoreTransaction(trxName -> withTab(info, tabId, parentQuery(parentValues), (tab, windowNo) -> {
            checkTabWritable(tabId);
            String sql = "SELECT IsInsertRecord FROM AD_Tab WHERE AD_Tab_ID=? AND IsActive='Y'";
            try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
                ps.setInt(1, tabId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next() || !"Y".equalsIgnoreCase(rs.getString(1)))
                        throw new AuthException("La pestaña no permite crear registros");
                }
            } catch (java.sql.SQLException e) {
                throw new ModelException("Error verificando creación en pestaña: " + e.getMessage());
            }
            GenericRepository.TableSpec spec = genericRepository.resolveTable(
                    info, tab.getQueryDefinition().getTableName());
            ParentLink parent = requireParentContext(info, tab, parentValues, trxName);
            Map<String, Object> insertValues = new HashMap<>(values);
            if (parent != null) {
                M_Table childTable = M_Table.get(info.getCtx(), spec.getTableName());
                if (childTable == null || childTable.getColumn(parent.key) == null)
                    throw new AuthException("No se puede resolver una relación directa padre-hijo para crear el detalle");
                for (String field : values.keySet()) {
                    if (parent.key.equalsIgnoreCase(field))
                        throw new AuthException("La referencia al padre debe provenir exclusivamente del contexto validado");
                }
                insertValues.put(parent.key, parent.id);
            }
            String createdId = genericRepository.insertRecord(info, spec.getTableName(), insertValues, trxName);
            // Verificar antes del commit que el registro nuevo resulte
            // efectivamente visible dentro del universo de esta pestaña.
            int numericId;
            try {
                numericId = Integer.parseInt(createdId);
            } catch (NumberFormatException ex) {
                throw new ModelException("La creación contextual requiere una clave primaria numérica simple");
            }
            contextualTable(info, tab, windowNo, numericId, trxName);
            verifyParentLink(info, spec, numericId, parent, trxName);
            return createdId;
        }));
    }

    public void updateTabRecord(UserInfo info, int tabId, int recordId,
            Map<String, String> parentValues, Map<String, Object> values)
            throws ModelException, NotFoundException, AuthException {
        if (values == null || values.isEmpty())
            throw new ModelException("Debe indicar al menos un campo para actualizar");
        validateWriteParentValues(info, tabId, parentValues);
        inCoreTransaction(trxName -> withTab(info, tabId, parentQuery(parentValues), (tab, windowNo) -> {
            ParentLink parent = requireParentContext(info, tab, parentValues, trxName);
            checkTabWritable(tabId);
            GenericRepository.TableSpec spec = genericRepository.resolveTable(
                    info, tab.getQueryDefinition().getTableName());
            lockRecordForWrite(spec, recordId, trxName);
            spec = contextualTable(info, tab, windowNo, recordId, trxName);
            verifyParentLink(info, spec, recordId, parent, trxName);
            if (parent != null) {
                for (String field : values.keySet()) {
                    if (parent.key.equalsIgnoreCase(field))
                        throw new AuthException("No se permite cambiar la referencia al padre desde esta pestaña");
                }
            }
            genericRepository.updateRecord(info, spec.getTableName(), recordId, values, trxName);
            // Un PUT no puede desplazar el registro fuera del universo
            // contextual que autorizó la modificación.
            contextualTable(info, tab, windowNo, recordId, trxName);
            verifyParentLink(info, spec, recordId, parent, trxName);
            return null;
        }));
    }

    public void deleteTabRecord(UserInfo info, int tabId, int recordId,
            Map<String, String> parentValues)
            throws ModelException, NotFoundException, AuthException {
        validateWriteParentValues(info, tabId, parentValues);
        inCoreTransaction(trxName -> withTab(info, tabId, parentQuery(parentValues), (tab, windowNo) -> {
            ParentLink parent = requireParentContext(info, tab, parentValues, trxName);
            checkTabWritable(tabId);
            GenericRepository.TableSpec spec = genericRepository.resolveTable(
                    info, tab.getQueryDefinition().getTableName());
            lockRecordForWrite(spec, recordId, trxName);
            spec = contextualTable(info, tab, windowNo, recordId, trxName);
            verifyParentLink(info, spec, recordId, parent, trxName);
            genericRepository.deleteRecord(info, spec.getTableName(), recordId, trxName);
            return null;
        }));
    }

    /**
     * Un detalle no puede evaluarse con contexto padre ausente: las
     * expresiones de CORE podrían quedar sin resolver o ampliar el filtro.
     */
    /**
     * Las variables de contexto provienen del cliente y se aplican a Env.
     * Las escrituras solo admiten identificadores de registros, nunca
     * variables de seguridad, organización o contexto arbitrario.
     */
    /**
     * Solo admite claves primarias de las pestañas ancestras reales.
     * Se valida antes de poblar Env para impedir inyección de variables
     * arbitrarias con apariencia de identificadores.
     */
    private void validateWriteParentValues(UserInfo info, int tabId,
            Map<String, String> values) throws AuthException, ModelException {
        if (info == null)
            throw new AuthException("Usuario no autenticado");
        String sql = "SELECT p.AD_Table_ID, p.TabLevel FROM AD_Tab c "
                + "JOIN AD_Tab p ON p.AD_Window_ID=c.AD_Window_ID "
                + "AND p.IsActive='Y' AND p.SeqNo<c.SeqNo "
                + "WHERE c.AD_Tab_ID=? AND c.IsActive='Y' ORDER BY p.SeqNo";
        int targetLevel;
        try (PreparedStatement ps = DB.prepareStatement(
                "SELECT TabLevel FROM AD_Tab WHERE AD_Tab_ID=? AND IsActive='Y'", null)) {
            ps.setInt(1, tabId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    throw new AuthException("Pestaña no disponible");
                targetLevel = rs.getInt(1);
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error consultando nivel de pestaña: " + e.getMessage());
        }
        // Reconstruye la rama activa: una pestaña del mismo nivel reemplaza
        // a sus hermanas; una de nivel inferior cierra los descendientes.
        List<Integer> branch = new ArrayList<>();
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, tabId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int level = rs.getInt(2);
                    if (level < 0 || level > branch.size())
                        throw new AuthException("Jerarquía de pestañas inconsistente");
                    while (branch.size() > level)
                        branch.remove(branch.size() - 1);
                    branch.add(rs.getInt(1));
                }
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error resolviendo jerarquía de pestañas: " + e.getMessage());
        }
        if (targetLevel < 0 || targetLevel > branch.size())
            throw new AuthException("Jerarquía de pestañas incompleta");
        while (branch.size() > targetLevel)
            branch.remove(branch.size() - 1);
        Set<String> allowed = new HashSet<>();
        for (Integer tableId : branch) {
            M_Table table = M_Table.get(info.getCtx(), tableId);
            if (table == null)
                throw new AuthException("Metadatos de tabla ancestra no disponibles");
            GenericRepository.TableSpec spec = genericRepository.resolveTable(info, table.getTableName());
            allowed.add(spec.getKeyColumn().toLowerCase(Locale.ROOT));
        }
        if (values == null || values.isEmpty()) {
            if (targetLevel > 0)
                throw new AuthException("Falta el contexto de las pestañas ancestras");
            return;
        }
        Set<String> supplied = new HashSet<>();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null || !supplied.add(key.toLowerCase(Locale.ROOT))
                    || !allowed.contains(key.toLowerCase(Locale.ROOT))
                    || value == null || !value.matches("[0-9]{1,10}"))
                throw new AuthException("El contexto contiene una columna ajena a la jerarquía de pestañas");
            try {
                if (Integer.parseInt(value) <= 0)
                    throw new AuthException("Identificador padre inválido");
            } catch (NumberFormatException e) {
                throw new AuthException("Identificador padre fuera de rango");
            }
        }
        if (supplied.size() != allowed.size())
            throw new AuthException("Faltan identificadores de pestañas ancestras");
    }

    private ParentLink requireParentContext(UserInfo info, MTab tab, Map<String, String> parentValues, String trxName)
            throws AuthException, ModelException, NotFoundException {
        if (tab.getTabLevel() <= 0)
            return null;
        if (parentValues == null || parentValues.isEmpty())
            throw new AuthException("Se requiere contexto del registro padre para operar en una pestaña detalle");

        for (Map.Entry<String, String> entry : parentValues.entrySet()) {
            if (entry.getKey() == null || !entry.getKey().matches("[A-Za-z_][A-Za-z0-9_]*")
                    || entry.getValue() == null || entry.getValue().trim().isEmpty())
                throw new AuthException("Contexto del registro padre inválido o incompleto");
        }

        // El padre inmediato se identifica por la jerarquía de AD_Tab, no por
        // un nombre de columna arbitrario enviado por el cliente.
        String sql = "SELECT p.AD_Table_ID FROM AD_Tab c JOIN AD_Tab p "
                + "ON p.AD_Window_ID=c.AD_Window_ID AND p.IsActive='Y' "
                + "AND p.SeqNo=(SELECT MAX(p2.SeqNo) FROM AD_Tab p2 "
                + "WHERE p2.AD_Window_ID=c.AD_Window_ID AND p2.IsActive='Y' "
                + "AND p2.SeqNo<c.SeqNo AND p2.TabLevel=c.TabLevel-1) "
                + "WHERE c.AD_Tab_ID=? AND c.IsActive='Y'";
        int parentTableId;
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, tab.getAD_Tab_ID());
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    throw new AuthException("No se pudo determinar la pestaña padre");
                parentTableId = rs.getInt(1);
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error resolviendo pestaña padre: " + e.getMessage());
        }
        M_Table parentTable = M_Table.get(info.getCtx(), parentTableId);
        if (parentTable == null)
            throw new AuthException("Metadatos de la tabla padre no disponibles");
        GenericRepository.TableSpec parentSpec = genericRepository.resolveTable(info, parentTable.getTableName());
        String parentKey = parentSpec.getKeyColumn();
        String rawId = null;
        for (Map.Entry<String, String> entry : parentValues.entrySet()) {
            if (parentKey.equalsIgnoreCase(entry.getKey())) {
                rawId = entry.getValue();
                break;
            }
        }
        if (rawId == null || !rawId.matches("[0-9]{1,10}"))
            throw new AuthException("Falta el identificador de la entidad padre: " + parentKey);
        int parentId;
        try {
            parentId = Integer.parseInt(rawId);
        } catch (NumberFormatException e) {
            throw new AuthException("Identificador de entidad padre inválido");
        }
        if (!genericRepository.retrieveRecord(info, parentSpec.getTableName(), parentId, parentKey).isPresent())
            throw new AuthException("El registro padre no existe o no es accesible");
        // El padre queda protegido frente a cambios concurrentes hasta el
        // commit o rollback de la escritura contextual.
        lockRecordForWrite(parentSpec, parentId, trxName);
        String linkColumn = resolveParentLinkColumn(tab.getAD_Tab_ID(), parentTableId, parentKey);
        return new ParentLink(linkColumn, parentId);
    }

    /**
     * Respeta AD_Tab.AD_Column_ID cuando está configurado. En su ausencia
     * acepta únicamente una columna IsParent inequívoca que referencie la
     * tabla padre. Nunca deduce la relación solo por coincidencia de nombres.
     */
    private String resolveParentLinkColumn(int tabId, int parentTableId, String parentKey)
            throws ModelException, AuthException {
        String sql = "SELECT t.AD_Column_ID, c.ColumnName FROM AD_Tab t "
                + "LEFT JOIN AD_Column c ON c.AD_Column_ID=t.AD_Column_ID "
                + "AND c.AD_Table_ID=t.AD_Table_ID AND c.IsActive='Y' "
                + "WHERE t.AD_Tab_ID=?";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, tabId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    throw new AuthException("Pestaña no disponible");
                int explicitId = rs.getInt(1);
                if (explicitId > 0) {
                    String column = rs.getString(2);
                    if (column == null || !column.equalsIgnoreCase(parentKey))
                        throw new AuthException("El vínculo explícito de la pestaña no coincide con la clave del padre");
                    return column;
                }
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error resolviendo vínculo explícito: " + e.getMessage());
        }
        // Sin override explícito, no elegir arbitrariamente entre varias
        // columnas IsParent: la relación debe ser única y coincidir con la PK.
        sql = "SELECT c.ColumnName FROM AD_Tab t "
                + "JOIN AD_Column c ON c.AD_Table_ID=t.AD_Table_ID "
                + "WHERE t.AD_Tab_ID=? AND c.IsActive='Y' AND c.IsParent='Y'";
        String candidate = null;
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, tabId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (candidate != null)
                        throw new AuthException("La pestaña tiene múltiples columnas IsParent sin vínculo explícito");
                    candidate = rs.getString(1);
                }
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error resolviendo vínculo IsParent: " + e.getMessage());
        }
        if (candidate != null && candidate.equalsIgnoreCase(parentKey))
            return candidate;
        throw new AuthException("No hay relación padre-hijo explícita y verificable en los metadatos");
    }

    private static final class ParentLink {
        final String key;
        final int id;
        ParentLink(String key, int id) {
            this.key = key;
            this.id = id;
        }
    }

    /**
     * Verificación explícita de la FK padre-hijo. Solo se admiten tablas
     * con columna directa homónima a la PK del padre; relaciones indirectas
     * requieren resolución específica y se deniegan por defecto.
     */
    private void verifyParentLink(UserInfo info, GenericRepository.TableSpec child,
            int recordId, ParentLink parent, String trxName) throws AuthException, ModelException {
        if (parent == null)
            return;
        M_Table childTable = M_Table.get(info.getCtx(), child.getTableName());
        if (childTable == null || childTable.getColumn(parent.key) == null)
            throw new AuthException("No se puede verificar la relación directa padre-hijo de esta pestaña");
        String sql = "SELECT 1 FROM " + child.getTableName()
                + " WHERE " + child.getKeyColumn() + "=? AND " + parent.key + "=?";
        try (PreparedStatement ps = DB.prepareStatement(sql, trxName)) {
            ps.setInt(1, recordId);
            ps.setInt(2, parent.id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    throw new AuthException("El registro no pertenece al padre indicado");
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error verificando relación padre-hijo: " + e.getMessage());
        }
    }

    private WindowRecordQuery parentQuery(Map<String, String> values) {
        WindowRecordQuery query = new WindowRecordQuery();
        query.setParentValues(values);
        return query;
    }

    private void checkTabWritable(int tabId) throws ModelException, AuthException {
        String sql = "SELECT IsReadOnly FROM AD_Tab WHERE AD_Tab_ID=? AND IsActive='Y'";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, tabId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next() || "Y".equalsIgnoreCase(rs.getString(1)))
                    throw new AuthException("La pestaña no permite modificar registros");
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error verificando la pestaña: " + e.getMessage());
        }
    }

    /**
     * Bloquea la fila antes de comprobar su pertenencia contextual.
     * El bloqueo se conserva hasta el commit/rollback de la misma Trx.
     */
    private void lockRecordForWrite(GenericRepository.TableSpec spec, int recordId,
            String trxName) throws ModelException, AuthException {
        String sql = "SELECT " + spec.getKeyColumn() + " FROM " + spec.getTableName()
                + " WHERE " + spec.getKeyColumn() + "=? FOR UPDATE";
        try (PreparedStatement ps = DB.prepareStatement(sql, trxName)) {
            ps.setInt(1, recordId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    throw new AuthException("El registro no existe o no está disponible para modificar");
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error bloqueando registro para escritura: " + e.getMessage());
        }
    }

    private GenericRepository.TableSpec contextualTable(UserInfo info, MTab tab,
            int windowNo, int recordId, String trxName) throws ModelException, NotFoundException, AuthException {
        GenericRepository.TableSpec spec = genericRepository.resolveTable(
                info, tab.getQueryDefinition().getTableName());
        SafeQueryFilter.Compiled filter = validateFilter(info, spec, null);
        String sql = "SELECT 1 FROM (" + buildBaseSelect(info, tab, windowNo, spec, filter)
                + ") contextual WHERE contextual." + spec.getKeyColumn() + "=?";
        try (PreparedStatement ps = DB.prepareStatement(sql, trxName)) {
            ps.setInt(1, recordId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    throw new AuthException("El registro no pertenece al contexto accesible de la pestaña");
            }
        } catch (java.sql.SQLException e) {
            throw new ModelException("Error verificando pertenencia a la pestaña: " + e.getMessage());
        }
        return spec;
    }

    /* =========================== Recuperación =========================== */

    private List<GenericRecord> retrieveRecords(UserInfo info, MTab tab, int windowNo, WindowRecordQuery query)
            throws ModelException, NotFoundException, AuthException {

        MTabQueryDefinition definition = tab.getQueryDefinition();
        GenericRepository.TableSpec table = genericRepository.resolveTable(info, definition.getTableName());

        SafeQueryFilter.Compiled filter = validateFilter(info, table, query != null ? query.getFilter() : null);
        String sql = buildBaseSelect(info, tab, windowNo, table, filter);

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
            bindFilterValues(statement, filter.values);
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
        SafeQueryFilter.Compiled filter = validateFilter(info, table, query != null ? query.getFilter() : null);
        String innerSql = buildBaseSelect(info, tab, windowNo, table, filter);
        String sql = "SELECT COUNT(*) FROM (" + innerSql + ") tab_records";

        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = DB.prepareStatement(sql, null);
            bindFilterValues(statement, filter.values);
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
                                   GenericRepository.TableSpec table, SafeQueryFilter.Compiled userFilter)
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
        if (!userFilter.values.isEmpty() || !"1=1".equals(userFilter.sql)) {
            sql.append(hasWhere ? " AND (" : " WHERE (").append(userFilter.sql).append(")");
        }

        return MQueryPreparation.applyReadAccess(
                info.getCtx(), sql.toString(), definition.getTableName());
    }


    /* =========================== Filtro HTTP =========================== */

    private SafeQueryFilter.Compiled validateFilter(UserInfo info, GenericRepository.TableSpec tableSpec, String filter)
            throws ModelException {
        Map<String, String> columns = new HashMap<>();
        M_Table table = M_Table.get(info.getCtx(), tableSpec.getTableName());
        for (M_Column column : table.getColumns(false))
            columns.put(column.getColumnName().toLowerCase(Locale.ROOT), column.getColumnName());
        return SafeQueryFilter.compile(filter, columns);
    }

    private void bindFilterValues(PreparedStatement statement, List<Object> values) throws java.sql.SQLException {
        for (int i = 0; i < values.size(); i++)
            statement.setObject(i + 1, values.get(i));
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
            /*
             * MTab.getParentTabNo() resuelve la jerarquía leyendo
             * CTX_TabLevel del contexto por número de pestaña. Los
             * clientes clásicos cargan explícitamente ese contexto al
             * inicializar cada tab; el endpoint REST construía MWindow
             * pero no reproducía ese paso. En tabs de nivel > 1 eso
             * podía dejar getParentTabNo() recorriendo tabNo hacia
             * valores negativos indefinidamente.
             */
            initializeTabLevelContext(info, windowNo, window);

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

    private void initializeTabLevelContext(UserInfo info, int windowNo, MWindow window) {

        for (int tabNo = 0; tabNo < window.getTabCount(); tabNo++) {
            MTab tab = window.getTab(tabNo);

            Env.setContext(
                    info.getCtx(),
                    windowNo,
                    tabNo,
                    MTab.CTX_TabLevel,
                    Integer.toString(tab.getTabLevel())
            );
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