package org.libertya.api.monitor;

import org.openXpertya.util.DB;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id = "dbinfo")
public class DBInfoContributor {

    @ReadOperation
    public String getInfo() {
        return DB.getDatabaseInfo();
    }
}
