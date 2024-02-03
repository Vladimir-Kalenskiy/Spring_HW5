package ru.kalenskiy.homework5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kalenskiy.homework5.model.Task;
import ru.kalenskiy.homework5.model.impl.TaskStatus;
import ru.kalenskiy.homework5.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    public void addTask(@RequestBody Task task){
        service.addTask(task);
    }

    @GetMapping("/")
    public List<Task> getAllTasks(){
        return service.getAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.getTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTaskStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
