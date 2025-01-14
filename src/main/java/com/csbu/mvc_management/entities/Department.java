package com.csbu.mvc_management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Departments")
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Department {
    @Id
    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "name")
    private String departmentName;

    public Department() {

    }
    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {return departmentId;}

    public void setDepartmentId(String departmentId) {this.departmentId = departmentId;}

    public String getDepartmentName() {return departmentName;}

    public void setDepartmentName(String departmentName) {this.departmentName = departmentName;}
}
