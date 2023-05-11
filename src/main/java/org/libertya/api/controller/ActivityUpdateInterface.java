package org.libertya.api.controller;

import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

@FunctionalInterface
public interface ActivityUpdateInterface {

    /** Actividad de actualizacion
     * @throws NotFoundException en caso de no existir el registro en cuestion
     * @throws ModelException en caso de validacion en logica de negocio */
    void perform() throws NotFoundException, ModelException;
}
