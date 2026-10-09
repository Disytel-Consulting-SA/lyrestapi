package org.libertya.api.stub.iface;
import org.libertya.api.stub.model.ColumnLookupValue;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ProcessparameterlookupApi {
    ResponseEntity<List<ColumnLookupValue>> retrieveProcessParameterLookup(Integer id, Integer parameterId, Integer limit, Integer page, String search, String value, String context);
}
