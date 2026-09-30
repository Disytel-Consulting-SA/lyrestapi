package org.libertya.api.exception;

public class NotFoundException extends Exception {

    public NotFoundException() {
        super();
    }

    /**
     * @param message descripcion de lo que no se encontro (p. ej. la tabla del endpoint generico)
     */
    public NotFoundException(String message) {
        super(message);
    }
}
