package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.stub.model.Product;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.PO;
import org.openXpertya.model.X_M_Product;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository @RequiredArgsConstructor
public class ProductRepository extends AbstractRepository {

    public Optional<Product> retrieveProduct(int id) {
        PO aPO = getPO(X_M_Product.Table_Name, id, null);
        if (aPO == null || aPO.getID() == 0) {
            return Optional.empty();
        }
        Product product = new Product();
        Field[] fields = product.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName().toLowerCase().replace("_", "");

            M_Table aTable = M_Table.get(getCtx(), aPO.get_TableName());
            M_Column[] columns = aTable.getColumns(false);
            for (M_Column aColumn : columns) {
                if (aColumn.getColumnName().toLowerCase().replace("_", "").equals(fieldName)) {
                    field.setAccessible(true);
                    setValueToObject(product, field, aColumn, aPO.get_Value(aColumn.getColumnName()));
                    break;
                }
            }
        }
        return Optional.of(product);
    }

    public List<Product> retrieveAllProducts() {
        List retVal = new ArrayList();
        int[] ids = PO.getAllIDs(X_M_Product.Table_Name, null, null);
        if (ids == null || ids.length==0)
            return retVal;
        for (int id : ids) {
            retVal.add(retrieveProduct(id));
        }
        return retVal;
    }

}
