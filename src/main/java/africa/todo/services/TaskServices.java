package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewAllTaskRequest;
import africa.todo.dataTransferObjects.responses.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskServices {
    CreateTaskResponse createTask(CreateTaskRequest createTaskRequest);
    ViewAllTaskResponse viewAllTask(ViewAllTaskRequest viewAllTaskRequest);
    DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest);
    EditTaskResponse editTask(EditTaskRequest editTaskRequest);
    //Task findTaskByUser(User user);
    List<Task> findAllTask();
    Task findByName(String title);
    Task findTaskById(String id);
    AssignTaskResponse assignTask(CreateTaskResponse task, User assignee,
                                  User assigner, CreateTaskRequest createTaskRequest);


}
