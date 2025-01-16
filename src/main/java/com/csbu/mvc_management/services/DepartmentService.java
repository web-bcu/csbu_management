package com.csbu.mvc_management.services;

import com.csbu.mvc_management.entities.Department;
import com.csbu.mvc_management.entities.UserModel;
import com.csbu.mvc_management.mappers.DepartmentMapper;
import com.csbu.mvc_management.payload.DepartmentDto;
import com.csbu.mvc_management.payload.UserDto;
import com.csbu.mvc_management.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public String updateDepartment(DepartmentDto departmentdto) {
        Optional<Department> departmentOptional = repository.findById(departmentdto.departmentId());

        if (!departmentOptional.isPresent()) {
            return null;
        }

        Department department = departmentOptional.get();

        if (departmentdto.departmentName() != null) {
            department.setDepartmentName(departmentdto.departmentName());
        }
        repository.save(department);

        return "Updated Successfully";
    }

    public String deleteDepartment(String departmentId) {
        repository.deleteById(departmentId);
        return "Deleted Successfully";
    }
}
