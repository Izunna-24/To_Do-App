package africa.todo.utilities;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        task.setDueDate(LocalDateTime.now().plusDays(createTaskRequest.getDueDate()));
        task.setCategory(createTaskRequest.getCategory());
        task.setPriority(createTaskRequest.getPriority());
        return task;
    }

    public static CreateTaskResponse taskCreatedResponse(Task task) {
        CreateTaskResponse createTaskResponse = new CreateTaskResponse();
       // createTaskResponse.setTaskId(task.getId());
        createTaskResponse.setTaskName(task.getTaskName());
        return createTaskResponse;
    }

    public static DeleteTaskResponse deleteTaskResponse(Task task) {
        DeleteTaskResponse deleteTaskResponse = new DeleteTaskResponse();
        deleteTaskResponse.setTaskId(task.getId());
        deleteTaskResponse.setTaskName(task.getTaskName());
        return deleteTaskResponse;

    }

    public static EditTaskResponse editTaskResponse(Task task) {
        EditTaskResponse editTaskResponse = new EditTaskResponse();
        editTaskResponse.setTaskId(task.getId());
        editTaskResponse.setTaskName(task.getTaskName());
        editTaskResponse.setDateEdited(task.getDateEdited());
        editTaskResponse.setDateCreated(task.getTaskDateTime());
        return editTaskResponse;
    }

    public static GetTaskResponse getTaskResponse(Task task) {
        GetTaskResponse getTaskResponse = new GetTaskResponse();
        getTaskResponse.setStatus(task.getStatus());
        getTaskResponse.setPriority(task.getPriority());
        getTaskResponse.setCategory(task.getCategory());
        return getTaskResponse;
    }

    public static Task editTaskMap(EditTaskRequest editTaskRequest, Task task) {
        task.setTaskName(editTaskRequest.getTaskName());
        task.setContent(editTaskRequest.getContent());
        task.setDueDate(LocalDateTime.now().plusDays(editTaskRequest.getDueDate()));
        task.setCategory(editTaskRequest.getCategory());
        task.setPriority(editTaskRequest.getPriority());
        task.setDateEdited(LocalDateTime.now());
        return task;
    }

    public static ViewTaskResponse viewTaskResponse(Task task) {
        ViewTaskResponse viewTaskResponse = new ViewTaskResponse();
        viewTaskResponse.setTaskId(task.getId());
        viewTaskResponse.setTask(task);
        return viewTaskResponse;
    }
}