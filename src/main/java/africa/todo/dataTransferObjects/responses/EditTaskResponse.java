package africa.todo.dataTransferObjects.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class EditTaskResponse {
    private String taskId;
    private String taskName;
    private LocalDateTime dateEdited;
    private LocalDateTime dateCreated;
}
