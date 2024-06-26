package africa.todo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document("Reminder")
public class Reminder {
    private String reminderTime;
    private String nameOfTask;
    @Id
    private String reminderId;
    private Priority priority;
    private String reminderMessage;
}
