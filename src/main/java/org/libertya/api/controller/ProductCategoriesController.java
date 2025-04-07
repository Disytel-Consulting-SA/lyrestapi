package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.ProductCategoriesRepository;
import org.libertya.api.stub.iface.ProductcategoriesApi;
import org.libertya.api.stub.model.ProductCategories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductCategoriesController extends AbstractController implements ProductcategoriesApi {

    private final HttpServletRequest request;

    private final ProductCategoriesRepository repository;

    @Override
    public ResponseEntity<String> addProductCategory(ProductCategories body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }

    @Override
    public ResponseEntity<String> deleteProductCategory(Integer id) {
        return deleteAction(request, (info) -> repository.delete(info, id));
    }

    @Override
    public ResponseEntity<List<ProductCategories>> getAllProductCategories(String filter, String fields, String sort, Integer limit, Integer page) {
        return retrieveAllAction(request, repository, query(filter, fields, sort, limit, page));
    }

    @Override
    public ResponseEntity<ProductCategories> retrieveProductCategory(Integer id) {
        return retrieveAction(request, (info) -> repository.retrieve(info, id));
    }

    @Override
    public ResponseEntity<String> updateProductCategory(Integer id, ProductCategories body) {
        return updateAction(request, (info) -> repository.update(info, id, body));
    }

}
