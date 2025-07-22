package org.libertya.api.repository;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

import org.libertya.api.security.ClientOrgAuth;
import org.libertya.api.stub.model.Propertiesmap;
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

    /** Nombre de la propiedad para valores referenciados */
    public static final String REFERENCED_VALUES_PROPERTY = "referencedvalues";

    /** Nombre de la propiedad para valores adicionales */
    public static final String ADDITIONAL_VALUES_PROPERTY = "additionalvalues";

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
    protected void setValueToObject(UserInfo info, Object target, Field property, M_Column aColumn, Object value) throws ModelException {
        try {
            // Workaround para DisplayType.  Table (18) lo considera de uso con enteros (withoutQuotes = true), pero esto afecta a AD_Language por ejemplo (el cual es un string).
            Class valueClass = (value != null ? value.getClass() : null);
            if (value == null)
                property.set(target, null);
            else if (Integer.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && (String.class != valueClass)) {
                property.set(target, value);
                if (useReferencedValues(info))
                    setReferencedValue(target, value, aColumn);
            }
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

    /** Setea (si corresponde) el valor de las columna referencial aColumn a partir del valor val en la propiedad referencedvalues del objeto target */
    protected void setReferencedValue(Object target, Object val, M_Column aColumn) {
        if (!isTableReference(aColumn) || val==null)
            return;
        try
        {
            // Recuperar nombre de tabla y columna referenciada
            ArrayList<String> reference = getReferencedColumnAndTableName(aColumn);
            String tableName = reference.get(0);
            String columnName = reference.get(1);
            // si se obtuvo una referencia válida, recuperar el dato
            if (columnName!=null && tableName!=null && columnName.length()>0 && tableName.length() > 0)
            {
                // Obtener las columnas identificadoras de la tabla destino
                StringBuffer identifierColumns = new StringBuffer("");
                for (String identifierColumn : M_Table.getIdentifierColumns(null, tableName))
                    identifierColumns.append(" COALESCE(").append(identifierColumn).append("::varchar, '') || '_' || ");
                // Adicionalmente, existe en la tabla referenciada la columna value?
                int valueCol = DB.getSQLValue(null, "SELECT count(1) " +
                        " FROM information_schema.columns " +
                        " WHERE table_name = '"+tableName.toLowerCase()+"'" +
                        " AND column_name = 'value'");
                // Si no hay identificadores, no hay columna Value, y no hay columnas adicionales a recuperar... entonces no hay nada mas que hacer
                if (identifierColumns.length()==0 && valueCol==0)
                    return;
                // Si hay identificadores, borrar ultimo concatenador
                if (identifierColumns.length()>0)
                    identifierColumns.delete(identifierColumns.length()-11, identifierColumns.length()-1);

                // Obtener el dato referenciado y cargar los identificadoes en la map de detalles (y el value también si es que este existe)
                String sql = " SELECT null as dummyColumnForResultSet " +
                        (identifierColumns.length() > 0 ? ", COALESCE(" + identifierColumns.toString() + ") as detail " : "") +
                        (valueCol>0?", value ":"") +
                        " FROM " + tableName +
                        " WHERE " + columnName + " = ? ";
                PreparedStatement ps = DB.prepareStatement(sql, null);
                Object value;
                Integer intValue;
                String strValue = String.valueOf(val.toString());
                try{
                    intValue = Integer.parseInt(strValue);
                    ps.setInt(1, intValue);
                } catch(NumberFormatException cce){
                    value = strValue;
                    ps.setObject(1, value);
                }
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    Field field = target.getClass().getDeclaredField(REFERENCED_VALUES_PROPERTY);
                    field.setAccessible(true);
                    // Cargar la nomina de identificadores del registro referenciado
                    if (identifierColumns.length() > 0 && rs.getString("detail") != null)
                        addPropToProps((ArrayList<Propertiesmap>)field.get(target), field, target, aColumn.getColumnName().toLowerCase() + schemaUtils.getReferencedValuesDetailSuffix(), rs.getString("detail"));
                    // Cargar el value del registro referenciado
                    if (valueCol > 0 && rs.getString("value") != null)
                        addPropToProps((ArrayList<Propertiesmap>)field.get(target), field, target, aColumn.getColumnName().toLowerCase() + schemaUtils.getReferencedValuesValueSuffix(), rs.getString("value"));
                }
            }
        }
        catch (Exception e) {
            // Por el momento ignorar el error
        }
    }

    /** Incorpora una nueva property a la lista de props */
    protected void addPropToProps(ArrayList<Propertiesmap> props, Field field, Object target, String name, String value) throws Exception {
        if (props==null)
            props = new ArrayList<>();
        Propertiesmap prop = new Propertiesmap();
        prop.setKey(name);
        prop.setValue(value);
        props.add(prop);
        field.set(target, props);
    }

    /**
     * Verifica si una columna dada referencia a
     * @param aColumn la columna a evaluar
     * @return verdadero si hay referencia hacia otra tabla o falso en caso contrario
     */
    protected boolean isTableReference(M_Column aColumn)
    {
        boolean isReference = false;
        if(DisplayType.isTableReference(aColumn.getAD_Reference_ID()))
            isReference = true;
        else if(!aColumn.isKey() && aColumn.getColumnName().toUpperCase().endsWith("_ID")){
            String tablename = aColumn.getColumnName().substring(0, aColumn.getColumnName().lastIndexOf("_"));
            String sql = "SELECT count(1) FROM ad_table WHERE upper(tablename) = upper(?)";
            isReference = DB.getSQLValue(null, sql, tablename) > 0;
        }
        return isReference;
    }

    /**
     * Dada una M_Columnm, retorna el nombre de la tabla y columna de tipo ID referenciada en dicha M_Column
     * @param aColumn columna que contiene la referencia
     * @return un ArrayList conteniendo:
     * 		1. Nombre de la tabla referenciada
     * 		2. Nombre de la columna de tipo ID referenciada
     */
    protected ArrayList<String> getReferencedColumnAndTableName(M_Column aColumn) throws Exception {
        String tableName = null;
        String columnName = null;
        // Si la columna termina en _ID la tabla referenciada se determina de manera directa
        if(aColumn.getColumnName().toUpperCase().endsWith("_ID"))
        {
            tableName = aColumn.getColumnName().substring(0, aColumn.getColumnName().lastIndexOf("_"));
            columnName = aColumn.getColumnName();
        }
        // Si la columna tiene tiene una referencia seteada, entonces buscar la definición allí
        if(aColumn.getAD_Reference_Value_ID() != 0)
        {
            // Recuperar nombre de tabla y columna que está referenciando la columna actual
            int tableID = 0, key = 0;
            tableID = schemaUtils.getTableIDFromReferenceID(aColumn.getAD_Reference_Value_ID());
            key = schemaUtils.getKeyFromReferenceID(aColumn.getAD_Reference_Value_ID());
            tableName = schemaUtils.getTableNameFromTableID(tableID);
            columnName = M_Column.getColumnName(Env.getCtx(), key);
        }
        ArrayList<String> retValue = new ArrayList<String>();
        retValue.add(tableName);
        retValue.add(columnName);
        return retValue;
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
        if (aPO==null || (pkColumns==null && aPO.getID()==0)) {
            return Optional.empty();
        }
        // Instanciar objeto del modelo segun corresponda
        Object object = target.perform();
        Field[] fields = object.getClass().getDeclaredFields();

        Map<String, M_Column> columnNameMap = schemaUtils.getColumnNameMap(aPO.get_TableName(), getCtx(info));
        Set<String> assignedFields = new HashSet<>();
        // Iterar por los campos del objeto, asignando los valores en cada matcheo
        for (Field field : fields) {
            String fieldName = schemaUtils.normalize(field.getName());
            loadValueToEntity(info, aPO, columnNameMap, fieldName, field, object, includeFields);
            assignedFields.add(fieldName);
        }
        // Queda informacion por asignar por fuera de la estructura pre-establecida del objeto?
        try {
            if (includeFields==null || includeFields.contains(ADDITIONAL_VALUES_PROPERTY)) {
                Field field = object.getClass().getDeclaredField(ADDITIONAL_VALUES_PROPERTY);
                field.setAccessible(true);
                ArrayList<Propertiesmap> props = new ArrayList<>();
                M_Column[] columns = M_Table.get(getCtx(info), tableName).getColumns(false);
                for (M_Column column : columns) {
                    if (shouldSkipColumn(column))
                        continue;
                    String colName = column.getColumnName();
                    // Ya fue asignado previamente en las propiedades predefinidas? Omitir
                    if (!assignedFields.contains(schemaUtils.normalize(colName)) && aPO.get_Value(colName) != null)
                        addPropToProps(props, field, object, colName.toLowerCase(), aPO.get_Value(colName).toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Optional<T>)Optional.of(object);
    }

    /** Nomina de columnas que no deben incluirse en el entity a ser cargado a partir de un PO */
    protected boolean shouldSkipColumn(M_Column column) {
        return (column.getAD_Reference_ID() == DisplayType.Binary || column.getAD_Reference_ID() == DisplayType.Image);
    }

    /** Realiza el volcado de value para la propiedad fieldName en el PO aPO correspondiente, basandose en la map de columnas columnNameMap */
    protected void loadValueToEntity(UserInfo info, PO aPO, Map<String, M_Column> columnNameMap, String fieldName, Field field, Object object, Set<String> includeFields) throws ModelException {
        M_Column aColumn = columnNameMap.get(fieldName);
        if (aColumn != null && (includeFields == null || includeFields.contains(fieldName))) {
            field.setAccessible(true);
            setValueToObject(info, object, field, aColumn, aPO.get_Value(aColumn.getColumnName()));
        }
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
                setValue(po, aColumn, getDefaultValue(aColumn), true);

            // Solo para tipo BigDecimal
            if (BigDecimal.class == clazz &&
                    (po.get_Value(columnName) == null || BigDecimal.ZERO.compareTo(new BigDecimal(po.get_ValueAsString(columnName))) == 0) &&
                    (aColumn.getDefaultValue() != null && aColumn.getDefaultValue().length() > 0 && !aColumn.getDefaultValue().trim().startsWith("@")))
                setValue(po, aColumn, getDefaultValue(aColumn), true);
        } catch (Exception e) {
            throw new ModelException("No es posible setear valor por defecto" + aColumn.getDefaultValue() + " en columna " + aColumn.getColumnName() + " de entidad " + po.get_TableName() + "(" + e.getMessage() + ")");
        }
    }

    /**  */
    String getDefaultValue(M_Column aColumn) {
        if (aColumn.getDefaultValue()==null || aColumn.getDefaultValue().equalsIgnoreCase("null"))
            return null;
        return aColumn.getDefaultValue();
    }

    /** Usar valores por defecto? */
    protected boolean useDefaults(UserInfo info) {
        try {
            return "Y".equalsIgnoreCase((String)info.getCtx().get("#USE_DEFAULTS"));
        } catch (Exception e) {
            return false;
        }
    }

    /** Usar valores referenciaos? */
    protected boolean useReferencedValues(UserInfo info) {
        try {
            return "Y".equalsIgnoreCase((String)info.getCtx().get("#USE_REFERENCED_VALUES"));
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

            // Informacion adicional contenida en la propiedad additionalvalues (informacion dinamica)
            if (ADDITIONAL_VALUES_PROPERTY.equalsIgnoreCase(field.getName()) && value!=null) {
                for (Propertiesmap map : (List<Propertiesmap>)value) {
                    loadValueToPO(info, aPO, columnNameMap, schemaUtils.normalize(map.getKey()), map.getValue(), inserting);
                }
                continue;
            }

            // Volcar value de la property al PO (informacion pre-establecida)
            loadValueToPO(info, aPO, columnNameMap, fieldName, value, inserting);
        }
    }

    /** Realiza el volcado de value para la propiedad fieldName en el PO aPO correspondiente, basandose en la map de columnas columnNameMap */
    protected void loadValueToPO(UserInfo info, PO aPO, Map<String, M_Column> columnNameMap, String fieldName, Object value, boolean inserting ) throws ModelException {
        M_Column aColumn = columnNameMap.get(fieldName);
        if (aColumn != null) {
            if (inserting && useDefaults(info)) {
                setDefaultValue(aColumn, aPO);
            }
            // El valor podría haber sido definido previamente al especificar los defaults
            if (aPO.get_Value(aColumn.getColumnName()) == null || value != null) {
                setValue(aPO, aColumn, value, inserting);
            }
        }
    }

    /**
     * Setea el valor en PO dependiendo su tipo
     *
     * @param po      el PO a asignar el valor
     * @param aColumn columna a asignar
     * @param value   valor a asignar
     */
    protected boolean setValue(PO po, M_Column aColumn, Object value, boolean inserting) throws ModelException {
        try {
            // Se esta insertando o se solicitó omitir el modelo?
            if (inserting || schemaUtils.shouldForceValues()) {
                return po.get_ColumnIndex(aColumn.getColumnName()) >= 0 &&
                        (
                                ((null == value || schemaUtils.getNullValue().equals(value)) && po.set_ValueNoCheck(aColumn.getColumnName(), null)) ||
                                        (String.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), value)) ||
                                        (Integer.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), Integer.parseInt(value.toString()))) ||
                                        (BigDecimal.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), new BigDecimal(value.toString()))) ||
                                        (Timestamp.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), Timestamp.valueOf(value.toString())))
                        );
            }
            // Validar contra el modelo la actualizacion en cuestion
            checkAlwaysUpdatable(po, aColumn);
            boolean ok = po.get_ColumnIndex(aColumn.getColumnName()) >= 0 &&
                    (
                            ((null == value || schemaUtils.getNullValue().equals(value)) && po.set_Value(aColumn.getColumnName(), null)) ||
                                    (String.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_Value(aColumn.getColumnName(), value)) ||
                                    (Integer.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_Value(aColumn.getColumnName(), Integer.parseInt(value.toString()))) ||
                                    (BigDecimal.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_Value(aColumn.getColumnName(), new BigDecimal(value.toString()))) ||
                                    (Timestamp.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_Value(aColumn.getColumnName(), Timestamp.valueOf(value.toString())))
                    );
            if (!ok) throw new Exception("Imposible actualizar.");
            return true;
        } catch (Exception e) {
            throw new ModelException("Error al setear valor " + (value == null ? "null" : value) + " en columna " + aColumn.getColumnName() + " de entidad " + po.get_TableName() + ". " + e);
        }
    }

    /**
     * Logica de validación por "siempre actualizable" para columnas incluidas en tablas con lógica de documentos
     * @param po el objeto a intentar modificar
     * @param aColumn columna a intentar setear un nuevo valor.
     * @throws ModelException en caso de que el po se encuentra procesado y la columna no tiene setead isAlwaysUpdateable en true
     *
     * La logica NO generará excepciones si el documento puede ser actualizable, debido a alguna de las siguientes razones:
     * 		1) No existe el dato processed de po, con lo cual el valor isAlwaysUpdateable ya no es necesario
     * 		2) El dato processed de po se encuentra en false, con lo cual estamos en un escenario similar a 1
     * 		3) El dato processed de po se encuentra en true, pero la columna está configurada como isAlwaysUpdateable
     *
     */
    protected void checkAlwaysUpdatable(PO po, M_Column aColumn) throws ModelException {
        // Intentar recuperar el campo Processed
        Object oo = po.get_Value("Processed");
        // Si no hay campo processed, entonces solo hay que evaluar la logica de isUpdateable
        if (oo == null)
            return;
        // Determinar si el registro está procesado o no (similar al codigo generado en las clases X_
        boolean isProcessed = (oo instanceof Boolean) ? ((Boolean)oo).booleanValue() : "Y".equals(oo);
        // Si el registro no fue procesado, entonces no hay inconvenientes
        if (!isProcessed)
            return;
        // Si llegamos hasta aqui es debido a que solo se podrá actualizar si el campo isAlwaysUpdateable = Y
        if (!aColumn.isAlwaysUpdateable())
            throw new ModelException(" El documento se encuentra procesado, y la columna a setear no esta configurada como Siempre Actualizable.");
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
            if (aPO.getID() <= 0) {
                throw new NotFoundException();
            }
            // Si el status ya coincide con el action, entonces no hay nada por hacer
            if (action.equalsIgnoreCase(((DocAction)aPO).getDocStatus())) {
                throw new ModelException(String.format("Imposible procesar.  La accion %s a aplicar ya coincide con el estado actual %s", action.toUpperCase(), ((DocAction)aPO).getDocStatus()));
            }
            if (!DocumentEngine.processAndSave((DocAction) aPO, action.toUpperCase(), true)) {
                String err = Msg.parseTranslation(getCtx(info), ((DocAction) aPO).getProcessMsg());
                throw new ModelException(!Util.isEmpty(err) ? err : "Error al procesar la entidad (no hay mas detalles disponibles)");
            }
            // Validar si pudo cambiarse la nuevo estado, dado que DocumentEngine.processIt no realiza dicha actividad
            if (!action.equalsIgnoreCase(((DocAction)aPO).getDocStatus())) {
                throw new ModelException(String.format("Imposible procesar.  La accion %s no puede aplicarse al estado actual %s", action.toUpperCase(), ((DocAction)aPO).getDocStatus()));
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
