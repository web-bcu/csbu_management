package com.csbu.mvc_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class UserModel {
    @Id
    private String id;
    private String fullname;
    private String department;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserModel() {

    }
    public UserModel(String id, String fullname, String department, String password) {
        this.id = id;
        this.fullname = fullname;
        this.department = department;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDepartment() {return department;}

    public void setDepartment(String department) {this.department = department;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

