package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ValidCombinationRepository;
import org.libertya.api.stub.iface.ValidcombinationApi;
import org.libertya.api.stub.model.ValidCombination;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Maestro contable de solo lectura.  Ver docs/asientos-manuales-api.md */
@Controller
@RequiredArgsConstructor
public class ValidCombinationController extends AbstractController implements ValidcombinationApi {

    private final HttpServletRequest request;

    private final ValidCombinationRepository repository;

    @Override
    public ResponseEntity<List<ValidCombination>> getAllValidCombinations(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ValidCombination> retrieveValidCombinations(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
