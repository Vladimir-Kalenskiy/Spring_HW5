package ru.kalenskiy.homework5.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import ru.kalenskiy.homework5.model.impl.TaskStatus;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @CreationTimestamp
    private LocalDateTime dateOfCreation;

}
