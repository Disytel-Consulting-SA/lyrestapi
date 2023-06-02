package org.libertya.api.controller;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

@FunctionalInterface
public interface ActivityDeleteInterface {

    /** Actividad de eliminacion
     * @throws NotFoundException en caso de no existir el registro en cuestion
     * @throws ModelException en caso de validacion en logica de negocio */
    void perform(UserInfo info) throws NotFoundException, ModelException, AuthException;
}
