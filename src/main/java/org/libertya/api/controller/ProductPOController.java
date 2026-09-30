package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductPORepository;
import org.libertya.api.stub.iface.ProductpoApi;
import org.libertya.api.stub.model.ProductPO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductPOController extends AbstractController implements ProductpoApi {

    private final HttpServletRequest request;

    private final ProductPORepository repository;

    @Override
    public ResponseEntity<String> addProductPO(ProductPO body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteProductPO(Integer idProduct, Integer idBPartner) {
        return deleteAction(request, (info) -> repository.delete(info, new int[]{idProduct, idBPartner}));
    }

    @Override
    public ResponseEntity<List<ProductPO>> getAllProductPOs(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProductPO> retrieveProductPO(Integer idProduct, Integer idBPartner) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new int[]{idProduct, idBPartner}));
    }

    @Override
    public ResponseEntity<String> updateProductPO(Integer idProduct, Integer idBPartner, ProductPO body) {
        return updateAction(request, (info) -> repository.update(info, idProduct, idBPartner, body));
    }
}
