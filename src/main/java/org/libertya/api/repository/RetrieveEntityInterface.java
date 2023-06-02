package org.libertya.api.repository;

import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;

@FunctionalInterface
public interface RetrieveEntityInterface {

    /** Recuperacion de una entidad. La misma podría identificarse por más de una columna (ejemplo C_InvoiceTax), con lo cual se recibe un array de enteros */
    Object perform(int[] id) throws ModelException, AuthException;
}
