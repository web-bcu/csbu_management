package com.csbu.mvc_management.repository;

import com.csbu.mvc_management.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
