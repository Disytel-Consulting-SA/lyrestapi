package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ControladorFiscalRepository;
import org.libertya.api.stub.iface.ControladorfiscalApi;
import org.libertya.api.stub.model.ControladorFiscal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ControladorFiscalController extends AbstractController implements ControladorfiscalApi {

    private final HttpServletRequest request;

    private final ControladorFiscalRepository repository;

    @Override
    public ResponseEntity<String> addControladorFiscal(ControladorFiscal body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteControladorFiscal(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<ControladorFiscal>> getAllControladoresFiscales(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ControladorFiscal> retrieveControladorFiscal(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateControladorFiscal(Integer id, ControladorFiscal body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
