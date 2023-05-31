package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.OrderLineRepository;
import org.libertya.api.repository.OrderRepository;
import org.libertya.api.repository.OrderTaxRepository;
import org.libertya.api.stub.model.Order;
import org.libertya.api.stub.model.OrderDocument;
import org.libertya.api.stub.model.OrderLine;
import org.libertya.api.stub.model.OrderTax;
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
    protected Optional<OrderDocument> performRetrieve(int id) throws ModelException {
        OrderDocument doc = new OrderDocument();

        // Cabecera
        Optional<Order> inv = orderRepository.retrieve(id);
        if (!inv.isPresent())
            return Optional.empty();
        doc.setHeader(inv.get());

        // Lineas
        for (Object item : orderLineRepository.retrieveAll("c_Order_id="+id, null, null, null, null )) {
            doc.addLinesItem(((Optional<OrderLine>)item).get());
        }

        // Impuestos
        for (Object item : orderTaxRepository.retrieveAll("c_Order_id="+id, null, null, null, null )) {
            doc.addTaxesItem(((Optional<OrderTax>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected String performCreate(Object document, AbstractRepository docRepository, String trxName) throws Exception {
        OrderDocument OrderDocument = (OrderDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(orderRepository.insert(OrderDocument.getHeader(), trxName));

        // Lineas
        for (OrderLine OrderLine : OrderDocument.getLines()) {
            OrderLine.setCOrderId(id);
            orderLineRepository.insert(OrderLine, trxName);
        }

        // Impuestos
        for (OrderTax OrderTax : OrderDocument.getTaxes()) {
            OrderTax.setCOrderId(id);
            orderTaxRepository.insert(OrderTax, trxName);
        }

        return Integer.toString(id);
    }



}
