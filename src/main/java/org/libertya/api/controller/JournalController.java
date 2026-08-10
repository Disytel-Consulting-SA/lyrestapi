package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.JournalRepository;
import org.libertya.api.service.JournalService;
import org.libertya.api.stub.iface.JournalApi;
import org.libertya.api.stub.model.Journal;
import org.libertya.api.stub.model.JournalDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Asientos contables manuales (GL_Journal).
 *
 * OJO: no confundir con PosJournalController, que es la caja diaria de punto de venta (C_POSJournal) y no
 * tiene ninguna relacion con la contabilidad.
 */
@Controller
@RequiredArgsConstructor
public class JournalController extends AbstractController implements JournalApi {

    private final HttpServletRequest request;

    private final JournalRepository repository;

    private final JournalService service;

    @Override
    public ResponseEntity<String> addJournal(JournalDocument body, Boolean complete, Boolean validatebalance) {
        return insertAction(request, (info) -> service.create(info, body, complete, validatebalance));
    }

    @Override
    public ResponseEntity<String> deleteJournal(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Journal>> getAllJournals(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<JournalDocument> retrieveJournal(Integer id) {
        return retrieveAction(request, (info) -> service.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateJournal(Integer id, Journal body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processJournal(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}
