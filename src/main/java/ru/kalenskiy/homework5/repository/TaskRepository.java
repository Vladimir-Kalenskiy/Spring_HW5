package ru.kalenskiy.homework5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kalenskiy.homework5.model.Task;
import ru.kalenskiy.homework5.model.impl.TaskStatus;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByTaskStatus(TaskStatus status);

}
