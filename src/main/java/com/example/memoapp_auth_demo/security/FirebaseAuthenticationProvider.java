package com.example.memoapp_auth_demo.security;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.google.firebase.auth.FirebaseToken;

@Component
public class FirebaseAuthenticationProvider {
    public Authentication createAuthentication(FirebaseToken token) {
        String uid = token.getUid();
        String role = (String) token.getClaims().getOrDefault("role", "USER");

        return new UsernamePasswordAuthenticationToken(
                uid,
                null,
                List.of(new SimpleGrantedAuthority("ROLE_" + role)));
    }
}
