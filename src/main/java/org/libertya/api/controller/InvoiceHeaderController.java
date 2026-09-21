package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.InvoiceRepository;
import org.libertya.api.stub.iface.InvoiceheaderApi;
import org.libertya.api.stub.model.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class InvoiceHeaderController extends AbstractController implements InvoiceheaderApi {

    private final HttpServletRequest request;

    private final InvoiceRepository repository;

    @Override
    public ResponseEntity<String> addInvoiceHeader(Invoice body) {
        return insertAction(request, (info) -> repository.insert(info, body));
    }
}