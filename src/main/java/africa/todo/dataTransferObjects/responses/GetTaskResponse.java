package africa.todo.dataTransferObjects.responses;

import africa.todo.data.models.Category;
import africa.todo.data.models.Priority;
import africa.todo.data.models.Status;
import lombok.Data;

@Data
public class GetTaskResponse {
    private Status status;
    private Category category;
    private Priority priority;
}
