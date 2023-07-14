package org.libertya.api.security;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.openXpertya.model.MOrg;
import org.openXpertya.model.PO;

public class ClientOrgAuth {

    /**
     * Valida si el usuario que está intentando ejecutar la operacion tiene los permisos correspondientes.
     * @param info informacion del usuario que realiza la peticion de operacion.
     *             En el unico caso en que info puede ser null es al momento de generar el token
     * @param aPO objeto a gestionar
     * @return el aPO validado
     * @throws AuthException en caso de no tener los permisos correspondientes
     */
    public static PO validate(UserInfo info, PO aPO) throws AuthException {
        // No es factible realizar validacion alguna
        if (info==null || aPO==null || aPO.getID()==0)
            return aPO;

        // Si el token de acceso solo permite una compañia en particular, no permitir gestionar/retornar informacion de otra compañía
        // Si el token de acceso es de compañía 0, entonces no limitar
        if (info.getClientID() > 0 && aPO.getAD_Client_ID() != info.getClientID()) {
            throw new AuthException("Token de acceso limitado a compañía " + info.getClientID());
        }
        return aPO;
    }
}
