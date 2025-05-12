package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.LetraComprobanteRepository;
import org.libertya.api.stub.iface.LetracomprobanteApi;
import org.libertya.api.stub.model.LetraComprobante;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LetraComprobanteController extends AbstractController implements LetracomprobanteApi {

    private final HttpServletRequest request;

    private final LetraComprobanteRepository repository;

    @Override
    public ResponseEntity<String> addLetraComprobante(LetraComprobante body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteLetraComprobante(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<LetraComprobante>> getAllLetrasComprobante(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<LetraComprobante> retrieveLetraComprobante(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateLetraComprobante(Integer id, LetraComprobante body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
