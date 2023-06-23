package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService extends AbstractService {

    private final PaymentRepository repository;

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        return repository.insert(info, document, trxName);
    }

    @Override
    protected <T> Optional<T> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        return repository.retrieve(info, id);
    }

    @Override
    protected AbstractRepository getRepository() {
        return repository;
    }
}
