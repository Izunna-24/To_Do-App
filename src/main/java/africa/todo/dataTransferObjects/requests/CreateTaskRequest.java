package africa.todo.dataTransferObjects.requests;

import africa.todo.data.models.Category;
import africa.todo.data.models.Priority;
import africa.todo.data.models.Status;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CreateTaskRequest {
    private String userId;
    private String taskName;
    private String content;
    private LocalDateTime taskDateTime;
    private Category category;
    private Priority priority;
    private  Status status;
}


