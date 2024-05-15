package africa.todo.dataTransferObjects.requests;

import lombok.Data;

@Data
public class AssignTaskRequest {
    private String taskId;
    private String assignerUsername;
    private String assigneeUsername;
}
