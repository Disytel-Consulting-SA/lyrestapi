package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.EntidadFinancieraRepository;
import org.libertya.api.stub.iface.EntidadfinancieraApi;
import org.libertya.api.stub.model.EntidadFinanciera;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EntidadFinancieraController extends AbstractController implements EntidadfinancieraApi {

    private final HttpServletRequest request;

    private final EntidadFinancieraRepository repository;

    @Override
    public ResponseEntity<String> addEntidadFinanciera(EntidadFinanciera body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteEntidadFinanciera(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<EntidadFinanciera>> getAllEntidadesFinancieras(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<EntidadFinanciera> retrieveEntidadFinanciera(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateEntidadFinanciera(Integer id, EntidadFinanciera body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
