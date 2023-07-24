package org.libertya.api.repository;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

import org.libertya.api.security.ClientOrgAuth;
import org.libertya.api.util.SchemaUtils;
import org.openXpertya.model.MOrg;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.PO;
import org.openXpertya.process.DocAction;
import org.openXpertya.process.DocumentEngine;
import org.openXpertya.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public abstract class AbstractRepository {

    @Autowired
    protected SchemaUtils schemaUtils;

    /** Nombre de la tabla asociada a esta entidad  (a definir en el constructor de las subclases) */
    protected String tableName = null;

    /** Instanciacion de entidades (a definir en el constructor de las subclases) */
    protected SpawnModelInstanceInterface iface;

    /** Columnas que conforman la clave principal. (a definir en el constructor de las subclases)
     *  Si no se modifica se supone que la PK esta conformada por una unica columna NOMBRETABLA_ID */
    protected String[] pkColumns = null;

    /** Numero maximo por defecto de entidades a retornar */
    public static final Integer DEFAULT_LIMIT = 100;

    public String getTableName() {
        return tableName;
    }

    public String[] getPkColumns() {
        return pkColumns;
    }

    /**
     * Recupera un objeto persistente a partir de su ID
     * @param tableName nombre de la tabla
     * @param id identificador/es de la entidad
     * @param trxName nombre de la transaccion
     * @return una entidad que extiende de PO
     */
    public PO getPO(UserInfo info, String tableName, int[] id, String trxName) throws AuthException {
        PO aPO;
        M_Table table = M_Table.get(getCtx(info), tableName);
        // Tabla con PK formada por mas de una columna? (y no estamos insertando)
        if (pkColumns!=null && id[0]>0) {
            aPO = table.getPO(getPOWhereClause(id), trxName);
        } else {
            aPO = table.getPO(id[0], trxName);
        }
        return ClientOrgAuth.validate(info, aPO);
    }

    /** Arma el string conteniendo el whereClause para casos de PK con multi-columnas
     * @param id valores de las columnas identificadoras
     */
    protected String getPOWhereClause(int[] id) {
        if (pkColumns==null)
            return ""+id[0];
        StringBuilder retValue = new StringBuilder();
        int i=0;
        for (String column : pkColumns) {
            retValue.append(column)
                    .append("=")
                    .append(id[i++])
                    .append(" AND ");
        }
        retValue.append("1=1");
        return retValue.toString();
    }

    /**
     * Cierra la transaccion actual sin forzar commit de la actividad realizada bajo la Trx.
     * No fuerza el commit dado que podriamos estar llegando a este punto debido a un Error (x ej. LinkageError), los cuales no deben ser catcheados.
     * Al no ser catcheados, la trx no es rollbackeada y por consiguiente podria ocurrir que se realice incorrectamente el commit parcial de una operación.
     * Es por esto que toda operacion en LYWS debe finalizar con el commitTransaction() antes de retornar los datos.
     */
    protected void closeTransaction(String trxName) {
        Trx.getTrx(trxName).close(false);
    }

    /**
     * Commit de la transaccion actual
     */
    protected void commitTransaction(String trxName) {
        Trx.getTrx(trxName).commit();
    }

    /**
     * Rollbck de la transaccion actual
     */
    protected void rollbackTransaction(String trxName) {
        Trx.getTrx(trxName).rollback();
    }

    protected Properties getCtx(UserInfo info)
    {
        // Prioriza el uso del ctx del request por encima del general
        if (info!=null)
            return info.getCtx();
        return Env.getCtx();
    }

    /**
     * Asigna un valor al objeto destino
     * @param target objeto al cual asignarle el valor
     * @param property la propiedad del objeto a setear
     * @param aColumn columna que contiene el valor a asignar
     * @param value valor a asignar
     */
    protected void setValueToObject(Object target, Field property, M_Column aColumn, Object value) throws ModelException {
        try {
            if (value == null)
                property.set(target, null);
            else if (Integer.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false))
                property.set(target, value);
            else if (String.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false)) {
                // Workaround de resolucion de tipos debido al código en DisplayType de CORE
                try {
                    property.set(target, value);
                } catch (Exception e) {
                    property.set(target, String.valueOf(value));
                }
            }
            else if (BigDecimal.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false))
                property.set(target, value);
            else if (Timestamp.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false))
                property.set(target, value.toString());
        } catch (Exception e) {
            throw new ModelException("Error al setear " + value + " a columna " + aColumn.getColumnName() + ". " + e.getMessage());
        }
    }

    /**
     * Recupera todas las entidades en bdd
     * @param tableName nombre de la tabla
     * @param iface que recuperar
     * @param <T> tipo del modelo
     * @return una lista con todas las entidades
     */
    protected <T> List<T> retrieveAllEntities(UserInfo info, String tableName, RetrieveEntityInterface iface, QueryParams params) throws ModelException, AuthException {
        List retVal = new ArrayList();
        // Si params lo recibo como null (sin ningun tipo de query), entonces instanciar uno vacio
        if (params==null) {
            params = new QueryParams();
        }
        if (params.getLimit()!=null && params.getLimit()<=0)
            throw new ModelException("limit debe ser mayor o igual a 1 si se especifica");
        if (params.getPage()!=null && params.getPage()<=0)
            throw new ModelException("page debe ser mayor o igual a 1 si se especifica");
        String theFilter = (params.getFilter() != null && params.getFilter().length() > 0 ? formatClause(params.getFilter()) + " AND " : "") + filterByClient(info);
        String theSort = params.getSort() != null && params.getSort().length() > 0 ? " ORDER BY " + params.getSort() : " ";
        Integer theLimit = (params.getLimit() != null && params.getLimit() > 0 ? params.getLimit() : DEFAULT_LIMIT);
        Integer thePage = params.getPage() != null ? theLimit * (params.getPage() - 1) : 0;
        String[] entitiesIDs = getAllIDs(tableName,
                String.format( " %s %s LIMIT %d OFFSET %d ",
                        theFilter,
                        theSort,
                        theLimit,
                        thePage),
        null);
        if (entitiesIDs == null || entitiesIDs.length==0)
            return retVal;
        for (String entityIDs : entitiesIDs) {
            if (pkColumns==null)
                // Unica columna PK
                retVal.add(iface.perform(new int[]{Integer.parseInt(entityIDs)}));
            else {
                // PK conformada por varias columnas
                String[] keyVals = entityIDs.split(",");
                int[] keys = new int[keyVals.length];
                for (int i=0; i< keys.length; i++)
                    keys[i] = Integer.parseInt(keyVals[i]);
                retVal.add(iface.perform(keys));
            }
        }
        return retVal;
    }

    /** Genera un filtro si es que la busqueda no contiene uno especifico */
    protected String filterByClient(UserInfo info) {
        if (info.getClientID()==0)
            return " 1=1 ";
        return " AD_Client_ID = " + info.getClientID();
    }

    /** Recupera todos los IDs que respetan el criterio especificado */
    public String[] getAllIDs(String tableName, String WhereClause, String trxName) {
        List<String> list = new ArrayList();
        StringBuilder sql = new StringBuilder("SELECT ");
        if (pkColumns==null)
            sql.append(tableName).append("_ID::varchar");
        else
            sql.append(getSelectKeyColumns());
        sql.append(" FROM ").append(tableName);
        if (WhereClause != null && WhereClause.length() > 0) {
            sql.append(" WHERE ").append(WhereClause);
        }
        try {
            PreparedStatement pstmt = DB.prepareStatement(sql.toString(), trxName);
            ResultSet rs = pstmt.executeQuery();
            while(true) {
                if (!rs.next()) {
                    rs.close();
                    pstmt.close();
                    break;
                }
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        String[] retValue = new String[list.size()];
        for(int i = 0; i < retValue.length; ++i) {
            retValue[i] = list.get(i);
        }
        return retValue;
    }

    /** Nombres de las columnas que conforman la PK */
    protected String getSelectKeyColumns() {
        StringBuffer retValue = new StringBuffer();
        for (String column : pkColumns) {
            retValue.append(column).append("||','||");
        }
        return retValue.substring(0,retValue.length()-7);
    }

    /** Retorna el ID de un PO dado.
     *  Si la PK es formada por varios campos, devuelve cada uno de estos separado por un guion,
     *  en el orden definido en las subclases, segun lo especificado en pkColumns */
    public String getID(PO aPO) {
        if (pkColumns==null)
            return ""+aPO.getID();
        StringBuffer retValue = new StringBuffer();
        for (String pkColumn : pkColumns) {
            retValue.append(aPO.get_Value(pkColumn)).append("-");
        }
        return retValue.toString().substring(0, retValue.toString().length()-1);
    }

    protected String formatClause(String str) {
        return str.replace("\"", "").replace("--", "").replace(";", "");
    }

    /**
     * Recupera y retorna un objeto perteneciente al modelo autogenerado a partir de la informacion en bdd
     * @param id identificador/es del PO
     * @param tableName nombre de la tabla
     * @param target objeto destino
     * @param filterFields campos a considerar unicamente
     * @param <T> tipo del modelo
     * @return un optional con el objeto eventualmente cargado
     */
    protected <T> Optional<T> loadEntityFromPO(UserInfo info, int[] id, String tableName, String trxName, String filterFields, SpawnModelInstanceInterface target) throws ModelException, AuthException {
        Set<String> includeFields = getFilterFields(filterFields);
        // Recuperar el PO asociado en BDD
        PO aPO = getPO(info, tableName, id, trxName);
        if (aPO == null || aPO.getID() == 0) {
            return Optional.empty();
        }
        // Instanciar objeto del modelo segun corresponda
        Object object = target.perform();
        Field[] fields = object.getClass().getDeclaredFields();

        Map<String, M_Column> columnNameMap = schemaUtils.getColumnNameMap(aPO.get_TableName(), getCtx(info));
        // Iterar por los campos del objeto, asignando los valores en cada matcheo
        for (Field field : fields) {
            String fieldName = schemaUtils.normalize(field.getName());
            M_Column aColumn = columnNameMap.get(fieldName);
            if (aColumn != null && (includeFields == null || includeFields.contains(fieldName))) {
                field.setAccessible(true);
                setValueToObject(object, field, aColumn, aPO.get_Value(aColumn.getColumnName()));
            }
        }
        return (Optional<T>)Optional.of(object);
    }

    /**
     * Convierte el string separado por comas en un set de strings normalizado
     * @param criteria por ejemplo name,value
     * @return un set por ejemplo [name, value]
     */
    protected Set<String> getFilterFields(String criteria) {
        if (criteria == null)
            return null;
        String[] elements = criteria.replace("\"", "").replace(" ", "").split(",");
        for (int i = 0; i < elements.length; i++) {
            elements[i]=schemaUtils.normalize(elements[i]);
        }
        return new HashSet<>(Arrays.asList(elements));
    }

    /** Carga de valores por defecto */
    protected void loadPOInitialValues(UserInfo info, PO aPO, boolean inserting) {
        int userID = DB.getSQLValue(null, String.format("SELECT ad_user_id FROM ad_user where name = '%s'", info.getUserName()));
        // Inserting?
        if (inserting) {
            aPO.set_ValueNoCheck("AD_Client_ID", info.getClientID());
            aPO.set_ValueNoCheck("AD_Org_ID", info.getOrgID());
            aPO.set_ValueNoCheck("CreatedBy", userID);
        }
        // Updating siempre modifica el dato
        aPO.set_ValueNoCheck("UpdatedBy", userID);
    }

    /**
     * Setea el valor por defecto cargado en metadatos para la columna dada.
     * 		Unicamente para tipos de dato Entero y BigDecimal, si éstos NO contienen valores de tipo @expresion@
     * @param aColumn columna a setear valor
     * @param po objeto a asignar valor para la columna dada
     * @throws ModelException en caso de error
     */
    protected void setDefaultValue(M_Column aColumn, PO po) throws ModelException {
        Class<?> clazz = DisplayType.getClass(aColumn.getAD_Reference_ID(), false);
        String columnName = aColumn.getColumnName();
        try {
            // Solo para tipo Entero
            if (Integer.class == clazz &&
                    (po.get_Value(columnName) == null || "0".equals(po.get_ValueAsString(columnName))) &&
                    (aColumn.getDefaultValue() != null && aColumn.getDefaultValue().length() > 0 && !aColumn.getDefaultValue().trim().startsWith("@")))
                setValue(po, aColumn, aColumn.getDefaultValue());

            // Solo para tipo BigDecimal
            if (BigDecimal.class == clazz &&
                    (po.get_Value(columnName) == null || BigDecimal.ZERO.compareTo(new BigDecimal(po.get_ValueAsString(columnName))) == 0) &&
                    (aColumn.getDefaultValue() != null && aColumn.getDefaultValue().length() > 0 && !aColumn.getDefaultValue().trim().startsWith("@")))
                setValue(po, aColumn, aColumn.getDefaultValue());
        } catch (Exception e) {
            throw new ModelException("No es posible setear valor por defecto" + aColumn.getDefaultValue() + " en columna " + aColumn.getColumnName() + " de entidad " + po.get_TableName() + "(" + e.getMessage() + ")");
        }
    }

    /** Usar valores por defecto? */
    protected boolean useDefaults(UserInfo info) {
        try {
            return "Y".equalsIgnoreCase((String)info.getCtx().get("#USE_DEFAULTS"));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Carga en un PO la informacion del objeto recibida
     * @param aPO el PO a cargar
     * @param source el objeto con las propiedades a volcar
     */
    protected void loadPOFromEntity(UserInfo info, PO aPO, Object source, boolean ignoreNulls, boolean inserting) throws ModelException {
        // Instanciar objeto del modelo segun corresponda
        Field[] fields = source.getClass().getDeclaredFields();

        Map<String, M_Column> columnNameMap = schemaUtils.getColumnNameMap(aPO.get_TableName(), getCtx(info));
        // Iterar por los campos matcheando segun el nombre de la propiedad.
        // NOTA: Swagger openapi respeta camelCase mientras que las columnas en BDD no siempre y ademas utiliza underscores
        for (Field field : fields) {
            Object value = null;
            try {
                field.setAccessible(true);
                value = field.get(source);
                if (value == null && ignoreNulls)
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
            String fieldName = schemaUtils.normalize(field.getName());
            M_Column aColumn = columnNameMap.get(fieldName);
            if (aColumn != null) {
                if (inserting && useDefaults(info)) {
                    setDefaultValue(aColumn, aPO);
                }
                // El valor podría haber sido definido previamente al especificar los defaults
                if (aPO.get_Value(aColumn.getColumnName()) == null || value != null) {
                    setValue(aPO, aColumn, value);
                }
            }
        }
    }

    /**
     * Setea el valor en PO dependiendo su tipo
     * @param po el PO a asignar el valor
     * @param aColumn columna a asignar
     * @param value valor a asignar
     */
    protected void setValue(PO po, M_Column aColumn, Object value) throws ModelException {
        try {
            boolean ok =
                    po.get_ColumnIndex(aColumn.getColumnName()) > 0 &&
                    (
                        (null == value && po.set_ValueNoCheck(aColumn.getColumnName(), null)) ||
                        (String.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), value)) ||
                        (Integer.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), Integer.parseInt(value.toString()))) ||
                        (BigDecimal.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), new BigDecimal(value.toString()))) ||
                        (Timestamp.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), Timestamp.valueOf(value.toString())))
                    );
        } catch (Exception e) {
            throw new ModelException("Error al setear valor " + (value==null?"null":value) + " en columna " + aColumn.getColumnName() + " de entidad " + po.get_TableName() + ". " + e);
        }
    }

    /**
     * Actualiza un PO en BDD
     * @param id id del registro a actualizar
     * @param tableName nombre de la tabla a actualizar
     * @param source objeto con la nueva informacion a actualizar
     * @throws ModelException si no es posible actualizar por logica de negocio
     * @throws NotFoundException si no existe el id especificado
     */
    protected void updateEntity(UserInfo info, int[] id, String tableName, Object source, boolean ignoreNulls) throws ModelException, NotFoundException, AuthException {
        // Recuperar el PO asociado en BDD
        PO aPO = getPO(info, tableName, id, null);
        if (aPO == null || aPO.getID() == 0) {
            throw new NotFoundException();
        }
        loadPOInitialValues(info, aPO, false);
        loadPOFromEntity(info, aPO, source, ignoreNulls, false);
        if (!aPO.save())
            throw new ModelException(CLogger.retrieveErrorAsString());
    }

    /**
     * Inserta un PO pasando por el modelo
     * @param tableName nombre de la tabla
     * @param source fuente de los datos a usar
     * @throws ModelException en caso de presentarse errores de modelo
     * @throws AuthException en caso de problemas de autorizacion
     * @return un String conteniendo el ID del objeto persistido
     */
    protected String insertEntity(UserInfo info, String tableName, Object source, String trxName) throws ModelException, AuthException {
        PO aPO = getPO(info, tableName, new int[]{0}, trxName);
        loadPOInitialValues(info, aPO, true);
        loadPOFromEntity(info, aPO, source, false, true);
        // Se especificó una organizacion adecuada perteneciente a la compañía?
        if (aPO.getAD_Org_ID() > 0 && (MOrg.get(info.getCtx(), aPO.getAD_Org_ID()).getID()==0 || MOrg.get(info.getCtx(), aPO.getAD_Org_ID()).getAD_Client_ID()!= aPO.getAD_Client_ID())) {
            throw new ModelException("Organizacion " + aPO.getAD_Org_ID() + " inexistente para compañía " + info.getClientID());
        }
        if (!aPO.save())
            throw new ModelException(CLogger.retrieveErrorAsString());
        return getID(aPO);
    }

    /**
     * Elimina una entrada
     * @param tableName nombre de la tabla en donde reside la entidad a eliminar
     * @param id de la entidad a eliminar
     * @throws ModelException si no es posible eliminar el registro
     * @throws NotFoundException si el registro no existe
     */
    protected void deleteEntity(UserInfo info, String tableName,  int[] id) throws ModelException, NotFoundException, AuthException {
        PO aPO = getPO(info, tableName, id, null);
        if (aPO.getID()<=0)
            throw new NotFoundException();
        if (!aPO.delete(false))
            throw new ModelException(CLogger.retrieveErrorAsString());
    }

    /**
     * Realiza el procesamiento de un documento
     * @param tableName tabla donde reside el documento (C_Invoice, C_Order, etc.)
     * @param id identificador del documento a procesasr
     * @param action accion a aplicar al documento (CO, CL, VO, etc.)
     * @param trx nombre de la transaccion. Si no se recibe se genera y gestiona la trx internamente
     *                                      Si se recibe un valor la trx no es gestionada internamente
     * @throws ModelException si no es posible eliminar el registro
     * @throws NotFoundException si el registro no existe
     */
    protected String processEntity(UserInfo info, String tableName, int[] id, String action, String trx) throws ModelException, NotFoundException, AuthException {
        String trxName;
        boolean handleTrx;
        if (trx!=null) {
            trxName = trx;
            handleTrx = false;
        } else {
            trxName = Trx.createTrx(Trx.createTrxName()).getTrxName();
            handleTrx = true;
        }
        PO aPO = getPO(info, tableName, id, trxName);
        loadPOInitialValues(info, aPO, false);
        try {
            if (aPO.getID() <= 0)
                throw new NotFoundException();
            if (!DocumentEngine.processAndSave((DocAction) aPO, action.toUpperCase(), false)) {
                throw new ModelException(Msg.parseTranslation(getCtx(info), ((DocAction) aPO).getProcessMsg()));
            }
            // Validar si pudo cambiarse la nuevo estado, dado que DocumentEngine.processIt no realiza dicha actividad
            String currentStatus = ((DocAction) aPO).getDocStatus();
            if (!action.equalsIgnoreCase(currentStatus)) {
                throw new ModelException(String.format("Imposible procesar.  La accion %s no puede aplicarse al estado actual %s", action.toUpperCase(), currentStatus));
            }
            if (handleTrx) {
                commitTransaction(trxName);
            }
            return ((DocAction)aPO).getProcessMsg();
        } catch (Exception e) {
            if (handleTrx) {
                rollbackTransaction(trxName);
            }
            throw e;
        } finally {
            if (handleTrx) {
                closeTransaction(trxName);
            }
        }
    }

    /* =========================== Metodos publicos  =========================== */

    /** Insercion de una entidad */
    public String insert(UserInfo info, Object payload) throws ModelException, AuthException {
        return insertEntity(info, tableName, payload, null);
    }

    /** Insercion de una entidad usando una TRX */
    public String insert(UserInfo info, Object payload, String trxName) throws ModelException, AuthException {
        return insertEntity(info, tableName, payload, trxName);
    }

    /** Eliminacion de una entidad con PK identificada por multiples columnas */
    public void delete(UserInfo info, int[] id) throws ModelException, NotFoundException, AuthException {
        deleteEntity(info, tableName, id);
    }

    /** Eliminacion de una entidad con PK identificada por una unica columna */
    public void delete(UserInfo info, int id) throws ModelException, NotFoundException, AuthException {
        deleteEntity(info, tableName, new int[]{id});
    }

    /** Actualizacion de una entidad con PK identificada por multiples columnas */
    public void update(UserInfo info, int[] id, Object payload) throws ModelException, NotFoundException, AuthException {
        updateEntity(info, id, tableName, payload, true);
    }

    /** Actualizacion de una entidad con PK v por una unica columna */
    public void update(UserInfo info, int id, Object payload) throws ModelException, NotFoundException, AuthException {
        updateEntity(info, new int[]{id}, tableName, payload, true);
    }

    /** Recuperacion de una entidad con PK identificada por multiples columnas, con filtro de campos */
    public <T> Optional<T> retrieve(UserInfo info, int[] id, String trxName, String fields) throws ModelException, AuthException {
        return loadEntityFromPO(info, id, tableName, trxName, fields, iface);
    }

    /** Recuperacion de una entidad con PK identificada por una unica columna, con filtro de campos */
    public <T> Optional<T> retrieve(UserInfo info, int id, String trxName, String fields) throws ModelException, AuthException {
        return loadEntityFromPO(info, new int[]{id}, tableName, trxName, fields, iface);
    }

    /** Recuperacion de una entidad con PK identificada por multiples columnas */
    public <T> Optional<T> retrieve(UserInfo info, int id, String trxName) throws ModelException, AuthException {
        return retrieve(info, id, trxName, null);
    }

    /** Recuperacion de una entidad con PK identificada por una unica columna */
    public <T> Optional<T> retrieve(UserInfo info, int[] id, String trxName) throws ModelException, AuthException {
        return retrieve(info, id, trxName, null);
    }

    /** Recuperacion de una entidad con PK identificada por multiples columnas */
    public <T> Optional<T> retrieve(UserInfo info, int id) throws ModelException, AuthException {
        return retrieve(info, id, null, null);
    }

    /** Recuperacion de una entidad con PK identificada por una unica columna */
    public <T> Optional<T> retrieve(UserInfo info, int[] id) throws ModelException, AuthException {
        return retrieve(info, id, null, null);
    }

    /** Recuperacion de varias entidades */
    public <T> List<T> retrieveAll(UserInfo info, QueryParams params) throws ModelException, AuthException {
        return retrieveAllEntities(info, tableName, id -> retrieve(info, id, null, params.getFields()), params);
    }

    /** Recuperacion de varias entidades bajo una trx */
    public <T> List<T> retrieveAll(UserInfo info, String trxName, QueryParams params) throws ModelException, AuthException {
        return retrieveAllEntities(info, tableName, id -> retrieve(info, id, trxName, params.getFields()), params);
    }

    /** Procesado de una entidad */
    public String process(UserInfo info, int id, String action) throws ModelException, NotFoundException, AuthException {
        return processEntity(info, tableName, new int[]{id}, action, null);
    }

    /** Procesado de una entidad bajo una TRX en particular */
    public String process(UserInfo info, int id, String action, String trxName) throws ModelException, NotFoundException, AuthException {
        return processEntity(info, tableName, new int[]{id}, action, trxName);
    }


}
