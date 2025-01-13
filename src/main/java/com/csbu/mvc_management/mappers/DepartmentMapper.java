package com.csbu.mvc_management.mappers;

import com.csbu.mvc_management.entities.Department;
import com.csbu.mvc_management.payload.DepartmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentMapper {
    public Department toDepartment(DepartmentDto request) {
        return new Department(
                request.departmentId(),
                request.departmentName()
        );
    }

    public DepartmentDto fromDepartment(Department department) {
        return new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName()
        );
    }
}
