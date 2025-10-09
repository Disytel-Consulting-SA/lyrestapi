package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CheckCuitControlRepository;
import org.libertya.api.stub.iface.CheckcuitcontrolApi;
import org.libertya.api.stub.model.CheckCuitControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CheckCuitControlController extends AbstractController implements CheckcuitcontrolApi {

    private final HttpServletRequest request;

    private final CheckCuitControlRepository repository;

    @Override
    public ResponseEntity<String> addCheckCuitControl(CheckCuitControl body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCheckCuitControl(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<CheckCuitControl>> getAllCheckCuitControls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CheckCuitControl> retrieveCheckCuitControl(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCheckCuitControl(Integer id, CheckCuitControl body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
