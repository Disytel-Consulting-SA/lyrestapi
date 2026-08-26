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
 * El procesado del documento se expone para CO, VO y CL, y no es una operacion menor: completar genera un
 * C_Payment por el neto y no se puede reactivar, y anular borra todos los cupones de la liquidacion. El
 * detalle de lo que hace cada accion esta en paths/creditcardsettlements_id_process.yaml, que es lo que ve
 * quien consume la API.
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
    public ResponseEntity<String> processCreditCardSettlement(Integer id, String action) {
        return processAction(request, (info) -> repository.process(info, id, action));
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
