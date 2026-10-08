package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProcessRepository;
import org.libertya.api.stub.iface.ProcessApi;
import org.libertya.api.stub.model.Process;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProcessController extends AbstractController implements ProcessApi {

    private final HttpServletRequest request;

    private final ProcessRepository repository;

    @Override
    public ResponseEntity<List<Process>> getAllProcesses(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Process> retrieveProcess(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}