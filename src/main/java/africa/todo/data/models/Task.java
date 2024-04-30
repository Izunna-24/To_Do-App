package africa.todo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Document("Tasks")
public class Task {
    private String taskName;
    private Status status = Status.PENDING;
    private Category category;
    @Id
    private String id;
    private String content;
    private Priority priority;
    private LocalDateTime taskDateTime = LocalDateTime.now();
    private LocalDateTime dueDate;
    private LocalDateTime dateEdited;
}
