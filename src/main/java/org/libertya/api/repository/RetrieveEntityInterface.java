package org.libertya.api.repository;

@FunctionalInterface
public interface RetrieveEntityInterface {

    Object perform(int id);
}
