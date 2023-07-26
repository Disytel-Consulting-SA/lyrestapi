package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.LocationRepository;
import org.libertya.api.stub.iface.LocationApi;
import org.libertya.api.stub.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LocationController extends AbstractController implements LocationApi {

    private final HttpServletRequest request;

    private final LocationRepository repository;

    @Override
    public ResponseEntity<String> addLocation(Location body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteLocation(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Location>> getAllLocations(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Location> retrieveLocation(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateLocation(Integer id, Location body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
