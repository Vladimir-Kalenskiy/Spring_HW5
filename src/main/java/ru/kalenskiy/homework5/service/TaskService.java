package ru.kalenskiy.homework5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kalenskiy.homework5.model.Task;
import ru.kalenskiy.homework5.model.impl.TaskStatus;
import ru.kalenskiy.homework5.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public void addTask(Task task){
        repository.save(task);
    }

    public List<Task> getAllTask(){
        return repository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus taskStatus){
        return repository.findAllByTaskStatus(taskStatus);
    }

    public Task updateTaskStatus(Long id, Task taskDetails){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskStatus(taskDetails.getTaskStatus());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
