package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProcessTrlRepository;
import org.libertya.api.stub.iface.ProcesstrlApi;
import org.libertya.api.stub.model.ProcessTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProcessTrlController extends AbstractController implements ProcesstrlApi {

    private final HttpServletRequest request;

    private final ProcessTrlRepository repository;

    @Override
    public ResponseEntity<List<ProcessTrl>> getAllProcessTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProcessTrl> retrieveProcessTrl(Integer idProcess, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idProcess, idLanguage}));
    }
}
