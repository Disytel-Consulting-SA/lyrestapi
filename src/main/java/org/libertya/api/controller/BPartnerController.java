package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.BPartnerRepository;
import org.libertya.api.stub.iface.BpartnerApi;
import org.libertya.api.stub.model.BPartner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BPartnerController extends AbstractController implements BpartnerApi {

    private final BPartnerRepository repository;

    @Override
    public ResponseEntity<String> addBPartner(BPartner body) {
        return insertAction(() -> repository.insert(body));
    }

    @Override
    public ResponseEntity<String> deleteBPartner(Integer id) {
        return deleteAction(() -> repository.delete(id));
    }

    @Override
    public ResponseEntity<List<BPartner>> getAllBPartners(String filter, String fields, String sort, Integer limit, Integer offset) {
        return new ResponseEntity<>(repository.retrieveAll(filter, fields, sort, limit, offset), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BPartner> retrieveBPartner(Integer id) {
        return retrieveAction(() -> repository.retrieve(id), BPartner.class);
    }

    @Override
    public ResponseEntity<String> updateBPartner(BPartner body, Integer id) {
        return updateAction(() -> repository.update(id, body, true));
    }

}
