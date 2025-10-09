package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.POSJournalRepository;
import org.libertya.api.stub.iface.PosjournalApi;
import org.libertya.api.stub.model.POSJournal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class POSJournalController extends AbstractController implements PosjournalApi {

    private final HttpServletRequest request;

    private final POSJournalRepository repository;

    @Override
    public ResponseEntity<String> addPOSJournal(POSJournal body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePOSJournal(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<POSJournal>> getAllPOSJournals(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<POSJournal> retrievePOSJournal(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePOSJournal(Integer id, POSJournal body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

    @Override
    public ResponseEntity<String> processPOSJournal(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
    }
}
