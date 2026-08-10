package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ElementValueRepository;
import org.libertya.api.stub.iface.ElementvalueApi;
import org.libertya.api.stub.model.ElementValue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Maestro contable de solo lectura.  Ver docs/asientos-manuales-api.md */
@Controller
@RequiredArgsConstructor
public class ElementValueController extends AbstractController implements ElementvalueApi {

    private final HttpServletRequest request;

    private final ElementValueRepository repository;

    @Override
    public ResponseEntity<List<ElementValue>> getAllElementValues(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ElementValue> retrieveElementValues(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
