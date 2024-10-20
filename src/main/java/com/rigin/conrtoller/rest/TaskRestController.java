package com.rigin.conrtoller.rest;

import com.rigin.model.entity.Status;
import com.rigin.model.entity.Task;
import com.rigin.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TaskRestController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> tasks(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {

        List<Task> list = taskService.getTasksWithLimitAndOffset(limit, page);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> task
            (@PathVariable("id") long id) {
        Optional<Task> task = taskService.getTask(id);
        return task.isPresent()
                ? ResponseEntity.ok(task)
                : ResponseEntity.notFound().build();

    }

    @PostMapping("/task/create")
    public ResponseEntity<Task> editTask(@RequestParam(value = "description", required = false, defaultValue = "BLA-BLA") String description,
                                         @RequestParam(value = "status", required = false, defaultValue = "DONE") Status status) {
        Task task = taskService.createTask(description, status);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("delete task with id  "+id);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Task> editTask(
            @PathVariable("id") long id,
            @RequestParam("description") String description,
            @RequestParam("status") Status status) {
        Optional<Task> optionalTask = taskService.getTask(id);
        Long findId = optionalTask.get().getId();
        var task = taskService.updateTask(findId, description,status);
        return ResponseEntity.ok(task.get());
    }



}
