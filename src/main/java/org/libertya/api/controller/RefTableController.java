package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.RefTableRepository;
import org.libertya.api.stub.iface.ReftableApi;
import org.libertya.api.stub.model.RefTable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RefTableController extends AbstractController implements ReftableApi {

    private final HttpServletRequest request;

    private final RefTableRepository repository;

    @Override
    public ResponseEntity<List<RefTable>> getAllRefTables(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<RefTable> retrieveRefTable(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}