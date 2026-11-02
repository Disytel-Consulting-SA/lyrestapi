package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CouponsSettlementsRepository;
import org.libertya.api.service.CouponsSettlementsService;
import org.libertya.api.stub.iface.CouponssettlementApi;
import org.libertya.api.stub.model.CouponsSettlements;
import org.libertya.api.stub.model.CouponsSettlementsBulk;
import org.libertya.api.stub.model.CouponsSettlementsBulkResult;
import org.libertya.api.stub.model.CouponsSettlementsExists;
import org.libertya.api.stub.model.CouponsSettlementsExistsResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Cupones de liquidacion (C_CouponsSettlements): la fila que vincula un cobro con una liquidacion.
 *
 * Los dos endpoints de lote responden 200 aunque haya items rechazados. Un conflicto no es un error de la
 * llamada sino un resultado normal del item, y el consumidor tiene que leer el estado de cada uno.
 */
@Controller
@RequiredArgsConstructor
public class CouponsSettlementsController extends AbstractController implements CouponssettlementApi {

    private final HttpServletRequest request;

    private final CouponsSettlementsRepository repository;

    private final CouponsSettlementsService service;

    @Override
    public ResponseEntity<String> addCouponsSettlement(CouponsSettlements body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<CouponsSettlementsBulkResult> addCouponsSettlementsBulk(CouponsSettlementsBulk body) {
        return insertObjectAction(request, (info) -> service.bulk(info, body));
    }

    @Override
    public ResponseEntity<CouponsSettlementsExistsResult> existsCouponsSettlements(CouponsSettlementsExists body) {
        return insertObjectAction(request, (info) -> service.exists(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCouponsSettlement(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<CouponsSettlements>> getAllCouponsSettlements(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CouponsSettlements> retrieveCouponsSettlement(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCouponsSettlement(Integer id, CouponsSettlements body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
