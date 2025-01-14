package com.csbu.mvc_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "Tasks")
public class TaskModel {
    @Id
    private String id;

    @Column(name="task_name", nullable = false)
    private String taskName;


    //    private Employee manager;
    @Column(name="department_id", nullable = false)
    private String departmentId;

    //    private Employee employee;
    @Column(name="employee_id", nullable = false)
    private String employeeId;

    @Column(name="description")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "deadline" ,nullable = false)
    private Date deadline;

    @Column(name = "status", nullable = false)
    private boolean status;

    public TaskModel() {

    }

    public TaskModel(
            String id, String taskName, String departmentId, String employeeId, String description, Date deadline, boolean status
    ) {
        this.id = id;
        this.taskName = taskName;
        this.departmentId = departmentId;
        this.employeeId = employeeId;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String managerId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
