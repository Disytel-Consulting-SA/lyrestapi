package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.UserRepository;
import org.libertya.api.stub.model.User;
import org.openXpertya.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${org.libertya.api.service.user.operations}")
    private String enabledOps;

    final UserRepository repository;

    public String insert(UserInfo info, Object payload) throws ModelException, AuthException {
        if (!Util.isEmpty(enabledOps) && enabledOps.toUpperCase().contains("C")) {
            return repository.insert(info, payload);
        }
        throw new AuthException("La creacion de usuarios no se encuentra habilitada");
    }

    public <T> Optional<User> retrieve(UserInfo info, int id) throws ModelException, AuthException {
        if (!Util.isEmpty(enabledOps) && enabledOps.toUpperCase().contains("R")) {
            Optional<User> user = repository.retrieve(info, id);
            if (user.isPresent()) {
                user.get().setPassword(null);
            }
            return user;
        }
        throw new AuthException("La recuperacion de usuarios no se encuentra habilitada");
    }

    public void update(UserInfo info, int id, Object payload) throws ModelException, NotFoundException, AuthException {
        if (!Util.isEmpty(enabledOps) && enabledOps.toUpperCase().contains("U")) {
            repository.update(info, id, payload);
            return;
        }
        throw new AuthException("La actualizacion de usuarios no se encuentra habilitada");
    }

    public void delete(UserInfo info, int id) throws ModelException, NotFoundException, AuthException {
        if (!Util.isEmpty(enabledOps) && enabledOps.toUpperCase().contains("D")) {
            repository.delete(info, id);
            return;
        }
        throw new AuthException("La eliminacion de usuarios no se encuentra habilitada");
    }

}
