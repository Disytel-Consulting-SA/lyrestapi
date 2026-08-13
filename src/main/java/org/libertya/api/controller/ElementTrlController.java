package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ElementTrlRepository;
import org.libertya.api.stub.iface.ElementtrlApi;
import org.libertya.api.stub.model.ElementTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ElementTrlController extends AbstractController implements ElementtrlApi {

    private final HttpServletRequest request;

    private final ElementTrlRepository repository;

    @Override
    public ResponseEntity<List<ElementTrl>> getAllElementTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ElementTrl> retrieveElementTrl(Integer idElement, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idElement, idLanguage}));
    }
}
