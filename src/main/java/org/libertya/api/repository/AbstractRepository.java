package org.libertya.api.repository;

import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.PO;
import org.openXpertya.process.DocAction;
import org.openXpertya.process.DocumentEngine;
import org.openXpertya.util.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

public abstract class AbstractRepository {

    protected String tableName = null;

    protected SpawnModelInstanceInterface iface;

    /** Numero maximo por defecto de entidades a retornar */
    public static final Integer DEFAULT_LIMIT = 100;

    /**
     * Recupera un objeto persistente a partir de su ID
     * @param tableName nombre de la tabla
     * @param id identificador de la entidad
     * @param trxName nombre de la transaccion
     * @return una entidad que extiende de PO
     */
    protected PO getPO(String tableName, int id, String trxName)  {
        PO aPO = null;
        M_Table table = M_Table.get(Env.getCtx(), tableName);
        aPO = table.getPO(id, trxName);
        return aPO;
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

    protected Properties getCtx()
    {
        return Env.getCtx();
    }

    /**
     * Asigna un valor al objeto destino
     * @param id el ID del registro
     * @param target objeto al cual asignarle el valor
     * @param property la propiedad del objeto a setear
     * @param aColumn columna que contiene el valor a asignar
     * @param value valor a asignar
     */
    protected void setValueToObject(int id, Object target, Field property, M_Column aColumn, Object value) throws ModelException {
        try {
            if (value == null)
                property.set(target, null);
            else if (Integer.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false))
                property.set(target, (Integer)value);
            else if (String.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false)) {
                // Workaround de resolucion de tipos debido al código en DisplayType de CORE
                try {
                    property.set(target, (Boolean)value);
                } catch (Exception e) {
                    property.set(target, String.valueOf(value));
                }
            }
            else if (BigDecimal.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false))
                property.set(target, (BigDecimal)value);
            else if (Timestamp.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false))
                property.set(target, (value).toString());
        } catch (Exception e) {
            throw new ModelException("Error al setear " + value + " a columna " + aColumn.getColumnName() + " en ID " + id + ". " + e.getMessage());
        }
    }

    /**
     * Recupera todas las entidades en bdd
     * @param tableName nombre de la tabla
     * @param iface que recuperar
     * @param <T> tipo del modelo
     * @return una lista con todas las entidades
     */
    protected <T> List<T> retrieveAllEntities(String tableName, RetrieveEntityInterface iface, String filter, String sort, Integer limit, Integer offset) throws ModelException {
        List retVal = new ArrayList();
        int[] ids = PO.getAllIDs(tableName,
                String.format( " %s %s LIMIT %d OFFSET %d ",
                        filter != null && filter.length() > 0 ? formatClause(filter) : " 1=1 ",
                        sort != null && sort.length() > 0 ? " ORDER BY " + sort : " ",
                        limit != null && limit > 0 ? limit : DEFAULT_LIMIT,
                        offset != null ? offset : 0 ),
                null);
        if (ids == null || ids.length==0)
            return retVal;
        for (int id : ids) {
            retVal.add(iface.perform(id));
        }
        return retVal;
    }

    protected String formatClause(String str) {
        return str.replace("\"", "").replace("--", "").replace(";", "");
    }

    /**
     * Recupera y retorna un objeto perteneciente al modelo autogenerado a partir de la informacion en bdd
     * @param id el ID del PO
     * @param tableName nombre de la tabla
     * @param target objeto destino
     * @param filterFields campos a considerar unicamente
     * @param <T> tipo del modelo
     * @return un optional con el objeto eventualmente cargado
     */
    protected <T> Optional<T> loadEntityFromPO(int id, String tableName, String filterFields, SpawnModelInstanceInterface target) throws ModelException {
        Set<String> includeFields = getFilterFields(filterFields);
        // Recuperar el PO asociado en BDD
        PO aPO = getPO(tableName, id, null);
        if (aPO == null || aPO.getID() == 0) {
            return Optional.empty();
        }
        // Instanciar objeto del modelo segun corresponda
        Object object = target.perform();
        Field[] fields = object.getClass().getDeclaredFields();
        // Iterar por los campos matcheando segun el nombre de la propiedad.
        // NOTA: Swagger openapi respeta camelCase mientras que las columnas en BDD no siempre y ademas utiliza underscores
        for (Field field : fields) {
            String fieldName = field.getName().toLowerCase().replace("_", "");
            M_Table aTable = M_Table.get(getCtx(), aPO.get_TableName());
            M_Column[] columns = aTable.getColumns(false);
            for (M_Column aColumn : columns) {
                if (aColumn.getColumnName().toLowerCase().replace("_", "").equals(fieldName)) {
                    if (includeFields==null || includeFields.contains(fieldName)) {
                        field.setAccessible(true);
                        setValueToObject(id, object, field, aColumn, aPO.get_Value(aColumn.getColumnName()));
                        break;
                    }
                }
            }
        }
        return (Optional<T>)Optional.of(object);
    }

    /**
     * Convieret el string separado por comas en un set de strings
     * @param criteria por ejemplo name,value
     * @return un set por ejemplo [name, value]
     */
    protected Set<String> getFilterFields(String criteria) {
        if (criteria == null)
            return null;
        return new HashSet<>(Arrays.asList(criteria.replace("\"", "").replace(" ", "").split(",")));
    }


    /**
     * Carga en un PO la informacion del objeto recibida
     * @param aPO el PO a cargar
     * @param source el objeto con las propiedades a volcar
     * @return el objeto actualizado
     */
    protected PO loadPOFromEntity(PO aPO, Object source, boolean ignoreNulls) throws ModelException {
        // Instanciar objeto del modelo segun corresponda
        Field[] fields = source.getClass().getDeclaredFields();
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
            String fieldName = field.getName().toLowerCase().replace("_", "");
            M_Table aTable = M_Table.get(getCtx(), aPO.get_TableName());
            M_Column[] columns = aTable.getColumns(false);
            for (M_Column aColumn : columns) {
                if (aColumn.getColumnName().toLowerCase().replace("_", "").equals(fieldName)) {
                    setValue(aPO, aColumn, value);
                    break;
                }
            }
        }
        return aPO;
    }

    /**
     * Setea el valor en PO dependiendo su tipo
     * @param po el PO a asignar el valor
     * @param aColumn columna a asignar
     * @param value valor a asignar
     */
    protected boolean setValue(PO po, M_Column aColumn, Object value) throws ModelException {
        boolean ok;
        try {
            ok =
                    po.get_ColumnIndex(aColumn.getColumnName()) > 0 &&
                    (
                        (null == value && po.set_ValueNoCheck(aColumn.getColumnName(), null)) ||
                        (String.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), value)) ||
                        (Integer.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), Integer.parseInt(value.toString()))) ||
                        (BigDecimal.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), new BigDecimal(value.toString()))) ||
                        (Timestamp.class == DisplayType.getClass(aColumn.getAD_Reference_ID(), false) && po.set_ValueNoCheck(aColumn.getColumnName(), Timestamp.valueOf(value.toString())))
                    );
            return ok;
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
    protected void updateEntity(int id, String tableName, Object source, boolean ignoreNulls) throws ModelException, NotFoundException {
        // Recuperar el PO asociado en BDD
        PO aPO = getPO(tableName, id, null);
        if (aPO == null || aPO.getID() == 0) {
            throw new NotFoundException();
        }
        loadPOFromEntity(aPO, source, ignoreNulls);
        if (!aPO.save())
            throw new ModelException(CLogger.retrieveErrorAsString());
    }

    /**
     * Inserta un PO pasando por el modelo
     * @param tableName nombre de la tabla
     * @param source fuente de los datos a usar
     * @throws ModelException
     * @return un String conteniendo el ID del objeto persistido
     */
    protected String insertEntity(String tableName, Object source, String trxName) throws ModelException {
        PO aPO = getPO(tableName, 0, trxName);
        loadPOFromEntity(aPO, source, false);
        if (!aPO.save())
            throw new ModelException(CLogger.retrieveErrorAsString());
        return ""+aPO.getID();
    }

    /**
     * Elimina una entrada
     * @param tableName nombre de la tabla en donde reside la entidad a eliminar
     * @param id de la entidad a eliminar
     * @throws ModelException si no es posible eliminar el registro
     * @throws NotFoundException si el registro no existe
     */
    protected void deleteEntity(String tableName,  int id) throws ModelException, NotFoundException {
        PO aPO = getPO(tableName, id, null);
        if (aPO.getID()<=0)
            throw new NotFoundException();
        if (!aPO.delete(false))
            throw new ModelException(CLogger.retrieveErrorAsString());
    }

    /**
     * Realiza el procesamiento de un documento
     * @param tableName tabla donde reside el documento (C_Invoice, C_Order, etc.)
     * @param id identificado del documento a procesasr
     * @param action accion a aplicar al documento (CO, CL, VO, etc.)
     * @param trx nombre de la transaccion. Si no se recibe se genera y gestiona la trx internamente
     *                                      Si se recibe un valor la trx no es gestionada internamente
     * @throws ModelException si no es posible eliminar el registro
     * @throws NotFoundException si el registro no existe
     */
    protected String processEntity(String tableName, int id, String action, String trx) throws ModelException, NotFoundException {
        String trxName;
        boolean handleTrx;
        if (trx!=null) {
            trxName = trx;
            handleTrx = false;
        } else {
            trxName = Trx.createTrx(Trx.createTrxName()).getTrxName();
            handleTrx = true;
        }
        PO aPO = getPO(tableName, id, trxName);
        try {
            if (aPO.getID() <= 0)
                throw new NotFoundException();
            if (!DocumentEngine.processAndSave((DocAction) aPO, action.toUpperCase(), false)) {
                throw new ModelException(Msg.parseTranslation(getCtx(), ((DocAction) aPO).getProcessMsg()));
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

    public String insert(Object payload) throws ModelException {
        return insertEntity(tableName, payload, null);
    }

    public String insert(Object payload, String trxName) throws ModelException {
        return insertEntity(tableName, payload, trxName);
    }

    public void delete(int id) throws ModelException, NotFoundException {
        deleteEntity(tableName, id);
    }

    public void update(int id, Object payload, boolean ignoreNulls) throws ModelException, NotFoundException {
        updateEntity(id, tableName, payload, ignoreNulls);
    }

    public <T> Optional<T> retrieve(int id, String fields) throws ModelException {
        return loadEntityFromPO(id, tableName, fields, iface);
    }

    public <T> Optional<T> retrieve(int id) throws ModelException {
        return retrieve(id, null);
    }

    public <T> List<T> retrieveAll(String filter, String fields, String sort, Integer limit, Integer offset) throws ModelException {
        return retrieveAllEntities(tableName, id -> retrieve(id, fields), filter, sort, limit, offset);
    }

    public String process(int id, String action) throws ModelException, NotFoundException {
        return processEntity(tableName, id, action, null);
    }

    public String process(int id, String action, String trxName) throws ModelException, NotFoundException {
        return processEntity(tableName, id, action, trxName);
    }


}
