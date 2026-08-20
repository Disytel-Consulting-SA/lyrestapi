package org.libertya.api.controller;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;

@FunctionalInterface
public interface ActivityInsertObjectInterface<T> {

    /** Actividad de insercion cuya respuesta es un objeto JSON y no el identificador en texto plano
     * @param info informacion de la solicitud
     * @return el objeto a serializar en el cuerpo de la respuesta
     * @throws ModelException en caso de validacion en logica de negocio */
    T perform(UserInfo info) throws ModelException, AuthException;
}
