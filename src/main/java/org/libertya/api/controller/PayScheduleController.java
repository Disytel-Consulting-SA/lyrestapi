package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PayScheduleRepository;
import org.libertya.api.stub.iface.PayscheduleApi;
import org.libertya.api.stub.model.PaySchedule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PayScheduleController extends AbstractController implements PayscheduleApi {

    private final HttpServletRequest request;

    private final PayScheduleRepository repository;

    @Override
    public ResponseEntity<String> addPaySchedule(PaySchedule body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePaySchedule(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<PaySchedule>> getAllPaySchedules(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<PaySchedule> retrievePaySchedule(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePaySchedule(Integer id, PaySchedule body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
