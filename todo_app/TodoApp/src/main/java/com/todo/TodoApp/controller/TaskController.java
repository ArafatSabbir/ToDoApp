package com.todo.TodoApp.controller;

import com.todo.TodoApp.dto.TaskDto;
import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    public ResponseEntity<String> addTask(@RequestBody TaskDto taskDto) {
        taskService.addTask(taskDto.getId(), taskDto.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body("Task added successfully");
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/complete/{id}")
    public ResponseEntity<String> completeTask(@PathVariable Long id) {
        taskService.completeTask(id);
        return ResponseEntity.ok("Task completed successfully");
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/undo")
    public ResponseEntity<String> undo() {
        taskService.undo();
        return ResponseEntity.ok("Undo successful");
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/redo")
    public ResponseEntity<String> redo() {
        taskService.redo();
        return ResponseEntity.ok("Redo successful");
    }
}
