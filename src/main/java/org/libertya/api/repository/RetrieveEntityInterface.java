package org.libertya.api.repository;

import org.libertya.api.exception.ModelException;

@FunctionalInterface
public interface RetrieveEntityInterface {

    Object perform(int id) throws ModelException;
}
