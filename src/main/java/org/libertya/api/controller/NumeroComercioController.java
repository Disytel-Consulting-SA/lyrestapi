package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.NumeroComercioRepository;
import org.libertya.api.stub.iface.NumerocomercioApi;
import org.libertya.api.stub.model.NumeroComercio;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Maestro de numeros de comercio, de solo lectura.  Ver docs/liquidaciones-tarjetas-api.md */
@Controller
@RequiredArgsConstructor
public class NumeroComercioController extends AbstractController implements NumerocomercioApi {

    private final HttpServletRequest request;

    private final NumeroComercioRepository repository;

    @Override
    public ResponseEntity<List<NumeroComercio>> getAllNumerosComercio(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<NumeroComercio> retrieveNumeroComercio(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
