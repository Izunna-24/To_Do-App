package africa.todo.dataTransferObjects.responses;

import africa.todo.data.models.Status;
import africa.todo.data.models.Task;
import lombok.Data;

@Data
public class CreateTaskResponse {
//    private String taskName;
//    private Status taskStatus;
//    private String taskId;
    private String taskDateTime;
    private Task task;
}
