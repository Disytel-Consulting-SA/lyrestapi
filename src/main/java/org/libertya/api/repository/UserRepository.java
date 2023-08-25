package org.libertya.api.repository;

import org.libertya.api.stub.model.User;
import org.openXpertya.model.PO;
import org.openXpertya.model.X_AD_User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository extends AbstractRepository {

    public UserRepository() {
        tableName = X_AD_User.Table_Name;
        iface = User::new;
    }

    public Optional<PO> findActiveUser(String username, String clientId, String orgId) {
        return find(username, null, clientId, orgId, true);
    }

    public Optional<PO> findUser(String username, String password, String clientId, String orgId) {
        return find(username, password, clientId, orgId, false);
    }

    public Optional<PO> find(String username, String password, String clientId, String orgId, boolean active) {
        int[] ids = PO.getAllIDs(
                X_AD_User.Table_Name,
                String.format(
                        " name = '%s' " +
                            (active ? " and isactive = 'Y' " : "") +
                            (password!=null ? " and password = '%s' " : " and %s is null") +
                            " and ad_client_id = %s " +
                            " and (ad_org_id = %s or (ad_org_id = 0 and %s in (select ad_org_id from ad_org where ad_client_id = %s)))", username, password, clientId, orgId, orgId, clientId),
                null);
        if (ids == null || ids.length == 0) {
            return Optional.empty();
        }
        try {
            return Optional.of(getPO(null, X_AD_User.Table_Name, new int[]{ids[0]}, null));
        } catch (Exception e) {
            return Optional.empty();
        }
    }



}
