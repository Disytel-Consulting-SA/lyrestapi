package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PreferenceRepository;
import org.libertya.api.stub.iface.PreferenceApi;
import org.libertya.api.stub.model.Preference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PreferenceController extends AbstractController implements PreferenceApi {

    private final HttpServletRequest request;

    private final PreferenceRepository repository;

    @Override
    public ResponseEntity<String> addPreference(Preference body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePreference(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Preference>> getAllPreferences(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Preference> retrievePreference(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePreference(Integer id, Preference body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
