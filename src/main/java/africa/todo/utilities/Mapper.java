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
        String formattedDateTime = createTaskRequest.getTaskDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        task.setTaskDateTime(parsedDateTime);
        task.setCategory(createTaskRequest.getCategory());
        task.setPriority(createTaskRequest.getPriority());
        task.setUserId(createTaskRequest.getUserId());
            return task;
        }



    public static CreateTaskResponse taskCreatedResponse(Task task) {
        CreateTaskResponse createTaskResponse = new CreateTaskResponse();
       createTaskResponse.setTaskId(task.getTaskId());
       createTaskResponse.setTaskStatus(task.getStatus());
        createTaskResponse.setTaskName(task.getTaskName());
        return createTaskResponse;
    }

    public static DeleteTaskResponse deleteTaskResponse(Task task) {
        DeleteTaskResponse deleteTaskResponse = new DeleteTaskResponse();
        deleteTaskResponse.setTaskId(task.getTaskId());
        deleteTaskResponse.setTaskName(task.getTaskName());
        return deleteTaskResponse;

    }

    public static EditTaskResponse editTaskResponse(Task task) {
        EditTaskResponse editTaskResponse = new EditTaskResponse();
        editTaskResponse.setTaskId(task.getTaskId());
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
        task.setTaskDateTime(LocalDateTime.now().plusDays(editTaskRequest.getDueDate()));
        task.setCategory(editTaskRequest.getCategory());
        task.setPriority(editTaskRequest.getPriority());
        task.setDateEdited(LocalDateTime.now());
        return task;
    }

    public static ViewAllTaskResponse viewTaskResponse(Task task) {
        ViewAllTaskResponse viewAllTaskResponse = new ViewAllTaskResponse();
        viewAllTaskResponse.setTaskId(task.getTaskId());
        viewAllTaskResponse.setTask(task);
        return viewAllTaskResponse;
    }

    public static LoginResponse loginResponse(User user){
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setUsername(user.getUsername());
    loginResponse.setLocked(user.isLocked());
    return loginResponse;
    }
}