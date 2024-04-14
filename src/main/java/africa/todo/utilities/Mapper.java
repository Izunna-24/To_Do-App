package africa.todo.utilities;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.CreateTaskResponse;
import africa.todo.dataTransferObjects.responses.RegisterResponse;

import java.time.LocalDateTime;

public class Mapper {
    public static User regMap(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static RegisterResponse regResponseMap(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUserId(user.getId());
        registerResponse.setUsername(user.getUsername());
        return registerResponse;
    }

    public static Task createTaskMap(CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTaskName(createTaskRequest.getTaskName());
        task.setContent(createTaskRequest.getContent());
        task.setTaskDateTime(LocalDateTime.now());
        return task;
    }

    public static CreateTaskResponse taskCreatedResponse(Task task) {
        CreateTaskResponse createTaskResponse = new CreateTaskResponse();
        createTaskResponse.setTaskId(task.getId());
        createTaskResponse.setTaskName(task.getTaskName());
        return createTaskResponse;
    }
}