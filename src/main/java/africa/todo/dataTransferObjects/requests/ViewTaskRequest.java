package africa.todo.dataTransferObjects.requests;

import lombok.Data;

@Data
public class ViewTaskRequest {
    private String id;
    private String taskName;
}
