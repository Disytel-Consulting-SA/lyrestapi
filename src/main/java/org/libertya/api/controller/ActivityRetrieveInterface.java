package org.libertya.api.controller;

import org.libertya.api.exception.NotFoundException;

import java.util.Optional;

@FunctionalInterface
public interface ActivityRetrieveInterface<T> {

    public Optional<T> perform();
}
