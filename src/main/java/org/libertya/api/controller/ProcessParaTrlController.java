package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProcessParaTrlRepository;
import org.libertya.api.stub.iface.ProcessparatrlApi;
import org.libertya.api.stub.model.ProcessParaTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProcessParaTrlController extends AbstractController implements ProcessparatrlApi {

    private final HttpServletRequest request;

    private final ProcessParaTrlRepository repository;

    @Override
    public ResponseEntity<List<ProcessParaTrl>> getAllProcessParaTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProcessParaTrl> retrieveProcessParaTrl(Integer idProcessPara, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idProcessPara, idLanguage}));
    }
}
