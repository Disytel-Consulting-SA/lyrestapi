package org.libertya.api.repository;

import org.libertya.api.stub.model.Entity;
import org.openXpertya.model.PO;
import org.openXpertya.model.X_M_Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository extends AbstractRepository {

    public Optional<Entity> retrieveProduct(int id) {
        PO aPO = getPO(X_M_Product.Table_Name, id, null);
        if (aPO == null || aPO.getID() == 0) {
            return Optional.empty();
        }
        return Optional.of(poToEntity(aPO));
    }

    public List<Entity> retrieveAllProducts() {
        List retVal = new ArrayList<Entity>();
        int[] ids = PO.getAllIDs(X_M_Product.Table_Name, null, null);
        if (ids == null || ids.length==0)
            return retVal;
        for (int id : ids) {
            retVal.add(poToEntity(getPO(X_M_Product.Table_Name, id, null)));
        }
        return retVal;
    }

}
