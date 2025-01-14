package com.csbu.mvc_management.mappers;

import com.csbu.mvc_management.entities.TaskModel;
import com.csbu.mvc_management.payload.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskMapper{
    public TaskModel toTask(TaskDto taskDto) {
        return new TaskModel(
                taskDto.id(),
                taskDto.taskName(),
                taskDto.departmentId(),
                taskDto.employeeId(),
                taskDto.description(),
                taskDto.deadline(),
                taskDto.status()
        );
    }

    public TaskDto fromTask(TaskModel taskModel) {
        return new TaskDto(
                taskModel.getId(),
                taskModel.getTaskName(),
                taskModel.getDepartmentId(),
                taskModel.getEmployeeId(),
                taskModel.getDescription(),
                taskModel.getDeadline(),
                taskModel.getStatus()
        );
    }
}
