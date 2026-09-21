package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InOutRepository;
import org.libertya.api.stub.iface.InoutheaderApi;
import org.libertya.api.stub.model.InOut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class InOutHeaderController extends AbstractController implements InoutheaderApi {

    private final HttpServletRequest request;

    private final InOutRepository repository;

    @Override
    public ResponseEntity<String> addInOutHeader(InOut body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }
}