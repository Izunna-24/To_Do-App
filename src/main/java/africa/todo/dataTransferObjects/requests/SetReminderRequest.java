package africa.todo.dataTransferObjects.requests;

import africa.todo.data.models.Priority;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SetReminderRequest {
    private String nameOfTask;
    private LocalDateTime reminderTime;
    private String taskId;
    private String userId;
    private String message;
    private Priority priority;
}
