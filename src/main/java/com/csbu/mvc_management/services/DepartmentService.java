package com.csbu.mvc_management.services;

import com.csbu.mvc_management.entities.Department;
import com.csbu.mvc_management.mappers.DepartmentMapper;
import com.csbu.mvc_management.payload.DepartmentDto;
import com.csbu.mvc_management.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private DepartmentMapper mapper;

    public String createDepartment(DepartmentDto departmentDto) {
        Department newDepartment = mapper.toDepartment(departmentDto);
        repository.save(newDepartment);
        return "New Department created successfully!!!";
    }

    public List<DepartmentDto> getAllDepartment () {
         return repository.findAll()
                .stream()
                .map(mapper::fromDepartment)
                 .collect(Collectors.toList());
    }
}
