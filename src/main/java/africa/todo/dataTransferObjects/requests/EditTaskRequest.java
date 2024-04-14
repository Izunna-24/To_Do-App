package africa.todo.dataTransferObjects.requests;

import africa.todo.data.models.Category;
import africa.todo.data.models.Priority;
import africa.todo.data.models.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class EditTaskRequest {
    public String id;
    private String taskName;
    private Status status = Status.PENDING;
    private String content;
    private LocalDateTime timeEdited;
    private LocalDateTime taskDateTime;
    private Category category;
    private Priority priority;
}

