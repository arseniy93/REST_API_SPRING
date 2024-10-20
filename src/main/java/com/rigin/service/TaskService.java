package com.rigin.service;


import com.rigin.model.entity.Status;
import com.rigin.model.entity.Task;
import com.rigin.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    @Transactional
    public Task createTask(String description, Status status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskRepository.save(task);
        return task;
    }

    @Transactional
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Transactional
    public Optional<Task> updateTask(Long id, Status status) {
        var task = taskRepository.findById(id);
        task.get().setStatus(status);
        taskRepository.save(task.get());
        return task;
    }

    @Transactional
    public Optional<Task> updateTask(Long id, String description) {
        var task = taskRepository.findById(id);
        task.get().setDescription(description);
        taskRepository.save(task.get());
        return task;
    }

    @Transactional
    public Optional<Task> updateTask(Long id, String description,Status status) {
        var task = taskRepository.findById(id);
        task.get().setDescription(description);
        task.get().setStatus(status);
        taskRepository.save(task.get());
        return task;
    }

    public Optional<Task> getTask(long id) {
        return taskRepository.findById(id);
    }


    public List<Task> getTasksWithLimitAndOffset(int limit, int offset) {
        return taskRepository.getAllWithLimitAndOffset(limit, offset);
    }


    public long getAllCount() {
        return taskRepository.count();
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> allTasks() {
        return taskRepository.findAll();
    }
}
