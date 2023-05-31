package org.libertya.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        Integer code    =  request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) != null ? (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) : 400;
        String message  = request.getAttribute(RequestDispatcher.ERROR_MESSAGE) != null ? (String)request.getAttribute(RequestDispatcher.ERROR_MESSAGE) : "Solicitud incorrecta";
        return new ResponseEntity<>(message, HttpStatus.valueOf(code));
    }
}
