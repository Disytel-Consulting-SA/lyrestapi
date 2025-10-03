package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.EntidadFinancieraPlanRepository;
import org.libertya.api.stub.iface.EntidadfinancieraplanApi;
import org.libertya.api.stub.model.EntidadFinancieraPlan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EntidadFinancieraPlanController extends AbstractController implements EntidadfinancieraplanApi {

    private final HttpServletRequest request;

    private final EntidadFinancieraPlanRepository repository;

    @Override
    public ResponseEntity<String> addEntidadFinancieraPlan(EntidadFinancieraPlan body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteEntidadFinancieraPlan(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<EntidadFinancieraPlan>> getAllEntidadFinancieraPlanes(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<EntidadFinancieraPlan> retrieveEntidadFinancieraPlan(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateEntidadFinancieraPlan(Integer id, EntidadFinancieraPlan body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
