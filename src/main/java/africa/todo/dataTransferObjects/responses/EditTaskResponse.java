package africa.todo.dataTransferObjects.responses;

import lombok.Data;

@Data

public class EditTaskResponse {
    private String taskId;
    private String taskName;
}
