package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.MessageTrlRepository;
import org.libertya.api.stub.iface.MessagetrlApi;
import org.libertya.api.stub.model.MessageTrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageTrlController extends AbstractController implements MessagetrlApi {

    private final HttpServletRequest request;

    private final MessageTrlRepository repository;

    @Override
    public ResponseEntity<List<MessageTrl>> getAllMessageTrls(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<MessageTrl> retrieveMessageTrl(Integer idMessage, String idLanguage) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new Object[]{idMessage, idLanguage}));
    }
}
