package org.libertya.api.controller;

import org.libertya.api.exception.ModelException;

@FunctionalInterface
public interface ActivityInsertInterface {

    /** Actividad de insercion
     * @return un String conteniendo el identificador de la entidad insertada
     * @throws ModelException en caso de validacion en logica de negocio */
    String perform() throws ModelException;
}
