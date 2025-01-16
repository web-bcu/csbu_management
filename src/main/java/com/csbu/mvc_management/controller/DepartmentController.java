package com.csbu.mvc_management.controller;

import com.csbu.mvc_management.payload.DepartmentDto;
import com.csbu.mvc_management.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService services;

    @PostMapping
    public ResponseEntity<String> createDepartment (
            @RequestBody DepartmentDto departmentDto
    ) {
        return ResponseEntity.ok(services.createDepartment(departmentDto));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        return ResponseEntity.ok(services.getAllDepartment());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDepartment(
            @RequestBody DepartmentDto departmentDto
    ) {
        return ResponseEntity.ok(services.updateDepartment(departmentDto));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(
            @PathVariable(name = "departmentId") String departmentId
    ) {
        return ResponseEntity.ok(services.deleteDepartment(departmentId));
    }
}
