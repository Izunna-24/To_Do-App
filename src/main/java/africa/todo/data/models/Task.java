package africa.todo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDateTime taskDateTime;
    private LocalDateTime dateEdited;
    @DBRef
    private List<Reminder> reminders = new ArrayList<>();
}
