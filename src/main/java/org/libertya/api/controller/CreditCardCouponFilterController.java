package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CreditCardCouponFilterRepository;
import org.libertya.api.stub.iface.CreditcardcouponfilterApi;
import org.libertya.api.stub.model.CreditCardCouponFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Filtros de cupones (C_CreditCardCouponFilter): la fila de la que cuelgan los cupones dentro de una
 * liquidacion. Normalmente no hace falta usar estos endpoints, porque
 * POST /v1.0/creditcardsettlements/full ya crea el filtro por defecto junto con la cabecera.
 */
@Controller
@RequiredArgsConstructor
public class CreditCardCouponFilterController extends AbstractController implements CreditcardcouponfilterApi {

    private final HttpServletRequest request;

    private final CreditCardCouponFilterRepository repository;

    @Override
    public ResponseEntity<String> addCreditCardCouponFilter(CreditCardCouponFilter body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteCreditCardCouponFilter(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<CreditCardCouponFilter>> getAllCreditCardCouponFilters(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CreditCardCouponFilter> retrieveCreditCardCouponFilter(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
