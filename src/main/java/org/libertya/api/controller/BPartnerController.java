package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.BPartnerRepository;
import org.libertya.api.stub.iface.BpartnerApi;
import org.libertya.api.stub.model.BPartner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BPartnerController extends AbstractController implements BpartnerApi {

    private final BPartnerRepository repository;

    @Override
    public ResponseEntity<String> addBPartner(BPartner body) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteBPartner(Integer id) {
        return deleteAction(() -> repository.deleteBPartner(id));
    }

    @Override
    public ResponseEntity<List<BPartner>> getAllBPartners() {
        return new ResponseEntity<>(repository.retrieveAllBPartners(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BPartner> retrieveBPartner(Integer id) {
        return retrieveAction(() -> repository.retrieveBPartner(id), BPartner.class);
    }

    @Override
    public ResponseEntity<String> updateBPartner(BPartner body, Integer id) {
        return null;
    }
}
