package org.libertya.api.stub.iface;

import org.libertya.api.stub.model.ProcessSchema;
import org.springframework.http.ResponseEntity;

public interface ProcessschemaApi {
    ResponseEntity<ProcessSchema> retrieveProcessSchema(Integer id, String language);
}
