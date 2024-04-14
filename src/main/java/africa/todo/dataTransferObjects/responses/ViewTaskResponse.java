package africa.todo.dataTransferObjects.responses;

import africa.todo.data.models.Task;
import lombok.Data;

@Data
public class ViewTaskResponse {
    private Task task;
    private String taskId;
//    private String userId;
}
