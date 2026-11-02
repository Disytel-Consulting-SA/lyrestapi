package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.CommissionConceptsRepository;
import org.libertya.api.stub.iface.CommissionconceptApi;
import org.libertya.api.stub.model.CommissionConcepts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Comisiones de una liquidacion de tarjetas (C_CommissionConcepts).
 *
 * No se expone POST ni DELETE: las filas ya vienen creadas por generateAllChildrens() al crearse la cabecera,
 * una por cada concepto de tarjeta de tipo comision. Lo unico que hay que hacer es listarlas para saber que concepto es cada
 * una y cargarles el importe con PUT, que dispara el recalculo del total CommissionAmount de la cabecera.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Controller
@RequiredArgsConstructor
public class CommissionConceptsController extends AbstractController implements CommissionconceptApi {

    private final HttpServletRequest request;

    private final CommissionConceptsRepository repository;

    @Override
    public ResponseEntity<List<CommissionConcepts>> getAllCommissionConcepts(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<CommissionConcepts> retrieveCommissionConcepts(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateCommissionConcepts(Integer id, CommissionConcepts body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
