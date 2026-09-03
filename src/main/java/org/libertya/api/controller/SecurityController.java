package org.libertya.api.controller;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.RoleOptionsRepository;
import org.libertya.api.repository.UserRepository;
import org.libertya.api.security.JWTUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final JWTUtils jwtUtils;
    private final UserRepository userRepository;
    private final RoleOptionsRepository roleOptionsRepository;
    private final HttpServletRequest request;

    @PostMapping("/token")
    public ResponseEntity<String> keygen(Model model, @RequestHeader HashMap<String, String> credentials) {
        if (userRepository.findUser(
                credentials.get("username"),
                credentials.get("password"),
                credentials.get("clientid"),
                credentials.get("orgid")
        ).isPresent()) {
            return new ResponseEntity<>(jwtUtils.buildToken(credentials), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/token/context")
    public ResponseEntity<String> contextToken(@RequestHeader("roleid") Integer roleID) {
        try {
            UserInfo info = jwtUtils.infoOf(request);

            if (!roleOptionsRepository.hasRole(info.getUserName(), roleID)) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            String currentToken = request.getHeader("Authorization").replace("Bearer ", "");
            Date expiration = jwtUtils.validateToken(currentToken).getExpiration();

            HashMap<String, String> credentials = new HashMap<>();
            credentials.put("username", info.getUserName());
            credentials.put("clientid", String.valueOf(info.getClientID()));
            credentials.put("orgid", String.valueOf(info.getOrgID()));
            credentials.put("roleid", String.valueOf(roleID));

            return new ResponseEntity<>(jwtUtils.buildToken(credentials, expiration), HttpStatus.OK);

        } catch (AuthException e) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
}