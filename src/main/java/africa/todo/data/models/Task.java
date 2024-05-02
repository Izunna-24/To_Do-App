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
    private String userId;
    private Status status = Status.PENDING;
    private Category category;
    @Id
    private String taskId;
    private String content;
    private Priority priority;
    private LocalDateTime taskDateTime = LocalDateTime.now();
    private LocalDateTime dateEdited = LocalDateTime.now();
}
