package com.example.memoapp_auth_demo.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.memoapp_auth_demo.models.User;

@Service
public class UserService {
    /*
     * Returns a User which only have uid, values of other fields are null.
     */
    public User getCurrentUser(Authentication auth) {
        User user = new User();
        user.setUid((String) auth.getPrincipal());
        return user;
    }
}
