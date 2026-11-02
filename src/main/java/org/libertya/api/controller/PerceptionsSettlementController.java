package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.PerceptionsSettlementRepository;
import org.libertya.api.stub.iface.PerceptionssettlementApi;
import org.libertya.api.stub.model.PerceptionsSettlement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Percepciones de una liquidacion de tarjetas (C_PerceptionsSettlement).
 *
 * No se expone POST ni DELETE: las filas ya vienen creadas por generateAllChildrens() al crearse la cabecera,
 * una por cada percepcion activa. Lo unico que hay que hacer es listarlas para saber que concepto es cada
 * una y cargarles el importe con PUT, que dispara el recalculo del total Perception de la cabecera.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Controller
@RequiredArgsConstructor
public class PerceptionsSettlementController extends AbstractController implements PerceptionssettlementApi {

    private final HttpServletRequest request;

    private final PerceptionsSettlementRepository repository;

    @Override
    public ResponseEntity<List<PerceptionsSettlement>> getAllPerceptionsSettlements(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<PerceptionsSettlement> retrievePerceptionsSettlement(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updatePerceptionsSettlement(Integer id, PerceptionsSettlement body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
