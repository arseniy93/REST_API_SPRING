package com.rigin;

import com.rigin.config.AppConfig;
import com.rigin.config.DatabaseConfig;
import com.rigin.model.entity.Status;
import com.rigin.model.entity.Task;
import com.rigin.repository.TaskRepository;
//import com.rigin.service.TaskService;
import com.rigin.service.TaskService;
//import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//@WebAppConfiguration

//public class Main {
//    public static void main(String[] args) throws Exception {
//        System.out.println("ASd");
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DatabaseConfig.class);
//        TaskService personJPARepository = context.getBean(TaskService.class);
//        System.out.println(personJPARepository.updateTask(9L, Status.IN_PROGRESS));
//        System.out.println(personJPARepository.updateTask(9L, "LOlyant"));
//        System.out.println(personJPARepository.getAllCount());
       // System.out.println(personJPARepository.getTasksWithLimitAndOffset(10,1));
//        Task task=new Task();
//        task.setStatus(Status.DONE);
//        task.setDescription("new description");
//        personJPARepository.createTask(task);
//        System.out.println(personJPARepository.getTasksWithLimitAndOffset(10, 0));
//        System.out.println(personJPARepository.getAllCount());

//        personJPARepository.createTask(task);
//        personJPARepository.createTask("Lol",Status.IN_PROGRESS);
       // System.out.println(personJPARepository.getTasksWithLimitAndOffset(5,0));



//    }
//}