package africa.todo.dataTransferObjects.requests;

import lombok.Data;

@Data

public class DeleteTaskRequest {
    private String userId;
    private String taskId;
}
