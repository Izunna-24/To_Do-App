package africa.todo.dataTransferObjects.requests;

import africa.todo.data.models.Category;
import africa.todo.data.models.Priority;
import africa.todo.data.models.Status;
import lombok.Data;

@Data
public class EditTaskRequest {
    public String taskId;
    private String taskName;
    private Status status = Status.PENDING;
    private String content;
    //private LocalDateTime timeEdited;
    private String taskDateTime;
    private Category category;
    private Priority priority;
    private String userId;

}

