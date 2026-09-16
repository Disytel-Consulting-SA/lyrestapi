package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.RetencionTypeRepository;
import org.libertya.api.stub.iface.RetenciontypeApi;
import org.libertya.api.stub.model.RetencionType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Maestro de tipos de retencion, de solo lectura.  Los de IIBB son filter=retentiontype='B' (pueden ser varios).  Ver docs/liquidaciones-tarjetas-api.md */
@Controller
@RequiredArgsConstructor
public class RetencionTypeController extends AbstractController implements RetenciontypeApi {

    private final HttpServletRequest request;

    private final RetencionTypeRepository repository;

    @Override
    public ResponseEntity<List<RetencionType>> getAllRetencionTypes(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<RetencionType> retrieveRetencionType(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
