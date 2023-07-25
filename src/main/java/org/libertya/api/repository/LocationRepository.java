package org.libertya.api.repository;

import org.libertya.api.stub.model.Location;
import org.openXpertya.model.X_C_Location;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository extends AbstractRepository {

    public LocationRepository() {
        tableName = X_C_Location.Table_Name;
        iface = Location::new;
    }
}
