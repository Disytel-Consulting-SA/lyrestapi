package org.libertya.api.repository;

import org.libertya.api.stub.model.Element;
import org.openXpertya.model.X_AD_Element;
import org.springframework.stereotype.Repository;

@Repository
public class ElementRepository extends AbstractRepository {

    public ElementRepository() {
        tableName = X_AD_Element.Table_Name;
        iface = Element::new;
    }
}
