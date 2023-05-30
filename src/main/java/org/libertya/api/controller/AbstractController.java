package org.libertya.api.controller;

import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.AbstractRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController {

    protected <T> ResponseEntity<T> retrieveAction(ActivityRetrieveInterface<T> iface) {
        try {
            return iface.perform()
                    .map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    protected <T> ResponseEntity<List<T>> retrieveAllAction(AbstractRepository repository, String filter, String fields, String sort, Integer limit, Integer offset) {
        try {
            return new ResponseEntity<>(repository.retrieveAll(filter, fields, sort, limit, offset), HttpStatus.OK);
        } catch (ModelException e) {
            List error = new ArrayList<T>();
            error.add(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
        }
    }

    protected ResponseEntity<String> deleteAction(ActivityDeleteInterface iface) {
        try {
            iface.perform();
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        }
    }

    protected ResponseEntity<String> updateAction(ActivityUpdateInterface iface) {
        try {
            iface.perform();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        }
    }

    protected ResponseEntity<String> insertAction(ActivityInsertInterface iface) {
        try {
            return new ResponseEntity<>(iface.perform(), HttpStatus.OK);
        } catch (ModelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    protected ResponseEntity<String> processAction(ActivityProcessInterface iface) {
        try {
            return new ResponseEntity<>(iface.perform(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        }
    }


}
