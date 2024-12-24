package com.csbu.mvc_management.repository;

import com.csbu.mvc_management.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
