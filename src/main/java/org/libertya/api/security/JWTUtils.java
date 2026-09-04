package org.libertya.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component @RequiredArgsConstructor
public class JWTUtils {

    @Value("${security.token.secret}")
    private String secretKey;

    @Value("${security.token.exp.days}")
    private Long expDays;

    @Value("${security.access.validate.user}")
    private String validateUser;

    @Autowired
    UserRepository repository;

    /** Generacion de un nuevo token para el username indicado */
    public String buildToken(HashMap<String, String> credentials) {
        return buildToken(credentials, null);
    }

    /** Generacion de un nuevo token para el username indicado, forzando expiration */
    public String buildToken(HashMap<String, String> credentials, Date expiration) {

        String userName = credentials.get("username");
        Integer userID = Integer.parseInt(credentials.get("userid"));
        Integer clientID = Integer.parseInt(credentials.get("clientid"));
        Integer orgID = Integer.parseInt(credentials.get("orgid"));
        String roleID = credentials.get("roleid");

        List<GrantedAuthority> grantedAuthorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        JwtBuilder builder = Jwts
                .builder()
                .setId("JWTBuilder")
                .setSubject(userName)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .claim("userName", userName)
                .claim("userID", userID)
                .claim("clientID", clientID)
                .claim("orgID", orgID);

        if (roleID != null && !roleID.trim().isEmpty()) {
            builder.claim("roleID", Integer.parseInt(roleID));
        }

        Date effectiveExpiration = expiration != null
                ? expiration
                : new Date(System.currentTimeMillis() + getExpirationMillis(credentials));

        String token = builder
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(effectiveExpiration)
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();

        return "Bearer " + token;
    }

    /** Validacion de token */
    public Claims validateToken(String jwtToken) {
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(jwtToken).getBody();
    }

    /** Vuelca en una instancia de UserInfo la informacion asociada al request */
    public UserInfo infoOf(HttpServletRequest request) throws AuthException  {
        try {
            String token = request.getHeader("Authorization").replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
            String userName = claims.get("userName").toString();
            String userID = claims.get("userID").toString();
            String clientID = claims.get("clientID").toString();
            String orgID = claims.get("orgID").toString();
            Object roleClaim = claims.get("roleID");
            Integer roleID = roleClaim != null ? Integer.parseInt(roleClaim.toString()) : null;
            if ("Y".equalsIgnoreCase(validateUser) && !repository.findActiveUser(userName, clientID, orgID).isPresent()) {
                throw new AuthException(String.format("Usuario:%s-Inexistente/Inactivo",userName));
            }
            return UserInfo.of(userName, Integer.parseInt(userID), Integer.parseInt(clientID), Integer.parseInt(orgID), roleID);
        } catch (Exception e) {
            throw new AuthException("Error Autenticacion JWT.: " + e.getMessage());
        }
    }


    private long getExpirationMillis(HashMap<String, String> credentials) {

        // Duración máxima/default configurada actualmente en application.properties.
        long defaultMillis = expDays * 24L * 60L * 60L * 1000L;
        String expirationMinutes = credentials.get("expirationminutes");
        //  Si el request no pide una duración específica, conservar comportamiento histórico.
        if (expirationMinutes == null || expirationMinutes.trim().isEmpty()) {
            return defaultMillis;
        }
        try {
            long minutes = Long.parseLong(expirationMinutes);
            if (minutes <= 0) {
                return defaultMillis;
            }
            long requestedMillis = minutes * 60L * 1000L;
            // Nunca permitir que el request extienda la duración máxima definida por servidor.
            return Math.min(requestedMillis, defaultMillis);
        } catch (NumberFormatException e) {
            // Valor inválido: comportamiento histórico.
            return defaultMillis;
        }
    }
}
