package org.libertya.api.service;

import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.openXpertya.process.DocAction;
import org.openXpertya.util.Trx;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService {

    @Value("{org.libertya.api.service.doc.complete}")
    private String completeDocument;

    /**
     *  Metodo a implementar por las sublases en donde deben crear cabeceras, lineas, impuestos, etc. en una misma trx.
     *  La implementacion debe crear todos los documentos bajo la trx y retornar el id de la cabecera del documento
     * @param document documento a generar (InvoiceDocument, OrderDocument, etc.)
     * @param docRepository repositorio del documento a procesar (InvoiceRepository, OrderRepository, etc.)
     * @param trxName nombre de la transaccion
     * @return el id de la cabecera del documento generado
     * @throws Exception en caso de error (modelo u otro)
     */
    protected abstract String perform(Object document, AbstractRepository docRepository, String trxName) throws Exception;

    /**
     * Metodo en comun para todos los services para la creación de documentos
     * @param document documento a generar (InvoiceDocument, OrderDocument, etc.)
     * @param docRepository repositorio del documento a procesar (InvoiceRepository, OrderRepository, etc.)
     * @return el id de la cabecera del documento generado
     * @throws ModelException en caso de presentarse inconvenientes al momento de crear el documento
     */
    protected String create(Object document, AbstractRepository docRepository) throws ModelException {
        String trxName = Trx.createTrx(Trx.createTrxName()).getTrxName();
        try {
            // Generacion de documento
            String id = perform(document, docRepository, trxName);

            // Procesado del documento
            if ("Y".equalsIgnoreCase(completeDocument)) {
                docRepository.process(Integer.parseInt(id), DocAction.ACTION_Complete, trxName);
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
}
