package com.arrow.sharemarketbackend.helper;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {

    private JwtHelper() {}

    public String userEmail(Jwt jwt) {
        return (String) jwt.getClaims().get("email");
    }

    public String name(Jwt jwt) {
        return (String) jwt.getClaims().get("name");
    }
}
