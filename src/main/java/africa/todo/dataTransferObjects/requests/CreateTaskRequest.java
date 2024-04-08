package africa.todo.dataTransferObjects.requests;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CreateTaskRequest {
    private String taskName;
    private String id;
    private String content;
    private LocalDateTime taskDateTime;
}
