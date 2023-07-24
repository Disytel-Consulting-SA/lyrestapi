package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.InventoryLineRepository;
import org.libertya.api.repository.InventoryRepository;
import org.libertya.api.stub.model.Inventory;
import org.libertya.api.stub.model.InventoryDocument;
import org.libertya.api.stub.model.InventoryLine;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService extends AbstractService {

    private final InventoryRepository invRepository;

    private final InventoryLineRepository invLineRepository;

    @Override
    protected AbstractRepository getRepository() {
        return invRepository;
    }

    @Override
    protected Optional<InventoryDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        InventoryDocument doc = new InventoryDocument();

        // Cabecera
        Optional<Inventory> inv = invRepository.retrieve(info, id);
        if (!inv.isPresent())
            return Optional.empty();
        doc.setHeader(inv.get());

        // Lineas
        QueryParams params = new QueryParams();
        params.setFilter("m_inventory_id="+id);
        for (Object item : invLineRepository.retrieveAll(info, params)) {
            doc.addLinesItem(((Optional<InventoryLine>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        InventoryDocument inventoryDocument = (InventoryDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(invRepository.insert(info, inventoryDocument.getHeader(), trxName));

        // Lineas
        for (InventoryLine inventoryLine : getList(inventoryDocument.getLines())) {
            inventoryLine.setMInventoryId(id);
            invLineRepository.insert(info, inventoryLine, trxName);
        }

        return Integer.toString(id);
    }


}
