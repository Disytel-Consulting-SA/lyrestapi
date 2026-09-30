package org.libertya.api.controller;

import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

@FunctionalInterface
public interface ActivityCountInterface {

    /** Actividad de conteo de entidades (header X-Total-Count)
     * @param info informacion de la solicitud
     * @param params filtro a respetar (el paginado se ignora)
     * @return la cantidad total de entidades que respetan el filtro
     * @throws NotFoundException en caso de no existir la tabla (endpoint generico)
     * @throws ModelException en caso de validacion en logica de negocio */
    int perform(UserInfo info, QueryParams params) throws ModelException, NotFoundException, AuthException;
}
