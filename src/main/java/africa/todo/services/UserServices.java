package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.dataTransferObjects.requests.*;
import africa.todo.dataTransferObjects.responses.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserServices {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    //CreateTaskResponse setTask(CreateTaskRequest createTaskRequest);
    EditTaskResponse editTask(EditTaskRequest editTaskRequest);
    DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest);
    List<Task> findTaskByName(String taskName);
    GetTaskResponse getTask(GetTaskRequest getTaskRequest);

}
