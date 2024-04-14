package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewTaskRequest;
import africa.todo.dataTransferObjects.responses.DeleteTaskResponse;
import africa.todo.dataTransferObjects.responses.EditTaskResponse;
import africa.todo.dataTransferObjects.responses.ViewTaskResponse;

import java.util.List;

public interface TaskServices {
    Task createTask(CreateTaskRequest createTaskRequest);
    ViewTaskResponse viewTask(ViewTaskRequest viewTaskRequest);
    DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest);
    EditTaskResponse editTask(EditTaskRequest editTaskRequest);
    //Task findTaskByUser(User user);
    List<Task> findAllTask();
    Task findByName(String title);
    Task findById(String id);
}
