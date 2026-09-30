package org.libertya.api.controller;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

import java.util.List;

@FunctionalInterface
public interface ActivityRetrieveAllInterface<T> {

    /** Actividad de recuperacion de varias entidades
     * @param info informacion de la solicitud
     * @param params filtro, campos, orden y paginado
     * @return la lista de entidades recuperadas
     * @throws NotFoundException en caso de no existir la tabla (endpoint generico)
     * @throws ModelException en caso de validacion en logica de negocio */
    List<T> perform(UserInfo info, QueryParams params) throws ModelException, NotFoundException, AuthException;
}
