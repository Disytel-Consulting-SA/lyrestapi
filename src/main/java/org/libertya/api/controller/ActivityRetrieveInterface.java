package org.libertya.api.controller;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.ModelException;

import java.util.Optional;

@FunctionalInterface
public interface ActivityRetrieveInterface<T> {

    /** Actividad de recuperacion de una entidad
     * @return un opcional con el objeto recuperado */
    Optional<T> perform(UserInfo info) throws ModelException;
}
