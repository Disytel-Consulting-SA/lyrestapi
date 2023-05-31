package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.repository.UserRepository;
import org.libertya.api.security.JWTUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;

@Controller @RequiredArgsConstructor
public class SecurityController {

    private final JWTUtils jwtUtils;

    private final UserRepository userRepository;

    @PostMapping("/token")
    public ResponseEntity<String> keygen(Model model, @RequestHeader HashMap<String, String> credentials) {
        if (userRepository.findUser(
                credentials.get("username"),
                credentials.get("password"),
                credentials.get("clientid"),
                credentials.get("orgid")
                ).isPresent())
            return new ResponseEntity(jwtUtils.buildToken(credentials), HttpStatus.OK);
        return new ResponseEntity(null, HttpStatus.FORBIDDEN);
    }
}
