package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ValRuleRepository;
import org.libertya.api.stub.iface.ValruleApi;
import org.libertya.api.stub.model.ValRule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ValRuleController extends AbstractController implements ValruleApi {

    private final HttpServletRequest request;

    private final ValRuleRepository repository;

    @Override
    public ResponseEntity<List<ValRule>> getAllValRules(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ValRule> retrieveValRule(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}