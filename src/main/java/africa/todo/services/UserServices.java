package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.CreateTaskResponse;
import africa.todo.dataTransferObjects.responses.DeleteTaskResponse;
import africa.todo.dataTransferObjects.responses.EditTaskResponse;
import africa.todo.dataTransferObjects.responses.RegisterResponse;

import java.util.List;

public interface UserServices {
    RegisterResponse register(RegisterRequest registerRequest);
    CreateTaskResponse createTask(CreateTaskRequest createTaskRequest);
    EditTaskResponse editTask(EditTaskRequest editTaskRequest);
    DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest);
    List<Task> findTaskByName(String taskName);

}
