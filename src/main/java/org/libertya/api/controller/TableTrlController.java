package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.TableTrlRepository;
import org.libertya.api.stub.iface.TabletrlApi;
import org.libertya.api.stub.model.TableTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TableTrlController extends AbstractController implements TabletrlApi {

    private final HttpServletRequest request;

    private final TableTrlRepository repository;

    @Override
    public ResponseEntity<List<TableTrl>> getAllTableTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<TableTrl> retrieveTableTrl(Integer idTable, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idTable, idLanguage}));
    }
}
