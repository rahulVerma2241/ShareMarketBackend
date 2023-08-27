package com.arrow.sharemarketbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class SecurityController {

    @GetMapping("jwt")
    public ResponseEntity getJwtToken(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok(Collections.singletonMap("Principal" , jwt));
    }
}
