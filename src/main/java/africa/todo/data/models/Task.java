package africa.todo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document("Tasks")
public class Task {
    private String taskName;
    private TaskStatus taskStatus;
    private TaskCategory taskCategory;
    @Id
    private String id;
    private String content;
    private LocalDateTime taskDateTime;
}
