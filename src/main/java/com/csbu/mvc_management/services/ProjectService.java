package com.csbu.mvc_management.services;

import com.csbu.mvc_management.entities.Projects;
import com.csbu.mvc_management.entities.TaskModel;
import com.csbu.mvc_management.entities.UserModel;
import com.csbu.mvc_management.mappers.ProjectMapper;
import com.csbu.mvc_management.payload.ProjectDto;
import com.csbu.mvc_management.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectService {
    @Autowired
    private ProjectRepository repository;
    @Autowired
    private ProjectMapper mapper;

    public String createProject(ProjectDto projectDto) {
        Projects project = mapper.toProject(projectDto);
        repository.save(project);
        return "New project created!!!";
    }

    public List<ProjectDto> getAllProject() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Projects::getStartDate))
                .map(mapper::fromProject)
                .collect(Collectors.toList());
    }

    public String updateProject(ProjectDto projectDto) {
        Optional<Projects> projectOptional = repository.findById(projectDto.projectId());

        if (!projectOptional.isPresent()) {
            return null;
        }

        Projects project = projectOptional.get();

        if (projectDto.projectName() != null) {
            project.setProjectName(projectDto.projectName());
        }
        if (projectDto.startDate() != null) {
            project.setStartDate(projectDto.startDate());
        }
        if (projectDto.endDate() != null) {
            project.setEndDate(projectDto.endDate());
        }
        if (projectDto.departmentId() != null) {
            project.setDepartmentId(projectDto.departmentId());
        }
        if (projectDto.description() != null) {
            project.setDescription(projectDto.description());
        }
        if (projectDto.createdAt() != null) {
            project.setCreatedAt(projectDto.createdAt());
        }

        repository.save(project);
        return "Update project Successfully";
    }

    public List<ProjectDto> getProjectByDepartment(String departmentId) {
        return repository.findByDepartmentId(departmentId)
                .stream()
                .sorted(Comparator.comparing(Projects::getStartDate))
                .map(mapper::fromProject)
                .collect(Collectors.toList());
    }
}
