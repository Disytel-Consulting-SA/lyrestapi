package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.AllocationHdrRepository;
import org.libertya.api.repository.AllocationLineRepository;
import org.libertya.api.stub.model.AllocationDocument;
import org.libertya.api.stub.model.AllocationHdr;
import org.libertya.api.stub.model.AllocationLine;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AllocationService extends AbstractService {

    private final AllocationHdrRepository allocHdrRepository;

    private final AllocationLineRepository allocLineRepository;

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        AllocationDocument allocDocument = (AllocationDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(allocHdrRepository.insert(info, allocDocument.getHeader(), trxName));

        // Lineas
        for (AllocationLine allocLine : getList(allocDocument.getLines())) {
            allocLine.setCAllocationhdrId(id);
            allocLineRepository.insert(info, allocLine, trxName);
        }

        return Integer.toString(id);
    }

    @Override
    protected Optional<AllocationDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        AllocationDocument doc = new AllocationDocument();

        // Cabecera
        Optional<AllocationHdr> header = allocHdrRepository.retrieve(info, id);
        if (!header.isPresent())
            return Optional.empty();
        doc.setHeader(header.get());

        // Lineas
        for (Object item : allocLineRepository.retrieveAll(info, "c_allocationhdr_id="+id, null, null, null, null)) {
            doc.addLinesItem(((Optional<AllocationLine>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected AbstractRepository getRepository() {
        return allocHdrRepository;
    }
}
