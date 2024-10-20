//package com.rigin.conrtoller.web;
//
//import com.rigin.model.entity.Status;
//import com.rigin.model.entity.Task;
//import com.rigin.service.TaskService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/ui/tasks")
//public class TaskUiController {
//
//    private final TaskService taskService;
//
//    @GetMapping("/")
//    public ModelAndView getTasks(ModelAndView modelAndView,
//                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page,
//                                 @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
//        int offset = (page - 1) * limit;
//        List<Task> tasks = taskService.getTasksWithLimitAndOffset(offset, limit);
//
//        modelAndView.setViewName("task");
//        modelAndView.addObject("task", tasks);
//        modelAndView.addObject("currentPage", page);
//        modelAndView.addObject("limit", limit);
//        return modelAndView;
//    }
//
//    @GetMapping("/{id}")
//    public ModelAndView getTask(ModelAndView modelAndView,
//                                @PathVariable("id") long id) {
//        Optional<Task> task = taskService.getTask(id);
//
//        if (task.isPresent()) {
//            modelAndView.setViewName("task-detail");
//            modelAndView.addObject("task", task.get());
//        } else {
//            modelAndView.setViewName("task-not-found");
//        }
//        return modelAndView;
//    }
//
//    @DeleteMapping("/{id}")
//    public ModelAndView deleteTask(ModelAndView modelAndView,
//                                   @PathVariable("id") long id) {
//        taskService.deleteTask(id);
//        return getTasks(modelAndView, 1, 10);  // Redirect to first page after deletion
//    }
//
//    @GetMapping("/create")
//    public ModelAndView showCreateTaskForm(ModelAndView modelAndView) {
//        modelAndView.setViewName("create-task");
//        return modelAndView;
//    }
//
//    // Handle task creation
//    @PostMapping("/")
//    public ModelAndView createTask(@RequestParam("description") String description,
//                                   @RequestParam("status") Status status,
//                                   ModelAndView modelAndView) {
//        Task newTask = new Task();
//        newTask.setStatus(status);
//        newTask.setDescription(description);
//        taskService.createTask(newTask);
//        return getTasks(modelAndView, 1, 10);  // Redirect to first page after creation
//    }
//
//    @PutMapping("/")
//    public ModelAndView updateTask(
//            @PathVariable("id") long id,
//            @RequestParam("description") String description,
//            @RequestParam("status") Status status,
//            ModelAndView modelAndView) {
//        Task updateTask = new Task();
//        updateTask.setId(id);
//        updateTask.setDescription(description);
//        updateTask.setStatus(status);
//        taskService.createTask(updateTask);
//        return modelAndView;
//    }
//}
//
