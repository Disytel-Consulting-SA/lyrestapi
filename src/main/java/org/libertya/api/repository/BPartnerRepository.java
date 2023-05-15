package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.BPartner;
import org.openXpertya.model.X_C_BPartner;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BPartnerRepository extends AbstractRepository {

    protected final String tableName = X_C_BPartner.Table_Name;

    public Optional<BPartner> retrieveBPartner(int id) {
        return loadEntityFromPO(id, tableName, null, BPartner::new);
    }

    public Optional<BPartner> retrieveBPartner(int id, String fields) {
        return loadEntityFromPO(id, tableName, fields, BPartner::new);
    }

    public List<BPartner> retrieveAllBPartners(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllEntities(tableName, id -> retrieveBPartner(id, fields), filter, sort, limit, offset);
    }

    public void deleteBPartner(int id) throws ModelException, NotFoundException {
        deleteEntity(tableName, id);
    }

    public void updateBPartner(int id, BPartner payload, boolean ignoreNulls) throws ModelException, NotFoundException {
        updateEntity(id, tableName, payload, ignoreNulls);
    }

    public String insertBPartner(BPartner payload) throws ModelException {
        return insertEntity(tableName, payload);
    }

}
