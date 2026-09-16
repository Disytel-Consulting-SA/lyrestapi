package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.OrgInfoRepository;
import org.libertya.api.stub.iface.OrginfoApi;
import org.libertya.api.stub.model.OrgInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** Informacion adicional de organizaciones (AD_OrgInfo), de solo lectura.  El {id} es el ad_org_id: la tabla no tiene ID propio.  Ver docs/liquidaciones-tarjetas-api.md */
@Controller
@RequiredArgsConstructor
public class OrgInfoController extends AbstractController implements OrginfoApi {

    private final HttpServletRequest request;

    private final OrgInfoRepository repository;

    @Override
    public ResponseEntity<List<OrgInfo>> getAllOrgInfos(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<OrgInfo> retrieveOrgInfo(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }
}
