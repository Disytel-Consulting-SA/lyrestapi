package org.libertya.api.repository;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.GenericRecord;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.process.DocAction;
import org.openXpertya.util.DB;
import org.openXpertya.util.DisplayType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    /** Procesado de un documento. Solo para tablas cuya clase de modelo implementa DocAction */
    public String processRecord(UserInfo info, String table, int id, String action) throws ModelException, NotFoundException, AuthException {
        TableSpec spec = resolveTable(info, table);
        checkWritable(spec);
        if (!spec.isDocument())
            throw new ModelException("La tabla " + spec.getTableName() + " no es un documento: no admite process");
        return processEntity(info, spec.getTableName(), new int[]{id}, action, null);
    }
}
