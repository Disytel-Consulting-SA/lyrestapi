package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.WithholdingSettlementRepository;
import org.libertya.api.stub.iface.WithholdingsettlementApi;
import org.libertya.api.stub.model.WithholdingSettlement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Retenciones sufridas de una liquidacion de tarjetas (C_WithholdingSettlement).
 *
 * No se expone POST ni DELETE: las filas ya vienen creadas por generateAllChildrens() al crearse la cabecera,
 * una por cada esquema de retencion sufrida activo. Lo unico que hay que hacer es listarlas para saber que concepto es cada
 * una y cargarles el importe con PUT, que dispara el recalculo del total Withholding de la cabecera.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Controller
@RequiredArgsConstructor
public class WithholdingSettlementController extends AbstractController implements WithholdingsettlementApi {

    private final HttpServletRequest request;

    private final WithholdingSettlementRepository repository;

    @Override
    public ResponseEntity<List<WithholdingSettlement>> getAllWithholdingSettlements(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<WithholdingSettlement> retrieveWithholdingSettlement(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateWithholdingSettlement(Integer id, WithholdingSettlement body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
