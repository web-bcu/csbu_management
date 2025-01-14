package com.csbu.mvc_management.controller;

import com.csbu.mvc_management.payload.ProjectByDepartment;
import com.csbu.mvc_management.payload.ProjectDto;
import com.csbu.mvc_management.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private ProjectService services;

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(services.createProject(projectDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(services.getAllProject());
    }

    @PutMapping
    public ResponseEntity<String> updateProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(services.updateProject(projectDto));
    }

    @PostMapping("/department")
    public ResponseEntity<List<ProjectDto>> getProjectByDepartmentId(@RequestBody ProjectByDepartment projectByDepartment) {
        return ResponseEntity.ok(services.getProjectByDepartment(projectByDepartment.departmentId()));
    }
}
