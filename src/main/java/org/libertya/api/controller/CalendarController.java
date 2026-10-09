package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CalendarRepository;
import org.libertya.api.stub.iface.CalendarApi;
import org.libertya.api.stub.model.Calendar;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CalendarController extends AbstractController implements CalendarApi {

    private final HttpServletRequest request;

    private final CalendarRepository repository;

    @Override
    public ResponseEntity<String> addCalendar(Calendar body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCalendar(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Calendar>> getAllCalendars(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Calendar> retrieveCalendar(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCalendar(Integer id, Calendar body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
