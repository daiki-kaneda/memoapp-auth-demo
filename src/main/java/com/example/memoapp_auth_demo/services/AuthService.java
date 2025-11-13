package com.example.memoapp_auth_demo.services;

import org.springframework.stereotype.Service;

import com.example.memoapp_auth_demo.drivers.FirebaseAuthDriver;
import com.example.memoapp_auth_demo.models.User;
import com.example.memoapp_auth_demo.repositories.UserRepository;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loadOrCreateUser(String idToken) throws FirebaseAuthException {
        FirebaseToken token = FirebaseAuthDriver.verifyToken(idToken);
        return userRepository.findById(token.getUid())
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setUid(token.getUid());
                    newUser.setName(token.getName());
                    newUser.setEmail(token.getEmail());
                    userRepository.save(newUser);

                    return newUser;
                });

    }
}
