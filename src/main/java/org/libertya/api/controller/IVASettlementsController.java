package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.IVASettlementsRepository;
import org.libertya.api.stub.iface.IvasettlementApi;
import org.libertya.api.stub.model.IVASettlements;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * IVA de una liquidacion de tarjetas (C_IVASettlements).
 *
 * No se expone POST ni DELETE: las filas ya vienen creadas por generateAllChildrens() al crearse la cabecera,
 * una por cada impuesto activo. Lo unico que hay que hacer es listarlas para saber que concepto es cada
 * una y cargarles el importe con PUT, que dispara el recalculo del total IVAAmount de la cabecera.
 *
 * Ver docs/liquidaciones-tarjetas-api.md
 */
@Controller
@RequiredArgsConstructor
public class IVASettlementsController extends AbstractController implements IvasettlementApi {

    private final HttpServletRequest request;

    private final IVASettlementsRepository repository;

    @Override
    public ResponseEntity<List<IVASettlements>> getAllIVASettlements(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<IVASettlements> retrieveIVASettlements(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateIVASettlements(Integer id, IVASettlements body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }
}
