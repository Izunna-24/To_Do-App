package africa.todo.dataTransferObjects.requests;

import lombok.Data;

@Data
public class GetTaskRequest {
    private String userId;
    private String taskId;
}
