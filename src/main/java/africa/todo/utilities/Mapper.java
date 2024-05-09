package africa.todo.utilities;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.*;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Mapper {
    public static User regMap(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static RegisterResponse regResponseMap(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUserId(user.getUserId());
        registerResponse.setUsername(user.getUsername());
        return registerResponse;
    }

    public static Task createTaskMap(CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTaskName(createTaskRequest.getTaskName());
        task.setContent(createTaskRequest.getContent());

        LocalDateTime parsedDateTime = LocalDateTime.parse(createTaskRequest.getTaskDateTime(),
                ofPattern("dd/MM/yyyy HH:mm"));
        task.setTaskDateTime(parsedDateTime);
        task.setCategory(createTaskRequest.getCategory());
        task.setPriority(createTaskRequest.getPriority());
        task.setUserId(createTaskRequest.getUserId());
            return task;
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
        editTaskResponse.setTaskDateTime(ofPattern("dd/MM/yyyy hh:mm a").format(task.getTaskDateTime()));
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
        LocalDateTime parsedDateTime = LocalDateTime.parse(editTaskRequest.getTaskDateTime(),
                ofPattern("dd/MM/yyyy HH:mm"));
        task.setTaskDateTime(parsedDateTime);
        task.setCategory(editTaskRequest.getCategory());
        task.setPriority(editTaskRequest.getPriority());
        task.setUserId(editTaskRequest.getUserId());
        task.setTaskId(editTaskRequest.getTaskId());
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
    loginResponse.setLoggedIn(user.isLogin());
    return loginResponse;
    }

    public static CreateTaskResponse createTaskResponse(Task task){
        CreateTaskResponse createTaskResponse = new CreateTaskResponse();
       createTaskResponse.setTaskName(task.getTaskName());
       createTaskResponse.setTaskStatus(task.getStatus());
       createTaskResponse.setTaskId(task.getTaskId());
        createTaskResponse.setTaskDateTime(ofPattern("dd/MM/yyyy hh:mm a").format(task.getTaskDateTime()));


        //createTaskResponse.setTask(task);
        return createTaskResponse;
    }

    public static AssignTaskResponse assignTaskResponse(Task task, User user,String message){
        AssignTaskResponse assignTaskResponse = new AssignTaskResponse();
        assignTaskResponse.setAssignedTaskDateTime(ofPattern("dd/MM/yyyy hh:mm a").format(task.getTaskDateTime()));
        assignTaskResponse.setAssignerName(user.getUsername());
        assignTaskResponse.setAssigneeName(user.getUsername());
        assignTaskResponse.setMessage(message);
        assignTaskResponse.setAssignedTaskName(task.getTaskName());
        return assignTaskResponse;
    }
}