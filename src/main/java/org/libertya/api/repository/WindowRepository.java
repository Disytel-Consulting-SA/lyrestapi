package org.libertya.api.repository;

import org.libertya.api.stub.model.Window;
import org.openXpertya.model.X_AD_Window;
import org.springframework.stereotype.Repository;

@Repository
public class WindowRepository extends AbstractRepository {

    public WindowRepository() {
        tableName = X_AD_Window.Table_Name;
        iface = Window::new;
    }
}
