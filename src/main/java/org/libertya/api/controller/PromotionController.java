package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PromotionRepository;
import org.libertya.api.stub.iface.PromotionApi;
import org.libertya.api.stub.model.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PromotionController extends AbstractController implements PromotionApi {

    private final HttpServletRequest request;

    private final PromotionRepository repository;

    @Override
    public ResponseEntity<String> addPromotion(Promotion body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deletePromotion(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<Promotion>> getAllPromociones(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Promotion> retrievePromotion(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePromotion(Integer id, Promotion body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
