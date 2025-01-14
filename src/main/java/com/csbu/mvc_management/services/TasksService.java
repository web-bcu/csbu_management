package com.csbu.mvc_management.services;

import com.csbu.mvc_management.entities.TaskModel;
import com.csbu.mvc_management.mappers.TaskMapper;
import com.csbu.mvc_management.payload.TaskDto;
import com.csbu.mvc_management.repository.TaskRepository;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService {
    @Autowired
    private TaskRepository repository;
    @Autowired
    private TaskMapper mapper;


    public List<TaskDto> getTasksByEmployeeId(String employeeId) {
        try {
            return repository.findByEmployeeId(employeeId)
                    .stream()
                    .map(mapper::fromTask)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new TransactionException("Error getting status", e);
        }
    }

    public String createTask(TaskDto taskDto){
        try{
            TaskModel task = mapper.toTask(taskDto);
            repository.save(task);
            return "Create task successfully!!!";
        }catch (Exception e){
            throw new TransactionException("Error creating status",e);
        }
    }

    public String updateTaskStatus(String id){
        try{
            repository.updateStatusById(id);
            return "Update task successfully";
        }catch (Exception e){
            throw new TransactionException("Error updating status",e);
        }
    }

    public String deleteTaskById(String id){
        try{
            repository.deleteById(id);
            return "Delete task successfully!!!";
        }catch (Exception e){
            throw new TransactionException("Error deleting status",e);
        }
    }

    public List<TaskDto> getByDepartmentId(String departmentId) {
        return repository.findByDepartmentId(departmentId)
                .stream()
                .map(mapper::fromTask)
                .collect(Collectors.toList());
    }
}
