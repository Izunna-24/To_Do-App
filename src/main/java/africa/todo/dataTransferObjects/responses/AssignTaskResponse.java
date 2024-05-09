package africa.todo.dataTransferObjects.responses;

import lombok.Data;

@Data
public class AssignTaskResponse {
    private String assignerName;
    private String assignedTaskName;
    private String assigneeName;
    private String assignedTaskDateTime;
    private String message;
}
