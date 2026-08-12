package org.libertya.api.repository;

import org.libertya.api.stub.model.Message;
import org.openXpertya.model.X_AD_Message;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository extends AbstractRepository {

    public MessageRepository() {
        tableName = X_AD_Message.Table_Name;
        iface = Message::new;
    }
}
