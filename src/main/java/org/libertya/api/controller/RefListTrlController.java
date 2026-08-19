package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.RefListTrlRepository;
import org.libertya.api.stub.iface.ReflisttrlApi;
import org.libertya.api.stub.model.RefListTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RefListTrlController extends AbstractController implements ReflisttrlApi {

    private final HttpServletRequest request;

    private final RefListTrlRepository repository;

    @Override
    public ResponseEntity<List<RefListTrl>> getAllRefListTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<RefListTrl> retrieveRefListTrl(Integer idRefList, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idRefList, idLanguage}));
    }
}
