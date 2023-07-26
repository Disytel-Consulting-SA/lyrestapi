package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.BPartnerRepository;
import org.libertya.api.stub.iface.BpartnerApi;
import org.libertya.api.stub.model.BPartner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BPartnerController extends AbstractController implements BpartnerApi {

    private final HttpServletRequest request;

    private final BPartnerRepository repository;

    @Override
    public ResponseEntity<String> addBPartner(BPartner body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteBPartner(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<BPartner>> getAllBPartners(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<BPartner> retrieveBPartner(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateBPartner(Integer id, BPartner body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
