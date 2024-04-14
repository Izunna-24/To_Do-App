package africa.todo.dataTransferObjects.responses;

import lombok.Data;
@Data
public class DeleteTaskResponse {

    private String taskId;
    private String taskName;
}
