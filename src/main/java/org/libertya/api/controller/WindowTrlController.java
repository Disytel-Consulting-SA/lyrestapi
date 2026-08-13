package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.WindowTrlRepository;
import org.libertya.api.stub.iface.WindowtrlApi;
import org.libertya.api.stub.model.WindowTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WindowTrlController extends AbstractController implements WindowtrlApi {

    private final HttpServletRequest request;

    private final WindowTrlRepository repository;

    @Override
    public ResponseEntity<List<WindowTrl>> getAllWindowTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<WindowTrl> retrieveWindowTrl(Integer idWindow, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idWindow, idLanguage}));
    }
}
