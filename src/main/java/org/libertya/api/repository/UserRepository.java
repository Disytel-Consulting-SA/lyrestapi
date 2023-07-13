package org.libertya.api.repository;

import org.openXpertya.model.PO;
import org.openXpertya.model.X_AD_User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository extends AbstractRepository {

    public Optional<PO> findUser(String username, String password, String clientId, String orgId) {
        int[] ids = PO.getAllIDs(X_AD_User.Table_Name, String.format(" name = '%s' and password = '%s' and ad_client_id = %s and (ad_org_id = 0 or ad_org_id = %s)", username, password, clientId, orgId),  null);
        if (ids == null || ids.length == 0) {
            return Optional.empty();
        }
        try {
            return Optional.of(getPO(null, X_AD_User.Table_Name, new int[]{ids[0]}, null));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
