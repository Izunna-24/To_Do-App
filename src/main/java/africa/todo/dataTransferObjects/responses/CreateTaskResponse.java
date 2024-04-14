package africa.todo.dataTransferObjects.responses;

import lombok.Data;

@Data
public class CreateTaskResponse {
    private String taskId;
    private String taskName;
}
