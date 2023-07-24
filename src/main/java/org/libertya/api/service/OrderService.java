package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.OrderLineRepository;
import org.libertya.api.repository.OrderRepository;
import org.libertya.api.repository.OrderTaxRepository;
import org.libertya.api.stub.model.*;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService extends AbstractService {

    private final OrderRepository orderRepository;

    private final OrderLineRepository orderLineRepository;

    private final OrderTaxRepository orderTaxRepository;

    @Override
    protected AbstractRepository getRepository() {
        return orderRepository;
    }

    @Override
    protected Optional<OrderDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        OrderDocument doc = new OrderDocument();

        // Cabecera
        Optional<Order> inv = orderRepository.retrieve(info, id);
        if (!inv.isPresent())
            return Optional.empty();
        doc.setHeader(inv.get());

        // Lineas
        QueryParams params = new QueryParams();
        params.setFilter("c_Order_id="+id);
        for (Object item : orderLineRepository.retrieveAll(info, params)) {
            doc.addLinesItem(((Optional<OrderLine>)item).get());
        }

        // Impuestos
        for (Object item : orderTaxRepository.retrieveAll(info, params)) {
            doc.addTaxesItem(((Optional<OrderTax>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        OrderDocument OrderDocument = (OrderDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(orderRepository.insert(info, OrderDocument.getHeader(), trxName));

        // Lineas
        for (OrderLine OrderLine : getList(OrderDocument.getLines())) {
            OrderLine.setCOrderId(id);
            orderLineRepository.insert(info, OrderLine, trxName);
        }

        // Impuestos
        for (OrderTax OrderTax : getList(OrderDocument.getTaxes())) {
            OrderTax.setCOrderId(id);
            orderTaxRepository.insert(info, OrderTax, trxName);
        }

        return Integer.toString(id);
    }



}
