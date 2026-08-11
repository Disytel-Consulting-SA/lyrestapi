package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.TableRepository;
import org.libertya.api.stub.iface.TableApi;
import org.libertya.api.stub.model.Table;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TableController extends AbstractController implements TableApi {

    private final HttpServletRequest request;

    private final TableRepository repository;

    @Override
    public ResponseEntity<List<Table>> getAllTables(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Table> retrieveTable(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
