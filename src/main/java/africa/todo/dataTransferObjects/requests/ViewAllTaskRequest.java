package africa.todo.dataTransferObjects.requests;

import lombok.Data;

@Data
public class ViewAllTaskRequest {
    private String id;
    private String taskName;
}
