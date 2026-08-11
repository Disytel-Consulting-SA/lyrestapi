package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.WindowRepository;
import org.libertya.api.stub.iface.WindowApi;
import org.libertya.api.stub.model.Window;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WindowController extends AbstractController implements WindowApi {

    private final HttpServletRequest request;

    private final WindowRepository repository;

    @Override
    public ResponseEntity<List<Window>> getAllWindows(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Window> retrieveWindow(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}