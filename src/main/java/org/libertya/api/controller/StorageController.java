package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.StorageRepository;
import org.libertya.api.stub.iface.StorageApi;
import org.libertya.api.stub.model.Storage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StorageController extends AbstractController implements StorageApi {

    private final HttpServletRequest request;

    private final StorageRepository repository;

    @Override
    public ResponseEntity<List<Storage>> getAllStorages(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<Storage> retrieveStorage(Integer idProduct, Integer idLocator) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new int[]{idProduct, idLocator}));
    }

    @Override
    public ResponseEntity<List<Storage>> retrieveStoragesOfProduct(Integer idProduct) {
        return retrieveAllAction(request, repository, query("M_Product_ID="+idProduct, null, null, null, null));
    }
}
