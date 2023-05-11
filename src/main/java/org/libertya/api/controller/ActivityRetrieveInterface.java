package org.libertya.api.controller;

import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

import java.util.Optional;

@FunctionalInterface
public interface ActivityRetrieveInterface<T> {

    /** Actividad de recuperacion de una entidad
     * @return un opcional con el objeto recuperado */
    Optional<T> perform();
}
