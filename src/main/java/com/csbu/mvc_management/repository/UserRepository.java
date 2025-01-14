package com.csbu.mvc_management.repository;

import com.csbu.mvc_management.entities.Role;
import com.csbu.mvc_management.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    // Using Method Name Query Derivation
    List<UserModel> findByRole(Role role);
    List<UserModel> findByDepartment(String department);
}
