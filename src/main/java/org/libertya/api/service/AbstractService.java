package org.libertya.api.service;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.openXpertya.process.DocAction;
import org.openXpertya.util.Trx;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class AbstractService {

    @Value("{org.libertya.api.service.doc.complete}")
    private String completeDocument;

    // === Metodos publicos a invocar desde los controllers ===

    public String create(UserInfo info, Object document) throws ModelException {
        return create(info, document, getRepository());
    }

    public <T> Optional<T>  retrieve(UserInfo info, int id) throws ModelException {
        return performRetrieve(info, id);
    }

    // === Metodos a implementar por las subclases ===

    /**
     *  Metodo a implementar por las sublases en donde deben crear cabeceras, lineas, impuestos, etc. en una misma trx.
     *  La implementacion debe crear todos los documentos bajo la trx y retornar el id de la cabecera del documento
     * @param info datos de acceso
     * @param document documento a generar (InvoiceDocument, OrderDocument, etc.)
     * @param docRepository repositorio del documento a procesar (InvoiceRepository, OrderRepository, etc.)
     * @param trxName nombre de la transaccion
     * @return el id de la cabecera del documento generado
     * @throws Exception en caso de error (modelo u otro)
     */
    protected abstract String performCreate(UserInfo info, Object document, AbstractRepository docRepository, String trxName) throws Exception;

    /**
     * Metodo a implementar por las subclases en donde se deben recuperar documentos que involucren cabeceras, lineas, impuestos, etc.
     * @param id  el id de la cabecera del documento
     * @return un opcional conteniendo el documento completo o bien un optional vacio
     * @throws Exception
     */
    protected abstract <T> Optional<T> performRetrieve(UserInfo info, int id) throws ModelException;

    /**
     * @return el repositorio principal (cabecera) correspondiente al documento
     */
    protected abstract AbstractRepository getRepository();

    // === Metodos internos

    /**
     * Metodo en comun para todos los services para la creación de documentos
     * @param document documento a generar (InvoiceDocument, OrderDocument, etc.)
     * @param docRepository repositorio del documento a procesar (InvoiceRepository, OrderRepository, etc.)
     * @return el id de la cabecera del documento generado
     * @throws ModelException en caso de presentarse inconvenientes al momento de crear el documento
     */
    protected String create(UserInfo info, Object document, AbstractRepository docRepository) throws ModelException {
        String trxName = Trx.createTrx(Trx.createTrxName()).getTrxName();
        try {
            // Generacion de documento
            String id = performCreate(info, document, docRepository, trxName);

            // Procesado del documento
            if ("Y".equalsIgnoreCase(completeDocument)) {
                docRepository.process(info, Integer.parseInt(id), DocAction.ACTION_Complete, trxName);
            }

            // Finalizacion de la operacion
            Trx.getTrx(trxName).commit();
            return id;
        } catch (Exception e) {
            Trx.getTrx(trxName).rollback();
            throw new ModelException("Error creando documento: " + e.getMessage());
        } finally {
            Trx.getTrx(trxName).close();
        }
    }

    /** Retorna una lista vacia si es que list es null, o la lista en cuestion
     * @param list la lista con elementos, la cual puede ser nula si no tiene elementos dado que swagger así la gestiona
     */
    protected <T> List<T> getList(List<T> list) {
        return list==null ? new ArrayList<T>() : list;
    }


}
