package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.OrderLineRepository;
import org.libertya.api.repository.OrderRepository;
import org.libertya.api.repository.OrderTaxRepository;
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


    public String createOrder(OrderDocument orderDocument) throws ModelException {
        return super.create(orderDocument, orderRepository);
    }

    @Override
    protected String performCreate(Object document, AbstractRepository docRepository, String trxName) throws Exception {
        OrderDocument orderDocument = (OrderDocument) document;

        // Cabecera
        Integer id = Integer.parseInt(orderRepository.insert(orderDocument.getHeader(), trxName));

        // Lineas
        for (OrderLine OrderLine : orderDocument.getLines()) {
            OrderLine.setCOrderId(id);
            orderLineRepository.insert(OrderLine, trxName);
        }

        // Impuestos
        for (OrderTax OrderTax : orderDocument .getTaxes()) {
            OrderTax.setCOrderId(id);
            orderTaxRepository.insert(OrderTax, trxName);
        }

        return Integer.toString(id);
    }

    @Override
    public <T> Optional<T> retrieve(int id) throws Exception {
        return Optional.empty();
    }


}
