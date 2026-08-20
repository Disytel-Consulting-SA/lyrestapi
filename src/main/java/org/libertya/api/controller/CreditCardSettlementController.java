package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CreditCardSettlementRepository;
import org.libertya.api.service.CreditCardSettlementService;
import org.libertya.api.stub.iface.CreditcardsettlementApi;
import org.libertya.api.stub.model.CreditCardSettlement;
import org.libertya.api.stub.model.CreditCardSettlementCreated;
import org.libertya.api.stub.model.CreditCardSettlementDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Liquidaciones de tarjetas de credito (C_CreditCardSettlement).
 *
 * NO se expone el procesado del documento. Completar una liquidacion genera un C_Payment por el neto y exige
 * que la liquidacion cuadre dentro de la tolerancia configurada, y ninguna de las dos cosas puede decidirlas
 * una integracion: queda en manos de una persona desde la ventana del ERP.
 */
@Controller
@RequiredArgsConstructor
public class CreditCardSettlementController extends AbstractController implements CreditcardsettlementApi {

    private final HttpServletRequest request;

    private final CreditCardSettlementRepository repository;

    private final CreditCardSettlementService service;

    @Override
    public ResponseEntity<String> addCreditCardSettlement(CreditCardSettlement body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<CreditCardSettlementCreated> addCreditCardSettlementFull(CreditCardSettlementDocument body) {
        return insertObjectAction(request, (info) -> service.createFull(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCreditCardSettlement(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<CreditCardSettlement>> getAllCreditCardSettlements(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CreditCardSettlement> retrieveCreditCardSettlement(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCreditCardSettlement(Integer id, CreditCardSettlement body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
