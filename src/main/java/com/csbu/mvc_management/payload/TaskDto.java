package com.csbu.mvc_management.payload;
import java.util.Date;

public record TaskDto(
        String id,
        String taskName,
        String departmentId,
        String employeeId,
        String description,
        Date deadline,
        boolean status
) {
}