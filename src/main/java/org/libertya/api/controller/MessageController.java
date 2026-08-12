package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.MessageRepository;
import org.libertya.api.stub.iface.MessageApi;
import org.libertya.api.stub.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController extends AbstractController implements MessageApi {

    private final HttpServletRequest request;

    private final MessageRepository repository;

    @Override
    public ResponseEntity<List<Message>> getAllMessages(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Message> retrieveMessage(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}