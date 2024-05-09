package africa.todo.dataTransferObjects.responses;

import africa.todo.data.models.Status;
import lombok.Data;

@Data

public class EditTaskResponse {
    private String taskId;
    private String taskName;
    //private String  dateEdited;
    private String taskDateTime;
}
