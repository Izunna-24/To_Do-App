package africa.todo.dataTransferObjects.responses;

import africa.todo.data.models.Task;
import lombok.Data;

@Data
public class ViewAllTaskResponse {
    private String taskId;
    private Task task;
}
