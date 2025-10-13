package org.libertya.api.repository;

import org.libertya.api.stub.model.Preference;
import org.openXpertya.model.X_AD_Preference;
import org.springframework.stereotype.Repository;

@Repository
public class PreferenceRepository extends AbstractRepository {

    public PreferenceRepository() {
        tableName = X_AD_Preference.Table_Name;
        iface = Preference::new;
    }
}
