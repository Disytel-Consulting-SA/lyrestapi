package org.libertya.api.controller;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;

@FunctionalInterface
public interface ActivityInsertInterface {

    /** Actividad de insercion
     * @param info informacion de la solicitud
     * @return un String conteniendo el identificador de la entidad insertada
     * @throws ModelException en caso de validacion en logica de negocio */
    String perform(UserInfo info) throws ModelException, AuthException;
}
