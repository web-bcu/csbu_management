package com.csbu.mvc_management.controller;

import com.csbu.mvc_management.entities.TaskModel;
import com.csbu.mvc_management.payload.PageResponse;
import com.csbu.mvc_management.payload.TaskDto;
import com.csbu.mvc_management.records.AddTaskRequest;
//import com.csbu.mvc_management.services.TaskService;
import com.csbu.mvc_management.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    @Autowired
    private TasksService services;


    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody @Valid TaskDto taskDto)
    {
        return ResponseEntity.ok(services.createTask(taskDto));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatusById(@PathVariable(name = "id") String id){
//        taskService.updateTaskStatus(id);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body("Task's status has been updated");
        return ResponseEntity.ok(services.updateTaskStatus(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable(name="id") String id){
//        taskService.deleteTaskById(id);
//        return  ResponseEntity.status(HttpStatus.OK).body("Task has been deleted!");
        return ResponseEntity.ok(services.deleteTaskById(id));
    }

//    @GetMapping("/{employee_id}")
//    public ResponseEntity<PageResponse<TaskDto>> getTaskByEmployeeId(
//            @PathVariable(name="employee_id") String employee_id,
//            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
//            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
//    ){
//        Page<TaskDto> task=taskService.getTasksByEmployeeId(employee_id, page, size);
//        PageResponse<TaskDto> pageResponse = new PageResponse<>(
//                task.getNumber() + 1,
//                task.getTotalPages(),
//                task.getSize(),
//                (int) task.getTotalElements(),
//                task.getContent()
//        );
//        return ResponseEntity.ok(pageResponse);
//    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<List<TaskDto>> getTaskByEmployeeId(
            @PathVariable(name="employee_id") String employee_id
    ){
        return ResponseEntity.ok(services.getTasksByEmployeeId(employee_id));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<TaskDto>> getTaskByDepartment(
            @PathVariable(name="departmentId") String departmentId
    ) {
        return ResponseEntity.ok(services.getByDepartmentId(departmentId));
    }
}
