package org.libertya.api.repository;

import lombok.RequiredArgsConstructor;
import org.libertya.api.stub.model.BPartner;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.PO;
import org.openXpertya.model.X_C_BPartner;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BPartnerRepository extends AbstractRepository {

    public Optional<BPartner> retrieveBPartner(int id) {
        PO aPO = getPO(X_C_BPartner.Table_Name, id, null);
        if (aPO == null || aPO.getID() == 0) {
            return Optional.empty();
        }
        BPartner BPartner = new BPartner();
        Field[] fields = BPartner.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName().toLowerCase().replace("_", "");

            M_Table aTable = M_Table.get(getCtx(), aPO.get_TableName());
            M_Column[] columns = aTable.getColumns(false);
            for (M_Column aColumn : columns) {
                if (aColumn.getColumnName().toLowerCase().replace("_", "").equals(fieldName)) {
                    field.setAccessible(true);
                    setValueToObject(BPartner, field, aColumn, aPO.get_Value(aColumn.getColumnName()));
                    break;
                }
            }
        }
        return Optional.of(BPartner);
    }

    public List<BPartner> retrieveAllBPartners() {
        List retVal = new ArrayList();
        int[] ids = PO.getAllIDs(X_C_BPartner.Table_Name, null, null);
        if (ids == null || ids.length==0)
            return retVal;
        for (int id : ids) {
            retVal.add(retrieveBPartner(id));
        }
        return retVal;
    }
}
