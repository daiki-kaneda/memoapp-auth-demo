package com.example.memoapp_auth_demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.memoapp_auth_demo.controllers.dtos.AuthLoginRequest;
import com.example.memoapp_auth_demo.controllers.dtos.AuthLoginResponse;
import com.example.memoapp_auth_demo.models.User;
import com.example.memoapp_auth_demo.services.AuthService;
import com.google.firebase.auth.FirebaseAuthException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest request) throws FirebaseAuthException {
        User user = authService.loadOrCreateUser(request.idToken());
        return ResponseEntity.ok(new AuthLoginResponse(user.getUid(), "Login Success!"));
    }
}