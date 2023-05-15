package org.libertya.api.controller;

import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractController {

    public <T> ResponseEntity<T> retrieveAction(ActivityRetrieveInterface<T> iface, Class<T> clazz) {
        return (ResponseEntity<T>) iface.perform()
                .map(simpleMap -> new ResponseEntity<>(simpleMap, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(null, HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> deleteAction(ActivityDeleteInterface iface) {
        try {
            iface.perform();
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> updateAction(ActivityUpdateInterface iface) {
        try {
            iface.perform();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> insertAction(ActivityInsertInterface iface) {
        try {
            return new ResponseEntity<>(iface.perform(), HttpStatus.OK);
        } catch (ModelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> processAction(ActivityProcessInterface iface) {
        try {
            return new ResponseEntity<>(iface.perform(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        }
    }


}
