package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.JournalLineRepository;
import org.libertya.api.stub.iface.JournallineApi;
import org.libertya.api.stub.model.JournalLine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Lineas sueltas de asiento contable (GL_JournalLine), para corregir un asiento en borrador. */
@Controller
@RequiredArgsConstructor
public class JournalLineController extends AbstractController implements JournallineApi {

    private final HttpServletRequest request;

    private final JournalLineRepository repository;

    @Override
    public ResponseEntity<String> addJournalLine(JournalLine body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteJournalLine(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<JournalLine>> getAllJournalLines(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<JournalLine> retrieveJournalLine(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateJournalLine(Integer id, JournalLine body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
