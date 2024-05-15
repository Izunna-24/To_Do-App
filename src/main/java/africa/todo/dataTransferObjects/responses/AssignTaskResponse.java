package africa.todo.dataTransferObjects.responses;

import africa.todo.data.models.Status;
import lombok.Data;

@Data
public class AssignTaskResponse {
    private String assignerName;
    private String assignedTaskName;
    private String assigneeName;
    private String assignedTaskDateTime;
    private Status assignedTaskStatus = Status.PENDING;
}
