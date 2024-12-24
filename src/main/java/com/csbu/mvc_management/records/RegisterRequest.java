package com.csbu.mvc_management.records;

public record RegisterRequest(
        String id,
        String fullname,
        String department,
        String password,
        String role
) {
}
