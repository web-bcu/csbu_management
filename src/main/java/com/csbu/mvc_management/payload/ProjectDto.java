package com.csbu.mvc_management.payload;

import java.time.LocalDate;

public record ProjectDto(
        String projectId,
        String projectName,
        LocalDate startDate,
        LocalDate endDate,
        String departmentId,
        String description,
        LocalDate createdAt
) {
}
