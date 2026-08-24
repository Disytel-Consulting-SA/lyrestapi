package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.RetencionSchemaRepository;
import org.libertya.api.stub.iface.RetencionschemaApi;
import org.libertya.api.stub.model.RetencionSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Maestro de esquemas de retencion, de solo lectura.  Las de liquidaciones de tarjetas son las sufridas: filter=retencionapplication='S'.  Ver docs/liquidaciones-tarjetas-api.md */
@Controller
@RequiredArgsConstructor
public class RetencionSchemaController extends AbstractController implements RetencionschemaApi {

    private final HttpServletRequest request;

    private final RetencionSchemaRepository repository;

    @Override
    public ResponseEntity<List<RetencionSchema>> getAllRetencionSchemas(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<RetencionSchema> retrieveRetencionSchema(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
