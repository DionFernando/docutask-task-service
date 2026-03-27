package com.docutask.task_service.service;

import com.docutask.task_service.entity.Task;
import com.docutask.task_service.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasksByDocumentId(String documentId) {
        return taskRepository.findByDocumentId(documentId);
    }

    public List<Task> getTasksByAssignedUserId(Long assignedUserId) {
        return taskRepository.findByAssignedUserId(assignedUserId);
    }
}