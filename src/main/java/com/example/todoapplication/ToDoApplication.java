package com.example.todoapplication;

import com.example.todoapplication.dto.NewTaskDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ToDoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ToDoApplication.class, args);
        TaskService taskService = context.getBean(TaskService.class);
//        do użycia w profilu normalnym
//        populateTestData(taskService);

//        do użycia w profilu dev
        TestDataPopulator testDataPopulator = new TestDataPopulator(taskService);
        TaskController taskController = context.getBean(TaskController.class);
        taskController.loop();
    }

    @Bean
    Scanner Scanner(){
        return new Scanner(System.in);
    }

//    do użycia w profilu mormalym
//    private static void populateTestData(TaskService taskService) {
//        taskService.saveTask(new NewTaskDto("Nauka Springa", "Nauczyć się obsługiwać bazy danych w Springu", 90));
//        taskService.saveTask(new NewTaskDto("Poprawić budżet domowy", "Sprawdzić arkusz, który błędnie liczy budżet domowy", 50));
//        taskService.saveTask(new NewTaskDto("Auto do mechanika", "Umówić i zawieźć auto do mechanika na przegląd", 80));
//        taskService.saveTask(new NewTaskDto("Zaplanować wakacje", "Wyszukać i zaklepać wakacje w biurze podróży", 70));
//        taskService.saveTask(new NewTaskDto("Kupić farbę", "Kupić białą farbę do odmalowania mieszkania", 30));
//        taskService.startTask(1L);
//        taskService.completeTask(1L);
//        taskService.startTask(3L);
//        taskService.completeTask(3L);
//    }
}
