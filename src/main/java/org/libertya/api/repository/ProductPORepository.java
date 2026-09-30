package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.ProductPO;
import org.libertya.api.stub.model.Propertiesmap;
import org.openXpertya.model.X_M_Product_PO;
import org.springframework.stereotype.Repository;

/** Relacion articulo-proveedor (M_Product_PO). PK compuesta: M_Product_ID + C_BPartner_ID */
@Repository
public class ProductPORepository extends AbstractRepository {

    public ProductPORepository() {
        tableName = X_M_Product_PO.Table_Name;
        iface = ProductPO::new;
        pkColumns = new String[]{"M_Product_ID", "C_BPartner_ID"};
    }

    /**
     * Actualizacion de una relacion identificada por la URL. Si el body trae las columnas clave con otro valor se
     * rechaza: escribirlas cambiaria la PK del registro en lugar de actualizarlo. Con el mismo valor se aceptan,
     * para poder reenviar lo recibido en un GET.
     */
    public void update(UserInfo info, int productID, int bpartnerID, ProductPO payload) throws ModelException, NotFoundException, AuthException {
        checkKeyValue("M_Product_ID", payload.getMProductId(), productID);
        checkKeyValue("C_BPartner_ID", payload.getCBpartnerId(), bpartnerID);
        if (payload.getAdditionalvalues() != null) {
            for (Propertiesmap prop : payload.getAdditionalvalues()) {
                if (prop.getKey() == null)
                    continue;
                String key = schemaUtils.normalize(prop.getKey());
                if (schemaUtils.normalize("M_Product_ID").equals(key))
                    checkKeyValue("M_Product_ID", prop.getValue(), productID);
                if (schemaUtils.normalize("C_BPartner_ID").equals(key))
                    checkKeyValue("C_BPartner_ID", prop.getValue(), bpartnerID);
            }
        }
        update(info, new int[]{productID, bpartnerID}, payload);
    }

    /** Valida que el valor recibido para una columna clave coincida con el de la URL */
    protected void checkKeyValue(String columnName, Object received, int expected) throws ModelException {
        if (received != null && !String.valueOf(expected).equals(String.valueOf(received).trim()))
            throw new ModelException("No se puede modificar " + columnName + " (" + expected + " -> " + received + "): " +
                    "es parte de la clave. Para relacionar el articulo con otro proveedor, crear una relacion nueva");
    }
}
