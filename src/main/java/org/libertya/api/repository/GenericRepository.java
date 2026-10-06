package org.libertya.api.repository;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.DocumentAction;
import org.libertya.api.stub.model.DocumentActions;
import org.libertya.api.stub.model.GenericRecord;
import org.openXpertya.model.MAllocationHdr;
import org.openXpertya.model.MRole;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.PO;
import org.openXpertya.plugin.MPluginPO;
import org.openXpertya.plugin.common.PluginPOUtils;
import org.openXpertya.process.DocAction;
import org.openXpertya.process.DocOptions;
import org.openXpertya.process.DocumentEngine;
import org.openXpertya.util.DB;
import org.openXpertya.util.DisplayType;
import org.openXpertya.util.Env;
import org.openXpertya.wf.MWFActivity;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;

/**
 * Operaciones sobre cualquier tabla de AD_Table indicada por nombre (endpoint generico /v1.0/generic/{table}).
 * Toda la logica de negocio la aporta la clase de modelo que el core resuelva para la tabla, incluidas las de
 * customizaciones que lleguen por el OXP.jar de la instancia. Ver docs/planes/plan-endpoint-generico.md.
 *
 * Como todo repository es un singleton de Spring: NO asigna tableName, iface ni pkColumns, porque la tabla
 * cambia en cada request. La tabla viaja por parametro, resuelta en un TableSpec.
 */
@Repository
public class GenericRepository extends AbstractRepository {

    /**
     * Acciones de documento actualmente soportadas por la capa REST.
     *
     * DocumentEngine y las implementaciones de DocOptions pueden exponer otras acciones validas
     * (Prepare, ReActivate, Reverse_Correct, Reverse_Accrual, etc.). Esas acciones se excluyen
     * intencionalmente de /process/actions.
     *
     * AbstractRepository.processEntity() actualmente valida luego del procesamiento que el DocStatus
     * resultante coincida con el DocAction solicitado. Esa suposicion es valida para Complete (CO),
     * Void (VO) y Close (CL), pero no es valida en general para todas las acciones soportadas por Libertya.
     *
     * Por este motivo /process/actions expone unicamente la interseccion entre las acciones que CORE
     * considera validas para el documento y las acciones que la capa REST puede procesar correctamente.
     *
     * IMPORTANTE: antes de incorporar nuevas acciones a este conjunto debe revisarse processEntity(),
     * eliminando la suposicion general DocAction == DocStatus resultante.
     */
    private static final Set<String> SUPPORTED_PROCESS_ACTIONS =
            new HashSet<>(Arrays.asList(DocAction.ACTION_Complete, DocAction.ACTION_Void, DocAction.ACTION_Close));

    /** Descriptor inmutable de la tabla sobre la que opera un request */
    public static final class TableSpec {

        /** Nombre canonico, tal como figura en AD_Table (nunca el recibido en la URL) */
        private final String tableName;
        /** Columna clave simple */
        private final String keyColumn;
        private final boolean view;
        /** La clase de modelo implementa DocAction */
        private final boolean document;

        TableSpec(String tableName, String keyColumn, boolean view, boolean document) {
            this.tableName = tableName;
            this.keyColumn = keyColumn;
            this.view = view;
            this.document = document;
        }

        public String getTableName() {
            return tableName;
        }

        public String getKeyColumn() {
            return keyColumn;
        }

        public boolean isView() {
            return view;
        }

        /** La clave sigue la convencion NOMBRETABLA_ID, que es la que asume PO.load(int) al actualizar o eliminar */
        public boolean hasStandardKey() {
            return keyColumn.equalsIgnoreCase(tableName + "_ID");
        }

        public boolean isDocument() {
            return document;
        }
    }

    /**
     * Resuelve la tabla indicada en la URL. Debe invocarse antes que cualquier otra cosa: el resto de los metodos
     * usan el nombre canonico, que termina concatenado en SQL y es la clave de la cache de ColumnResolver.
     * @param rawTableName nombre recibido, sin distinguir mayusculas
     * @throws NotFoundException si la tabla no existe en AD_Table
     * @throws ModelException si no hay clase de modelo para la tabla, o su clave no es simple y numerica
     */
    public TableSpec resolveTable(UserInfo info, String rawTableName) throws NotFoundException, ModelException {
        M_Table table = M_Table.get(getCtx(info), rawTableName);
        if (table == null || table.getAD_Table_ID() == 0)
            throw new NotFoundException("No existe la tabla " + rawTableName);
        String tableName = table.getTableName();

        // Sin clase de modelo el core no puede instanciar el PO (Libertya no tiene un PO generico)
        Class<?> modelClass = M_Table.getClass(tableName);
        if (modelClass == null)
            throw new ModelException(noModelClassMessage(table));

        // Solo PK simple numerica. getKeyColumnsAsArray devuelve la columna IsKey o, si no hay, las IsParent
        String[] keyColumns = table.getKeyColumnsAsArray();
        M_Column keyColumn = keyColumns.length == 1 ? table.getColumn(keyColumns[0]) : null;
        if (keyColumn == null || !keyColumn.isKey() || Integer.class != DisplayType.getClass(keyColumn.getAD_Reference_ID(), false))
            throw new ModelException("La tabla " + tableName + " no tiene una clave simple numerica (" + String.join(", ", keyColumns) +
                    "). El endpoint generico todavia no soporta claves compuestas ni alfanumericas");

        return new TableSpec(tableName, keyColumn.getColumnName(), table.isView(), DocAction.class.isAssignableFrom(modelClass));
    }

    /** Mensaje para una tabla sin clase de modelo en el classpath, con el componente duenio si lo tiene */
    protected String noModelClassMessage(M_Table table) {
        // Misma consulta que M_Table.getTableOwnerPackage (privado en el core)
        String packageName = DB.getSQLValueString(null,
                " SELECT c.packagename FROM AD_Table t " +
                        " INNER JOIN AD_ComponentVersion cv ON cv.AD_ComponentVersion_ID = t.AD_ComponentVersion_ID " +
                        " INNER JOIN AD_Component c ON c.AD_Component_ID = cv.AD_Component_ID " +
                        " WHERE t.AD_Table_ID = ?", table.getAD_Table_ID());
        return "No se encontro la clase de modelo para la tabla " + table.getTableName() +
                (packageName != null ? " (componente " + packageName + ")" : "") +
                ". Verificar que el OXP.jar de la instancia este en loader.path";
    }

    /** Las vistas son de solo lectura, y tambien las tablas cuya clave no es NOMBRETABLA_ID */
    protected void checkWritable(TableSpec spec) throws ModelException {
        if (spec.isView())
            throw new ModelException("La tabla " + spec.getTableName() + " es una vista: solo admite lectura");
        if (!spec.hasStandardKey())
            throw new ModelException("La clave de la tabla " + spec.getTableName() + " es " + spec.getKeyColumn() +
                    " y no " + spec.getTableName() + "_ID: el endpoint generico solo puede leerla");
    }

    /** Un registro recuperado del core, como objeto de la API */
    protected static GenericRecord toRecord(Map<String, Object> values) {
        GenericRecord record = new GenericRecord();
        record.putAll(values);
        return record;
    }

    /**
     * Resuelve las acciones actualmente validas para un documento reproduciendo
     * el mismo circuito utilizado por VDocAction/WDocActionPanel:
     *
     * DocumentEngine -> DocOptions del PO -> DocOptions de plugins -> permisos del rol.
     *
     * Finalmente se filtran las acciones que la capa REST todavia no puede procesar.
     */
    private DocumentActions resolveDocumentActions(UserInfo info, PO po) throws ModelException {
        if (!(po instanceof DocAction))
            throw new ModelException("La entidad no implementa DocAction");

        final int tableId = po.get_Table_ID();
        final int recordId = po.getID();
        final String docStatus = getStringValue(po, "DocStatus");
        final String currentDocAction = getStringValue(po, "DocAction");
        final Object processing = getValue(po, "Processing");
        final String orderType = getStringValue(po, "OrderType");
        final String isSOTrx = getStringValue(po, "IsSOTrx");

        if (docStatus == null)
            throw new ModelException("El documento no posee DocStatus");

        String wfStatus = MWFActivity.getActiveInfo(info.getCtx(), tableId, recordId);
        if (wfStatus != null)
            throw new ModelException("Existe un workflow activo para el documento: " + wfStatus);

        /*
         * VDocAction y WDocActionPanel cargan tanto la referencia general de DocAction
         * como la referencia especial de Allocation. Ademas de proveer nombre y descripcion,
         * el total de valores determina el tamanio del array utilizado por DocumentEngine
         * y las implementaciones de DocOptions.
         */
        ArrayList<String> refValues = new ArrayList<>();
        ArrayList<String> refNames = new ArrayList<>();
        ArrayList<String> refDescriptions = new ArrayList<>();

        readReferenceList(info, DocAction.AD_REFERENCE_ID, refValues, refNames, refDescriptions);
        readReferenceList(info, MAllocationHdr.ALLOCATIONACTION_AD_Reference_ID, refValues, refNames, refDescriptions);

        String[] options = new String[refValues.size()];
        String[] docActionHolder = new String[]{currentDocAction};

        // 1. Acciones estandar determinadas por CORE
        int index = DocumentEngine.getValidActions(docStatus, processing, orderType, isSOTrx, tableId, docActionHolder, options, recordId);

        // 2. Customizacion de la clase concreta del documento
        if (po instanceof DocOptions)
            index = ((DocOptions) po).customizeValidActions(docStatus, processing, orderType, isSOTrx, tableId, docActionHolder, options, index);

        // 3. Customizaciones aportadas por plugins
        Vector<MPluginPO> plugins = PluginPOUtils.getPluginList(po);
        for (MPluginPO plugin : plugins) {
            if (plugin instanceof DocOptions)
                index = ((DocOptions) plugin).customizeValidActions(docStatus, processing, orderType, isSOTrx, tableId, docActionHolder, options, index);
        }

        /*
         * 4. Restricciones configuradas por rol/tipo de documento.
         *
         * Los tokens REST historicos pueden no contener roleID. Cuando existe contexto
         * de rol reproducimos la validacion realizada por VDocAction/WDocActionPanel.
         * No se inventa un rol implicito cuando el token no lo posee.
         */
        Integer docTypeId = getIntegerValue(po, "C_DocType_ID");
        if (docTypeId == null || docTypeId == 0)
            docTypeId = getIntegerValue(po, "C_DocTypeTarget_ID");

        if (docTypeId != null && docTypeId != 0 && info.hasRole()) {
            MRole role = MRole.get(info.getCtx(), info.getRoleID(), info.getUserID(), false);
            index = role.checkActionAccess(info.getClientID(), docTypeId, options, index);
        }

        /*
         * 5. Publicar solamente las acciones que REST puede ejecutar correctamente.
         * Los nombres y descripciones provienen de las referencias de CORE.
         */
        List<DocumentAction> actions = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            String value = options[i];

            if (value == null || !SUPPORTED_PROCESS_ACTIONS.contains(value))
                continue;

            int refIndex = refValues.indexOf(value);
            String name = refIndex >= 0 ? refNames.get(refIndex) : value;
            String description = refIndex >= 0 ? refDescriptions.get(refIndex) : "";

            actions.add(new DocumentAction().value(value).name(name).description(description));
        }

        /*
         * getValidActions()/DocOptions pueden modificar la accion sugerida mediante
         * docActionHolder[0]. Solo la exponemos como default si sobrevivio a todas
         * las validaciones y esta soportada por REST.
         */
        String defaultAction = docActionHolder[0];
        boolean validDefault = defaultAction != null && containsAction(actions, defaultAction);

        if (!validDefault)
            defaultAction = actions.isEmpty() ? null : actions.get(0).getValue();

        return new DocumentActions().docStatus(docStatus).defaultAction(defaultAction).actions(actions);
    }

    /** Valor de una columna del PO, o null si el modelo no posee dicha columna */
    private Object getValue(PO po, String columnName) {
        if (po.get_ColumnIndex(columnName) < 0)
            return null;
        return po.get_Value(columnName);
    }

    /** Valor String de una columna del PO, o null si no existe/no tiene valor */
    private String getStringValue(PO po, String columnName) {
        Object value = getValue(po, columnName);
        return value != null ? value.toString() : null;
    }

    /** Valor Integer de una columna del PO, o null si no existe/no es numerica */
    private Integer getIntegerValue(PO po, String columnName) {
        Object value = getValue(po, columnName);
        return value instanceof Number ? ((Number) value).intValue() : null;
    }

    /** Indica si la accion se encuentra en el resultado final */
    private boolean containsAction(List<DocumentAction> actions, String action) {
        if (action == null)
            return false;

        for (DocumentAction option : actions) {
            if (action.equals(option.getValue()))
                return true;
        }

        return false;
    }

    /* =========================== Metodos publicos  =========================== */

    /** Recuperacion de un registro, con filtro de campos */
    public Optional<GenericRecord> retrieveRecord(UserInfo info, String table, int id, String fields) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        return loadRecordFromPO(info, spec.getTableName(), spec.getKeyColumn(), id, null, fields).map(GenericRepository::toRecord);
    }

    /** Recuperacion de varios registros */
    public List<GenericRecord> retrieveAllRecords(UserInfo info, String table, QueryParams params) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        String fields = params != null ? params.getFields() : null;
        return retrieveAllEntities(info, spec.getTableName(), new String[]{spec.getKeyColumn()},
                id -> loadRecordFromPO(info, spec.getTableName(), spec.getKeyColumn(), ((Number) id[0]).intValue(), null, fields)
                        .map(GenericRepository::toRecord)
                        .orElse(null),
                params);
    }

    /** Cantidad de registros que respetan el filtro */
    public int countAllRecords(UserInfo info, String table, QueryParams params) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        return countAll(info, spec.getTableName(), params);
    }

    /** Insercion de un registro. No completa documentos: completar es siempre un process explicito */
    public String insertRecord(UserInfo info, String table, Map<String, Object> values) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        checkWritable(spec);
        return insertEntity(info, spec.getTableName(), values, null);
    }

    /** Actualizacion parcial de un registro: solo las columnas recibidas */
    public void updateRecord(UserInfo info, String table, int id, Map<String, Object> values) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        checkWritable(spec);
        updateEntity(info, new int[]{id}, spec.getTableName(), values, true);
    }

    /** Eliminacion de un registro */
    public void deleteRecord(UserInfo info, String table, int id) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        checkWritable(spec);
        deleteEntity(info, spec.getTableName(), new int[]{id});
    }

    /**
     * Recupera las acciones de procesamiento actualmente disponibles para un documento.
     *
     * La disponibilidad se determina utilizando el estado persistido actual del PO,
     * las customizaciones DocOptions, los plugins y, cuando corresponde, los permisos
     * del rol autenticado.
     */
    public DocumentActions getDocumentActions(UserInfo info, String table, int id) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);

        if (!spec.isDocument())
            throw new ModelException("La tabla " + spec.getTableName() + " no es un documento: no admite process");

        PO po = getPO(info, spec.getTableName(), new int[]{id}, null);
        if (po == null || po.getID() <= 0)
            throw new NotFoundException();

        return resolveDocumentActions(info, po);
    }

    /**
     * Procesado de un documento. Solo para tablas cuya clase de modelo implementa DocAction.
     *
     * Este endpoint conserva el comportamiento historico de integracion: la accion recibida
     * se delega a CORE sin limitarla a las acciones publicadas por /process/actions.
     *
     * /process/actions expone solamente las acciones actualmente soportadas para el frontend
     * (CO, VO y CL), pero no restringe las acciones que otros consumidores pueden intentar
     * ejecutar mediante este endpoint.
     */
    public String processRecord(UserInfo info, String table, int id, String action) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        checkWritable(spec);

        if (!spec.isDocument())
            throw new ModelException("La tabla " + spec.getTableName() + " no es un documento: no admite process");

        return processEntity(info, spec.getTableName(), new int[]{id}, action, null);
    }


    private void readReferenceList(UserInfo info, int referenceId, List<String> values, List<String> names, List<String> descriptions) throws ModelException {
        String language = Env.getAD_Language(info.getCtx());
        boolean translated = language != null && !language.trim().isEmpty() && !Env.isBaseLanguage(info.getCtx(), "AD_Ref_List");

        String name = translated ? "COALESCE(t.Name, l.Name)" : "l.Name";
        String description = translated ? "COALESCE(t.Description, l.Description)" : "l.Description";

        String sql = "SELECT l.Value, " + name + ", " + description + " FROM AD_Ref_List l ";
        if (translated)
            sql += "LEFT JOIN AD_Ref_List_Trl t ON t.AD_Ref_List_ID=l.AD_Ref_List_ID AND t.AD_Language=? ";
        sql += "WHERE l.AD_Reference_ID=? ORDER BY " + name;

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = DB.prepareStatement(sql, null);
            int parameterIndex = 1;

            if (translated)
                pstmt.setString(parameterIndex++, language);

            pstmt.setInt(parameterIndex, referenceId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                values.add(rs.getString(1));
                names.add(rs.getString(2));
                String descriptionValue = rs.getString(3);
                descriptions.add(descriptionValue != null ? descriptionValue : "");
            }
        } catch (Exception e) {
            throw new ModelException("Error recuperando acciones de documento para el idioma " + language);
        } finally {
            DB.close(rs, pstmt);
        }
    }
}