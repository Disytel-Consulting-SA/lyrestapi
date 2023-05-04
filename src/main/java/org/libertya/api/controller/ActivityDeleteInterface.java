package org.libertya.api.controller;

import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;

@FunctionalInterface
public interface ActivityDeleteInterface {

    public void perform() throws NotFoundException, ModelException;
}
