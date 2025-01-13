package com.csbu.mvc_management.payload;

import com.csbu.mvc_management.entities.Role;

public record UserDto(
        String id,
        String fullname,
        String department,
        Role role
){
}
