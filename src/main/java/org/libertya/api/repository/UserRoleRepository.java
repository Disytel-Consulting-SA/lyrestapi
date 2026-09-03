package org.libertya.api.repository;

import org.libertya.api.stub.model.UserRole;
import org.openXpertya.model.X_AD_User_Roles;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepository extends AbstractRepository {

    public UserRoleRepository() {
        tableName = X_AD_User_Roles.Table_Name;
        iface = UserRole::new;
        pkColumns = new String[]{"AD_User_ID", "AD_Role_ID"};
    }
}
