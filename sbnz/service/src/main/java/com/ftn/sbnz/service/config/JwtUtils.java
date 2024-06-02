package com.ftn.sbnz.service.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    public String generate(String email, Long id, String role) {   
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("email", email);
        claims.put("id", id);
        claims.put("role", role);
        return Jwts.builder()
            .setIssuer("bobi")
            .setClaims(claims)
            .setSubject(email)
            .signWith(SignatureAlgorithm.HS512, "bogdanjanosevicnebojsavuga")
            .compact();
    }

    public String getJwt(String header) {
        if (header == null || !header.contains("Bearer")) {
            return null;
        }
        try {
            String jwt = header.substring(header.indexOf("Bearer ") + 7);
            if (jwt.isEmpty()) {
                return null;
            }
            return jwt;
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getEmail(String jwt) {
        return getAllClaims(jwt).getSubject();
    }

    public Long getId(String jwt) {
        Number id = (Number) getAllClaims(jwt).get("id");
        return id.longValue();
    }

    public String getRole(String jwt) {
        String role = (String) getAllClaims(jwt).get("role");
        return role;
    }

    private Claims getAllClaims(String jwt) {
        return Jwts.parser()
        .setSigningKey("bogdanjanosevicnebojsavuga")
        .parseClaimsJws(jwt)
        .getBody();
    }
}
