package com.csbu.mvc_management.controller;

import com.csbu.mvc_management.payload.FindByDepartment;
import com.csbu.mvc_management.payload.FindByRole;
import com.csbu.mvc_management.payload.UserDto;
import com.csbu.mvc_management.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService services;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAlluser() {
        return ResponseEntity.ok(services.getAllUser());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUser(
            @PathVariable("user_id") String user_id
    ) {
        return ResponseEntity.ok(services.getUser(user_id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(
            @RequestBody UserDto userdto
    ) {
        return ResponseEntity.ok(services.updateUser(userdto));
    }

    @PostMapping("/role")
    public ResponseEntity<List<UserDto>> getuserByRole(
            @RequestBody FindByRole role
    ) {
        return ResponseEntity.ok(services.getUserByRole(role.role()));
    }

    @PostMapping("/department")
    public ResponseEntity<List<UserDto>> getUserByDepartment(
            @RequestBody FindByDepartment department
            ){
        return ResponseEntity.ok(services.getUserByDepartment(department.department()));
    }
}
