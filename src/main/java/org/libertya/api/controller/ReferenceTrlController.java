package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ReferenceTrlRepository;
import org.libertya.api.stub.iface.ReferencetrlApi;
import org.libertya.api.stub.model.ReferenceTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReferenceTrlController extends AbstractController implements ReferencetrlApi {

    private final HttpServletRequest request;

    private final ReferenceTrlRepository repository;

    @Override
    public ResponseEntity<List<ReferenceTrl>> getAllReferenceTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ReferenceTrl> retrieveReferenceTrl(Integer idReference, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idReference, idLanguage}));
    }
}
