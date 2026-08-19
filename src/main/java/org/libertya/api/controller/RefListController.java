package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.RefListRepository;
import org.libertya.api.stub.iface.ReflistApi;
import org.libertya.api.stub.model.RefList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RefListController extends AbstractController implements ReflistApi {

    private final HttpServletRequest request;

    private final RefListRepository repository;

    @Override
    public ResponseEntity<List<RefList>> getAllRefLists(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<RefList> retrieveRefList(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}