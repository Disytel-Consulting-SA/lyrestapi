package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.BPartnerLocationRepository;
import org.libertya.api.stub.iface.BpartnerlocationApi;
import org.libertya.api.stub.model.BPartnerLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BPartnerLocationController extends AbstractController implements BpartnerlocationApi {

    private final HttpServletRequest request;

    private final BPartnerLocationRepository repository;

    @Override
    public ResponseEntity<String> addBPartnerLocation(BPartnerLocation body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteBPartnerLocation(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<BPartnerLocation>> getAllBPartnerLocations(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<BPartnerLocation> retrieveBPartnerLocation(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateBPartnerLocation(BPartnerLocation body, Integer id) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
