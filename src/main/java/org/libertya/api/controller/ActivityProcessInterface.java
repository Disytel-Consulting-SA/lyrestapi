package org.libertya.api.controller;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

@FunctionalInterface
public interface ActivityProcessInterface {

    /** Actividad de procesado de un documento
     * @param info informacion de la solicitud
     * @throws NotFoundException en caso de que no exista el documento
     * @throws ModelException en caso de validacion en logica de negocio
     */
    String perform(UserInfo info) throws ModelException, NotFoundException, AuthException;


}
