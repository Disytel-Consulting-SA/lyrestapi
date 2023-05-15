package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.Invoice;
import org.openXpertya.model.X_C_Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InvoiceRepository extends AbstractRepository {

    protected final String tableName = X_C_Invoice.Table_Name;

    public Optional<Invoice> retrieveInvoice(int id) {
        return loadEntityFromPO(id, tableName, null, Invoice::new);
    }

    public Optional<Invoice> retrieveInvoice(int id, String fields) {
        return loadEntityFromPO(id, tableName, fields, Invoice::new);
    }

    public List<Invoice> retrieveAllInvoices(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllEntities(tableName, id -> retrieveInvoice(id, fields), filter, sort, limit, offset);
    }

    public void deleteInvoice(int id) throws ModelException, NotFoundException {
        deleteEntity(tableName, id);
    }

    public void updateInvoice(int id, Invoice payload, boolean ignoreNulls) throws ModelException, NotFoundException {
        updateEntity(id, tableName, payload, ignoreNulls);
    }

    public String insertInvoice(Invoice payload) throws ModelException {
        return insertEntity(tableName, payload);
    }
}
