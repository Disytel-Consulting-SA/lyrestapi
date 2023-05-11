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

    public Optional<BPartner> retrieveBPartner(int id) {
        return loadEntityFromPO(id, X_C_BPartner.Table_Name, null, BPartner::new);
    }

    public Optional<BPartner> retrieveBPartner(int id, String fields) {
        return loadEntityFromPO(id, X_C_BPartner.Table_Name, fields, BPartner::new);
    }

    public List<BPartner> retrieveAllBPartners(String filter, String fields, String sort, Integer limit, Integer offset) {
        return retrieveAllEntities(X_C_BPartner.Table_Name, id -> retrieveBPartner(id, fields), filter, sort, limit, offset);
    }

    public void deleteBPartner(int id) throws ModelException, NotFoundException {
        deleteEntity(X_C_BPartner.Table_Name, id);
    }

    public void updateBPartner(int id, BPartner payload, boolean ignoreNulls) throws ModelException, NotFoundException {
        updateEntity(id, X_C_BPartner.Table_Name, payload, ignoreNulls);
    }

    public String insertBPartner(BPartner payload) throws ModelException {
        return insertEntity(X_C_BPartner.Table_Name, payload);
    }

}
