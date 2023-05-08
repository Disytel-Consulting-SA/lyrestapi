package org.libertya.api.controller;

import org.libertya.api.exception.ModelException;

@FunctionalInterface
public interface ActivityInsertInterface {

    public void perform() throws ModelException;
}
