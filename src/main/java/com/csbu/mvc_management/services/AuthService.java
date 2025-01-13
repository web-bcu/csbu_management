package com.csbu.mvc_management.services;

import com.csbu.mvc_management.entities.Role;
import com.csbu.mvc_management.entities.UserModel;
import com.csbu.mvc_management.mappers.UserMapper;
import com.csbu.mvc_management.payload.AuthenticationResponse;
import com.csbu.mvc_management.payload.MessageResponse;
import com.csbu.mvc_management.records.LoginRequest;
import com.csbu.mvc_management.records.RegisterRequest;
import com.csbu.mvc_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtService jwtService;

    public ResponseEntity<?> registerUser(RegisterRequest request) {
        if (repository.existsById(request.id())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("User already exists"));
        }

        UserModel user = mapper.toUser(request);

        user.setPassword(encoder.encode(request.password()));

        String strRole = request.role();

        switch(strRole) {
            case "user":
                Role userRole = Role.USER;
                user.setRole(userRole);
                break;
            case "manager":
                Role managerRole = Role.MANAGER;
                user.setRole(managerRole);
                break;
            case "admin":
                Role adminRole = Role.ADMIN;
                user.setRole(adminRole);
                break;
        }

        repository.save(user);

        return ResponseEntity.ok(new MessageResponse("Registered Successfully"));
    }

    public ResponseEntity<?> loginUser(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.id(), request.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new AuthenticationResponse(jwt,
                userDetails.getUsername(),
                userDetails.getFullname(),
                roles));
    }

    public ResponseEntity<?> getUserProfile(String token) {
        return ResponseEntity.ok(jwtService.getUserNameFromJwtToken(token));
    }
}
