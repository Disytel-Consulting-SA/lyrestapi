package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProcessParaRepository;
import org.libertya.api.stub.iface.ProcessparaApi;
import org.libertya.api.stub.model.ProcessPara;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProcessParaController extends AbstractController implements ProcessparaApi {

    private final HttpServletRequest request;

    private final ProcessParaRepository repository;

    @Override
    public ResponseEntity<List<ProcessPara>> getAllProcessParas(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProcessPara> retrieveProcessPara(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}