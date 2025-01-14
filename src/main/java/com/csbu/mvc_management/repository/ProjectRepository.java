package com.csbu.mvc_management.repository;

import com.csbu.mvc_management.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, String> {
    public List<Projects> findByDepartmentId(String departmentId);
}