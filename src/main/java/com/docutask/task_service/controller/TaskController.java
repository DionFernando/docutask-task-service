package com.docutask.task_service.controller;

import com.docutask.task_service.entity.Task;
import com.docutask.task_service.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/document/{documentId}")
    public List<Task> getTasksByDocumentId(@PathVariable String documentId) {
        return taskService.getTasksByDocumentId(documentId);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByAssignedUserId(@PathVariable Long userId) {
        return taskService.getTasksByAssignedUserId(userId);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}