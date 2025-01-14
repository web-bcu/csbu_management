package com.csbu.mvc_management.mappers;

import com.csbu.mvc_management.entities.Projects;
import com.csbu.mvc_management.payload.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMapper {
    public Projects toProject(ProjectDto projectDto) {
        return new Projects(
                projectDto.projectId(),
                projectDto.projectName(),
                projectDto.startDate(),
                projectDto.endDate(),
                projectDto.departmentId(),
                projectDto.description(),
                projectDto.createdAt()
        );
    }

    public ProjectDto fromProject(Projects project) {
        return new ProjectDto(
                project.getProjectId(),
                project.getProjectName(),
                project.getStartDate(),
                project.getEndDate(),
                project.getDepartmentId(),
                project.getDescription(),
                project.getCreatedAt()
        );
    }
}
