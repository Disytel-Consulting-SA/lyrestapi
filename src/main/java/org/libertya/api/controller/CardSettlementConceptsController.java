package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CardSettlementConceptsRepository;
import org.libertya.api.stub.iface.CardsettlementconceptApi;
import org.libertya.api.stub.model.CardSettlementConcepts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Maestro de conceptos de liquidacion de tarjetas, de solo lectura.  type='CO' comisiones, 'OT' otros costos.  Ver docs/liquidaciones-tarjetas-api.md */
@Controller
@RequiredArgsConstructor
public class CardSettlementConceptsController extends AbstractController implements CardsettlementconceptApi {

    private final HttpServletRequest request;

    private final CardSettlementConceptsRepository repository;

    @Override
    public ResponseEntity<List<CardSettlementConcepts>> getAllCardSettlementConcepts(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CardSettlementConcepts> retrieveCardSettlementConcept(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
