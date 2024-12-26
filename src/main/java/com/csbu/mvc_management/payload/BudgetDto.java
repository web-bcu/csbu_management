package com.csbu.mvc_management.payload;

import java.time.LocalDate;

public record BudgetDto(
        String id,
        String description,
        LocalDate periodStart,
        LocalDate periodEnd,
        Integer approvedAmount,
        Integer remainingAmount,
        String currency,
        LocalDate createdAt
) {

}