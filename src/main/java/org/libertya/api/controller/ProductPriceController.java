package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductPriceRepository;
import org.libertya.api.stub.iface.ProductpriceApi;
import org.libertya.api.stub.model.ProductPrice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductPriceController extends AbstractController implements ProductpriceApi {

    private final HttpServletRequest request;

    private final ProductPriceRepository repository;

    @Override
    public ResponseEntity<String> addProductPrice(ProductPrice body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteProductPrice(Integer idProduct, Integer idPriceListVersion) {
        return deleteAction(request, (info) -> repository.delete(info, new int[]{idProduct, idPriceListVersion}));
    }

    @Override
    public ResponseEntity<List<ProductPrice>> getAllProductPrices(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, filter, fields, sort, limit, page);
    }

    @Override
    public ResponseEntity<ProductPrice> retrieveProductPrice(Integer idProduct, Integer idPriceListVersion) {
        return retrieveAction(request, (info) -> repository.retrieve(info, new int[]{idProduct, idPriceListVersion}));
    }

    @Override
    public ResponseEntity<String> updateProductPrice(ProductPrice body, Integer idProduct, Integer idPriceListVersion) {
        return updateAction(request, (info) -> repository.update(info, new int[]{idProduct, idPriceListVersion}, body));
    }
}
