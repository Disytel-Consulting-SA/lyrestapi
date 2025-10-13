package org.libertya.api.repository;

import org.libertya.api.stub.model.Role;
import org.openXpertya.model.X_AD_Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository extends AbstractRepository {

    public RoleRepository() {
        tableName = X_AD_Role.Table_Name;
        iface = Role::new;
    }
}
