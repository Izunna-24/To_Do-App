package africa.todo.dataTransferObjects.responses;

import africa.todo.data.models.Task;
import lombok.Data;

@Data
public class ViewTaskResponse {
    private Task task;
}
