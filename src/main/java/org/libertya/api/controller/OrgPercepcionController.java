package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrgPercepcionRepository;
import org.libertya.api.stub.iface.OrgpercepcionApi;
import org.libertya.api.stub.model.OrgPercepcion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrgPercepcionController extends AbstractController implements OrgpercepcionApi {

    private final HttpServletRequest request;

    private final OrgPercepcionRepository repository;

    @Override
    public ResponseEntity<String> addOrgPerception(OrgPercepcion body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteOrgPerception(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<OrgPercepcion>> getAllOrgPerceptions(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<OrgPercepcion> retrieveOrgPerception(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateOrgPerception(Integer id, OrgPercepcion body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
