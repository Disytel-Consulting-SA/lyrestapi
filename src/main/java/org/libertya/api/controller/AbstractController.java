package org.libertya.api.controller;

import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

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

    protected <T> ResponseEntity<List<T>> retrieveAllAction(HttpServletRequest request, AbstractRepository repository, String filter, String fields, String sort, Integer limit, Integer page) {
        try {
            HttpHeaders headers = new HttpHeaders();
            appendHeaderLinks(headers, request);
            return new ResponseEntity<>(repository.retrieveAll(jwt.infoOf(request), filter, fields, sort, limit, page), headers, HttpStatus.OK);
        } catch (ModelException e) {
            List error = new ArrayList<T>();
            error.add(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        } catch (AuthException e3) {
            List error = new ArrayList<T>();
            error.add(e3.getMessage());
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
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

    protected void appendHeaderLinks(HttpHeaders headers, HttpServletRequest request) {
        try {
            List<String> prev = new ArrayList<>();
            List<String> next = new ArrayList<>();
            Map<String, String> links = generatePaginationLinks(request.getRequestURL() + "?" + request.getQueryString());
            prev.add(links.get("previous"));
            next.add(links.get("next"));
            headers.put("prev", prev);
            headers.put("next", next);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Genera los links prev y next para el header */
    public static Map<String, String> generatePaginationLinks(String url) throws URISyntaxException {
        Map<String, String> paginationLinks = new LinkedHashMap<>();
        URI uri = new URI(url);
        String query = uri.getQuery();

        int limit = -1;
        int page = -1;
        StringBuilder queryParamsBuilder = new StringBuilder();

        if (query != null) {
            String[] queryParams = query.split("&");
            for (String param : queryParams) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];
                    if (key.equalsIgnoreCase("limit")) {
                        limit = Integer.parseInt(value);
                    } else if (key.equalsIgnoreCase("page")) {
                        page = Integer.parseInt(value);
                    } else {
                        if (queryParamsBuilder.length() > 0) {
                            queryParamsBuilder.append("&");
                        }
                        queryParamsBuilder.append(key).append("=").append(value);
                    }
                }
            }
        }
        if (limit != -1 && page != -1) {
            String path = uri.getPath();
            String baseLink = uri.getScheme() + "://" + uri.getAuthority() + path;
            queryParamsBuilder.append("&limit=").append(limit);
            if (page > 1) {
                paginationLinks.put("previous", baseLink + "?" + queryParamsBuilder.toString() + "&page=" + (page - 1));
            }
            paginationLinks.put("next", baseLink + "?" + queryParamsBuilder.toString() + "&page=" + (page + 1));
        }

        return paginationLinks;
    }

}
