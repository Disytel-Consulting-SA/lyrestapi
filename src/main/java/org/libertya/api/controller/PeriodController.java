package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PeriodRepository;
import org.libertya.api.stub.iface.PeriodApi;
import org.libertya.api.stub.model.Period;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Maestro contable de solo lectura.  Ver docs/asientos-manuales-api.md */
@Controller
@RequiredArgsConstructor
public class PeriodController extends AbstractController implements PeriodApi {

    private final HttpServletRequest request;

    private final PeriodRepository repository;

    @Override
    public ResponseEntity<List<Period>> getAllPeriods(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Period> retrievePeriods(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
