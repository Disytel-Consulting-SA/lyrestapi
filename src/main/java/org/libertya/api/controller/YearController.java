package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.YearRepository;
import org.libertya.api.stub.iface.YearApi;
import org.libertya.api.stub.model.Year;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class YearController extends AbstractController implements YearApi {

    private final HttpServletRequest request;

    private final YearRepository repository;

    @Override
    public ResponseEntity<String> addYear(Year body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteYear(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Year>> getAllYears(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Year> retrieveYear(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateYear(Integer id, Year body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
