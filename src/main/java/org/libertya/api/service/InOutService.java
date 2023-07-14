package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.InOutLineRepository;
import org.libertya.api.repository.InOutRepository;
import org.libertya.api.stub.model.InOut;
import org.libertya.api.stub.model.InOutDocument;
import org.libertya.api.stub.model.InOutLine;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InOutService extends AbstractService {

    private final InOutRepository inoutRepository;

    private final InOutLineRepository inoutLineLineRepository;

    @Override
    protected AbstractRepository getRepository() {
        return inoutRepository;
    }

    @Override
    protected Optional<InOutDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        InOutDocument doc = new InOutDocument();

        // Cabecera
        Optional<InOut> inout = inoutRepository.retrieve(info, id);
        if (!inout.isPresent())
            return Optional.empty();
        doc.setHeader(inout.get());

        // Lineas
        for (Object item : inoutLineLineRepository.retrieveAll(info,"m_InOut_id="+id, null, null, null, null )) {
            doc.addLinesItem(((Optional<InOutLine>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        InOutDocument InOutDocument = (InOutDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(inoutRepository.insert(info, InOutDocument.getHeader(), trxName));

        // Lineas
        for (InOutLine InOutLine : getList(InOutDocument.getLines())) {
            InOutLine.setMInoutId(id);
            inoutLineLineRepository.insert(info, InOutLine, trxName);
        }

        return Integer.toString(id);
    }



}
