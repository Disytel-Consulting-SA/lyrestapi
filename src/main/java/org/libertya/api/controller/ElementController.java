package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ElementRepository;
import org.libertya.api.stub.iface.ElementApi;
import org.libertya.api.stub.model.Element;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ElementController extends AbstractController implements ElementApi {

    private final HttpServletRequest request;

    private final ElementRepository repository;

    @Override
    public ResponseEntity<List<Element>> getAllElements(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Element> retrieveElement(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}