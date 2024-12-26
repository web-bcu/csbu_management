package com.csbu.mvc_management.payload;
import java.util.Date;

public record TaskDto(
        String id,
        String taskName,
        String managerId,
        String employeeId,
        Date deadline,
        boolean status
) {
}