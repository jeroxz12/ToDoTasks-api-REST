package com.codefactory.todoapp.controller;

import com.codefactory.todoapp.persistence.entity.Task;
import com.codefactory.todoapp.persistence.entity.TaskStatus;
import com.codefactory.todoapp.service.TaskService;
import com.codefactory.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

// Siempre el path controlador debe ser en plural segun la entidad que voy a gestion
// En este caso Tasks
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping(path = "/all")
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping(path = "/status/{status}")
    public List<Task> findAllByStatus(@PathVariable TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping(path = "/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
         this.taskService.markTaskAsFinished(id);
         return ResponseEntity.noContent().build();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
