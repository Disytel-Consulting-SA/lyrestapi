package org.libertya.api.controller;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public abstract class AbstractController {

    @Autowired
    private JWTUtils jwt;

    protected <T> ResponseEntity<T> retrieveAction(HttpServletRequest request, ActivityRetrieveInterface<T> iface) {
        try {
            return iface.perform(jwt.infoOf(request))
                    .map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (AuthException e3) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    protected <T> ResponseEntity<List<T>> retrieveAllAction(HttpServletRequest request, AbstractRepository repository, String filter, String fields, String sort, Integer limit, Integer offset) {
        try {
            return new ResponseEntity<>(repository.retrieveAll(jwt.infoOf(request), filter, fields, sort, limit, offset), HttpStatus.OK);
        } catch (ModelException e) {
            List error = new ArrayList<T>();
            error.add(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
        } catch (AuthException e3) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    protected ResponseEntity<String> deleteAction(HttpServletRequest request, ActivityDeleteInterface iface) {
        try {
            iface.perform(jwt.infoOf(request));
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        } catch (AuthException e3) {
            return new ResponseEntity<>(e3.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    protected ResponseEntity<String> updateAction(HttpServletRequest request, ActivityUpdateInterface iface) {
        try {
            iface.perform(jwt.infoOf(request));
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        } catch (AuthException e3) {
            return new ResponseEntity<>(e3.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    protected ResponseEntity<String> insertAction(HttpServletRequest request, ActivityInsertInterface iface) {
        try {
            return new ResponseEntity<>(iface.perform(jwt.infoOf(request)), HttpStatus.OK);
        } catch (ModelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (AuthException e3) {
            return new ResponseEntity<>(e3.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    protected ResponseEntity<String> processAction(HttpServletRequest request, ActivityProcessInterface iface) {
        try {
            return new ResponseEntity<>(iface.perform(jwt.infoOf(request)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ModelException e2) {
            return new ResponseEntity<>(e2.getMessage(), HttpStatus.CONFLICT);
        } catch (AuthException e3) {
            return new ResponseEntity<>(e3.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }


}
