package com.csbu.mvc_management.controller;

import com.csbu.mvc_management.records.LoginRequest;
import com.csbu.mvc_management.records.ProfileRequest;
import com.csbu.mvc_management.records.RegisterRequest;
import com.csbu.mvc_management.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService services;

    @PostMapping("/register")
    public ResponseEntity<?> register (
            @RequestBody RegisterRequest request
            ) {
        return services.registerUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (
            @RequestBody LoginRequest request
            ) {
        return services.loginUser(request);
    }

    @PostMapping("/profile")
    public ResponseEntity<?> profile (
            @RequestBody ProfileRequest profile
            ) {
        return services.getUserProfile(profile.token());
    }
}
