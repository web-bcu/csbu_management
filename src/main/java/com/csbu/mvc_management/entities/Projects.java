package com.csbu.mvc_management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Projects {
    @Id
    @Column(name = "id")
    private String projectId;
    @Column(name = "name")
    private String projectName;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "department")
    private String departmentId;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private LocalDate createdAt;

    public Projects() {}

    public Projects(String projectId, String projectName, LocalDate startDate, LocalDate endDate, String departmentId, String description, LocalDate createdAt) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departmentId = departmentId;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getProjectId() {return projectId;}

    public void setProjectId(String projectId) {this.projectId = projectId;}

    public String getProjectName() {return projectName;}

    public void setProjectName(String projectName) {this.projectName = projectName;}

    public LocalDate getStartDate() {return startDate;}

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDepartmentId() {return departmentId;}

    public void setDepartmentId(String departmentId) {this.departmentId = departmentId;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public LocalDate getCreatedAt() {return createdAt;}

    public void setCreatedAt(LocalDate createdAt) {this.createdAt = createdAt;}
}
