package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.TabTrlRepository;
import org.libertya.api.stub.iface.TabtrlApi;
import org.libertya.api.stub.model.TabTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TabTrlController extends AbstractController implements TabtrlApi {

    private final HttpServletRequest request;

    private final TabTrlRepository repository;

    @Override
    public ResponseEntity<List<TabTrl>> getAllTabTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<TabTrl> retrieveTabTrl(Integer idTab, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idTab, idLanguage}));
    }
}
