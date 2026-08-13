package org.libertya.api.repository;

import org.libertya.api.stub.model.MessageTrl;
import org.openXpertya.model.X_AD_Message_Trl;
import org.springframework.stereotype.Repository;

@Repository
public class MessageTrlRepository extends AbstractRepository {

    public MessageTrlRepository() {
        tableName = X_AD_Message_Trl.Table_Name;
        iface = MessageTrl::new;
        pkColumns = new String[] {"AD_Message_ID", "AD_Language"};
    }
}
