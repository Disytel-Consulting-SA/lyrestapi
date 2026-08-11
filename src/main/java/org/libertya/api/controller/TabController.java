package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.TabRepository;
import org.libertya.api.stub.iface.TabApi;
import org.libertya.api.stub.model.Tab;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TabController extends AbstractController implements TabApi {

    private final HttpServletRequest request;

    private final TabRepository repository;

    @Override
    public ResponseEntity<List<Tab>> getAllTabs(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Tab> retrieveTab(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}